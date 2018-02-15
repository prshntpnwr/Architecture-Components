package com.example.prashant.databinding;

import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.prashant.databinding.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityMainBinding mainBinding = DataBindingUtil.
                setContentView(this, R.layout.activity_main);

        Contact contact = new Contact(
                "Name", "(+91) 9876543210", "name@user.com", "Home");
        mainBinding.setContact(contact);
    }
}
