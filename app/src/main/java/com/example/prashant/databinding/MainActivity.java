package com.example.prashant.databinding;

import android.arch.lifecycle.ViewModelProviders;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.example.prashant.databinding.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    private Contact mViewModelProvider;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityMainBinding mainBinding = DataBindingUtil.
                setContentView(this, R.layout.activity_main);

        mViewModelProvider = ViewModelProviders.of(this).get(Contact.class);
        mainBinding.setContact(mViewModelProvider);
    }
}
