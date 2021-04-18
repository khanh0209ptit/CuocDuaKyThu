package com.example.cucuathk;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    CheckBox checkBox1, checkBox2, checkBox3;
    SeekBar seekBar1, seekBar2, seekBar3;
    ImageView imageView;
    TextView textView;
    ImageButton imageButton;
    int soDiem = 100;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Anhxa();

        textView.setText(soDiem + "");

//        checkBox1.setEnabled(false);
//        checkBox2.setEnabled(false);
//        checkBox3.setEnabled(false);

        CountDownTimer countDownTimer = new CountDownTimer(60000,300) {
            @Override
            public void onTick(long millisUntilFinished) {
                int number = 5;
                Random random =  new Random();

                int one = random.nextInt(number);
                int two = random.nextInt(number);
                int three = random.nextInt(number);

                seekBar1.setProgress(seekBar1.getProgress() + one);
                seekBar2.setProgress(seekBar2.getProgress() + two);
                seekBar3.setProgress(seekBar3.getProgress() + three);

                //kiem tra Win
                if (seekBar1.getProgress() >= seekBar1.getMax()){
                    this.cancel();
                    //hien thi lai imagebutton
                    imageButton.setVisibility(View.VISIBLE);
                    Toast.makeText(MainActivity.this, "One WIN", Toast.LENGTH_SHORT).show();

                    //kiem tra dat cuoc
                    if (checkBox1.isChecked()){
                        soDiem += 10;
                        Toast.makeText(MainActivity.this, "Có thưởng", Toast.LENGTH_SHORT).show();
                    }else {
                        soDiem -=5;
                        Toast.makeText(MainActivity.this, "Còn thở là còn gỡ", Toast.LENGTH_SHORT).show();
                    }
                    textView.setText(soDiem + "");
                    EnableCheckBox();
                }

                if (seekBar2.getProgress() >= seekBar2.getMax()){
                    this.cancel();
                    imageButton.setVisibility(View.VISIBLE);
                    Toast.makeText(MainActivity.this, "Two WIN", Toast.LENGTH_SHORT).show();

//                    if (checkBox2.isChecked()){
//                        soDiem += 10;
//                        Toast.makeText(MainActivity.this, "Có thưởng", Toast.LENGTH_SHORT).show();
//                    }else {
//                        soDiem -=5;
//                        Toast.makeText(MainActivity.this, "Còn thở là còn gỡ", Toast.LENGTH_SHORT).show();
//                    }
                    textView.setText(soDiem + "");
                    EnableCheckBox();
                }

                if (seekBar3.getProgress() >= seekBar3.getMax()){
                    this.cancel();
                    imageButton.setVisibility(View.VISIBLE);
                    Toast.makeText(MainActivity.this, "Three WIN", Toast.LENGTH_SHORT).show();

//                    if (checkBox3.isChecked()){
//                        soDiem += 10;
//                        Toast.makeText(MainActivity.this, "Có thưởng", Toast.LENGTH_SHORT).show();
//                    }else {
//                        soDiem -=5;
//                        Toast.makeText(MainActivity.this, "Còn thở là còn gỡ", Toast.LENGTH_SHORT).show();
//                    }
                    textView.setText(soDiem + "");
                    EnableCheckBox();
                }
            }

            @Override
            public void onFinish() {

            }
        };
        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (checkBox1.isChecked() || checkBox2.isChecked() || checkBox3.isChecked()) {
                    //set lai ve 0 khi chay xong
                    seekBar1.setProgress(2);
                    seekBar2.setProgress(2);
                    seekBar3.setProgress(2);

                    //an view
                    imageButton.setVisibility(View.INVISIBLE);
                    //run
                    countDownTimer.start();

                    DisableCheckBox();
                }else {
                    Toast.makeText(MainActivity.this, "Người không chơi là người thắng", Toast.LENGTH_SHORT).show();
                }
            }
        });
        //chi duoc check 1 trong 3 cai
        checkBox1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                // neu 1 ve thi bo check 2,3
                if (isChecked){
                    checkBox2.setChecked(false);
                    checkBox3.setChecked(false);
                }
            }
        });
        checkBox2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked2) {
                // neu ve 2 bo 1 va 3
                if (isChecked2){
                    checkBox1.setChecked(false);
                    checkBox3.setChecked(false);
                }
            }
        });
        checkBox3.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked3) {
                // ve 3 bo 1 va 2
                if (isChecked3){
                    checkBox1.setChecked(false);
                    checkBox2.setChecked(false);
                }
            }
        });
//        checkBox1.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                checkBox1.setChecked(checkBox1.isChecked());
//                checkBox2.setChecked(false);
//                checkBox3.setChecked(false);
//            }
//        });
//        checkBox2.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                checkBox1.setChecked(false);
//                checkBox2.setChecked(checkBox2.isChecked());
//                checkBox3.setChecked(false);
//            }
//        });
//        checkBox3.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                checkBox1.setChecked(false);
//                checkBox2.setChecked(false);
//                checkBox3.setChecked(checkBox3.isChecked());
//            }
//        });
    }
    //cho tuong tac voi checkbox
    private void EnableCheckBox(){
        checkBox1.setEnabled(true);
        checkBox2.setEnabled(true);
        checkBox3.setEnabled(true);
    }
    // khong cho tuong tac voi checkBox
    private void DisableCheckBox(){
        checkBox1.setEnabled(false);
        checkBox2.setEnabled(false);
        checkBox3.setEnabled(false);
    }
    private void Anhxa(){
        checkBox1 = findViewById(R.id.checkbox1);
        checkBox2 = findViewById(R.id.checkbox2);
        checkBox3 = findViewById(R.id.checkbox3);
        seekBar1 = findViewById(R.id.seekbar1);
        seekBar2 = findViewById(R.id.seekbar2);
        seekBar3 = findViewById(R.id.seekbar3);
        imageView = findViewById(R.id.imageview);
        textView = findViewById(R.id.textview);
        imageButton = findViewById(R.id.imagebutton);
    }
}