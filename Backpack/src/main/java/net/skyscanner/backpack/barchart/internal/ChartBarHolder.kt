package net.skyscanner.backpack.barchart.internal

import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import net.skyscanner.backpack.R
import net.skyscanner.backpack.barchart.BpkBarChart
import net.skyscanner.backpack.util.Consumer
import net.skyscanner.backpack.util.ItemHolder

internal class ChartBarHolder(
  parent: ViewGroup,
  private val colors: BpkBarChart.Colors,
  private val onClick: Consumer<BpkBarChart.Bar>,
  private val onLineChanged: Consumer<Float>
) : ItemHolder<BpkBarChart.Bar>(parent, R.layout.view_bpk_barchart_column) {

  init {
    view.setOnClickListener {
      model?.let {
        onClick(it)
        onLineChanged(chartView.bottom - chart.valueInPixels)
      }
    }
  }

  private val title = findViewById<TextView>(R.id.bpk_barchart_column_title).apply {
    setTextColor(colors.columnTitle)
  }

  private val subtitle = findViewById<TextView>(R.id.bpk_barchart_column_subtitle).apply {
    setTextColor(colors.columnSubtitle)
  }

  private val chart = ChartDrawable(colors.chartBackground, colors.chartForeground)

  private val chartView = findViewById<View>(R.id.bpk_barchart_column_chart).apply {
    background = chart
  }

  override fun bind(model: BpkBarChart.Bar) {
    title.text = model.title
    subtitle.text = model.subtitle
    chart.value = model.value
    view.isEnabled = !model.disabled
  }
}