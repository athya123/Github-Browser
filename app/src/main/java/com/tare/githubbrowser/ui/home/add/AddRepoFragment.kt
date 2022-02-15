package com.tare.githubbrowser.ui.home.add

import android.os.Bundle
import android.text.Editable
import android.util.Log
import android.view.*
import androidx.fragment.app.Fragment
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import com.google.android.material.snackbar.Snackbar
import com.tare.githubbrowser.R
import com.tare.githubbrowser.databinding.FragmentAddRepoBinding
import com.tare.githubbrowser.ui.home.HomeActivity
import com.tare.githubbrowser.utils.Response
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class AddRepoFragment : Fragment() {
    private val addRepoViewModel: AddRepoViewModel by viewModels()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        (requireActivity() as HomeActivity).supportActionBar?.title = "Add Repo"
        setHasOptionsMenu(true)
        val binding: FragmentAddRepoBinding =
            DataBindingUtil.inflate(inflater, R.layout.fragment_add_repo, container, false)
        binding.apply {
            baseView = this@AddRepoFragment
            lifecycleOwner = this@AddRepoFragment
        }
        subscribeObservers()
        return binding.root
    }

    override fun onPrepareOptionsMenu(menu: Menu) {
        menu.findItem(R.id.add_repo)?.isVisible = false
    }

    private fun subscribeObservers() {
        addRepoViewModel.fetchRepoFromNetwork.observe(viewLifecycleOwner) {
            when (it) {
                is Response.Success -> {
                    addRepoViewModel.addRepoToDB(
                        it.responseGetRepo.name,
                        it.responseGetRepo.htmlUrl,
                        it.responseGetRepo.description,
                        it.responseGetRepo.owner.login
                    )
                }
                is Response.Error -> {
                    Toast.makeText(
                        requireContext(),
                        "Please enter valid Owner and Repo Name",
                        Toast.LENGTH_SHORT
                    ).show()
                }
                else -> {}
            }
        }

        addRepoViewModel.repoToDB.observe(viewLifecycleOwner){
            if(it == true){
                Toast.makeText(requireContext(),"Repository added to App",Toast.LENGTH_SHORT).show()
                activity?.onBackPressed()
                addRepoViewModel.repoToDB.value = null
            }
        }
    }

    fun validateRepo(
        owner: Editable?,
        repoName: Editable?
    ) {
        if (owner.isNullOrEmpty() || repoName.isNullOrEmpty()) {
            Log.d("DETAILS", "$owner, $repoName")
            Snackbar.make(requireView(), "Please enter correct details", Snackbar.LENGTH_SHORT)
                .show()
            return
        }
        addRepoViewModel.fetchRepoFromNetwork(owner.toString(),repoName.toString())
    }

    companion object {
        @JvmStatic
        fun newInstance() = AddRepoFragment()
    }
}