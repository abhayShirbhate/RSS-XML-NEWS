package com.abhay.rssnews.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.text.font.FontWeight
import coil.annotation.ExperimentalCoilApi
import coil.compose.rememberImagePainter
import com.abhay.rssnews.model.RssNewsItem

@OptIn(ExperimentalCoilApi::class)
@Composable
fun NewsItem(newsRssNewsItem: RssNewsItem,onClick:()->Unit) {
    Row(
        modifier = Modifier
            .padding(16.dp)
            .fillMaxWidth()
            .clickable{  onClick() },
        verticalAlignment = Alignment.CenterVertically
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth(0.65f)
                .fillMaxHeight()
        ) {
            Text(
                text = newsRssNewsItem.title?:"",
                style = MaterialTheme.typography.bodyLarge.copy(
                    fontWeight = FontWeight.Bold
                ),
                maxLines = 2,
                overflow = TextOverflow.Ellipsis,
                modifier = Modifier.padding(bottom = 8.dp)
            )
            Text(
                text = newsRssNewsItem.pubDate?:"",
                style = MaterialTheme.typography.bodySmall,
                modifier = Modifier.padding(bottom = 8.dp)
            )
        }
        Image(
            painter = rememberImagePainter(newsRssNewsItem.enclosure?.url?:""),
            contentDescription = null,
            modifier = Modifier
                .fillMaxWidth(0.40f)
                .fillMaxHeight()
                .clip(RoundedCornerShape(4.dp))
                .padding(start = 8.dp),
            contentScale = ContentScale.Crop
        )
    }
}
