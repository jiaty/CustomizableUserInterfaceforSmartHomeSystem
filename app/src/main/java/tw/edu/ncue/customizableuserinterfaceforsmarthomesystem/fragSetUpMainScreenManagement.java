package tw.edu.ncue.customizableuserinterfaceforsmarthomesystem;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioGroup;
import android.widget.Toast;

public class fragSetUpMainScreenManagement extends Fragment {

    private RadioGroup mrg_SetUpMainScreenManagement;

    public fragSetUpMainScreenManagement() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_frag_set_up_main_screen_management, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mrg_SetUpMainScreenManagement = (RadioGroup) getView().findViewById(R.id.rg_SetUpMainScreenManagement);
        mrg_SetUpMainScreenManagement.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener(){
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch(checkedId){
                    case R.id.rb_roomNumberSetUp:
                        fragSetUpRoomNumberSetUp fragSRN = new fragSetUpRoomNumberSetUp();
                        FragmentTransaction fragTransSRN = getFragmentManager().beginTransaction();
                        fragTransSRN.replace(R.id.framlaySetUpMainScreenManagement, fragSRN);
                        fragTransSRN.commit();
                        //Toast.makeText(getActivity().getApplicationContext(), "0 rb_roomNumberSetUp", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.rb_rightsSetUp:
                        fragSetUpRightsSetUp fragSR = new fragSetUpRightsSetUp();
                        FragmentTransaction fragTransSR = getFragmentManager().beginTransaction();
                        fragTransSR.replace(R.id.framlaySetUpMainScreenManagement, fragSR);
                        fragTransSR.commit();
                        //Toast.makeText(getActivity().getApplicationContext(), "1 rb_rightsSetUp", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.rb_mainScreenManagement:
                        fragSetUpMainScreenManagement fragSM = new fragSetUpMainScreenManagement();
                        FragmentTransaction fragTransSM = getFragmentManager().beginTransaction();
                        fragTransSM.replace(R.id.framlaySetUpMainScreenManagement, fragSM);
                        fragTransSM.commit();
                        //Toast.makeText(getActivity().getApplicationContext(), "2 rb_mainScreenManagement", Toast.LENGTH_SHORT).show();
                        break;
                }
            }
        });
    }
}
