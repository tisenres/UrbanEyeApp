package com.tisenres.urbaneyeapp.app.presentation.properties

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.tisenres.urbaneyeapp.app.presentation.properties.models.PropertyType
import com.tisenres.urbaneyeapp.databinding.PropertyItemBinding

const val NUMBER_OF_SECTIONS = 4

class PropertiesAdapter(private val presenter: IPropertiesPresenter) :
    RecyclerView.Adapter<PropertiesAdapter.PropertyViewHolder>() {
    
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PropertyViewHolder {
        val binding =
            PropertyItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return PropertyViewHolder(binding)
    }
    
    override fun getItemCount(): Int = NUMBER_OF_SECTIONS
    
    override fun onBindViewHolder(holder: PropertyViewHolder, position: Int) {
        holder.bind(position)
    }
    
    inner class PropertyViewHolder(private val binding: PropertyItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        
        init {
            initSetOnClickListeners()
        }
        
        private fun initSetOnClickListeners() {
            binding.button.setOnClickListener {
                val pos = adapterPosition
                if (pos != RecyclerView.NO_POSITION) {
                    presenter.onButtonPressed(pos)
                }
            }
            
            binding.card.setOnClickListener {
                val pos = adapterPosition
                if (pos != RecyclerView.NO_POSITION) {
                    presenter.onButtonPressed(pos)
                }
            }
        }
        
        fun bind(position: Int) {
            val propertyType = PropertyType.from(position)
            binding.propertyName.text = propertyType.name
            binding.propertyDescription.text = propertyType.description
            binding.propertyImage.setImageResource(propertyType.picRes)
        }
    }
}
