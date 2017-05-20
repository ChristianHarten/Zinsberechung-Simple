package de.hochschule_trier.zinsberechnung;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class LaufActivity extends AppCompatActivity {

    public static final String LAUFZEIT = "de.hochschule_trier.LAUFZEIT";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lauf);
    }

    public void onClick(View v)
    {
        //speichere Kapital und Zinsen
        Intent intent = getIntent();
        String kapital = intent.getStringExtra(MainActivity.MESSAGE);
        String zins = intent.getStringExtra(ZinsActivity.ZINSEN);

        //Laufzeit auslesen
        EditText editText = (EditText) findViewById(R.id.laufzeit_input);
        String laufzeit = editText.getText().toString();

        //neuen Intent bauen
        Intent newIntent = new Intent(this, ResultActivity.class);
        newIntent.putExtra(MainActivity.MESSAGE, kapital);
        newIntent.putExtra(ZinsActivity.ZINSEN, zins);
        newIntent.putExtra(LaufActivity.LAUFZEIT, laufzeit);
        startActivity(newIntent);
    }
}
