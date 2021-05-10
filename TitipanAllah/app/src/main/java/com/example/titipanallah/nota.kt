package com.example.titipanallah

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.ActionBar
import kotlinx.android.synthetic.main.activity_nota.*


class nota : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_nota)


        val actionBar: ActionBar? = supportActionBar
        actionBar!!.setDisplayHomeAsUpEnabled(true)
        actionBar!!.setDisplayShowHomeEnabled(true)

        var intent = intent

        val aNama   = intent.getStringExtra("pembeli")
        val aNo     = intent.getStringExtra("noHp")
        val aAlamat = intent.getStringExtra("alamat")
        val aproduk = intent.getStringExtra("nama")
        val aharga = intent.getIntExtra("harga", 0)
        val ajumlah = intent.getIntExtra("jumlah", 0)
        val atot = intent.getIntExtra("total", 0)


        actionBar.setTitle("Nota "+aproduk)

        namapembeli.text       = aNama
        nohppembeli.text       = aNo
        almtpembeli.text       = aAlamat
        trxnamaproduk.text     = aproduk
        trxharga.text          = aharga.toString()
        trxjumlah.text         = ajumlah.toString()
        trxjumlahharga.text    = atot.toString()
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }

}