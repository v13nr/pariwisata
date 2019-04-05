package com.nanangrustianto.pariwisata;

import android.content.BroadcastReceiver;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build;
import android.preference.PreferenceManager;
import android.provider.Settings;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.CoordinatorLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;

import com.nanangrustianto.pariwisata.activities.ActivityUserLogin;
import com.nanangrustianto.pariwisata.activities.MyApplication;
import com.nanangrustianto.pariwisata.models.User;
import com.nanangrustianto.pariwisata.utils.AppBarLayoutBehavior;
import com.nanangrustianto.pariwisata.utils.GDPR;

import retrofit2.Call;

public class MainActivity extends AppCompatActivity {


    private long exitTime = 0;
    MyApplication myApplication;
    private BottomNavigationView navigation;
    private ViewPager viewPager;
    private Toolbar toolbar;
    MenuItem prevMenuItem;
    int pager_number = 5;
    SharedPreferences preferences;
    BroadcastReceiver broadcastReceiver;
    View view;
    User user;
    String androidId;
    //private Call<CallbackUser> callbackCall = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Intent intentLogin = new Intent(this, ActivityUserLogin.class);
        startActivity(intentLogin);



        preferences = PreferenceManager.getDefaultSharedPreferences(getBaseContext());
        androidId = Settings.Secure.getString(getContentResolver(), Settings.Secure.ANDROID_ID);

        if (Config.ENABLE_RTL_MODE) {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR1) {
                getWindow().getDecorView().setLayoutDirection(View.LAYOUT_DIRECTION_RTL);
            }
        }

        GDPR.updateConsentStatus(this);

        AppBarLayout appBarLayout = findViewById(R.id.tab_appbar_layout);
        ((CoordinatorLayout.LayoutParams) appBarLayout.getLayoutParams()).setBehavior(new AppBarLayoutBehavior());

        myApplication = MyApplication.getInstance();

        toolbar = findViewById(R.id.toolbar);
        //setSupportActionBar(toolbar);
       // toolbar.setTitle(R.string.app_name);

    }
}
