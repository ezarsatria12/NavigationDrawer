package com.nunuzy.mynavigationdrawer

import android.os.Bundle
import android.view.Menu
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.drawerlayout.widget.DrawerLayout
import androidx.navigation.findNavController
import androidx.navigation.ui.*

import com.bumptech.glide.Glide
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.navigation.NavigationView
import com.google.android.material.snackbar.Snackbar

import de.hdodenhof.circleimageview.CircleImageView

class MainActivity : AppCompatActivity() {

    private lateinit var appBarConfiguration: AppBarConfiguration

    internal lateinit var profileCircleImageView: CircleImageView
    internal var profileImageUrl =
            "https://lh3.googleusercontent.com/-a6LNLruLhXA/XpfIxdNbxKI/AAAAAAAABa0/UtVrmAP3u7krMnmZd__5UBTnjMwvsvxXACEwYBhgLKtQDAL1OcqwS4DYzNR7c10kGHQlZMQgYn0Dl07k24nvxGTqMAPp9RZpgEABGNGZW_x0u-dQnlAaYhmP_Hx-qJGOdnIk59ga029noH-lAf5AB5C8FnsXf2dEvV003qmMQN6bPvho5e_0_-iMUgJsyttC6rz3Pf3bFWfOml7Ustu7BCb7_HO2AyisC-I4VsiYKErFu68V_nQZ1XRqozSC2iNCpy0KjrKwqrG2mJE4EbhHhFJoOXbidMTYbmqwhce-TVcWDJLhaQdUabYO61T-zuzG2JqFdav4kW2CzBJ0wVxNURMDZtzBTvJPAtMPuWiNusE8AE5NPhZWh49SLyrp9-E-ldhBWEulbFgFpP7_xSihhsdmuT_nPHkprCqniNAiA4_p0qPnSPva8sCBgWrdBD_AGozJT91avNXIe6u6RLiQ0mFrK7VBDdRcBLHnd6A2yo3APYO-RVFTvJA8dDOeCG6VB8eUKhuyb61ii5appUjYcHIrB2vR7M2da8-5iFszB5u-yaxfY2teg9MuKDkllkhG-H3ZXH0RwLmpiobzwAaG_DD47G4V6YoKmqx_fNDScnKRvDsDkHrh3Pnr3o4sad-s9m5ShA34BhrpXzaUcUYoabHy7DJTRMNibg_4F/w140-h140-p/peti.jpg"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val toolbar: Toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)

        val fab: FloatingActionButton = findViewById(R.id.fab)
        fab.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                    .setAction("Action") {
                        Toast.makeText(
                                this@MainActivity,
                                "Halo ini action dari snackbar",
                                Toast.LENGTH_SHORT
                        ).show()
                    }.show()
        }
        val drawerLayout: DrawerLayout = findViewById(R.id.drawer_layout)
        val navView: NavigationView = findViewById(R.id.nav_view)
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.

        profileCircleImageView = navView.getHeaderView(0).findViewById(R.id.imageView)
        Glide.with(this)
                .load(profileImageUrl)
                .into(profileCircleImageView)

        appBarConfiguration = AppBarConfiguration.Builder(
                R.id.nav_home, R.id.nav_gallery, R.id.nav_slideshow,
                R.id.nav_tools, R.id.nav_share, R.id.nav_send, R.id.nav_cart)
                .setDrawerLayout(drawerLayout)
                .build()

        val navController = findNavController(R.id.nav_host_fragment)
        setupActionBarWithNavController(navController, appBarConfiguration)
        navView.setupWithNavController(navController)
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.main, menu)
        return true
    }

    override fun onSupportNavigateUp(): Boolean {
        val navController = findNavController(R.id.nav_host_fragment)
        return navController.navigateUp(appBarConfiguration) || super.onSupportNavigateUp()
    }
}
