package kr.hs.emirim.ycy6685.reservationsystem;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.Chronometer;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.TimePicker;

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
    }
}
