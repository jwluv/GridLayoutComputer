package com.lyna.www.gridlayoutcomputer;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText edittext_num1, edittext_num2;
    Button button_add, button_sub, button_mul, button_div;
    TextView textview_result;
    String num1, num2;
    Integer result;
    Button[] numButtons = new Button[10];
    Integer[] numBtnIDs = {R.id.button0, R.id.button1, R.id.button2, R.id.button3, R.id.button4, R.id.button5, R.id.button6, R.id.button7, R.id.button8, R.id.button9};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.setTitle("그리드 레이아웃 계산기");
        edittext_num1 = (EditText) findViewById(R.id.edittext_num1);
        edittext_num2 = (EditText) findViewById(R.id.edittext_num2);
        button_add = (Button) findViewById(R.id.button_add);
        button_sub = (Button) findViewById(R.id.button_sub);
        button_mul = (Button) findViewById(R.id.button_mul);
        button_div = (Button) findViewById(R.id.button_div);

        textview_result = (TextView) findViewById(R.id.textview_result);

        for(int i=0; i<numBtnIDs.length; i++){
            numButtons[i] = (Button)findViewById(numBtnIDs[i]);
        }


        for(int i=0; i<numBtnIDs.length; i++){
            final int index = i;
            numButtons[index].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(edittext_num1.isFocused()) {
                        num1 = edittext_num1.getText().toString() + numButtons[index].getText().toString();
                        edittext_num1.setText(num1);
                    }
                    else if(edittext_num2.isFocused()) {
                        num2 = edittext_num2.getText().toString() + numButtons[index].getText().toString();
                        edittext_num2.setText(num2);
                    }
                    else{
                        Toast.makeText(getApplicationContext(), "먼저 입력텍스를 선택하세요", Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }

        button_add.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {

                InputMethodManager imm = (InputMethodManager) getApplicationContext().getSystemService(Activity.INPUT_METHOD_SERVICE);
                imm.hideSoftInputFromWindow(v.getWindowToken(), 0);

                num1 = edittext_num1.getText().toString();
                num2 = edittext_num2.getText().toString();
                result = Integer.parseInt(num1) + Integer.parseInt(num2);
                textview_result.setText("계산결과: "+result.toString());

                return false;
            }
        });

        button_sub.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {

                InputMethodManager imm = (InputMethodManager) getApplicationContext().getSystemService(Activity.INPUT_METHOD_SERVICE);
                imm.hideSoftInputFromWindow(v.getWindowToken(), 0);

                num1 = edittext_num1.getText().toString();
                num2 = edittext_num2.getText().toString();
                result = Integer.parseInt(num1) - Integer.parseInt(num2);
                textview_result.setText("계산결과: "+result.toString());

                return false;
            }
        });
        button_mul.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {

                InputMethodManager imm = (InputMethodManager) getApplicationContext().getSystemService(Activity.INPUT_METHOD_SERVICE);
                imm.hideSoftInputFromWindow(v.getWindowToken(), 0);

                num1 = edittext_num1.getText().toString();
                num2 = edittext_num2.getText().toString();
                result = Integer.parseInt(num1) * Integer.parseInt(num2);
                textview_result.setText("계산결과: "+result);

                return false;
            }
        });
        button_div.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {

                double res;
                InputMethodManager imm = (InputMethodManager) getApplicationContext().getSystemService(Activity.INPUT_METHOD_SERVICE);
                imm.hideSoftInputFromWindow(v.getWindowToken(), 0);

                num1 = edittext_num1.getText().toString();
                num2 = edittext_num2.getText().toString();
                res = Float.parseFloat(num1) / Float.parseFloat(num2);

                textview_result.setText("계산결과: "+res);

                return false;
            }
        });


    }
}
