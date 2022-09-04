package com.example.nepaleats;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.nepaleats.app.NepalEats;
import com.example.nepaleats.response.ResigsterResponse;
import com.example.nepaleats.api.ApiClient;
import com.example.nepaleats.api.ApiInterface;
import com.rengwuxian.materialedittext.MaterialEditText;


public class LoginActivity extends AppCompatActivity {
    private Button btnLogin;
    private TextView tvSignUp;
    private TextView tv;
    private MaterialEditText email, password;
    private ApiInterface apiInterface;
    private Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        initVars();

        checkLoggedInStatus();
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String Email = email.getText().toString(); // TODO set your email
                String Password = password.getText().toString(); // TODO set your password
//                final String urlToCall = et_server.getText().toString(); // TODO set your url

                apiInterface = ApiClient.getClient().create(ApiInterface.class);
                retrofit2.Call<ResigsterResponse> call = apiInterface.login(
                        Email, Password
                );
                call.enqueue(new retrofit2.Callback<ResigsterResponse>() {
                    @Override
                    public void onResponse(@NonNull retrofit2.Call<ResigsterResponse> call, @NonNull retrofit2.Response<ResigsterResponse> response) {
                        Log.d("aayush", "Response=>"+response.toString());
                        ResigsterResponse rs = response.body();
                        if(rs != null){
                            if(rs.isSuccess()){
                                NepalEats.prefs.setPrefs(rs.getData());
                                startMain();
                            }else{
                                Log.d("aayush", "Response=>else is success");
                                Toast.makeText(context,rs.getMessage(),Toast.LENGTH_SHORT).show();
                            }
                        }else{
                            Log.d("aayush", "Response=> else is false");
                            Toast.makeText(context,"Email or password invalid",Toast.LENGTH_SHORT).show();
                        }
                    }

                    @Override
                    public void onFailure(@NonNull retrofit2.Call<ResigsterResponse> call, @NonNull Throwable t) {

                    }
                });
            }

        });

        tvSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this,SignUpActivity.class);
                startActivity(intent);
            }
        });



    }

    private void startMain() {
        Intent intent = new Intent(LoginActivity.this, MainActivity.class);
        startActivity(intent);
        this.finish();
    }

    private void checkLoggedInStatus() {
        if(NepalEats.prefs.getPrefs()!= null){
            Intent intent = new Intent(LoginActivity.this, MainActivity.class);
            startActivity(intent);
        }
    }


    private void initVars(){
        btnLogin= findViewById(R.id.btnLogin);
        tvSignUp= findViewById(R.id.tvSignUp);
        email=findViewById(R.id.lgEmail);
        password=findViewById(R.id.loPassword);
        tv=findViewById(R.id.tv);
        context=this;

    }


}