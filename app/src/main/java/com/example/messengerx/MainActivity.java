package com.example.messengerx;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

import com.example.messengerx.Adapters.FragmentsAdapter;
import com.example.messengerx.databinding.ActivityMainBinding;
import com.example.messengerx.databinding.ActivitySigninBinding;
import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding1;
    FirebaseAuth auth1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding1 = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding1.getRoot());
        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(getResources().getColor(R.color.colorPrimary)));

        auth1 = FirebaseAuth.getInstance();

        binding1.viewpager.setAdapter(new FragmentsAdapter(getSupportFragmentManager()));
        binding1.tablayout.setupWithViewPager(binding1.viewpager);


        binding1.swipe.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                Intent intent4 = new Intent(MainActivity.this,MainActivity.class);
                startActivity(intent4);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu , menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        int id = item.getItemId();
        if(id == R.id.logout){

            auth1.signOut();
            Intent it = new Intent(MainActivity.this, Signin.class);
            startActivity(it);

        }
        else if (id == R.id.settings) {
            Intent intent2 = new Intent(MainActivity.this,SettingsActivity.class);
            startActivity(intent2);
        }
        else if (id == R.id.refresh) {
            Intent intent3 = new Intent(MainActivity.this,MainActivity.class);
            startActivity(intent3);
        }
        return super.onOptionsItemSelected(item);
    }
}