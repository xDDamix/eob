package pl.dguziak.view.component

import android.animation.ValueAnimator
import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.util.AttributeSet
import android.util.Log
import android.view.View
import pl.dguziak.view.R

class ProgressBar constructor(
    context: Context?,
    attrs: AttributeSet?
) : View(context, attrs) {

    private var paint: Paint = Paint().apply {
        style = Paint.Style.FILL_AND_STROKE
    }

    private var barMainColor: Int = Color.BLACK
    private var barBackgroundColor: Int = Color.GRAY

    init {
        context?.theme?.obtainStyledAttributes(
            attrs,
            R.styleable.ProgressBar,
            0, 0
        )?.apply {
            try {
                barMainColor = getColor(R.styleable.ProgressBar_mainColor, barMainColor)
                barBackgroundColor =
                    getColor(R.styleable.ProgressBar_backgroundColor, barBackgroundColor)
            } finally {
                recycle()
            }
        }
    }

    var currentProgress = 0f

    override fun onDraw(canvas: Canvas?) {
        val progressEnd = width.toFloat() * currentProgress
        paint.strokeWidth = height.toFloat()

        paint.color = barMainColor
        canvas?.drawLine(0f, height.toFloat(), progressEnd, height.toFloat(), paint)

        paint.color = barBackgroundColor
        canvas?.drawLine(progressEnd, height.toFloat(), width.toFloat(), height.toFloat(), paint)
    }

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        val height = MeasureSpec.getSize(heightMeasureSpec)
        val width = MeasureSpec.getSize(widthMeasureSpec)

        setMeasuredDimension(width, height)
    }

    fun setAnimatedProgress(startProgress: Float, designatedProgress: Float, timeMs: Long) {
        if (startProgress > designatedProgress) {
            Log.e("EOApp", "Bar Animation - start value $startProgress is higher than designated value $designatedProgress")
            return
        }

        setProgress(startProgress)
        val barAnimator = ValueAnimator.ofFloat(startProgress, designatedProgress);
        barAnimator.duration = timeMs;

        barAnimator.addUpdateListener {
            val value = it.animatedValue as Float
            setProgress(value * designatedProgress)
        }

        barAnimator.start()
    }

    fun setProgress(value: Float) {
        currentProgress = value

        invalidate()
        requestLayout()
    }
}