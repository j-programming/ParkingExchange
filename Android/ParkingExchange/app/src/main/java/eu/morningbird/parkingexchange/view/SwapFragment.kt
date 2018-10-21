package eu.morningbird.parkingexchange.view

import android.content.Context
import android.content.Intent
import android.databinding.DataBindingUtil
import android.databinding.Observable
import android.net.Uri
import android.os.Bundle
import android.os.Handler
import android.support.v4.app.Fragment
import android.support.v7.widget.DefaultItemAnimator
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ProgressBar

import eu.morningbird.parkingexchange.R
import eu.morningbird.parkingexchange.R.id.listPlantsRecyclerView
import eu.morningbird.parkingexchange.data.LocationsTempAccess
import eu.morningbird.parkingexchange.data.Preferences

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PLACE = "place"
private const val ARG_LON = "lon"
private const val ARG_LAT = "lat"


/**
 * A simple [Fragment] subclass.
 * Activities that contain this fragment must implement the
 * [FindFragment.OnFragmentInteractionListener] interface
 * to handle interaction events.
 * Use the [FindFragment.newInstance] factory method to
 * create an instance of this fragment.
 *
 */
class SwapFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var place: String? = null
    private var lon: Double? = null
    private var lat: Double? = null
    private var fragmentView: View? = null

    private var listener: OnFragmentInteractionListener? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            place = it.getString(ARG_PLACE)
            lon = it.getDouble(ARG_LON)
            lat = it.getDouble(ARG_LAT)
        }
    }



    private fun setupAdapter() {
        fragmentView!!.findViewById<RecyclerView>(R.id.listPlantsRecyclerView).visibility = View.GONE
        fragmentView!!.findViewById<ProgressBar>(R.id.resultsProgressBar).visibility = View.VISIBLE
        val handler = Handler()
        handler.postDelayed({
            fragmentView!!.findViewById<RecyclerView>(R.id.listPlantsRecyclerView).visibility = View.VISIBLE
            fragmentView!!.findViewById<ProgressBar>(R.id.resultsProgressBar).visibility = View.GONE
        }, 3000)
        val recycler = fragmentView!!.findViewById<RecyclerView>(R.id.listPlantsRecyclerView)
        recycler.itemAnimator = DefaultItemAnimator()
        recycler.layoutManager = LinearLayoutManager(getActivity())
        val adapter = SwapResultsListAdapter()
        adapter.locationList = LocationsTempAccess.getSwapLocations()
        recycler.adapter = adapter
    }

    private fun updateView() {
        val recycler = fragmentView!!.findViewById<RecyclerView>(R.id.listPlantsRecyclerView)
        if (recycler.adapter == null) setupAdapter()
    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        fragmentView = inflater.inflate(R.layout.fragment_swap, container, false)
        updateView()
        return fragmentView
    }

    fun onShowOnMapButtonPressed(view: View) {
        listener?.onShowOnMapButtonPressed(view)
    }

    fun onPurchaseButtonPressed(view: View) {
        listener?.onPurchaseButtonPressed(view)
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is OnFragmentInteractionListener) {
            listener = context
        } else {
            throw RuntimeException(context.toString() + " must implement OnFragmentInteractionListener")
        }
    }

    override fun onDetach() {
        super.onDetach()
        listener = null
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     *
     *
     * See the Android Training lesson [Communicating with Other Fragments]
     * (http://developer.android.com/training/basics/fragments/communicating.html)
     * for more information.
     */
    interface OnFragmentInteractionListener {
        fun onPurchaseButtonPressed(view: View)
        fun onShowOnMapButtonPressed(view: View)
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @return A new instance of fragment FindFragment.
         */
        @JvmStatic
        fun newInstance(place: String, lon: Double, lat: Double) =
            SwapFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PLACE, place)
                    putDouble(ARG_LON, lon)
                    putDouble(ARG_LAT, lat)
                }
            }
    }
}
