package com.qrrollcall.qrrollcall;

import androidx.activity.result.ActivityResult;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.renderscript.ScriptGroup;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button forgotpassword;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        forgotpassword = (Button) findViewById(R.id.forgotbutton);

        forgotpassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                forgotPage();

            }
        });

    }

    protected void forgotPage()
    {
        Intent forgotintent = new Intent(this, forgot_password.class);
        startActivity(forgotintent);

    }


}