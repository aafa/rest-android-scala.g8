package $package$.model

import com.fasterxml.jackson.annotation.JsonProperty

// JsonProperty is mandatory for scala case classes
case class Ticker(
                   @JsonProperty("last_price") var last_price : String
                 ) {

}