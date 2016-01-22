package $package$.service

import android.content.Context
import $package$.BuildConfig
import $package$.helpers.JacksonConverter
import com.fasterxml.jackson.databind.{DeserializationFeature, ObjectMapper}
import com.fasterxml.jackson.module.scala.DefaultScalaModule
import com.fasterxml.jackson.module.scala.experimental.ScalaObjectMapper
import retrofit.RestAdapter

/**
  * Copyright (c) $copyright$. All rights reserved.
  * Created by $developer$
  */
object APIServiceContext {
  var serviceContext: Option[APIServiceContext] = None

  def apply(ctx: Context) = {
    this.synchronized {
      if (serviceContext.isEmpty) {
        serviceContext = Some(new APIServiceContext(ctx))
      }

      serviceContext.get
    }
  }

}


class APIServiceContext(ctx: Context)  {

  private var restAdapter: RestAdapter = null
  lazy val serviceDescriptor: APIServiceDescriptor = createAPIServiceDescriptor

  {
    val jackson = new ObjectMapper() with ScalaObjectMapper
    jackson.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES)
    jackson.registerModule(DefaultScalaModule)

    val converter = new JacksonConverter(jackson)

    val builder = new RestAdapter.Builder()
      .setEndpoint("")
      .setConverter(converter)

    restAdapter = builder.build

    if (BuildConfig.DEBUG) {
      restAdapter.setLogLevel(RestAdapter.LogLevel.FULL)
    } else {
      restAdapter.setLogLevel(RestAdapter.LogLevel.NONE)
    }
  }


  def createAPIServiceDescriptor: APIServiceDescriptor = {
    restAdapter.create(classOf[APIServiceDescriptor])
  }

}


