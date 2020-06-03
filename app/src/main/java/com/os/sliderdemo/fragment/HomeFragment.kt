package com.os.sliderdemo.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.os.sliderdemo.MainViewModel
import com.os.sliderdemo.R
import com.os.sliderdemo.adapter.SliderAdapter
import com.os.sliderdemo.apiutils.requestModel.ApiResponse
import com.os.sliderdemo.apiutils.requestModel.ClickResponse
import kotlinx.android.synthetic.main.fragment_home.*
import kotlinx.android.synthetic.main.fragment_home.view.*


class HomeFragment :Fragment(),View.OnClickListener {

    var mViewModel:MainViewModel?=null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
       val mView= inflater.inflate(R.layout.fragment_home,container,false)
        mViewInit(mView)
        mInitResponse()
        return mView
    }

    private fun mInitResponse() {

        mViewModel?.mResponseLiveData?.observe(activity!!, Observer {
            mClickResponse(it)
        })
    }

    private fun mClickResponse(it: ApiResponse<ClickResponse>) {
        when(it.status){
           ApiResponse.Status.ERROR ->
            Toast.makeText(activity,getString(R.string.error_in_api),Toast.LENGTH_SHORT).show()
            ApiResponse.Status.SUCCESS -> Toast.makeText(activity,it.data?.data?.rstr,Toast.LENGTH_SHORT).show()
        }
    }

    private fun mViewInit(mView: View) {
        mViewModel=ViewModelProvider(this).get(MainViewModel::class.java)

        mView.button1.setOnClickListener(this)
        mView.button2.setOnClickListener(this)
        mView.button3.setOnClickListener(this)
        mView.button4.setOnClickListener(this)

        //adapter
        val mList=ArrayList<String>()
        mList.add("First")
        mList.add("Second")
        mList.add("Third")
        mList.add("Forth")
        val mAdapter=SliderAdapter(mList)
        mView.recyclerView.adapter=mAdapter
    }

    override fun onClick(p0: View?) {
        when(p0){
            button1 -> mViewModel?.mApiCalling(button1.text.toString())
            button2 -> mViewModel?.mApiCalling(button2.text.toString())
            button3 -> mViewModel?.mApiCalling(button3.text.toString())
            button4 -> mViewModel?.mApiCalling(button4.text.toString())
        }

    }

}