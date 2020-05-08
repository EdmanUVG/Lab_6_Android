package com.example.lab_5_android.ui.result

import android.content.Intent
import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import android.view.*
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController

import com.example.lab_5_android.R
import kotlinx.android.synthetic.main.fragment_register.*
import kotlinx.android.synthetic.main.fragment_result.*

class ResultFragment : Fragment() {

    private lateinit var viewModel: ResultViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        setHasOptionsMenu(true)
        return inflater.inflate(R.layout.fragment_result, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(ResultViewModel::class.java)
        // TODO: Use the ViewModel
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

        val total_guest : String = ResultFragmentArgs.fromBundle(requireArguments()).guestAmount.toString()
        val guest_registered : String = ResultFragmentArgs.fromBundle(requireArguments()).guestRegistered.toString()

        val wordGuest = "Invitados: "
        val guests = "$wordGuest  $total_guest"
        text_guest.text = guests

        val wordRegistered = "Registrados: "
        val registered = "$wordRegistered $guest_registered"
        text_registered.text = registered


        button_restart.setOnClickListener {
            findNavController().navigate(R.id.result_to_register)
        }

        button_see_guest.setOnClickListener {
            Toast.makeText(activity, "No", Toast.LENGTH_SHORT).show()
        }
    }

}
