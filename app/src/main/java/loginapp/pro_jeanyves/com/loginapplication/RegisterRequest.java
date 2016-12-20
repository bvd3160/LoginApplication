package loginapp.pro_jeanyves.com.loginapplication;

import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by jean-yves on 18/12/2016.
 */

public class RegisterRequest extends StringRequest {
    private static final String REGISTER_REQUEST_URL = "http://jeanyves-pro.com/RegisterUser.php";
    private Map<String, String> params;

    public RegisterRequest(String firstName, String lastName, String age, String phone, String email,
                           String username, String password, Response.Listener<String> listener) {
        super(Method.POST, REGISTER_REQUEST_URL, listener, null);
        params = new HashMap<>();
        params.put("firstName", firstName);
        params.put("lastName", lastName);
        params.put("age", age);
        params.put("phone", phone);
        params.put("email", email);
        params.put("username", username);
        params.put("password", password);
    }

    @Override
    public Map<String, String> getParams() {
        System.out.println("PARAMS CONTAINED " + params.size() + " ELEMENTS!");
        return params;
    }
}
