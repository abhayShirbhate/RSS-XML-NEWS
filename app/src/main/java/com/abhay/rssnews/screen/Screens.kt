package com.abhay.rssnews.screen

enum class Screens(var url: String) {
    RssNewsScreens("rss_news_screen"),
    WebScreens("web_screen?url={url}")
}