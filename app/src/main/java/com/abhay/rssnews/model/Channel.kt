package com.abhay.rssnews.model

import org.simpleframework.xml.Element
import org.simpleframework.xml.ElementList
import org.simpleframework.xml.Root

@Root(name = "channel", strict = false)
class Channel {

    @field:Element(name = "title")
    var title: String? = null

    @field:ElementList(inline = true, required = false)
    var rssNewsItems: List<RssNewsItem>? = null
}