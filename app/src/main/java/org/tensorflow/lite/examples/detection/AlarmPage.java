package org.tensorflow.lite.examples.detection;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class AlarmPage extends AppCompatActivity {

    Button startbutton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alarm_page);

        startbutton=findViewById(R.id.buttonstart);
    }

    public void OpenMap(View view) {
    }

    public void PlayMusic(View view) {
    }

    public void Journey(View view) {
        Intent i = new Intent(AlarmPage.this, CameraActivity.class);
        startActivity(i);
    }
}