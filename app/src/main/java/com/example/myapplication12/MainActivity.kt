package com.example.myapplication12

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayout

class MainActivity : AppCompatActivity() {
    lateinit var tablayout: TabLayout
    lateinit var viewpager: ViewPager2
    lateinit var adapter:ViewPagerAdabter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        tablayout=findViewById(R.id.tab_layout)
        viewpager=findViewById(R.id.view_pager)
        adapter= ViewPagerAdabter(supportFragmentManager,lifecycle)

        tablayout.addTab(tablayout.newTab().setText("login"))
        tablayout.addTab(tablayout.newTab().setText("signup"))

        viewpager.adapter=adapter

        tablayout.addOnTabSelectedListener(object: TabLayout.OnTabSelectedListener{
            override fun onTabSelected(tab: TabLayout.Tab?) {
                if (tab != null) {
                    viewpager.currentItem =tab.position
                }
            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {

            }

            override fun onTabReselected(tab: TabLayout.Tab?) {

            }

        } )
        viewpager.registerOnPageChangeCallback(object :ViewPager2.OnPageChangeCallback(){
            override fun onPageScrolled(position: Int, positionOffset: Float, positionOffsetPixels: Int) {
                super.onPageScrolled(position, positionOffset, positionOffsetPixels)
                tablayout.selectTab(tablayout.getTabAt(position))
            }
        } )

    }
    override fun onResume() {
        super.onResume()
        getSupportActionBar()?.hide()
    }
}