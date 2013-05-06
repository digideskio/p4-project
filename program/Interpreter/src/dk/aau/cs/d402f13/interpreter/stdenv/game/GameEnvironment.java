package dk.aau.cs.d402f13.interpreter.stdenv.game;

import java.util.Map.Entry;

import dk.aau.cs.d402f13.interpreter.AbstractMember;
import dk.aau.cs.d402f13.interpreter.Callable;
import dk.aau.cs.d402f13.interpreter.ConstantCallable;
import dk.aau.cs.d402f13.interpreter.Interpreter;
import dk.aau.cs.d402f13.interpreter.Member;
import dk.aau.cs.d402f13.interpreter.ParentCallable;
import dk.aau.cs.d402f13.interpreter.stdenv.StandardEnvironment;
import dk.aau.cs.d402f13.utilities.errors.StandardError;
import dk.aau.cs.d402f13.utilities.errors.TypeError;
import dk.aau.cs.d402f13.utilities.errors.ArgumentError;
import dk.aau.cs.d402f13.values.AbstractTypeValue;
import dk.aau.cs.d402f13.values.BoolValue;
import dk.aau.cs.d402f13.values.CoordValue;
import dk.aau.cs.d402f13.values.IntValue;
import dk.aau.cs.d402f13.values.ListValue;
import dk.aau.cs.d402f13.values.ObjectValue;
import dk.aau.cs.d402f13.values.PatternValue;
import dk.aau.cs.d402f13.values.TypeValue;
import dk.aau.cs.d402f13.values.Value;

public class GameEnvironment extends StandardEnvironment {

  private final AbstractTypeValue game = new AbstractTypeValue("Game", false, "title");
  private final TypeValue board = new TypeValue("Board", false);
  private final TypeValue square = new TypeValue("Square", false);
  private final TypeValue gridBoard = new TypeValue("GridBoard", board,
      new ParentCallable() {
        @Override
        public Value call(Interpreter interpreter) throws StandardError {
          return board.getInstance(interpreter);
        }
      }, false, "width", "height");
  private final TypeValue piece = new TypeValue("Piece", false, "owner");
  private final TypeValue player = new TypeValue("Player", false);
  
  private final AbstractTypeValue action = new AbstractTypeValue("Action", false);
  private final TypeValue actionSequence = new TypeValue("ActionSequence", action,
      new ParentCallable() {
        @Override
        public Value call(Interpreter interpreter) throws StandardError {
          return action.getInstance(interpreter);
        }
      }, true, "actions");
  private final AbstractTypeValue unitAction = new AbstractTypeValue("UnitAction", action,
      new ParentCallable() {
        @Override
        public Value call(Interpreter interpreter) throws StandardError {
          return action.getInstance(interpreter);
        }
      }, false, "piece");
  private final TypeValue addAction = new TypeValue("AddAction", unitAction,
      new ParentCallable() {
        @Override
        public Value call(Interpreter interpreter) throws StandardError {
          Value v = interpreter.getSymbolTable().getVariable("piece", piece);
          return v;
        }
      }, false, "piece", "to");
  private final TypeValue removeAction = new TypeValue("RemoveAction", unitAction,
      new ParentCallable() {
        @Override
        public Value call(Interpreter interpreter) throws StandardError {
          Value v = interpreter.getSymbolTable().getVariable("piece", piece);
          return v;
        }
      }, false, "piece", "from");
  private final TypeValue moveAction = new TypeValue("MoveAction", unitAction,
      new ParentCallable() {
        @Override
        public Value call(Interpreter interpreter) throws StandardError {
          Value v = interpreter.getSymbolTable().getVariable("piece", piece);
          return v;
        }
      }, false, "piece", "from", "to");
  
  public TypeValue gameType() {
    return game;
  }
  
  public TypeValue boardType() {
    return board;
  }
  
  public TypeValue squareType() {
    return square;
  }
  
  public TypeValue gridBoardType() {
    return gridBoard;
  }
  
  public TypeValue pieceType() {
    return piece;
  }
  
  public TypeValue playerType() {
    return player;
  }
  
  public TypeValue actionType() {
    return action;
  }
  
  public TypeValue actionSequenceType() {
    return actionSequence;
  }
  
  public TypeValue unitActionType() {
    return unitAction;
  }
  
  public TypeValue addActionType() {
    return addAction;
  }
  
  public TypeValue removeActionType() {
    return removeAction;
  }
  
  public TypeValue moveActionType() {
    return moveAction;
  }
  
  public GameEnvironment() {
    super();


    ////////////////////////////////////
    // type: Game
    ////////////////////////////////////
    addType(game);
    
    game.addAbstractMember("players", new AbstractMember());
    game.addAbstractMember("board", new AbstractMember());
    game.addAttribute("currentPlayer", new Member(new ConstantCallable() {
      @Override
      public Value call(Interpreter interpreter, Value object) throws StandardError {
        return new IntValue(0);
      }
    }));
    game.addAttribute("currentBoard", new Member(new ConstantCallable() {
      @Override
      public Value call(Interpreter interpreter, Value object) throws StandardError {
        return object.getMember("board", board);
      }
    }));
    game.addTypeMember("currentPlayer", new Member(new ConstantCallable() {
      @Override
      public Value call(Interpreter interpreter, Value object) throws StandardError {
        int i = ((ObjectValue)object).getAttributeInt("currentPlayer");
        Value[] players = object.getMemberList("turnOrder", player, 1);
        if (i >= players.length || i < 0) {
          throw new ArgumentError("Invalid player index:  + i");
        }
        return players[i];
      }
    }));
    game.addTypeMember("currentBoard", new Member(new ConstantCallable() {
      @Override
      public Value call(Interpreter interpreter, Value object) throws StandardError {
        return ((ObjectValue)object).getAttribute("currentBoard");
      }
    }));
    game.addTypeMember("turnOrder", new Member(new ConstantCallable() {
      @Override
      public Value call(Interpreter interpreter, Value object) throws StandardError {
        return object.getMember("players");
      }
    }));
    game.addTypeMember("title", new Member(new ConstantCallable() {
      @Override
      public Value call(Interpreter interpreter, Value object) throws StandardError {
        return interpreter.getSymbolTable().getVariable("title");
      }
    }));
    game.addTypeMember("findSquares", new Member(1, false, new Callable() {
      @Override
      public Value call(Interpreter interpreter, Value... actualParameters)
          throws StandardError {
        TypeValue.expect(actualParameters, 0, PatternValue.type());
        return new ListValue();
      }
    }));
    
    ////////////////////////////////////
    // type: Board
    ////////////////////////////////////
    addType(board);
    
    board.addTypeMember("squares", new Member(new ConstantCallable() {
      @Override
      public Value call(Interpreter interpreter, Value object) throws StandardError {
        return new ListValue();
      }
    }));
    board.addTypeMember("isFull", new Member(new ConstantCallable() {
      @Override
      public Value call(Interpreter interpreter, Value object) throws StandardError {
        return BoolValue.falseValue();
      }
    }));
    board.addTypeMember("emptySquares", new Member(new ConstantCallable() {
      @Override
      public Value call(Interpreter interpreter, Value object) throws StandardError {
        return object.getMember("squares");
      }
    }));
    
    ////////////////////////////////////
    // type: GridBoard
    ////////////////////////////////////
    addType(gridBoard);
    
    gridBoard.addAttribute("squares", new Member(new ConstantCallable() {
      @Override
      public Value call(Interpreter interpreter, Value object) throws StandardError {
        int width = interpreter.getSymbolTable().getVariableInt("width");
        int height = interpreter.getSymbolTable().getVariableInt("height");
        Value[] types = object.getMemberList("squareTypes", square, 1);
        int size = width * height;
        Value[] squares = new Value[size];
        int x = 0, y = 0, numTypes = types.length;
        for (int i = 0; i < size; i++) {
          squares[i] = types[(x + y) % numTypes];
          x++;
          if (x >= width) {
            x = 0;
            y++;
          }
        }
        return new ListValue(squares);
      }
    }));
    gridBoard.addTypeMember("squares", new Member(new ConstantCallable() {
      @Override
      public Value call(Interpreter interpreter, Value object) throws StandardError {
        return ((ObjectValue)object).getAttribute("squares");
      }
    }));
    gridBoard.addTypeMember("squareTypes", new Member(new ConstantCallable() {
      @Override
      public Value call(Interpreter interpreter, Value object) throws StandardError {
        return new ListValue(square.getInstance(interpreter));
      }
    }));
    
    ////////////////////////////////////
    // type: Piece
    ////////////////////////////////////
    addType(piece);
    
    piece.addTypeMember("player", new Member(new ConstantCallable() {
      @Override
      public Value call(Interpreter interpreter, Value object) throws StandardError {
        return interpreter.getSymbolTable().getVariable("owner");
      }
    }));
    piece.addAttribute("position", new Member(new ConstantCallable() {
      @Override
      public Value call(Interpreter interpreter, Value object) throws StandardError {
        return new CoordValue(1, 1);
      }
    }));
    piece.addTypeMember("position", new Member(new ConstantCallable() {
      @Override
      public Value call(Interpreter interpreter, Value object) throws StandardError {
        return ((ObjectValue)object).getAttribute("position");
      }
    }));
    piece.addAttribute("onBoard", new Member(new ConstantCallable() {
      @Override
      public Value call(Interpreter interpreter, Value object) throws StandardError {
        return BoolValue.falseValue();
      }
    }));
    piece.addTypeMember("onBoard", new Member(new ConstantCallable() {
      @Override
      public Value call(Interpreter interpreter, Value object) throws StandardError {
        return ((ObjectValue)object).getAttribute("onBoard");
      }
    }));
    piece.addTypeMember("move", new Member(1, false, new Callable() {
      @Override
      public Value call(Interpreter interpreter, Value... actualParameters) throws StandardError {
        TypeValue.expect(actualParameters, 0, CoordValue.type());
        ObjectValue object = (ObjectValue)interpreter.getSymbolTable().getThis();
        object.beginClone();
        object.setAttribute("position", actualParameters[0]);
        object.setAttribute("onBoard", BoolValue.trueValue());
        return object.endClone();
      }
    }));
    piece.addTypeMember("remove", new Member(0, false, new Callable() {
      @Override
      public Value call(Interpreter interpreter, Value... actualParameters) throws StandardError {
        ObjectValue object = (ObjectValue)interpreter.getSymbolTable().getThis();
        object.beginClone();
        object.setAttribute("onBoard", BoolValue.falseValue());
        return object.endClone();
      }
    }));
    
    ////////////////////////////////////
    // type: Player
    ////////////////////////////////////
    addType(player);
    
    player.addTypeMember("winCondition", new Member(1, false, new Callable() {
      @Override
      public Value call(Interpreter interpreter, Value... actualParameters)
          throws StandardError {
        return BoolValue.falseValue();
      }
    }));
    
    player.addTypeMember("tieCondition", new Member(1, false, new Callable() {
      @Override
      public Value call(Interpreter interpreter, Value... actualParameters)
          throws StandardError {
        return BoolValue.falseValue();
      }
    }));
    
    player.addTypeMember("actions", new Member(1, false, new Callable() {
      @Override
      public Value call(Interpreter interpreter, Value... actualParameters)
          throws StandardError {
        return new ListValue();
      }
    }));
    
    ////////////////////////////////////
    // type: Square
    ////////////////////////////////////
    addType(square);
    
    square.addAttribute("position", new Member(new ConstantCallable() {
      @Override
      public Value call(Interpreter interpreter, Value object) throws StandardError {
        return new CoordValue(1, 1);
      }
    }));
    square.addTypeMember("position", new Member(new ConstantCallable() {
      @Override
      public Value call(Interpreter interpreter, Value object) throws StandardError {
        return ((ObjectValue)object).getAttribute("position");
      }
    }));
    square.addTypeMember("setPosition", new Member(1, false, new Callable() {
      @Override
      public Value call(Interpreter interpreter, Value... actualParameters) throws StandardError {
        TypeValue.expect(actualParameters, 0, CoordValue.type());
        ObjectValue object = (ObjectValue)interpreter.getSymbolTable().getThis();
        object.beginClone();
        object.setAttribute("position", actualParameters[0]);
        return object.endClone();
      }
    }));
    
    ////////////////////////////////////
    // type: Action
    ////////////////////////////////////
    addType(action);
    

    ////////////////////////////////////
    // type: ActionSequence
    ////////////////////////////////////
    addType(actionSequence);

    
    ////////////////////////////////////
    // type: UnitAction
    ////////////////////////////////////
    addType(unitAction);

    
    ////////////////////////////////////
    // type: AddAction
    ////////////////////////////////////
    addType(addAction);

    
    ////////////////////////////////////
    // type: RemoveAction
    ////////////////////////////////////
    addType(removeAction);

    
    ////////////////////////////////////
    // type: MoveAction
    ////////////////////////////////////
    addType(moveAction);
  }
  
  /**
   * Find any type extending Game in the symbol table
   * @return The Game-type if it exists or null otherwise
   */
  public TypeValue findGameType() {
    for (Entry<String, TypeValue> e : types.entrySet()) {
      if (e.getValue().isSubtypeOf(game) && !(e.getValue() instanceof AbstractTypeValue)) {
        return e.getValue();
      }
    }
    return null;
  }

}
