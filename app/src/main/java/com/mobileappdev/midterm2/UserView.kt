package com.mobileappdev.midterm2

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mobileappdev.midterm2.models.User
import com.mobileappdev.midterm2.services.UserService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class UserView(private val userService: UserService) : ViewModel() {

    private val _users = MutableStateFlow<List<User>>(emptyList())
    val users: StateFlow<List<User>> get() = _users.asStateFlow()

    fun fetchUsers() {
        viewModelScope.launch {
            try {
                val result = withContext(Dispatchers.IO) {
                    userService.getUsers()
                }
                _users.value = result
            } catch (e: Exception) {
                // Handle error
                e.printStackTrace()
            }
        }
    }
}
