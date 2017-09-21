package tw.edu.ncue.customizableuserinterfaceforsmarthomesystem;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity{
    SectionsPagerAdapter mSectionsPagerAdapter;
    ViewPager mViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());
        mViewPager = (ViewPager) findViewById(R.id.viewPager);
        mViewPager.setAdapter(mSectionsPagerAdapter);
        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabLayout);
        tabLayout.setupWithViewPager(mViewPager);
    }

    private class SectionsPagerAdapter extends FragmentPagerAdapter {

        public SectionsPagerAdapter(FragmentManager fm) {super(fm);}

        @Override
        public Fragment getItem(int position) {
            Fragment fragment = null;
            //根據目前tab標籤頁的位置，傳回對應的fragment物件
            switch (position) {
                case 0:
                    fragment = new fragHome();
                    break;
                case 1:
                    fragment = new fragSecuritySafeGuard();
                    break;
                case 2:
                    fragment = new fragControlScenario();
                    break;
                case 3:
                    fragment = new fragCommunityBillboard();
                    break;
                case 4:
                    fragment = new fragSetUpRoomNumberSetUp();
                    break;
            }
            return fragment;
        }

        @Override
        public int getCount() {
            return 5;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            switch (position) {
                case 0:
                    return "主頁";
                case 1:
                    return "安全";
                case 2:
                    return "居家控制";
                case 3:
                    return "社區";
                case 4:
                    return "設定";
                default:
                    return null;
            }
        }
    }
}
