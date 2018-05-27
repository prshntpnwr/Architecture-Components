package com.example.prashant.databinding.owner;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.prashant.databinding.observer.Contact;
import com.example.prashant.databinding.R;
import com.example.prashant.databinding.databinding.ActivityMainBinding;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
//    private Contact mViewModelProvider;
    private ArrayList<Contact> contactArrayList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        populateContact();
        ActivityMainBinding mainBinding = DataBindingUtil.
                setContentView(this, R.layout.activity_main);
//
//        mViewModelProvider = ViewModelProviders.of(this).get(Contact.class);
//        mainBinding.setContact(mViewModelProvider);
        RecyclerView recyclerView = mainBinding.recyclerView;
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(new ItemAdapter(contactArrayList));
    }

    private void populateContact() {
        int i = 0;
        do {
           contactArrayList.add(new Contact());
            i++;
        } while (i <= 10);
    }
}
