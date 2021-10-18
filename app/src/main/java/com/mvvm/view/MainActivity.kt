package com.mvvm.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.mvvm.R
import com.mvvm.base.BaseActivity
import com.mvvm.viewmodel.MainViewModel
import org.koin.android.viewmodel.ext.android.viewModel

class MainActivity : BaseActivity() {
    private val viewModel by viewModel<MainViewModel>()

    override fun getLayoutResourceId(): Int = R.layout.activity_main

    override fun initView(savedInstanceState: Bundle?) {
        viewModel.load()
    }

    override fun initListener() {

    }

    override fun initObserver() {

    }
}