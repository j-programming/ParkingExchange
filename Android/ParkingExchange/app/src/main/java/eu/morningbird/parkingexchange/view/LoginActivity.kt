package eu.morningbird.parkingexchange.view

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.support.v7.app.AppCompatActivity
import android.view.View
import br.com.simplepass.loading_button_lib.customViews.CircularProgressButton
import eu.morningbird.parkingexchange.R
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
    }

    fun onLoginButtonClicked(view: View) {

        val circularProgressButton = view as CircularProgressButton
        if(!circularProgressButton.isAnimating){
            circularProgressButton.startAnimation()
            val handler = Handler()
            handler.postDelayed({
                if(emailEditText.text.toString() == "test@test.test" && passwordEditText.text.toString() == "test") {
                    val intent = Intent(applicationContext, MainActivity::class.java)
                    startActivity(intent)
                } else {
                    passwordEditText.error = "Invalid password"
                    circularProgressButton.stopAnimation()
                }

            }, 3000)

        }

    }

    fun onRegisterTextViewClicked(view: View) {
        val intent = Intent(applicationContext, NotImplementedActivity::class.java)
        startActivity(intent)
    }
}
