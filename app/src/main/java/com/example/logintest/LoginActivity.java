package com.example.logintest;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {
    private EditText mEditText_username;
    private EditText mEditText_password;
    private Button mButton_login;
    private Button mButton_register;
    private String str_username;
    private String str_password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mEditText_username = findViewById(R.id.username);
        mEditText_password = findViewById(R.id.password);
        mButton_login = findViewById(R.id.button_login);
        mButton_register = findViewById(R.id.button_register);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar!=null){
            actionBar.hide();
        }

        mButton_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                str_username = mEditText_username.getText().toString();
                str_password = mEditText_password.getText().toString();
                if (str_username.equals("admin") && str_password.equals("admin")) {
                    Intent intent = new Intent(LoginActivity.this, SuccessActivity.class);
                    startActivity(intent);
                }
                else {
                    AlertDialog.Builder builder = new AlertDialog.Builder(LoginActivity.this);
                        builder.setTitle("提示：");
                        builder.setMessage("用户名或密码错误");
                        builder.setPositiveButton("确定",new DialogInterface.OnClickListener(){
                            @Override
                            public void onClick(DialogInterface arg0, int arg1) {
                                Toast.makeText(LoginActivity.this, "请重新输入！",Toast.LENGTH_LONG).show();
                            }
                        });
                    AlertDialog dialog = builder.create();
                    dialog.show();


                }
            }
        });
    }


}