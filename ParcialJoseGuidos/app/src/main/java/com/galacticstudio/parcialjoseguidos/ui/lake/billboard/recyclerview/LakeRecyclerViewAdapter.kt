package com.galacticstudio.parcialjoseguidos.ui.lake.billboard.recyclerview

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ExpandableListView.OnChildClickListener
import androidx.recyclerview.widget.RecyclerView
import com.galacticstudio.parcialjoseguidos.data.models.LakeModel
import com.galacticstudio.parcialjoseguidos.databinding.LakeItemBinding

class LakeRecyclerViewAdapter (
    private val clickListener: (LakeModel) -> Unit
    ): RecyclerView.Adapter<LakeRecyclerViewHolder>() {

        private val lakes = arrayListOf<LakeModel>()

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LakeRecyclerViewHolder {
            val binding = LakeItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
            return LakeRecyclerViewHolder(binding)
        }

        override fun getItemCount(): Int {
            return lakes.size
        }

        override fun onBindViewHolder(holder: LakeRecyclerViewHolder, position: Int) {
            val lake = lakes[position]
            holder.bind(lake, clickListener)
        }

        fun setData(lakesList: List<LakeModel>){
            lakes.clear()
            lakes.addAll(lakesList)
        }

    }

