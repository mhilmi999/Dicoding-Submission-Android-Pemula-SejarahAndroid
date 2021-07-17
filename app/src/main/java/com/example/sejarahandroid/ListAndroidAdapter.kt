package com.example.sejarahandroid

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions

class ListAndroidAdapter(private val listAndroid: ArrayList<Android>) : RecyclerView.Adapter<ListAndroidAdapter.ListViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.item_row_android, parent, false)
        return ListViewHolder(view)
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val android = listAndroid[position]

        Glide.with(holder.itemView.context)
            .load(android.photo)
            .apply(RequestOptions().override(55,55))
            .into(holder.imgPhoto)

        holder.tvName.text = android.name
        holder.tvDetail.text = android.detail

        val mContext = holder.itemView.context

        holder.itemView.setOnClickListener {
            val versionDetail = Intent(mContext, AndroidDetailActivity::class.java)
            versionDetail.putExtra(AndroidDetailActivity.EXTRA_NAME, android.name)
            versionDetail.putExtra(AndroidDetailActivity.EXTRA_DETAIL, android.detail)
            versionDetail.putExtra(AndroidDetailActivity.EXTRA_PHOTO, android.photo)
            mContext.startActivity(versionDetail)
        }
    }

    override fun getItemCount(): Int {
        return listAndroid.size
    }

    inner class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var tvName: TextView = itemView.findViewById(R.id.tv_item_name)
        var tvDetail: TextView = itemView.findViewById(R.id.tv_item_detail)
        var imgPhoto: ImageView = itemView.findViewById(R.id.img_item_photo)
    }
}