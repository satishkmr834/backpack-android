package net.skyscanner.backpack.demo.stories

import android.os.Bundle
import android.view.View
import android.widget.TextView
import net.skyscanner.backpack.demo.R
import net.skyscanner.backpack.snackbar.BpkSnackbar
import net.skyscanner.backpack.snackbar.setAction

class SnackbarStory : Story() {

  override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    super.onViewCreated(view, savedInstanceState)

    view.findViewById<TextView>(R.id.snackbar_short).setOnClickListener {
      it as TextView
      BpkSnackbar.make(view, it.text, BpkSnackbar.LENGTH_SHORT)
        .setAction("Action!") {}
        .show()
    }

    view.findViewById<TextView>(R.id.snackbar_long).setOnClickListener {
      it as TextView
      BpkSnackbar.make(view, it.text, BpkSnackbar.LENGTH_LONG)
        .setAction("Action!") {}
        .show()
    }

    view.findViewById<TextView>(R.id.snackbar_indefinite).setOnClickListener {
      it as TextView
      BpkSnackbar.make(view, it.text, BpkSnackbar.LENGTH_INDEFINITE)
        .setAction("Action!") {}
        .show()
    }

    view.findViewById<TextView>(R.id.snackbar_title).setOnClickListener {
      it as TextView
      BpkSnackbar.make(view, "message", BpkSnackbar.LENGTH_INDEFINITE)
        .setTitle("Title")
        .setAction("Action!") {}
        .show()
    }

    view.findViewById<TextView>(R.id.snackbar_icon).setOnClickListener {
      it as TextView
      BpkSnackbar.make(view, "message", BpkSnackbar.LENGTH_INDEFINITE)
        .setIcon(R.drawable.bpk_tick_circle)
        .setAction("Action!") {}
        .show()
    }

    view.findViewById<TextView>(R.id.snackbar_title_icon).setOnClickListener {
      it as TextView
      BpkSnackbar.make(view, "message", BpkSnackbar.LENGTH_INDEFINITE)
        .setTitle("Title")
        .setIcon(R.drawable.bpk_tick_circle)
        .setAction("Action!") {}
        .show()
    }

    view.findViewById<TextView>(R.id.snackbar_iconOnly).setOnClickListener {
      it as TextView
      BpkSnackbar.make(view, "message", BpkSnackbar.LENGTH_INDEFINITE)
        .setAction(R.drawable.bpk_close) { }
        .show()
    }

    view.findViewById<TextView>(R.id.snackbar_title_iconOnly).setOnClickListener {
      it as TextView
      BpkSnackbar.make(view, "message", BpkSnackbar.LENGTH_INDEFINITE)
        .setTitle("Title")
        .setAction(R.drawable.bpk_close) { }
        .show()
    }

    view.findViewById<TextView>(R.id.snackbar_icon_iconOnly).setOnClickListener {
      it as TextView
      BpkSnackbar.make(view, "message", BpkSnackbar.LENGTH_INDEFINITE)
        .setIcon(R.drawable.bpk_tick_circle)
        .setAction(R.drawable.bpk_close) { }
        .show()
    }

    view.findViewById<TextView>(R.id.snackbar_title_icon_iconOnly).setOnClickListener {
      it as TextView
      BpkSnackbar.make(view, "message", BpkSnackbar.LENGTH_INDEFINITE)
        .setTitle("Title")
        .setAction(R.drawable.bpk_close) { }
        .setIcon(R.drawable.bpk_tick_circle)
        .show()
    }
  }

  companion object {
    private const val LAYOUT_ID = "fragment_id"

    infix fun of(fragmentLayout: Int) = SnackbarStory().apply {
      arguments = Bundle()
      arguments?.putInt(LAYOUT_ID, fragmentLayout)
    }
  }
}
