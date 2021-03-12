package com.example.swwiki.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import com.example.swwiki.R
import com.example.swwiki.model.FirstResponse
import com.example.swwiki.ui.adapter.InitialMenuAdapter
import com.example.swwiki.viewmodel.InitialMenuViewModel
import kotlinx.android.synthetic.main.activity_initial_menu.*
import java.util.ArrayList

class InitialMenuActivity : AppCompatActivity() {

    lateinit var initialMenuViewModel : InitialMenuViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_initial_menu)

        initialMenuViewModel = InitialMenuViewModel()
        initialMenuViewModel.getFirstResponse()?.observe(this, Observer { firstResponse ->
            Log.e("Resposta: ", "$firstResponse")
        })

        val lista: List<String> = listOf<String>("People","Planets","Species","Vehicles","Films","Starships")
        val initialMenuAdapter = InitialMenuAdapter(this, lista)
        val layoutManager = GridLayoutManager(this,2, GridLayoutManager.VERTICAL,false)

        rvInitialMenuItems.adapter = initialMenuAdapter
        rvInitialMenuItems.layoutManager = layoutManager




    }

}
