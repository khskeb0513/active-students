package com.busanhs.active_students.ui.notifications

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.busanhs.active_students.api.RetrofitClient
import com.busanhs.active_students.api.RetrofitService
import kotlinx.coroutines.launch
import retrofit2.awaitResponse
import java.lang.Exception

class NotificationsViewModel : ViewModel() {

    val personalData = MutableLiveData<RetrofitService.PersonalData>()
    val requestData = MutableLiveData<RequestDataFormat>()
    fun setRequestData(requestDataFormat: RequestDataFormat) {
        requestData.value = requestDataFormat
    }

    data class RequestDataFormat(
        val grade: Int,
        val ban: Int,
        val num: Int,
        val name: String
    )

    fun setPersonalData(Name: String, StudentNo: String, Grade: Int, Ban: Int, Num: Int) {
        viewModelScope.launch {
            val service = RetrofitClient.service
            try {
                val response = service.requestPersonalDataService(
                    RetrofitService.PersonalDataRequest(
                        Name, StudentNo, Grade, Ban, Num
                    )
                ).awaitResponse()
                if (response.isSuccessful) {
                    personalData.value = response.body()
                }
            } catch (e: Exception) {
                Log.e(TAG, e.message!!)
            }
        }
    }

    private companion object {
        const val TAG = "NotificationsViewModel"
    }
}