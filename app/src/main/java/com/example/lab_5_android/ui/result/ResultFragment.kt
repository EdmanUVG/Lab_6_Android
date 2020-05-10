package com.example.lab_5_android.ui.result

import android.content.Intent
import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import android.view.*
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController

import com.example.lab_5_android.R
import com.example.lab_5_android.databinding.FragmentResultBinding
import kotlinx.android.synthetic.main.fragment_result.*

class ResultFragment : Fragment() {

    private lateinit var viewModel: ResultViewModel

    private lateinit var viewModelFactory: ResultViewModelFactory

    private lateinit var binding: FragmentResultBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                                savedInstanceState: Bundle?): View? {

        // Inflate view and obtain an instance of the binding class
        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_result,
            container,
            false
        )

        viewModelFactory = ResultViewModelFactory(ResultFragmentArgs.fromBundle(requireArguments()).guestTotal)

        viewModel = ViewModelProvider(this, viewModelFactory).get(ResultViewModel::class.java)

        // Add observer for guests
//        viewModel.guests.observe(viewLifecycleOwner, Observer { newGuest ->
//            binding.textGuest.text = newGuest.toString()
//        })

        // Add observer for registered
        viewModel.registered.observe(viewLifecycleOwner, Observer { newGuest ->
            binding.textRegistered.text = newGuest.toString()
        })

        binding.buttonRestart.setOnClickListener { viewModel.onPlayAgain() }
        binding.buttonSeeGuest.setOnClickListener { viewModel.onSeeGuests() }

        // Navigates back to game when button is pressed
        viewModel.eventPlayAgain.observe(viewLifecycleOwner, Observer { playAgain ->
            if (playAgain) {
                findNavController().navigate(ResultFragmentDirections.resultToRegister())
                viewModel.onPlayAgainComplete()
            }
        })

        // Display Toas with all users registration information
        viewModel.eventSeeGuests.observe(viewLifecycleOwner, Observer { seeGuests ->
            if (seeGuests) {
                Toast.makeText(activity, "Users registerd", Toast.LENGTH_SHORT).show()
                viewModel.onSeeGuestsComplete()
            }
        })

        setHasOptionsMenu(true)

        return binding.root
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.result_menu, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == R.id.action_share) {
            val intent = Intent()
            intent.action= Intent.ACTION_SEND
            intent.putExtra(Intent.EXTRA_TEXT, "Hey check out this great app:")
            intent.type="text/plain"
            startActivity(Intent.createChooser(intent, "Share To:"))
        }
        return super.onOptionsItemSelected(item)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val guest_total: String = ResultFragmentArgs.fromBundle(requireArguments()).guestTotal.toString()
        text_guest.text = guest_total
    }
}
