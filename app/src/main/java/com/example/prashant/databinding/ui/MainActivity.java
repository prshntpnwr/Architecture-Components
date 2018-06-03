package com.example.prashant.databinding.ui;

import android.arch.lifecycle.ViewModelProviders;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.prashant.databinding.R;
import com.example.prashant.databinding.databinding.ActivityMainBinding;
import com.example.prashant.databinding.data.Contact;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private ArrayList<Contact> contactArrayList = new ArrayList<>();
    private ItemAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityMainBinding mainBinding = DataBindingUtil.
                setContentView(this, R.layout.activity_main);

        RecyclerView recyclerView = mainBinding.recyclerView;
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter =  new ItemAdapter(contactArrayList);
        recyclerView.setAdapter(adapter);

        // Create a ViewModel the first time the system calls an activity's onCreate() method.
        // Re-created activities receive the same MyViewModel instance created by the first activity.
        ItemViewModel model = ViewModelProviders.of(this).get(ItemViewModel.class);
        model.getContacts().observe(this, users -> {
            // update UI
            adapter.notifyDataSetChanged();
        });
    }
}
