package com.example.covid19_statistics.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.covid19_statistics.R
import com.example.covid19_statistics.data.CovidRepository
import kotlinx.android.synthetic.main.fragment_usa_data.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class UsaFragmentData : Fragment(), CoroutineScope {
    override val coroutineContext = Dispatchers.Main

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_usa_data, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val repoLastDate = CovidRepository()

        launch {
            val countryLastCases = repoLastDate.getUsaData().await()
            loader.visibility = View.GONE
            usa.visibility = View.VISIBLE
            usaConfirmed.visibility = View.VISIBLE
            usaDeaths.visibility = View.VISIBLE
            usaRecovered.visibility = View.VISIBLE
            countryUsaData.visibility = View.VISIBLE

            countryLastCases?.let {
                usa.text = it.country
                usaConfirmed.text = getString(R.string.all_deaths_template).format(it.deaths)
                usaDeaths.text = getString(R.string.all_confirmed_template).format(it.confirmed)
                usaRecovered.text = getString(R.string.all_recovered_template).format(it.recovered)


            }
        }
    }
}