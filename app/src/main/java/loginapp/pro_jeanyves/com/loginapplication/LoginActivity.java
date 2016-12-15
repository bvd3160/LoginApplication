package loginapp.pro_jeanyves.com.loginapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        //initializing views
        final EditText username = (EditText) findViewById(R.id.etLoginUser);
        final EditText password = (EditText) findViewById(R.id.etLoginPass);
        final Button loginBtn = (Button) findViewById(R.id.btLogin);
        final Button registerBtn = (Button) findViewById(R.id.btRegister);
    }
}
