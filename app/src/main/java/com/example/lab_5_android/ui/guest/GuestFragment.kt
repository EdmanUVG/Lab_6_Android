package com.example.lab_5_android.ui.guest

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.fragment.findNavController
import com.example.lab_5_android.R
import com.example.lab_5_android.database.GuestDatabase
import com.example.lab_5_android.databinding.FragmentGuestBinding
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.fragment_guest.*

class GuestFragment : Fragment() {

    private lateinit var guestViewModel: GuestViewModel

    private lateinit var binding: FragmentGuestBinding


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?): View? {

        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_guest,
            container,
            false
        )

        val application = requireNotNull(this.activity).application

        // Create an instance of the ViewModel Factory
        val dataSource = GuestDatabase.getInstance(application).guestDatabaseDao
        val viewModelFactory = GuestViewModelFactory(dataSource, application)

        // Get a reference to the ViewModel associated with this fragment
         guestViewModel =
            ViewModelProvider(this, viewModelFactory).get(GuestViewModel::class.java)

        binding.setLifecycleOwner(this)

        binding.guestViewModel = guestViewModel

        // Setting up LiveData observation relationship
        guestViewModel.guest_name.observe(viewLifecycleOwner, Observer { newGuest->
            binding.textview.text = newGuest
        })

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        fab.setOnClickListener { view ->
            findNavController().navigate(R.id.action_guestFragment_to_addFragment)
        }
    }
}
