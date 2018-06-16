package com.example.rkhat.timestable;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SeekBar;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    ListView timesTableListView;
    public void generateTimesTable(int timesTable){
        ArrayList<String>timesTablecontent=new ArrayList<String>();
        for(int i=1;i<=10;i++){
            timesTablecontent.add(Integer.toString(i*timesTable));
        }
        ArrayAdapter<String>arrayAdapter=new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,timesTablecontent);
        timesTableListView.setAdapter(arrayAdapter);



    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final SeekBar timesTableSeekBar=(SeekBar)findViewById(R.id.timesTableSeekBar);
         timesTableListView=(ListView)findViewById(R.id.timesTableListView);
        timesTableSeekBar.setMax(100);
        timesTableSeekBar.setProgress(10);

        timesTableSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                int min=1;
                int timesTable;
                if(progress<min){
                    timesTable=min;
                    timesTableSeekBar.setProgress(min);
                }
                else{
                    timesTable=progress;
                }
                generateTimesTable(timesTable);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
        generateTimesTable(10);

    }
}
