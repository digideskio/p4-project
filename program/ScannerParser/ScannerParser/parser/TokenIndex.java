/* This file was generated by SableCC (http://www.sablecc.org/). */

package ScannerParser.parser;

import ScannerParser.node.*;
import ScannerParser.analysis.*;

class TokenIndex extends AnalysisAdapter
{
    int index;

    @Override
    public void caseTDecimal(@SuppressWarnings("unused") TDecimal node)
    {
        this.index = 0;
    }

    @Override
    public void caseTLowercase(@SuppressWarnings("unused") TLowercase node)
    {
        this.index = 1;
    }

    @Override
    public void caseTUppercase(@SuppressWarnings("unused") TUppercase node)
    {
        this.index = 2;
    }

    @Override
    public void caseTAnycase(@SuppressWarnings("unused") TAnycase node)
    {
        this.index = 3;
    }

    @Override
    public void caseTQuotebs(@SuppressWarnings("unused") TQuotebs node)
    {
        this.index = 4;
    }

    @Override
    public void caseTUnichar(@SuppressWarnings("unused") TUnichar node)
    {
        this.index = 5;
    }

    @Override
    public void caseTStrchar(@SuppressWarnings("unused") TStrchar node)
    {
        this.index = 6;
    }

    @Override
    public void caseTKeyword(@SuppressWarnings("unused") TKeyword node)
    {
        this.index = 7;
    }

    @Override
    public void caseTOperator(@SuppressWarnings("unused") TOperator node)
    {
        this.index = 8;
    }

    @Override
    public void caseTPatternKeyword(@SuppressWarnings("unused") TPatternKeyword node)
    {
        this.index = 9;
    }

    @Override
    public void caseTPatternOperator(@SuppressWarnings("unused") TPatternOperator node)
    {
        this.index = 10;
    }

    @Override
    public void caseTDirection(@SuppressWarnings("unused") TDirection node)
    {
        this.index = 11;
    }

    @Override
    public void caseTStarQmarkPlus(@SuppressWarnings("unused") TStarQmarkPlus node)
    {
        this.index = 12;
    }

    @Override
    public void caseTInteger(@SuppressWarnings("unused") TInteger node)
    {
        this.index = 13;
    }

    @Override
    public void caseTCoordinate(@SuppressWarnings("unused") TCoordinate node)
    {
        this.index = 14;
    }

    @Override
    public void caseTString(@SuppressWarnings("unused") TString node)
    {
        this.index = 15;
    }

    @Override
    public void caseTFunction(@SuppressWarnings("unused") TFunction node)
    {
        this.index = 16;
    }

    @Override
    public void caseTIdentifier(@SuppressWarnings("unused") TIdentifier node)
    {
        this.index = 17;
    }

    @Override
    public void caseTVariable(@SuppressWarnings("unused") TVariable node)
    {
        this.index = 18;
    }

    @Override
    public void caseTDefine(@SuppressWarnings("unused") TDefine node)
    {
        this.index = 19;
    }

    @Override
    public void caseTGame(@SuppressWarnings("unused") TGame node)
    {
        this.index = 20;
    }

    @Override
    public void caseTLBkt(@SuppressWarnings("unused") TLBkt node)
    {
        this.index = 21;
    }

    @Override
    public void caseTRBkt(@SuppressWarnings("unused") TRBkt node)
    {
        this.index = 22;
    }

    @Override
    public void caseTLBrc(@SuppressWarnings("unused") TLBrc node)
    {
        this.index = 23;
    }

    @Override
    public void caseTRBrc(@SuppressWarnings("unused") TRBrc node)
    {
        this.index = 24;
    }

    @Override
    public void caseTLPar(@SuppressWarnings("unused") TLPar node)
    {
        this.index = 25;
    }

    @Override
    public void caseTRPar(@SuppressWarnings("unused") TRPar node)
    {
        this.index = 26;
    }

    @Override
    public void caseTNot(@SuppressWarnings("unused") TNot node)
    {
        this.index = 27;
    }

    @Override
    public void caseTIf(@SuppressWarnings("unused") TIf node)
    {
        this.index = 28;
    }

    @Override
    public void caseTThen(@SuppressWarnings("unused") TThen node)
    {
        this.index = 29;
    }

    @Override
    public void caseTElse(@SuppressWarnings("unused") TElse node)
    {
        this.index = 30;
    }

    @Override
    public void caseTPound(@SuppressWarnings("unused") TPound node)
    {
        this.index = 31;
    }

    @Override
    public void caseTLArrow(@SuppressWarnings("unused") TLArrow node)
    {
        this.index = 32;
    }

    @Override
    public void caseTSlash(@SuppressWarnings("unused") TSlash node)
    {
        this.index = 33;
    }

    @Override
    public void caseTStar(@SuppressWarnings("unused") TStar node)
    {
        this.index = 34;
    }

    @Override
    public void caseTQMark(@SuppressWarnings("unused") TQMark node)
    {
        this.index = 35;
    }

    @Override
    public void caseTPlus(@SuppressWarnings("unused") TPlus node)
    {
        this.index = 36;
    }

    @Override
    public void caseTEmark(@SuppressWarnings("unused") TEmark node)
    {
        this.index = 37;
    }

    @Override
    public void caseTFriend(@SuppressWarnings("unused") TFriend node)
    {
        this.index = 38;
    }

    @Override
    public void caseTFoe(@SuppressWarnings("unused") TFoe node)
    {
        this.index = 39;
    }

    @Override
    public void caseTEmpty(@SuppressWarnings("unused") TEmpty node)
    {
        this.index = 40;
    }

    @Override
    public void caseTThis(@SuppressWarnings("unused") TThis node)
    {
        this.index = 41;
    }

    @Override
    public void caseEOF(@SuppressWarnings("unused") EOF node)
    {
        this.index = 42;
    }
}
