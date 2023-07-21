package com.example.step01activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    //카운트 셀 필드
    private int count=20000;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    //버튼을 클랙했을떄 실행되는 메소드
    public void clicked(View view){
        count++;
        /**
         * 필드의 값을 TextView 에 출력하기
         * res/layout/activvity_main.xml 문서를 전개해서 레이아웃을 구성
         * 거기에서 TextView의 참조값을 얻어와야한다
         */
        TextView a = findViewById(R.id.textView);
        a.setText(Integer.toString(count));

    }
    public void reserBtn(View view){
        /**
         * 현재 활성화 되어 있는 액티비티가  구성한  화면에서
         * textView 라는 아이디를 가지고 있는 UI 의 참조값 얻어와서
         * TextView type 의 a라는 지역 변수에 담기
         */
        count=0;
        TextView a = findViewById(R.id.textView);
        a.setText(Integer.toString(count));

    }
}