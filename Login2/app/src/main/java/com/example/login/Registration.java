package com.example.login;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.shashank.sony.fancytoastlib.FancyToast;

public class Registration extends AppCompatActivity {
    View vLog;
    EditText etFullName, etEmail, etPwd, etRePwd, etPhNo;
    Button regBtn;
    boolean isUname = false, isEmail = false, isPhnNo = false, isPwd = false, isRePwdMach = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);
        viewBinder();
        vLog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Registration.this, MainActivity.class));
                Registration.this.finish();
            }
        });
        regBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                nameValidator(etFullName.getText().toString());
                emailValidator(etEmail.getText().toString());
                phoneNoValidator(etPhNo.getText().toString());
                passwordValidator(etPwd.getText().toString());
                reEnterPwdValidator(etRePwd.getText().toString());
            }
        });
    }

    public void reEnterPwdValidator(String repwd) {
        String prvpwd = null;
        if (isPwd) {
            prvpwd = etPwd.getText().toString();
            pwdChecker(prvpwd, repwd);
        } else if (repwd.length() == 0) {
            FancyToast.makeText(this, "Please re-enter your password for confirmation ", FancyToast.LENGTH_LONG, FancyToast.ERROR, true).show();
            isRePwdMach = false;
        }
    }

    public void pwdChecker(String prvpwd, String repwd) {
        if (prvpwd.equals(repwd)) {
            isRePwdMach = true;
        } else {
            isRePwdMach = false;
            FancyToast.makeText(this, "Entered password doesnot match ", FancyToast.LENGTH_LONG, FancyToast.ERROR, true).show();

        }

    }

    public void passwordValidator(String pwd) {
        if (pwd.length() == 0) {
            FancyToast.makeText(this, "Please enter password ", FancyToast.LENGTH_LONG, FancyToast.ERROR, true).show();
            isPwd = false;
        } else {
            isPwd = true;
        }
    }

    public void phoneNoValidator(String phno) {
        if (phno.length() == 10) {
            isPhnNo = true;
        } else if (phno.length() == 0) {
            FancyToast.makeText(this, "Phone no feield is empty ", FancyToast.LENGTH_LONG, FancyToast.ERROR, true).show();

            isPhnNo = false;
        } else {
            FancyToast.makeText(this, "Please enter a valid phone no ", FancyToast.LENGTH_LONG, FancyToast.ERROR, true).show();

            isPhnNo = false;
        }
    }

    public void emailValidator(String email) {
        if (TextUtils.isEmpty(email)) {
            FancyToast.makeText(this, "Email feild is empty", FancyToast.LENGTH_LONG, FancyToast.ERROR, true).show();

            isEmail = false;
        } else if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            FancyToast.makeText(this, "Enter a valid email address", FancyToast.LENGTH_LONG, FancyToast.ERROR, true).show();

            isEmail = false;
        } else {
            isEmail = true;
        }


    }


    public void nameValidator(String name) {


    }

    private void viewBinder() {
        vLog = findViewById(R.id.vLog);
        etFullName = findViewById(R.id.etFullname);
        etEmail = findViewById(R.id.etEmail);
        etPwd = findViewById(R.id.etPwd);
        etRePwd = findViewById(R.id.etRePwd);
        etPhNo = findViewById(R.id.etPhno);
        regBtn = findViewById(R.id.regBtn);


    }

}
