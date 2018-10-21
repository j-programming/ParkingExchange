package eu.morningbird.parkingexchange.view

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.support.v7.app.AppCompatActivity
import eu.morningbird.parkingexchange.R
import eu.morningbird.parkingexchange.data.Preferences


class SlpashActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        val handler = Handler()
        handler.postDelayed({
            if (Preferences.userToken == null) {
                val intent = Intent(applicationContext, LoginActivity::class.java)
                startActivity(intent)
            } else {
                //MainActivity
            }
        }, 3000)
    }
}
