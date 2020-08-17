package com.example.adelalsay.mypostsv2.data;


import com.example.adelalsay.mypostsv2.pojo.PostModel;

import java.util.List;

import io.reactivex.Single;
import retrofit2.http.GET;

public interface PostInterface {
    @GET("posts")
    public Single<List<PostModel>> getPosts();
}
