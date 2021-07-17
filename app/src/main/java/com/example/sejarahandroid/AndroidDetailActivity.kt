package com.example.sejarahandroid

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions

class AndroidDetailActivity : AppCompatActivity() {
    companion object{
        const val EXTRA_NAME = "extra_name"
        const val EXTRA_PHOTO = "extra_photo"
        const val EXTRA_DETAIL = "extra_detail"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_android_detail)
        val actionbar = supportActionBar
        actionbar!!.title = "Detail Versi Android"
        actionbar.setDisplayHomeAsUpEnabled(true)

        val tvItemName: TextView = findViewById(R.id.tv_item_name)
        val tvItemDetail: TextView = findViewById(R.id.tv_item_detail)
        val imgItemPhoto: ImageView = findViewById(R.id.img_item_photo)

        val androVersionName = intent.getStringExtra(EXTRA_NAME)
        val androVersionDetail = intent.getStringExtra(EXTRA_DETAIL)
        val androVersionImg = intent.getIntExtra(EXTRA_PHOTO, 0)

        tvItemName.text = androVersionName
        tvItemDetail.text = androVersionDetail
        Glide.with(this)
            .load(androVersionImg)
            .apply(RequestOptions())
            .into(imgItemPhoto)
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}