package com.abhay.rssnews.screen

import android.annotation.SuppressLint
import android.webkit.WebViewClient
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.viewinterop.AndroidView


@SuppressLint("SetJavaScriptEnabled")
@Composable
fun WebView(url: String) {
    AndroidView(
        modifier = Modifier.fillMaxSize(),
        factory = { context ->
            android.webkit.WebView(context).apply {
                loadUrl(url)
                settings.javaScriptEnabled = true
                webViewClient = WebViewClient()

            }
        }
    )
}
