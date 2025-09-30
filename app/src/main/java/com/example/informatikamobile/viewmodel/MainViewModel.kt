package com.example.informatikamobile.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.informatikamobile.data.model.BookDoc
import com.example.informatikamobile.data.network.RetrofitInstance
import kotlinx.coroutines.launch

class MainViewModel : ViewModel() {

    private val _books = MutableLiveData<List<BookDoc>>()
    val books: LiveData<List<BookDoc>> get() = _books

    fun searchBooks(query: String) {
        viewModelScope.launch {
            try {
                val response = RetrofitInstance.api.searchBooks(query)
                if (response.isSuccessful) {
                    _books.value = response.body()?.docs ?: emptyList()
                } else {
                    _books.value = emptyList()
                }
            } catch (e: Exception) {
                _books.value = emptyList()
            }
        }
    }
}
