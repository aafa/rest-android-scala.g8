package $package$.api

import $package$.helpers.UiThreading
import $package$.api.{APIServiceDescriptor, APIServiceContext}
import android.content.Context

import scala.concurrent.Future
import scala.concurrent.ExecutionContext.Implicits.global

/**
  * Copyright (c) $copyright$. All rights reserved.
  * Created by $developer$
  */
trait UiService extends UiThreading {
  this: Context =>

  lazy val api = new ServiceWrapper(this)
}

class ServiceWrapper(ctx: Context) {
  val api = APIServiceContext(ctx).serviceDescriptor

  def apply[A](f: APIServiceDescriptor => A): Future[A] = Future {
    f(api)
  }
}