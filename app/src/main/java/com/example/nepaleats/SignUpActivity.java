package com.example.nepaleats;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.nepaleats.response.ResigsterResponse;
import com.example.nepaleats.api.ApiClient;
import com.example.nepaleats.api.ApiInterface;
import com.rengwuxian.materialedittext.MaterialEditText;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SignUpActivity extends AppCompatActivity {
    private TextView tvLogin;
    private MaterialEditText username, email, password;
    private Button btnsignup;
    private ApiInterface apiInterface;
    String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        
        initVars();

        tvLogin.setOnClickListener(new View.OnClickListener() {
            @Override

            public void onClick(View v) {
//                Intent intent = new Intent(LoginActivity.this, MainActivity.class);
//                startActivity(intent);
//                    String userName = username.getText().toString(); // TODO set your user name
//                    String emAil = email.getText().toString(); // TODO set your password
//                    //final String urlToCall = et_server.getText().toString(); // TODO set your url
//
//                    apiInterface = ApiClient.getClient().create(ApiInterface.class);
//                    retrofit2.Call<ResigsterResponse> call = apiInterface.register(
//                            userName,emAil
//                    );
//                call.enqueue(new Callback<ResigsterResponse>() {
//                    @Override
//                    public void onResponse(Call<ResigsterResponse> call, Response<ResigsterResponse> response) {
//                        Log.d("aayush", "Response=>" + response.toString());
//                    }
//
//                    @Override
//                    public void onFailure(Call<ResigsterResponse> call, Throwable t) {
//                        Log.d("aayush", "Response=>" + t.getMessage());
//                    }
//                });



            }
        });


        btnsignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(username.getText().toString().isEmpty() || email.getText().toString().isEmpty() || password.getText().toString().isEmpty()){
                    Toast.makeText(SignUpActivity.this, "Fill as the deatils",Toast.LENGTH_SHORT).show();
                }else {
                    if(email.getText().toString().matches(emailPattern)) {

                        if(password.getText().toString().length() >=6){
                            String userName = username.getText().toString(); // TODO set your user name
                            String emAil = email.getText().toString(); // TODO set your password
                            String Password = password.getText().toString();
                            //final String urlToCall = et_server.getText().toString(); // TODO set your url

                            apiInterface = ApiClient.getClient().create(ApiInterface.class);
                            retrofit2.Call<ResigsterResponse> call = apiInterface.register(
                                    userName,emAil,Password
                            );
                            call.enqueue(new Callback<ResigsterResponse>() {
                                @Override
                                public void onResponse(Call<ResigsterResponse> call, Response<ResigsterResponse> response) {
                                    Log.d("aayush", "Response=>" + response.toString());
                                    ResigsterResponse rs = response.body();
                                    if(rs.isSuccess()){
                                        Toast.makeText(SignUpActivity.this, rs.getMessage(), Toast.LENGTH_SHORT).show();
                                        Intent intent = new Intent(SignUpActivity.this, LoginActivity.class);
                                        startActivity(intent);
                                    }
                                }

                                @Override
                                public void onFailure(Call<ResigsterResponse> call, Throwable t) {
                                    Log.d("aayush", "Response=>" + t.getMessage());
                                }
                            });


                        }else{
                            Toast.makeText(SignUpActivity.this, "Password should have minimum of 6 character", Toast.LENGTH_SHORT).show();
                        }

                    }else{
                            Toast.makeText(SignUpActivity.this, "Invalid Email", Toast.LENGTH_SHORT).show();
                        }
                    }
                }
        });

        tvLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SignUpActivity.this,LoginActivity.class);
                startActivity(intent);
            }
        });
    }

    private void initVars() {
        tvLogin = findViewById(R.id.tvLogin);
        username = findViewById(R.id.etUsername);
        email = findViewById(R.id.etEmail);
        password =  findViewById(R.id.etPassword);
        btnsignup =  findViewById(R.id.btnSignup);
    }
}