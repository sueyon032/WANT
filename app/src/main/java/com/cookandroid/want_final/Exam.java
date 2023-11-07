package com.cookandroid.want_final;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Exam extends AppCompatActivity {

    String [][] questionList = {
            {"내가 선호하는 환경은?",
                    "내가 좋아하는 여행지 날씨는?",
                    "여행 중 내가 더 하고 싶은 것은?",
                    "내가 추구하는 여행 중 식사는?",
                    "여행지의 한국인 수는?",
                    "나에게 맞는 물가는?",
                    "더 끌리는 여행 계획은?",
                    "더 좋아하는 여행 형식은?",
                    "좋아하는 여행 스타일은?",
                    "더 좋아하는 숙박 시설은?"
            },
            {"푸른 바다", "오들오들 겨울", "그 나라의 유명 관광지 탐방", "현지인 동기화 현지음식", "한국인 찾는게 하늘의 별따기인 곳",
                    " 학생들도 갈 수 있도록한 물가가 저렴한 곳", "나는 계획 없이 못살아! 철저한 계획",
                    "가이드로부터 자세한 설명을 들을 수 있는 패키지 여행", "나만의 행복을 느낄 수 있는 혼자여행", "  비싸지만 모든 것이 갖춰져 있는 좋은 호텔"},

            {"나무가 많은 산", "햇빛 쨍쨍 여름", "풍경을 보면서 편하게 쉬는 휴양", "한식 포기못해 한국음식", "여기저기서 한국어가 들리는 유명 장소",
                    "오늘은 플랙스다! 물가가 높은 곳", " 나는 계획따위 없어! 즉흥적 여행", "프리한 여행을 할 수 있는 자유여행",
                    "다른 친구들과 시끌벅적 얘기할 수 있는 단체여행", " 싸다! 잠만 잘 수 있는 곳"}
    };

    int [][] resultList = {
            {1, 0, 0, 0, 0, 1, 0, 0, 1, 0},
            {0, 1, 0, 0, 1, 0, 0, 0, 1, 1},
            {0, 1, 1, 0, 1, 0, 1, 1, 0, 1},
            {1, 1, 0, 1, 0, 1, 0, 0, 0, 0},
            {0, 1, 1, 1, 0, 1, 0, 1, 0, 0},
            {0, 1, 0, 0, 1, 1, 0, 1, 0, 1},
            {1, 1, 0, 1, 0, 0, 0, 0, 1, 1},
            {0, 1, 1, 1, 0, 0, 1, 1, 0, 0},
            {1, 1, 0, 1, 0, 1, 0, 1, 0, 0},
            {1, 0, 0, 1, 0, 1, 0, 1, 0, 0}
    };

    Button btn1, btn2;
    TextView answerNum;
    TextView question;
    int[] count = {1}; // 배열로 감싸서 변경 가능하도록 만듦
    int[] answerNo = {2};
    int[] resultArr = new int[questionList[0].length];
    int[] resultCount={0};
    int[] finalResult = {-1}; // 클래스의 멤버 변수로 이동하고 초기값을 -1로 설정

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exam);
        btn1 = findViewById(R.id.btn1);
        btn2 = findViewById(R.id.btn2);
        answerNum = findViewById(R.id.answerNum);
        question = findViewById(R.id.question);

        answerNum.setText("01");
        question.setText(questionList[0][0]);
        btn1.setText(questionList[1][0]);
        btn2.setText(questionList[2][0]);

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                resultArr[count[0]-1] = 0;
                if(answerNo[0] == 10){
                    answerNum.setText(Integer.toString(answerNo[0]++));
                }
                else if(answerNo[0]>10) {
                    finalResult[0] = getFinalResult(resultArr); // 결과를 계산하여 finalResult에 저장
                    Intent in = new Intent(Exam.this, Result.class);
                    in.putExtra("finalResultValue", finalResult[0]);
                    startActivity(in);
                }
                else{
                    answerNum.setText("0" + Integer.toString(answerNo[0]++));
                }
                question.setText(questionList[0][count[0]]);
                btn1.setText(questionList[1][count[0]]);
                btn2.setText(questionList[2][count[0]]);
                count[0]++;
            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                resultArr[count[0]-1] = 1;
                if(answerNo[0] == 10){
                    answerNum.setText(Integer.toString(answerNo[0]++));
                }
                else if(answerNo[0]>10) {
                    finalResult[0] = getFinalResult(resultArr); // 결과를 계산하여 finalResult에 저장
                    Intent in = new Intent(Exam.this, Result.class);
                    in.putExtra("finalResultValue", finalResult[0]);
                    startActivity(in);
                }
                else{
                    answerNum.setText("0" + Integer.toString(answerNo[0]++));
                }
                question.setText(questionList[0][count[0]]);
                btn1.setText(questionList[1][count[0]]);
                btn2.setText(questionList[2][count[0]]);
                count[0]++;
            }
        });

    }

    private int getFinalResult(int[] resultArr) {
        int resultCount = 0; // 결과를 저장하는 변수

        for(int i=0; i<10; i++) {
            for(int j=0; j<10; j++) {
                if(resultArr[j] == resultList[i][j]) resultCount++;
                if(resultCount == 10) return i;
            }
            resultCount = 0; // 다음 결과를 계산하기 전에 초기화
        }

        return -1; // 유효한 결과가 없을 경우 -1 반환
    }
}
