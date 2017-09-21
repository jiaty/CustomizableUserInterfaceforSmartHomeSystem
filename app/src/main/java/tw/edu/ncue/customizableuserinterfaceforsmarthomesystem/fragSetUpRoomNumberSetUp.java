package tw.edu.ncue.customizableuserinterfaceforsmarthomesystem;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.RadioGroup;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class fragSetUpRoomNumberSetUp extends Fragment {

    private RadioGroup mrg_SetUpRoomNumberSetUp;
    private ListView mlv_roomNumber;

    public fragSetUpRoomNumberSetUp() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = (View) inflater.inflate(R.layout.fragment_frag_set_up_room_number_set_up, container, false);
        String[] roomRumberNameList = {
                "客廳",
                "廚房",
                "主臥",
                "客房"
        };
        String[] roomRumberList = {
                "房間1",
                "房間2",
                "房間3",
                "房間4"
        };
        List<Map<String, Object>> mList;
        mlv_roomNumber = (ListView) rootView.findViewById(R.id.lv_roomNumber);
        mList = new ArrayList<Map<String, Object>>();
        for(int i = 0; i < roomRumberList.length; i++){
            Map<String, Object> item = new HashMap<String, Object>();
            item.put("txv_lvNumber", roomRumberList[i]);
            item.put("txv_lvItem", roomRumberNameList[i]);
            mList.add(item);
        }
        SimpleAdapter arrAdapRoomNumber = new SimpleAdapter(
                getActivity(),
                mList,
                R.layout.lv_item_room_number,
                new String[] {"txv_lvNumber", "txv_lvItem"},
                new int[] {R.id.txv_lvNumber, R.id.txv_lvItem}
        );
        mlv_roomNumber.setAdapter(arrAdapRoomNumber);
        return rootView;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mrg_SetUpRoomNumberSetUp = (RadioGroup) getView().findViewById(R.id.rg_SetUpRoomNumberSetUp);
        mrg_SetUpRoomNumberSetUp.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener(){
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch(checkedId){
                    case R.id.rb_roomNumberSetUp:
                        fragSetUpRoomNumberSetUp fragSRN = new fragSetUpRoomNumberSetUp();
                        FragmentTransaction fragTransSRN = getFragmentManager().beginTransaction();
                        fragTransSRN.replace(R.id.framlaySetUpRoomNumberSetUp, fragSRN);
                        fragTransSRN.commit();
                        //Toast.makeText(getActivity().getApplicationContext(), "0 rb_roomNumberSetUp", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.rb_rightsSetUp:
                        fragSetUpRightsSetUp fragSR = new fragSetUpRightsSetUp();
                        FragmentTransaction fragTransSR = getFragmentManager().beginTransaction();
                        fragTransSR.replace(R.id.framlaySetUpRoomNumberSetUp, fragSR);
                        fragTransSR.commit();
                        //Toast.makeText(getActivity().getApplicationContext(), "1 rb_rightsSetUp", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.rb_mainScreenManagement:
                        fragSetUpMainScreenManagement fragSM = new fragSetUpMainScreenManagement();
                        FragmentTransaction fragTransSM = getFragmentManager().beginTransaction();
                        fragTransSM.replace(R.id.framlaySetUpRoomNumberSetUp, fragSM);
                        fragTransSM.commit();
                        //Toast.makeText(getActivity().getApplicationContext(), "2 rb_mainScreenManagement", Toast.LENGTH_SHORT).show();
                        break;
                }
            }
        });
    }
}
