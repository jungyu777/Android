package com.example.step03customadapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

//
//  레이아웃에 연결할 어텝터 클래스 정의하기
//  -BaseAdapter 추상 클래스를 상속 받아서 만든다,
//
//
public class CountryAdapter extends BaseAdapter {
    //필드
    Context context;
    int layoutRes;
    List<CountryDto>list;


    //생성자
    public CountryAdapter(Context context, int layoutRes, List<CountryDto> list){
        //생성자의 인자로 전달된 값을 필드에 저장한다.
        this.context=context;
        this.layoutRes=layoutRes;
        this.list=list;
    }

    //모델의 갯수를 리턴하는 메소드
    @Override
    public int getCount() {
        return list.size();
    }
    //i 번째 인덱스에 해당하는 모델을 리턴
    @Override
    public Object getItem(int i) {
        return list.get(i);
    }
    //i번쨰 인덱스에 해당하는 모델의 아이디(PROMARY KEY)가 있다면 리턴
    @Override
    public long getItemId(int i) {
        //없으면 인덱스를 리턴
        return i;
    }
    //i 번째 인덱스에 해당하는 cell view 를 리턴
    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        //인자로 전달되는 i 번째 cell view 를 만들어서 리턴해야 한다.
        //cell view 는 레이아웃 xml 문서를 전개해서 만들어야 한다.
        //전개해서 만든 View  의 ImageView 와 TextView 에 적절한 데이터를 출력한다음
        //view 객체를 리턴해 준다.
        //cell view 는 모델의 갯수만큼 다 만드는 것이 아니라 최소한의 갯수만 만들어서
        //기존에 만들었던 View 객체를 재사용해야 한다.

        //key point
        //레이아웃 문서를 어떻게 하면 전개할지
        //전개해서ㅓ 만든 view 의 ImageView와 TextView에 적절한 데이터를 출력할지
        //최소한의 갯수만 만들어서 기존에 만들었던 view 객체를 재사용할지
        Log.d("CountryAdapter","getView() 호출됨 i : " + i);
        Log.d("CountryAdapter","view 처음들어올떈 null 재사용하면 값이담긴다 " + view);

            if(view==null){
                //레이아웃 xml 문서를 전개해서 View 객체를 새로 만든다.
                LayoutInflater inflater = LayoutInflater.from(context);
                view = inflater.inflate(layoutRes,viewGroup,false);
            }
            //i 에 해당하는 CountryDto 객체
            CountryDto dto = list.get(i);
            //View 객체 안에 있는 ImageView, TextView 의 참조값을 얻어온다.
            ImageView imageView = view.findViewById(R.id.imageView);
            TextView textView = view.findViewById(R.id.textView);
            //ImageView ,  TextView 에 정보를 출력한다.
            imageView.setImageResource(dto.getResId());
            textView.setText(dto.getName());
            //i번째 인덱스에 해당하는 View를 리턴해준다.

        return view;
        //처음 인자로 들어오는 View 는 아무것도 안만들어져서 들어온다
        //리턴으로 만든 cell view 로 보낸다
    }
}
