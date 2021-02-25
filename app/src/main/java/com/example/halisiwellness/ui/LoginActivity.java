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
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.halisiwellness.R;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import butterknife.BindView;
import butterknife.ButterKnife;

public class LoginActivity extends AppCompatActivity  {


    @BindView(R.id.login_btn) Button mLogonBtn;
    @BindView(R.id.textRegister) TextView mTextRegister;
    @BindView(R.id.botimageView) ImageView mBotImageView;
    @BindView(R.id.login_name) EditText mLoginName;
    @BindView(R.id.login_password) EditText mLoginPassword;

    String Name,Password; // to store phone and store password that user enters
    String userPassword;

    ProgressDialog LoadingBar;






    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);

        LoadingBar = new ProgressDialog(this);



        LoadingBar.setTitle("Log In process");
        LoadingBar.setMessage("Please wait we are checking credentials in your in our database");
        LoadingBar.setCanceledOnTouchOutside(false);


        mLogonBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                Name = mLoginName.getText().toString();
                Password = mLoginPassword.getText().toString();

                LoginAccount(Name,Password);




            }
        });

        mTextRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LoginActivity.this, RegisterActivity.class);
                startActivity(intent);
            }
        });

        mBotImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LoginActivity.this, ChatBoxActivity.class);
                startActivity(intent);
            }
        });


    }

    private void LoginAccount(String name, String password) {


        if(TextUtils.isEmpty(name))
        {
            Toast.makeText(this,"Please Enter you phone username",Toast.LENGTH_LONG).show();
        }
        else if (TextUtils.isEmpty(password))
        {
            Toast.makeText(this,"PLease enter you password",Toast.LENGTH_LONG).show();
        }
        else
        {


            LoadingBar.show();
            final DatabaseReference mRef;

            mRef = FirebaseDatabase.getInstance().getReference();

            mRef.addListenerForSingleValueEvent(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot snapshot) {

                    if (snapshot.child("Users").child(Name).exists()) {
                        userPassword = snapshot.child("Users").child(Name).child("password").getValue().toString();

                        if (Password.equals(userPassword)) {
                            //if the users  credentials are correct, will be directed on home activity
                            LoadingBar.dismiss();
                            Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                            startActivity(intent);


                        } else {   /// Checking if user the password is correct
                            LoadingBar.dismiss();
                            Toast.makeText(LoginActivity.this, "Please enter the correct password", Toast.LENGTH_LONG).show();

                        }
                    } else {
                        // Checking if the user is existing

                        Toast.makeText(LoginActivity.this, "User with this username does not exist", Toast.LENGTH_LONG).show();
                    }

                }


                @Override
                public void onCancelled(@NonNull DatabaseError error) {

                }
            });
        }


    }




}