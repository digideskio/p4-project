/* This file was generated by SableCC (http://www.sablecc.org/). */

package dk.aau.cs.d402f13.ScannerParser.node;

import dk.aau.cs.d402f13.ScannerParser.analysis.*;

@SuppressWarnings("nls")
public final class AEmptyPatternCheck extends PPatternCheck
{
    private TEmpty _empty_;

    public AEmptyPatternCheck()
    {
        // Constructor
    }

    public AEmptyPatternCheck(
        @SuppressWarnings("hiding") TEmpty _empty_)
    {
        // Constructor
        setEmpty(_empty_);

    }

    @Override
    public Object clone()
    {
        return new AEmptyPatternCheck(
            cloneNode(this._empty_));
    }

    @Override
    public void apply(Switch sw)
    {
        ((Analysis) sw).caseAEmptyPatternCheck(this);
    }

    public TEmpty getEmpty()
    {
        return this._empty_;
    }

    public void setEmpty(TEmpty node)
    {
        if(this._empty_ != null)
        {
            this._empty_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._empty_ = node;
    }

    @Override
    public String toString()
    {
        return ""
            + toString(this._empty_);
    }

    @Override
    void removeChild(@SuppressWarnings("unused") Node child)
    {
        // Remove child
        if(this._empty_ == child)
        {
            this._empty_ = null;
            return;
        }

        throw new RuntimeException("Not a child.");
    }

    @Override
    void replaceChild(@SuppressWarnings("unused") Node oldChild, @SuppressWarnings("unused") Node newChild)
    {
        // Replace child
        if(this._empty_ == oldChild)
        {
            setEmpty((TEmpty) newChild);
            return;
        }

        throw new RuntimeException("Not a child.");
    }
}
