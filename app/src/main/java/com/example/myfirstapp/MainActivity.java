package com.example.myfirstapp;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity implements View.OnClickListener  {

    private Button btnStart;
    private Button btnStartAgain;
    private Button btnExit;
    private TextView txtMessage;






    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnStart=(Button) this.findViewById(R.id.btnStart);
        btnStartAgain=(Button) this.findViewById(R.id.btnStartAgain);
        btnExit=(Button) this.findViewById(R.id.btnExit);
        txtMessage=(TextView) this.findViewById(R.id.txtMessage);

        btnStart.setOnClickListener(this);
        btnStartAgain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        btnExit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        btnStartAgain.setVisibility(View.GONE);
        btnExit.setVisibility(View.GONE);
    }

    public void onClick(View v){
        final EditText input = new EditText(  this);
        AlertDialog dialog =new AlertDialog.Builder(  this )
                .setMessage("What would you like tomtalk about??")
                .setView(input)
                .setPositiveButton("Continue", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int which) {
                        keepTalking(input.getText().toString());

                    }
                })
                .setNegativeButton("cancel",null )
                .show();
        startAgain();


    }

    public void keepTalking( final String t){
        AlertDialog secondDialog =new AlertDialog.Builder( this)
                .setMessage("Do you like "+t+"?")
                .setPositiveButton("yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int which) {
                        likeTopic(t);
                    }
                })
                .setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int which) {
                        dislikeTopic(t);
                    }
                })
                .show();


    }
    public void likeTopic(String t){
        Context context=getApplicationContext();
        CharSequence message ="I am happy that you like"+t+"!!";
        int duration = Toast.LENGTH_LONG;
        Toast toast =Toast.makeText(context,message,duration);
        toast.show();

    }
    public void startAgain(){
        btnStart.setVisibility(View.GONE);
        txtMessage.setVisibility(View.GONE);
        btnStartAgain.setVisibility(View.VISIBLE);
        btnExit.setVisibility(View.VISIBLE);

     }
    public void dislikeTopic(String t){
        Context context=getApplicationContext();
        CharSequence message ="Are you serious?you dont like"+t+"!!";
        int duration = Toast.LENGTH_LONG;
        Toast toast =Toast.makeText(context,message,duration);
        toast.show();

    }









}


