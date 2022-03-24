package com.example.mygprogram.viewmodel

import android.content.Context
import android.hardware.Sensor
import android.hardware.SensorEvent
import android.hardware.SensorEventListener
import android.hardware.SensorManager
import androidx.core.content.ContextCompat.getSystemService
import androidx.lifecycle.ViewModel
import com.github.mikephil.charting.data.LineDataSet

class ChartViewModel : ViewModel(){
    // 把采集的数据设置到折线图中
    fun setChartData(lineData: ArrayList<LineDataSet>){

    }
}