package tw.edu.ncue.customizableuserinterfaceforsmarthomesystem;


import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RadioGroup;

public class fragSecurityMonitor extends Fragment {

    private RadioGroup mrg_securityMonitor;

    public fragSecurityMonitor() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_frag_security_monitor, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        mrg_securityMonitor = (RadioGroup) getView().findViewById(R.id.rg_securityMonitor);
        mrg_securityMonitor.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener(){
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch(checkedId){
                    case R.id.rb_safeGuard:
                        fragSecuritySafeGuard fragS = new fragSecuritySafeGuard();
                        FragmentTransaction fragTransS = getFragmentManager().beginTransaction();
                        fragTransS.replace(R.id.framlaySecurityMonitor, fragS);
                        fragTransS.commit();
                        //Toast.makeText(getActivity().getApplicationContext(), "0 rb_safeGuard", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.rb_ringBell:
                        fragSecurityRingBell fragSRB = new fragSecurityRingBell();
                        FragmentTransaction fragTransSRB = getFragmentManager().beginTransaction();
                        fragTransSRB.replace(R.id.framlaySecurityMonitor, fragSRB);
                        fragTransSRB.commit();
                        //Toast.makeText(getActivity().getApplicationContext(), "1 rb_ringBell", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.rb_monitor:
                        fragSecurityMonitor fragSM = new fragSecurityMonitor();
                        FragmentTransaction fragTransSM = getFragmentManager().beginTransaction();
                        fragTransSM.replace(R.id.framlaySecurityMonitor, fragSM);
                        fragTransSM.commit();
                        //Toast.makeText(getActivity().getApplicationContext(), "2 rb_monitor", Toast.LENGTH_SHORT).show();
                        break;
                }
            }
        });
    }
}
