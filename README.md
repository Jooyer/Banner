# Banner
RecyclerView 实现无限轮播的 Banner

## 用法如下

```
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

```
布局文件:
```
<?xml version="1.0" encoding="utf-8"?>
<androidx.constraintlayout.widget.ConstraintLayout
        xmlns:android="http://schemas.android.com/apk/res/android"
        xmlns:tools="http://schemas.android.com/tools"
        xmlns:app="http://schemas.android.com/apk/res-auto"
        android:layout_width="match_parent"
        android:layout_height="match_parent"
        tools:context=".MainActivity">

    <com.meirenmeitu.banner.BannerLayout
            android:id="@+id/banner"
            android:layout_width="match_parent"
            android:layout_height="200dp"
            app:banner_indicator_height="10dp"
            app:banner_indicator_margin="3dp"
            app:banner_normal_indicator_drawable="@drawable/normal"
            app:banner_select_indicator_drawable="@drawable/select"
            app:banner_loop_time="5000"
            app:banner_show_indicator="true"
            app:layout_constraintLeft_toLeftOf="parent"
            app:layout_constraintRight_toRightOf="parent"
            app:layout_constraintTop_toTopOf="parent"
    />

    <com.meirenmeitu.banner.BannerLayout
            android:id="@+id/banner2"
            android:layout_width="match_parent"
            android:layout_height="200dp"
            android:layout_marginTop="30dp"
            app:banner_indicator_height="10dp"
            app:banner_indicator_margin="3dp"
            app:banner_normal_indicator_drawable="@drawable/normal"
            app:banner_select_indicator_drawable="@drawable/select"
            app:banner_loop_time="4000"
            app:banner_show_indicator="false"
            app:layout_constraintLeft_toLeftOf="parent"
            app:layout_constraintRight_toRightOf="parent"
            app:layout_constraintTop_toBottomOf="@id/banner"
    />

    <com.meirenmeitu.banner.BannerLayout
            android:id="@+id/banner3"
            android:layout_width="match_parent"
            android:layout_height="200dp"
            android:layout_marginTop="30dp"
            app:banner_indicator_height="10dp"
            app:banner_indicator_margin="3dp"
            app:banner_normal_indicator_drawable="@drawable/normal"
            app:banner_select_indicator_drawable="@drawable/select"
            app:banner_loop_time="3000"
            app:banner_show_indicator="false"
            app:layout_constraintLeft_toLeftOf="parent"
            app:layout_constraintRight_toRightOf="parent"
            app:layout_constraintTop_toBottomOf="@id/banner2"
    />

    <androidx.appcompat.widget.AppCompatTextView
            android:id="@+id/tv_text"
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:padding="5dp"
            android:background="#7C000000"
            android:text="双十一活动报名现在开始..."
            android:layout_alignParentBottom="true"
            android:textSize="14sp"
            android:textColor="#fff"
            app:layout_constraintEnd_toEndOf="@+id/banner3"
            app:layout_constraintBottom_toBottomOf="@+id/banner3"
    />


</androidx.constraintlayout.widget.ConstraintLayout>
```

