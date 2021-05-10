package com.example.titipanallah

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Filter
import android.widget.Filterable
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_produk.view.*


class produkAdapter (val context: Context):
                        RecyclerView.Adapter<produkAdapter.ViewHolder>(), Filterable{

    var arrayList           = ArrayList<produk_model>()
    var produkListFilter    = ArrayList<produk_model>()

    fun setData(arrayList: ArrayList<produk_model>){
        this.arrayList          = arrayList
        this.produkListFilter   = arrayList
        notifyDataSetChanged()
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){

        fun bindItems(model : produk_model){
            //id pada item_produk xml
            itemView.namaproduk.text        =   model.nmProduk
            itemView.deskripsiproduk.text   =   model.dsProduk
            itemView.hargaproduk.text       =   model.hargaProduk.toString()
            itemView.imgproduk.setImageResource(model.picProduk)

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val V = LayoutInflater.from(parent.context).inflate(R.layout.activity_produk, parent, false)
        return produkAdapter.ViewHolder(V)
    }

    override fun getItemCount(): Int {
        return arrayList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindItems(arrayList[position])

        holder.itemView.setOnClickListener(){
            val model = arrayList.get(position)

            var gProduct 	: String 	= model.nmProduk
            var gDesc   	: String 	= model.dsProduk
            var gPrice  	: Int    	= model.hargaProduk.toString().toInt()
            var gImg    	: Int    	= model.picProduk

            val intent = Intent(context, order::class.java)
            intent.putExtra("pProduct", 	gProduct)
            intent.putExtra("pDesc",   	gDesc)
            intent.putExtra("pPrice",  	gPrice)
            intent.putExtra("pImg",    	gImg)

            context.startActivity(intent)
        }
    }

    override fun getFilter(): Filter {
        return object :Filter(){
            override fun performFiltering(charSequence: CharSequence?): FilterResults {
                val filterResults = FilterResults()
                if (charSequence == null || charSequence.length < 0){
                    filterResults.count = produkListFilter.size
                    filterResults.values= produkListFilter
                } else {
                    var searchChr = charSequence.toString()
                    val productSearch = ArrayList<produk_model>()
                    for (item in produkListFilter){
                        if (item.nmProduk.toLowerCase().contains(searchChr) ||item.dsProduk.toLowerCase().contains(searchChr)){
                            productSearch.add(item)
                        }
                    }
                    filterResults.count = productSearch.size
                    filterResults.values= productSearch
                }
                return filterResults
            }

            override fun publishResults(p0: CharSequence?, filterResults: FilterResults?) {
                arrayList = filterResults!!.values as ArrayList<produk_model>
                notifyDataSetChanged()
            }
        }
    }
}

