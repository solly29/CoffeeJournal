package com.example.coffeejournal.presentation.customview

import android.content.Context
import android.os.Handler
import android.os.Looper
import android.util.AttributeSet
import android.view.*
import android.widget.ImageView
import android.widget.LinearLayout
import androidx.core.view.children
import com.example.coffeejournal.R
import kotlinx.coroutines.*

class IntroCustomImage @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : LinearLayout(context, attrs, defStyleAttr) {

    private var isStartProgress = true
    var delayTime = 1500L
    private var listener: ((Boolean) -> Unit)? = null
    var delay = true

    init {
        val inflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        val view = inflater.inflate(R.layout.custom_intro_image, this, false)
        addView(view)
    }

    fun stopProgress(){
        isStartProgress = false
    }

    fun startProgress(){
        isStartProgress = true
    }

    fun isStart() = isStartProgress

    fun onStopListener(listener: ((Boolean) -> Unit)?) { this.listener = listener }

    private fun setHandler(){
        Handler(Looper.getMainLooper()).postDelayed({
            stopProgress()
            listener?.invoke(!isStartProgress)
        }, delayTime)
    }

    fun showProgress() {
        CoroutineScope(Dispatchers.Main).launch {
            if(delay)
                setHandler()
            while (isStartProgress) {
                val layout = findViewById<LinearLayout>(R.id.custom_loading_layout)
                for (i in 0 until layout.childCount) {
                    (layout.getChildAt(i) as ImageView).visibility = View.VISIBLE
                    delay(200)
                }
                layout.children.all {
                    it.visibility = View.INVISIBLE
                    true
                }
                delay(200)
            }
        }
    }
}