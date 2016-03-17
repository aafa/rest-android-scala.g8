package $package$.api

import $package$.model.Ticker
import retrofit.http._


trait APIServiceDescriptor{
  @GET("/pubticker/{symbol}") def pubticker(@Path("symbol") symbol : String) : Ticker
}