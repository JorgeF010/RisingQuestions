package com.example.risingquestions.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.risingquestions.MyAdapter;
import com.example.risingquestions.Profile;
import com.example.risingquestions.Question;
import com.example.risingquestions.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class HomeFragment extends Fragment {

    private HomeViewModel homeViewModel;
    private RecyclerView recyclerView;
    private RecyclerView.LayoutManager layoutManager;
    private MyAdapter myAdapter;
    private List<Profile> profiles;
    private HashMap<String, List<Question>> questions;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        homeViewModel =
                ViewModelProviders.of(this).get(HomeViewModel.class);
        View root = inflater.inflate(R.layout.fragment_home, container, false);
        this.profiles = new ArrayList<>();
        this.questions = new HashMap<>();
        Profile Eli = new Profile("Eli", "Eli123");
        List<Question> JorgeQuestion = new ArrayList<>();
        Question question = new Question("How high is Eli?", 1, 2);
        JorgeQuestion.add(question);
        Profile Eli2 = new Profile("Eli2", "Eli1236");
        List<Question> JorgeQuestion2 = new ArrayList<>();
        Question question2 = new Question("How high is Eli?", 1, 2);
        JorgeQuestion2.add(question2);
        this.profiles.add(Eli);
        this.questions.put(Eli.getUsername(), JorgeQuestion);
        this.profiles.add(Eli2);
        this.questions.put(Eli2.getUsername(), JorgeQuestion2);
        this.recyclerView = root.findViewById(R.id.recyclerView);
        this.myAdapter = new MyAdapter(root.getContext(), profiles, questions);
        this.recyclerView.setAdapter(myAdapter);
        this.layoutManager = new LinearLayoutManager(root.getContext());
        this.recyclerView.setLayoutManager(layoutManager);
//        final TextView textView = root.findViewById(R.id.text_home);
//        homeViewModel.getText().observe(this, new Observer<String>() {
//            @Override
//            public void onChanged(@Nullable String s) {
//                textView.setText(s);
//            }
//        });
        return root;
    }
}