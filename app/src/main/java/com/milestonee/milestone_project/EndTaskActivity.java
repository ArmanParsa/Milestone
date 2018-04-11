package com.milestonee.milestone_project;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class EndTaskActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_end_task);
    }

    @Override
    public void onClick(View view) {
        MilestoneActivity.I1.setVisibility(View.VISIBLE);
        finish();
    }

    public void onClick1(View view) {
        MilestoneActivity.I2.setVisibility(View.VISIBLE);
        finish();
    }

    public void onClick2(View view) {
        MilestoneActivity.I3.setVisibility(View.VISIBLE);
        finish();
    }

    public void onClick3(View view) {
        MilestoneActivity.I4.setVisibility(View.VISIBLE);
        MilestoneActivity.I5.setVisibility(View.VISIBLE);
        finish();
    }
}
