package com.milestonee.milestone_project;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    static ListView lv;//Variable Description
    static int indexx=0;//Variable Description
    static  String item="";//Variable Description
    static String startdate="", enddate="", name="";//Variable Description
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lv = (ListView) findViewById(R.id.listview);//Initialising ListView
        try {
            lv.setAdapter(HomeActivity.adapter);
            lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position,
                                        long id) {
                    item = ((TextView) view).getText().toString();
                    String[] result = item.split("\n", 2); // Delimit the string upto 2nd line
                    result[0]=result[0].substring(result[0].indexOf(":")+1, result[0].length());//get first line
                    result[0]=result[0].trim();//trim the first line
                    name=result[0]+"";//store it in name
                    indexx = position;//store the position in indexx
                    Intent intent = new Intent(MainActivity.this, MilestoneActivity.class);//MainActivity to Milestone Activity
                    startActivity(intent);// Start Activity
                }
            });
        }catch (Exception ds){}
    }
}
