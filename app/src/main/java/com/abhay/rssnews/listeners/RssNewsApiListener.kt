package com.abhay.rssnews.listeners

import com.abhay.rssnews.model.RSSFeed
import com.zobaze.zobazerefractortask.employee.Response.ApiResult

interface RssNewsApiListener {
    fun onRssDataSuccess(result: ApiResult.Success<RSSFeed>)
    fun onRssDataError(result: ApiResult<RSSFeed>)
}