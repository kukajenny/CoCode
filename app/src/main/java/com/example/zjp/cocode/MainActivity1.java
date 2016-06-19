package com.example.zjp.cocode;


import android.graphics.Color;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.aurelhubert.ahbottomnavigation.AHBottomNavigation;
import com.aurelhubert.ahbottomnavigation.AHBottomNavigationItem;
import com.example.zjp.cocode.ui.menu_fragment.HomeFragment;
import com.example.zjp.cocode.ui.menu_fragment.MeFragment;
import com.example.zjp.cocode.ui.menu_fragment.MessageFragment;
import com.example.zjp.cocode.ui.menu_fragment.TypeFragment;

public class MainActivity1 extends FragmentActivity{

    private AHBottomNavigation bottomNavigation;
    private Fragment homeFragment;
    private Fragment typeFragment;
    private Fragment messageFragment;
    private Fragment meFragment;
    private FragmentTransaction transaction;
    private FragmentManager fragmentManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initview();
        setDefaultFragment();
    }
    public void initview(){

        bottomNavigation = (AHBottomNavigation) findViewById(R.id.bottom_navigation);
        setBottomNavigation();
        transaction = getSupportFragmentManager().beginTransaction();


    }

    private void setDefaultFragment()
    {

        homeFragment = new HomeFragment();
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.id_content, homeFragment).commit();

    }

    public void setBottomNavigation(){



// Create items
        AHBottomNavigationItem item1 = new AHBottomNavigationItem(R.string.tab_1, R.mipmap.tab_home_normal, R.color.color_tab_1);
        AHBottomNavigationItem item2 = new AHBottomNavigationItem(R.string.tab_2, R.mipmap.tab_type_normal, R.color.color_tab_2);
        AHBottomNavigationItem item3 = new AHBottomNavigationItem(R.string.tab_3, R.mipmap.tab_message_normal, R.color.color_tab_3);
        AHBottomNavigationItem item4 = new AHBottomNavigationItem(R.string.tab_4, R.mipmap.tab_me_normal, R.color.color_tab_4);
// Add items
        bottomNavigation.addItem(item1);
        bottomNavigation.addItem(item2);
        bottomNavigation.addItem(item3);
        bottomNavigation.addItem(item4);

// Set background color
        bottomNavigation.setDefaultBackgroundColor(Color.parseColor("#FEFEFE"));

// Disable the translation inside the CoordinatorLayout
        bottomNavigation.setBehaviorTranslationEnabled(false);

// Change colors
        bottomNavigation.setAccentColor(Color.parseColor("#F63D2B"));
        bottomNavigation.setInactiveColor(Color.parseColor("#747474"));

// Force to tint the drawable (useful for font with icon for example)
        bottomNavigation.setForceTint(true);

// Force the titles to be displayed (against Material Design guidelines!)
        bottomNavigation.setForceTitlesDisplay(false);

// Use colored navigation with circle reveal effect
        bottomNavigation.setColored(false);

// Set current item programmatically
        bottomNavigation.setCurrentItem(0);

// Customize notification (title, background, typeface)
        bottomNavigation.setNotificationBackgroundColor(Color.parseColor("#F63D2B"));

// Add or remove notification for each item
        bottomNavigation.setNotification("4", 1);
        bottomNavigation.setNotification("", 1);

// Set listener
        bottomNavigation.setOnTabSelectedListener(new AHBottomNavigation.OnTabSelectedListener() {
            @Override
            public boolean onTabSelected(int position, boolean wasSelected) {
                // 开启Fragment事务

                transaction = getSupportFragmentManager().beginTransaction();

                switch (position){
                    case 0:
                        if(homeFragment==null){
                            homeFragment = new HomeFragment();
                         }
                        transaction.replace(R.id.id_content, homeFragment);
                        break;
                    case 1:
                        if(typeFragment==null) {
                            typeFragment = new TypeFragment();
                        }
                        transaction.replace(R.id.id_content, typeFragment);
                        break;
                    case 2:
                        if(messageFragment==null) {
                            messageFragment = new MessageFragment();
                        }
                        transaction.replace(R.id.id_content, messageFragment);
                        break;
                    case 3:
                        if(meFragment==null){
                            meFragment = new MeFragment();
                        }
                        transaction.replace(R.id.id_content, meFragment);
                        break;
                }
                transaction.commit();
                return true;
            }
        });
    }
}
