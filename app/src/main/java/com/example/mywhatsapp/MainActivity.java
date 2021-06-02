package com.example.mywhatsapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.MultiAutoCompleteTextView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MainActivity extends AppCompatActivity {


    ListView listview;
    MultiAutoCompleteTextView multiAutoCompleteTextView;
    RelativeLayout recordRL;
    List<Message> messageList;
    String time = "00:00";
    CustomListViewAdapter customListViewAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate ( savedInstanceState );
        setContentView ( R.layout.activity_main );
        installize ();

        messageList = new ArrayList<Message>();


        recordRL.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String temp = String.valueOf ( multiAutoCompleteTextView.getText () );
                if(temp.charAt ( 0 ) == 'a'){

                    temp = temp.substring (2);
                    Message message = new Message ( "a",temp,time );
                    messageList.add ( message );
                    multiAutoCompleteTextView.setText ( "" );

                }
                if(temp.charAt ( 0 ) == 'b'){

                    temp = temp.substring (2);

                    Message message = new Message ( "b",temp,time );
                    messageList.add ( message );
                    multiAutoCompleteTextView.setText ( "" );
                }

                customListViewAdapter = new CustomListViewAdapter (getApplicationContext (),messageList );
                listview.setAdapter ( customListViewAdapter );

            }
        });

    }

    public void installize(){

        listview = (ListView) findViewById ( R.id.lvMessageBoard );
        multiAutoCompleteTextView = (MultiAutoCompleteTextView) findViewById ( R.id.multiAutoCompleteTextViewMessage );
        recordRL =  findViewById ( R.id.recordRL );
    }

    public void SetTimer(String value){
        time = value.substring ( 2 );
    }
    public void UpdateTimer(){
        int tempTime = Integer.parseInt ( time.substring ( 3,5 ) )+1;
        time = time.substring ( 0,2 )+tempTime;
    }

}