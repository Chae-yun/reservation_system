package kr.hs.emirim.ycy6685.reservationsystem;

import android.graphics.Color;
import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.Chronometer;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.TimePicker;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    Chronometer chrono;
    Button butStart,butDone;
    RadioButton radioDate,radioTime;
    CalendarView calView;
    TimePicker timePicker;
    TextView textResult; //참조변수들

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main); //이걸 통해 인플레이션(xml문서의 클래스 이름을 찾아 올림?)

        chrono=(Chronometer)findViewById(R.id.chrono); //이건 인플레이션 후에 해줘야 함! 안그럼 널값
        //파인드뷰바이아이디는 반환이 뷰! 그러니까 크로노미터로 형변환 안하면 에러
        butStart=(Button)findViewById(R.id.but_start);
        butDone=(Button)findViewById(R.id.but_done);
        radioDate=(RadioButton)findViewById(R.id.radio_date);
        radioTime=(RadioButton)findViewById(R.id.radio_time);
        calView=(CalendarView)findViewById(R.id.calendar);
        timePicker=(TimePicker)findViewById(R.id.time_pick);
        textResult=(TextView)findViewById(R.id.text_result);
        timePicker.setVisibility(View.INVISIBLE);
        calView.setVisibility(View.INVISIBLE);

        radioDate.setOnClickListener(new View.OnClickListener() { //익명클래스 하려면 괄호 안에 new + 추상클래스나 인터페이스 이름
            @Override
            public void onClick(View v) {
                calView.setVisibility(View.VISIBLE);
                timePicker.setVisibility(View.INVISIBLE);
            }
        });

        radioTime.setOnClickListener(new View.OnClickListener() { //익명클래스 하려면 괄호 안에 new + 추상클래스나 인터페이스 이름
            @Override
            public void onClick(View v) {
                calView.setVisibility(View.INVISIBLE);
                timePicker.setVisibility(View.VISIBLE);
            }
        });

        butStart.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                chrono.setBase(SystemClock.elapsedRealtime()); //long 타입
                chrono.start();
                chrono.setTextColor(Color.RED);
            }
        });

        butDone.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                chrono.stop();
                chrono.setTextColor(Color.BLUE);
                Calendar cal=Calendar.getInstance(); //추상클래스라 뉴 못씀
                cal.setTimeInMillis(calView.getDate()); //시스템 날짜로 하려면 이문장 ㄴㄴ 우리는 캘린더 객체의 날짜로 하기 위해서
                //getDate가 밀리세컨드로 반환해서 setTimeInMillis 쓴거임?

                int year=cal.get(Calendar.YEAR); //캘린더뷰에 설정된 연도 반환 가능, 상수 필드로!
                int month=cal.get(Calendar.MONTH)+1; //달은 0부터 시작해서 나와서 +1
                int date=cal.get(Calendar.DATE);
                //int hour=timePicker.getHour(); //23버전 이하는 이게 안 되는데 그러면 캘린더처럼 해야 됨
                //int minute=timePicker.getMinute();

                String dateAndTime=year+"년 "+month+"월 "+date+"일";
                textResult.setText(dateAndTime);
            }
        });
    }
}
