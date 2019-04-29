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
public class LoginRequest extends StringRequest {

    private static final String ruta = "http://orders0101.000webhostapp.com/login.php";
    private Map<String, String> parametros;

    public LoginRequest (String user, String password, Response.Listener<String> listener, Response.ErrorListener error){
        super(Request.Method.POST, ruta, listener, error);

        parametros = new HashMap<>();
        parametros.put("nameUser", user);
        parametros.put("password", password);
    }

    @Override
    protected Map<String, String> getParams() {
        return parametros;
    }
}
