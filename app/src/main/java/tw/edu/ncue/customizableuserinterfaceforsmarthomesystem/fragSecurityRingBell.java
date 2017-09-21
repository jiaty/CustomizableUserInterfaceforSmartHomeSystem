package tw.edu.ncue.customizableuserinterfaceforsmarthomesystem;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.RadioGroup;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class fragSecurityRingBell extends Fragment {

    private RadioGroup mrg_securityRingBell;
    private ListView mlv_ringBellHistory;

    public fragSecurityRingBell() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = (View) inflater.inflate(R.layout.fragment_frag_security_ring_bell, container, false);
        String[] ringBellHistoryDate = {
                "2017/5/1",
                "2017/4/1",
                "2017/3/1",
                "2017/2/1",
                "2017/1/1",
                "2016/12/1"
        };
        String[] ringBellHistoryTime = {
                "12:00",
                "12:00",
                "12:00",
                "12:00",
                "12:00",
                "12:00"
        };
        List<Map<String, Object>> mList;
        mlv_ringBellHistory = (ListView) rootView.findViewById(R.id.lv_ringBellHistory);
        mList = new ArrayList<Map<String, Object>>();
        for(int i = 0; i < ringBellHistoryDate.length; i++){
            Map<String, Object> item = new HashMap<String, Object>();
            item.put("txv_lvNumber", ringBellHistoryDate[i]);
            item.put("txv_lvItem", ringBellHistoryTime[i]);
            mList.add(item);
        }
        SimpleAdapter arrAdapringBellHistory = new SimpleAdapter(
                getActivity(),
                mList,
                R.layout.lv_item_ring_bell_history,
                new String[] {"txv_lvNumber", "txv_lvItem"},
                new int[] {R.id.txv_lvNumber, R.id.txv_lvItem}
        );
        mlv_ringBellHistory.setAdapter(arrAdapringBellHistory);
        return rootView;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mrg_securityRingBell = (RadioGroup) getView().findViewById(R.id.rg_securityRingBell);
        mrg_securityRingBell.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.rb_safeGuard:
                        fragSecuritySafeGuard fragS = new fragSecuritySafeGuard();
                        FragmentTransaction fragTransS = getFragmentManager().beginTransaction();
                        fragTransS.replace(R.id.framlaySecurityRingBell, fragS);
                        fragTransS.commit();
                        //Toast.makeText(getActivity().getApplicationContext(), "0 rb_safeGuard", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.rb_ringBell:
                        fragSecurityRingBell fragSRB = new fragSecurityRingBell();
                        FragmentTransaction fragTransSRB = getFragmentManager().beginTransaction();
                        fragTransSRB.replace(R.id.framlaySecurityRingBell, fragSRB);
                        fragTransSRB.commit();
                        //Toast.makeText(getActivity().getApplicationContext(), "1 rb_ringBell", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.rb_monitor:
                        fragSecurityMonitor fragSM = new fragSecurityMonitor();
                        FragmentTransaction fragTransSM = getFragmentManager().beginTransaction();
                        fragTransSM.replace(R.id.framlaySecurityRingBell, fragSM);
                        fragTransSM.commit();
                        //Toast.makeText(getActivity().getApplicationContext(), "2 rb_monitor", Toast.LENGTH_SHORT).show();
                        break;
                }
            }
        });
    }
}
