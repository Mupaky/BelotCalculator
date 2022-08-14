package com.example.georgi.belotcalculator;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;


public class MainActivity extends AppCompatActivity {

    private EditText scoreTeamA;
    private EditText scoreTeamB;
    private TextView resultTeamA;
    private TextView resultTeamB;
    private EditText textTeamA;
    private EditText textTeamB;
    private CharSequence actA;
    private CharSequence actB;
    private byte countWinsTeamA;
    private byte countWinsTeamB;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        identificators();

        textTeamA.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (!hasFocus) {
                    actA = textTeamA.getText().toString();
                }
             }
        });
        textTeamB.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if(!hasFocus) {
                    actB = textTeamB.getText().toString();
                }
            }
        });


    }


    public void outScore(View view){
        if (((Button)view).getText().toString().equals("Out-B")
                && !scoreTeamB.getText().toString().equals("")
                && !resultTeamB.getText().toString().equals("")
                && scoreTeamB.getText().toString().charAt(0) >= '1'
                && scoreTeamB.getText().toString().charAt(0) <= '9') {
            if ( Integer.parseInt(resultTeamB.getText().toString()) >=  Integer.parseInt(scoreTeamB.getText().toString())
                    && Integer.parseInt(scoreTeamB.getText().toString()) > 0
                    ) {
                int a = Integer.parseInt(scoreTeamB.getText().toString());
                int b = Integer.parseInt(resultTeamB.getText().toString());
                this.resultTeamB.setText("" + (b-a));
                scoreTeamB.setText("");
            }
            else {
                Toast.makeText(MainActivity.this,"Enter another number", Toast.LENGTH_LONG);
            }


        }
        if (((Button)view).getText().toString().equals("Out-A")
                && !this.scoreTeamA.getText().toString().equals("")
                && !resultTeamA.getText().toString().equals("")
                && scoreTeamA.getText().toString().charAt(0) >= '1'
                && scoreTeamA.getText().toString().charAt(0) <= '9') {
            if (Integer.parseInt(resultTeamA.getText().toString()) >= Integer.parseInt(scoreTeamA.getText().toString())
                    && Integer.parseInt(scoreTeamA.getText().toString()) > 0
                    ) {
                int a = Integer.parseInt(scoreTeamA.getText().toString());
                int b = Integer.parseInt(resultTeamA.getText().toString());
                this.resultTeamA.setText("" + (b - a));
                scoreTeamA.setText("");
            } else {
                Toast.makeText(MainActivity.this, "Enter another number", Toast.LENGTH_LONG);
            }
        }
    }

    public void addoutScoreB(View view){

        if (!this.scoreTeamA.getText().toString().equals("")
                && !this.scoreTeamB.getText().toString().equals("")) {

                int a = Integer.parseInt(scoreTeamA.getText().toString());
                int b = Integer.parseInt(resultTeamA.getText().toString());
                this.resultTeamA.setText("" + (a+b));
                scoreTeamA.setText("");

                int c = Integer.parseInt(scoreTeamB.getText().toString());
                int d = Integer.parseInt(resultTeamB.getText().toString());
                this.resultTeamB.setText("" + (c+d));
                scoreTeamB.setText("");


        }
        if (Integer.parseInt(this.resultTeamB.getText().toString()) >= 151
                && Integer.parseInt(this.resultTeamB.getText().toString()) >
                Integer.parseInt(this.resultTeamA.getText().toString())) {
            this.resultTeamA.setText("0");
            this.resultTeamB.setText("0");
            this.countWinsTeamB++;
            AlertDialog.Builder newnew = new AlertDialog.Builder(this);
            newnew.setMessage(actB +  " win the game. \nResult " + actA +" " + countWinsTeamA +" vs "
                                + actB + " " + countWinsTeamB).setCancelable(false)
                    .setPositiveButton("Okay", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.cancel();
                        }
                    });
            AlertDialog alert = newnew.create();
            alert.setTitle(actB + " win!");
            alert.show();

        }

        if (Integer.parseInt(this.resultTeamA.getText().toString()) >= 151
                && Integer.parseInt(this.resultTeamA.getText().toString()) >
                Integer.parseInt(this.resultTeamB.getText().toString())) {
            this.resultTeamA.setText("0");
            this.resultTeamB.setText("0");
            this.countWinsTeamA++;
            AlertDialog.Builder newnew = new AlertDialog.Builder(this);
            newnew.setMessage(this.actA + " win the game. \nResult " + actA +" " + countWinsTeamA +" vs "
                            + actB + " " + countWinsTeamB).setCancelable(false)
                    .setPositiveButton("Okay", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.cancel();
                        }
                    });
            AlertDialog alert = newnew.create();
            alert.setTitle(actA +" win!");
            alert.show();

        }
    }

    public void restart(View view) {
        if (Integer.parseInt(this.resultTeamA.getText().toString()) > 0
                && Integer.parseInt(this.resultTeamB.getText().toString()) > 0) {

            AlertDialog.Builder restart = new AlertDialog.Builder(this);
            restart.setMessage("Realy want to restart the game?").setCancelable(true)
                    .setPositiveButton("restart", new DialogInterface.OnClickListener() {
                        TextView resultTeamA = (TextView) findViewById(R.id.resultA);
                        TextView resultTeamB = (TextView) findViewById(R.id.resultB);

                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            this.resultTeamA.setText("0");
                            this.resultTeamB.setText("0");
                            dialog.cancel();
                        }
                    });
            AlertDialog res = restart.create();
            res.setTitle("Restart!");
            res.show();
        }
    }

    public void identificators(){
        this.scoreTeamA = (EditText)findViewById(R.id.teamA);
        this.scoreTeamB = (EditText)findViewById(R.id.teamB);
        this.resultTeamA = (TextView)findViewById(R.id.resultA);
        this.resultTeamB = (TextView)findViewById(R.id.resultB);
        this.textTeamA = (EditText)findViewById(R.id.textTeamA);
        this.textTeamB = (EditText)findViewById(R.id.textTeamB);
        this.actA = textTeamA.getText().toString();
        this.actB = textTeamB.getText().toString();
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


}
