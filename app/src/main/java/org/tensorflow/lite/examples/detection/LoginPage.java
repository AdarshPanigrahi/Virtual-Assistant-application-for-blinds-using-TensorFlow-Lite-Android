package org.tensorflow.lite.examples.detection;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginPage extends AppCompatActivity {

    EditText useridL,userpasswordL;
    Button userlogin;
    String name="Adarsh";
    String password="Adarsh123";
    public final static String EXTRA_MESSAGE="" ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_page);

        useridL=findViewById(R.id.useridL);
        userpasswordL=findViewById(R.id.userpasswordL);
        userlogin=findViewById(R.id.userlogin);
    }

    public void UserLoggedIn(View view) {

        final String sname2 = useridL.getText().toString().trim(), spwd2 = userpasswordL.getText().toString().trim();
        Intent intent = new Intent(LoginPage.this, DashboardPage.class);
        intent.putExtra(EXTRA_MESSAGE, sname2);
        startActivity(intent);
        Toast.makeText(LoginPage.this, "Login Successful", Toast.LENGTH_LONG).show();
//        if (!sname2.isEmpty()) {
//            if (!spwd2.isEmpty()) {
//                if(sname2.equals(name) && spwd2.equals(password)){
//
//                }
//                else {
//                    Toast.makeText(LoginPage.this, "Wrong Username or Password", Toast.LENGTH_LONG).show();
//                }
//            } else
//                Toast.makeText(LoginPage.this, "Password required", Toast.LENGTH_LONG).show();
//        } else
//            Toast.makeText(LoginPage.this, "Username required", Toast.LENGTH_LONG).show();

    }
}