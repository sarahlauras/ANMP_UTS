package com.mlbdev.anmp_miniproject.view

import android.view.LayoutInflater
import androidx.recyclerview.widget.RecyclerView
import com.mlbdev.anmp_miniproject.model.DataUkur
import android.view.ViewGroup
import com.mlbdev.anmp_miniproject.databinding.DataListItemBinding


class DataListAdapter(val dataList: ArrayList<DataUkur>):RecyclerView.Adapter<DataListAdapter.DataViewHolder>(){
    class DataViewHolder(var binding: DataListItemBinding):RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DataViewHolder {
        val binding = DataListItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return DataViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return dataList.size
    }

    override fun onBindViewHolder(holder: DataViewHolder, position: Int) {
holder.binding.txtAge.text = dataList[position].umur.toString()
        holder.binding.txtHeight.text = dataList[position].tinggi.toString()
        holder.binding.txtWeight.text = dataList[position].berat.toString()
    }
}