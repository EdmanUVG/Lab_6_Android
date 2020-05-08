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

    private lateinit var guestList : GuestList
    private lateinit var guests : ArrayList<Guest>




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

//        text_total.text = guestCount.toString() + " /8"
//
//        showCurrentGuest(currentGuest)
    }

    // Method for button click handlers
    private fun onYesGuestClicked(){

    }

    private fun onNoGuestClicked(){

    }

//    @SuppressLint("SetTextI18n")
//    private fun onYesGuestClicked() {
//
//        guestRegistered++
//        currentGuest++
//        guestCount++
//
//        if(guestCount == 9) {
//            nextFragment()
//        } else {
//            showCurrentGuest(currentGuest)
//            text_total.text = guestCount.toString() + " /8"
//        }
//
//    }
//
//    private fun onNoGuestClicked() {
//
//        currentGuest++
//        guestCount++
//
//        if(guestCount == 9) {
//            nextFragment()
//        } else {
//            showCurrentGuest(currentGuest)
//            text_total.text = guestCount.toString() + " /8"
//        }
//    }

//    private fun showCurrentGuest(i : Int) {
//
//        text_name.text = allGuest[i].name
//        text_phone.text = allGuest[i].phone
//        text_email.text = allGuest[i].email
//    }
//
//    private fun nextFragment() {
//        val total_guest = currentGuest
//        val guest_registered = guestRegistered
//        val action = RegisterFragmentDirections.registerToResult(total_guest, guest_registered)
//        findNavController().navigate(action)
//    }

}
