package com.example.recyclerviewticktock

import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.VideoView
import androidx.recyclerview.widget.RecyclerView

class FavoriteCardAdapter(var mList: List<CardDate>): RecyclerView.Adapter<FavoriteCardAdapter.FavoriteCardViewHolder>() {
    inner class  FavoriteCardViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        val logo: VideoView = itemView.findViewById(R.id.logoIv)
//        val titleTv: TextView = itemView.findViewById(R.id.titleTv)
    }

    fun setFilterdList(mList: List<CardDate>){
        this.mList = mList
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FavoriteCardViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.favorite_item, parent, false)
        return FavoriteCardViewHolder(view)
    }

    override fun getItemCount() = mList.size

    override fun onBindViewHolder(holder: FavoriteCardViewHolder, position: Int) {
        val cardData = mList[position]
        // VideoView を取得し、動画をセット
        val videoView = holder.itemView.findViewById<VideoView>(R.id.logoIv)
        videoView.setVideoURI(Uri.parse(cardData.logo))

        // 動画再生を開始
        videoView.start()
    }
}