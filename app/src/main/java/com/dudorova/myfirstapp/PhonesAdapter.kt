package com.dudorova.myfirstapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
//import androidx.recyclerview.widget.RecyclerView.ViewHolder
import kotlinx.android.synthetic.main.recyclerview_item.view.*


class PhoneAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private var mPhonesList: ArrayList<PhoneModel> = ArrayList()

    fun setupPhones(phoneList: ArrayList<PhoneModel>){
        mPhonesList.clear()
        mPhonesList.addAll(phoneList)
        notifyDataSetChanged()
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (holder is PhoneViewHolder){
            holder.bind(mPhones = mPhonesList[position])
        }
    }

    override fun getItemCount(): Int {
        return mPhonesList.count()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val itemView = layoutInflater.inflate(R.layout.recyclerview_item, parent, false)
        return PhoneViewHolder(itemView)
    }

    class PhoneViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){

        fun bind(mPhones: PhoneModel){
            itemView.name_text_view.text = mPhones.name
            itemView.launch_price_value_text_view.text = mPhones.price
            itemView.launch_date_value_text_view.text = mPhones.date
            itemView.camera_score_value_text_view.text = mPhones.score
        }

    }

}