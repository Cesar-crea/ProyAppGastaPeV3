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

    private lateinit var ivRegresar: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_mis_gastos)

        ivRegresar = findViewById(R.id.imgRegresar)

        ivRegresar.setOnClickListener {
            finish()
        }
    }
}