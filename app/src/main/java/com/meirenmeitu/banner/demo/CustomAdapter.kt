package com.meirenmeitu.banner.demo

import androidx.appcompat.widget.AppCompatImageView
import androidx.appcompat.widget.AppCompatTextView

/**
 * Desc:
 * Author: Jooyer
 * Date: 2019-08-28
 * Time: 12:01
 */
class CustomAdapter(data: List<String>, layoutId: Int) :
    BannerAdapter<String>(data, layoutId) {
    override fun onBindViewHolder(holder: BannerHolder, position: Int) {
        holder.itemView.findViewById<AppCompatTextView>(R.id.tv_position).text = "${position + 1}"
        ImageLoader.loader.loadImage(
            holder.itemView.findViewById<AppCompatImageView>(R.id.iv_banner),
            mData[position]
        )
    }

}