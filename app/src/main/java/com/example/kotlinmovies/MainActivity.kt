package com.example.kotlinmovies

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.example.kotlinmovies.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), Navigation {

    lateinit var bindingmainActivity: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        bindingmainActivity = ActivityMainBinding.inflate(layoutInflater)
        setContentView(bindingmainActivity.root)

        openFragmentRequest()

    }

    private fun replaceFragment(fragmentRequest: Fragment) {
        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.container, fragmentRequest)
        fragmentTransaction.addToBackStack(null)
        fragmentTransaction.commit()
    }

    override fun openFragmentRequest() {
replaceFragment(FragmentRequest().newInstance())
    }

    override fun openFragmentResponce(kinopoiskId: String) {
replaceFragment(FragmentResponce.newInstance(kinopoiskId))
    }
}

interface Navigation{
fun openFragmentRequest()
fun openFragmentResponce(kinopoiskId: String)
}