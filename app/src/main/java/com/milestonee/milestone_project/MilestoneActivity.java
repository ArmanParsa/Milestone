package com.milestonee.milestone_project;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Scanner;

public class MilestoneActivity extends AppCompatActivity implements View.OnClickListener{

    static ImageView I1,I2,I3,I4,I5; // Variable Description
    TextView t1,t2,t3,t4,t5; // Variable Description

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_milestone);

        I1=(ImageView)findViewById(R.id.imageView7); // Initialising I1
        I1.setVisibility(View.INVISIBLE);//Making the Star Invisible
        I2=(ImageView)findViewById(R.id.imageView8);//Initialising I2
        I2.setVisibility(View.INVISIBLE);//Making the Star Invisible
        I3=(ImageView)findViewById(R.id.imageView9);//Initialising I3
        I3.setVisibility(View.INVISIBLE);//Making the star invisible
        I4=(ImageView)findViewById(R.id.imageView10);//Initialising I4
        I4.setVisibility(View.INVISIBLE);//Making the Star Invisible
        I5=(ImageView)findViewById(R.id.imageView11);//Initialising I5
        I5.setVisibility(View.INVISIBLE);//Making the badge Invisible

        t1=(TextView)findViewById(R.id.textView7);//Initialising Textview
        t1.setText(""+MainActivity.name);//Set text (Milestone Name)
    }

    @Override
    public void onClick(View view) {
        Intent intent = new Intent(MilestoneActivity.this, EndTaskActivity.class);//Milestone to EndTask
        startActivity(intent);//Start Activity
    }

    public void onClick1(View view) {
        Intent intent = new Intent(MilestoneActivity.this, NewTaskActivity.class);//Milestone to Newtask to take tasks input
        startActivity(intent);//Start Activity
    }
}
