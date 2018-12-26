package com.example.admin.test.testkt;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.admin.test.R;
import com.example.admin.test.network.LoginRequest;
import com.example.admin.test.testkt.Object.LoginRequest2;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {
    TextView tvDangky;
    EditText edName, edPassword;
    Button btLogin;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        init();
        btLogin.setOnClickListener(this);
        tvDangky.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }

    private void init() {
        tvDangky = findViewById(R.id.tv_dangky);
        edName = findViewById(R.id.ed_name);
        edPassword = findViewById(R.id.ed_password);
        btLogin = findViewById(R.id.bt_login);
    }

    @Override
    public void onClick(View v) {
        String username = edName.getText().toString();
        String password = edPassword.getText().toString();

        Retrofit retrofit = new Retrofit.Builder().baseUrl("http://192.168.1.12:3000")
                                                    .addConverterFactory(GsonConverterFactory.create())
                                                    .build();
        retrofit.create(APIServices2.class).login(username,password).enqueue(new Callback<LoginRequest2>() {
            @Override
            public void onResponse(Call<LoginRequest2> call, Response<LoginRequest2> response) {
                if (response.isSuccessful()){
                    LoginRequest2 loginRequest = response.body();
                    if (loginRequest.getStatus()==1){
                        Intent intent = new Intent(LoginActivity.this,ListActivity.class);
                        startActivity(intent);
                    }
                }
            }

            @Override
            public void onFailure(Call<LoginRequest2> call, Throwable t) {

            }
        });
    }


}
