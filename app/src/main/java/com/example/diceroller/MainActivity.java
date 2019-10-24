package com.example.diceroller;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
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

    private static int points = 0;


    public String roll_the_dice()
    {
        Random r = new Random();
        int number = r.nextInt(5) + 1;
        String answer = Integer.toString(number);
        return answer;
    }

    // Roll the dice game
    public void on_button_click(View view)
    {
        EditText simpleEditText = (EditText) findViewById(R.id.simpleEditText);
        String guess = simpleEditText.getText().toString();

        TextView tv = this.findViewById(R.id.myTextView);

        String answer = roll_the_dice();

        tv.setText("The correct answer is: " + answer);
        TextView pts = this.findViewById(R.id.points);

        if(guess.equals(answer))
        {
            Toast.makeText(getApplicationContext(), "Congrats!", Toast.LENGTH_SHORT).show();
            points++;
            pts.setText(Integer.toString(points));
        }
        else
        {
            Toast.makeText(getApplicationContext(), "Try again", Toast.LENGTH_SHORT).show();
        }

    }

    // D-ICEBREAKERS
    public void onClickdIceBreakers(View view)
    {
        TextView tv = this.findViewById(R.id.myTextView);

        String diceValue = roll_the_dice();

        if(diceValue.equals("1"))
        {
            tv.setText("If you could go anywhere in the world, where would you go?");
        }
        else if(diceValue.equals("2"))
        {
            tv.setText("If you were stranded on a desert island, what three things would you want to take with you?");
        }
        else if(diceValue.equals("3"))
        {
            tv.setText("If you could eat only one food for the rest of your life, what would that be?");
        }
        else if(diceValue.equals("4"))
        {
            tv.setText("If you won a million dollars, what is the first thing you would buy?");
        }
        else if(diceValue.equals("5"))
        {
            tv.setText("If you could spaned the day with one fictional character, who would it be??");
        }
        else if(diceValue.equals("6"))
        {
            tv.setText("If you found a magic lantern and a genie gave you three wishes, what would you wish?");
        }
    }

    // Add new dicebreaker button
    public void onClickNewdiceBreaker(View view)
    {
        Intent intent = new Intent(this, newdIceBreaker.class);
        startActivity(intent);
    }
}
