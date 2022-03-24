package com.example.mygprogram

/**
 * @description 首页
 * @author LLLError 2022.3.23
 */
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.example.mygprogram.view.WalkActivity

class   MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        findViewById<Button>(R.id.btn_walk).setOnClickListener {
            //走路加速度数据采集
            WalkActivity.start(this)
        }
        findViewById<Button>(R.id.btn_run).setOnClickListener {
            //跑步加速度数据采集

        }
        findViewById<Button>(R.id.btn_jump).setOnClickListener {
            //跳跃加速度数据采集

        }
        findViewById<Button>(R.id.btn_fall).setOnClickListener {
            //摔倒加速度数据采集

        }
    }
}