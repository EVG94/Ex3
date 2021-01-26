package com.example.ex3

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.anupkumarpanwar.scratchview.ScratchView
import kotlinx.android.synthetic.main.activity_scratch.*

class ScratchActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_scratch)

        val scratchView = findViewById<ScratchView>(R.id.scratchView)
        scratchView.setRevealListener(object :ScratchView.IRevealListener{
            override fun onRevealed(scratchView: ScratchView?) {
                Toast.makeText(applicationContext, "complete", Toast.LENGTH_SHORT).show()
            }

            override fun onRevealPercentChangedListener(scratchView: ScratchView?, percent: Float) {

            }
        })
    }
}