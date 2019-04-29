package co.com.kqm.orders.model;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Kenner QM
 * @since 24/04/2019
 */
public class RegisterRequest extends StringRequest {

    private static final String ruta = "http://orders0101.000webhostapp.com/register.php";
    private Map<String, String> parametros;

    public RegisterRequest(String nameUser, String name, String lastName, String email, String password, String phone, Response.Listener<String> listener, Response.ErrorListener error){
        super(Request.Method.POST, ruta, listener, error);

        parametros = new HashMap<>();
        parametros.put("nameUser", nameUser);
        parametros.put("name", name);
        parametros.put("lastname", lastName);
        parametros.put("email", email);
        parametros.put("password", password);
        parametros.put("phone", phone);
    }

    @Override
    protected Map<String, String> getParams() {
        return parametros;
    }

}