package com.example.canvas_jetpackcompose.viewmodel

import android.os.CountDownTimer
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class CanvasViewModel : ViewModel() {
    private var timer: CountDownTimer? = null
    private var second: Int = 30
    private val _second = MutableLiveData(0)
    val sec: LiveData<Int> get() = _second

    fun countDown(totalSec: Long) {
        timer = object : CountDownTimer(totalSec, 1000) {
            override fun onTick(p0: Long) {
                _second.value = second
                second--
            }

            override fun onFinish() {
                Log.d("CanvasFinish", "onFinish: Time Finished")
            }
        }

        timer?.start()
    }
}