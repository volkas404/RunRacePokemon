package com.nam.uapokemon;

import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageButton;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    CheckBox cb1, cb2, cb3;
    SeekBar sb1, sb2, sb3;
    ImageButton btn;
    TextView diem;
    int SoDiem = 1000;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        anhxa();

        sb1.setEnabled(false);
        sb2.setEnabled(false);
        sb3.setEnabled(false);

        diem.setText(SoDiem + "");

        CountDownTimer cdtm = new CountDownTimer(60000,100) {
            @Override
            public void onTick(long l) {
                int n = 2;
                Random rd = new Random();
                int rd1 = rd.nextInt(n);
                int rd2 = rd.nextInt(n);
                int rd3 = rd.nextInt(n);
                if(sb1.getProgress() >= sb1.getMax()){
                    this.cancel();
                    btn.setVisibility(View.VISIBLE);
                    Toast.makeText(MainActivity.this,"Squirtle Win", Toast.LENGTH_SHORT).show();
                    if(cb1.isChecked()){
                        SoDiem += 50;
                    }else{
                        SoDiem -= 50;
                    }
                    diem.setText(SoDiem + "");
                    batcheck();
                }
                if(sb2.getProgress() >= sb2.getMax()){
                    this.cancel();
                    btn.setVisibility(View.VISIBLE);
                    Toast.makeText(MainActivity.this,"Chamander Win", Toast.LENGTH_SHORT).show();
                    if(cb2.isChecked()){
                        SoDiem += 50;
                    }else{
                        SoDiem -= 50;
                    }
                    diem.setText(SoDiem + "");
                    batcheck();
                }
                if(sb3.getProgress() >= sb3.getMax()){
                    this.cancel();
                    btn.setVisibility(View.VISIBLE);
                    Toast.makeText(MainActivity.this,"Bulbasour Win", Toast.LENGTH_SHORT).show();
                    if(cb3.isChecked()){
                        SoDiem += 50;
                    }else{
                        SoDiem -= 50;
                    }
                    diem.setText(SoDiem + "");
                    batcheck();
                }
                sb1.setProgress(sb1.getProgress()+rd1);
                sb2.setProgress(sb2.getProgress()+rd2);
                sb3.setProgress(sb3.getProgress()+rd3);
            }

            @Override
            public void onFinish() {

            }
        };
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(cb1.isChecked() || cb2.isChecked() || cb3.isChecked()){
                    sb1.setProgress(0);
                    sb2.setProgress(0);
                    sb3.setProgress(0);
                    btn.setVisibility(view.INVISIBLE);
                    cdtm.start();
                    tatcheck();
                }else{
                    Toast.makeText(MainActivity.this,"Đặt cược đã :))))",Toast.LENGTH_SHORT).show();
                }

            }
        });
        cb1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cb1.setChecked(true);
                cb2.setChecked(false);
                cb3.setChecked(false);
            }
        });
        cb2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cb1.setChecked(false);
                cb2.setChecked(true);
                cb3.setChecked(false);
            }
        });
        cb3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cb1.setChecked(false);
                cb2.setChecked(false);
                cb3.setChecked(true);
            }
        });
    }
    private void tatcheck(){
        cb1.setEnabled(false);
        cb2.setEnabled(false);
        cb3.setEnabled(false);
    }
    private void batcheck(){
        cb1.setEnabled(true);
        cb2.setEnabled(true);
        cb3.setEnabled(true);
    }
    private void anhxa(){
        btn = (ImageButton)  findViewById(R.id.imgbtn);
        diem = (TextView) findViewById(R.id.txt);
        cb1 = (CheckBox)  findViewById(R.id.cb1);
        cb2 = (CheckBox)  findViewById(R.id.cb2);
        cb3 = (CheckBox)  findViewById(R.id.cb3);
        sb1 = (SeekBar)  findViewById(R.id.sb1);
        sb2 = (SeekBar)  findViewById(R.id.sb2);
        sb3 = (SeekBar)  findViewById(R.id.sb3);
    }
}