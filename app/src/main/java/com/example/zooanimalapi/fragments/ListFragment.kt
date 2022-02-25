package com.example.zooanimalapi.fragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.zooanimalapi.R
import com.example.zooanimalapi.adapterRV.adapterRV
import com.example.zooanimalapi.databinding.FragmentListBinding
import com.example.zooanimalapi.model.AnimalListItem
import com.example.zooanimalapi.viewmodel.AnimalsViewModel
import com.example.zooanimalapi.viewmodel.Factory

class ListFragment : Fragment() {

    private var _binding: FragmentListBinding? = null
    private val binding get() = _binding!!
    private lateinit var vmodel: AnimalsViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentListBinding.inflate(inflater, container, false)


        vmodel = Factory(requireActivity().application).create(AnimalsViewModel::class.java)
        var adapter = adapterRV()

        with(binding)
        {

            rvListaMonedas.layoutManager = LinearLayoutManager(context)
            rvListaMonedas.adapter = adapter

            vmodel.traemeLoDelServer()

            adapter.setOnItemClickListener(object : adapterRV.listenerParaClickEnRV {
                override fun alClickearAnimal(animal: AnimalListItem) {
                    var miBundle = Bundle()
                    miBundle.putSerializable("animal", animal)


                    findNavController().navigate(
                        R.id.action_listFragment_to_detailFragment,
                        miBundle
                    )
                }

            })

            vmodel.exponeDatosDeDB().observe(viewLifecycleOwner, Observer {

                Log.v("recyclerview", it.toString())
                adapter.setearListener(it)

            })

        }

        return binding.root
    }

}