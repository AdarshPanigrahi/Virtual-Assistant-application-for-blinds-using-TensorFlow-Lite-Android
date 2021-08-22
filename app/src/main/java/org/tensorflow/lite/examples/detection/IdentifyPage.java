package org.tensorflow.lite.examples.detection;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class IdentifyPage extends AppCompatActivity {

    Button startbutton2;
    ImageView imageView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_identify_page);

        startbutton2=findViewById(R.id.buttonstart2);
        imageView=findViewById(R.id.iv1);

        startbutton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(IdentifyPage.this, CameraActivity.class);
                startActivity(i);
            }
        });
    }

}