package com.example.prashant.samplecloud;

import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button b1=(Button)findViewById(R.id.button);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                EditText t1=(EditText)findViewById(R.id.editText);
                EditText t2=(EditText)findViewById(R.id.editText2);
                EditText t3=(EditText)findViewById(R.id.editText3);
                EditText t4=(EditText)findViewById(R.id.editText4);

                String uname=t1.getText().toString();
                String pwd=t2.getText().toString();
                String email=t3.getText().toString();
                String contact=t4.getText().toString();


                Toast.makeText(getApplicationContext(), uname + "" + pwd + "" + email + "" + contact, Toast.LENGTH_LONG).show();



                StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
                StrictMode.setThreadPolicy(policy);

                String username = "be5aa74cc2bf45";
                String password = "50e1eb6d";
                String url = "jdbc:mysql://us-cdbr-iron-east-04.cleardb.net:3306/ad_e61f87f5d90e741";
                String driver = "com.mysql.jdbc.Driver";
                Connection con = null;
                PreparedStatement ps = null;
                ResultSet rs = null;


                try {
                    Toast.makeText(MainActivity.this, "000000000000000", Toast.LENGTH_SHORT).show();
                    Class.forName(driver);
                    //  Toast.makeText(MainActivity.this, "1212121212122", Toast.LENGTH_SHORT).show();
                    con = DriverManager.getConnection(url, username, password);
                    Toast.makeText(MainActivity.this, "0101010101010", Toast.LENGTH_SHORT).show();
                    System.out.println("Successfully Connected with db");
                    String sql = "insert into regitser(uname,pwd,email,dob)values(?,?,?,?)";
                    ps = con.prepareStatement(sql);
                    ps.setString(1, uname);
                    ps.setString(2, pwd);
                    ps.setString(3,email);
                    ps.setString(4, contact);

                    int i = ps.executeUpdate();
                    Toast.makeText(MainActivity.this, "1111111111", Toast.LENGTH_SHORT).show();
                    if (i > 0) {

                        Toast.makeText(MainActivity.this, "DONE DONE DONE", Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(MainActivity.this, "NO NO NO", Toast.LENGTH_SHORT).show();
                    }

                    Toast.makeText(MainActivity.this, "NO NO NO", Toast.LENGTH_SHORT).show();
                } catch (Exception e) {
                    Toast.makeText(MainActivity.this, "EXCEPTION", Toast.LENGTH_SHORT).show();
                    e.printStackTrace();
                    Toast.makeText(MainActivity.this, e.toString(), Toast.LENGTH_SHORT).show();
                }






            }
        });





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
}
