package com.example.chaitanyav.ndktestapp;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends ActionBarActivity implements View.OnClickListener {

    public native int sumTwoValues(int a,int b);

    Button btnAdd;
    EditText editTextOne;
    EditText editTextTwo;
    TextView txtResult;
    static {
        System.loadLibrary("ndkTest");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnAdd = (Button) findViewById(R.id.btnAdd);
        editTextOne = (EditText) findViewById(R.id.editTextOne);
        editTextTwo = (EditText) findViewById(R.id.editTextTwo);
        txtResult = (TextView) findViewById(R.id.txtResult);
        btnAdd.setOnClickListener(this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(View v) {
        if(isValidInput()) {
            int z = sumTwoValues(Integer.parseInt(editTextOne.getText().toString()), Integer.parseInt(editTextTwo.getText().toString()));
            System.out.println("SUM : " + z);
            txtResult.setText("" + z);
        }
    }

    private boolean isValidInput() {
        if(editTextOne.getText().toString().isEmpty() || editTextTwo.getText().toString().isEmpty()) {
            Toast.makeText(this, "Please enter values", Toast.LENGTH_SHORT).show();
            return false;
        }
        return true;
    }
}
