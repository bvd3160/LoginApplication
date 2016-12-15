package loginapp.pro_jeanyves.com.loginapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainScreen extends AppCompatActivity {

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
    }
}
