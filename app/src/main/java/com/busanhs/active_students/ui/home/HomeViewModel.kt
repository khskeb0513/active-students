package com.busanhs.active_students.ui.home

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.busanhs.active_students.api.RetrofitClient
import com.busanhs.active_students.api.RetrofitService
import kotlinx.coroutines.launch
import retrofit2.awaitResponse
import java.lang.Exception

class HomeViewModel : ViewModel() {

    private companion object {
        const val TAG = "HomeViewModel"
    }

    init {
        viewModelScope.launch {
            val service = RetrofitClient.service
            try {
                val response = service.requestAboutService().awaitResponse()
                if (response.isSuccessful) {
                    schoolInfo.value = response.body()
                }
            } catch (e: Exception) {
                Log.e(TAG, e.message!!)
            }
        }
    }

    val schoolInfo = MutableLiveData<RetrofitService.SchoolInfo>()
}