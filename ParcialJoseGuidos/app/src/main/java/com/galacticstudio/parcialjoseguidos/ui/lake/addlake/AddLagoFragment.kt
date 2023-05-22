package com.galacticstudio.parcialjoseguidos.ui.lake.addlake

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.galacticstudio.parcialjoseguidos.databinding.FragmentAddLagoBinding
import com.galacticstudio.parcialjoseguidos.ui.lake.viewmodel.LakeViewModel

class AddLagoFragment : Fragment() {

    private lateinit var binding: FragmentAddLagoBinding

    private val viewModel: LakeViewModel by activityViewModels {
        LakeViewModel.Factory
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentAddLagoBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setViewModel()
        observeStatus()
    }

    private fun setViewModel() {
        binding.viewmodel = viewModel
    }

    private fun observeStatus(){
        viewModel.status.observe(viewLifecycleOwner){status->
            when{
                status.equals(LakeViewModel.LAKE_CREATED) ->{
                    Log.d("APP_TAG", status)
                    Log.d("APP_TAG", viewModel.getLakes().toString())

                    viewModel.clearStatus()
                    viewModel.clearData()
                    findNavController().popBackStack()
                }
                status.equals(LakeViewModel.WRONG_DATA) ->{
                    Log.d("APP_TAG", status)
                    viewModel.clearStatus()
                }
            }
        }
    }

}