package com.example.step01example;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //전송버튼의 참조값 얻어오기
        Button sendBtn = findViewById(R.id.sendBtn);
        //버튼에 리스너 등록하기
        sendBtn.setOnClickListener(this);

        Button sendBtn2 = findViewById(R.id.sendBtn2);
        sendBtn2.setOnClickListener(view -> {
            //1. editText 에 입력한 문자열을 읽어와서
            EditText editText = findViewById(R.id.editText);
            String s = editText.getText().toString();
            //2.TextView 에 출력하기
            TextView  textView = findViewById(R.id.textView);
            textView.setText(s);
        });
    }



    @Override
    public void onClick(View view) {
        //1. editText 에 입력한 문자열을 읽어와서
        EditText editText = findViewById(R.id.editText);
        String s = editText.getText().toString();
        //2.TextView 에 출력하기
        TextView  textView = findViewById(R.id.textView);
        textView.setText(s);

    }
}