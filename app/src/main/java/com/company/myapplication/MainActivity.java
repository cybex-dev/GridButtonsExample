package com.company.myapplication;

import android.content.DialogInterface;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button clickedFirst = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnOne = findViewById(R.id.button3);
        Button btnTwo = findViewById(R.id.button);
        Button btnTwo2 = findViewById(R.id.button2);
        btnOne.setOnClickListener(this);
        btnTwo.setOnClickListener(this);
        btnTwo2.setOnClickListener(this);
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
    public void onClick(View view) {
        if (clickedFirst == null) {
            // First click
            clickedFirst = (Button) view;
        } else {
            // Second Click
            if (((Button)view).getText().equals(clickedFirst.getText())) {
                new AlertDialog.Builder(this).setTitle("You won").setMessage("Contrats, you got a match").setPositiveButton("Thanks", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(MainActivity.this, "You lciked thanks", Toast.LENGTH_SHORT).show();
                    }
                }).create().show();
            } else {
                Toast.makeText(this, "Sorry, no match", Toast.LENGTH_SHORT).show();
            }
            clickedFirst = null;
        }
    }
}
