package com.ajc.avadhut_demo_app.ui

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.widget.Toast
import com.ajc.avadhut_demo_app.R
import com.ajc.avadhut_demo_app.model.local.LoginDatabase
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_main.passwordEt
import kotlinx.android.synthetic.main.activity_main.signUpBtn
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val dao = LoginDatabase.getLoginDatabase(this).getLoginDAO()

        signUpBtn.setOnClickListener {
            startActivity(Intent(this, SignUpActivity::class.java))
        }

        signInBtn.setOnClickListener {
            CoroutineScope(Dispatchers.IO).launch {
                val user = dao.getUser(EmailSignIn.text.toString(), passwordEt.text.toString())


                if (user != null) {
                    if (user?.email?.isNotEmpty()) {
                        runOnUiThread {

                            val intent = Intent(this@MainActivity, ChooseTask::class.java)
                            startActivity(intent)
                            Toast.makeText(this@MainActivity, "success", Toast.LENGTH_SHORT).show()
                        }
                    }
                } else {
                    runOnUiThread {
                        Toast.makeText(
                            this@MainActivity,
                            "Enter Email and Password",
                            Toast.LENGTH_SHORT
                        ).show()
                    }
                }
            }
        }
    }
}