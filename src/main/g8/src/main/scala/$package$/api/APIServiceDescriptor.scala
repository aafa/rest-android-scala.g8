package $package$.api

import $package$.model.Ticker
import retrofit.http._

/**
  * Copyright (c) $copyright$. All rights reserved.
  * Created by $developer$
  */
trait APIServiceDescriptor{
  @GET("/pubticker/{symbol}") def pubticker(@Path("symbol") symbol : String) : Ticker
}