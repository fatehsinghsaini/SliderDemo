package com.os.sliderdemo.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.os.sliderdemo.MainViewModel
import com.os.sliderdemo.R
import com.os.sliderdemo.databinding.FragmentHomeBinding

class HomeFragment :Fragment() {

    var mViewModel:MainViewModel?=null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

       val mView= DataBindingUtil.inflate<FragmentHomeBinding>(inflater, R.layout.fragment_home,container,false)
        mViewModel=ViewModelProvider(this).get(MainViewModel::class.java)
        return mView.root
    }

}