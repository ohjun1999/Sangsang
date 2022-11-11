package com.link.sangsang.adapter

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.link.sangsang.R
import com.link.sangsang.dataclass.PointDetailPmoDataClass

class PointDetailPmoAdapter(val context: Context, var pointList: ArrayList<PointDetailPmoDataClass>) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private val deAd: ArrayList<PointDetailPmoDataClass> = arrayListOf()


    override fun onCreateViewHolder(parent: ViewGroup, position: Int): RecyclerView.ViewHolder {
        var view =
            LayoutInflater.from(parent.context).inflate(R.layout.item_point_detail, parent, false)
        val point = pointList[position]



        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        var viewHolder = (holder as PointDetailPmoAdapter.ViewHolder).itemView
        val point: PointDetailPmoDataClass = pointList[position]


        holder.mainText.text = point.mainText
        holder.subText1.text = point.subText1
        holder.subText2.text = point.subText2

        when (point.pointName.toString()) {
            "킹버스" -> holder.logo.setImageResource(R.drawable.ic_kingbus_logo)

            "PMO" -> holder.logo.setImageResource(R.drawable.ic_pmo_logo)

            "모일수록" -> holder.logo.setImageResource(R.drawable.ic_moilsurok)

            "RATEL" -> holder.logo.setImageResource(R.drawable.ic_ratel_logo)
        }

        holder.itemView.setOnClickListener {
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse(point.link))
            context.startActivity(intent)    }


    }

    override fun getItemCount(): Int {
        return pointList.size
    }


    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        val logo: ImageView = itemView.findViewById(R.id.logo)
        val mainText: TextView = itemView.findViewById(R.id.mainText)
        val subText1: TextView = itemView.findViewById(R.id.subText1)
        val subText2: TextView = itemView.findViewById(R.id.subText2)
    }

    fun replaceList(newList: MutableList<PointDetailPmoDataClass>) {
        pointList = newList.toMutableList() as ArrayList<PointDetailPmoDataClass>
        //어댑터의 데이터가 변했다는 notify를 날린다
        notifyDataSetChanged()
    }
}
