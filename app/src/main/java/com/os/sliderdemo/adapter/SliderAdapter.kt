package com.os.sliderdemo.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.os.sliderdemo.R
import kotlinx.android.synthetic.main.slider_item.view.*

class SliderAdapter(var mList:ArrayList<String>) : RecyclerView.Adapter<SliderAdapter.MyView>() {
    class MyView(myView: View):RecyclerView.ViewHolder(myView){
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyView {
       val mView= LayoutInflater.from(parent.context).inflate(R.layout.slider_item,parent,false)


        val layoutParams: ViewGroup.LayoutParams = mView.layoutParams
        layoutParams.width = (parent.width * 0.7).toInt()
        mView.layoutParams = layoutParams

        return MyView(mView)
    }

    override fun getItemCount(): Int {
       return mList.size
    }

    override fun onBindViewHolder(holder: MyView, position: Int) {
        holder.itemView.name.text=mList[position]

    }

}