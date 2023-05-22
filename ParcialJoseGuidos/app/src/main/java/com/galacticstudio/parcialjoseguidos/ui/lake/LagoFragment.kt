package com.galacticstudio.parcialjoseguidos.ui.lake

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import com.galacticstudio.parcialjoseguidos.R
import com.galacticstudio.parcialjoseguidos.databinding.FragmentLagoBinding
import com.galacticstudio.parcialjoseguidos.ui.lake.viewmodel.LakeViewModel


class LagoFragment : Fragment() {

    private lateinit var binding: FragmentLagoBinding

    private val lakeViewModel: LakeViewModel by activityViewModels {
        LakeViewModel.Factory
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentLagoBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.viewmodel = lakeViewModel
        binding.lifecycleOwner = viewLifecycleOwner
    }

}