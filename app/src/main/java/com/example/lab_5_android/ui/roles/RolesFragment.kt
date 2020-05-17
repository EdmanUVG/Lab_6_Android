package com.example.lab_5_android.ui.roles

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController

import com.example.lab_5_android.R
import com.example.lab_5_android.database.GuestDatabase
import com.example.lab_5_android.databinding.FragmentRolesBinding
import kotlinx.android.synthetic.main.fragment_guest.*

class RolesFragment : Fragment() {

    private lateinit var viewModelFactory: RolesViewModelFactory
    private lateinit var viewModel: RolesViewModel
    private lateinit var binding: FragmentRolesBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                                savedInstanceState: Bundle?): View? {

        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_roles,
            container,
            false
        )

        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        binding.lifecycleOwner = this

        val application = requireNotNull(this.activity).application
        val dataSource = GuestDatabase.getInstance(application).guestRoleDatabaseDao
        viewModelFactory =RolesViewModelFactory(dataSource)
        viewModel = ViewModelProvider(this, viewModelFactory).get(RolesViewModel::class.java)

        binding.viewModel = viewModel
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        fab.setOnClickListener {
            findNavController().navigate(R.id.roles_to_addRoles)
        }
    }


}
