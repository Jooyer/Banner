package com.meirenmeitu.banner.demo

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.meirenmeitu.banner.OnPositionChangeListener
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private val data = arrayListOf(
        "https://img-my.csdn.net/uploads/201508/05/1438760758_3497.jpg",
        "https://img-my.csdn.net/uploads/201508/05/1438760724_2371.jpg",
        "https://img-my.csdn.net/uploads/201508/05/1438760707_4653.jpg"
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        // 普通用法
        val adapter = CustomAdapter(data, R.layout.item_banner_normal)
        banner.setBannerAdapter(adapter)

        // Item 带横幅用法
        val adapter2 = CustomAdapter2(data, R.layout.item_banner_normal2)
        banner2.setBannerAdapter(adapter2)

        // 独立横幅用法
        val titles = arrayListOf("818活动刚刚过去...", "双十一活动报名现在开始...", "双十二活动即将到来...")
        tv_text.text = titles[0]
        val adapter3 = CustomAdapter(data, R.layout.item_banner_normal)
        banner3.setBannerAdapter(adapter3)
        banner3.setOnPositionChangeListener(object : OnPositionChangeListener {
            override fun onPositionChange(position: Int) { // 此时banner2下方的横幅是随 Item 移动的,如果不想要其移动可以如下方式
                tv_text.text = titles[position]
            }
        })
    }

}
