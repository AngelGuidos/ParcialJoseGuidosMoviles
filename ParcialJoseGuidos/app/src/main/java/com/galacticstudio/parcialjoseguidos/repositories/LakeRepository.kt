package com.galacticstudio.parcialjoseguidos.repositories

import com.galacticstudio.parcialjoseguidos.data.models.LakeModel

class LakeRepository(private val lakes: MutableList<LakeModel>) {

    fun getLakes() = lakes

    fun addLake(newLake: LakeModel) = lakes.add(newLake)
}