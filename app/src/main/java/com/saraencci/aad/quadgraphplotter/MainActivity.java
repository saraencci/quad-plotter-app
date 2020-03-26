package com.saraencci.aad.quadgraphplotter;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.os.Bundle;

import com.saraencci.aad.quadgraphplotter.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityMainBinding mainBinding;
        mainBinding= DataBindingUtil.setContentView(this,R.layout.activity_main);
       // setContentView(R.layout.activity_main);
    }
}
