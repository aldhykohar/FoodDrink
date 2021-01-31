package com.stimednp.fooddrinkcustomer.ui.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter

class SectionPagerAdapter(fm: FragmentManager) : FragmentPagerAdapter(fm) {

    private val fragmentList = ArrayList<Fragment>()
    private val fragmentListTitle = ArrayList<String>()

    override fun getItem(position: Int): Fragment = fragmentList[position]

    override fun getCount(): Int = fragmentList.size

    override fun getPageTitle(position: Int): CharSequence? = fragmentListTitle[position]

    fun addFragment(
        fragment: Fragment?,
        title: String?
    ) {
        fragmentList.add(fragment!!)
        fragmentListTitle.add(title!!)
    }
}