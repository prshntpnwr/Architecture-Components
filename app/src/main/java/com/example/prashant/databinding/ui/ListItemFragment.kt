package com.example.prashant.databinding.ui

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProvider
import android.arch.lifecycle.ViewModelProviders
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.prashant.databinding.R
import com.example.prashant.databinding.data.Contact
import com.example.prashant.databinding.databinding.FragmentListItemBinding
import com.example.prashant.databinding.di.Injectable
import com.example.prashant.databinding.observer.ItemViewModel
import java.util.*
import javax.inject.Inject

/**
 * A simple [Fragment] subclass.
 * Activities that contain this fragment must implement the
 * [ListItemFragment.OnFragmentInteractionListener] interface
 * to handle interaction events.
 * Use the [ListItemFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class ListItemFragment : Fragment(), Injectable {
    private val contactArrayList = ArrayList<Contact>()

    @Inject
    lateinit var itemFactory: ViewModelProvider.Factory

    @Inject
    lateinit var viewModel: ItemViewModel

    lateinit var binding: FragmentListItemBinding

    override fun onCreateView(inflater: LayoutInflater,
                              container: ViewGroup?,
                              savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(
                inflater,
                R.layout.fragment_list_item,
                container,
                false)
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders
                .of(this, itemFactory)
                .get(ItemViewModel::class.java)

        binding.let {
            it.recyclerView.adapter = ItemAdapter(contactArrayList)
            it.lifecycleOwner = this
            it.executePendingBindings()
        }

        viewModel.let {
            it.init()
            it.contacts.observe(this, Observer{ list ->
                // Update UI
                contactArrayList.clear()
                contactArrayList.addAll(list!!)
            })
        }
    }
}
