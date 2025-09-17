package com.example.ex1;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.bottomnavigation.BottomNavigationView;


public class MainActivity2 extends AppCompatActivity {
    EditText user, pass;
    Button buttonSignUp, buttonLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        user = findViewById(R.id.name);
        pass = findViewById(R.id.pas);
        buttonSignUp = findViewById(R.id.SignUp);
        buttonLogin = findViewById(R.id.Login);

        buttonSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name1 = user.getText().toString().trim();
                String password1 = pass.getText().toString().trim();
                if (!name1.isEmpty() && !password1.isEmpty()) {
                    SharedPreferences shared = getSharedPreferences("UserPrefs", MODE_PRIVATE);
                    SharedPreferences.Editor editor = shared.edit();
                    editor.putString("name", name1);
                    editor.putString("password", password1);
                    editor.apply();

                    Toast.makeText(MainActivity2.this, "تم التسجيل بنجاح", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(MainActivity2.this, "الرجاء إدخال اسم المستخدم وكلمة المرور", Toast.LENGTH_SHORT).show();
                }
            }
        });

        buttonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences sharedPreferences = getSharedPreferences("UserPrefs", MODE_PRIVATE);
                String savedName = sharedPreferences.getString("name", null);
                String savedPass = sharedPreferences.getString("password", null);
                String inputName = user.getText().toString().trim();
                String inputPassword = pass.getText().toString().trim();
                if (savedName != null && savedPass != null) {
                    if (savedName.equals(inputName) && savedPass.equals(inputPassword)) {
                        Toast.makeText(MainActivity2.this, "تم تسجيل الدخول بنجاح ", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(MainActivity2.this, MainActivity3.class);
                        intent.putExtra("loggedUser", savedName);
                        startActivity(intent);
                        finish();
                    } else {
                        Toast.makeText(MainActivity2.this, "اسم المستخدم أو كلمة المرور غير صحيحة", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(MainActivity2.this, "لا يوجد حساب مسجل، الرجاء التسجيل أولاً", Toast.LENGTH_SHORT).show();
                }
            }
        });
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
}