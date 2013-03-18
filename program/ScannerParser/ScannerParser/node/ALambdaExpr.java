/* This file was generated by SableCC (http://www.sablecc.org/). */

package ScannerParser.node;

import java.util.*;
import ScannerParser.analysis.*;

@SuppressWarnings("nls")
public final class ALambdaExpr extends PLambdaExpr
{
    private TPound _pound_;
    private TLBkt _lBkt_;
    private final LinkedList<TVariable> _variable_ = new LinkedList<TVariable>();
    private TRBkt _rBkt_;
    private TLArrow _lArrow_;
    private PExpression _expression_;

    public ALambdaExpr()
    {
        // Constructor
    }

    public ALambdaExpr(
        @SuppressWarnings("hiding") TPound _pound_,
        @SuppressWarnings("hiding") TLBkt _lBkt_,
        @SuppressWarnings("hiding") List<?> _variable_,
        @SuppressWarnings("hiding") TRBkt _rBkt_,
        @SuppressWarnings("hiding") TLArrow _lArrow_,
        @SuppressWarnings("hiding") PExpression _expression_)
    {
        // Constructor
        setPound(_pound_);

        setLBkt(_lBkt_);

        setVariable(_variable_);

        setRBkt(_rBkt_);

        setLArrow(_lArrow_);

        setExpression(_expression_);

    }

    @Override
    public Object clone()
    {
        return new ALambdaExpr(
            cloneNode(this._pound_),
            cloneNode(this._lBkt_),
            cloneList(this._variable_),
            cloneNode(this._rBkt_),
            cloneNode(this._lArrow_),
            cloneNode(this._expression_));
    }

    @Override
    public void apply(Switch sw)
    {
        ((Analysis) sw).caseALambdaExpr(this);
    }

    public TPound getPound()
    {
        return this._pound_;
    }

    public void setPound(TPound node)
    {
        if(this._pound_ != null)
        {
            this._pound_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._pound_ = node;
    }

    public TLBkt getLBkt()
    {
        return this._lBkt_;
    }

    public void setLBkt(TLBkt node)
    {
        if(this._lBkt_ != null)
        {
            this._lBkt_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._lBkt_ = node;
    }

    public LinkedList<TVariable> getVariable()
    {
        return this._variable_;
    }

    public void setVariable(List<?> list)
    {
        for(TVariable e : this._variable_)
        {
            e.parent(null);
        }
        this._variable_.clear();

        for(Object obj_e : list)
        {
            TVariable e = (TVariable) obj_e;
            if(e.parent() != null)
            {
                e.parent().removeChild(e);
            }

            e.parent(this);
            this._variable_.add(e);
        }
    }

    public TRBkt getRBkt()
    {
        return this._rBkt_;
    }

    public void setRBkt(TRBkt node)
    {
        if(this._rBkt_ != null)
        {
            this._rBkt_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._rBkt_ = node;
    }

    public TLArrow getLArrow()
    {
        return this._lArrow_;
    }

    public void setLArrow(TLArrow node)
    {
        if(this._lArrow_ != null)
        {
            this._lArrow_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._lArrow_ = node;
    }

    public PExpression getExpression()
    {
        return this._expression_;
    }

    public void setExpression(PExpression node)
    {
        if(this._expression_ != null)
        {
            this._expression_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._expression_ = node;
    }

    @Override
    public String toString()
    {
        return ""
            + toString(this._pound_)
            + toString(this._lBkt_)
            + toString(this._variable_)
            + toString(this._rBkt_)
            + toString(this._lArrow_)
            + toString(this._expression_);
    }

    @Override
    void removeChild(@SuppressWarnings("unused") Node child)
    {
        // Remove child
        if(this._pound_ == child)
        {
            this._pound_ = null;
            return;
        }

        if(this._lBkt_ == child)
        {
            this._lBkt_ = null;
            return;
        }

        if(this._variable_.remove(child))
        {
            return;
        }

        if(this._rBkt_ == child)
        {
            this._rBkt_ = null;
            return;
        }

        if(this._lArrow_ == child)
        {
            this._lArrow_ = null;
            return;
        }

        if(this._expression_ == child)
        {
            this._expression_ = null;
            return;
        }

        throw new RuntimeException("Not a child.");
    }

    @Override
    void replaceChild(@SuppressWarnings("unused") Node oldChild, @SuppressWarnings("unused") Node newChild)
    {
        // Replace child
        if(this._pound_ == oldChild)
        {
            setPound((TPound) newChild);
            return;
        }

        if(this._lBkt_ == oldChild)
        {
            setLBkt((TLBkt) newChild);
            return;
        }

        for(ListIterator<TVariable> i = this._variable_.listIterator(); i.hasNext();)
        {
            if(i.next() == oldChild)
            {
                if(newChild != null)
                {
                    i.set((TVariable) newChild);
                    newChild.parent(this);
                    oldChild.parent(null);
                    return;
                }

                i.remove();
                oldChild.parent(null);
                return;
            }
        }

        if(this._rBkt_ == oldChild)
        {
            setRBkt((TRBkt) newChild);
            return;
        }

        if(this._lArrow_ == oldChild)
        {
            setLArrow((TLArrow) newChild);
            return;
        }

        if(this._expression_ == oldChild)
        {
            setExpression((PExpression) newChild);
            return;
        }

        throw new RuntimeException("Not a child.");
    }
}
