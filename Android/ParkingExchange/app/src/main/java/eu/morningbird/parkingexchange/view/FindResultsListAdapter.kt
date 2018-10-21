package eu.morningbird.parkingexchange.view

import android.databinding.DataBindingUtil
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup

import eu.morningbird.parkingexchange.R
import eu.morningbird.parkingexchange.databinding.ItemFindResultBinding
import eu.morningbird.parkingexchange.data.Location
import eu.morningbird.parkingexchange.viewmodel.FindResultVM

class FindResultsListAdapter : RecyclerView.Adapter<FindResultsListAdapter.FindResultsListAdapterViewHolder>() {

    var locationList: List<Location>? = emptyList()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FindResultsListAdapterViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val itemLocationBinding: ItemFindResultBinding = DataBindingUtil.inflate(layoutInflater, R.layout.item_find_result, parent, false)
        return FindResultsListAdapterViewHolder(itemLocationBinding)
    }

    override fun onBindViewHolder(holder: FindResultsListAdapterViewHolder, position: Int) {
        holder.bindLocations(locationList!![position])
    }

    override fun getItemCount(): Int {
        return locationList!!.size
    }


    class FindResultsListAdapterViewHolder(var mItemLocationBinding: ItemFindResultBinding) : RecyclerView.ViewHolder(mItemLocationBinding.itemPlant) {


        internal fun bindLocations(location: Location) {
            if (mItemLocationBinding.viewModel == null) {
                mItemLocationBinding.viewModel = FindResultVM()
                mItemLocationBinding.viewModel!!.attach(itemView.context)
                if (!mItemLocationBinding.viewModel!!.isDataLoaded) {
                    mItemLocationBinding.viewModel!!.loadData(location)
                }
            } else {
                mItemLocationBinding.viewModel!!.loadData(location)
            }
        }
    }
}
