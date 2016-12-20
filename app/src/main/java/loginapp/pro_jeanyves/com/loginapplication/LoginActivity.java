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

import org.json.JSONException;
import org.json.JSONObject;

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

        registerBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                LoginActivity.this.startActivity(new Intent(LoginActivity.this, RegisterActivity.class));
            }
        });

        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String user = username.getText().toString();
                String pass = password.getText().toString();

                Response.Listener<String> responseLitener = new Response.Listener<String>() {

                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONObject jsonObject = new JSONObject(response);
                            boolean successful = jsonObject.getBoolean("success");
                            if (successful) {
                                Intent mainScreen = new Intent(LoginActivity.this, MainScreenActivity.class);
                                mainScreen.putExtra("FIRSTNAME", jsonObject.getString("firstName"));
                                mainScreen.putExtra("LASTNAME", jsonObject.getString("lastName"));
                                mainScreen.putExtra("AGE", jsonObject.getString("age"));
                                mainScreen.putExtra("PHONE", jsonObject.getString("phone"));
                                mainScreen.putExtra("EMAIL", jsonObject.getString("email"));
                                mainScreen.putExtra("USERNAME", jsonObject.getString("user"));
                                mainScreen.putExtra("PASSWORD", jsonObject.getString("pass"));
                                LoginActivity.this.startActivity(mainScreen);
                                Toast.makeText(LoginActivity.this, "Welcome home!", Toast.LENGTH_SHORT).show();
                            } else {
                                AlertDialog.Builder builder = new AlertDialog.Builder(LoginActivity.this);
                                builder.setMessage("Login Failed!");
                                builder.setNegativeButton("Retry", null).create().show();
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                };

                LoginRequest loginRequest = new LoginRequest(user, pass, responseLitener);
                RequestQueue queue = Volley.newRequestQueue(LoginActivity.this);
                queue.add(loginRequest);

            }
        });
    }
}
