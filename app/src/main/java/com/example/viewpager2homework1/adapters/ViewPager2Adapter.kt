package com.example.viewpager2homework1.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.viewpager2homework1.databinding.ItemViewPagerBinding
import com.example.viewpager2homework1.models.User
import java.util.ArrayList

class ViewPager2Adapter(val list: ArrayList<User>):RecyclerView.Adapter<ViewPager2Adapter.VH>() {
    inner class VH(val itemViewPagerBinding: ItemViewPagerBinding):RecyclerView.ViewHolder(itemViewPagerBinding.root){
        fun onBind(user: User){
            itemViewPagerBinding.backItem.setBackgroundResource(user.back)
            itemViewPagerBinding.itemTxtname.text = user.name
            itemViewPagerBinding.itemTxtinfo.text = user.info
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VH {
        return VH(ItemViewPagerBinding.inflate(LayoutInflater.from(parent.context),parent,false))
    }

    override fun getItemCount(): Int = list.size

    override fun onBindViewHolder(holder: VH, position: Int) {
        holder.onBind(list[position])
    }
}