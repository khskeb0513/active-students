package com.busanhs.active_students.api

import retrofit2.Call
import retrofit2.http.*

interface RetrofitService {

    @GET("neis/about")
    fun requestAboutService(): Call<SchoolInfo>

    @GET("neis/meal")
    fun requestMealService(): Call<MealInfo>

    @GET("internal/schooltime")
    fun requestSchoolTimeService(): Call<SchoolTimeInfo>

    @POST("internal/personalData")
    fun requestPersonalDataService(
        @Body RequestData: PersonalDataRequest
    ): Call<PersonalData>

    data class PersonalDataRequest(
        val Name: String,
        val StudentNo: String,
        val Grade: Int,
        val Ban: Int,
        val Num: Int
    )

    data class PersonalData(
        val Merit: String
    )

    data class SchoolTimeInfo(
        val DayGubun: String,
        val FirstINTime: String,
        val SecondINTime: String,
        val OutTime: String,
        val DBTime: String,
        val Bigo: String
    )

    data class MealInfo(
        val today1: EachMealInfo,
        val today2: EachMealInfo,
        val today3: EachMealInfo,
        val tomorrow1: EachMealInfo,
        val tomorrow2: EachMealInfo,
        val tomorrow3: EachMealInfo
    )

    data class EachMealInfo(
        val ATPT_OFCDC_SC_CODE: String,
        val ATPT_OFCDC_SC_NM: String,
        val SD_SCHUL_CODE: String,
        val SCHUL_NM: String,
        val MMEAL_SC_CODE: String,
        val MMEAL_SC_NM: String,
        val MLSV_YMD: String,
        val MLSV_FGR: String,
        val DDISH_NM: String,
        val ORPLC_INFO: String,
        val CAL_INFO: String,
        val NTR_INFO: String,
        val MLSV_FROM_YMD: String,
        val MLSV_TO_YMD: String
    )

    data class SchoolInfo(
        val ATPT_OFCDC_SC_CODE: String,
        val ATPT_OFCDC_SC_NM: String,
        val SD_SCHUL_CODE: String,
        val SCHUL_NM: String,
        val ENG_SCHUL_NM: String,
        val SCHUL_KND_SC_NM: String,
        val LCTN_SC_NM: String,
        val JU_ORG_NM: String,
        val FOND_SC_NM: String,
        val ORG_RDNZC: String,
        val ORG_RDNMA: String,
        val ORG_RDNDA: String,
        val ORG_TELNO: String,
        val HMPG_ADRES: String,
        val COEDU_SC_NM: String,
        val ORG_FAXNO: String,
        val HS_SC_NM: String,
        val INDST_SPECL_CCCCL_EXST_YN: String,
        val HS_GNRL_BUSNS_SC_NM: String,
        val SPCLY_PURPS_HS_ORD_NM: String,
        val ENE_BFE_SEHF_SC_NM: String,
        val DGHT_SC_NM: String,
        val FOND_YMD: String,
        val FOAS_MEMRD: String,
        val LOAD_DTM: String
    )
}