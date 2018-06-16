package com.example.rkhat.currencyconverter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    public void convertDollars(View view){
        EditText dollarText=(EditText)findViewById(R.id.dollarText);
        Double dollarAmount=Double.parseDouble(dollarText.getText().toString());
        Double rupeeAmount=dollarAmount*67.16;
        Toast.makeText(MainActivity.this, "Rs" + String.format("%.2f",rupeeAmount),Toast.LENGTH_SHORT).show();



    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
