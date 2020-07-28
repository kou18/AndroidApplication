package com.example.testapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity implements View.OnClickListener {

    TextView mOutput;
    Button mbtn1, mbtn2,mbtn3,mbtn4,mbtn5,mbtn6,mbtn7,mbtn8,mbtn9,mbtnClear,mbtnPlus,mbtnMinus,mbtnMultiply,
            mbtnDivision,mbtnEqual,mbtnZero,mbtnDot,mbtnDelete;
    private Boolean OpIsPressed=false;
    private double firstVariable=0.0;
    private int second_variable_idx=0;
    private char Operator;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        //Wire widgets
        mOutput=(TextView)findViewById(R.id.Output);
        mbtn1=(Button)findViewById(R.id.One);
        mbtn2=(Button)findViewById(R.id.Two);
        mbtn3=(Button)findViewById(R.id.Three);
        mbtn4=(Button)findViewById(R.id.Four);
        mbtn5=(Button)findViewById(R.id.Five);
        mbtn6=(Button)findViewById(R.id.Six);
        mbtn7=(Button)findViewById(R.id.Seven);
        mbtn8=(Button) findViewById(R.id.Eight);
        mbtn9=(Button)findViewById(R.id.Nine);
        mbtnClear=(Button)findViewById(R.id.Clear);
        mbtnPlus=(Button)findViewById(R.id.Plus);
        mbtnMinus=(Button)findViewById(R.id.Minus);
        mbtnMultiply=(Button)findViewById(R.id.Multiply);
        mbtnDivision=(Button)findViewById(R.id.Division);
        mbtnEqual=(Button)findViewById(R.id.Equal);
        mbtnZero=(Button)findViewById(R.id.Zero);
        mbtnDot=(Button)findViewById(R.id.Dot);
        mbtnDelete=(Button)findViewById(R.id.Delete);



        mbtn1.setOnClickListener(this);
        mbtn2.setOnClickListener(this);
        mbtn3.setOnClickListener(this);
        mbtn4.setOnClickListener(this);
        mbtn5.setOnClickListener(this);
        mbtn6.setOnClickListener(this);
        mbtn7.setOnClickListener(this);
        mbtn8.setOnClickListener(this);
        mbtn9.setOnClickListener(this);
        mbtnPlus.setOnClickListener(this);
        mbtnMinus.setOnClickListener(this);
        mbtnMultiply.setOnClickListener(this);
        mbtnDivision.setOnClickListener(this);
        mbtnEqual.setOnClickListener(this);
        mbtnZero.setOnClickListener(this);
        mbtnDelete.setOnClickListener(this);
        mbtnDot.setOnClickListener(this);
        mbtnClear.setOnClickListener(this);


    }

    @Override
    public void onClick(View view) {
        int length= mOutput.getText().toString().length();
        final int Id=(int) view.getId();
        switch(Id){
            case R.id.One:
                mOutput.append("1");
                break;
            case R.id.Two:
                mOutput.append("2");
                break;
            case R.id.Three:
                mOutput.append("3");
                break;
            case R.id.Four:
                mOutput.append("4");
                break;
            case R.id.Five:
                mOutput.append("5");
                break;
            case R.id.Six:
                mOutput.append("6");
                break;
            case R.id.Seven:
                mOutput.append("7");
                break;
            case R.id.Eight:
                mOutput.append("8");
                break;
            case R.id.Nine:
                mOutput.append("9");
                break;
            case R.id.Equal:
                length= mOutput.getText().toString().length();
                if (OpIsPressed){
                    switchInside(length);
                }

                OpIsPressed=false;
                break;
            case R.id.Plus:
                switchfn(length, '+', "+");
                break;
            case R.id.Minus:
                switchfn(length, '-', "-");
                break;
            case R.id.Multiply:
                switchfn(length, '*', "*");
                break;
            case R.id.Division:
                switchfn(length, '/', "/");
                break;
            case R.id.Zero:
                mOutput.append("0");
                break;
            case R.id.Dot:
                if(mOutput.getText().toString().indexOf('.')<0){
                    mOutput.append(".");}
                break;
            case R.id.Clear:
                mOutput.setText("");
                break;
            case R.id.Delete:
                if(length!=0){
                    String text=mOutput.getText().toString();
                    text=text.substring(0,length-1);
                    mOutput.setText(text);
                }
                break;

        }
    }

    private void switchfn(int length, char Op, String Ope){
        if (OpIsPressed){
            switchInside(length);
            firstVariable=Double.parseDouble(mOutput.getText().toString());
            second_variable_idx=mOutput.getText().toString().length()+1;
            mOutput.append(Ope);
            Operator=Op;
        }
        else{
            OpIsPressed=true;
            Operator=Op;
            firstVariable=Double.parseDouble( mOutput.getText().toString());
            second_variable_idx=mOutput.getText().toString().length()+1;
            mOutput.append(Ope);}
    }

    void switchInside(int length){
        double secondVariable = Double.parseDouble(mOutput.getText().toString().substring(second_variable_idx,length));
        switch(Operator){
            case '+':
                mOutput.setText(String.valueOf(firstVariable+secondVariable));
                break;
            case '-':
                mOutput.setText(String.valueOf(firstVariable-secondVariable));
                break;
            case '*':
                mOutput.setText(String.valueOf(firstVariable*secondVariable));
                break;
            case '/':
                mOutput.setText(String.valueOf(firstVariable/secondVariable));
                break;
        }

    }
}