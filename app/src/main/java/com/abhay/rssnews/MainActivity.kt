package com.abhay.rssnews

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.abhay.rssnews.screen.RssNewsScreen
import com.abhay.rssnews.ui.theme.RSSNewsTheme
import com.abhay.rssnews.screen.Screens
import com.abhay.rssnews.screen.WebScreen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            RSSNewsTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    NavScreen(Screens.RssNewsScreens)
                }
            }
        }
    }
}

@Composable
fun NavScreen(startDestination: Screens) {
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = startDestination.url
    ) {
        composable(Screens.RssNewsScreens.url) {
            RssNewsScreen( navController)
        }
        composable(Screens.WebScreens.url) { backStackEntry ->
            val url = backStackEntry.arguments?.getString("url") ?: ""
            WebScreen(url = url)
        }
    }

}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    RSSNewsTheme {
        Greeting("Android")
    }
}