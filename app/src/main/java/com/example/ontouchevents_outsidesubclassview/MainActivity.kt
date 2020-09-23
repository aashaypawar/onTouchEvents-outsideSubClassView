package com.example.ontouchevents_outsidesubclassview

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.MotionEvent
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.MotionEventCompat

class MainActivity : AppCompatActivity() {
    @SuppressLint("ClickableViewAccessibility")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val mainView = findViewById<View>(R.id.main_view)
        val subView = findViewById<View>(R.id.view1)


        mainView.setOnTouchListener { v, event ->
                return@setOnTouchListener when (MotionEventCompat.getActionMasked(event)) {
                    MotionEvent.ACTION_DOWN -> {
                        if(isInside(subView,event)) {
                            Toast.makeText(applicationContext, "Inside", Toast.LENGTH_SHORT).show()
                        }
                        if(!isInside(subView,event)){
                            Toast.makeText(applicationContext, "Outside", Toast.LENGTH_SHORT).show()
                        }
                        true
                    }
                    else ->false
                }
            }
        }

    private fun isInside(v: View, e: MotionEvent): Boolean {
        return !(e.x < 0 || e.y < 0 || e.x > v.measuredWidth || e.y > v.measuredHeight)
    }

}



