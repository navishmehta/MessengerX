package com.example.messengerx;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.messengerx.databinding.ActivitySigninBinding;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class Signin extends AppCompatActivity {

    ActivitySigninBinding binding;
    FirebaseAuth auth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivitySigninBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        auth = FirebaseAuth.getInstance();

        binding.signuptv2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i3 = new Intent(Signin.this , SignUp.class);
                startActivity(i3);
            }
        });

        binding.loginbtn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            auth.signInWithEmailAndPassword(binding.emailet2.getText().toString() , binding.passwordet2.getText().toString()).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if(task.isSuccessful()){
                        Intent i6 = new Intent(Signin.this , MainActivity.class);
                        startActivity(i6);
//                        Toast.makeText(Signin.this, "THERE", Toast.LENGTH_SHORT).show();
                    }
                    else{
                        Toast.makeText(Signin.this, task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                    }
                }
            });

            }
        });

        if(auth.getCurrentUser()!= null){
            Intent i2 = new Intent(Signin.this , MainActivity.class);
            startActivity(i2);
        }

    }
}

