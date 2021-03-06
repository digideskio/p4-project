package dk.aau.cs.d402f13.widgets;

import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.TrueTypeFont;

import dk.aau.cs.d402f13.helpers.ResourceHelper;

public class Label extends Widget{
	private String fontName;
	private int fontSize;
	private String text;
	
	public Label( String fontName, int fontSize, String text ){
		scaleWidth( 0 );
		this.fontName = fontName;
		this.fontSize = fontSize;
		this.text = text;
	}
	
	public TrueTypeFont font(){
		return ResourceHelper.getFont( fontName, fontSize );
	}
	
	public void setString( String newText ){
		text = newText;
	}
	

	@Override
	public int getMinWidth(){ return font().getWidth( text ); }
	@Override
	public int getMinHeight(){ return font().getLineHeight(); }
	@Override
	public int getMaxHeight(){ return getMinHeight(); }
	
	@Override
	public void handleDraw( Graphics g ){
		g.setFont( font() );
		g.setColor( Color.black );
		g.drawString( text, 0, 0 );
	}
}
