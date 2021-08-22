package org.tensorflow.lite.examples.detection;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class DashboardPage extends AppCompatActivity {

    public static String message;
    public final static String EXTRA_MESSAGE1="" ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard_page);

        Intent intent = getIntent();
        message = intent.getStringExtra(LoginPage.EXTRA_MESSAGE);
    }

    public void Navigate(View view) {
        Intent intent1 = new Intent(DashboardPage.this,NavigatePage.class);
        intent1.putExtra(EXTRA_MESSAGE1, message);
        startActivity(intent1);
    }

    public void Identify(View view) {
        Intent intent1 = new Intent(DashboardPage.this,IdentifyPage.class);
        startActivity(intent1);

    }

    public void Alarm(View view) {
        Intent intent1 = new Intent(DashboardPage.this,AlarmPage.class);
        intent1.putExtra(EXTRA_MESSAGE1, message);
        startActivity(intent1);
    }

    public void Emergency(View view) {
        Intent intent1 = new Intent(DashboardPage.this,EmergencyPage.class);
        startActivity(intent1);
    }

    public void LogoutUser(View view) {
        Intent intent1 = new Intent(DashboardPage.this,LoginPage.class);
        startActivity(intent1);
    }
}