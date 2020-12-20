package vn.edu.usth.weather;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.view.Menu;
import android.view.MenuItem;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import androidx.appcompat.widget.Toolbar;

import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;

public class WeatherActivity extends AppCompatActivity {

    Toolbar toolbar;
    private static final String TAG = "WeatherActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weather);

        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("USTH Weather");

        Log.i(TAG, "onCreate: ");

        FragmentManager fragmentManager = getSupportFragmentManager();
        ForecastFragment firstFragment = new ForecastFragment();
        getSupportFragmentManager().beginTransaction().add(R.id.container, firstFragment).commit();

        PagerAdapter adapter = new HomeFragmentPagerAdapter(getSupportFragmentManager());
        ViewPager pager = (ViewPager) findViewById(R.id.pager);
        pager.setOffscreenPageLimit(3);
        pager.setAdapter(adapter);

        TabLayout tabLayout = (TabLayout) findViewById(R.id.tab);
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add("HANOI,VIETNAM");
        arrayList.add("PARIS,FRANCE");
        arrayList.add("TOULOUSE,FRANCE");
        tabLayout.setupWithViewPager(pager);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_weather, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        String msg = "";
        switch (item.getItemId()) {
            case R.id.action_refresh:
                msg = "Refreshing...";
                break;
            case R.id.action_setting:
                msg = "Setting";
                Intent intent = new Intent(this,PrefActivity.class);
                startActivity(intent);
                break;
            default:
                super.onOptionsItemSelected(item);
        }
        Toast.makeText(this,msg,Toast.LENGTH_LONG).show();
        return true;
    }


    @Override
    protected void onStart() {
        super.onStart();
        Log.i(TAG, "onStart: ");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i(TAG, "onResume: ");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i(TAG, "onPause: ");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i(TAG, "onStop: ");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i(TAG, "onDestroy: ");
    }

}

