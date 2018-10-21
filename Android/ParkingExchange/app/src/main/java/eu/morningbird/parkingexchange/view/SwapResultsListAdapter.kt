package eu.morningbird.parkingexchange.view

import android.databinding.DataBindingUtil
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup

import eu.morningbird.parkingexchange.R
import eu.morningbird.parkingexchange.databinding.ItemSwapResultBinding
import eu.morningbird.parkingexchange.data.Location
import eu.morningbird.parkingexchange.viewmodel.SwapResultVM

class SwapResultsListAdapter : RecyclerView.Adapter<SwapResultsListAdapter.SwapResultsListAdapterViewHolder>() {

    var locationList: List<Location>? = emptyList()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SwapResultsListAdapterViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val itemLocationBinding: ItemSwapResultBinding = DataBindingUtil.inflate(layoutInflater, R.layout.item_swap_result, parent, false)
        return SwapResultsListAdapterViewHolder(itemLocationBinding)
    }

    override fun onBindViewHolder(holder: SwapResultsListAdapterViewHolder, position: Int) {
        holder.bindLocations(locationList!![position])
    }

    override fun getItemCount(): Int {
        return locationList!!.size
    }


    class SwapResultsListAdapterViewHolder(var mItemLocationBinding: ItemSwapResultBinding) : RecyclerView.ViewHolder(mItemLocationBinding.itemPlant) {


        internal fun bindLocations(location: Location) {
            if (mItemLocationBinding.viewModel == null) {
                mItemLocationBinding.viewModel = SwapResultVM()
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
