package com.example.zooanimalapi.adapterRV

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.zooanimalapi.R
import com.example.zooanimalapi.databinding.ItemrecyclerviewBinding
import com.example.zooanimalapi.model.AnimalListItem

class adapterRV : RecyclerView.Adapter<adapterRV.CustomViewHolder>()  {

    var lista: List<AnimalListItem> = ArrayList()
    private lateinit var listener: listenerParaClickEnRV

    class CustomViewHolder(itemView: View, var listener: listenerParaClickEnRV) :
        RecyclerView.ViewHolder(itemView) {

        private val binding = ItemrecyclerviewBinding.bind(itemView)

        fun bindData(animal: AnimalListItem) {

           binding.iconoMonedaLista.load(animal.image_link)

            binding.nombreAnimal.text = animal.name
            binding.tipoAnimal.text = animal.animal_type
            binding.habitatAnimal.text = animal.habitat

            itemView.setOnClickListener {
                listener.alClickearAnimal(animal)
            }

        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CustomViewHolder {

        val view: View =
            LayoutInflater.from(parent.context).inflate(R.layout.itemrecyclerview, parent, false)
        return CustomViewHolder(view, listener)


    }

    override fun onBindViewHolder(holder: CustomViewHolder, position: Int) {
        holder.bindData(lista[position])
    }

    override fun getItemCount(): Int {
        return lista.size
    }

    interface listenerParaClickEnRV {
        fun alClickearAnimal(animal: AnimalListItem)
    }

    fun setearListener(zooAnimal: List<AnimalListItem>) {

        lista = zooAnimal as ArrayList<AnimalListItem>
        notifyDataSetChanged()

    }

    fun setOnItemClickListener(listener: listenerParaClickEnRV) {

        this.listener = listener

    }

}