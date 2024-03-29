package com.sage.sale.ui;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.View;

/**
 * Space is a lightweight View subclass that may be used to create gaps between
 * components in general purpose layouts.
 */
public final class SpaceView extends View {
	/**
	 * {@inheritDoc}
	 */
	public SpaceView(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
		if (getVisibility() == VISIBLE) {
			setVisibility(INVISIBLE);
		}
	}

	/**
	 * {@inheritDoc}
	 */
	public SpaceView(Context context, AttributeSet attrs) {
		this(context, attrs, 0);
	}

	/**
	 * {@inheritDoc}
	 */
	public SpaceView(Context context) {
		// noinspection NullableProblems
		this(context, null);
	}

	/**
	 * Draw nothing.
	 * 
	 * @param canvas
	 *            an unused parameter.
	 */
	@Override
	public void draw(Canvas canvas) {
	}

	/**
	 * Compare to: {@link View#getDefaultSize(int, int)} If mode is AT_MOST,
	 * return the child size instead of the parent size (unless it is too big).
	 */
	private static int getDefaultSize2(int size, int measureSpec) {
		int result = size;
		int specMode = MeasureSpec.getMode(measureSpec);
		int specSize = MeasureSpec.getSize(measureSpec);

		switch (specMode) {
		case MeasureSpec.UNSPECIFIED:
			result = size;
			break;
		case MeasureSpec.AT_MOST:
			result = Math.min(size, specSize);
			break;
		case MeasureSpec.EXACTLY:
			result = specSize;
			break;
		}
		return result;
	}

	@Override
	protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
		setMeasuredDimension(
				getDefaultSize2(getSuggestedMinimumWidth(), widthMeasureSpec),
				getDefaultSize2(getSuggestedMinimumHeight(), heightMeasureSpec));
	}
}
