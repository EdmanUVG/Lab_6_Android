package com.example.lab_5_android.ui.roles

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.findNavController

import com.example.lab_5_android.R
import com.example.lab_5_android.databinding.FragmentRolesBinding
import kotlinx.android.synthetic.main.fragment_guest.*

class RolesFragment : Fragment() {

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

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        fab.setOnClickListener {
            findNavController().navigate(R.id.roles_to_addRoles)
        }
    }


}
