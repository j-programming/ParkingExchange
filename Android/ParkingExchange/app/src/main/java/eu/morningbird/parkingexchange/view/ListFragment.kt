package eu.morningbird.parkingexchange.view

import android.content.Context
import android.content.Intent
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
import android.widget.Button
import android.widget.ProgressBar
import android.widget.TextView
import br.com.simplepass.loading_button_lib.customViews.CircularProgressButton

import eu.morningbird.parkingexchange.R
import eu.morningbird.parkingexchange.data.LocationsTempAccess
import kotlinx.android.synthetic.main.activity_login.*
import kotlinx.android.synthetic.main.fragment_list.*
import com.mcsoft.timerangepickerdialog.RangeTimePickerDialog



// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PLACE = "place"
private const val ARG_LON = "lon"
private const val ARG_LAT = "lat"

/**
 * A simple [Fragment] subclass.
 * Activities that contain this fragment must implement the
 * [ListFragment.OnFragmentInteractionListener] interface
 * to handle interaction events.
 * Use the [ListFragment.newInstance] factory method to
 * create an instance of this fragment.
 *
 */
class ListFragment : Fragment() {
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



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        fragmentView = inflater.inflate(R.layout.fragment_list, container, false)
        fragmentView!!.findViewById<TextView>(R.id.nameTextView).text = place
        fragmentView!!.findViewById<TextView>(R.id.locationTextView).text = "at " + lon + ", " + lat
        fragmentView!!.findViewById<CircularProgressButton>(R.id.addButton).setOnClickListener { view: View ->
            val circularProgressButton = view as CircularProgressButton
            if(!circularProgressButton.isAnimating){
                circularProgressButton.startAnimation()
                val handler = Handler()
                handler.postDelayed({
                    listener?.onAddButtonPressed(view)
                }, 3000)

            }

        }

        return fragmentView
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
        fun onAddButtonPressed(view: View)
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
            ListFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PLACE, place)
                    putDouble(ARG_LON, lon)
                    putDouble(ARG_LAT, lat)
                }
            }
    }
}
