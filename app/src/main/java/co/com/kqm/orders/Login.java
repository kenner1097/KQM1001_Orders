package co.com.kqm.orders;

import android.app.AlertDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;

import org.json.JSONObject;

import co.com.kqm.orders.model.LoginRequest;

public class Login extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        TextView register = findViewById(R.id.id_register);
        final Button login = findViewById(R.id.button_entryClient);
        final EditText nameUser = findViewById(R.id.id_name);
        final EditText password = findViewById(R.id.id_password);

        //Loading the view when the user select register now

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent register = new Intent(Login.this, Register.class);
                Login.this.startActivity(register);
                finish();
            }
        });

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                final String nameUser1 = nameUser.getText().toString();
                final String password1 = password.getText().toString();

                Response.Listener<String> respuesta = new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONObject jsonrespuesta = new JSONObject(response);
                            boolean ok = jsonrespuesta.getBoolean("success");

                            if (ok == true) {

                                String name = jsonrespuesta.getString("name");
                                Intent welcome = new Intent(Login.this, MainActivity.class);
                                welcome.putExtra("name", name);

                                Login.this.startActivity(welcome);
                                Login.this.finish();

                            } else {

                                AlertDialog.Builder alerta = new AlertDialog.Builder(Login.this);
                                alerta.setMessage("Fallo en el inicio de sesion")
                                        .setNegativeButton("Reintentar", null)
                                        .create()
                                        .show();
                            }

                        } catch (Exception e) {
                            e.getMessage();
                        }
                    }
                };
                LoginRequest r = new LoginRequest(nameUser1, password1, respuesta);
                RequestQueue cola = Volley.newRequestQueue(Login.this);

            }
        });
    }
}