package com.example.futuretrajectory_semifinal.feature_vkservicelist.presentation.ui

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.fragment.app.setFragmentResult
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.futuretrajectory_semifinal.IoC
import com.example.futuretrajectory_semifinal.core_data.model.VKServiceListItem
import com.example.futuretrajectory_semifinal.core_data.repository.VKServiceRepository
import com.example.futuretrajectory_semifinal.core_data.repository.VKServiceRepositoryImpl
import com.example.futuretrajectory_semifinal.core_navigation.Navigator
import com.example.futuretrajectory_semifinal.core_network.client.NetworkClient
import com.example.futuretrajectory_semifinal.core_network.client.NetworkClientImpl
import com.example.futuretrajectory_semifinal.core_network.datasource.VKServiceRemoteDataSource
import com.example.futuretrajectory_semifinal.core_network.datasource.retrofit.RetrofitClient
import com.example.futuretrajectory_semifinal.core_network.datasource.retrofit.VKServiceApi
import com.example.futuretrajectory_semifinal.core_network.datasource.retrofit.VKServiceRemoteDataSourceImpl
import com.example.futuretrajectory_semifinal.core_navigation.VKServiceListNavigation
import com.example.futuretrajectory_semifinal.feature_vkservicelist.presentation.recycler.VKServiceClickListener
import com.example.futuretrajectory_semifinal.feature_vkservicelist.presentation.recycler.VKServiceListAdapter
import com.example.futuretrajectory_semifinal.feature_vkservicelist.presentation.recycler.VKServiceListDiffUtil
import com.example.futuretrajectory_semifinal.feature_vkservicelist.presentation.stateholders.VKServiceListViewModel
import com.example.futuretrajectory_semifinal.feature_vkservicelist.presentation.stateholders.VKServiceListViewModelFactory
import com.example.futuretrajectory_semifinal.core_utils.datawrappers.Result
import com.example.futuretrajectory_semifinal.databinding.FragmentVkserviceListBinding
import com.example.futuretrajectory_semifinal.feature_vkservicelist.domain.usecase.GetVKServiceListUseCase

class VKServiceListFragment : Fragment(), VKServiceClickListener {

    private val binding: FragmentVkserviceListBinding by lazy(LazyThreadSafetyMode.NONE) {
        FragmentVkserviceListBinding.inflate(layoutInflater)
    }

    lateinit var vkServiceListViewModelFactory: VKServiceListViewModelFactory

    lateinit var navigation: VKServiceListNavigation

    private val viewModel: VKServiceListViewModel by viewModels {
        vkServiceListViewModelFactory
    }

    private var adapter: VKServiceListAdapter? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val view = binding.root


        vkServiceListViewModelFactory =
            VKServiceListViewModelFactory(
                GetVKServiceListUseCase(
                    IoC.getRepository()
                )
            )

        navigation = Navigator(parentFragmentManager)

        setUpRecycler()
        setUpObservers()

        binding.responseError.setOnClickListener {
            viewModel.tryAgain()
        }

        return view
    }

    private fun setUpRecycler() {

        val tasksRecyclerView = binding.todoRecyclerView
        tasksRecyclerView.layoutManager = LinearLayoutManager(activity)

        val VKServiceListDiffUtil = VKServiceListDiffUtil()
        adapter = VKServiceListAdapter(
            VKServiceListDiffUtil,
            this
        )
        tasksRecyclerView.adapter = adapter
    }

    private fun setUpObservers() {
        viewModel.vkServiceListLD.observe(viewLifecycleOwner) { response ->
            when (response) {
                is Result.Success -> {
                    adapter?.submitList(response.value)
                    dataIsLoaded()
                }
                is Result.Error -> {
                    showResponseError()
                }
                is Result.Loading -> showLoading()

            }
        }
    }

    private fun showLoading() {
        binding.todoRecyclerView.isVisible = false
        binding.progress.isVisible = true
        binding.responseError.isVisible = false
    }

    private fun dataIsLoaded() {
        binding.todoRecyclerView.isVisible = true
        binding.progress.isVisible = false
        binding.responseError.isVisible = false
    }

    private fun showResponseError() {
        binding.todoRecyclerView.isVisible = false
        binding.progress.isVisible = false
        binding.responseError.isVisible = true
    }

    override fun onItemClick(vkServiceListItem: VKServiceListItem) {

        val name = vkServiceListItem.name
        setFragmentResult("vkServiceName", bundleOf("bundleKey" to name))
        navigation.showVKServiceInfo(vkServiceListItem.name)
    }
}