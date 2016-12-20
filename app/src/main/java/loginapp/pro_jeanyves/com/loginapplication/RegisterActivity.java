package loginapp.pro_jeanyves.com.loginapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;

import org.json.JSONObject;

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


        saveDetails.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String FIRSTNAME = firstName.getText().toString();
                String LASTNAME = lastName.getText().toString();
                String AGE = age.getText().toString();
                String PHONE = phone.getText().toString();
                String EMAIL = email.getText().toString();
                String USERNAME = username.getText().toString();
                String PASSWORD = password.getText().toString();


                Response.Listener<String> responseListener = new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONObject jsonResponse = new JSONObject(response);
                            boolean successful = jsonResponse.getBoolean("success");
                            if (successful) {
                                RegisterActivity.this.startActivity(new Intent(RegisterActivity.this, LoginActivity.class));
                                Toast.makeText(RegisterActivity.this, "Registration Successful", Toast.LENGTH_SHORT).show();
                            } else {
                                AlertDialog.Builder builder = new AlertDialog.Builder(RegisterActivity.this);
                                builder.setMessage("Registration Failed!");
                                builder.setNegativeButton("Retry", null).create().show();
                            }

                        } catch (Exception e) {
                            System.out.println(e.getMessage());
                            Toast.makeText(RegisterActivity.this, "Error! Server did not respond!", Toast.LENGTH_SHORT).show();
                        }

                    }
                };


                RegisterRequest request = new RegisterRequest(FIRSTNAME, LASTNAME, AGE, PHONE, EMAIL, USERNAME, PASSWORD, responseListener);
                RequestQueue queue = Volley.newRequestQueue(RegisterActivity.this);
                queue.add(request);
            }
        });
    }
}
