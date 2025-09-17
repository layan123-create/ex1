package com.example.ex1;

import android.content.Intent;
import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        BottomNavigationView bt = findViewById(R.id.bt);
        bt.setOnItemSelectedListener(item -> {
            int id = item.getItemId();
            Intent intent1 = null;

            if (id == R.id.main) {
                intent1 = new Intent(this, MainActivity.class);
            } else if (id == R.id.login) {
                intent1 = new Intent(this, MainActivity2.class);
            } else if (id == R.id.dash) {
                intent1 = new Intent(this, MainActivity3.class);
            }
            if (intent1 != null) {
                startActivity(intent1);
                return true;
            }
            return false;
        });
    }
}