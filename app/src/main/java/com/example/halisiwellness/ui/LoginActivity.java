package com.example.halisiwellness.ui;

import androidx.appcompat.app.AppCompatActivity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import com.example.halisiwellness.R;
import com.example.halisiwellness.models.UserData;
import com.example.halisiwellness.network.HalisiApi;
import com.example.halisiwellness.network.HalisiClient;
import com.google.android.material.textfield.TextInputEditText;
import org.parceler.Parcels;
import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
public class LoginActivity extends AppCompatActivity {
    @BindView(R.id.login_btn) Button mLogonBtn;
    @BindView(R.id.login_email)
    EditText mLoginEmail;
    @BindView(R.id.login1_password)
    TextInputEditText mPassword;
    @BindView(R.id.textRegister) TextView mTextRegister;
    @BindView(R.id.botimageView) ImageView mBotImageView;
    private ProgressDialog progressDialog;
    private SharedPreferences preferences;
    private SharedPreferences.Editor mEditor;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);
        preferences = PreferenceManager.getDefaultSharedPreferences(this);
        mEditor = preferences.edit();
        loadingScreen();
        mLogonBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Intent intent = new Intent(LoginActivity.this,MainActivity.class);
//                startActivity(intent);
                logIn();
            }
        });
        mTextRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LoginActivity.this,RegisterActivity.class);
                startActivity(intent);
            }
        });
        mBotImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LoginActivity.this,ChatBoxActivity.class);
                startActivity(intent);
            }
        });
    }
    private void logIn() {
        String email = mLoginEmail.getText().toString().trim();
        String password = mPassword.getText().toString().trim();
        progressDialog.show();
        if( mLogonBtn.isClickable()){
            if (!isEmailValid(email) || !isValidPassword(password)) {
                return;
            }
            UserData userData = new UserData(email, password, 1);
            HalisiApi client = HalisiClient.urlRequest();
            Call<UserData> call = client.loginUser(userData);
            call.enqueue(new Callback<UserData>() {
                @Override
                public void onResponse(Call<UserData> call, Response<UserData> response) {
                    if (response.isSuccessful()) {
                        progressDialog.dismiss();
                        Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                        startActivity(intent);
                    }
                }
                @Override
                public void onFailure(Call<UserData> call, Throwable t) {
                }
            });
        }
    }
    private boolean isEmailValid(String email) {
        boolean isGoodEmail = (email != null && Patterns.EMAIL_ADDRESS.matcher(email).matches());
        if (!isGoodEmail) {
            mLoginEmail.setError("Enter a valid email address");
            return false;
        }
        return true;
    }
    private boolean isValidPassword(String password) {
        if (password.length() < 6) {
            mPassword.setError("Please enter a password containing at least 6 characters");
            return false;
        }
        return true;
    }
    private void loadingScreen() {
        progressDialog = new ProgressDialog(this);
        progressDialog.setTitle("Logging In");
        progressDialog.setMessage("Authenticating....");
        progressDialog.setCancelable(false);
    }
}