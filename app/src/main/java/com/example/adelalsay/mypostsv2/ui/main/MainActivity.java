package com.example.adelalsay.mypostsv2.ui.main;

import android.os.Bundle;

import com.example.adelalsay.mypostsv2.R;
import com.example.adelalsay.mypostsv2.pojo.PostModel;

import java.util.List;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerView ;
    private PostViewModel postViewModel;
    private PostsAdapter postsAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        postViewModel = ViewModelProviders.of(this).get(PostViewModel.class);
        postViewModel.getPosts();
        recyclerView = findViewById(R.id.mainPostRV);

        setListOnPostsRecycler();



    }
    private void setListOnPostsRecycler(){
        postsAdapter = new PostsAdapter();
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(postsAdapter);


        postViewModel.postModelMutableLiveData.observe(this, new Observer<List<PostModel>>() {
            @Override
            public void onChanged(List<PostModel> postModels) {
                postsAdapter.setList(postModels);


            }
        });
    }
}
