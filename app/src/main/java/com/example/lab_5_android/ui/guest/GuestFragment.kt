package com.example.lab_5_android.ui.guest

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.fragment.findNavController
import com.example.lab_5_android.R
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.fragment_guest.*

class GuestFragment : Fragment() {

    private lateinit var guestViewModel: GuestViewModel

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        guestViewModel =
                ViewModelProviders.of(this).get(GuestViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_guest, container, false)
        guestViewModel.text.observe(viewLifecycleOwner, Observer {})
        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        fab.setOnClickListener { view ->
            findNavController().navigate(R.id.action_guestFragment_to_addFragment)
        }
    }
}
