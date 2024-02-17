package com.example.kriiyetahackathon.recyclerview

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.kriiyetahackathon.databinding.RecyclerViewLayoutFileBinding

class RecycleViewAdapter(val context: Context, private val arrContact: ArrayList<RecyclerViewArraylist>) :
    RecyclerView.Adapter<RecycleViewAdapter.ViewHolder>() {

    class ViewHolder(private val binding:RecyclerViewLayoutFileBinding) : RecyclerView.ViewHolder(binding.root) {
        val img=binding.imgBadge
        val carbonno=binding.txtCarbon
        val name=binding.txtName
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view= RecyclerViewLayoutFileBinding.inflate(LayoutInflater.from((parent.context)),parent,false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return arrContact.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.img.setImageResource(arrContact[position].badge)
        holder.carbonno.text=arrContact[position].carbonnumber
        holder.name.text=arrContact[position].name


    }
}
