package com.example.evaluation_task;




import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

import android.text.TextUtils;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;

import android.widget.TextView;
import android.widget.Toast;


import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

import java.util.Objects;


public class MainActivity extends AppCompatActivity {

    TextView textView;

    TextInputLayout layoutName, layoutMailId, layoutMobileNo, layoutPassword, layoutConfirmPassword;

    TextInputEditText name, mail, mobileNo, password, confirmPassword;

    Button button;

    String newUser,newMail,newPassword,newCnFrmPass,newPhNo;

    SharedPreferences sharedPreferences;

    public static final String MyPREFERENCES = "myPreferences";
    public static final String Name = "nameKey";
    public static final String email = "mailKey";
    public static final String phone = "phoneKey";
    public static final String Password = "passWordKey";
    public static final String ConfirmPassword = "confirmPassKey";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        textView = findViewById(R.id.textView);


        layoutName = findViewById(R.id.textInputLayout1);
        layoutMailId = findViewById(R.id.textInputLayout2);
        layoutMobileNo = findViewById(R.id.textInputLayout3);
        layoutPassword = findViewById(R.id.textInputLayout4);
        layoutConfirmPassword = findViewById(R.id.textInputLayout5);


        name = findViewById(R.id.textInputEditText6);
        mail = findViewById(R.id.textInputEditText2);
        mobileNo = findViewById(R.id.textInputEditText3);
        password = findViewById(R.id.textInputEditText5);
        confirmPassword = findViewById(R.id.textInputEditText4);

        button = findViewById(R.id.button);
        sharedPreferences = getSharedPreferences(MyPREFERENCES, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                newUser = Objects.requireNonNull(name.getText()).toString();
                 newMail = Objects.requireNonNull(mail.getText()).toString();
                 newPassword = Objects.requireNonNull(password.getText()).toString();
                 newCnFrmPass = Objects.requireNonNull(confirmPassword.getText()).toString();
                 newPhNo = Objects.requireNonNull(mobileNo.getText()).toString();
                checkDataEntered();


                editor.putString(Name, newUser);
                editor.putString(email, newMail);
                editor.putString(Password, newPassword);
                editor.putString(ConfirmPassword, newCnFrmPass);
                editor.putString(phone, newPhNo);
              final boolean commit=  editor.commit();

            }
        });
    }

    boolean isEmail(TextInputEditText text)
    {
        CharSequence newMail = Objects.requireNonNull(text.getText()).toString();
        return (!TextUtils.isEmpty(newMail) && Patterns.EMAIL_ADDRESS.matcher(newMail).matches());
    }

    boolean isEmpty(TextInputEditText text) {
        CharSequence str = Objects.requireNonNull(text.getText()).toString();
        return TextUtils.isEmpty(str);
    }


    private void checkDataEntered() {
        if (newUser.isEmpty()) {
            name.setError("Enter your name in the field");
        }
        else if(isEmpty(mail))
        {
            mail.setError("It should not be empty");
        }
        else if (!isEmail(mail)) {
            mail.setError("Enter valid email");
        }
        else if (isEmpty(mobileNo)) {
            mobileNo.setError("Enter your Phone number");
        }
        else if (isEmpty(password)) {
            password.setError("This field required password");
        }
        else if (isEmpty(confirmPassword)) {
            confirmPassword.setError("Enter your confirm password");
        }
        else if (!confirmPassword.getText().toString().equals(password.getText().toString())) {
            confirmPassword.setError("Your password does not matching");
        }
        else {
            Toast.makeText(MainActivity.this, "Registered Successfully", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(MainActivity.this, LoginPage.class);
            startActivity(intent);
        }

    }



    }


