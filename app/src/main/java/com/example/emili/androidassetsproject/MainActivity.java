package com.example.emili.androidassetsproject;

import android.content.res.Configuration;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;


import com.example.emili.androidassetsproject.fragment.BodyPartFragment;
import com.example.emili.androidassetsproject.fragment.MasterListFragment;

public class MainActivity extends AppCompatActivity implements BodyPartFragment.OnFragmentInteractionListener, MasterListFragment.OnFragmentInteractionListener {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (savedInstanceState == null) {
            BodyPartFragment headFragment = new BodyPartFragment();
            headFragment.setBodyPartIndexForPrsenter(0);
            headFragment.setmListIndex(0);
            getSupportFragmentManager().beginTransaction().add(R.id.frameLayoutHead, headFragment).commit();

            BodyPartFragment bodyFragment = new BodyPartFragment();
            bodyFragment.setBodyPartIndexForPrsenter(1);
            bodyFragment.setmListIndex(4);
            getSupportFragmentManager().beginTransaction().add(R.id.frameLayoutBody, bodyFragment).commit();

            BodyPartFragment legsFragment = new BodyPartFragment();
            legsFragment.setBodyPartIndexForPrsenter(2);
            legsFragment.setmListIndex(2);
            getSupportFragmentManager().beginTransaction().add(R.id.frameLayoutLegs, legsFragment).commit();
        }
        if(getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE) {
            MasterListFragment masterListFragment = new MasterListFragment();
            getSupportFragmentManager().beginTransaction().add(R.id.frameLayoutMaster, masterListFragment).commit();
        }


    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }

    @Override
    public void onFragmentInteraction(int position) {

        int myPosition = 0;

        if(position <= 11){
            BodyPartFragment headFragment = new BodyPartFragment();
            headFragment.setBodyPartIndexForPrsenter(0);
            headFragment.setmListIndex(position);
            getSupportFragmentManager().beginTransaction().replace(R.id.frameLayoutHead, headFragment).commit();
        }
        else if(position >= 12 && position <= 23){
            myPosition = position - 12;
            BodyPartFragment bodyFragment = new BodyPartFragment();
            bodyFragment.setBodyPartIndexForPrsenter(1);
            bodyFragment.setmListIndex(myPosition);
            getSupportFragmentManager().beginTransaction().replace(R.id.frameLayoutBody, bodyFragment).commit();
        }
        else if(position >= 24 && position <= 35){
            myPosition = position - 24;
            BodyPartFragment legsFragment = new BodyPartFragment();
            legsFragment.setBodyPartIndexForPrsenter(2);
            legsFragment.setmListIndex(myPosition);
            getSupportFragmentManager().beginTransaction().replace(R.id.frameLayoutLegs, legsFragment).commit();
        }
    }
}

