package com.example.practical6;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    Button max,min,avg,totalStudent,AboveAverage;
    TextView tv;
    String line, arr[];
    int counter = 0, i, arrInt[];
    ArrayList<Student> st = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        max = (Button) findViewById(R.id.maxMarks);
        min = (Button) findViewById(R.id.minMarks);
        avg = (Button) findViewById(R.id.avgMarks);
        totalStudent = (Button) findViewById(R.id.Total);
        AboveAverage = (Button) findViewById(R.id.aboveAvg);
        tv = (TextView) findViewById(R.id.tv);
        try {
            InputStream is = getApplicationContext().getAssets().open("marks");
            tv = (TextView) findViewById(R.id.tv);
            BufferedReader br = new BufferedReader(new InputStreamReader(is));
            if (is!=null) {
                tv.setText("opened");
                while ((line = br.readLine()) != null) {
                    Log.d("loop", "onCreate:in loop ");
                    if (counter == 0)
                        counter++;
                    else {
                        arr = line.split(",");
                        arrInt = new int[arr.length];
                        i = 0;
                        for (String s : arr) {
                            arrInt[i] = Integer.parseInt(s);
                            i++;
                        }
                        Student ob = new Student(arrInt[0], Math.max(arrInt[1], arrInt[2]), Math.max(arrInt[3], arrInt[4]), arrInt[5]);
                        st.add(ob);
                        counter++;
                    }
                }
            }
        }
        catch (Exception ex)
        {
            tv.setText("not opened");
            Log.e("file error", "onCreate: " );
        }

        max.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Student ob = new Student();//st.get(0);
                ob = ob.Max(st);
                tv.setText(ob.data());
                Log.v("mytag", "onCreate:");
            }
        });
        min.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Student ob=new Student();
                ob=ob.Min(st);
                tv.setText(ob.data());
                }
        });
        avg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Student ob=new Student();
                double avg=ob.Average(st);
                tv.setText("Class Average is "+avg);
            }
        });
        final int finalCounter = counter;
        totalStudent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tv.setText("Total student in class are  "+(finalCounter -1));
            }
        });
        AboveAverage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Student ob=new Student();
                tv.setText("Class Average is  "+ob.aboveAvgStudent(ob.Average(st),st));
            }
        });

    }
}
