package gss.guru.loginnormal.ui.main;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;



import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.EActivity;

import gss.guru.loginnormal.R;

@EActivity(R.layout.activity_main)
public class MainActivity extends AppCompatActivity {

//
//    @ViewById DrawerLayout drawer_layout;
//    @ViewById FloatingActionButton fab;
//    @ViewById Toolbar toolbar;
//    @ViewById NavigationView nav_view;
//    @ViewById FrameLayout fl_fragment_conteiner;
//    @ViewById CoordinatorLayout cl_main;
//
//    @ViewById ImageButton settingsButton;
//
////    @Click({R.id.settingsButton})
////    void settingsButton() {
////        drawer_layout.closeDrawers();
////
////    }
//
//    @Click({R.id.btn_login})
//    void btn_login() {
//        Snackbar.make(fab, "Replace with your own action", Snackbar.LENGTH_LONG).setAction("Action", null).show();
//    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @AfterViews
    void bindViews() {
//        setSupportActionBar(toolbar);
//        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawer_layout, null, R.string.app_name, R.string.app_name) {
//            public void onDrawerClosed(View view) {
//                supportInvalidateOptionsMenu();
//            }
//            public void onDrawerOpened(View drawerView) {
//                supportInvalidateOptionsMenu();
//            }
//            @Override
//            public void onDrawerSlide( View drawerView, float slideOffset) {
//                super.onDrawerSlide(drawerView, slideOffset);
//                cl_main.setTranslationX(slideOffset * drawerView.getWidth());
//                drawer_layout.bringChildToFront(drawerView);
//                drawer_layout.requestLayout();
//            }
//        };
//        drawer_layout.addDrawerListener(toggle);
//        toggle.syncState();
//
//        nav_view.setNavigationItemSelectedListener(this);
//
//        toolbar.setNavigationIcon(R.drawable.ic_menu);
//        toolbar.setNavigationOnClickListener(view -> drawer_layout.openDrawer(GravityCompat.START));
//
//        settingsButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                startActivity(new Intent(MainActivity.this, SettingsActivity_.class));
//            }
//        });
    }

//    @Override
//    public void onBackPressed() {
//        if (drawer_layout.isDrawerOpen(GravityCompat.START)) {
//            drawer_layout.closeDrawer(GravityCompat.START);
//        } else {
//            super.onBackPressed();
//        }
//    }

//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        getMenuInflater().inflate(R.menu.menu_main, menu);
//        return true;
//    }
//
//    @Override
//    public boolean onOptionsItemSelected(MenuItem item) {
//        int id = item.getItemId();
//        if (id == R.id.action_select_shop) {
//            return true;
//        }
//        return super.onOptionsItemSelected(item);
//    }
//
//    @SuppressWarnings("StatementWithEmptyBody")
//    @Override
//    public boolean onNavigationItemSelected(MenuItem item) {
//        int id = item.getItemId();
//
//        if (id == R.id.nav_indicators) {
//            // Handle the camera action
//        } else if (id == R.id.nav_call_support) {
//
//        }
//        drawer_layout.closeDrawer(GravityCompat.START);
//        return true;
//    }
}
