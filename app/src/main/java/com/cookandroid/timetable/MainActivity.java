package com.cookandroid.timetable;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Dictionary;
import java.util.Enumeration;
import java.util.List;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    int day;
    int time;
    String lectureName;
    static boolean corrected = false;
    boolean corrected1 = false;
    static SQLiteDatabase database;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.e("인텐드 확인"," "+corrected);

        TextView monday9 = (TextView) findViewById(R.id.monday9);
        TextView monday10 = (TextView) findViewById(R.id.monday10);
        TextView monday11 = (TextView) findViewById(R.id.monday11);
        TextView monday12 = (TextView) findViewById(R.id.monday12);
        TextView monday13 = (TextView) findViewById(R.id.monday13);
        TextView monday14 = (TextView) findViewById(R.id.monday14);
        TextView monday15 = (TextView) findViewById(R.id.monday15);
        TextView monday16 = (TextView) findViewById(R.id.monday16);
        TextView monday17 = (TextView) findViewById(R.id.monday17);
        TextView tuesday9 = (TextView) findViewById(R.id.tuesday9);
        TextView tuesday10 = (TextView) findViewById(R.id.tuesday10);
        TextView tuesday11 = (TextView) findViewById(R.id.tuesday11);
        TextView tuesday12 = (TextView) findViewById(R.id.tuesday12);
        TextView tuesday13 = (TextView) findViewById(R.id.tuesday13);
        TextView tuesday14 = (TextView) findViewById(R.id.tuesday14);
        TextView tuesday15 = (TextView) findViewById(R.id.tuesday15);
        TextView tuesday16 = (TextView) findViewById(R.id.tuesday16);
        TextView tuesday17 = (TextView) findViewById(R.id.tuesday17);
        TextView wednesday9 = (TextView) findViewById(R.id.wednesday9);
        TextView wednesday10 = (TextView) findViewById(R.id.wednesday10);
        TextView wednesday11 = (TextView) findViewById(R.id.wednesday11);
        TextView wednesday12 = (TextView) findViewById(R.id.wednesday12);
        TextView wednesday13 = (TextView) findViewById(R.id.wednesday13);
        TextView wednesday14 = (TextView) findViewById(R.id.wednesday14);
        TextView wednesday15 = (TextView) findViewById(R.id.wednesday15);
        TextView wednesday16 = (TextView) findViewById(R.id.wednesday16);
        TextView wednesday17 = (TextView) findViewById(R.id.wednesday17);
        TextView thursday9 = (TextView) findViewById(R.id.thursday9);
        TextView thursday10 = (TextView) findViewById(R.id.thursday10);
        TextView thursday11 = (TextView) findViewById(R.id.thursday11);
        TextView thursday12 = (TextView) findViewById(R.id.thursday12);
        TextView thursday13 = (TextView) findViewById(R.id.thursday13);
        TextView thursday14 = (TextView) findViewById(R.id.thursday14);
        TextView thursday15 = (TextView) findViewById(R.id.thursday15);
        TextView thursday16 = (TextView) findViewById(R.id.thursday16);
        TextView thursday17 = (TextView) findViewById(R.id.thursday17);
        TextView friday9 = (TextView) findViewById(R.id.friday9);
        TextView friday10 = (TextView) findViewById(R.id.friday10);
        TextView friday11 = (TextView) findViewById(R.id.friday11);
        TextView friday12 = (TextView) findViewById(R.id.friday12);
        TextView friday13 = (TextView) findViewById(R.id.friday13);
        TextView friday14 = (TextView) findViewById(R.id.friday14);
        TextView friday15 = (TextView) findViewById(R.id.friday15);
        TextView friday16 = (TextView) findViewById(R.id.friday16);
        TextView friday17 = (TextView) findViewById(R.id.friday17);

        TextView mondayList[] = {monday9,monday10,monday11,monday12,monday13,monday14,monday15,monday16,monday17};
        TextView tuesdayList[] = {tuesday9,tuesday10,tuesday11,tuesday12,tuesday13,tuesday14,tuesday15,tuesday16,tuesday17};
        TextView wednesdayList[] = {wednesday9,wednesday10,wednesday11,wednesday12,wednesday13,wednesday14,wednesday15,wednesday16,wednesday17};
        TextView thursdayList[] = {thursday9,thursday10,thursday11,thursday12,thursday13,thursday14,thursday15,thursday16,thursday17};
        TextView fridayList[] = {friday9,friday10,friday11,friday12,friday13,friday14,friday15,friday16,friday17};

        //DataBaseManager dataBaseManager = DataBaseManager.getInstance(this);


        if(corrected)
        {
            Intent intent = getIntent();
            ContentValues addRowValue = new ContentValues();
            corrected1 = intent.getExtras().getBoolean("corrected1");
            addRowValue.put("corrected1",corrected1);
            if(corrected1) {
                Log.e("intent 받기", day + " " + time + " " + lectureName);

                corrected = false;
                day = intent.getExtras().getInt("day");
                time = intent.getExtras().getInt("time");
                lectureName = intent.getExtras().getString("lectureName");
                Log.e("lectureName", lectureName);


                addRowValue.put("day", day);
                addRowValue.put("time", time);
                addRowValue.put("lectureName", lectureName);

                //dataBaseManager.insert(addRowValue);
                switch (day) {
                    case 0:
                        if (lectureName.length() == 0) {
                            Log.e("mondayList", "null");
                            mondayList[time].setText("");
                            mondayList[time].setBackgroundColor(Color.parseColor("#CCCCCC"));
                        } else {
                            Log.e("mondayList", "Full");
                            mondayList[time].setText(lectureName);
                            mondayList[time].setBackgroundColor(Color.parseColor("#99FF99"));
                        }
                        break;
                    case 1:
                        if (lectureName.length() == 0) {
                            tuesdayList[time].setText("");
                            tuesdayList[time].setBackgroundColor(Color.parseColor("#CCCCCC"));
                        } else {
                            tuesdayList[time].setText(lectureName);
                            tuesdayList[time].setBackgroundColor(Color.parseColor("#99CCFF"));
                        }
                        break;
                    case 2:
                        if (lectureName.length() == 0) {
                            wednesdayList[time].setText("");
                            wednesdayList[time].setBackgroundColor(Color.parseColor("#CCCCCC"));
                        } else {
                            wednesdayList[time].setText(lectureName);
                            wednesdayList[time].setBackgroundColor(Color.parseColor("#9999FF"));
                        }
                        break;
                    case 3:
                        if (lectureName.length() == 0) {
                            thursdayList[time].setText("");
                            thursdayList[time].setBackgroundColor(Color.parseColor("#CCCCCC"));
                        } else {
                            thursdayList[time].setText(lectureName);
                            thursdayList[time].setBackgroundColor(Color.parseColor("#CCFFFF"));
                        }
                        break;
                    case 4:
                        if (lectureName.length() == 0) {
                            fridayList[time].setText("");
                            fridayList[time].setBackgroundColor(Color.parseColor("#CCCCCC"));
                        } else {
                            fridayList[time].setText(lectureName);
                            fridayList[time].setBackgroundColor(Color.parseColor("#CCCCFF"));
                        }
                        break;
                }
            }
        }



        Button button = (Button) findViewById(R.id.button_current);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),correct.class);
                corrected = true;
                Log.e("test","Throw");
                startActivity(intent);

            }
        });
    }

}