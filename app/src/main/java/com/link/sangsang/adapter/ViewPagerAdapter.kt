package com.link.sangsang.adapter

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.link.sangsang.R

class ViewPagerAdapter(idolList: ArrayList<Int>,
                       val context: Context
) :
    RecyclerView.Adapter<ViewPagerAdapter.PagerViewHolder>() {
    var item = idolList

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = PagerViewHolder((parent))

    override fun getItemCount(): Int = item.size

    override fun onBindViewHolder(holder: PagerViewHolder, position: Int) {
        holder.idol.setImageResource(item[position])
        holder.itemView.setOnClickListener {

            Log.d("testNum",position.toString())
            when (position) {
                0 ->{
                    val intent = Intent(Intent.ACTION_VIEW, Uri.parse("http://www.moilsurok.shop/"))
                    context.startActivity(intent)
                }
                1 ->{
                    val intent = Intent(Intent.ACTION_VIEW, Uri.parse("http://linkpmo.co.kr/"))
                    context.startActivity(intent)
                }
                2 ->{
                    val intent = Intent(Intent.ACTION_VIEW, Uri.parse("https://blog.naver.com/kingbus7111"))
                    context.startActivity(intent)
                }
            }
        }
    }

    inner class PagerViewHolder(parent: ViewGroup) : RecyclerView.ViewHolder
        (LayoutInflater.from(parent.context).inflate(R.layout.idol_list_item, parent, false)) {

        val idol = itemView.findViewById<ImageView>(R.id.imageView_idol)
    }
}