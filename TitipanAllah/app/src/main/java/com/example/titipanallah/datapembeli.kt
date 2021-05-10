package com.example.titipanallah

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.ActionBar
import kotlinx.android.synthetic.main.activity_datapembeli.*
import kotlinx.android.synthetic.main.activity_nota.*
import kotlinx.android.synthetic.main.activity_order.*

class datapembeli : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_datapembeli)

        val actionBar: ActionBar? = supportActionBar
        actionBar!!.setDisplayHomeAsUpEnabled(true)
        actionBar!!.setDisplayShowHomeEnabled(true)

        //pembuatan variable intent pemanggilan ke class order

        val intent = intent

        val aProduct = intent.getStringExtra("nama")
        val aPrice = intent.getIntExtra("harga",0)
        val ajumlah = intent.getIntExtra("jumlah",0)
        val atot = intent.getIntExtra("total",0)

        actionBar.setTitle("Pembelian " + aProduct)

        trxnamaproduk1.text = aProduct
        trxharga1.text = aPrice.toString()
        trxjumlah1.text = ajumlah.toString()
        trxjumlahharga1.text = atot.toString()

        proses.setOnClickListener {
            val intent = Intent(this, nota::class.java)
            intent.putExtra("pembeli", nmpembeli.text.toString())
            intent.putExtra("noHp", nopembeli.text.toString())
            intent.putExtra("alamat", alamatpembeli.text.toString())
            intent.putExtra("nama", aProduct)
            intent.putExtra("harga", aPrice.toString().toInt())
            intent.putExtra("jumlah", ajumlah.toString().toInt())
            intent.putExtra("total", atot.toString().toInt())

            startActivity(intent)
            true
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}