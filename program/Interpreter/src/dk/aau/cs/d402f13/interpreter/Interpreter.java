package dk.aau.cs.d402f13.interpreter;

import dk.aau.cs.d402f13.utilities.ast.AstNode;
import dk.aau.cs.d402f13.utilities.ast.AstNode.Type;
import dk.aau.cs.d402f13.utilities.ast.Visitor;
import dk.aau.cs.d402f13.utilities.errors.ArgumentError;
import dk.aau.cs.d402f13.utilities.errors.LegalValueError;
import dk.aau.cs.d402f13.utilities.errors.StandardError;
import dk.aau.cs.d402f13.utilities.errors.TypeError;
import dk.aau.cs.d402f13.values.BoolValue;
import dk.aau.cs.d402f13.values.CoordValue;
import dk.aau.cs.d402f13.values.DirValue;
import dk.aau.cs.d402f13.values.FunValue;
import dk.aau.cs.d402f13.values.IntValue;
import dk.aau.cs.d402f13.values.ListValue;
import dk.aau.cs.d402f13.values.PatternValue;
import dk.aau.cs.d402f13.values.StrValue;
import dk.aau.cs.d402f13.values.Value;

public class Interpreter extends Visitor {
  private SymbolTable symbolTable = new SymbolTable();

  public Interpreter(AstNode root) throws StandardError {
    visit(root);
    FunValue fun = new FunValue(
      2, false,
      new Callable() {
        @Override
        public Value call(Interpreter interpreter, Value... actualParameters)
            throws StandardError {
          if (!(actualParameters[0] instanceof IntValue
              && actualParameters[1] instanceof IntValue)) {
            throw new ArgumentError("Invalid arguments, expected two integers");
          }
          int a = ((IntValue)actualParameters[0]).getValue();
          int b = ((IntValue)actualParameters[1]).getValue();
          return new IntValue(a + b);
        }
      }
    );
    symbolTable.addFunction("add", fun);
  }
  
  public SymbolTable getSymbolTable() {
    return symbolTable;
  }
  
  @Override
  public Value visit(AstNode node) throws StandardError {
    if(node.type == Type.GAME_DECL || node.type == Type.FUNC_DEF)
      return (Value)super.visit(node);
    throw new LegalValueError("Root node has to be a game declaration or a function definition", node);
  }

  @Override
  protected Value visitAssignment(AstNode node) throws StandardError {
    symbolTable.openScope();
    String var = node.get(0).value;
    Value val = visit(node.get(1));
    symbolTable.addVariable(var, val);
    for (int i = 2; i < node.size() -1; i++) {
      AstNode assign = node.get(i);
      var = assign.get(0).value;
      val = visit(assign.get(1));
      symbolTable.addVariable(var, val);
    }
    Value ret = visit(node.get(node.size() - 1));
    symbolTable.closeScope();
    return ret;
  }

  @Override
  protected CoordValue visitCoordLit(AstNode node) throws StandardError {
    if(node.value != null && node.type == Type.COORD_LIT)
      return new CoordValue(node.value);
    
    throw new LegalValueError("Coordinate does not have a value or is not of correct type", node);
  }

  @Override
  protected Value visitDecl(AstNode node) throws StandardError {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  protected Value visitDeclStruct(AstNode node) throws StandardError {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  protected Value visitDirLit(AstNode node) throws StandardError {
      return new DirValue(node.value);
  }

  @Override
  protected Value visitFunction(AstNode node) throws StandardError {
    return symbolTable.getFunction(node.value);
  }

  @Override
  protected Value visitFuncCall(AstNode node) throws StandardError {
    Value v = visit(node.get(0));
    
    if(v instanceof FunValue) {
      ListValue list = (ListValue)visit(node.get(1));
      
      return ((FunValue)v).call(this, list.getValues());
    }
    else if(v instanceof ListValue) {
      
    }
    else
      throw new TypeError("Must be function or list value", node.get(0));
    
    
    return null;
  }

  @Override
  protected Value visitFuncDef(AstNode node) throws StandardError {
    symbolTable.addFunction(node.get(0).value, new FunValue(node.get(1), node.get(2)));
    
    return null;
  }

  @Override
  protected Value visitGameDecl(AstNode node) throws StandardError {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  protected Value visitId(AstNode node) throws StandardError {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  protected Value visitIfExpr(AstNode node) throws StandardError {
    Value b = visit(node.get(0));
    
    if (!(b instanceof BoolValue)) {
     throw new TypeError("Not a boolean", node.get(0)); 
    }
    
    if(b == BoolValue.trueValue())
      return visit(node.get(1));

    
    return visit(node.get(2));    
  }

  @Override
  protected IntValue visitIntLit(AstNode node) throws StandardError {
    if(node.value != null && node.type == Type.INT_LIT) {
      return new IntValue(node.value);
    }
    else {
      throw new StandardError("Integer value must not be null and of type int", node);
    }
  }

  @Override
  protected Value visitKeyword(AstNode node) throws StandardError {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  protected Value visitLambdaExpr(AstNode node) throws StandardError {
    
  }

  @Override
  protected Value visitList(AstNode node) throws StandardError {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  protected Value visitNotOperator(AstNode node) throws StandardError {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  protected Value visitOperator(AstNode node) throws StandardError {
    
    return null;
  }

  @Override
  protected Value visitPattern(AstNode node) throws StandardError {
      for(AstNode child : node) {
        visit(child);
    }
    
    return null;
  }

  @Override
  protected Value visitPatternKeyword(AstNode node) throws StandardError {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  protected Value visitPatternMultiplier(AstNode node) throws StandardError {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  protected Value visitPatternNot(AstNode node) throws StandardError {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  protected Value visitPatternOperator(AstNode node) throws StandardError {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  protected Value visitPatternOr(AstNode node) throws StandardError {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  protected Value visitProgram(AstNode node) throws StandardError {
    if(node.value != null && node.type == Type.PROGRAM) {
      for(AstNode child : node) {
        if(child.type == Type.FUNC_DEF) {
          visit(child);
        }
        else if(child.type == Type.GAME_DECL) {
          visit(child);
          break;
        }
        else {
          throw new StandardError("Node is not of type function def or game decl", node);
        }
      }
    }
    return null;
  }

  @Override
  protected StrValue visitStringLit(AstNode node) throws StandardError {
    if(node.value != null && node.type == Type.STRING_LIT) {
      return new StrValue(node.value);
    }
    else {
      throw new StandardError("String literals cannot be null and have to be of type string", node);
    }
  }

  @Override
  protected Value visitThis(AstNode node) throws StandardError {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  protected Value visitVar(AstNode node) throws StandardError {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  protected Value visitVarlist(AstNode node) throws StandardError {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  protected Object visitVars(AstNode node) throws StandardError {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  protected Object visitNegation(AstNode node) throws StandardError {
    // TODO Auto-generated method stub
    return null;
  }

}
