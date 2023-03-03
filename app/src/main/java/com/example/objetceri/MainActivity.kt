package com.example.objetceri

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.DocumentsContract.Root
import com.google.android.material.floatingactionbutton.FloatingActionButton
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.LinearLayout
import android.widget.Toast
import com.example.objetceri.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding


    @SuppressLint("WrongViewCast", "ShowToast")
    override fun onCreate(savedInstanceState: Bundle?) {


        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        val repo = ItemRepository()
        repo.updateData{
            Toast.makeText(this, "Data updated", Toast.LENGTH_SHORT).show()
            replaceFragment(FindFragment())

        }

        //replaceFragment(FindFragment())


        binding.BottomNavigationView.setOnNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.found -> replaceFragment(FindFragment())
                R.id.lost -> replaceFragment(LostFragment())

                else -> {
                }


            }
            true
        }


        val button = findViewById<FloatingActionButton>(R.id.btn_showPopUp)



        button.setOnClickListener(){
            val popUpFragment = PopUpFragment()
            popUpFragment.show(supportFragmentManager, "PopUpFragment")




        }




    }


    private fun replaceFragment(fragment: Fragment) {
        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.frame_layout, fragment)
        fragmentTransaction.commit()
    }



}




