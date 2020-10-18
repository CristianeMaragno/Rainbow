package com.cristianerm.rainbow

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.promotion_item.view.*

class PromotionsRecyclerViewAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private var items: List<PromotionsInformation> = ArrayList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return DestinationResultViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.promotion_item, parent, false)
        )
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when(holder) {

            is DestinationResultViewHolder -> {
                holder.bind(items.get(position))
            }

        }
    }

    override fun getItemCount(): Int {
        return items.size
    }

    fun submitList(destinationResultList: ArrayList<PromotionsInformation>){
        items = destinationResultList
    }

    class DestinationResultViewHolder
    constructor(
        itemView: View
    ): RecyclerView.ViewHolder(itemView){

        val disconto_v = itemView.disconto_value
        val disconto_e = itemView.disconto_event

        fun bind(destinationResult: PromotionsInformation){

            disconto_v.setText(destinationResult.desconto)
            disconto_e.setText(destinationResult.evento_servico)

        }

    }
}












