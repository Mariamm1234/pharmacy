package com.example.myapplication12

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter

class fragmentPageAdabter (fm: FragmentManager, fc: Lifecycle): FragmentStateAdapter(fm,fc) {
    override fun getItemCount(): Int {
        return 2
    }

    override fun createFragment(position: Int): Fragment {
        return  if(position==1)
            write_one()
        else
            complete_one()
    }

}