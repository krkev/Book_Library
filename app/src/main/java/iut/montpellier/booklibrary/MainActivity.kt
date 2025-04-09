package iut.montpellier.booklibrary

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.rememberNavController
import dagger.hilt.android.AndroidEntryPoint
import iut.montpellier.booklibrary.presentation.navigation.NavGraph
import iut.montpellier.booklibrary.ui.theme.BookLibraryTheme
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.foundation.layout.PaddingValues

val LocalInnerPadding = staticCompositionLocalOf { PaddingValues() }

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            BookLibraryTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerpadding ->
                    val navHostController = rememberNavController()
                    CompositionLocalProvider(LocalInnerPadding provides innerpadding) {
                        NavGraph(navHostController = navHostController)
                    }
                }
            }
        }
    }
}




@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    BookLibraryTheme {
        val navHostController = rememberNavController()
        NavGraph(navHostController = navHostController)
    }
}