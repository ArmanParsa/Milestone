package com.milestonee.milestone_project;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    static ListView lv;
    static int indexx=0;
    static  String item="";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lv = (ListView) findViewById(R.id.listview);
        try {
            lv.setAdapter(HomeActivity.adapter);
            lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position,
                                        long id) {
                    item = ((TextView) view).getText().toString();
                    indexx = position;
                    Intent intent = new Intent(MainActivity.this, MilestoneActivity.class);
                    startActivity(intent);
                }
            });
        }catch (Exception ds){}
    }
}
