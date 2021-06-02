package com.example.mywhatsapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

public class CustomListViewAdapter extends BaseAdapter
    {

        private Context context;
        List<Message> messages;
        public CustomListViewAdapter(Context context, List<Message> list)
        {

            this.context = context;
            messages = list;
        }

        @Override
        public int getCount() {
            return messages.size ();
        }

        @Override
        public Object getItem(int position) {
            return messages.get ( position );
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            TextView textViewItemName;
            TextView textViewDate;

            Message currentItem = (Message) getItem(position);
            if (convertView == null) {
                if(messages.get ( position ).userName=="b")
                {
                    convertView = LayoutInflater.from ( context ).inflate ( R.layout.a_message,parent,false );

                    textViewItemName = (TextView)
                            convertView.findViewById(R.id.tvMessageA);
                    textViewDate = (TextView)
                            convertView.findViewById(R.id.tvTimeA );
                }else {
                    convertView = LayoutInflater.from ( context ).inflate ( R.layout.b_message,parent,false );

                    textViewItemName = (TextView)
                            convertView.findViewById(R.id.tvMessageB);
                    textViewDate = (TextView)
                            convertView.findViewById(R.id.tvTimeB );

                }

                textViewItemName.setText ( currentItem.message );
                textViewDate.setText ( currentItem.time );


                }
            return convertView;
        }
    }

