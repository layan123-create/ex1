package com.example.ex1;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.bottomnavigation.BottomNavigationView;


public class MainActivity3 extends AppCompatActivity {
    TextView name2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        name2=findViewById(R.id.user);
        SharedPreferences sharedPreferences = getSharedPreferences("UserPrefs", MODE_PRIVATE);
        String savedName = sharedPreferences.getString("name", "user");
        String loggedUser = getIntent().getStringExtra("loggedUser");
        if (loggedUser != null) {
            name2.setText("Hello " + loggedUser);
        } else {
            name2.setText("Hello user");
        }
        BottomNavigationView bt = findViewById(R.id.bt);
        bt.setOnItemSelectedListener(item -> {
            int id = item.getItemId();
            Intent intent = null;

            if (id == R.id.main) {
                intent = new Intent(this, MainActivity.class);
            } else if (id == R.id.login) {
                intent = new Intent(this, MainActivity2.class);
            } else if (id == R.id.dash) {
                intent = new Intent(this, MainActivity3.class);
            }
            if (intent != null) {
                startActivity(intent);
                return true;
            }
            return false;
        });
    }

    public void out(View view){
        name2.setText("Hello user");
    }
    public void ext(View view){
        finishAffinity();
    }
}