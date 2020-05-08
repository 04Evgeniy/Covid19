package com.example.covid19_statistics.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.covid19_statistics.R
import com.example.covid19_statistics.data.CovidRepository
import kotlinx.android.synthetic.main.fragment_russia_data.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class RussiaFragmentData : Fragment(), CoroutineScope {
    override val coroutineContext = Dispatchers.Main

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_russia_data, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val repoLastDate = CovidRepository()

        launch {
            val countryLastCases = repoLastDate.getRussiaData().await()
            loader.visibility = View.GONE
            russia.visibility = View.VISIBLE
            rusConfirmed.visibility = View.VISIBLE
            russiaDeaths.visibility = View.VISIBLE
            rusRecovered.visibility = View.VISIBLE
            countryRusData.visibility = View.VISIBLE

            countryLastCases?.let {
                russia.text = it.country
                rusConfirmed.text = getString(R.string.all_confirmed_template).format(it.confirmed)
                russiaDeaths.text = getString(R.string.all_deaths_template).format(it.deaths)
                rusRecovered.text = getString(R.string.all_recovered_template).format(it.recovered)


            }
        }
    }
}