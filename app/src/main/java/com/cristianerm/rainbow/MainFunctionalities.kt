package com.cristianerm.rainbow

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import androidx.appcompat.widget.PopupMenu
import androidx.core.view.GravityCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import com.google.android.material.navigation.NavigationView
import kotlinx.android.synthetic.main.activity_main_functionalities.*

class MainFunctionalities : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener{

    private lateinit var promotionsRecyclerViewAdapter: PromotionsRecyclerViewAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_functionalities)

        setSupportActionBar(app_bar_rainbow_main_functionalities)

        app_bar_rainbow_main_functionalities.setNavigationOnClickListener {
            drawer_layout.openDrawer(GravityCompat.START)
        }

        app_bar_rainbow_main_functionalities.setOnMenuItemClickListener { menuItem ->
            when (menuItem.itemId) {
                R.id.menu_icon_investments -> {
                    val intent = Intent(this, RevertidoCaridadeActivity::class.java)
                    startActivity(intent)
                    val menuItemView: View = findViewById(R.id.menu_icon_investments)
                    true
                }
                else -> false
            }
        }

        val navigationView: NavigationView = nav_view
        navigationView.setNavigationItemSelectedListener(this)

        navigationView.setCheckedItem(R.id.nav_main_inicio)

        recyclerView_promotions.apply {
            layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL ,false)
            promotionsRecyclerViewAdapter = PromotionsRecyclerViewAdapter()
            adapter = promotionsRecyclerViewAdapter
        }

        val list = ArrayList<PromotionsInformation>()
        list.add(
            PromotionsInformation(
                "5%",
                "Evento tal"
            )
        )
        list.add(
            PromotionsInformation(
                "R$10",
                "Checkup de saúde"
            )
        )
        list.add(
            PromotionsInformation(
                "7%",
                "Balada"
            )
        )

        promotionsRecyclerViewAdapter.submitList(list)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.toolbar_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // The action bar home/up action should open or close the drawer.
        when (item.itemId) {
            android.R.id.home -> {
                drawer_layout.openDrawer(GravityCompat.START)
                return true
            }
        }
        return super.onOptionsItemSelected(item)
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {

        when (item.itemId) {
            R.id.nav_main_inicio -> Toast.makeText(this, "Test nav_one_fragment clicked", Toast.LENGTH_LONG).show()

            R.id.nav_main_meu_perfil -> Toast.makeText(this, "Test nav_second_fragment clicked", Toast.LENGTH_LONG).show()
        }

        drawer_layout.closeDrawer(GravityCompat.START)
        return true
    }

}