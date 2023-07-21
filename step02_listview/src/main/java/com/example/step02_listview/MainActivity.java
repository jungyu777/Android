package com.example.step02_listview;

import android.app.AlertDialog;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;
public class MainActivity extends AppCompatActivity
        implements
        AdapterView.OnItemClickListener ,
        AdapterView.OnItemLongClickListener {
    List<String> names;
    ArrayAdapter<String> adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //res
        setContentView(R.layout.activity_main);

        //ListView 의 참조값 이 리턴된다
        //안드로이드는 모든 리소스에 숫자를 부여해둔다 (정수)
        //어떤 숫자를 부여했는지 모르니깐  R.id.listView로 찾는다
        ListView listView=findViewById(R.id.listView);

        //ListView 에 출력할 SampleData
        names=new ArrayList<>();
        names.add("김구라");
        names.add("해골");
        names.add("원숭이");
        for(int i=0; i<100; i++){
            names.add("아무게"+i);
        }
        //ListView 에 연결할 아답타 객체 생성하기
        // new ArrayAdapter<>( Context , layout resource , 모델 )
         adapter=new ArrayAdapter<>(
                this,
                android.R.layout.simple_list_item_1,
                names
        );
        //여기에 listView = 이런종류의 setOnItemClickListener =이벤트가 발생하면
        // this = 호출할 메소드를 가지고 있는 객체의 참조값 전달
        //아답타를 ListView 에 연결하기
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(this);

        listView.setOnItemLongClickListener(this);

        //버튼에 리스너 등록
        Button addBtn = findViewById(R.id.addBtn);
        addBtn.setOnClickListener(view -> {
            //1, EditText에 입력한 문자열을 읽어와서
            EditText inputName = findViewById(R.id.inputName);
            String name = inputName.getText().toString();
            //2.names(모델)에 추가하고
            names.add(name);
            //3.어뎁터에 names(모델)이 변경되었다고 알린다
            adapter.notifyDataSetChanged();
            //마지막 위치까지 부드럽게 스크롤하기ㅇㄴ
            int position = adapter.getCount();//전체 아이템의 개수
            listView.smoothScrollToPosition(position);
        });
    }

    /**
     *
     * 어댑터의 역활  셀을구성할  뷰를 공급
     */

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        //i는 클릭한 Item  의 인덱스값
        Log.d("MainActivity","i:" + i);
        //클릭한 Item 에 출략된 이름
        String clickedName=names.get(i);
        //토스트 (가벼운메세지) 출력
        Toast.makeText(this, clickedName, Toast.LENGTH_SHORT).show();

    }
    //listView 의 cell을 오랫동안 클릭하면 호출되는 메소드
    @Override
    public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {

        /*
        DialogInterface.OnClickListener listener = new DialogInterface.OnClickListener(){


            //알림창에 있는 버튼을 눌렀을때(예,아니요) 호출되는 메소드를 가지고 있는 리스너 객체
            @Override
            public void onClick(DialogInterface dialogInterface, int result) {
                if( result == DialogInterface.BUTTON_POSITIVE){//긍정버튼을 눌렀을때
                    //i번쨰 인덱스의 아이템을 제거
                    //제거하는방법
                    //1.모델에서 제거하고
                    names.remove(i);
                    //모델이 변경되었다고 어뎁터에 알리면 ListView 가 업데이트 된다.
                    adapter.notifyDataSetChanged();

                    }
                }
            };
       new AlertDialog.Builder(this)
               .setTitle("알림")
               .setMessage("삭제할까요?")
               .setPositiveButton("네",listener)
               .setNegativeButton("아니요",listener)
               .create()
               .show();
       */
        new AlertDialog.Builder(this)
                .setTitle("알림")
                .setMessage("삭제할까요?")
                .setPositiveButton("네",(a,b)->{
                    //1.모델에서 제거하고
                    names.remove(i);
                    //모델이 변경되었다고 어뎁터에 알리면 ListView 가 업데이트 된다.
                    adapter.notifyDataSetChanged();
                })
                .setNegativeButton("아니요",null)
                .create()
                .show();
       return false;
    };
}

