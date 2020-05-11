package com.example.lab_5_android.ui.add

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import android.view.*
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import androidx.navigation.Navigation.findNavController
import androidx.navigation.fragment.findNavController

import com.example.lab_5_android.R
import com.example.lab_5_android.database.Guest
import com.example.lab_5_android.database.GuestDatabase
import com.example.lab_5_android.ui.BaseFragment
import kotlinx.android.synthetic.main.fragment_add.*
import kotlinx.coroutines.launch

class AddFragment : BaseFragment() {


    private lateinit var viewModel: AddViewModel

    private var guest: Guest? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        setHasOptionsMenu(true)
        return inflater.inflate(R.layout.fragment_add, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(AddViewModel::class.java)
        // TODO: Use the ViewModel
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.add_menu, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == R.id.action_save) {

            val guestName = editText_name.text.toString().trim()
            val guestPhone = editText_phone.text.toString().trim()
            val guestEmail = editText_email.text.toString().trim()

            launch {

                context?.let {
                    val mNote = Guest( guestName, guestPhone, guestEmail)

                    if (guest == null) {
                        GuestDatabase(it).getGuestDatabaseDao().addGuest(mNote)
                        Toast.makeText(activity, "Saved", Toast.LENGTH_LONG).show()
                    } else {
                        mNote.guestId = guest!!.guestId
                        GuestDatabase(it).getGuestDatabaseDao().addGuest(mNote)
                        Toast.makeText(activity, "NOte updated", Toast.LENGTH_LONG).show()
                    }

                    val action = AddFragmentDirections.addToGuests()
                    findNavController().navigate(action)
                }
            }
        }
        return super.onOptionsItemSelected(item)
    }
}
