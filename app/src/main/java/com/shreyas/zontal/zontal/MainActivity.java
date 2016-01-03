package com.shreyas.zontal.zontal;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.parse.LogInCallback;
import com.parse.ParseException;
import com.parse.ParseUser;


public class MainActivity extends ActionBarActivity {


    private EditText username,password;
    private Button login, goToRegister;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        username = (EditText)findViewById(R.id.login_username);
        password = (EditText)findViewById(R.id.login_password);

        login = (Button)findViewById(R.id.login_btn);
        goToRegister = (Button)findViewById(R.id.go_to_register_btn);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String usernameText = username.getText().toString();
                String passwordText = password.getText().toString();

                ParseUser.logInInBackground(usernameText, passwordText, new LogInCallback() {
                    @Override
                    public void done(ParseUser user, ParseException e) {

                        if(e == null){
                            //TODO: Transition to chat list
                        }
                        else{
                            Zontal.showToast(e.getMessage());
                        }

                    }
                });

            }
        });
        
        goToRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i = new Intent(MainActivity.this,RegisterActivity.class);

                startActivity(i);

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
