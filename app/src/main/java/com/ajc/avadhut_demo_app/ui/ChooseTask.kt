package com.ajc.avadhut_demo_app.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.widget.Toast
import com.ajc.avadhut_demo_app.R
import com.ajc.avadhut_demo_app.chart.LineChartActivity1
import kotlinx.android.synthetic.main.activity_choosetask.*
import kotlinx.android.synthetic.main.activity_signup.*

class ChooseTask : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_choosetask)

        graph1.setOnClickListener {
            val intent = Intent(this@ChooseTask, LineChartActivity1::class.java)
            startActivity(intent)
            val msg = "Total cases in India vs the world"
            val toast = Toast.makeText(applicationContext, msg, Toast.LENGTH_SHORT)
            toast.show()
            val handler = Handler()
            handler.postDelayed(Runnable { toast.cancel() }, 2000)
        }

        graph2.setOnClickListener {
            val intent = Intent(this@ChooseTask, LineChartActivity1::class.java)
            startActivity(intent)
            val msg = "New cases vs deaths in India"
            val toast = Toast.makeText(applicationContext, msg, Toast.LENGTH_SHORT)
            toast.show()
            val handler = Handler()
            handler.postDelayed(Runnable { toast.cancel() }, 2000)
        }

        graph3.setOnClickListener {
            val intent = Intent(this@ChooseTask, LineChartActivity1::class.java)
            startActivity(intent)
            val msg = "Total cases in India vs the world"
            val toast = Toast.makeText(applicationContext, msg, Toast.LENGTH_SHORT)
            toast.show()
            val handler = Handler()
            handler.postDelayed(Runnable { toast.cancel() }, 2000)
        }
    }
}