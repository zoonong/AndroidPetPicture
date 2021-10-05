package com.example.petpicture;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    TextView text1, text2;
    CheckBox chkBox;
    RadioGroup rGroup;
    RadioButton rDog, rCat, rRabbit;
    Button btnOk;
    ImageView petPic;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setIcon(R.drawable.pet_house);

        text1 = (TextView) findViewById(R.id.txt1);
        chkBox = (CheckBox) findViewById(R.id.chk);
        text2 = (TextView) findViewById(R.id.txt2);
        rGroup = (RadioGroup) findViewById(R.id.rgroup);
        rDog = (RadioButton) findViewById(R.id.dog);
        rCat = (RadioButton) findViewById(R.id.cat);
        rRabbit = (RadioButton) findViewById(R.id.rabbit);

        btnOk = (Button) findViewById(R.id.btn);
        petPic = (ImageView) findViewById(R.id.pic);

        chkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {

            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (chkBox.isChecked() == true){
                    text2.setVisibility(View.VISIBLE);
                    rGroup.setVisibility(View.VISIBLE);
                    btnOk.setVisibility(View.VISIBLE);
                    petPic.setVisibility(View.VISIBLE);
                } else {
                    text2.setVisibility(View.INVISIBLE);
                    rGroup.setVisibility(View.INVISIBLE);
                    btnOk.setVisibility(View.INVISIBLE);
                    petPic.setVisibility(View.INVISIBLE);
                }

            }
        });

        btnOk.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                switch (rGroup.getCheckedRadioButtonId()){
                    case R.id.dog:
                        petPic.setImageResource(R.drawable.dog);
                        break;
                    case R.id.cat:
                        petPic.setImageResource(R.drawable.cat);
                        break;
                    case R.id.rabbit:
                        petPic.setImageResource(R.drawable.rabbit);
                        break;
                    default:
                        Toast.makeText(getApplicationContext(), "동물을 선택해 주세요.", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}