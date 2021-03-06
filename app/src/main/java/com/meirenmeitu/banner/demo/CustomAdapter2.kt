package com.meirenmeitu.banner.demo

import androidx.appcompat.widget.AppCompatImageView
import androidx.appcompat.widget.AppCompatTextView

/**
 * Desc:
 * Author: Jooyer
 * Date: 2019-08-28
 * Time: 12:01
 */
class CustomAdapter2(data: List<String>, layoutId: Int) :
    BannerAdapter<String>(data, layoutId) {

    private val titles = arrayListOf("818活动刚刚过去...","双十一活动报名现在开始...","双十二活动即将到来...")

    override fun onBindViewHolder(holder: BannerHolder, position: Int) {
        holder.itemView.findViewById<AppCompatTextView>(R.id.tv_position).text = "$position"
        holder.itemView.findViewById<AppCompatTextView>(R.id.tv_text).text = titles[position]

        ImageLoader.loader.loadImage(holder.itemView.findViewById<AppCompatImageView>(R.id.iv_banner), mData[position])
    }

}