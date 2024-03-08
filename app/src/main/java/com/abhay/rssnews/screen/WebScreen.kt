package com.abhay.rssnews.screen

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun WebScreen(url: String) {
    Surface(modifier = Modifier.fillMaxSize()) {
        WebView(url = url)
    }
}

@Preview
@Composable
fun PreviewWebScreen() {
    WebScreen(url = "https://www.example.com")
}
