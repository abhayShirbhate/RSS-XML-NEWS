package com.abhay.rssnews.model

import org.simpleframework.xml.Attribute
import org.simpleframework.xml.Root

@Root(name = "enclosure", strict = false)
class Enclosure {

    @field:Attribute(name = "url", required = false)
    var url: String? = null
}