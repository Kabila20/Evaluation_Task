package com.example.evaluation_task;


import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.textfield.TextInputEditText;

import java.util.Objects;


public class LoginPage extends AppCompatActivity {
    TextInputEditText MobileNumber, passWord;
     Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);

        MobileNumber = findViewById(R.id.mobile);
        passWord = findViewById(R.id.password);
        button = findViewById(R.id.button2);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                checkLoginDetails();

              //  intent.putExtra("Values", MobileNumber.getText().toString());
               // intent.putExtra("Values", Password.getText().toString());


            }
        });
    }


    boolean isEmpty(TextInputEditText text) {
        CharSequence str = Objects.requireNonNull(text.getText()).toString();
        return TextUtils.isEmpty(str);
    }


    private void checkLoginDetails() {
        String mobileNo = null;
        String password = null;
        if (isEmpty(MobileNumber))
        {
            MobileNumber.setError("Enter your Phone number to login!");
        }
        else if (isEmpty(passWord))
        {
            passWord.setError("This field required password");
        }

        else if (MobileNumber.getText().toString().equals(mobileNo) && passWord.getText().toString().equals(password))
            {
                Toast.makeText(LoginPage.this, "Login Successfully", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(LoginPage.this, Welcome.class);
                startActivity(intent);
            }
        else {
                Toast.makeText(LoginPage.this, "MobileNumber and Password Does not match", Toast.LENGTH_SHORT ).show();
            }
    }

}
