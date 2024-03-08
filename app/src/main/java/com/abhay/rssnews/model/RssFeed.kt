package com.abhay.rssnews.model

import org.simpleframework.xml.Element
import org.simpleframework.xml.Root

@Root(name = "rss", strict = false)
class RSSFeed {

    @field:Element(name = "channel")
    var channel: Channel? = null
}

