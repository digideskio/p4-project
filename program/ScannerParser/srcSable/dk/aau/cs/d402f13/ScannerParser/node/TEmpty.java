/* This file was generated by SableCC (http://www.sablecc.org/). */

package dk.aau.cs.d402f13.ScannerParser.node;

import dk.aau.cs.d402f13.ScannerParser.analysis.*;

@SuppressWarnings("nls")
public final class TEmpty extends Token
{
    public TEmpty()
    {
        super.setText("empty");
    }

    public TEmpty(int line, int pos)
    {
        super.setText("empty");
        setLine(line);
        setPos(pos);
    }

    @Override
    public Object clone()
    {
      return new TEmpty(getLine(), getPos());
    }

    @Override
    public void apply(Switch sw)
    {
        ((Analysis) sw).caseTEmpty(this);
    }

    @Override
    public void setText(@SuppressWarnings("unused") String text)
    {
        throw new RuntimeException("Cannot change TEmpty text.");
    }
}