package jeybi.me.drecorder

import android.content.Context
import android.graphics.Color
import android.media.Image
import android.support.constraint.ConstraintLayout
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

class VideosAdapter(val context: Context) :
    RecyclerView.Adapter<VideosAdapter.VideoHolder>() {


    override fun getItemViewType(position: Int): Int {
        return if (position == 0)
            0
        else
            1
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, position: Int): VideoHolder {

        val view: View? = if (position == 0)
            LayoutInflater.from(context).inflate(R.layout.item_big, viewGroup, false)
        else
            LayoutInflater.from(context).inflate(R.layout.item_small, viewGroup, false)

        return VideoHolder(view!!)
    }

    override fun getItemCount(): Int {
        return 10
    }

    override fun onBindViewHolder(holder: VideoHolder, position: Int) {

        if (position != 0) when (position % 4) {
            0 -> holder.backgroundLayout.setBackgroundResource(R.drawable.bc_child_4)
            1 -> holder.backgroundLayout.setBackgroundResource(R.drawable.bc_child_1)
            2 -> holder.backgroundLayout.setBackgroundResource(R.drawable.bc_child_2)
            3 -> holder.backgroundLayout.setBackgroundResource(R.drawable.bc_child_3)
        }
    }


    class VideoHolder(view: View) : RecyclerView.ViewHolder(view) {
        val backgroundLayout = view.findViewById<ConstraintLayout>(R.id.layoutBackground)!!
    }


}