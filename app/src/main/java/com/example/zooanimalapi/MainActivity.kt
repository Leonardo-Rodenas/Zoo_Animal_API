package com.example.zooanimalapi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.NavigationUI
import com.example.zooanimalapi.databinding.ActivityMainBinding
import com.example.zooanimalapi.viewmodel.AnimalsViewModel

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var navegador: NavController
    val vmodel: AnimalsViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        var navhost: NavHostFragment =
            supportFragmentManager.findFragmentById(R.id.fragContainer) as NavHostFragment
        navegador = navhost.navController;

        NavigationUI.setupActionBarWithNavController(this, navegador)
    }

    override fun onSupportNavigateUp(): Boolean {
        return NavigationUI.navigateUp(navegador, null)
    }
}