package iut.montpellier.booklibrary.presentation.allBooksScreen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import iut.montpellier.booklibrary.presentation.effects.AnimateShimmer
import iut.montpellier.booklibrary.presentation.uiComponent.BookCart
import iut.montpellier.booklibrary.presentation.viewModels.ViewModel

@Composable
fun AllBooksScreen(
    modifier: Modifier= Modifier,
    viewModel: ViewModel = hiltViewModel(),
    navHostController: NavHostController
){


    LaunchedEffect(Unit) {

        viewModel.bringAllBooks()
    }

    val res = viewModel.state.value
    when {

        res.isLoading ->{

            Column(
                modifier = Modifier.fillMaxSize()
            ) {
                LazyColumn {
                    items(10) {
                        AnimateShimmer()
                    }
                }
            }
        }


        res.error.isNotEmpty() ->{

            Text(text = res.error, modifier = modifier)
        }

        res.items.isNotEmpty() -> {
            Column(
                modifier = Modifier.fillMaxSize()
            ) {
                LazyColumn(modifier = Modifier.fillMaxSize()) {

                    items(res.items){

                        BookCart(
                            imageUrl = it.image,
                            title = it.bookName,
                            description = it.bookDescription,
                            bookurl = it.bookUrl,
                            author = it.bookAuthor,
                            navHostController = navHostController
                        )
                    }
                }
            }
        } else -> {
            Text(text = "No Books Available", modifier = modifier)
        }


    }













}