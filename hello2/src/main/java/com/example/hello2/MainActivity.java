package com.example.hello2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

/**
 * MainActivity 는 hello2 앱이 활성화 될떄
 * 최초로 사용자를 대면하는 액티비티이다.
 * 대체로 액티비티 하나는 화면 하나이다
 */
public class MainActivity extends AppCompatActivity {
    /**
     * 액티비가 활성화 될떄 최초 호출되는 되소드
     *
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //res/layout/activity_main.xml 문서를 전개(해석) 해서 화면 구성하기
        setContentView(R.layout.activity_main);
    }

    //버튼을 클릭했을때 호출되는 메소드
    public void clicked(View view){
        Toast.makeText(this, "버튼on", Toast.LENGTH_SHORT).show();
    }
    public void deleteClicked(View view){
        Toast.makeText(this, "삭제버튼on", Toast.LENGTH_SHORT).show();

    }
}