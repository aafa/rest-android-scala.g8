package $package$.activity


import $package$.api.UiService
import $package$.model.Ticker
import android.content.{Intent, Context}
import android.view.View
import android.widget.{TextView, ProgressBar, LinearLayout}
import macroid.FullDsl._
import macroid._
import android.app.Activity
import android.os.Bundle

/**
  * Copyright (c) $copyright$. All rights reserved.
  * Created by $developer$
  */

class MainActivity extends Activity with Contexts[Activity] with MainActivityView with UiService {

  override def onCreate(b: Bundle): Unit = {
    super.onCreate(b)
    setTitle("Hello world, $name$!")
    setContentView(ui.get)
    update
  }

  def update = api(_.pubticker("btcusd")) mapUi updateView

  def updateView(t: Ticker) = runUi(
    lastPriceSlot <~ text("Whoa! Bitcoin price is " + t.last_price)
  )
}

trait MainActivityView {
  var lastPriceSlot = slot[TextView]

  def ui(implicit context: ActivityContext): Ui[LinearLayout] = {
    l[LinearLayout](
      w[TextView] <~ wire(lastPriceSlot)
    )
  }

}
