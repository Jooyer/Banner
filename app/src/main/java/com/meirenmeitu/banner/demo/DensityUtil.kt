package com.meirenmeitu.banner.demo

import android.content.Context
import android.util.TypedValue

/**
 * Desc: dp2px 等工具集合
 * Author: Jooyer
 * Date: 2019-09-02
 * Time: 11:22
 */
object DensityUtil {

    /**
     * dp 转 px 方法
     */
    fun dp2px(context: Context, dpValue: Float): Int {
        return TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dpValue, context.resources.displayMetrics).toInt()
    }


}