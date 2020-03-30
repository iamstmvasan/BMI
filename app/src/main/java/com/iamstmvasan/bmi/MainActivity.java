package com.iamstmvasan.bmi;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    ImageView img_male , img_female , img_gender ,img_bmi;
    TextView txt_male , txt_female ,txt_gender , bmi_val , bmi_res  , height_val , weight_val;
    Button height_add , height_sub , weight_add , weight_sub , bmi_calc ;

    SeekBar height_bar , weight_bar;

    float usr_weight , usr_height , val ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txt_male = findViewById(R.id.textView);
        txt_female = findViewById(R.id.textView2);
        txt_gender = findViewById(R.id.textView3);

        height_bar = findViewById(R.id.seekBar_h);
        weight_bar = findViewById(R.id.seekBar_w);

        height_val = findViewById(R.id.hight);
        weight_val = findViewById(R.id.weight);

        height_add = findViewById(R.id.add_h);
        height_sub = findViewById(R.id.sub_h);
        weight_add = findViewById(R.id.add_w);
        weight_sub = findViewById(R.id.sub_w);
        bmi_calc = findViewById(R.id.bmi_calc);

        bmi_val = findViewById(R.id.bmi_value);
        bmi_res = findViewById(R.id.bmi_result);


        img_male = findViewById(R.id.imageView);
        img_female = findViewById(R.id.imageView2);
        img_gender = findViewById(R.id.imageView3);
        img_bmi = findViewById(R.id.bmi_img);

        img_male.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                img_male.setVisibility(View.INVISIBLE);
                img_female.setVisibility(View.INVISIBLE);
                img_gender.setVisibility(View.VISIBLE);

                txt_male.setVisibility(View.INVISIBLE);
                txt_female.setVisibility(View.INVISIBLE);
                txt_gender.setVisibility(View.VISIBLE);

                img_gender.setImageResource(R.drawable.m_user);
                txt_gender.setText("MALE");
            }
        });

        img_female.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                img_male.setVisibility(View.INVISIBLE);
                img_female.setVisibility(View.INVISIBLE);
                img_gender.setVisibility(View.VISIBLE);

                txt_male.setVisibility(View.INVISIBLE);
                txt_female.setVisibility(View.INVISIBLE);
                txt_gender.setVisibility(View.VISIBLE);

                img_gender.setImageResource(R.drawable.f_user);
                txt_gender.setText("FEMALE");
            }
        });

        img_gender.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                img_gender.setVisibility(View.INVISIBLE);
                img_male.setVisibility(View.VISIBLE);
                img_female.setVisibility(View.VISIBLE);

                txt_male.setVisibility(View.VISIBLE);
                txt_female.setVisibility(View.VISIBLE);
                txt_gender.setVisibility(View.INVISIBLE);
            }
        });

        //set max value to height seekbar by default minimum is 0
        height_bar.setMax(400);
        //to get value from height seekbar
        height_bar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                usr_height = height_bar.getProgress();
                height_val.setText(String.valueOf(usr_height));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        //set max value to weight seekbar by default minimum is 0
        weight_bar.setMax(200);
        //to get value from weight seekbar
        weight_bar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                usr_weight = weight_bar.getProgress();
                weight_val.setText(String.valueOf(usr_weight));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        //if you could not fix correct height value in seekbar use this (+ and -) button to increment and decrement weight value
        height_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                usr_height++;
                height_val.setText(String.valueOf(usr_height));
                height_bar.setProgress((int)usr_height);
            }
        });

        height_sub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                usr_height--;
                height_val.setText(String.valueOf(usr_height));
                height_bar.setProgress((int)usr_height);
            }
        });

        //if you could not fix correct weight value in seekbar use this (+ and -) button to increment and decrement weight value
        weight_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                usr_weight++;
                weight_val.setText(String.valueOf(usr_weight));
                weight_bar.setProgress((int)usr_weight);
            }
        });

        weight_sub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                usr_weight--;
                weight_val.setText(String.valueOf(usr_weight));
                weight_bar.setProgress((int)usr_weight);
            }
        });

        bmi_calc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (txt_gender.getText().toString().length() > 0) {
                    usr_height = height_bar.getProgress();
                    usr_weight = weight_bar.getProgress();

                    bmi_val.setVisibility(View.VISIBLE);
                    img_bmi.setVisibility(View.VISIBLE);
                    bmi_res.setVisibility(View.VISIBLE);


                    usr_height /= 100;  //to conert centimeter to meter
                    usr_height = usr_height * usr_height;   //to convert meter square
                    val = usr_weight / usr_height;  //to find bmi value

                    String value = String.format("%.2f", val);     //number formatting
                    bmi_val.setText(value);

                    //to find our bmi result based on bmi value
                    if (val < 18.5) {
                        bmi_res.setText("UNDERWEIGHT ~ EAT MORE");
                        img_bmi.setImageResource(R.drawable.u_wt);
                    }
                    else if (val < 24.9) {
                        bmi_res.setText("HEALTHY ~ ENJOY");
                        img_bmi.setImageResource(R.drawable.health);
                    }
                    else if (val < 29.9) {
                        bmi_res.setText("OVERWEIGHT ~ DO EXERCISE");
                        img_bmi.setImageResource(R.drawable.ovr_wt);
                    }
                    else if (val >= 30) {
                        bmi_res.setText("OBESE ~ Consult a Doctor");
                        img_bmi.setImageResource(R.drawable.obese);
                    }
                }
                else{
                    Toast.makeText(MainActivity.this, "Select Gender", Toast.LENGTH_SHORT).show();
                }
            }

        });
    }

}
