package com.galacticstudio.parcialjoseguidos.ui.lake.billboard.recyclerview

import androidx.recyclerview.widget.RecyclerView
import com.galacticstudio.parcialjoseguidos.data.models.LakeModel
import com.galacticstudio.parcialjoseguidos.databinding.LakeItemBinding

class LakeRecyclerViewHolder(private val binding: LakeItemBinding): RecyclerView.ViewHolder(binding.root) {
    fun bind(lake: LakeModel, clickListener: (LakeModel) -> Unit){
        binding.itemNameTv.text = lake.name
        binding.itemSurfaceTv.text = lake.surface

        binding.lakeItemCv.setOnClickListener{
            clickListener(lake)
        }
    }
}