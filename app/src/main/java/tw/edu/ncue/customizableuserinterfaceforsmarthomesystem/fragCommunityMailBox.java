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

public class fragCommunityMailBox extends Fragment {

    private RadioGroup mrg_communityMailBox;

    public fragCommunityMailBox() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_frag_community_mail_box, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mrg_communityMailBox = (RadioGroup) getView().findViewById(R.id.rg_communityMailBox);
        mrg_communityMailBox.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener(){
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch(checkedId){
                    case R.id.rb_mailBox:
                        fragCommunityMailBox fragCM = new fragCommunityMailBox();
                        FragmentTransaction fragTransCM = getFragmentManager().beginTransaction();
                        fragTransCM.replace(R.id.framlayCommunityMailBox, fragCM);
                        fragTransCM.commit();
                        //Toast.makeText(getActivity().getApplicationContext(), "0 rb_mailBox", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.rb_billboard:
                        fragCommunityBillboard fragCB = new fragCommunityBillboard();
                        FragmentTransaction fragTransCB = getFragmentManager().beginTransaction();
                        fragTransCB.replace(R.id.framlayCommunityMailBox, fragCB);
                        fragTransCB.commit();
                        //Toast.makeText(getActivity().getApplicationContext(), "1 rb_billboard", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.rb_contactManagementRoom:
                        fragCommunityContactManagementRoom fragCC = new fragCommunityContactManagementRoom();
                        FragmentTransaction fragTransCC = getFragmentManager().beginTransaction();
                        fragTransCC.replace(R.id.framlayCommunityMailBox, fragCC);
                        fragTransCC.commit();
                        //Toast.makeText(getActivity().getApplicationContext(), "2 rb_contactManagementRoom", Toast.LENGTH_SHORT).show();
                        break;
                }
            }
        });
    }
}
