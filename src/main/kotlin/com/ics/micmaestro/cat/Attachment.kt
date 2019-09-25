package com.ics.micmaestro.cat

import com.fasterxml.jackson.annotation.JsonProperty

data class Attachment(val id:Long,
                      val company:Company,
                      val department:Department?,
                      @JsonProperty("rejected")
                      var rejected:Any)