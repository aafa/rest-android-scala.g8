package $package$.service

import retrofit.http._

/**
  * Copyright (c) $copyright$. All rights reserved.
  * Created by $developer$
  */
trait APIServiceDescriptor{
  @GET("/api/call") def apiCall : Model
}