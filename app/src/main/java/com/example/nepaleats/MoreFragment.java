package com.example.nepaleats;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


public class MoreFragment extends Fragment {

    private TextView terms;
    private TextView asked;
    private TextView feedBack;





    public MoreFragment() {
        // Required empty public constructor
    }




    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v= inflater.inflate(R.layout.fragment_more, container, false);
        terms = v.findViewById(R.id.terms);
        terms.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), TermConditionActivity.class);
                startActivity(intent);
            }
        });

//        asked = v.findViewById(R.id.faq);
//        asked.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(getContext(),FrequentlyAsked.class);
//                startActivity(intent);
//            }
//        });

//        feedBack = v.findViewById(R.id.feedback);
//        feedBack.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(getContext(),FeedBack.class);
//                startActivity(intent);
//            }
//        });




        return v;
    }
}