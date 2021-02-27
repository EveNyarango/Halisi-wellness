package com.example.halisiwellness.ui;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import com.example.halisiwellness.R;
import com.example.halisiwellness.models.UserData;
import com.example.halisiwellness.network.HalisiApi;
import com.example.halisiwellness.network.HalisiClient;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import java.util.HashMap;
import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
public class RegisterActivity extends AppCompatActivity {
    @BindView(R.id.register_btn) Button mRegisterButton;
    @BindView(R.id.register_email)
    TextInputEditText mRegisterEmail;
    @BindView(R.id.register_name) TextInputEditText mRegisterName;
    @BindView(R.id.register_password)
    TextInputEditText mRegisterPassword;
    @BindView(R.id.confirm_register_password) TextInputEditText mConfirmPassword;
    private ProgressDialog progressDialog;
    private Button CreateUserButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        setContentView(R.layout.activity_register);
        ButterKnife.bind(this);
        loadingScreen();
        mRegisterButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Intent intent = new Intent( RegisterActivity.this,MainActivity.class);
//                startActivity(intent);
                createUser();
            }
        });
    }
    //    public void itemClicked(View view){
//        Button button = (Button) view;
//
//    }
    private void createUser() {
        String username = mRegisterName.getText().toString().trim();
        String email = mRegisterEmail.getText().toString().trim();
        String password = mRegisterPassword.getText().toString().trim();
        String confirmPassword = mConfirmPassword.getText().toString().trim();
        if (!isValidUserName(username) || !isEmailValid(email) || !isValidPassword(password, confirmPassword)) {
            return;
        }
        progressDialog.show();
        if (mRegisterButton.isClickable()) {
            UserData userData = new UserData(username, email,password);
            HalisiApi client = HalisiClient.urlRequest();
            Call<UserData> call = client.register(userData);
            call.enqueue(new Callback<UserData>() {
                @Override
                public void onResponse(Call<UserData> call, Response<UserData> response) {
                    if (response.isSuccessful()) {
                        progressDialog.dismiss();
                        Intent intent = new Intent(RegisterActivity.this, MainActivity.class);
                        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                        startActivity(intent);
                    }
                }
                @Override
                public void onFailure(Call<UserData> call, Throwable t) {
                    progressDialog.dismiss();
                }
            });
        }
    }
    private void loadingScreen() {
        progressDialog = new ProgressDialog(this);
        progressDialog.setTitle("Creating Account");
        progressDialog.setMessage("Loading....");
        progressDialog.setCancelable(false);
    }
    private boolean isValidPassword(String password, String confirmPassword) {
        if (password.length() < 6) {
            mRegisterPassword.setError("Please create a password containing at least 6 characters");
            return false;
        } else if (!password.equals(confirmPassword)) {
            mConfirmPassword.setError("Passwords do not match");
            return false;
        }
        return true;
    }
    private boolean isEmailValid(String email) {
        boolean isGoodEmail = (email != null && Patterns.EMAIL_ADDRESS.matcher(email).matches());
        if (!isGoodEmail) {
            mRegisterEmail.setError("Enter a valid email address");
            return false;
        }
        return true;
    }
    private boolean isValidUserName(String username) {
        if(username.equals("")){
            mRegisterName.setError("Please enter your name");
            return false;
        }
        return true;
    }
}






