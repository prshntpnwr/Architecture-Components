package com.example.prashant.databinding.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.DataBindingComponent
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import com.example.prashant.databinding.R
import com.example.prashant.databinding.binding.FragmentDataBindingComponent
import com.example.prashant.databinding.databinding.ListBinding
import com.example.prashant.databinding.di.Injectable
import com.example.prashant.databinding.observer.ItemViewModel
import com.example.prashant.databinding.utils.AppExecutors
import com.example.prashant.databinding.utils.autoCleared
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

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    @Inject
    lateinit var viewModel: ItemViewModel

    @Inject
    lateinit var executors: AppExecutors

    var binding by autoCleared<ListBinding>()

    var dataBindingComponent: DataBindingComponent = FragmentDataBindingComponent(this)

    lateinit var mAdapter: ItemAdapter

    override fun onCreateView(inflater: LayoutInflater,
                              container: ViewGroup?,
                              savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(
                inflater,
                R.layout.fragment_list_item,
                container,
                false,
                dataBindingComponent)
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders
                .of(this, viewModelFactory)
                .get(ItemViewModel::class.java)

        mAdapter = ItemAdapter(dataBindingComponent, executors, null)

        binding.let {
            it.rvList.adapter = mAdapter
            it.lifecycleOwner = this
        }

        viewModel.let {
            it.init()
            it.contacts.observe(this, Observer { list ->
                mAdapter.submitList(list)
            })
        }
    }
}
