package com.aabulhaj.hujiapp

import Session
import com.aabulhaj.hujiapp.data.timeTableUrl
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.http.*

interface HujiApi {
    @GET("/dataj/resources/captcha/stu/")
    fun getCaptcha(): Call<ResponseBody>

    @FormUrlEncoded
    @POST("/dataj/controller/auth/stu/?")
    fun login(@Field("itz_id") id: String,
              @Field("itz_code") code: String,
              @Field("captcha_session_key") captchaText: String,
              @Field("enter") enter: String = "+%EB%F0%E9%F1%E4+"
    ): Call<ResponseBody>

    @GET("/dataj/controller/auth/stu/?")
    fun loadLoginPage(): Call<ResponseBody>

    @GET
    fun getFirstSemesterTimeTable(
            @Url url: String = Session.getSessionUrl(timeTableUrl(1))
    ): Call<ResponseBody>

    @GET
    fun getCoursesList(@Url url: String): Call<ResponseBody>

    @GET
    fun getStatistics(@Url url: String): Call<ResponseBody>
}