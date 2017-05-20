package de.hochschule_trier.zinsberechnung;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class ZinsActivity extends AppCompatActivity {

    public static final String ZINSEN = "de.hochschule_trier.ZINSEN";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_zins);
    }

    public void onClick(View v)
    {
        // kapital speichern
        Intent intent = getIntent();
        String kapital = intent.getStringExtra(MainActivity.MESSAGE);

        //Zinsen auslesen
        EditText editText = (EditText) findViewById(R.id.zins_input);
        String zins = editText.getText().toString();

        Intent newIntent = new Intent(this, LaufActivity.class);
        newIntent.putExtra(MainActivity.MESSAGE, kapital);
        newIntent.putExtra(ZinsActivity.ZINSEN, zins);
        startActivity(newIntent);
    }
}
