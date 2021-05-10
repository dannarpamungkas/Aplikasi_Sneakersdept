package com.example.titipanallah

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_login.*

class login : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
    }

    fun loginMasuk(view: View){
        val Uname = idlogin.text.toString()
        val Upass = passlogin.text.toString()

        if(Uname.isEmpty() || Upass.isEmpty()){
            Toast.makeText(this, "Masukkan Nama Pengguna atau Kata Sandi Dahulu", Toast.LENGTH_SHORT).show()
        }else if (Uname.toLowerCase() == "dannar" && Upass.toLowerCase()== "1234"){
            Toast.makeText(this, "Berhasil Masuk", Toast.LENGTH_SHORT).show()

            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            true
        }else{
            Toast.makeText(this, "Nama Pengguna atau Kata Sandi salah", Toast.LENGTH_SHORT).show()
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}