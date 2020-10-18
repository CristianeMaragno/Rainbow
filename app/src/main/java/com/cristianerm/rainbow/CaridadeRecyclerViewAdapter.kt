package com.cristianerm.rainbow

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.caridade_item.view.*

class CaridadeRecyclerViewAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private var items: List<CaridadeInformation> = ArrayList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return DestinationResultViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.caridade_item, parent, false)
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

    fun submitList(destinationResultList: ArrayList<CaridadeInformation>){
        items = destinationResultList
    }

    class DestinationResultViewHolder
    constructor(
        itemView: View
    ): RecyclerView.ViewHolder(itemView){

        val nome_c = itemView.nome_caridade
        val desc_c = itemView.descricao_caridade

        fun bind(destinationResult: CaridadeInformation){

            nome_c.setText(destinationResult.nome_caridade)
            desc_c.setText(destinationResult.descricao_caridade)

        }

    }
}
