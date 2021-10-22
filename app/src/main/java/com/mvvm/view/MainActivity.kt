package com.mvvm.view

import android.os.Bundle
import android.util.Log
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.mvvm.R
import com.mvvm.base.BaseActivity
import com.mvvm.view.adapter.PokemonAdapter
import com.mvvm.viewmodel.MainViewModel
import org.koin.android.viewmodel.ext.android.viewModel

class MainActivity : BaseActivity() {
    private val viewModel by viewModel<MainViewModel>()

    private lateinit var pokemonAdapter: PokemonAdapter

    var pokemonList: RecyclerView? = null

    override fun getLayoutResourceId(): Int = R.layout.activity_main

    override fun initView(savedInstanceState: Bundle?) {
        pokemonList = findViewById<RecyclerView>(R.id.recyclerView)
        pokemonList?.layoutManager = GridLayoutManager(this, 2)
//        pokemonList?.layoutManager = LinearLayoutManager(this)

        pokemonAdapter = PokemonAdapter(this)
        pokemonList?.adapter = pokemonAdapter
        viewModel.load()

    }

    override fun initListener() {

    }

    override fun initObserver() {

        viewModel.resultPokemon.observe(this, Observer {result ->
            result?.let {
                if (it.status==1){
                    it.pokemon?.let { list ->
                        if (list.size > 0){
                            Log.i("AA","status 1 list : ${list.size}")
                            pokemonAdapter.swap(list)
                        }else{
                            //dont have
                            Log.i("AA","status 1 list : ${list.size}")
                        }
                    }
                }else if(it.status==2){
                    //loading
                    Log.i("AA","status 2")
                }
            }
        })
    }
}