package com.mariammuhammad.myapplication;

import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class MainActivity extends AppCompatActivity {
    private ImageView imageView;
    private FloatingActionButton button,msgButton,copyButton;
    private boolean isShared = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        imageView = findViewById(R.id.imageView);
        button = findViewById(R.id.fabSharebutton);
        msgButton=findViewById(R.id.fabMessage);
        copyButton=findViewById(R.id.fabCopy);



        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Animation fadeOut = AnimationUtils.loadAnimation(MainActivity.this, R.anim.animation);
                Animation rotate=AnimationUtils.loadAnimation(MainActivity.this,R.anim.rotate);
                button.startAnimation(rotate);
                imageView.startAnimation(fadeOut);
                if (!isShared) {
                    button.setImageDrawable(getResources().getDrawable(android.R.drawable.ic_delete));
                    isShared = true;

                    msgButton.show();
                    copyButton.show();
                } else {
                    button.setImageDrawable(getResources().getDrawable(android.R.drawable.ic_menu_share));
                    isShared = false;

                    msgButton.hide();
                    copyButton.hide();
                }

            }
        });

}

}