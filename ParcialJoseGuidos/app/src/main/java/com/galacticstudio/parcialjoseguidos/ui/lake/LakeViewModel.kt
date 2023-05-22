package com.galacticstudio.parcialjoseguidos.ui.lake

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider.AndroidViewModelFactory.Companion.APPLICATION_KEY
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.galacticstudio.parcialjoseguidos.LakeReviewerApplication
import com.galacticstudio.parcialjoseguidos.data.models.LakeModel
import com.galacticstudio.parcialjoseguidos.repositories.LakeRepository

class LakeViewModel(private val repository: LakeRepository): ViewModel() {

    var name = MutableLiveData("")
    var surface = MutableLiveData("")
    var status = MutableLiveData("")

    fun getLakes() = repository.getLakes()

    fun addLake(lake: LakeModel) = repository.addLake(lake)

    private fun validateData(): Boolean{
        when{
            name.value.isNullOrEmpty() -> return false
            surface.value.isNullOrEmpty() -> return false
        }
        return true
    }

    fun createLake(){
        if (!validateData()){
            status.value = WRONG_DATA
            return
        }
        val lake = LakeModel(
            name.value!!,
            surface.value!!
        )
        addLake(lake)
        clearData()

        status.value = LAKE_CREATED
    }

    fun clearData(){
        name.value = ""
        surface.value = ""
    }
    fun clearStatus(){
        status.value = INACTIVE
    }

    companion object {
        val Factory = viewModelFactory {
            initializer {
                val app = this[APPLICATION_KEY] as LakeReviewerApplication
                LakeViewModel(app.lakeRepository)
            }
        }

        const val LAKE_CREATED = "Lake created"
        const val WRONG_DATA = "Wrong data"
        const val INACTIVE = ""
    }
}