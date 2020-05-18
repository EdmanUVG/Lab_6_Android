package com.example.lab_5_android.ui.roles

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import android.view.*
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController

import com.example.lab_5_android.R
import com.example.lab_5_android.database.GuestDatabase
import com.example.lab_5_android.databinding.FragmentAddRolesBinding
import kotlinx.android.synthetic.main.fragment_add_roles.*

class AddRolesFragment : Fragment() {

    private lateinit var viewModelFactory: AddRolesViewModelFactory
    private lateinit var viewModel: AddRolesViewModel

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

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        binding.lifecycleOwner = this
        val application = requireNotNull(this.activity).application
        val dataSource = GuestDatabase.getInstance(application).guestRoleDatabaseDao
        viewModelFactory = AddRolesViewModelFactory(dataSource)
        viewModel = ViewModelProvider(this, viewModelFactory).get(AddRolesViewModel::class.java)

        viewModel.orden.observe(viewLifecycleOwner, Observer { order ->
            binding.seekBarValue.text = order.toString()
        })

        binding.viewModel = viewModel
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.add_menu, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == R.id.action_save) {
            viewModel.insertGuestRole()
            activity?.onBackPressed()
        }
        return super.onOptionsItemSelected(item)
    }
}
