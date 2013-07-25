/**
 * 
 */
package com.realdelsi.dartsscoreboard;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.widget.Button;

/**
 * @author mike
 *
 */
public class CricketView extends Button 
{
	private int clicks;
	private int player;
	private int value;
	private Paint painter;
	

	/**
	 * @param context
	 */
	public CricketView(Context context) {
		super(context);
		initCricketView();
	}

	/**
	 * @param context
	 * @param attrs
	 */
	public CricketView(Context context, AttributeSet attrs) {
		super(context, attrs);
		initCricketView();
	}

	/**
	 * @param context
	 * @param attrs
	 * @param defStyle
	 */
	public CricketView(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
		initCricketView();
	}
	protected void initCricketView()
	{
		setFocusable(true);
		clicks = 0;
		player = 0;
		painter = new Paint(Paint.ANTI_ALIAS_FLAG);
		painter.setColor(getResources().getColor(android.R.color.white));
		painter.setStrokeWidth(10);
		painter.setStyle(Paint.Style.STROKE);
	}
	@Override
	protected void onDraw(Canvas canvas)
	{
		int width = getMeasuredWidth();
		int height = getMeasuredHeight();
		int px = width/2;
		int py = height/2;
		int radius = Math.min(px, py);
		//draw circle for test with numclicks text
		//canvas.drawCircle(px, py, radius, painter);
		//canvas.drawText("" + clicks, 20, 20, painter);

		
		if(clicks == 1)
		{
			canvas.drawLine(0, 0, width, height, painter);
		}
		else if(clicks == 2)
		{
			canvas.drawLine(0, 0, width, height, painter);
			canvas.drawLine(0, height, width, 0, painter);
		}
		else if(clicks >= 3)
		{
			canvas.drawLine(0, 0, width, height, painter);
			canvas.drawLine(0, height, width, 0, painter);
			canvas.drawCircle(px, py, radius, painter);
		}
	}
	@Override
	protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec)
	{
		int measuredWidth = measure(widthMeasureSpec);
		int measuredHeight = measure(heightMeasureSpec);
		int d = Math.min(measuredWidth, measuredHeight);
		setMeasuredDimension(d, d);
	}
	private int measure(int measureSpec)
	{
		int result = 0;
		//Decode Measurement specifications
		int specMode = MeasureSpec.getMode(measureSpec);
		int specSize = MeasureSpec.getSize(measureSpec);
		if(specMode == MeasureSpec.UNSPECIFIED)
		{
			//return 100 by default
			result = 100;
		}
		else
		{
			//return full available size if possible
			result = specSize;
		}
		return result;
	}
	
	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}
	
	public void setPlayer(int p)
	{
		player = p;
	}
	
	public int getPlayer()
	{
		return player;
	}
	
	public void setClicks(int c)
	{
		clicks = c;
	}
	public int getClicks()
	{
		return clicks;
	}
	public void addClick()
	{
		clicks++;
	}
}