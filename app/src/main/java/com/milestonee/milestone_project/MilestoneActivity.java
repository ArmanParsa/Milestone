package com.milestonee.milestone_project;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Scanner;

public class MilestoneActivity extends AppCompatActivity implements View.OnClickListener{

    static ImageView I1,I2,I3,I4,I5;
    TextView t1,t2,t3,t4,t5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_milestone);
        I1=(ImageView)findViewById(R.id.imageView7);
        I1.setVisibility(View.INVISIBLE);
        I2=(ImageView)findViewById(R.id.imageView8);
        I2.setVisibility(View.INVISIBLE);
        I3=(ImageView)findViewById(R.id.imageView9);
        I3.setVisibility(View.INVISIBLE);
        I4=(ImageView)findViewById(R.id.imageView10);
        I4.setVisibility(View.INVISIBLE);
        I5=(ImageView)findViewById(R.id.imageView11);
        I5.setVisibility(View.INVISIBLE);

        t1=(TextView)findViewById(R.id.textView7);
        t1.setText(""+MainActivity.name);
    }

    @Override
    public void onClick(View view) {
        Intent intent = new Intent(MilestoneActivity.this, EndTaskActivity.class);
        startActivity(intent);
    }

    public void onClick1(View view) {
        Intent intent = new Intent(MilestoneActivity.this, NewTaskActivity.class);
        startActivity(intent);
    }
}
