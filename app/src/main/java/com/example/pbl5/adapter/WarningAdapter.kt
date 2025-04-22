package com.example.pbl5.adapter

import android.media.Image
import  android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.example.pbl5.R
import com.example.pbl5.model.Warning



class WarningAdapter(private var warnings: List<Warning>) :
    RecyclerView.Adapter<WarningAdapter.WarningViewHolder>() {

    class WarningViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imWarningIcon: ImageView
        val tvType : TextView
        val tvInfo: TextView
        val tvTimestamp: TextView

        init {
            // Define click listener for the ViewHolder's View
            imWarningIcon = itemView.findViewById(R.id.im_warningIcon)
            tvType = itemView.findViewById(R.id.tv_type)
            tvInfo = itemView.findViewById(R.id.tv_info)
            tvTimestamp = itemView.findViewById(R.id.tv_timestamp)
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
            viewHolder.imWarningIcon.setImageResource(R.drawable.speed_sign_icon)
            viewHolder.tvType.text = "Speed Limit Exceeded"
            viewHolder.itemView.setBackgroundColor(ContextCompat.getColor(viewHolder.itemView.context,R.color.speed_warning_bg))
        }
        else if(warnings[position].type.equals("traffic-sign")){
            viewHolder.imWarningIcon.setImageResource(R.drawable.traffic_sign_icon)
            viewHolder.tvType.text = "Traffic Sign Detection"
            viewHolder.itemView.setBackgroundColor(ContextCompat.getColor(viewHolder.itemView.context,R.color.traffic_sign_bg))
        }
        else{
            viewHolder.imWarningIcon.setImageResource(R.drawable.fallback_icon)
            viewHolder.tvType.text = "Warning"
        }

        viewHolder.tvInfo.text = warnings[position].info
        viewHolder.tvTimestamp.text = warnings[position].timestamp
    }

    // Return the size of your dataset (invoked by the layout manager)
    override fun getItemCount() :Int = warnings.size

    public fun updateData(newWarnings : List<Warning>){
        warnings = newWarnings
        notifyDataSetChanged()
    }
}