package com.example.futuretrajectory_semifinal.core_navigation

import androidx.fragment.app.FragmentManager
import com.example.futuretrajectory_semifinal.feature_vkserviceinfo.presentation.ui.VKServiceInfoFragment
import com.example.futuretrajectory_semifinal.R

class Navigator(
    private val fragmentManager: FragmentManager
) : VKServiceListNavigation, VKServiceInfoNavigation {


    override fun showVKServiceInfo(name: String) {
        fragmentManager.beginTransaction()
            .add(R.id.main_container, VKServiceInfoFragment())
            .addToBackStack(null)
            .commit()
    }

    override fun backToList() {
        fragmentManager.popBackStack()
    }

}