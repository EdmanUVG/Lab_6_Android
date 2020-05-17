package com.example.lab_5_android.ui.add

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import android.view.*
import android.widget.ArrayAdapter
import android.widget.EditText
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController

import com.example.lab_5_android.R
import com.example.lab_5_android.database.Guest
import com.example.lab_5_android.database.GuestDatabase
import com.example.lab_5_android.database.GuestRole
import com.example.lab_5_android.databinding.FragmentAddBinding
import com.example.lab_5_android.databinding.FragmentGuestBinding
import com.example.lab_5_android.ui.guest.GuestViewModelFactory
import kotlinx.android.synthetic.main.fragment_add.*
import kotlinx.android.synthetic.main.fragment_register.*


class AddFragment : Fragment() {

    private lateinit var viewModelFactory: AddViewModelFactory
    private lateinit var viewModel: AddViewModel

    private lateinit var binding: FragmentAddBinding

    private var guest: Guest? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                                savedInstanceState: Bundle?): View? {

        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_add,
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
        //Create an instance of the ViewModel Factory
        val dataSource = GuestDatabase.getInstance(application).guestDatabaseDao
        val dataSourceRole = GuestDatabase.getInstance(application).guestRoleDatabaseDao
        viewModelFactory = AddViewModelFactory(dataSource, dataSourceRole)
        viewModel = ViewModelProvider(this, viewModelFactory).get(AddViewModel::class.java)

        binding.viewModel = viewModel

        val items = arrayListOf<GuestRole>()
        val arrayAdapter = ArrayAdapter(requireContext(), android.R.layout.simple_spinner_item, items)
        binding.spinner.adapter = arrayAdapter

        viewModel.rolesList.observe(viewLifecycleOwner, Observer {
            items.clear()
            items.addAll(it)
            if (it.isNotEmpty()) binding.spinner.setSelection(0)
            arrayAdapter.notifyDataSetChanged()
        })

    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.add_menu, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == R.id.action_save) {
            viewModel.insertGuest(binding.spinner.selectedItem)
            activity?.onBackPressed()
        }
        return super.onOptionsItemSelected(item)
    }
}
