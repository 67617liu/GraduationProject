package com.example.mygprogram.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.mygprogram.R
import com.example.mygprogram.viewmodel.ChartViewModel
import com.github.mikephil.charting.charts.LineChart
import com.github.mikephil.charting.components.XAxis
import com.github.mikephil.charting.components.YAxis
import com.github.mikephil.charting.data.LineData

class ChartFragment() : Fragment() {

    private lateinit var xAxis: XAxis
    private lateinit var yAxis: YAxis
    private lateinit var data: LineData
    private lateinit var chart: LineChart
    private lateinit var viewModel: ChartViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        init(chart)
    }

    // 初始化
    private fun init(chart: LineChart){
        // 获取 X 轴
        xAxis = chart.xAxis;
        // 允许显示 X 轴的垂直网格线
        xAxis.enableGridDashedLine(10f, 10f, 0f);
        // 设置 X 轴在下方显示
        xAxis.position = XAxis.XAxisPosition.BOTTOM
        // 获取 Y 轴并设置在左侧显示
        yAxis = chart.getAxis(YAxis.AxisDependency.LEFT)
        // 允许显示 X 轴的垂直网格线
        xAxis.enableGridDashedLine(10f, 10f, 0f);
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        var chartview: View = inflater.inflate(R.layout.chart_fragment, container, false)
        return chartview
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(ChartViewModel::class.java)
        // TODO: Use the ViewModel
    }
}