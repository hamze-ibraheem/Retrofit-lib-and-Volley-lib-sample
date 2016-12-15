package com.example.hamzesarsourlocal.rotrofitlib;

import retrofit.Callback;
import retrofit.client.Response;
import retrofit.http.Field;
import retrofit.http.FormUrlEncoded;
import retrofit.http.POST;

/**
 * Created by hamze sarsour local on 9/1/2016.
 */
public interface RegisterAPI {
    @FormUrlEncoded
    @POST("/rotrofitlib/insert.php")
    public void insertUser(
            @Field("id") String name,
            @Field("name") String username,
            @Field("publisher") String password,
            @Field("image") String email,
            Callback<Response> callback);




}


