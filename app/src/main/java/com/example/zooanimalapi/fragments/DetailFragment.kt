package com.example.zooanimalapi.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import coil.load
import com.example.zooanimalapi.R
import com.example.zooanimalapi.databinding.FragmentDetailBinding
import com.example.zooanimalapi.model.AnimalListItem
import com.example.zooanimalapi.viewmodel.AnimalsViewModel


class DetailFragment : Fragment() {

    private var _binding: FragmentDetailBinding? = null
    private val binding get() = _binding!!
    lateinit var vmodel: AnimalsViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentDetailBinding.inflate(inflater, container, false)

        var recuperarAnimalClickeado = arguments?.getSerializable("animal") as AnimalListItem

        binding.nombreAnimalDetalle.text = recuperarAnimalClickeado.name
        binding.nombreLatin.text = recuperarAnimalClickeado.latin_name
        binding.tipoDetalle.text = recuperarAnimalClickeado.animal_type
        binding.actividadDetalle.text = recuperarAnimalClickeado.active_time
        binding.longitudMinDetalle.text = recuperarAnimalClickeado.length_min
        binding.longitudMaxDetalle.text = recuperarAnimalClickeado.length_max
        binding.pesoMinDetalle.text = recuperarAnimalClickeado.weight_min
        binding.pesoMaxDetalle.text = recuperarAnimalClickeado.weight_max
        binding.vidaDetalle.text = recuperarAnimalClickeado.lifespan
        binding.habitatDetalle.text = recuperarAnimalClickeado.habitat
        binding.dietaDetalle.text = recuperarAnimalClickeado.diet
        binding.localizacionDetalle.text = recuperarAnimalClickeado.geo_range

        binding.ivDetalle.load(recuperarAnimalClickeado.image_link)

        return binding.root
    }

}