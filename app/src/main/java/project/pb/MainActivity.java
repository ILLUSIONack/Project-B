package project.pb;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.os.Build;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import project.pb.fragments.ContactPageFragment;
import project.pb.fragments.FAQFragment;
import project.pb.fragments.HomeScreenFragment;
import project.pb.fragments.QuizFragment;
import project.pb.fragments.SettingsFragment;
import project.pb.fragments.SettlementFragment;
import project.pb.fragments.SharedPref;
import project.pb.fragments.StudyPageFragment;
import project.pb.hints.HintExecutor;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    private SharedPref sharedPref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initializeChannels();
        sharedPref = new SharedPref(getApplicationContext());
        if (sharedPref.getNotificationState()) {
            HintExecutor.start(this);
        }
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                new HomeScreenFragment()).commit();

        navigationView.setCheckedItem(R.id.nav_home_screen);

    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    /**
     * Fetches what menu id is being pressed and executes the clicked item
     * @param item
     * @return
     */
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        int id = item.getItemId();
        switch (id) {
            case R.id.nav_home_screen:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new HomeScreenFragment()).commit();
                break;
            case R.id.nav_studies:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                       new StudyPageFragment()).commit();
                break;
            case R.id.nav_settlement:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new SettlementFragment()).commit();
                break;
            case R.id.nav_askedquestions:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new FAQFragment()).commit();
                break;
            case R.id.nav_contact_page:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new ContactPageFragment()).commit();
                break;
            case R.id.nav_settings:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new SettingsFragment()).commit();
                break;
            case R.id.nav_quiz:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new QuizFragment()).commit();
                break;
        }

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    private void initializeChannels() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            NotificationChannel notificationChannel =
                    new NotificationChannel("main_channel", "main_channel",
                            NotificationManager.IMPORTANCE_HIGH);
            NotificationManager notificationManager = getSystemService(NotificationManager.class);
            notificationManager.createNotificationChannel(notificationChannel);

        }
    }

}