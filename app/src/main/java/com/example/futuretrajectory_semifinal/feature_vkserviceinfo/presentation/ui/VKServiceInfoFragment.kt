package com.example.futuretrajectory_semifinal.feature_vkserviceinfo.presentation.ui

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.setFragmentResultListener
import androidx.fragment.app.viewModels
import com.example.futuretrajectory_semifinal.IoC
import com.example.futuretrajectory_semifinal.core_data.model.VKServiceInfo
import com.example.futuretrajectory_semifinal.core_navigation.Navigator
import com.example.futuretrajectory_semifinal.core_navigation.VKServiceInfoNavigation
import com.example.futuretrajectory_semifinal.core_utils.datawrappers.Result
import com.example.futuretrajectory_semifinal.core_utils.imageloading.GlideImageLoader
import com.example.futuretrajectory_semifinal.core_utils.imageloading.ImageLoader
import com.example.futuretrajectory_semifinal.databinding.FragmentVkserviceInfoBinding
import com.example.futuretrajectory_semifinal.feature_vkserviceinfo.domain.usecase.GetVKServiceByNameUseCase
import com.example.futuretrajectory_semifinal.feature_vkserviceinfo.presentation.stateholders.VKServiceInfoViewModel
import com.example.futuretrajectory_semifinal.feature_vkserviceinfo.presentation.stateholders.VKServiceInfoViewModelFactory


class VKServiceInfoFragment : Fragment() {

    private val binding: FragmentVkserviceInfoBinding by lazy(LazyThreadSafetyMode.NONE) {
        FragmentVkserviceInfoBinding.inflate(layoutInflater)
    }

    lateinit var imageLoader: ImageLoader

    lateinit var navigation: VKServiceInfoNavigation

    lateinit var vkServiceInfoViewModelFactory: VKServiceInfoViewModelFactory

    private var uri: String? = null

    private val viewModel: VKServiceInfoViewModel by viewModels {
        vkServiceInfoViewModelFactory
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val view = binding.root


        vkServiceInfoViewModelFactory = VKServiceInfoViewModelFactory(
            GetVKServiceByNameUseCase(
                IoC.getRepository()
            )
        )

        imageLoader = GlideImageLoader()

        navigation = Navigator(parentFragmentManager)

        checkForArgs()
        setUpListeners()
        return view
    }

    private fun checkForArgs() {
        setFragmentResultListener("vkServiceName") { requestKey, bundle ->
            val name = bundle.getString("bundleKey") ?: ""
            setExistingService(name)
        }
    }

    private fun setUpListeners() {
        binding.closeBut.setOnClickListener {
            navigation.backToList()
        }

        binding.url.setOnClickListener {
            val browserIntent = Intent(Intent.ACTION_VIEW, Uri.parse(uri))
            startActivity(browserIntent)
        }
    }

    private fun setExistingService(name: String) {
        viewModel.getByName(name)
        viewModel.currentVKServiceLD.observe(viewLifecycleOwner) { vkService ->
            when (vkService) {
                is Result.Success -> {
                    expandVKService(vkService.value)
                    uri = vkService.value.service_url
                }
                is Result.Error -> Log.e("MMM", "Error")
                is Result.Loading -> Log.e("MMM", "Loading")
            }
        }
    }

    private fun expandVKService(vkServiceInfo: VKServiceInfo) {
        imageLoader.load(
            requireContext(),
            vkServiceInfo.icon_url,
            binding.icon
        )
        binding.apply {
            name.text = vkServiceInfo.name
            descriprion.text = vkServiceInfo.description
            url.text = vkServiceInfo.service_url
        }
    }
}