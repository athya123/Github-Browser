package com.tare.githubbrowser.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.tare.githubbrowser.ui.detail.branches.BranchFragment
import com.tare.githubbrowser.ui.detail.issues.IssuesFragment

class ViewPagerAdapter(fragmentManager: FragmentManager): FragmentPagerAdapter(fragmentManager) {
    override fun getCount(): Int = 2

    override fun getItem(position: Int): Fragment {
        return when(position){
            1 ->{
                IssuesFragment.newInstance()
            }
            else -> {BranchFragment.newInstance()}
        }
    }

    override fun getPageTitle(position: Int): CharSequence? {
        var title: String? = null
        when(position){
            0 -> {
                title = "Branches"
            }
            1 -> {
                title = "Issues(0)"
            }
        }
        return title
    }
}