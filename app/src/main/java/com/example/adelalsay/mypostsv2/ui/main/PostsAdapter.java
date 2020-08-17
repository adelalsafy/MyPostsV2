package com.example.adelalsay.mypostsv2.ui.main;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.example.adelalsay.mypostsv2.R;
import com.example.adelalsay.mypostsv2.pojo.PostModel;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class PostsAdapter extends RecyclerView.Adapter<PostsAdapter.PostViewHolder> {
    private List<PostModel> postsList = new ArrayList<>();


    @NonNull
    @Override
    public PostViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new PostViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.custom_post_item, parent, false));

    }

    @Override
    public void onBindViewHolder(@NonNull PostViewHolder holder, int position) {
        PostModel model =postsList.get(position);
        holder.userTV.setText(model.getUserId()+"");
        holder.titleTV.setText(model.getTitle());
        holder.bodyTV.setText(model.getBody());

    }

    @Override
    public int getItemCount() {
        return postsList.size();
    }
    public void setList(List<PostModel> postList) {
        this.postsList = postList;
        notifyDataSetChanged();
    }

    public class PostViewHolder extends RecyclerView.ViewHolder {
        TextView titleTV, userTV, bodyTV;

        public PostViewHolder(@NonNull View itemView) {
            super(itemView);
            titleTV = itemView.findViewById(R.id.customItemTitleTV);
            userTV = itemView.findViewById(R.id.customItemUserIdTV);
            bodyTV = itemView.findViewById(R.id.customItemBodyTV);

        }
    }
}