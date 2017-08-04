package com.example.toshba.firebaseuygulamasi.Adapter;

import android.content.Context;
import android.os.Message;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.toshba.firebaseuygulamasi.Mesaj;
import com.example.toshba.firebaseuygulamasi.R;
import com.google.firebase.auth.FirebaseUser;

import java.util.ArrayList;

/**
 * Created by TOSHİBA on 4.08.2017.
 */

public class CustomAdapter extends ArrayAdapter<Mesaj> {

    private FirebaseUser firebaseUser;

    public CustomAdapter(Context context, ArrayList<Mesaj> chatList, FirebaseUser firebaseUser) {
        super(context, 0, chatList);
        this.firebaseUser = firebaseUser;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        Mesaj message = getItem(position);
        if (firebaseUser.getEmail().equalsIgnoreCase(message.getGonderici())) {

            convertView = LayoutInflater.from(getContext()).inflate(R.layout.right_item_layout, parent, false);

            TextView txtUser = (TextView) convertView.findViewById(R.id.txtUserRight);
            TextView txtMessage = (TextView) convertView.findViewById(R.id.txtMessageRight);
            TextView txtTime = (TextView) convertView.findViewById(R.id.txtTimeRight);

            txtUser.setText(message.getGonderici());
            txtMessage.setText(message.getMesajText());
            txtTime.setText(message.getZaman());

        } else {

            convertView = LayoutInflater.from(getContext()).inflate(R.layout.left_item_layout, parent, false);

            TextView txtUser = (TextView) convertView.findViewById(R.id.txtUserLeft);
            TextView txtMessage = (TextView) convertView.findViewById(R.id.txtMessageLeft);
            TextView txtTime = (TextView) convertView.findViewById(R.id.txtTimeLeft);

            txtUser.setText(message.getGonderici());
            txtMessage.setText(message.getMesajText());
            txtTime.setText(message.getZaman());

        }

        return convertView;
    }
}