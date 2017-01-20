package com.example.gideonubaldo.contactmanager;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TabHost;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    EditText nametxt,phonetxt,emailtxt,addresstxt;
    List<Contact> Contacts = new ArrayList<Contact>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nametxt = (EditText)findViewById(R.id.etName);
        phonetxt = (EditText)findViewById(R.id.etPhoneNumber);
        emailtxt = (EditText)findViewById(R.id.etEmail);
        addresstxt = (EditText)findViewById(R.id.etAddress);

        TabHost tabhost = (TabHost)findViewById(R.id.tabhost);

        tabhost.setup();

        TabHost.TabSpec tabspec = tabhost.newTabSpec("creator");
        tabspec.setContent(R.id.tabCreator);
        tabspec.setIndicator("Creator");
        tabhost.addTab(tabspec);

        tabspec = tabhost.newTabSpec("list");
        tabspec.setContent(R.id.tabContactList);
        tabspec.setIndicator("List");
        tabhost.addTab(tabspec);

        final Button addBtn = (Button)findViewById(R.id.addButton);
        addBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(),"Your contact has been created!",Toast.LENGTH_SHORT).show();
            }
        });


        nametxt.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                addBtn.setEnabled(!nametxt.getText().toString().trim().isEmpty());
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
    }
    private class ContactListAdapter extends ArrayAdapter<Contact>{
        public ContactListAdapter(){
            super(MainActivity.this, R.layout.listview_item, Contacts);

        }
    }
}
