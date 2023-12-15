package com.qrrollcall.qrrollcall.service;
import com.qrrollcall.qrrollcall.model.Akademisyen;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Path;

import java.util.List;

public interface ApiService {

    @Headers("Content-Type:application/json;charset=UTF-8")
    @GET("api/Akademisyen")
    Call<List<Akademisyen>> getAkademisyenler();
    @Headers("Content-Type:application/json;charset=UTF-8")
    @GET("api/Akademisyen/akademisyenGiris/{id}/{sifre}")
    Call<Akademisyen> getAkademisyenGiris(@Path("id") int id, @Path("sifre") String sifre);



}
