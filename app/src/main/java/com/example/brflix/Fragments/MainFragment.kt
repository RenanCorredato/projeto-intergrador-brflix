package com.example.brflix.Fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.viewpager2.widget.ViewPager2
import com.example.brflix.Adapter.LoginViewPagerAdapter
import com.example.brflix.R
import com.example.brflix.databinding.FragmentMainBinding
import com.google.android.material.tabs.TabLayout


class MainFragment : Fragment() {

    private var binding: FragmentMainBinding? = null
    private var viewPager: ViewPager2? = null
    private var loginViewPagerAdapter: LoginViewPagerAdapter? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentMainBinding.inflate(inflater, container, false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        loginViewPagerAdapter = LoginViewPagerAdapter(this)
        viewPager = binding?.pager
        viewPager?.adapter = loginViewPagerAdapter

        binding?.tlLogin?.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab?) {
                val tabPosition = tab?.position ?: 0
                viewPager?.setCurrentItem(tabPosition)
            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {}

            override fun onTabReselected(tab: TabLayout.Tab?) {}
        })

               viewPager?.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback(){
           override fun onPageSelected(position: Int) {
              super.onPageSelected(position)
               binding?.let {
                   with(it.tlLogin){
                       selectTab(getTabAt(position))

                    }
                }
            }
        })
    }


    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }
}