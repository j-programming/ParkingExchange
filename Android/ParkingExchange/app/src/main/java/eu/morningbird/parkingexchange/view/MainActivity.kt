package eu.morningbird.parkingexchange.view

import android.app.Activity
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.RecyclerView
import android.view.View
import com.mikepenz.materialdrawer.Drawer
import com.mikepenz.materialdrawer.DrawerBuilder
import com.mikepenz.materialdrawer.model.DividerDrawerItem
import com.mikepenz.materialdrawer.model.PrimaryDrawerItem
import com.mikepenz.materialdrawer.model.SecondaryDrawerItem
import com.mikepenz.materialdrawer.model.interfaces.IDrawerItem
import eu.morningbird.parkingexchange.R
import kotlinx.android.synthetic.main.activity_main.*
import android.support.v4.app.ShareCompat.IntentBuilder
import com.google.android.gms.location.places.ui.PlacePicker
import android.widget.Toast
import com.google.android.gms.location.places.Place
import android.content.Intent




class MainActivity : AppCompatActivity(), HomeFragment.OnFragmentInteractionListener, FindFragment.OnFragmentInteractionListener, ListFragment.OnFragmentInteractionListener, SwapFragment.OnFragmentInteractionListener {



    override fun onAddButtonPressed(view: View) {
        val fragment = HomeFragment.newInstance()
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.fragment_container, fragment)
        fragmentTransaction.commit()
        fragmentManager.executePendingTransactions()
    }


    val fragmentManager = supportFragmentManager
    var drawer : Drawer? = null
    val FIND_SPOT = 1
    val RENT_SPOT = 2
    val SWAP_SPOT = 3



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(mainActivityToolbar)
        createDrawer()
        val fragment = HomeFragment.newInstance()
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.fragment_container, fragment)
        fragmentTransaction.commit()
        fragmentManager.executePendingTransactions()
    }

    private fun createDrawer() {

        drawer = DrawerBuilder()
            .withActivity(this)
            .withToolbar(mainActivityToolbar)
            .addDrawerItems(
                PrimaryDrawerItem().withIdentifier(1).withName("Home").withOnDrawerItemClickListener { view: View, i: Int, iDrawerItem: IDrawerItem<Any, RecyclerView.ViewHolder> ->
                    val fragment = HomeFragment.newInstance()
                    val fragmentTransaction = fragmentManager.beginTransaction()
                    fragmentTransaction.replace(R.id.fragment_container, fragment)
                    fragmentTransaction.commit()
                    fragmentManager.executePendingTransactions()
                },
                DividerDrawerItem(),
                PrimaryDrawerItem().withIdentifier(2).withName("Find").withOnDrawerItemClickListener { view: View, i: Int, iDrawerItem: IDrawerItem<Any, RecyclerView.ViewHolder> ->
                    findSpot()
                    true
                },
                PrimaryDrawerItem().withIdentifier(3).withName("List").withOnDrawerItemClickListener { view: View, i: Int, iDrawerItem: IDrawerItem<Any, RecyclerView.ViewHolder> ->
                    rentSpot()
                    true
                },
                PrimaryDrawerItem().withIdentifier(4).withName("Swap").withOnDrawerItemClickListener { view: View, i: Int, iDrawerItem: IDrawerItem<Any, RecyclerView.ViewHolder> ->
                    swapSpot()
                    true
                },
                DividerDrawerItem(),
                PrimaryDrawerItem().withIdentifier(5).withName("Account").withOnDrawerItemClickListener { view: View, i: Int, iDrawerItem: IDrawerItem<Any, RecyclerView.ViewHolder> ->
                    val intent = Intent(applicationContext, NotImplementedActivity::class.java)
                    startActivity(intent)
                    true
                },
                PrimaryDrawerItem().withIdentifier(6).withName("Logout").withOnDrawerItemClickListener { view: View, i: Int, iDrawerItem: IDrawerItem<Any, RecyclerView.ViewHolder> ->
                    val intent = Intent(applicationContext, LoginActivity::class.java)
                    startActivity(intent)
                    true
                },
                DividerDrawerItem(),
                PrimaryDrawerItem().withIdentifier(7).withName("Settings").withOnDrawerItemClickListener { view: View, i: Int, iDrawerItem: IDrawerItem<Any, RecyclerView.ViewHolder> ->
                    val intent = Intent(applicationContext, NotImplementedActivity::class.java)
                    startActivity(intent)
                    true
                },
                PrimaryDrawerItem().withIdentifier(8).withName("About").withOnDrawerItemClickListener { view: View, i: Int, iDrawerItem: IDrawerItem<Any, RecyclerView.ViewHolder> ->
                    val intent = Intent(applicationContext, NotImplementedActivity::class.java)
                    startActivity(intent)
                    true
                }
            )
            .build()
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        if (requestCode == FIND_SPOT) {
            if (resultCode == Activity.RESULT_OK) {
                val place = PlacePicker.getPlace(this, data!!)

                val fragment = FindFragment.newInstance(String.format("%s", place.name), place.latLng.longitude, place.latLng.latitude)
                val fragmentTransaction = fragmentManager.beginTransaction()
                fragmentTransaction.replace(R.id.fragment_container, fragment)
                fragmentTransaction.commit()
                fragmentManager.executePendingTransactions()
            }
        }
        if (requestCode == RENT_SPOT) {
            if (resultCode == Activity.RESULT_OK) {
                val place = PlacePicker.getPlace(this, data!!)

                val fragment = ListFragment.newInstance(String.format("%s", place.name), place.latLng.longitude, place.latLng.latitude)
                val fragmentTransaction = fragmentManager.beginTransaction()
                fragmentTransaction.replace(R.id.fragment_container, fragment)
                fragmentTransaction.commit()
                fragmentManager.executePendingTransactions()
            }
        }

        if (requestCode == SWAP_SPOT) {
            if (resultCode == Activity.RESULT_OK) {
                val place = PlacePicker.getPlace(this, data!!)

                val fragment = SwapFragment.newInstance(String.format("%s", place.name), place.latLng.longitude, place.latLng.latitude)
                val fragmentTransaction = fragmentManager.beginTransaction()
                fragmentTransaction.replace(R.id.fragment_container, fragment)
                fragmentTransaction.commit()
                fragmentManager.executePendingTransactions()
            }
        }
    }



    private fun findSpot(){
        val builder = PlacePicker.IntentBuilder()
        startActivityForResult(builder.build(this), FIND_SPOT)
    }

    private fun rentSpot() {
        val builder = PlacePicker.IntentBuilder()
        startActivityForResult(builder.build(this), RENT_SPOT)
    }

    private fun swapSpot() {
        val builder = PlacePicker.IntentBuilder()
        startActivityForResult(builder.build(this), SWAP_SPOT)
    }

    override fun onRentButtonPressed(view: View) {
        rentSpot()
    }

    override fun onSwapButtonPressed(view: View) {
        swapSpot()
    }

    override fun onFindButtonPressed(view: View) {
        findSpot()
    }

    override fun onPurchaseButtonPressed(view: View) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onShowOnMapButtonPressed(view: View) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}
