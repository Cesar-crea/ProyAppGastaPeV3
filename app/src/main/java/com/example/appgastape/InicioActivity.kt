package com.example.appgastape

import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.navigation.NavigationView

class InicioActivity : AppCompatActivity() {

    private lateinit var dlMenu: DrawerLayout
    private lateinit var ivMenu: ImageView
    private lateinit var nvMenu: NavigationView
    private lateinit var vistaNavegacionInferior: BottomNavigationView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        enableEdgeToEdge()
        setContentView(R.layout.activity_inicio)

        dlMenu = findViewById(R.id.dlMenu)
        ivMenu = findViewById(R.id.ivMenu)
        nvMenu = findViewById(R.id.nvMenu)
        vistaNavegacionInferior = findViewById(R.id.menu_inferior)

        ivMenu.setOnClickListener {
            dlMenu.open()
        }

        nvMenu.setNavigationItemSelectedListener { menuItem ->

            when (menuItem.itemId) {

                R.id.itCategoria -> {
                    startActivity(
                        Intent(
                            this,
                            CategoriasActivity::class.java
                        )
                    )
                }

                R.id.itInicio -> {
                    startActivity(
                        Intent(
                            this,
                            InicioActivity::class.java
                        )
                    )
                }
            }
            true
        }

        vistaNavegacionInferior.setOnItemSelectedListener { menuItem ->

            when (menuItem.itemId) {

                R.id.boton_inicio -> {
                    replaceFragment(FragmentoInicio())
                    true
                }

                R.id.boton_gastos -> {
                    startActivity(
                        Intent(this, MisGastosActivity::class.java)
                    )
                    true
                }

                R.id.boton_agregarGasto -> {
                    replaceFragment(FragmentoAgregarGasto())
                    true
                }

                R.id.boton_estadistica -> {
                    replaceFragment(FragmentoEstadistica())
                    true
                }

                R.id.boton_perfil -> {
                    replaceFragment(FragmentoPerfil())
                    true
                }

                else -> false
            }
        }

        // Fragmento inicial
        replaceFragment(FragmentoInicio())

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.dlMenu)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(
                systemBars.left,
                systemBars.top,
                systemBars.right,
                systemBars.bottom
            )
            insets
        }
    }

    private fun replaceFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.frame_container, fragment)
            .commit()
    }
}