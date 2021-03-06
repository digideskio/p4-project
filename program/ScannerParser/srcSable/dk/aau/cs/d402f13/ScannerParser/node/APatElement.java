/* This file was generated by SableCC (http://www.sablecc.org/). */

package dk.aau.cs.d402f13.ScannerParser.node;

import dk.aau.cs.d402f13.ScannerParser.analysis.*;

@SuppressWarnings("nls")
public final class APatElement extends PElement
{
    private TSlash _left_;
    private PPattern _pattern_;
    private TSlash _right_;

    public APatElement()
    {
        // Constructor
    }

    public APatElement(
        @SuppressWarnings("hiding") TSlash _left_,
        @SuppressWarnings("hiding") PPattern _pattern_,
        @SuppressWarnings("hiding") TSlash _right_)
    {
        // Constructor
        setLeft(_left_);

        setPattern(_pattern_);

        setRight(_right_);

    }

    @Override
    public Object clone()
    {
        return new APatElement(
            cloneNode(this._left_),
            cloneNode(this._pattern_),
            cloneNode(this._right_));
    }

    @Override
    public void apply(Switch sw)
    {
        ((Analysis) sw).caseAPatElement(this);
    }

    public TSlash getLeft()
    {
        return this._left_;
    }

    public void setLeft(TSlash node)
    {
        if(this._left_ != null)
        {
            this._left_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._left_ = node;
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

    public TSlash getRight()
    {
        return this._right_;
    }

    public void setRight(TSlash node)
    {
        if(this._right_ != null)
        {
            this._right_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._right_ = node;
    }

    @Override
    public String toString()
    {
        return ""
            + toString(this._left_)
            + toString(this._pattern_)
            + toString(this._right_);
    }

    @Override
    void removeChild(@SuppressWarnings("unused") Node child)
    {
        // Remove child
        if(this._left_ == child)
        {
            this._left_ = null;
            return;
        }

        if(this._pattern_ == child)
        {
            this._pattern_ = null;
            return;
        }

        if(this._right_ == child)
        {
            this._right_ = null;
            return;
        }

        throw new RuntimeException("Not a child.");
    }

    @Override
    void replaceChild(@SuppressWarnings("unused") Node oldChild, @SuppressWarnings("unused") Node newChild)
    {
        // Replace child
        if(this._left_ == oldChild)
        {
            setLeft((TSlash) newChild);
            return;
        }

        if(this._pattern_ == oldChild)
        {
            setPattern((PPattern) newChild);
            return;
        }

        if(this._right_ == oldChild)
        {
            setRight((TSlash) newChild);
            return;
        }

        throw new RuntimeException("Not a child.");
    }
}
