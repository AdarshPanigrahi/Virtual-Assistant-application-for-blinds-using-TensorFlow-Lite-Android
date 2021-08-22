package org.tensorflow.lite.examples.detection;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class NavigatePage extends AppCompatActivity{

    public SensorManager sensorManager;
    public Sensor Acc;
    public SmsManager smsManager;

    Button btn;
    String phoneNo = "108";
    String message = "Help me!";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_navigate_page);

        btn=findViewById(R.id.btn1);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                smsManager = SmsManager.getDefault();
                sensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);
                Acc = sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
                sensorManager.registerListener(acc, Acc, sensorManager.SENSOR_DELAY_NORMAL);
            }
        });

    }


    SensorEventListener acc= new SensorEventListener() {
        @Override
        public void onSensorChanged(SensorEvent sensorEvent) {
            if (sensorEvent.sensor.getType() == Sensor.TYPE_ACCELEROMETER) {
                if (sensorEvent.values[0] >= 10.0) {
                    if (phoneNo.length()>0 && message.length()>0)
                    {
                        if(ContextCompat.checkSelfPermission(NavigatePage.this, Manifest.permission.SEND_SMS)
                        == PackageManager.PERMISSION_GRANTED)
                        {
                            sendMessage();
                        }
                        else
                        {
                            ActivityCompat.requestPermissions(NavigatePage.this,new String[] {
                                    Manifest.permission.SEND_SMS
                            },100);
                        }
                    }

                }

                if (sensorEvent.values[1] >= 15.0) {
                    if (phoneNo.length()>0 && message.length()>0)
                    {

                    }

                }
            }
        }
        @Override
        public void onAccuracyChanged(Sensor sensor, int i) {

        }
    };

    private void sendMessage()
    {
        SmsManager smsManager= SmsManager.getDefault();
        smsManager.sendTextMessage(phoneNo,null,message,null,null);
        Toast.makeText(getApplicationContext(),"SMS Sent", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);

        if(requestCode == 100 && grantResults.length > 0 && grantResults[0]==PackageManager.PERMISSION_GRANTED){
            sendMessage();
        }
        else
        {
           ;
        }
    }
}