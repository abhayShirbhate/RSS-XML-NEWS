package com.abhay.rssnews.retrofit_client

import com.abhay.rssnews.model.RSSFeed
import retrofit2.Call
import retrofit2.http.GET

interface RSSService {

    @GET("rssfeeds/-2128821991.cms")
    fun getPuneRssNews(): Call<RSSFeed>
}
