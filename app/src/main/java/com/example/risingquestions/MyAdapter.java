package com.example.risingquestions;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.HashMap;
import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {

    private List<Profile> profiles;
    private HashMap<String, List<Question>> questions;
    private Context context;

    public MyAdapter(Context context, List<Profile> profiles, HashMap<String, List<Question>> questions) {
        this.context = context;
        this.profiles = profiles;
        this.questions = questions;
    }

    @NonNull
    @Override
    public MyAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.row, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyAdapter.MyViewHolder holder, int position) {
        String profileName = this.profiles.get(position).getName();
        String username = this.profiles.get(position).getUsername();
        // I need to figure out a way to get the correct question and not the 0 index
        String question = this.questions.get(username).get(0).getQuestion();
        holder.question.setText(question);
        holder.username.setText(username);
    }

    @Override
    public int getItemCount() {
        return profiles.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {

        private TextView question;
        private TextView username;
        private Button upVote;
        private Button downVote;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            this.question = itemView.findViewById(R.id.questionText);
            this.username = itemView.findViewById(R.id.usernameText);
            this.upVote = itemView.findViewById(R.id.upVoteButton);
            this.downVote = itemView.findViewById(R.id.downVoteButton);
        }
    }
}
