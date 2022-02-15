package com.tare.githubbrowser.ui.home

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.LinearLayout
import androidx.activity.viewModels
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.recyclerview.widget.RecyclerView
import com.tare.githubbrowser.R
import com.tare.githubbrowser.adapter.HomeAdapter
import com.tare.githubbrowser.databinding.ActivityMainBinding
import com.tare.githubbrowser.pojo.entities.Repository
import com.tare.githubbrowser.ui.home.add.AddRepoFragment
import com.tare.githubbrowser.ui.detail.DetailActivity
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeActivity : AppCompatActivity(), FragmentManager.OnBackStackChangedListener {
    private val homeViewModel: HomeViewModel by viewModels()
    private val homeAdapter = HomeAdapter(this)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportFragmentManager.addOnBackStackChangedListener(this)
        shouldDisplayHomeUp()
        val binding: ActivityMainBinding =
            DataBindingUtil.setContentView(this, R.layout.activity_main)

        binding.apply {
            baseView = this@HomeActivity
            viewModel = homeViewModel
            lifecycleOwner = this@HomeActivity
        }
        subscribeObservers(binding.noItemsLl, binding.RvHome)
    }

    private fun subscribeObservers(llHome: LinearLayout, rvHome: RecyclerView) {
        rvHome.adapter = homeAdapter
        homeViewModel.repoList.observe(this) {
            it?.let { list ->
                if (list.isNotEmpty()) {
                    llHome.visibility = View.GONE
                    rvHome.visibility = View.VISIBLE
                    homeAdapter.submitList(list)
                }
            }
        }
    }


    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.add_repo -> {
                replaceFragment(AddRepoFragment.newInstance())
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    fun onAddRepoClick(){
        replaceFragment(AddRepoFragment.newInstance())
    }

    fun onShareClick(item: Repository) {
        val intent = Intent(Intent.ACTION_SEND)
        intent.type = "text/plain"
        intent.putExtra(Intent.EXTRA_SUBJECT, "Share repository ${item.name}")
        intent.putExtra(
            Intent.EXTRA_TEXT,
            "Here is a Repository: ${item.name} with Link: ${item.url}"
        )
        startActivity(Intent.createChooser(intent, "Share Repository via"))
    }

    fun onRepoClick(item: Repository) {
        val intent = Intent(this, DetailActivity::class.java)
        intent.putExtra(DetailActivity.REPO_ID, item.id)
        startActivity(intent)
    }

    private fun replaceFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction().apply {
            setCustomAnimations(
                R.anim.slide_in_right, R.anim.slide_out_left, R.anim.slide_in_left,
                R.anim.slide_out_right
            )
            replace(R.id.fragment_container, fragment)
            addToBackStack(null)
            commit()
        }
    }

    override fun onBackStackChanged() {
        shouldDisplayHomeUp()
    }

    private fun shouldDisplayHomeUp() {
        val canGoBack = supportFragmentManager.backStackEntryCount > 0
        supportActionBar?.setDisplayHomeAsUpEnabled(canGoBack)
    }

    override fun onBackPressed() {
        val isFragment = supportFragmentManager.backStackEntryCount == 1
        if (isFragment) {
            supportActionBar?.title = "Github Browser"
            super.onBackPressed()
        } else {
            super.onBackPressed()
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        val isFragment = supportFragmentManager.backStackEntryCount == 1
        if (isFragment)
            supportActionBar?.title = "Github Browser"
        supportFragmentManager.popBackStack()
        return true
    }
}