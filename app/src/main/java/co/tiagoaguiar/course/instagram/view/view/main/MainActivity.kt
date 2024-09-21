package co.tiagoaguiar.course.instagram.view.view.main

import android.os.Bundle
import android.view.ViewGroup
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.view.marginBottom
import androidx.core.view.marginTop
import androidx.core.view.setPadding
import co.tiagoaguiar.course.instagram.R
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())

//            // Obtém a referência do BottomNavigationView
//            val bottomNavView = findViewById<BottomNavigationView>(R.id.bottom_nav_profile)
//
//            // Evite definir padding diretamente no BottomNavigationView que pode aumentar sua altura
//            val layoutParams = bottomNavView.layoutParams as ViewGroup.MarginLayoutParams
//
//            // Aplica a margem inferior para compensar a barra de navegação do sistema sem alterar o padding
//            layoutParams.bottomMargin = systemBars.bottom
//            bottomNavView.layoutParams = layoutParams

            v.setPadding(systemBars.left, systemBars.top, systemBars.right,0)
            insets
        }
    }
}