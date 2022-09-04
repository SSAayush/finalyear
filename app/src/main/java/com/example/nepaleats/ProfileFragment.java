package com.example.nepaleats;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.nepaleats.app.NepalEats;


public class ProfileFragment extends Fragment {

    private TextView history;
    private TextView address;
    private TextView password;
    private TextView  userName;
    private TextView userEmail;
    private TextView tvLogOut;



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

      View v = inflater.inflate(R.layout.fragment_profile, container, false);
        userName=v.findViewById(R.id.userName);
        userEmail=v.findViewById(R.id.userEmail);
//        history = v.findViewById(R.id.history);
//        history.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(getContext(), OrderHistoryActivity.class);
//                startActivity(intent);
//
//            }
//        });

//        address=v.findViewById(R.id.address);
//        address.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(getContext(), ManageAddressActivity.class);
//                startActivity(intent);
//
//            }
//        });
        password=v.findViewById(R.id.password);
        password.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), ChangePasswordActivity.class);
                startActivity(intent);


            }
        });
        tvLogOut=v.findViewById(R.id.tvLogOut);
        tvLogOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            NepalEats.prefs.clearPrefs();
            Intent intent = new Intent(getActivity(),LoginActivity.class);
            startActivity(intent);
            getActivity().finish();
            }
        });

        setWelcomeMessage();
      return v;

    }

    private void setWelcomeMessage() {
        userName.setText(NepalEats.prefs.getPrefs().getName());
        userEmail.setText(NepalEats.prefs.getPrefs().getEmail());

    }
}