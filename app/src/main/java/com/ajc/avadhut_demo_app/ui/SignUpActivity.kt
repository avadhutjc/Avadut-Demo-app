package com.ajc.avadhut_demo_app.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.widget.Toast
import com.ajc.avadhut_demo_app.R
import com.ajc.avadhut_demo_app.model.local.LoginDAO
import com.ajc.avadhut_demo_app.model.local.LoginDatabase
import com.ajc.avadhut_demo_app.model.local.LoginEntity
import kotlinx.android.synthetic.main.activity_main.view.*
import kotlinx.android.synthetic.main.activity_signup.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class SignUpActivity : AppCompatActivity() {

    lateinit var database: LoginDatabase
    lateinit var dao: LoginDAO //creating dao obj

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signup)

        database = LoginDatabase.getLoginDatabase(this)
        dao = database.getLoginDAO()

        signUpBtn.setOnClickListener {
            val signUpData = LoginEntity(
                // nameEt.text.toString(),
                emailEtRegister.text.toString(),
                passwordEt.text.toString()
                //  ageEt.text.toString().toInt(),
                // mobileEt.text.toString().toInt(),
            )

            CoroutineScope(Dispatchers.IO).launch {
                dao.register(signUpData)
                //  finish()

                if (emailEtRegister.text.toString() == null) {
                    runOnUiThread {
                        val intent = Intent(this@SignUpActivity, MainActivity::class.java)
                        startActivity(intent)
                        Toast.makeText(
                            this@SignUpActivity,
                            "Successfully Account Created Now Login Here",
                            Toast.LENGTH_SHORT
                        ).show()
                    }
                } else {
                    runOnUiThread {
                        val msg = "Required Email and Password For Sign-Up"
                        val toast = Toast.makeText(applicationContext, msg, Toast.LENGTH_SHORT)
                        toast.show()
                        val handler = Handler()
                        handler.postDelayed(Runnable { toast.cancel() }, 3000)
                    }
                }
            }
        }

//            val intent = Intent(this@RegisterActivity, MainActivity::class.java)
//            startActivity(intent)
//            // Toast.makeText(this@RegisterActivity, Toast.LENGTH_SHORT).show()
//            val msg = "Successfully Sign-Up Now Login Here"
//            val toast = Toast.makeText(applicationContext, msg, Toast.LENGTH_SHORT)
//            toast.show()
//            val handler = Handler()
//            handler.postDelayed(Runnable { toast.cancel() }, 2000)
    }
}
/*
//            val msg = "Successfully Sign-Up Now Login Here"
//            val toast = Toast.makeText(applicationContext, msg, Toast.LENGTH_SHORT)
//            toast.show()
//            val handler = Handler()
//            handler.postDelayed(Runnable { toast.cancel() }, 2000)
 */