package com.sundae.FrontAndBackAnimator;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private View frontView, backView;
    private FrontAndBackView faceAndBackView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        frontView = findViewById(R.id.front_view);
        backView = findViewById(R.id.back_view);

        faceAndBackView = new FrontAndBackView(getApplicationContext() , frontView, backView);
        //faceAndBackView.setDuration(1000);
        backView.setOnClickListener(this);
        frontView.setOnClickListener(this);

        faceAndBackView.setFrontAndBackViewListener(new FrontAndBackView.FrontAndBackViewListener() {
            @Override
            public void animationEnd() {
                Log.e("TAG" , "END");
            }
        });

    }

    @Override
    public void onClick(View v) {
        if(v.getId() == R.id.front_view || v.getId() == R.id.back_view)
            faceAndBackView.toggle();
    }
}
