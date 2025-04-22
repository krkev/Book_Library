package iut.montpellier.booklibrary.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.toRoute
import iut.montpellier.booklibrary.presentation.allBooksCategoryScreen.BooksByCategoryScreen
import iut.montpellier.booklibrary.presentation.forms.CreateAccountScreen
import iut.montpellier.booklibrary.presentation.forms.LoginScreen
import iut.montpellier.booklibrary.presentation.homeScreen.HomeScreen
import iut.montpellier.booklibrary.presentation.launcher.SplashScreen
import iut.montpellier.booklibrary.presentation.uiComponent.PdfViewScreen
import iut.montpellier.booklibrary.presentation.WelcomeScreen


@Composable
fun NavGraph(navHostController: NavHostController){

    NavHost(navController = navHostController, startDestination = Route.SplashScreen) {

        composable<Route.SplashScreen>{
            SplashScreen(navHostController)
        }
        
        composable<Route.WelcomeScreen>{
            WelcomeScreen(navHostController)
        }

        composable<Route.LoginScreen>{
            LoginScreen(navHostController)
        }

        composable<Route.CreateAccountScreen>{
            CreateAccountScreen(navHostController)
        }

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