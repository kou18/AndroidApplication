package com.example.testapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView mGreeting;
    TextView mNameText;
    EditText mNameInput;
    Button mValid;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Link the widgets
        mGreeting=(TextView)findViewById(R.id.GreetingText);
        mNameText=(TextView)findViewById(R.id.NameText);
        mNameInput=(EditText)findViewById(R.id.NameInput);
        mValid=(Button)findViewById(R.id.ValidBtn);

        mValid.setEnabled(false);

        mNameInput.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                mValid.setEnabled(charSequence.toString().length()!=0);
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

        mValid.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view){
                Intent SecondActivity = new Intent(MainActivity.this, SecondActivity.class);
                startActivity(SecondActivity);
            }

        });
    }
}