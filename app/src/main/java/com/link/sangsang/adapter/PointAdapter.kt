package com.link.sangsang.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.link.sangsang.R
import com.link.sangsang.activity.PointDetailActivity
import com.link.sangsang.dataclass.PointDataClass

class PointAdapter(val context: Context, var pointList: ArrayList<PointDataClass>) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private val deAd: ArrayList<PointDataClass> = arrayListOf()


    override fun onCreateViewHolder(parent: ViewGroup, position: Int): RecyclerView.ViewHolder {
        var view =
            LayoutInflater.from(parent.context).inflate(R.layout.item_point, parent, false)
        val point = pointList[position]



        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        var viewHolder = (holder as PointAdapter.ViewHolder).itemView
        val point: PointDataClass = pointList[position]
        var img = point.pointImg

        when (point.pointName.toString()) {
            "킹버스" -> holder.pointImg.setImageResource(R.drawable.ic_kingbus_logo)

            "PMO" -> holder.pointImg.setImageResource(R.drawable.ic_pmo_logo)

            "모일수록" -> holder.pointImg.setImageResource(R.drawable.ic_moilsurok)

            "RATEL" -> holder.pointImg.setImageResource(R.drawable.ic_ratel_logo)
        }



        holder.itemView.setOnClickListener {
            val intent =
                Intent(holder.itemView.context, PointDetailActivity::class.java)
            intent.putExtra("pointName", point.pointName)

            ContextCompat.startActivity(holder.itemView.context, intent, null)
        }


    }

    override fun getItemCount(): Int {
        return pointList.size
    }


    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {


        val pointImg: ImageView = itemView.findViewById(R.id.pointImg)
    }

    fun replaceList(newList: MutableList<PointDataClass>) {
        pointList = newList.toMutableList() as ArrayList<PointDataClass>
        //어댑터의 데이터가 변했다는 notify를 날린다
        notifyDataSetChanged()
    }
}
