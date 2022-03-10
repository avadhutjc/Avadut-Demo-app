package com.ajc.avadhut_demo_app.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ajc.avadhut_demo_app.model.remote.ResponseDTOItem
import com.ajc.avadhut_demo_app.repository.DataRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainViewModel(private val dataRepository: DataRepository) : ViewModel() {

    fun createTransaction() {
        viewModelScope.launch(Dispatchers.IO) {
            dataRepository.getData()
        }
    }

    val user: LiveData<ResponseDTOItem> get() = dataRepository.user

}