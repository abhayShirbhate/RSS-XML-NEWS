package com.abhay.rssnews.repository

import RssRepository
import com.abhay.rssnews.listeners.RssNewsApiListener
import com.abhay.rssnews.model.RSSFeed
import com.abhay.rssnews.retrofit_client.RSSService
import com.zobaze.zobazerefractortask.employee.Response.ApiResult
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.net.SocketTimeoutException
import java.net.UnknownHostException

class RssRepositoryImpl(private val rssService: RSSService) : RssRepository {

    override fun getPuneNews(listener: RssNewsApiListener) {
        rssService.getPuneRssNews().enqueue(object : Callback<RSSFeed> {
            override fun onResponse(
                call: Call<RSSFeed>,
                response: Response<RSSFeed>
            ) {
                if (response.isSuccessful && response.body() != null) {
                    // Process the RSS feed data here
                    listener.onRssDataSuccess(ApiResult.Success(response.body()!!))
                } else {
                    // Handle error
                    listener.onRssDataError(ApiResult.Error("Something went wrong, please try again!! \n responseCode ${response.code()}"))
                }
            }

            override fun onFailure(call: Call<RSSFeed>, t: Throwable) {
                // Handle failure
                if (t is SocketTimeoutException || t is UnknownHostException) {
                    listener.onRssDataError(ApiResult.NoInternetConnection("Please check internet connection and try again!!"))
                } else {
                    listener.onRssDataError(ApiResult.Error("Something went wrong, please try again!!"))
                }
            }
        })
    }
}