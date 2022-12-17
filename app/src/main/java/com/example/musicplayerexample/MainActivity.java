package com.example.musicplayerexample;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView tv1,tv2;
    private FragmentManager fm;
    private FragmentTransaction ft;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tv1=findViewById(R.id.menu1);
        tv2=findViewById(R.id.menu2);

        tv1.setOnClickListener(this);
        tv2.setOnClickListener(this);

        fm = getSupportFragmentManager();

        ft = fm.beginTransaction();

        ft.replace(R.id.content,new frag1());

        ft.commit();
    }

    @Override
    public void onClick(View v) {
        ft = fm.beginTransaction();

        switch(v.getId()){
            case R.id.menu1:
                ft.replace(R.id.content, new frag1());
                break;
            case R.id.menu2:
                ft.replace(R.id.content, new frag2());
                break;
            default:
                break;
        }
        ft.commit();
    }
}