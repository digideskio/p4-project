/* This file was generated by SableCC (http://www.sablecc.org/). */

package dk.aau.cs.d402f13.ScannerParser.node;

import dk.aau.cs.d402f13.ScannerParser.analysis.*;

@SuppressWarnings("nls")
public final class APatcheckPatternVal extends PPatternVal
{
    private PPatternCheck _patternCheck_;

    public APatcheckPatternVal()
    {
        // Constructor
    }

    public APatcheckPatternVal(
        @SuppressWarnings("hiding") PPatternCheck _patternCheck_)
    {
        // Constructor
        setPatternCheck(_patternCheck_);

    }

    @Override
    public Object clone()
    {
        return new APatcheckPatternVal(
            cloneNode(this._patternCheck_));
    }

    @Override
    public void apply(Switch sw)
    {
        ((Analysis) sw).caseAPatcheckPatternVal(this);
    }

    public PPatternCheck getPatternCheck()
    {
        return this._patternCheck_;
    }

    public void setPatternCheck(PPatternCheck node)
    {
        if(this._patternCheck_ != null)
        {
            this._patternCheck_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._patternCheck_ = node;
    }

    @Override
    public String toString()
    {
        return ""
            + toString(this._patternCheck_);
    }

    @Override
    void removeChild(@SuppressWarnings("unused") Node child)
    {
        // Remove child
        if(this._patternCheck_ == child)
        {
            this._patternCheck_ = null;
            return;
        }

        throw new RuntimeException("Not a child.");
    }

    @Override
    void replaceChild(@SuppressWarnings("unused") Node oldChild, @SuppressWarnings("unused") Node newChild)
    {
        // Replace child
        if(this._patternCheck_ == oldChild)
        {
            setPatternCheck((PPatternCheck) newChild);
            return;
        }

        throw new RuntimeException("Not a child.");
    }
}
