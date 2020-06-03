package com.os.sliderdemo

import android.os.Bundle
import android.os.PersistableBundle
import android.view.MenuItem
import androidx.annotation.NonNull
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.os.sliderdemo.fragment.HomeFragment
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity :AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        mInitView()

    }


    private fun mInitView() {
        val mFragment: Fragment? = HomeFragment()
        mChangeFragment(mFragment!!, false)

    }

    private fun mChangeFragment(fragment: Fragment, isAddToBack: Boolean) {

        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.frameLayout, fragment, fragment.javaClass.name)
        if (isAddToBack && supportFragmentManager.findFragmentByTag(fragment.tag) == null) transaction.addToBackStack(
            fragment.javaClass.name
        )
        transaction.commit()
    }


}