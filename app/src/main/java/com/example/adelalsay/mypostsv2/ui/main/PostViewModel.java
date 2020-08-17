package com.example.adelalsay.mypostsv2.ui.main;

import android.util.Log;

import com.example.adelalsay.mypostsv2.data.PostsClient;
import com.example.adelalsay.mypostsv2.pojo.PostModel;

import java.util.List;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import io.reactivex.Single;
import io.reactivex.SingleObserver;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;


public class PostViewModel extends ViewModel {
    private static final String TAG = "PostViewModel";
    MutableLiveData<List<PostModel>> postModelMutableLiveData = new MutableLiveData<>();
    MutableLiveData<String> posts = new MutableLiveData<>();

    public void getPosts() {
        Single observable = PostsClient.getINSTANCE().getPosts()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                ;

        SingleObserver<List<PostModel>> observer = new SingleObserver<List<PostModel>>() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onSuccess(List<PostModel> postModels) {
                postModelMutableLiveData.setValue(postModels);

            }

            @Override
            public void onError(Throwable e) {
                Log.d(TAG, "onError: "+ e);

            }
        };


        observable.subscribe(observer);


    }

}
