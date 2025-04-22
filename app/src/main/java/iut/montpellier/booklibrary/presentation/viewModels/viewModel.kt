package iut.montpellier.booklibrary.presentation.viewModels

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import iut.montpellier.booklibrary.common.BookCategoryModel
import iut.montpellier.booklibrary.common.BookModel
import iut.montpellier.booklibrary.common.ResultState
import iut.montpellier.booklibrary.domain.repo.AllBookRepo
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class ViewModel @Inject constructor(private val repo: AllBookRepo): ViewModel() {

    private  val _state: MutableState<ItemState> = mutableStateOf(ItemState())
    val state: MutableState<ItemState> = _state

    fun bringAllBooks(){
        viewModelScope.launch {
            repo.getAllBooks().collect{

                when(it){

                    is ResultState.Loading ->{
                        _state.value = ItemState(isLoading = true)

                    }
                    is ResultState.Success ->{
                        _state.value = ItemState(items = it.data)
                    }
                    is ResultState.Error ->{
                        _state.value = ItemState(error = it.exception.localizedMessage ?: "An unexpected error occurred")
                    }
                }
            }


        }
    }


    fun bringCategories(){
        viewModelScope.launch {
            repo.getAllCategory().collect{

                when(it){
                    is ResultState.Loading ->{
                        _state.value = ItemState(isLoading = true)
                    }
                    is ResultState.Error ->{
                        _state.value = ItemState(error = it.exception.localizedMessage ?: "An unexpected error occurred")
                    }
                    is ResultState.Success ->{
                        _state.value = ItemState(category = it.data)
                    }
                }
            }
        }
    }


    fun bringAllBooksByCategory(category: String){
        viewModelScope.launch {
            repo.getAllBooksByCategory(category).collect{
                when(it){
                    is ResultState.Loading -> {
                        _state.value = ItemState(isLoading = true)
                    }
                    is ResultState.Error -> {
                        _state.value = ItemState(error = it.exception.localizedMessage ?: "An unexpected error occurred")
                    }
                    is ResultState.Success ->{
                        _state.value = ItemState(items = it.data)
                    }
                }
            }
        }
    }

}

data class ItemState(

    val isLoading: Boolean = false,
    val items: List<BookModel> = emptyList(),
    val error: String = "",
    val category: List<BookCategoryModel> = emptyList()

)