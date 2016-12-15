package com.example.hamzesarsourlocal.rotrofitlib;

import java.util.List;

import retrofit.Callback;
import retrofit.http.GET;

/**
 * Created by hamze sarsour local on 9/1/2016.
 */
public interface SelectAPI {

    /*Retrofit get annotation with our URL
       And our method that will return us the list ob Book
    */
    @GET("/rotrofitlib/get.php?page=1")
    public void getItems(Callback<List<Item>> response);



}
