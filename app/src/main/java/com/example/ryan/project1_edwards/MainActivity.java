package com.example.ryan.project1_edwards;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;
import java.util.RandomAccess;

public class MainActivity extends AppCompatActivity implements Animation.AnimationListener {


    private Animation animRotate1;
    private ImageView leftFlower;
    private ImageView centerFlower;
    private ImageView rightFlower;
    private TextView counter;
    private int number = 5;
    private Button reset;
    private Button go;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //hold on t
        leftFlower = (ImageView)findViewById(R.id.LeftFlw);
        centerFlower = (ImageView)findViewById(R.id.MiddleFlw);
        rightFlower = (ImageView)findViewById(R.id.RightFlw);

        // load the animation
        animRotate1 = AnimationUtils.loadAnimation(getApplicationContext(),
                R.anim.rotate);
        //set listener (VERY IMPORTANT, YOU FORGET nothing works!)
        animRotate1.setAnimationListener(this);

        counter = (TextView)findViewById(R.id.count);


        counter.setText(Integer.toString(number));

        reset = (Button)findViewById(R.id.reset);
        go = (Button)findViewById(R.id.go_button);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onAnimationStart(Animation animation) {
        leftFlower.setImageResource(R.drawable.tmp);

        rightFlower.setImageResource(R.drawable.tmp);

        centerFlower.setImageResource(R.drawable.tmp);
    }

    @Override
    public void onAnimationEnd(Animation animation) {
        setRandomImage();
        reset.setVisibility(View.VISIBLE);
    }

    @Override
    public void onAnimationRepeat(Animation animation) {

    }

    public void doClick(View view) {

        counter.setText(Integer.toString(number));

        leftFlower.startAnimation(animRotate1);
        rightFlower.startAnimation(animRotate1);
        centerFlower.startAnimation(animRotate1);


    }


    private void setRandomImage() {

        Random r = new Random();

        int leftRand = r.nextInt(3);
        int rightRand = r.nextInt(3);
        int centerRand = r.nextInt(3);

        if(leftRand == 0){
            leftFlower.setImageResource(R.drawable.f1);
        }else if(leftRand == 1){
            leftFlower.setImageResource(R.drawable.f2);
        }else if(leftRand == 2){
            leftFlower.setImageResource(R.drawable.f3);
        }
        if(centerRand == 0){
            centerFlower.setImageResource(R.drawable.f1);
        }else if(centerRand == 1){
            centerFlower.setImageResource(R.drawable.f2);
        }else if(centerRand == 2){
            centerFlower.setImageResource(R.drawable.f3);
        }
        if(rightRand == 0){
            rightFlower.setImageResource(R.drawable.f1);
        }else if(rightRand == 1){
            rightFlower.setImageResource(R.drawable.f2);
        }else if(rightRand == 2){
            rightFlower.setImageResource(R.drawable.f3);
        }


        setCounter(leftRand, centerRand, rightRand);



    }

    public void setCounter(int left, int center, int right){
        if(left == center && left == right && center == right){

            number += 2;

            counter.setText(Integer.toString(number));

        }else if(left == center || right == center|| left == right){
            number += 1;

            counter.setText(Integer.toString(number));
        }else{
            number -= 1;

            counter.setText(Integer.toString(number));
        }

        if(number == 0){
            go.setVisibility(View.GONE);
        }

    }

    public void reset(View view) {
        number = 5;
        counter.setText(Integer.toString(number));
        reset.setVisibility(View.GONE);
        go.setVisibility(View.VISIBLE);

    }
}

