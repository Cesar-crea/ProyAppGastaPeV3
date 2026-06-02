package com.example.appgastape

import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.drawerlayout.widget.DrawerLayout
import com.google.android.material.navigation.NavigationView

class MisGastosActivity : AppCompatActivity() {
    private lateinit var dlMenu : DrawerLayout
    private lateinit var ivMenu : ImageView
    private lateinit var nvMenu : NavigationView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_mis_gastos)

        dlMenu = findViewById<DrawerLayout>(R.id.dlMenu)
        ivMenu = findViewById<ImageView>(R.id.ivMenu)
        nvMenu = findViewById<NavigationView>(R.id.nvMenu)

        ivMenu.setOnClickListener {
            dlMenu.open()
        }

        nvMenu.setNavigationItemSelectedListener { menuItem ->

            when (menuItem.itemId) {

                R.id.itCategoria -> {

                    val intent = Intent(this, CategoriasActivity::class.java)
                    startActivity(intent)

                }
                R.id.itGasto -> {

                    val intent =    Intent(this, com.example.appgastape.MisGastosActivity::class.java)
                    startActivity(intent)
                }

            }
            true
        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.dlMenu)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}