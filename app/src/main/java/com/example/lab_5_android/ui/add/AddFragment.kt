package com.example.lab_5_android.ui.add

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import android.view.*
import android.widget.EditText
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController

import com.example.lab_5_android.R
import com.example.lab_5_android.database.Guest
import com.example.lab_5_android.database.GuestDatabase
import com.example.lab_5_android.databinding.FragmentAddBinding
import com.example.lab_5_android.databinding.FragmentGuestBinding
import com.example.lab_5_android.ui.guest.GuestViewModelFactory
import kotlinx.android.synthetic.main.fragment_add.*
import kotlinx.android.synthetic.main.fragment_register.*


class AddFragment : Fragment() {


    private lateinit var viewModel: AddViewModel

    private var guest: Guest? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                                savedInstanceState: Bundle?): View? {

        val binding: FragmentAddBinding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_add,
            container,
            false
        )

        setHasOptionsMenu(true)

        val application = requireNotNull(this.activity).application


        //Create an instance of the ViewModel Factory
        val dataSource = GuestDatabase.getInstance(application).guestDatabaseDao
        val viewModelFactory = AddViewModelFactory( dataSource)

        viewModel =
            ViewModelProvider(this, viewModelFactory).get(AddViewModel::class.java)

        binding.addViewModel = viewModel

        return binding.root
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.add_menu, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == R.id.action_save) {
            val fieldName = editText_name.text.toString().trim()
            val fieldPhone = editText_phone.text.toString().trim()
            val fieldEmail = editText_email.text.toString().trim()

            if (fieldName.isEmpty() && fieldPhone.isEmpty() && fieldEmail.isEmpty()) {
                editText_name.error = "Nombre requerido"
                editText_name.requestFocus()
                editText_phone.error = "Telefono requerido"
                editText_phone.requestFocus()
                editText_email.error = "Correo requerido"
                editText_email.requestFocus()
            }else if (fieldName.isEmpty()) {
                editText_name.error = "Nombre requerido"
                editText_name.requestFocus()
            }else if (fieldPhone.isEmpty()) {
                editText_phone.error = "Telefono requerido"
                editText_phone.requestFocus()
            }else if (fieldEmail.isEmpty()) {
                editText_email.error = "Correo requerido"
                editText_email.requestFocus()
            } else {
                viewModel.onInsertGuest(fieldName, fieldPhone, fieldEmail)

                findNavController().navigate(R.id.add_to_guests)
            }
        }
        return super.onOptionsItemSelected(item)
    }
}
