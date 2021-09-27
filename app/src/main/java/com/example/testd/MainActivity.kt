package com.example.testd

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.example.testd.fragments.DetailsFragment
import com.example.testd.fragments.ListContinentsFragment

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        switchFragment(ListContinentsFragment())
        switchFragment(DetailsFragment())
    }

    private fun switchFragment(fragment: Fragment){

        supportFragmentManager
            .beginTransaction()
            .replace(R.id.list, fragment)
            .commit()

    }
}