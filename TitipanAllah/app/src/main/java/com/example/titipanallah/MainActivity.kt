package com.example.titipanallah

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.widget.SearchView
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.navigation.NavigationView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    //initialize
    private lateinit var drawerLayout: DrawerLayout
    private lateinit var actionBarToggle: ActionBarDrawerToggle
    private lateinit var navDrawerView: NavigationView

    //intialize the navigation
    private lateinit var bottomNavigation: BottomNavigationView

    var myAdapter: produkAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val arrayItem = ArrayList<produk_model>()
        arrayItem.add(
            produk_model(
                "VANS ANAHEIM CHECKERBOARD",
                "The Anaheim Factory Old Skool 36 DX pays tribute to our first Vans factory in Anaheim, California, by borrowing details from the original Old Skool and offering modernized comfort with upgraded Ortholite® sockliners.",
                R.drawable.vansanaheim_checkerboard,
                700000
            )
        )
        arrayItem.add(
            produk_model(
                "VANS AUTHENTIC ANAHEIM BLACK/WHITE",
                "The Anaheim Factory Old Skool 36 DX pays tribute to our first Vans factory in Anaheim, California, by borrowing details from the original Old Skool and offering modernized comfort with upgraded Ortholite® sockliners.",
                R.drawable.vansauthenticanaheim_black,
                800000
            )
        )
        arrayItem.add(
            produk_model(
                "VANS X AUTISM AWARNESS",
                "Vans shines a light on Autism Awareness with a collection of sensory-friendly footwear and apparel.",
                R.drawable.vansautis_blue,
                700000
            )
        )
        arrayItem.add(
            produk_model(
                "VANS SLIP-ON BLACK CHERRIES",
                "canvas and suede uppers with embroidery",
                R.drawable.vanscherys_black,
                700000
            )
        )
        arrayItem.add(
            produk_model(
                "VANS SPORT (RETRO SPORT) BISTRO GREEN/MARSHMALLOW",
                "The Retro Sport Vans Sport is a retro lace-up style featuring sturdy canvas uppers with leather accents, old school V side stripes, padded collars, and signature rubber waffle out soles.",
                R.drawable.vansepoch_green,
                850000
            )
        )
        arrayItem.add(
            produk_model(
                "VANS ERA NAVY",
                "The Era, Vans classic low top lace-up skate shoe, has a durable double-stitched canvas upper with padded tongue and lining and Vans signature Waffle Outsole.",
                R.drawable.vansera_navy,
                600000
            )
        )
        arrayItem.add(
            produk_model(
                "VANS AUTHENTIC (THANK YOU FLORAL)",
                "Stay blessed in prolific style with the Authentic Thank You black and floral skate shoes from Vans",
                R.drawable.vansfloral_black,
                700000
            )
        )
        arrayItem.add(
            produk_model(
                "VANS OLDSKOOL ANAHEIM BLACK",
                "The Anaheim Factory Old Skool 36 DX pays tribute to our first Vans factory in Anaheim, California, by borrowing details from the original Old Skool and offering modernized comfort with upgraded Ortholite® sockliners.",
                R.drawable.vansoldskoolanaheim_black,
                800000
            )
        )
        arrayItem.add(
            produk_model(
                "VANS SK8-HI (66 SUPPLY) ANTIQUE WHITE/BLACK",
                "The 66 Supply Sk8-Hi combines the legendary Vans lace-up high top with sturdy suede and textile uppers, printed sidewalls, and re-enforced toe caps to withstand repeated wear.",
                R.drawable.vanssk8hi_white,
                950000
            )
        )
        arrayItem.add(
            produk_model(
                "VANS SK8-LOW BLACK/WHITE",
                "The Sk8-Low, a takedown of the legendary Vans high top skate shoe, is built with an array of colors and materials to provide a familiar Sk8-Hi aesthetic in a low top shoe.",
                R.drawable.vanssk8low_black,
                899000
            )
        )
        arrayItem.add(
            produk_model(
                "VANS ANAHEIM FACTORY OLD SKOOL 36 DX SHOES OG LIGHT BLUE/OG PURPLE/OG PINK",
                "The Anaheim Factory Old Skool 36 DX pays tribute to our first Vans factory in Anaheim, California, by borrowing details from the original Old Skool and offering modernized comfort with upgraded Ortholite® sockliners.",
                R.drawable.vansanaheim_pink,
                839000
            )
        )

        myAdapter = produkAdapter(this)
        myAdapter!!.setData(arrayItem)

        //Product_RecyclerView berasal dari id recyclerView pada activity_main.xml
        Produk_RecycleView.layoutManager = LinearLayoutManager(this)
        Produk_RecycleView.adapter = myAdapter

        bottomNavigation = findViewById(R.id.navbottom)
        bottomNavigation.setOnNavigationItemReselectedListener {
            when (it.itemId) {
                R.id.home -> {
                    val intent = Intent(applicationContext, MainActivity::class.java)
                    startActivity(intent)
                    true
                }
                R.id.history -> {
                    Toast.makeText(this, "Pergi Ke Riwayat Belanja", Toast.LENGTH_SHORT).show()
                    true
                }
                else -> {
                    false
                }
            }
        }


        drawerLayout = findViewById(R.id.drawer)

        //call
        actionBarToggle = ActionBarDrawerToggle(
            this, drawerLayout,
            0,
            0
        )

        drawerLayout.addDrawerListener(actionBarToggle)

        //display
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        //call
        actionBarToggle.syncState()

        //call
        navDrawerView = findViewById(R.id.navDrawer)

        //call
        navDrawerView.setNavigationItemSelectedListener { menuItem ->
            when (menuItem.itemId) {
                R.id.myProfile -> {
                    val intent = Intent(applicationContext, profil::class.java)
                    startActivity(intent)
                    true
                }
                R.id.myContact -> {
                    Toast.makeText(this, "kontak", Toast.LENGTH_SHORT).show()
                    true
                }
                R.id.myHelp -> {
                    Toast.makeText(this, "Pusat Bantuan", Toast.LENGTH_SHORT).show()
                    true
                }
                else -> {
                    false
                }
            }
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        if (this.drawerLayout.isDrawerOpen(GravityCompat.START)) {
            this.drawerLayout.closeDrawer(GravityCompat.START)
        } else {
            this.drawerLayout.openDrawer(GravityCompat.START)
        }
        return true
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.toolbar_menu, menu)

        val searchitem = menu?.findItem(R.id.search)
        if (searchitem != null) {
            val searchView = searchitem.actionView as SearchView
            searchView.maxWidth = Int.MAX_VALUE
            searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {

                override fun onQueryTextSubmit(p0: String?): Boolean {
                    return true
                }

                override fun onQueryTextChange(filterString: String?): Boolean {
                    myAdapter!!.filter.filter(filterString)
                    return true
                }
            })
        }
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val id = item.itemId
        if (id == R.id.shopping) {
            Toast.makeText(this, "Lihat keranjang", Toast.LENGTH_SHORT).show()
            return true
        } else if (id == R.id.account) {
            Toast.makeText(this, "Akun Diklik", Toast.LENGTH_SHORT).show()
            return true
        } else if (id == R.id.logout) {
            val  intent = Intent(this, login::class.java)
            startActivity(intent)
            Toast.makeText(this, "Keluar, Silahkan Masuk", Toast.LENGTH_SHORT).show()
            return true
        }
        return super.onOptionsItemSelected(item)
    }
}
