package net.skyscanner.backpack.demo.stories

import android.os.Bundle
import android.view.View
import android.widget.RadioGroup
import kotlinx.android.synthetic.main.calendar_selection_type.range
import kotlinx.android.synthetic.main.calendar_selection_type.single
import kotlinx.android.synthetic.main.fragment_calendar_colored.bpkCalendar
import kotlinx.android.synthetic.main.fragment_calendar_colored.shiftColorsButton
import kotlinx.android.synthetic.main.fragment_calendar_default.selection_type
import net.skyscanner.backpack.calendar.BpkCalendar
import net.skyscanner.backpack.calendar.presenter.SelectionType
import net.skyscanner.backpack.demo.R
import net.skyscanner.backpack.demo.data.ExampleBpkCalendarController

class DisabledCalendarStory : Story() {

  lateinit var controller: ExampleBpkCalendarController

  override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    super.onViewCreated(view, savedInstanceState)

    controller = ExampleBpkCalendarController(requireContext(), disableDates = true)
    val bpkCalendar = view.findViewById<BpkCalendar>(R.id.bpkCalendar)
    controller.isColoredCalendar = true
    initSelectionTypeSwitcher()
    shiftColorsButton.setOnClickListener {
      controller.shiftDisabledDates()
      controller.updateContent()
    }
    bpkCalendar.setController(controller)
  }

  private fun initSelectionTypeSwitcher() {
    single.text = "Single"
    range.text = "Range"
    range.isChecked = true

    selection_type.visibility = View.VISIBLE

    (selection_type as? RadioGroup)?.setOnCheckedChangeListener { _, checkedId ->
      when (checkedId) {
        R.id.single -> {
          controller = ExampleBpkCalendarController(requireContext(), SelectionType.SINGLE, disableDates = true)
        }
        R.id.range -> {
          controller = ExampleBpkCalendarController(requireContext(), SelectionType.RANGE, disableDates = true)
        }
      }
      controller.isColoredCalendar = true
      bpkCalendar.setController(controller)
    }
  }

  companion object {
    private const val LAYOUT_ID = "fragment_id"

    infix fun of(fragmentLayout: Int) = DisabledCalendarStory().apply {
      arguments = Bundle()
      arguments?.putInt(LAYOUT_ID, fragmentLayout)
    }
  }
}
