package co.com.kqm.orders;

import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
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
        final EditText lastName = findViewById(R.id.txt_lastName);
        final EditText email = findViewById(R.id.txt_email);
        final EditText password = findViewById(R.id.txt_password);
        final EditText phone = findViewById(R.id.txt_numberPhone);
        Button register = findViewById(R.id.button_registerClient);

        register.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {

                String nameUser1 = nameUser.getText().toString();
                String name1 = name.getText().toString();
                String lastName1 = lastName.getText().toString();
                String email1 = email.getText().toString();
                String password1 = password.getText().toString();
                String phone1 = phone.getText().toString();

                RegisterRequest r = new RegisterRequest(nameUser1, name1, lastName1, email1, password1, phone1, new Response.Listener<String>() {

                    @Override
                    public void onResponse(String response) {

                        try {

                            JSONObject jsonRespuesta = new JSONObject(response);
                            boolean ok = jsonRespuesta.getBoolean("success");

                            if (ok == true) {
                                Intent i = new Intent(Register.this, Login.class);
                                Register.this.startActivity(i);
                                Register.this.finish();
                            } else {
                                AlertDialog.Builder alertar = new AlertDialog.Builder(Register.this);
                                alertar.setMessage("Fallo en el registro")
                                        .setNegativeButton("Reintentar", null)
                                        .create()
                                        .show();
                            }

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast toast = Toast.makeText(Register.this, error.getMessage(), Toast.LENGTH_SHORT);
                        toast.setGravity(Gravity.CENTER_VERTICAL, 0, 0);
                        toast.show();
                    }
                });

                RequestQueue cola = Volley.newRequestQueue(Register.this);
                cola.add(r);

            }
        });

    }
}