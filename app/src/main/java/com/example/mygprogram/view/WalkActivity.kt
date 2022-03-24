package com.example.mygprogram.view

/**
 * @description 走路加速度数据监测页
 * @author LLLError 2022.3.23
 */
import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.hardware.Sensor
import android.hardware.SensorEvent
import android.hardware.SensorEventListener
import android.hardware.SensorManager
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.mygprogram.R
import com.example.mygprogram.model.chartModel
import com.github.mikephil.charting.charts.LineChart

class WalkActivity: AppCompatActivity(), SensorEventListener {
    var sensorManager:SensorManager? = null
    var sensor:Sensor? = null
    private lateinit var btn_walk_start: Button
    private lateinit var btn_walk_end: Button
    private lateinit var chart_walk: LineChart
    private var start: Boolean = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_walk)
        initView()
        initSensor()
    }

    private fun initView(){
        btn_walk_start = findViewById(R.id.btn_walk_start)
        btn_walk_end = findViewById(R.id.btn_walk_end)
        chart_walk = findViewById(R.id.chart_walk)

        btn_walk_start.setOnClickListener(){
            if(!start){
                start = true
            }
        }
        btn_walk_end.setOnClickListener(){
            if (start){
                start = false
            }
        }
    }


    //传感器初始化
    private fun initSensor(){
        sensorManager = getSystemService(Context.SENSOR_SERVICE) as SensorManager
        sensor = sensorManager!!.getDefaultSensor(Sensor.TYPE_ACCELEROMETER)
    }

    //传感器的值更改时调用
    override fun onSensorChanged(event: SensorEvent?) {
        val values = event?.values
        var x = values!![0]
        var y = values!![1]
        var z = values!![2]
        var accsqrt = x * x + y * y + z * z
//        chart_walk.text = "X轴加速度$x\nY轴加速度$y\nZ轴加速度$z"
    }

    //传感器的准确性更改时调用
    override fun onAccuracyChanged(p0: Sensor?, p1: Int) {

    }

    override fun onResume() {
        super.onResume()
        //注册传感器事件
        sensorManager?.registerListener(this, sensor, SensorManager.SENSOR_DELAY_NORMAL)
    }

    override fun onPause() {
        super.onPause()
        //解除传感器事件注册
        sensorManager?.unregisterListener(this)
    }

    companion object {
        fun start(context: Context) {
            val intent = Intent(context, WalkActivity::class.java)
            context.startActivity(intent)
        }
    }

}