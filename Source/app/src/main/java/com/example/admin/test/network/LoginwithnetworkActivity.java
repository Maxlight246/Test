package com.example.admin.test.network;

import android.app.ProgressDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.admin.test.R;
import com.google.gson.Gson;
import com.squareup.picasso.Picasso;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class LoginwithnetworkActivity extends AppCompatActivity {
    EditText edUsername, edPassword;
    Button btLogin;
    ImageView imgProfile;
    TextView tvTitle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loginwithnetwork);
        init();
    }

    private void init() {
        edUsername = findViewById(R.id.ed_username);
        edPassword = findViewById(R.id.ed_password);
        btLogin = findViewById(R.id.bt_login);
        tvTitle = findViewById(R.id.tv_title);
        imgProfile = findViewById(R.id.img_profile);

        btLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                final ProgressDialog dialog = ProgressDialog.show(LoginwithnetworkActivity.this, "",
                        "Loading. Please wait...", true);

                String username = edUsername.getText().toString();
                String password = edPassword.getText().toString();
                Retrofit retrofit = new Retrofit.Builder()
                        .baseUrl("http://192.168.1.9:3000")
                        .addConverterFactory(GsonConverterFactory.create())
                        .build();
                retrofit.create(APIServices.class).login(username,password).enqueue(new Callback<LoginRequest>() {
                    @Override
                    public void onResponse(Call<LoginRequest> call, Response<LoginRequest> response) {

                        dialog.dismiss();
                        if (response.isSuccessful()){
                            LoginRequest loginRequest = response.body();
                            if (loginRequest.getStatus() == 1){
                                   tvTitle.setText("Xin chao"+ loginRequest.getData().getUsername());
                                Picasso.get().load(loginRequest.getData().getProfilePicture()).into(imgProfile);
                            }else {
                                Toast.makeText(LoginwithnetworkActivity.this, loginRequest.getMsg(), Toast.LENGTH_SHORT).show();
                            }
                        }
                    }

                    @Override
                    public void onFailure(Call<LoginRequest> call, Throwable t) {
                        tvTitle.setText("khong co mang");
                        dialog.dismiss();
                    }
                });

                Retrofit retrofit1 = new Retrofit.Builder().baseUrl("https://apilite.cukcuk.vn/service/").addConverterFactory(GsonConverterFactory.create()).build();
                retrofit1.create(APIServices.class).GetList().enqueue(new Callback<String>() {
                    @Override
                    public void onResponse(Call<String> call, Response<String> response) {
                        Gson gson = new Gson();
                        RestaurantTypeRequest restaurantTypeRequest = gson.fromJson(response.body(),RestaurantTypeRequest.class);
                    }

                    @Override
                    public void onFailure(Call<String> call, Throwable t) {

                    }
                });
            }
        });
    }
}
