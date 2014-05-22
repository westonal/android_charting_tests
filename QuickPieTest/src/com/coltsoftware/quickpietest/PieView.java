package com.coltsoftware.quickpietest;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.View;

public class PieView extends View {

	public PieView(Context context, AttributeSet attrs) {
		super(context, attrs);
	}

	public PieView(Context context) {
		super(context);
	}

	@Override
	protected void onDraw(Canvas canvas) {
		super.onDraw(canvas);
		canvas.drawColor(0xffff0000);
	}

	@Override
	protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
		// Try for a width based on our minimum
		int minw = getPaddingLeft() + getPaddingRight()
				+ getSuggestedMinimumWidth();
		int w = resolveSizeAndState(minw, widthMeasureSpec, 1);

		// Whatever the width ends up being, ask for a height that would let the
		// pie
		// get as big as it can
		int minh = MeasureSpec.getSize(w) + getPaddingBottom()
				+ getPaddingTop();
		int h = resolveSizeAndState(MeasureSpec.getSize(w), heightMeasureSpec,
				0);

		setMeasuredDimension(w, h);
	}

}
