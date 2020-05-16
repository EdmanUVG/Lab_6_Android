package com.example.lab_5_android.ui.register

import android.os.Bundle
import android.util.Log
import android.view.*
import androidx.fragment.app.Fragment
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.lab_5_android.R
import com.example.lab_5_android.database.GuestDatabase
import com.example.lab_5_android.databinding.FragmentRegisterBinding
import kotlinx.android.synthetic.main.fragment_register.*

class RegisterFragment : Fragment() {

    private lateinit var registerViewModel: RegisterViewModel

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

        val application = requireNotNull(this.activity).application

        // Create an instance of the View Model Factory
        val dataSource = GuestDatabase.getInstance(application).guestDatabaseDao
        val viewModelFactory = RegisterViewModelFactory(dataSource, application)

        // Get a reference to the ViewModel associated with this fragment
        registerViewModel =
            ViewModelProvider(this, viewModelFactory).get(RegisterViewModel::class.java)

        // To use the View Model with dta binding, you have to explicitly
        // give the binding object a reference to it.
        binding.registerViewModel = registerViewModel

        // Specify the fragment view as the lifecycle owner of the binding.
        // This is used so that the binding can observe LiveData updates
        binding.lifecycleOwner = viewLifecycleOwner

        // Display total guest amount from database
        registerViewModel.guestCount.observe(viewLifecycleOwner, Observer { newAllGuestCount ->
            binding.textTotalAllGuest.text = newAllGuestCount.toString()
        })

        registerViewModel.guest_name.observe(viewLifecycleOwner, Observer { newGuestName ->
            binding.textName.text = newGuestName.toString()
        })

        registerViewModel.guest_phone.observe(viewLifecycleOwner, Observer { newGuestPhone ->
            binding.textPhone.text = newGuestPhone.toString()
        })

        registerViewModel.guest_email.observe(viewLifecycleOwner, Observer { newGuestEmail ->
            binding.textEmail.text = newGuestEmail.toString()
        })

        Log.i("@Edman", "Name: ${binding.textEmail.text}")

        setHasOptionsMenu(true)

//        // Setting up LiveData observation relationship
//        viewModel.guest.observe(viewLifecycleOwner, Observer { newGuest->
//            binding.textName.text = newGuest
//        })
//
//        // Setting up LiveData observation relationship
//        viewModel.guestCount.observe(viewLifecycleOwner, Observer { newGuestCount->
//            binding.textTotal.text = newGuestCount.toString()
//        })

//        viewModel.allGuestCount.observe(viewLifecycleOwner, Observer { newAllGuestCount ->
//            binding.textTotalAllGuest.text = newAllGuestCount.toString()
//        })

        // Observer for the Game finished event
//        viewModel.eventGameFinish.observe(viewLifecycleOwner, Observer { hasFinished->
//            if (hasFinished) gameFinished()
//        })

        return binding.root
    }


    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.register_menu, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
//        if (item.itemId == R.id.action_yes) {
//            onYesGuestClicked()
//        }
//        if (item.itemId == R.id.action_no) {
//            onNoGuestClicked()
//        }
        return super.onOptionsItemSelected(item)
    }

    // Method for button click handlers
//    private fun onYesGuestClicked(){
//        viewModel.onYesGuestClicked()
//    }
//
//    private fun onNoGuestClicked(){
//        viewModel.onNoGuestClicked()
//    }

    private fun onEndGame() {
        gameFinished()
    }

     //Called when the game is finished
    private fun gameFinished() {
//         val guestTotal = viewModel.guestCount.value?:0
//         val registered = viewModel.guestRegistered.value?:0
//         val action = RegisterFragmentDirections.registerToResult(guestTotal, registered)
//         findNavController().navigate(action)
//         viewModel.onGameFinishComplete()
    }
}
