package com.example.testd

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.example.testd.ui.DetailsFragment
import com.example.testd.ui.ListContinentsFragment

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        switchFragment(ListContinentsFragment(), R.id.left_container)
        switchFragment(DetailsFragment(), R.id.right_container)
    }

    private fun switchFragment(fragment: Fragment, containerId: Int){

        supportFragmentManager
            .beginTransaction()
            .replace(containerId, fragment)
            .commit()

    }
}