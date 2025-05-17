package com.example.pbl5.adapter

import android.media.Image
import  android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AnimationUtils
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.example.pbl5.R
import com.example.pbl5.model.Warning
import android.graphics.Color


class WarningAdapter(private var warnings: List<Warning>) :
    RecyclerView.Adapter<WarningAdapter.WarningViewHolder>() {

   private var lastAnimatedPosition = -1  // phục vụ mục đích cuộn cho item mới vừa được tạo

    class WarningViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imWarningIcon: ImageView
        val tvType : TextView
        val tvInfo: TextView
        val tvTimestamp: TextView
        val viewStripe: View

        init {
            // Define click listener for the ViewHolder's View
            imWarningIcon = itemView.findViewById(R.id.im_warningIcon)
            tvType = itemView.findViewById(R.id.tv_type)
            tvInfo = itemView.findViewById(R.id.tv_info)
            tvTimestamp = itemView.findViewById(R.id.tv_timestamp)
            viewStripe = itemView.findViewById(R.id.view_warningStripe)
        }
    }

    // Create new views (invoked by the layout manager)
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WarningViewHolder {
        // Create a new view, which defines the UI of the list item
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_warning, parent, false)

        return WarningViewHolder(view)
    }

    // Replace the contents of a view (invoked by the layout manager)
    override fun onBindViewHolder(viewHolder: WarningViewHolder, position: Int) {

        // Get element from your dataset at this position and replace the
        // contents of the view with that element
        if(warnings[position].type.equals("speed")){
            viewHolder.imWarningIcon.setImageResource(R.drawable.warning_speed)
            viewHolder.tvType.text = "Speed Limit Exceeded"
            viewHolder.viewStripe.setBackgroundColor(Color.parseColor("#ff2147"))

        }
        else if(warnings[position].type.equals("traffic-sign")){
            viewHolder.imWarningIcon.setImageResource(R.drawable.warning_traffic_sign)
            viewHolder.tvType.text = "Traffic Sign Detection"
            viewHolder.viewStripe.setBackgroundColor(Color.parseColor("#ffb400"))

        }
        else{
            viewHolder.imWarningIcon.setImageResource(R.drawable.fallback_icon)
            viewHolder.tvType.text = "Warning"
        }

        viewHolder.tvInfo.text = warnings[position].info
        viewHolder.tvTimestamp.text = warnings[position].timestamp

       // // 💥 Animate chỉ khi item là mới được thêm (position > lastAnimatedPosition)
        val currentPosition = viewHolder.adapterPosition
        if (currentPosition != RecyclerView.NO_POSITION && currentPosition > lastAnimatedPosition) {
            val animation = AnimationUtils.loadAnimation(viewHolder.itemView.context, R.anim.item_slide_in_right)
            viewHolder.itemView.startAnimation(animation)
            lastAnimatedPosition = currentPosition
        }

    }

    // Return the size of your dataset (invoked by the layout manager)
    override fun getItemCount() :Int = warnings.size

    public fun updateData(newWarnings : List<Warning>){
        warnings = newWarnings
        notifyDataSetChanged()
    }
}