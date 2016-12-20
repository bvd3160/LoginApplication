package loginapp.pro_jeanyves.com.loginapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.TextView;

public class MainScreenActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_screen);

        //initializing views
        final TextView greeting = (TextView) findViewById(R.id.tvGreeting);
        final TextView currentTime = (TextView) findViewById(R.id.tvCurrentTime);
        final TextView yourUsername = (TextView) findViewById(R.id.tvYourUsername);
        final TextView yourPassword = (TextView) findViewById(R.id.tvYourPassword);
        final Button contactAppMaker = (Button) findViewById(R.id.btContactAppMaker);

        Intent intent = getIntent();
        String firstName = intent.getStringExtra("FIRSTNAME");
        String lastName = intent.getStringExtra("LASTNAME");
        String age = intent.getStringExtra("AGE");
        String phone = intent.getStringExtra("PHONE");
        String email = intent.getStringExtra("EMAIL");
        String username = intent.getStringExtra("USERNAME");
        String password = intent.getStringExtra("PASSWORD");

        greeting.setText("Hi " + firstName + " " + lastName + " ^__^");
        currentTime.setText("You're very young at " + age + "!!");
        yourUsername.setText("While '" + username + "' is an interesting username,");
        yourPassword.setText("your password '" + password + "' is even more curious.");

    }
}
