package com.example.lab_5_android.ui.roles

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import android.view.*
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.findNavController

import com.example.lab_5_android.R
import com.example.lab_5_android.databinding.FragmentAddRolesBinding
import kotlinx.android.synthetic.main.fragment_add_roles.*

class AddRolesFragment : Fragment() {


    private lateinit var binding: FragmentAddRolesBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                                savedInstanceState: Bundle?): View? {

        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_add_roles,
            container,
            false
        )

        setHasOptionsMenu(true)

        return binding.root
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.add_menu, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == R.id.action_save) {

            val fieldName = editText_name.text.toString().trim()
            val fieldDescription = editText_description.text.toString().trim()

            if (fieldName.isEmpty() && fieldDescription.isEmpty()) {
                editText_name.error = "Nombre requerido"
                editText_name.requestFocus()
                editText_description.error = "Descripcion requerido"
                editText_description.requestFocus()
            } else if (fieldName.isEmpty()) {
                editText_name.error = "Nombre requerido"
                editText_name.requestFocus()
            } else if (fieldName.isEmpty()) {
                editText_description.error = "Descripcion requerido"
                editText_description.requestFocus()
            } else {
                Toast.makeText(activity, "Saved", Toast.LENGTH_LONG).show()
                findNavController().navigate(R.id.addRoles_to_roles)
            }
        }
        return super.onOptionsItemSelected(item)
    }
}
