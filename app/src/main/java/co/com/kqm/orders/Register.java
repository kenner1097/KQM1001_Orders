package co.com.kqm.orders;

import android.app.AlertDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

import co.com.kqm.orders.model.RegisterRequest;

public class Register extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        final EditText nameUser = findViewById(R.id.txt_nameUser);
        final EditText name = findViewById(R.id.txt_name);
        final EditText lastname = findViewById(R.id.txt_lastName);
        final EditText email = findViewById(R.id.txt_email);
        final EditText password = findViewById(R.id.txt_password);
        final EditText phone = findViewById(R.id.txt_numberPhone);
        Button register = findViewById(R.id.button_registerClient);

        register.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {

                String nameUser1 = nameUser.getText().toString();
                String name1 = name.getText().toString();
                String lastname1 = lastname.getText().toString();
                String email1 = email.getText().toString();
                String password1 = password.getText().toString();
                String phone1 = phone.getText().toString();

                Response.Listener<String> respuesta = new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {

                        try{
                            JSONObject jsonRespuesta = new JSONObject(response);
                            boolean ok = jsonRespuesta.getBoolean("sucess");
                            if (ok == true) {
                                Intent i = new Intent (Register.this, Login.class);
                                Register.this.startActivity(i);
                                Register.this.finish();;
                            } else {
                                AlertDialog.Builder alertar = new AlertDialog.Builder(Register.this);
                                alertar.setMessage("Fallo en el registro")
                                        .setNegativeButton("Reintentar", null)
                                            .create()
                                                .show();
                            }
                        } catch(JSONException e) {
                            e.getMessage();
                        }
                    }
                };

                RegisterRequest r = new RegisterRequest(nameUser1, name1, lastname1, email1, password1, phone1, respuesta);
                RequestQueue cola = Volley.newRequestQueue(Register.this);
            }
        });

    }
}