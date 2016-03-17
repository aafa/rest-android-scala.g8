package $package$.helpers

import android.os.{Looper, Handler}
import macroid.UiThreadExecutionContext
import scala.concurrent.{Future, ExecutionContext}


trait UiThreading {
  implicit val ec: ExecutionContext = ExecutionContext.global

  implicit class UiFuture[T](future: Future[T]) {
    def mapUi[S](f: Function[T, S]) = future.map(f)(UiThreadExecutionContext)
  }

  lazy val handler = new Handler(Looper.getMainLooper)

  lazy val uiThread = Looper.getMainLooper.getThread

  def assertBackground() {
    assert(uiThread != Thread.currentThread)
  }

  def assertUIThread() {
    assert(uiThread == Thread.currentThread)
  }

  def runOnUiThread(f: => Unit): Unit = {
    if (uiThread == Thread.currentThread) {
      f
    } else {
      handler.post(new Runnable() {
        def run() {
          f
        }
      })
    }
  }
}
