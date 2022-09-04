package com.example.nepaleats;

import static com.example.nepaleats.api.ApiClient.retrofit;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.nepaleats.api.ApiClient;
import com.example.nepaleats.api.ApiInterface;
import com.example.nepaleats.app.NepalEats;
import com.example.nepaleats.response.ChangePasswordResponse;
import com.example.nepaleats.response.ResigsterResponse;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ChangePasswordActivity extends AppCompatActivity {
    private Button btnChangePassword;
    private EditText tvOldPassword, tvNewPassword, tvConfirmPassword;
    private Context context;
    ApiInterface apiInterface;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        setContentView(R.layout.activity_change_password);
        getSupportActionBar().setTitle("Change Password");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        intisVars();

        btnChangePassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (tvOldPassword.getText().toString().isEmpty() || tvNewPassword.getText().toString().isEmpty() || tvConfirmPassword.getText().toString().isEmpty()) {
                    Toast.makeText(ChangePasswordActivity.this, "Fill as the deatils", Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(ChangePasswordActivity.this, "Password changed", Toast.LENGTH_SHORT).show();
                    String password = tvNewPassword.getText().toString();
                    String re_password = tvConfirmPassword.getText().toString();
                    String Email = NepalEats.prefs.getPrefs().getEmail();
                    String oldPassword = tvOldPassword.getText().toString();
                    int id = NepalEats.prefs.getPrefs().getId();

                    if (password.equals(re_password)){

                        apiInterface = ApiClient.getClient().create(ApiInterface.class);
                        retrofit2.Call<ResigsterResponse> call = apiInterface.login(
                                Email, oldPassword
                        );
                        call.enqueue(new Callback<ResigsterResponse>() {
                            @Override
                            public void onResponse(Call<ResigsterResponse> call, Response<ResigsterResponse> response) {
                                ResigsterResponse rs = response.body();
                                if(rs != null){
                                    if(rs.isSuccess()){

                                        changePasswordAPI(id, password);

                                    }else{
                                        Log.d("aayush", "Response=>else is success");
                                        Toast.makeText(context,rs.getMessage(),Toast.LENGTH_SHORT).show();
                                    }
                                }else{
                                    Log.d("aayush", "Response=> else is false");
                                    Toast.makeText(context,"Password invalid",Toast.LENGTH_SHORT).show();
                                }
                            }

                            @Override
                            public void onFailure(Call<ResigsterResponse> call, Throwable t) {
                                Log.d("aayush", "Response=>" + t.getMessage());
                                Toast.makeText(context,"Server Error",Toast.LENGTH_SHORT).show();
                            }
                        });

                    }else{
                        Toast.makeText(ChangePasswordActivity.this, "Password does not match", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });

    }


    public void changePasswordAPI(int id, String password){
        apiInterface = ApiClient.getClient().create(ApiInterface.class);
        retrofit2.Call<ChangePasswordResponse> call1 = apiInterface.changePassword(
                id,
                password
        );
        call1.enqueue(new Callback<ChangePasswordResponse>() {
            @Override
            public void onResponse(Call<ChangePasswordResponse> call, Response<ChangePasswordResponse> response) {
                ChangePasswordResponse rs = response.body();

                if (rs.isSuccess()){
                    NepalEats.prefs.clearPrefs();
                    Intent intent = new Intent(ChangePasswordActivity.this, LoginActivity.class);
                    startActivity(intent);
                    finish();
                }
            }

            @Override
            public void onFailure(Call<ChangePasswordResponse> call, Throwable t) {

            }
        });
    }




    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(item.getItemId() == android.R.id.home){
            finish();
        }

        return super.onOptionsItemSelected(item);
    }

    public void intisVars(){
        btnChangePassword= (Button)findViewById(R.id.btnChangePassword);
        tvOldPassword = findViewById(R.id.tvOldPassword);
        tvNewPassword = findViewById(R.id.tvNewPassword);
        tvConfirmPassword = findViewById(R.id.tvConfirmPassword);
        context=this;
    }




}