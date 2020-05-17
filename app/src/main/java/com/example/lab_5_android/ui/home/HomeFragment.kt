package com.example.lab_5_android.ui.home

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.*
import android.widget.Button
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.fragment.findNavController
import com.example.lab_5_android.R
import com.example.lab_5_android.databinding.FragmentHomeBinding
import com.example.lab_5_android.ui.register.RegisterFragment
import kotlinx.android.synthetic.main.fragment_home.*

class HomeFragment : Fragment() {

    private lateinit var viewModel: HomeViewModel

    private lateinit var binding: FragmentHomeBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                                savedInstanceState: Bundle?): View? {

        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_home,
            container,
            false
        )

        setHasOptionsMenu(true)

        viewModel = ViewModelProvider(this).get(HomeViewModel::class.java)

        // Set the viewmodel for databinding - this allows the bound layout access
        // to all the data in the VieWModel
        binding.homeViewModel = viewModel

        // Observer for the Game finished event
        viewModel.eventGoToRegister.observe(viewLifecycleOwner, Observer<Boolean> { hasFinished ->
            if (hasFinished) onGoToRegisterFragment()
        })

        return binding.root
    }

    private fun onGoToRegisterFragment() {
        findNavController().navigate(R.id.action_nav_home_to_registerFragment)
        viewModel.onGoToRegisterComplete()
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.main, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == R.id.action_about) {
            findNavController().navigate(R.id.action_nav_home_to_aboutFragment)
        }
        return super.onOptionsItemSelected(item)
    }
}
