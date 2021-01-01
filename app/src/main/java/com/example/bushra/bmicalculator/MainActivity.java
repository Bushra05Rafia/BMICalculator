package com.example.bushra.bmicalculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;
import android.view.View;

public class MainActivity extends AppCompatActivity {
    private EditText weight;
    private EditText height;
    private TextView result;
    private TextView comment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        height = (EditText) findViewById(R.id.height);
        weight = (EditText) findViewById(R.id.weight);
        result = (TextView) findViewById(R.id.result);
        comment = (TextView) findViewById(R.id.comment);
    }

    public void calculateBMI(View v) {
        String heightStr = height.getText().toString();
        String weightStr = weight.getText().toString();
        float heightValue = Float.parseFloat(heightStr)*3;
        float weightValue = Float.parseFloat(weightStr);
        float bmi= (weightValue / (heightValue * heightValue))*100;
        if (heightStr != null && !"".equals(heightStr) && weightStr != null && !"".equals(weightStr))
        {
            String bmidisplay=display(bmi);
            result.setText(bmi+"\n\n"+bmidisplay);
        }
    }

    private String display(float bmi)
    {
        if(bmi <16)
        {
            return "Severely Under Weighted";
        }
        else if(bmi<18.5)
        {
            return "UnderWeighted.You are too thin! You need to gain and develop muscle to be considered normal.";
        }
        else if(bmi<25)
        {
            return "Normal.You are within normal bounds!Stay that way.";
        }
        else if(bmi<30)
        {
            return "OverWeighted.You need to lose weight to avoid any further health issues!";
        }
        else
            return "Observe";
    }
}
