package com.example.proyecto_pmmd.adapter

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.proyecto_pmmd.databinding.ActivityMainBinding
import com.example.proyecto_pmmd.databinding.ItemlistCardviewBinding
import com.example.proyecto_pmmd.models.Digimon

class ViewHDigimon(
    view: View,
    var deleteOnClick: (Int) -> Unit,
    var updateOnClick: (Int) -> Unit,
) : RecyclerView.ViewHolder(view) {
    private var binding: ItemlistCardviewBinding

    init {
        binding = ItemlistCardviewBinding.bind(view)
    }

    fun renderize(digi: Digimon, position: Int) {
        binding.textName.text = digi.name
        binding.textLevel.text = digi.level
        binding.textType.text = digi.type
        binding.textAttribute.text = digi.attribute

        Glide
            .with(itemView.context)
            .load(digi.imagen)
            .centerCrop()
            .into(binding.idImgPpal)

        setOnClickListener(position)
    }

    private fun setOnClickListener(position: Int) {
        binding.btnEdit.setOnClickListener {
            updateOnClick(position)
        }
        binding.btnDel.setOnClickListener {
            deleteOnClick(position)
        }
    }
}