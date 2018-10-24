package com.example.dell.modul2_pemrogramanplatformmobile;

import android.app.FragmentManager;
import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (savedInstanceState == null) {
            //inisiasi adapter untuk mengaktifkan fragment
            android.support.v4.app.FragmentManager fragmentManager = getSupportFragmentManager();

            //transaksi fragment
            //inisiasi object bertipe BodyPartFragment
            BodyPartsFragments bodyPartsFragments;


            //mengambil fragment
            BodyPartsFragments headFragment = new BodyPartsFragments();

            //inisiasi adaptor untuk mengaktifkan fragment
            //android.support.v4.app.FragmentManager fragmentManager = getSupportFragmentManager();

            //transaksi fragment
            fragmentManager.beginTransaction().add(R.id.heads_container, headFragment).commit();

            //membuat object untuk heads
            BodyPartsFragments bodyFragment = new BodyPartsFragments();
            bodyFragment.setmImageIds(ImageAssets.getHeads());
            bodyFragment.setmListIndex(0);

            //transaksi fragment heads
            fragmentManager.beginTransaction().add(R.id.heads_container, bodyFragment).commit();

            //membuat object untuk bodys
            bodyFragment = new BodyPartsFragments();
            bodyFragment.setmImageIds(ImageAssets.getBodys());
            bodyFragment.setmListIndex(0);

            //transaksi fragment bodys
            fragmentManager.beginTransaction().add(R.id.bodys_container, bodyFragment).commit();

            //membuat object untuk legs
            bodyFragment = new BodyPartsFragments();
            bodyFragment.setmImageIds(ImageAssets.getLegss());
            bodyFragment.setmListIndex(0);

            //transaksi fragment legs
            fragmentManager.beginTransaction().add(R.id.legs_container, bodyFragment).commit();
        }
    }
}
