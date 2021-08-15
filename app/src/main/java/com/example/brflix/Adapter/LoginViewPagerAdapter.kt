package com.example.brflix.Adapter

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.brflix.Fragments.LoginFragment
import com.example.brflix.Fragments.RegisterFragment

private val NUN_PAGES = 2

class LoginViewPagerAdapter(fragment: Fragment) : FragmentStateAdapter(fragment) {
    override fun getItemCount(): Int = NUN_PAGES


    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> LoginFragment()
            else -> RegisterFragment()
        }
    }
}