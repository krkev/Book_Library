package iut.montpellier.booklibrary.presentation.viewModels

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import kotlinx.coroutines.launch



class AuthViewModel : ViewModel() {
    private val auth: FirebaseAuth = Firebase.auth
    val isLoading = mutableStateOf(false)
    val errorMessage = mutableStateOf<String?>(null)
    val isUserLoggedIn = mutableStateOf(auth.currentUser != null)

    fun createAccount(email: String, password: String, onSuccess: () -> Unit) {
        viewModelScope.launch {
            isLoading.value = true
            errorMessage.value = null

            auth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener { task ->
                    isLoading.value = false
                    if (task.isSuccessful) {
                        isUserLoggedIn.value = true
                        onSuccess()
                    } else {
                        errorMessage.value = task.exception?.message
                    }
                }
        }
    }

    fun login(email: String, password: String, onSuccess: () -> Unit) {
        viewModelScope.launch {
            isLoading.value = true
            errorMessage.value = null

            auth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener { task ->
                    isLoading.value = false
                    if (task.isSuccessful) {
                        isUserLoggedIn.value = true
                        onSuccess()
                    } else {
                        errorMessage.value = task.exception?.message
                    }
                }
        }
    }
}