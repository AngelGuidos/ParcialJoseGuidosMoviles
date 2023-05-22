package com.galacticstudio.parcialjoseguidos.ui.lake.billboard

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.galacticstudio.parcialjoseguidos.R
import com.galacticstudio.parcialjoseguidos.data.models.LakeModel
import com.galacticstudio.parcialjoseguidos.databinding.FragmentBillboardBinding
import com.galacticstudio.parcialjoseguidos.ui.lake.billboard.recyclerview.LakeRecyclerViewAdapter
import com.galacticstudio.parcialjoseguidos.ui.lake.viewmodel.LakeViewModel

class BillboardFragment : Fragment() {

    private lateinit var binding: FragmentBillboardBinding

    private lateinit var adapter: LakeRecyclerViewAdapter

    private val lakeViewModel : LakeViewModel by activityViewModels {
        LakeViewModel.Factory
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentBillboardBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setRecyclerView(view)

        binding.actionToAdd.setOnClickListener{
            findNavController().navigate(R.id.action_billboardFragment_to_addLagoFragment)
        }
    }

    private fun setRecyclerView(view: View){
        binding.lakeRv.layoutManager = LinearLayoutManager(view.context)

        adapter = LakeRecyclerViewAdapter { selectedLake ->
            showSelctedItem(selectedLake)
        }

        binding.lakeRv.adapter = adapter
        displayLakes()
    }

    private fun showSelctedItem(lake: LakeModel){
        lakeViewModel.setSelectedItem(lake)
        Log.d("APP_TAG", lake.name)
        findNavController().navigate(R.id.action_billboardFragment_to_lagoFragment)
    }

    private fun displayLakes(){
        adapter.setData(lakeViewModel.getLakes())
        adapter.notifyDataSetChanged()
    }
}