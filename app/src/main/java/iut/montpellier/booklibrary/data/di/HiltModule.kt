package iut.montpellier.booklibrary.data.di

import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.storage.FirebaseStorage
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton
import dagger.Provides
import iut.montpellier.booklibrary.data.repoImplimentation.AllBookRepoImpl
import iut.montpellier.booklibrary.domain.repo.AllBookRepo


@Module
@InstallIn(SingletonComponent :: class)
object HiltModule{
    
    @Provides
    @Singleton
    fun provideRealTimeDatabase(): FirebaseDatabase {
        return FirebaseDatabase.getInstance()
    }

    @Provides
    @Singleton
    fun provideFirebaseStorage(): FirebaseStorage{
         return FirebaseStorage.getInstance()
    }

    @Provides
    @Singleton
    fun provideAllbookRepo( firebaseDatabase: FirebaseDatabase): AllBookRepo{
        return AllBookRepoImpl(firebaseDatabase)
    }
}