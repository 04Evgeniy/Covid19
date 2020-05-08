package com.example.covid19_statistics.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.covid19_statistics.R
import com.example.covid19_statistics.data.CountryGlobalData
import kotlinx.android.synthetic.main.item_global_country_data.view.*

class CountriesGlobalDataAdapter(
    private val countries: List<CountryGlobalData>
):RecyclerView.Adapter<CountriesGlobalDataAdapter.CountryGlobalDataHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CountryGlobalDataHolder {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.item_global_country_data, parent, false)
        return CountryGlobalDataHolder(view)
    }

    override fun getItemCount() = countries.size

    override fun onBindViewHolder(holder: CountryGlobalDataHolder, position: Int) {
        holder.bind(countries[position])
    }

    class CountryGlobalDataHolder(itemView:View) : RecyclerView.ViewHolder(itemView){
        fun bind(countryGlobalData: CountryGlobalData) = itemView.apply {
            countryName.text = countryGlobalData.country
            countryNewConfirmed.text = resources.getString(R.string.new_confirmed_template).format(countryGlobalData.newConfirmed)
            countryNewDeaths.text = resources.getString(R.string.new_deaths_template).format(countryGlobalData.newDeaths)
            countryNewRecovered.text = resources.getString(R.string.new_recovered_template).format(countryGlobalData.newConfirmed)
            countryTotalConfirmed.text = resources.getString(R.string.total_confirmed_template).format(countryGlobalData.totalConfirmed)
            countryTotalDeaths.text = resources.getString(R.string.total_deaths_template).format(countryGlobalData.totalDeaths)
            countryTotalRecovered.text = resources.getString(R.string.total_recovered_template).format(countryGlobalData.totalRecovered)

        }
    }
}