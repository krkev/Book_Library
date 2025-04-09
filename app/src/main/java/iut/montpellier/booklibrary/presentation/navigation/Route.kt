package iut.montpellier.booklibrary.presentation.navigation

import kotlinx.serialization.Serializable

sealed class Route {

    @Serializable
    object HomeScreen

    @Serializable
    object WelcomeScreen

    @Serializable
    object LoginScreen

    @Serializable
    object CreateAccountScreen

    @Serializable
     data class BooksByCategory(val category: String)

    @Serializable
     data class ShowPdfScreen(val url: String)

}