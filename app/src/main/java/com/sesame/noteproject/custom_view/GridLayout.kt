package com.sesame.noteproject.custom_view

import android.content.Context
import android.util.AttributeSet
import android.view.View
import android.view.ViewGroup
import com.sesame.noteproject.R

class GridLayout @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : ViewGroup(context, attrs, defStyleAttr) {
    private var columnCount = 0
    private var columnSpace = 0
    private var rowSpace = 0

    init {
        context.obtainStyledAttributes(attrs, R.styleable.GridLayout, defStyleAttr, 0).apply {
            columnCount = getInt(R.styleable.GridLayout_gl_column, 2)
            columnSpace = getDimensionPixelSize(R.styleable.GridLayout_gl_columnSpace, 0)
            rowSpace = getDimensionPixelSize(R.styleable.GridLayout_gl_rowSpace, 0)
            recycle()
        }
    }

    override fun onLayout(changed: Boolean, l: Int, t: Int, r: Int, b: Int) {
        val itemWidth = (measuredWidth - columnSpace * (columnCount - 1)) / columnCount
        var top = paddingTop
        var lineHeight = 0

        (0 until childCount).asSequence()
            .map { getChildAt(it) }
            .filter { it.visibility != View.GONE }
            .forEachIndexed { index, view ->
                val column = index % columnCount
                val left = (itemWidth + columnSpace) * column
                view.layout(
                    left,
                    top,
                    left + view.measuredWidth,
                    top + view.measuredHeight
                ) //为什么不+l/r/t/b
                lineHeight = lineHeight.coerceAtLeast(view.measuredHeight)
                if (column == columnCount - 1) {
                    top += lineHeight + rowSpace
                    lineHeight = 0
                }
            }
    }

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        val widthSize = MeasureSpec.getSize(widthMeasureSpec)
        val itemWidth = (widthSize - columnSpace * (columnCount - 1)) / columnCount
        var height = paddingTop + paddingBottom
        var lineHeight = 0
        var lineTop = 0
        val childWidthMeasureSpec = MeasureSpec.makeMeasureSpec(itemWidth, MeasureSpec.EXACTLY)
        (0 until childCount).asSequence()
            .map { getChildAt(it) }
            .filter { it.visibility != View.GONE }
            .forEachIndexed { index, child ->
                measureChild(child, childWidthMeasureSpec, heightMeasureSpec)
                lineHeight = lineHeight.coerceAtLeast(child.measuredHeight) //由于一行中每一个都不一定是相同的高度
                if (index % columnCount == 0) {
                    height += lineHeight + lineTop
                }
                // 如果到达每行最后一个（第n-1列），即将换行
                if (index % columnCount == columnCount - 1) {
                    lineTop = rowSpace
                    lineHeight = 0
                }
            }
        setMeasuredDimension(widthSize, height)
    }
}