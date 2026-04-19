package com.example.lab9

import android.graphics.Color
import android.os.Bundle
import android.view.ContextMenu
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar

class MainActivity : AppCompatActivity() {

    companion object {
        private const val CONTEXT_INCREASE_ID = 1
        private const val CONTEXT_DECREASE_ID = 2
    }

    private lateinit var textViewNumber: TextView
    private lateinit var toolbar: Toolbar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)

        textViewNumber = findViewById(R.id.textViewNumber)

        registerForContextMenu(textViewNumber)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.action_red -> {
                textViewNumber.setTextColor(Color.RED)
                Toast.makeText(this, getString(R.string.toast_red), Toast.LENGTH_SHORT).show()
                return true
            }

            R.id.action_green -> {
                textViewNumber.setTextColor(Color.GREEN)
                Toast.makeText(this, getString(R.string.toast_green), Toast.LENGTH_SHORT).show()
                return true
            }

            R.id.action_blue -> {
                textViewNumber.setTextColor(Color.BLUE)
                Toast.makeText(this, getString(R.string.toast_blue), Toast.LENGTH_SHORT).show()
                return true
            }
        }

        return super.onOptionsItemSelected(item)
    }

    override fun onCreateContextMenu(
        menu: ContextMenu?,
        v: View?,
        menuInfo: ContextMenu.ContextMenuInfo?
    ) {
        super.onCreateContextMenu(menu, v, menuInfo)

        menu?.setHeaderTitle(getString(R.string.context_menu_title))
        menu?.add(0, CONTEXT_INCREASE_ID, 0, getString(R.string.context_increase))
        menu?.add(0, CONTEXT_DECREASE_ID, 1, getString(R.string.context_decrease))
    }

    override fun onContextItemSelected(item: MenuItem): Boolean {
        val currentNumber = textViewNumber.text.toString().toInt()

        when (item.itemId) {
            CONTEXT_INCREASE_ID -> {
                textViewNumber.text = (currentNumber + 10).toString()
                Toast.makeText(this, getString(R.string.toast_increase), Toast.LENGTH_SHORT).show()
                return true
            }

            CONTEXT_DECREASE_ID -> {
                textViewNumber.text = (currentNumber - 10).toString()
                Toast.makeText(this, getString(R.string.toast_decrease), Toast.LENGTH_SHORT).show()
                return true
            }
        }

        return super.onContextItemSelected(item)
    }
}