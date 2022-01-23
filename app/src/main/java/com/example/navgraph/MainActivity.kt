package com.example.navgraph

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import androidx.navigation.NavHost
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Находим основной нафигационный контролер (область куда помещаем фрагменты)
        val navController = findNavController(R.id.my_nav_host_fragment)
        //Находим нижнее меню
        val navBottom:BottomNavigationView = findViewById(R.id.navBottom)

        //Заполняем настройки для стыковки пунктов в нижнем меню и навигационным контролером
        //Выбираем только нужные нам фрагменты
        val appBarConfiguration = AppBarConfiguration(setOf(R.id.homeFragment, R.id.qrcodeFragment))

        //Переносим настройки в навигационный контролер
        setupActionBarWithNavController(navController, appBarConfiguration)

        //Связваем навигационный контролер с нижнем меню
        navBottom.setupWithNavController(navController)


    }

    override fun onSupportNavigateUp(): Boolean {
        val navController = findNavController(R.id.my_nav_host_fragment)

        return navController.navigateUp() || super.onSupportNavigateUp()
    }

}