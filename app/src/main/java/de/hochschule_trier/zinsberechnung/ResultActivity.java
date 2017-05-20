package de.hochschule_trier.zinsberechnung;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

public class ResultActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        TextView resultView = (TextView) findViewById(R.id.result_view);

        //lese informationen aus Intent
        Intent intent = getIntent();
        String kapital = intent.getStringExtra(MainActivity.MESSAGE);
        String zinsen = intent.getStringExtra(ZinsActivity.ZINSEN);
        String laufzeit = intent.getStringExtra(LaufActivity.LAUFZEIT);

        //parse String to Integer, berechne ergebnis
        double result, base = 0, zins = 0, duration = 0;
        try {
            base = Double.parseDouble(kapital);
            zins = Double.parseDouble(zinsen);
            duration = Double.parseDouble(laufzeit);
        }
        catch (NumberFormatException e) {
            Toast.makeText(this, "FEHLER BEIM PARSEN", Toast.LENGTH_LONG).show();
        }
        result = base * Math.pow((1 + (zins/100)), duration);
        result = Math.round(result * 100.0)/100.0;

        //zeige ergebnis
        resultView.append(Double.toString(result));
    }
}
