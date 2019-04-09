package co.com.kqm.orders.model;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Kenner QM
 * @since 31/03/2019
 */
public class RegisterRequest extends StringRequest {

    private static final String ruta = "http://orders0101.000webhostapp.com/register.php";
    private Map<String, String> parametros;

    public RegisterRequest(String nameUser, String name, String lastName, String email, String password, String phone, Response.Listener<String> listener){

        super(Request.Method.POST, ruta, listener, null);
        parametros = new HashMap<>();
        parametros.put("nombre de usuario", nameUser+"");
        parametros.put("nombre", name+"");
        parametros.put("apellidos", lastName+"");
        parametros.put("correo", email+"");
        parametros.put("contrasena", password+"");
        parametros.put("telefono", phone+"");
    }

    @Override
    protected Map<String, String> getParams() {
        return parametros;
    }

}