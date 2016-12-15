package loginapp.pro_jeanyves.com.loginapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

public class RegisterActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        //initializing views
        final EditText firstName = (EditText) findViewById(R.id.etFName);
        final EditText lastName = (EditText) findViewById(R.id.etLName);
        final EditText age = (EditText) findViewById(R.id.etAge);
        final EditText phone = (EditText) findViewById(R.id.etPhone);
        final EditText email = (EditText) findViewById(R.id.etEmail);
        final EditText username = (EditText) findViewById(R.id.etUsername);
        final EditText password = (EditText) findViewById(R.id.etPassword);
        final Button saveDetails = (Button) findViewById(R.id.btSave);
    }
}
