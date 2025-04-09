package iut.montpellier.booklibrary.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.toRoute
import iut.montpellier.booklibrary.presentation.allBooksCategoryScreen.BooksByCategoryScreen
import iut.montpellier.booklibrary.presentation.homeScreen.HomeScreen
import iut.montpellier.booklibrary.presentation.uiComponent.PdfViewScreen


@Composable
fun NavGraph(navHostController: NavHostController){

    NavHost(navController = navHostController, startDestination = Route.HomeScreen) {

        composable<Route.HomeScreen>{
            HomeScreen(navHostController)
        }

        composable<Route.ShowPdfScreen>{ backStackEntry ->

            val data: Route.ShowPdfScreen = backStackEntry.toRoute()
            PdfViewScreen(url = data.url)
        }

        composable<Route.BooksByCategory>{backStackEntry ->

            val data2: Route.BooksByCategory = backStackEntry.toRoute()
            BooksByCategoryScreen(category = data2.category, navHostController = navHostController)

        }


    }
}