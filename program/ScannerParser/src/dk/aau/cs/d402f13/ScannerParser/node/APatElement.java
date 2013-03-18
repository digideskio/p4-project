/* This file was generated by SableCC (http://www.sablecc.org/). */

package dk.aau.cs.d402f13.ScannerParser.node;

import dk.aau.cs.d402f13.ScannerParser.analysis.*;

@SuppressWarnings("nls")
public final class APatElement extends PElement
{
    private PPattern _pattern_;

    public APatElement()
    {
        // Constructor
    }

    public APatElement(
        @SuppressWarnings("hiding") PPattern _pattern_)
    {
        // Constructor
        setPattern(_pattern_);

    }

    @Override
    public Object clone()
    {
        return new APatElement(
            cloneNode(this._pattern_));
    }

    @Override
    public void apply(Switch sw)
    {
        ((Analysis) sw).caseAPatElement(this);
    }

    public PPattern getPattern()
    {
        return this._pattern_;
    }

    public void setPattern(PPattern node)
    {
        if(this._pattern_ != null)
        {
            this._pattern_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._pattern_ = node;
    }

    @Override
    public String toString()
    {
        return ""
            + toString(this._pattern_);
    }

    @Override
    void removeChild(@SuppressWarnings("unused") Node child)
    {
        // Remove child
        if(this._pattern_ == child)
        {
            this._pattern_ = null;
            return;
        }

        throw new RuntimeException("Not a child.");
    }

    @Override
    void replaceChild(@SuppressWarnings("unused") Node oldChild, @SuppressWarnings("unused") Node newChild)
    {
        // Replace child
        if(this._pattern_ == oldChild)
        {
            setPattern((PPattern) newChild);
            return;
        }

        throw new RuntimeException("Not a child.");
    }
}
