package $package$

import $package$.api.APIServiceContext
import $package$.model.Ticker
import android.os.Build.VERSION_CODES._
import org.robolectric.RuntimeEnvironment
import org.robolectric.annotation.Config
import org.scalatest.{RobolectricSuite, Matchers, FlatSpec}

/**
  */
@Config(sdk = Array(LOLLIPOP))
class APITests extends FlatSpec with Matchers with RobolectricSuite {
  "API" should "respond" in {
    val api = APIServiceContext(RuntimeEnvironment.application).serviceDescriptor

    val pubticker: Ticker = api.pubticker("btcusd")
    println(pubticker)

    assert(pubticker.last_price.nonEmpty)
  }
}
