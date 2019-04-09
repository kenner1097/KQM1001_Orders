package co.com.kqm.orders;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final TextView welcome = findViewById(R.id.ms_mansaje);
        Intent ms = this.getIntent();
        String name = ms.getStringExtra("name");
        welcome.setText(welcome.getText()+ "" + name + "");
    }

}
