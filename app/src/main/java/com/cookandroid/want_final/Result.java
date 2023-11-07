package com.cookandroid.want_final;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;

public class Result extends AppCompatActivity {
    ImageView countryImg;
    TextView countryName;

    String[] nameArr = {"러시아", "태국", "캄보디아", "이탈리아", "덴마크", "일본", "이집트", "볼리비아", "영국", "프랑스"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        countryImg = findViewById(R.id.countryImg);
        countryName = findViewById(R.id.countryName);

        int finalResultValue = getIntent().getIntExtra("finalResultValue", 5000);

//        if(finalResultValue >= 0) {
//            int imageResource = getResources().getIdentifier("result_" + finalResultValue, "drawable", getPackageName());
//            countryImg.setImageResource(imageResource);
//        }
//        else {
//            countryImg.setImageResource(getResources().getIdentifier("home","drawable", getPackageName()));
//        }

        int imageResource = getResources().getIdentifier("result_" + finalResultValue, "drawable", getPackageName());
        countryImg.setImageResource(imageResource);


        switch (finalResultValue){
            case 0: countryName.setText(nameArr[0]); break;
            case 1: countryName.setText(nameArr[1]); break;
            case 2: countryName.setText(nameArr[2]); break;
            case 3: countryName.setText(nameArr[3]); break;
            case 4: countryName.setText(nameArr[4]); break;
            case 5: countryName.setText(nameArr[5]); break;
            case 6: countryName.setText(nameArr[6]); break;
            case 7: countryName.setText(nameArr[7]); break;
            case 8: countryName.setText(nameArr[8]); break;
            case 9: countryName.setText(nameArr[9]); break;
            default:
                countryName.setText("집입니다!!");
                int defaultImageResource = getResources().getIdentifier("home", "drawable", getPackageName());
                countryImg.setImageResource(defaultImageResource);
        };

    }
}