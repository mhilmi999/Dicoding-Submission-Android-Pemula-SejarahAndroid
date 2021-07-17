package com.example.sejarahandroid

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    private lateinit var rvAndroid: RecyclerView
    private var list: ArrayList<Android> = arrayListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val actionbar = supportActionBar
        actionbar!!.title = "Sejarah Android"

        rvAndroid = findViewById(R.id.rv_android)
        rvAndroid.setHasFixedSize(true)

        list.addAll(AndroidData.listData)
        showRecyclerList()
    }

    private fun showRecyclerList() {
        rvAndroid.layoutManager = LinearLayoutManager(this)
        val listAndroidAdapter = ListAndroidAdapter(list)
        rvAndroid.adapter = listAndroidAdapter
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main,menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        setMode(item.itemId)
        return super.onOptionsItemSelected(item)
    }

    private fun setMode(selectedMode: Int) {
        when(selectedMode){
            R.id.myProfile -> {
                val movetoProfile = Intent(this@MainActivity, ProfileActivity::class.java)
                startActivity(movetoProfile)
            }
        }
    }
}