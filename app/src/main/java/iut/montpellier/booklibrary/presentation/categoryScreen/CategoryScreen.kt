package iut.montpellier.booklibrary.presentation.categoryScreen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
//import androidx.lifecycle.ViewModel
import androidx.navigation.NavHostController
import iut.montpellier.booklibrary.presentation.effects.categoryShimmer
import iut.montpellier.booklibrary.presentation.uiComponent.BookCategoryCard
import iut.montpellier.booklibrary.presentation.viewModels.viewModel

@Composable
fun CategoryScreen(
    viewModel: viewModel = hiltViewModel(),
    navHostController: NavHostController){

    LaunchedEffect(Unit) {
        viewModel.BringCategories()
    }

    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        val res = viewModel.state.value

        when{

            res.isLoading -> {
                Column(modifier = Modifier.fillMaxSize()) {

                    LazyVerticalGrid(
                        GridCells.Fixed(2),
                        modifier = Modifier.fillMaxSize()
                    ) {

                        items(10){
                            categoryShimmer()
                        }
                    }
                }
            }

            res.error.isNotEmpty() ->{
                Text(text = res.error)
            }

            res.category.isNotEmpty() ->{

                LazyVerticalGrid(
                    GridCells.Fixed(2),
                    modifier = Modifier.fillMaxSize()
                ) {

                    items(res.category){

                        BookCategoryCard(
                            imageUrl = it.categoryImageUrl,
                            category = it.name,
                            navHostController = navHostController
                        )
                    }
                }
            }
        }
    }














}