package com.example.proyecto_pmmd.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.proyecto_pmmd.R
import com.example.proyecto_pmmd.models.Digimon

class AdapterDigimon(
    private var listaDigimons: MutableList<Digimon>,
    private var deleteOnClick: (Int) -> Unit,
    private var updateOnCLick: (Int) -> Unit) : RecyclerView.Adapter<ViewHDigimon>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHDigimon {
        val layoutInflater = LayoutInflater.from(parent.context)
        val layoutItemDigi = R.layout.itemlist_cardview

        return ViewHDigimon(
            layoutInflater.inflate(layoutItemDigi, parent, false),
            deleteOnClick,
            updateOnCLick
        )
    }

    override fun onBindViewHolder(holder: ViewHDigimon, position: Int) {
        holder.renderize(listaDigimons[position], position)
    }

    override fun getItemCount(): Int = listaDigimons.size
}