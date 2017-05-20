package de.hochschule_trier.zinsberechnung;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    public static final String MESSAGE = "de.hochschule_trier.MESSAGE";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onClick(View v)
    {
        EditText editText = (EditText) findViewById(R.id.kapital_input);
        String input = editText.getText().toString();
        Intent intent = new Intent(this,ZinsActivity.class);
        intent.putExtra(MESSAGE, input);
        startActivity(intent);
    }
}
