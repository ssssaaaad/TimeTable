package com.cookandroid.timetable;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Debug;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class correct extends AppCompatActivity {

    int day;
    int time;
    String lectureName;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_correct);

        String[] dayArray = {"월요일","화요일","수요일","목요일","금요일"};
        String[] timeArray = {"09:00","10:00","11:00","12:00","13:00","14:00","15:00","16:00","17:00"};
        Log.e("test","catch");

        //spinner
        Spinner spinner_day = (Spinner) findViewById(R.id.spinner_day);
        ArrayAdapter<String> adapter_day =new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, dayArray);
        spinner_day.setAdapter(adapter_day);
        //adapter_day.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        //spinner_day.setAdapter(adapter_day);

        Spinner spinner_time = (Spinner) findViewById(R.id.spinner_time);
        ArrayAdapter<String> adapter_time = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item,timeArray);
        //adapter_time.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner_time.setAdapter(adapter_time);

        EditText editText = (EditText) findViewById(R.id.editText_LecturName);

        spinner_day.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                day = i;
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
                day = 100;
            }
        });

        spinner_time.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                time = i;
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
                time = 100;
            }
        });

        Button corrected = (Button) findViewById(R.id.button_currented);
        corrected.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
                //if(day!=100||time!=100) {
                    lectureName = editText.getText().toString();
                    Log.e("intent 보내기",day+" "+time+" "+lectureName);
                    intent.putExtra("day", day);
                    intent.putExtra("time", time);
                    intent.putExtra("lectureName", lectureName);

                    startActivity(intent);
                //}
                //else
                //{
                //    Toast.makeText(getApplicationContext(),"강의 정보를 넣어주세요",Toast.LENGTH_SHORT);
                //}
            }
        });

        Button cancle = (Button) findViewById(R.id.button_cancle);
        cancle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),MainActivity.class);
                startActivity(intent);
            }
        });
    }
}