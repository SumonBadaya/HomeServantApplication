package com.example.user.homeservantapplication;

import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class GalleryActivity extends AppCompatActivity {
    ViewPager viewPager;
    Integer[] imageId = {R.drawable.cliening, R.drawable.dring, R.drawable.kichan, R.drawable.wash,R.drawable.weash};
    String[] imagesName = {"cliening","dring","kichan","wash","weash"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gallery);

        viewPager = (ViewPager) findViewById(R.id.viewPager_Photo);
        PagerAdapter adapter = new ImageSlideAdapter(GalleryActivity.this,imageId,imagesName);
        viewPager.setAdapter(adapter);
    }
}
