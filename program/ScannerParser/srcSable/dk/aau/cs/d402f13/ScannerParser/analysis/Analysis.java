/* This file was generated by SableCC (http://www.sablecc.org/). */

package dk.aau.cs.d402f13.ScannerParser.analysis;

import dk.aau.cs.d402f13.ScannerParser.node.*;

public interface Analysis extends Switch
{
    Object getIn(Node node);
    void setIn(Node node, Object o);
    Object getOut(Node node);
    void setOut(Node node, Object o);

    void caseStart(Start node);
    void caseAProgram(AProgram node);
    void caseAFunctionDef(AFunctionDef node);
    void caseAGameDecl(AGameDecl node);
    void caseADeclStruct(ADeclStruct node);
    void caseAKeystrucDecl(AKeystrucDecl node);
    void caseAIdstrucDecl(AIdstrucDecl node);
    void caseADeclstrucStructure(ADeclstrucStructure node);
    void caseAExprStructure(AExprStructure node);
    void caseAElopexpExpression(AElopexpExpression node);
    void caseAAssignExpression(AAssignExpression node);
    void caseAIfExpression(AIfExpression node);
    void caseALambdaExpression(ALambdaExpression node);
    void caseAElExpression(AElExpression node);
    void caseANotExpression(ANotExpression node);
    void caseAExprElement(AExprElement node);
    void caseAVarElement(AVarElement node);
    void caseAListElement(AListElement node);
    void caseAPatElement(APatElement node);
    void caseAKeyElement(AKeyElement node);
    void caseADirElement(ADirElement node);
    void caseACorElement(ACorElement node);
    void caseAIntElement(AIntElement node);
    void caseAStrElement(AStrElement node);
    void caseAIdElement(AIdElement node);
    void caseAFuncElement(AFuncElement node);
    void caseAVarExpr(AVarExpr node);
    void caseAAssignment(AAssignment node);
    void caseAIfExpr(AIfExpr node);
    void caseALambdaExpr(ALambdaExpr node);
    void caseAList(AList node);
    void caseAPattern(APattern node);
    void caseAPatvalPatternExpr(APatvalPatternExpr node);
    void caseAPatvalexprPatternExpr(APatvalexprPatternExpr node);
    void caseADirPatternVal(ADirPatternVal node);
    void caseAVarPatternVal(AVarPatternVal node);
    void caseAPatcheckPatternVal(APatcheckPatternVal node);
    void caseAEmarkpatcheckPatternVal(AEmarkpatcheckPatternVal node);
    void caseALpatexprrPatternVal(ALpatexprrPatternVal node);
    void caseAFriendPatternCheck(AFriendPatternCheck node);
    void caseAFoePatternCheck(AFoePatternCheck node);
    void caseAEmptyPatternCheck(AEmptyPatternCheck node);
    void caseAThisPatternCheck(AThisPatternCheck node);
    void caseAIdPatternCheck(AIdPatternCheck node);

    void caseTComment(TComment node);
    void caseTInteger(TInteger node);
    void caseTEol(TEol node);
    void caseTBlank(TBlank node);
    void caseTDirection(TDirection node);
    void caseTKeyword(TKeyword node);
    void caseTSharedOperator(TSharedOperator node);
    void caseTNormalOperator(TNormalOperator node);
    void caseTPatternOperator(TPatternOperator node);
    void caseTPatternOr(TPatternOr node);
    void caseTPatternNot(TPatternNot node);
    void caseTFriend(TFriend node);
    void caseTFoe(TFoe node);
    void caseTEmpty(TEmpty node);
    void caseTDefine(TDefine node);
    void caseTGame(TGame node);
    void caseTNot(TNot node);
    void caseTIf(TIf node);
    void caseTThen(TThen node);
    void caseTElse(TElse node);
    void caseTLet(TLet node);
    void caseTIn(TIn node);
    void caseTLBkt(TLBkt node);
    void caseTRBkt(TRBkt node);
    void caseTLBrc(TLBrc node);
    void caseTRBrc(TRBrc node);
    void caseTLPar(TLPar node);
    void caseTRPar(TRPar node);
    void caseTEql(TEql node);
    void caseTComma(TComma node);
    void caseTArrow(TArrow node);
    void caseTSlash(TSlash node);
    void caseTPound(TPound node);
    void caseTStar(TStar node);
    void caseTEmark(TEmark node);
    void caseTThis(TThis node);
    void caseTQmark(TQmark node);
    void caseTPlus(TPlus node);
    void caseTStarQmarkPlus(TStarQmarkPlus node);
    void caseTLowercase(TLowercase node);
    void caseTUppercase(TUppercase node);
    void caseTAnycase(TAnycase node);
    void caseTUnichar(TUnichar node);
    void caseTCoordinate(TCoordinate node);
    void caseTString(TString node);
    void caseTFunction(TFunction node);
    void caseTIdentifier(TIdentifier node);
    void caseTVariable(TVariable node);
    void caseTOperator(TOperator node);
    void caseEOF(EOF node);
    void caseInvalidToken(InvalidToken node);
}
