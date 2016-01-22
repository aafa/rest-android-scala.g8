package $package$.activity


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

class MainActivity extends Activity with Contexts[Activity]{

  override def onCreate(b: Bundle): Unit = {
    super.onCreate(b)
    setTitle("Hello world, $name$!")

    setContentView(ui)
  }

  def ui: View = l[LinearLayout](
    w[TextView] <~ text("Welcome to $name$!")
  ).get

}
