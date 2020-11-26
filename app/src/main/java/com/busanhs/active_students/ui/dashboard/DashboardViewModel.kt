package com.busanhs.active_students.ui.dashboard

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.busanhs.active_students.api.RetrofitClient
import com.busanhs.active_students.api.RetrofitService
import kotlinx.coroutines.launch
import retrofit2.awaitResponse
import java.lang.Exception

class DashboardViewModel : ViewModel() {

    private companion object {
        const val TAG = "DashboardViewModel"
    }

    init {
        viewModelScope.launch {
            val service = RetrofitClient.service
            try {
                val response = service.requestSchoolTimeService().awaitResponse()
                if (response.isSuccessful) {
                    schoolTimeInfo.value = response.body()
                }
            } catch (e: Exception) {
                Log.e(TAG, e.message!!)
            }
            try {
                val response = service.requestMealService().awaitResponse()
                if (response.isSuccessful) {
                    mealInfo.value = response.body()
                }
            } catch (e: Exception) {
                Log.e(TAG, e.message!!)
            }
        }
    }

    val mealInfo = MutableLiveData<RetrofitService.MealInfo>()
    val schoolTimeInfo = MutableLiveData<RetrofitService.SchoolTimeInfo>()
}