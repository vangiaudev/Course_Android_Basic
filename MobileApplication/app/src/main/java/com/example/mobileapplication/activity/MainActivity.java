package com.example.mobileapplication.activity;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.app.ActionBar;
import android.app.Notification;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;
import androidx.appcompat.widget.Toolbar;
import android.widget.ViewFlipper;

import com.example.mobileapplication.R;
import com.google.android.material.navigation.NavigationView;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import static com.squareup.picasso.Picasso.*;

public class MainActivity extends AppCompatActivity  {
    Toolbar toolbar;
    ViewFlipper viewFlipper;
    RecyclerView recyclerViewManHinhChinh;
    NavigationView navigationView;
    ListView listViewManHinhChinh;
    DrawerLayout drawerLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Anhxa();
        ActionBarr();
        ActionViewFlipper();
    }

    public void ActionViewFlipper() {
        ArrayList<String> mangquangcao = new ArrayList<>();
        mangquangcao.add("https://cdn.tgdd.vn/Products/Images/42/220438/oppo-reno5-trang-600x600-1-600x600.jpg");
        mangquangcao.add("https://cdn.tgdd.vn/Products/Images/44/235542/5-600x600.jpg");
        mangquangcao.add("https://cdn.tgdd.vn/Products/Images/42/213033/iphone-12-pro-max-xanh-duong-new-600x600-600x600.jpg");
        mangquangcao.add("https://cdn.tgdd.vn/Products/Images/42/190325/iphone-xr-hopmoi-den-600x600-2-600x600.jpg");
        for (int i = 0 ; i < mangquangcao.size();i++){
            ImageView imageView = new ImageView(getApplicationContext());
            Picasso.with(getApplicationContext()).load(mangquangcao.get(i)).into(imageView);
            imageView.setScaleType(ImageView.ScaleType.FIT_XY);
            viewFlipper.addView(imageView);
        }
        viewFlipper.setFlipInterval(5000);
        viewFlipper.setAutoStart(true);

    }

    @SuppressLint("NewApi")
    private void ActionBarr() {
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbar.setNavigationIcon(android.R.drawable.ic_menu_sort_by_size);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                drawerLayout.openDrawer(GravityCompat.START);
            }
        });

    }
    private void Anhxa() {
    toolbar =  findViewById(R.id.ToobarManHinhChinh);
    viewFlipper = findViewById(R.id.ViewFlipperManHinhChinh);
    recyclerViewManHinhChinh =findViewById(R.id.RecyclerView);
    navigationView = findViewById(R.id.NavigationView);
    listViewManHinhChinh = findViewById(R.id.ListViewManHinhChinh);
    drawerLayout = findViewById(R.id.DrawerLayor);
    }






}