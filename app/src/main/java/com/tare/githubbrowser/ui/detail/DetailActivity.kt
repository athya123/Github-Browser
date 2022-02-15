package com.tare.githubbrowser.ui.detail

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.activity.viewModels
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.tare.githubbrowser.R
import com.tare.githubbrowser.adapter.ViewPagerAdapter
import com.tare.githubbrowser.databinding.ActivityDetailBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DetailActivity : AppCompatActivity() {
    private var repoId: Int = 0
    private var url: String? = null
    private val detailViewModel: DetailViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.title = "Details"
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        repoId = intent.getIntExtra(REPO_ID, 0)
        val binding: ActivityDetailBinding =
            DataBindingUtil.setContentView(this, R.layout.activity_detail)
        binding.apply {
            viewModel = detailViewModel
            lifecycleOwner = this@DetailActivity
        }
        binding.tabLayout.setupWithViewPager(binding.viewPagerDetail)
        binding.viewPagerDetail.adapter = ViewPagerAdapter(supportFragmentManager)
        subscribeObservers(binding)
    }

    override fun onStart() {
        super.onStart()
        detailViewModel.fetchRepoDB(repoId)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.detail_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.delete_repo -> {
                detailViewModel.deleteRepo(repoId)
                true
            }
            R.id.open_browser -> {
                url?.let {
                    val intent = Intent(Intent.ACTION_VIEW)
                    intent.data = Uri.parse(it)
                    startActivity(intent)
                }
                true
            }
            else -> {
                super.onOptionsItemSelected(item)
            }
        }
    }

    private fun subscribeObservers(binding: ActivityDetailBinding) {
        detailViewModel.dbRepo.observe(this) {
            it?.let {
                url = it.url
                binding.repName.text = it.name
                binding.repDesc.text = it.description
                detailViewModel.fetchDetailsForRepo(it.owner, it.name)
            }
        }
        detailViewModel.openIssues.observe(this) {
            it?.let {
                binding.tabLayout.getTabAt(1)?.text = "Issues(${it.size})"
            }
        }
        detailViewModel.deleteRepo.observe(this){
            if(it == true){
                detailViewModel.deleteRepo.value = false
                onBackPressed()
            }
        }
    }

    fun replaceFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction().apply {
            setCustomAnimations(
                R.anim.slide_in_right, R.anim.slide_out_left, R.anim.slide_in_left,
                R.anim.slide_out_right
            )
            add(R.id.fragment_detail_container, fragment)
            addToBackStack(null)
            commit()
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }

    override fun onBackPressed() {
        val isFragment = supportFragmentManager.backStackEntryCount > 0
        if(isFragment){
            supportFragmentManager.popBackStack()
            supportActionBar?.title = "Details"
            supportActionBar?.subtitle = null
        }else{
            super.onBackPressed()
        }
    }

    companion object {
        const val REPO_ID = "ID"
    }
}