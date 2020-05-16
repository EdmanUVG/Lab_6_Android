package com.example.lab_5_android.ui.guest

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.lab_5_android.R
import com.example.lab_5_android.database.GuestDatabase
import com.example.lab_5_android.databinding.FragmentGuestBinding
import com.example.lab_5_android.ui.GuestsAdapter
import kotlinx.android.synthetic.main.fragment_guest.*

class GuestFragment : Fragment() {

    private lateinit var guestViewModel: GuestViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?): View? {

        val binding: FragmentGuestBinding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_guest,
            container,
            false
        )

        val application = requireNotNull(this.activity).application

         //Create an instance of the ViewModel Factory
        val dataSource = GuestDatabase.getInstance(application).guestDatabaseDao
        val viewModelFactory = GuestViewModelFactory(dataSource, application)

         //Get a reference to the ViewModel associated with this fragment
         guestViewModel =
            ViewModelProvider(this, viewModelFactory).get(GuestViewModel::class.java)


        // To use the View Model with dta binding, you have to explicitly
        // give the binding object a reference to it.
        binding.guestViewModel = guestViewModel

        val adapter = GuestsAdapter()
        binding.guestList.adapter = adapter

        guestViewModel.allGuests.observe(viewLifecycleOwner, Observer {
            it?.let {
                adapter.data = it
            }
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
