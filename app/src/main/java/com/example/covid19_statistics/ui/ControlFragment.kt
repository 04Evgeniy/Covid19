package com.example.covid19_statistics.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.covid19_statistics.R
import kotlinx.android.synthetic.main.activity_control.*

class ControlFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.activity_control, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        frameOne.setOnClickListener {
            fragmentManager?.beginTransaction()
                ?.replace(R.id.navHost, GlobalFragment())
                ?.addToBackStack(null)
                ?.commit()
        }

        frameTwo.setOnClickListener {
            fragmentManager?.beginTransaction()
                ?.replace(R.id.navHost, CountryDataFragment())
                ?.addToBackStack(null)
                ?.commit()
        }
        frameThree.setOnClickListener {
            fragmentManager?.beginTransaction()
                ?.replace(R.id.navHost, RussiaFragmentData())
                ?.addToBackStack(null)
                ?.commit()
        }
        frameFour.setOnClickListener {
            fragmentManager?.beginTransaction()
                ?.replace(R.id.navHost, UsaFragmentData())
                ?.addToBackStack(null)
                ?.commit()
        }
    }

}