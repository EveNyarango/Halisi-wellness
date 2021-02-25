package com.example.halisiwellness.ui;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import com.example.halisiwellness.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import java.util.HashMap;
import butterknife.BindView;
import butterknife.ButterKnife;
public class RegisterActivity extends AppCompatActivity {
    @BindView(R.id.register_btn) Button mRegisterButton;
    @BindView(R.id.register_email) EditText mRegisterPhone;
    @BindView(R.id.register_name) EditText mRegisterName;
    @BindView(R.id.register_password) EditText mRegisterPassword;
    @BindView(R.id.confirm_register_password) EditText mConfirmPassword;
    String Email,Password,Name;
    ProgressDialog LoadingBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        ButterKnife.bind(this);
        LoadingBar = new ProgressDialog(this);
        LoadingBar.setTitle("Creating Account");
        LoadingBar.setMessage("Please Wait while we are checking your credentials ");
        LoadingBar.setCanceledOnTouchOutside(false);
        mRegisterButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Email = mRegisterPhone.getText().toString();
//                Password = mRegisterPassword.getText().toString();
//                Name = mRegisterName.getText().toString();
//                CreateNewAccount(Email,Password,Name);

                Intent intent = new Intent(RegisterActivity.this,MainActivity.class);
                startActivity(intent);
            }
        });
    }

}






