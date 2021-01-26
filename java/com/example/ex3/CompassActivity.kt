package com.example.ex3

import android.content.Context
import android.hardware.Sensor
import android.hardware.SensorEvent
import android.hardware.SensorEventListener
import android.hardware.SensorManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.animation.Animation
import android.view.animation.RotateAnimation
import kotlinx.android.synthetic.main.activity_compass.*

class CompassActivity : AppCompatActivity(), SensorEventListener {

    var sensManager: SensorManager? = null
    var current_degree: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_compass)
        sensManager = getSystemService(Context.SENSOR_SERVICE) as SensorManager

    }

    override fun onResume() {
        super.onResume()
        sensManager?.registerListener(
            this,
            sensManager?.getDefaultSensor(Sensor.TYPE_ORIENTATION),
            SensorManager.SENSOR_DELAY_GAME
        )
    }

    override fun onPause() {
        super.onPause()
        sensManager?.unregisterListener(this)
    }

    override fun onSensorChanged(p0: SensorEvent?) {
        val degree: Int = p0?.values?.get(0)?.toInt()!!
        tv_Degree.text = degree.toString()
        val rotation = RotateAnimation(
            current_degree.toFloat(), (-degree).toFloat(),
            Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f
        )
        rotation.duration = 210
        rotation.fillAfter = true
        current_degree = -degree
        imgDunamic.startAnimation(rotation)
    }

    override fun onAccuracyChanged(p0: Sensor?, p1: Int) {

    }
}