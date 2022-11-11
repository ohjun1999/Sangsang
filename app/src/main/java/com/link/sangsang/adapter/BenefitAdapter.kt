package com.link.sangsang.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.link.sangsang.R
import com.link.sangsang.activity.BenefitDetailActivity
import com.link.sangsang.dataclass.BenefitDataClass

class BenefitAdapter(val context: Context, var benefitList: ArrayList<BenefitDataClass>) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private val deAd: ArrayList<BenefitDataClass> = arrayListOf()


    override fun onCreateViewHolder(parent: ViewGroup, position: Int): RecyclerView.ViewHolder {
        var view =
            LayoutInflater.from(parent.context).inflate(R.layout.item_benefit, parent, false)
        val benefit = benefitList[position]



        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        var viewHolder = (holder as BenefitAdapter.ViewHolder).itemView
        val benefit: BenefitDataClass = benefitList[position]
        holder.mainExplain.text = benefit.mainExplain.toString()
        holder.tag1.text = "#" + benefit.tag1.toString()
        holder.tag2.text = "#" + benefit.tag2.toString()
        holder.tag3.text = "#" + benefit.tag3.toString()
        holder.goDetail.setOnClickListener {
            val intent =
                Intent(holder.itemView.context, BenefitDetailActivity::class.java)
            intent.putExtra("mainImg", benefit.mainImg)
            intent.putExtra("logo", benefit.logo)
            intent.putExtra("company", benefit.company)
            intent.putExtra("sector", benefit.sector)
            intent.putExtra("comNum", benefit.comNum)
            intent.putExtra("membership1", benefit.membership1)
            intent.putExtra("membership2", benefit.membership2)
            intent.putExtra("membership3", benefit.membership3)
            intent.putExtra("membership4", benefit.membership4)
            intent.putExtra("companyLink", benefit.companyLink)
            ContextCompat.startActivity(holder.itemView.context, intent, null)
        }


//


    }

    override fun getItemCount(): Int {
        return benefitList.size
    }


    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        val mainExplain: TextView = itemView.findViewById(R.id.mainExplain)
        val tag1: TextView = itemView.findViewById(R.id.tag1)
        val tag2: TextView = itemView.findViewById(R.id.tag2)
        val tag3: TextView = itemView.findViewById(R.id.tag3)
        val goDetail: Button = itemView.findViewById(R.id.goDetail)
        val mainImg: ImageView = itemView.findViewById(R.id.mainImg)
    }

    fun replaceList(newList: MutableList<BenefitDataClass>) {
        benefitList = newList.toMutableList() as ArrayList<BenefitDataClass>
        //어댑터의 데이터가 변했다는 notify를 날린다
        notifyDataSetChanged()
    }
}
