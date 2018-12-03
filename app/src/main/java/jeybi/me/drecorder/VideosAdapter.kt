package jeybi.me.drecorder

import android.content.Context
import android.graphics.Color
import android.media.Image
import android.support.design.card.MaterialCardView
import android.support.v7.widget.RecyclerView
import android.text.Layout
import android.view.ContextMenu
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import java.text.FieldPosition

class VideosAdapter(val context: Context, val videos: ArrayList<RecordedVideo>) :
    RecyclerView.Adapter<VideosAdapter.VideoHolder>() {


    override fun onCreateViewHolder(viewGroup: ViewGroup, p1: Int): VideoHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.item_big, viewGroup, false)

        return VideoHolder(view)
    }

    override fun getItemCount(): Int {
        return videos.size
    }

    override fun onBindViewHolder(holder: VideoHolder, position: Int) {
        val video = videos[position]

        holder.textViewTitle.text = video.title
        holder.textViewPath.text = video.path

        when(position % 2){
            0->holder.cardView.setCardBackgroundColor(Color.parseColor("#EB3F57"))
            1-> holder.cardView.setCardBackgroundColor(Color.parseColor("#6459FB"))
        }

    }


    class VideoHolder(view: View) : RecyclerView.ViewHolder(view) {
        val textViewTitle = view.findViewById<TextView>(R.id.textViewTitle)
        val textViewPath = view.findViewById<TextView>(R.id.textViewPath)
        val cardView = view.findViewById<MaterialCardView>(R.id.cardView)
    }


}