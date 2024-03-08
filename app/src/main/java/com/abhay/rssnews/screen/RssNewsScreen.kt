package com.abhay.rssnews.screen

import RetrofitClient
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import com.abhay.rssnews.repository.RssRepositoryImpl
import com.abhay.rssnews.viewmodel.RssViewModel

@Composable
fun RssNewsScreen(
    nav: NavHostController,
    viewModel: RssViewModel = viewModel(factory = RssViewModel.Factory)
) {

    // Observe the list of RSS news items fr
    // om the view model
    val rssNewsList by remember{ viewModel.rssNewsList }

    // Observe the error message from the view model
    val errorMsg by remember{ viewModel.errorMsg }

    // Display the list of RSS news items in a LazyColumn
    LazyColumn {
        items(rssNewsList.size) { i ->
            // Render each RSS news item using a composable function
            val rssNewsItem = rssNewsList[i]
            NewsItem(rssNewsItem){
                nav.navigate("web_screen?url={${rssNewsItem.link}}")
            }
        }
    }

    // Show error message if there's an error
    if(errorMsg != null){
        AlertDialogWithSingleButton(
            "Error",
            errorMsg?:"",
            "Try Again"
        ){
            viewModel.fetchPuneNews()
            viewModel.errorMsg.value = null
        }
    }

    // Fetch Pune news when the screen is first displayed
    LaunchedEffect(Unit){
        viewModel.fetchPuneNews()
    }
}



@Preview
@Composable
fun PreviewRssNewsScreen() {
    // Create a preview RssViewModel
    val viewModel = RssViewModel(RssRepositoryImpl(RetrofitClient.rssService))

    // Preview the RssNewsScreen
//    RssNewsScreen(viewModel = viewModel)
}
