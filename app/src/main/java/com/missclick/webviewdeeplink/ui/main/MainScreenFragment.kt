package com.missclick.webviewdeeplink.ui.main

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import com.missclick.webviewdeeplink.R

class MainScreenFragment : Fragment() {

    companion object {
        fun newInstance() =
            MainScreenFragment()
    }

    private lateinit var viewModel: MainScreenViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(MainScreenViewModel::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.main_screen_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.okHttp()
//        viewModel.simpleLiveData.observe(viewLifecycleOwner, Observer {
//            Log.e("Main", it.error.toString())
//        })
//        viewModel.getUsers(1)
    }


}