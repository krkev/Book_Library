package iut.montpellier.booklibrary.domain.repo

import iut.montpellier.booklibrary.common.BookCategoryModel
import iut.montpellier.booklibrary.common.BookModel
import iut.montpellier.booklibrary.common.ResultState
import kotlinx.coroutines.flow.Flow

interface AllBookRepo {

    fun getAllBooks(): Flow<ResultState<List<BookModel>>>
    fun getAllCategory(): Flow<ResultState<List<BookCategoryModel>>>
    fun getAllBooksByCategory(category: String): Flow<ResultState<List<BookModel>>>
}