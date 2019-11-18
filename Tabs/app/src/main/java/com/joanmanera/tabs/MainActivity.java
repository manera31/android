package com.joanmanera.tabs;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import com.google.android.material.tabs.TabLayout;
import com.joanmanera.tabs.fragments.FragmentAcceso;
import com.joanmanera.tabs.fragments.FragmentPersonal;
import com.joanmanera.tabs.fragments.FragmentProfesional;
import com.joanmanera.tabs.modelos.Empresa;
import com.joanmanera.tabs.modelos.Trabajador;
import com.joanmanera.tabs.modelos.Usuario;

public class MainActivity extends AppCompatActivity {

    private Trabajador trabajador;
    private ViewPager viewPager;
    private MiFragmentPageAdapter miFragmentPageAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        trabajador = new Trabajador("Joan", "Manera", "48758746B", "31/10/1999", "Callosa", new Usuario("joanmanera", "123"), new Empresa("IES 1 Xabia", 123456789, "Av Augusta", "ies1xabia.es", "ies1xabia@gmail.es"));

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        miFragmentPageAdapter = new MiFragmentPageAdapter(getSupportFragmentManager(), FragmentStatePagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);
        viewPager = findViewById(R.id.container);
        viewPager.setAdapter(miFragmentPageAdapter);

        TabLayout tabLayout = findViewById(R.id.tabs);
        tabLayout.setTabMode(TabLayout.MODE_FIXED);

        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
        tabLayout.addOnTabSelectedListener(new TabLayout.ViewPagerOnTabSelectedListener(viewPager));
    }

    public class MiFragmentPageAdapter extends FragmentPagerAdapter {
        private final int N_PAGES = 3;

        public MiFragmentPageAdapter(FragmentManager fm, int behavior) {
            super(fm, behavior);
        }

        @Override
        public Fragment getItem(int position) {
            Bundle args;
            switch (position){
                case 0:
                    FragmentPersonal fragmentPersonal = new FragmentPersonal();
                    args = new Bundle();
                    args.putSerializable(FragmentPersonal.PLACEHOLDER_TAB1, trabajador);
                    fragmentPersonal.setArguments(args);
                    return fragmentPersonal;
                case 1:
                    FragmentProfesional fragmentProfesional = new FragmentProfesional();
                    args = new Bundle();
                    args.putSerializable(FragmentProfesional.PLACEHOLDER_TAB2, trabajador);
                    fragmentProfesional.setArguments(args);
                    return fragmentProfesional;
                case 2:
                    FragmentAcceso fragmentAcceso = new FragmentAcceso();
                    args = new Bundle();
                    args.putSerializable(FragmentAcceso.PLACEHOLDER_TAB3, trabajador);
                    fragmentAcceso.setArguments(args);
                    return fragmentAcceso;
            }
            return null;
        }

        @Override
        public int getCount() {
            return N_PAGES;
        }
    }
}
