package com.example.halisiwellness.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.halisiwellness.R;
import com.example.halisiwellness.network.RetrofitClient;
import com.example.halisiwellness.network.UserRequest;
import com.example.halisiwellness.network.UserResponse;
import com.google.android.material.textfield.TextInputEditText;

import java.io.IOException;

import butterknife.BindView;
import butterknife.ButterKnife;

import okhttp3.ResponseBody;
import retrofit2.Response;
import retrofit2.Call;
import retrofit2.Callback;


public class RegisterActivity extends AppCompatActivity implements View.OnClickListener {
    public static final String TAG = RegisterActivity.class.getSimpleName();

//    private String username;
//    private String email;
//    private String password;



    private ProgressDialog mAuthProgressDialog;
    private String mName;


    EditText mUsernameEditText, mEmailEditText;
    TextInputEditText mPasswordEditText;
    Button mRegisterButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        ButterKnife.bind(this);

        mUsernameEditText = findViewById(R.id.username);
        mEmailEditText = findViewById(R.id.email);
        mPasswordEditText = findViewById(R.id.password);
        mRegisterButton = findViewById(R.id.register_btn);

        mRegisterButton.setOnClickListener(this);
        createAuthProgressDialog();

        mRegisterButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(RegisterActivity.this, MainActivity.class);
                intent.setFlags(intent.FLAG_ACTIVITY_NEW_TASK | intent.FLAG_ACTIVITY_CLEAR_TASK);
                startActivity(intent);
                finish();

            }
        });

    }

    public UserRequest createRequest(){
        UserRequest userRequest = new UserRequest();
        userRequest.setUsername(mUsernameEditText.getText().toString());
        userRequest.setEmail(mEmailEditText.getText().toString());
        userRequest.setPassword(mPasswordEditText.getText().toString());
        return userRequest;

    }

    public void saveUser(UserRequest userRequest){
        Call <UserResponse> userResponseCall = RetrofitClient.getUserService().saveUser(userRequest);
        userResponseCall.enqueue(new Callback<UserResponse>() {
            @Override
            public void onResponse(Call<UserResponse> call, Response<UserResponse> response) {
                if (response.isSuccessful()) {
                    Toast.makeText(RegisterActivity.this, "saved successfully", Toast.LENGTH_LONG).show();
                    Intent intent = new Intent(RegisterActivity.this, MainActivity.class);
            intent.setFlags(intent.FLAG_ACTIVITY_NEW_TASK | intent.FLAG_ACTIVITY_CLEAR_TASK);
            startActivity(intent);
            finish();

                }else {
                    Toast.makeText(RegisterActivity.this, "Failed request", Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onFailure(Call<UserResponse> call, Throwable t) {
                Toast.makeText(RegisterActivity.this, t.getMessage(), Toast.LENGTH_LONG).show();

            }
        });

    }




//        api

//        Call<ResponseBody> call = RetrofitClient
//                .getInstance()
//                .getApi()
//                .register(username, email, password);
//
//        call.enqueue(new Callback<ResponseBody>() {
//            @Override
//            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
//               try{
//                String s = response.body().string();
//                Toast.makeText(RegisterActivity.this, s, Toast.LENGTH_LONG).show();
//            }catch (IOException e){
//               e.printStackTrace();
//               }
//            }
//
//            @Override
//            public void onFailure(Call<ResponseBody> call, Throwable t) {
//                Toast.makeText(RegisterActivity.this, t.getMessage(), Toast.LENGTH_LONG).show();
//
//            }
//        });
//    }
//}


        private void createAuthProgressDialog () {
            mAuthProgressDialog = new ProgressDialog(this);
            mAuthProgressDialog.setTitle("Loading...");
            mAuthProgressDialog.setMessage("Authenticating with Firebase...");
            mAuthProgressDialog.setCancelable(false);

        }

        @Override
        public void onClick (View v){
//            Intent intent = new Intent(RegisterActivity.this, MainActivity.class);
//            intent.setFlags(intent.FLAG_ACTIVITY_NEW_TASK | intent.FLAG_ACTIVITY_CLEAR_TASK);
//            startActivity(intent);
//            finish();

            if (v == mRegisterButton) {
                createNewUser();
            }
        }

        private void createNewUser () {
            final String username = mUsernameEditText.getText().toString().trim();
            final String email = mEmailEditText.getText().toString().trim();
            String password = mPasswordEditText.getText().toString().trim();
            mName = mUsernameEditText.getText().toString().trim();

            boolean validUsername = isValidUsername(username);
            boolean validEmail = isValidEmail(email);
            boolean validPassword = isValidPassword(password);
            if (!validUsername || !validEmail || validPassword) return;
            mAuthProgressDialog.show();
        }


        private boolean isValidUsername (String username){
            if (username.equals("")) {
                mUsernameEditText.setError("Please enter your name");
                return false;
            }
            return true;
        }

        private boolean isValidEmail (String email){
            boolean isGoodEmail = (email != null && Patterns.EMAIL_ADDRESS.matcher(email).matches());
            if (!isGoodEmail) {
                mEmailEditText.setError("Please enter a valid email address");
                return false;
            }
            return isGoodEmail;
        }

        private boolean isValidPassword (String password){
            if (password.length() < 6) {
                mPasswordEditText.setError("Please create a password containing at least 6 characters");
                return false;
            }
            return true;
        }


    }
