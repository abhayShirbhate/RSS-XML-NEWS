package com.abhay.rssnews.viewmodel

import RetrofitClient
import RssRepository
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.abhay.rssnews.listeners.RssNewsApiListener
import com.abhay.rssnews.model.RssNewsItem
import com.abhay.rssnews.model.RSSFeed
import com.abhay.rssnews.repository.RssRepositoryImpl
import com.zobaze.zobazerefractortask.employee.Response.ApiResult

class RssViewModel(private val repository: RssRepository) : ViewModel(), RssNewsApiListener {
    private val _rssNewsList: MutableState<List<RssNewsItem>> = mutableStateOf(emptyList())
    val rssNewsList: MutableState<List<RssNewsItem>> get() = _rssNewsList

    private val _errorMsg : MutableState<String?> = mutableStateOf(null)
    val errorMsg : MutableState<String?> get() = _errorMsg

    fun fetchPuneNews() {
        // Call method in Repository to fetch RSS news
        repository.getPuneNews(this)
    }

    override fun onRssDataSuccess(result: ApiResult.Success<RSSFeed>) {
        result.data.channel?.rssNewsItems?.let {
            _rssNewsList.value = it
        }
    }

    override fun onRssDataError(result: ApiResult<RSSFeed>) {
        if (result is ApiResult.NoInternetConnection){
            errorMsg.value = result.msg
        }else if (result is ApiResult.Error){
            errorMsg.value = result.msg
        }
    }

    companion object {
        val Factory: ViewModelProvider.Factory = viewModelFactory {
            initializer {
                RssViewModel(repository = RssRepositoryImpl(RetrofitClient.rssService))
            }
        }
    }
}
