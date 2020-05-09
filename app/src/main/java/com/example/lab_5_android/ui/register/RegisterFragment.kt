package com.example.lab_5_android.ui.register

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import android.view.*
import androidx.fragment.app.Fragment
import android.widget.TextView
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.fragment.findNavController
import com.example.lab_5_android.R
import com.example.lab_5_android.data.Guest
import com.example.lab_5_android.data.GuestList
import com.example.lab_5_android.databinding.FragmentRegisterBinding
import kotlinx.android.synthetic.main.fragment_register.*

class RegisterFragment : Fragment() {

    private lateinit var viewModel: RegisterViewModel

    private lateinit var binding : FragmentRegisterBinding

    override fun onCreateView( inflater: LayoutInflater, container: ViewGroup?,
                                savedInstanceState: Bundle?): View? {

        // Inflate view and obtain an instance of the binding class
        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_register,
            container,
            false
        )

        setHasOptionsMenu(true)

        return binding.root
    }


    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        binding.lifecycleOwner = this

        Log.i("RegisterFragment", "Called ViewModelProvider")
        viewModel = ViewModelProvider(this).get(RegisterViewModel::class.java)
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.register_menu, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == R.id.action_yes) {
            onYesGuestClicked()
        }
        if (item.itemId == R.id.action_no) {
            onNoGuestClicked()
        }
        return super.onOptionsItemSelected(item)
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    }

    // Method for button click handlers
    private fun onYesGuestClicked(){
        viewModel.onYesGuestClicked()
        updateWordText()
        updateScoreText()
    }

    private fun onNoGuestClicked(){
        viewModel.onNoGuestClicked()
        updateScoreText()
        updateWordText()
    }

    // Methods for updating the UI
    private fun updateWordText() {
        binding.textName.text = viewModel.guest
    }
    private fun updateScoreText() {
        binding.textTotal.text = viewModel.guestCount.toString()
    }
}
