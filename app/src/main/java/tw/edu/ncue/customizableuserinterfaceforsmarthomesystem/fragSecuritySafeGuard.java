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
import android.widget.CompoundButton;
import android.widget.RadioGroup;
import android.widget.Switch;
import android.widget.Toast;

public class fragSecuritySafeGuard extends Fragment {

    public int isClosed_rN1_window1 = 1;
    public int isClosed_rN1_window2 = 0;
    public int isClosed_rN2_window1 = 0;
    public int isClosed_rN3_window1 = 1;
    public int isClosed_rN3_window2 = 1;
    public int isClosed_rN4_window1 = 1;

    private Switch mswt_SecuOnOff2;
    private Button mbtn_rN1_window1;
    private Button mbtn_rN1_window2;
    private Button mbtn_rN2_window1;
    private Button mbtn_rN3_window1;
    private Button mbtn_rN3_window2;
    private Button mbtn_rN4_window1;
    private RadioGroup mrg_securitySafeGuard;

    public fragSecuritySafeGuard() {
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
        return inflater.inflate(R.layout.fragment_frag_security_safe_guard, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mswt_SecuOnOff2 = (Switch) getView().findViewById(R.id.swt_SecuOnOff2);
        mbtn_rN1_window1 = (Button) getView().findViewById(R.id.btn_rN1_window1);
        mbtn_rN1_window2 = (Button) getView().findViewById(R.id.btn_rN1_window2);
        mbtn_rN2_window1 = (Button) getView().findViewById(R.id.btn_rN2_window1);
        mbtn_rN3_window1 = (Button) getView().findViewById(R.id.btn_rN3_window1);
        mbtn_rN3_window2 = (Button) getView().findViewById(R.id.btn_rN3_window2);
        mbtn_rN4_window1 = (Button) getView().findViewById(R.id.btn_rN4_window1);
        mrg_securitySafeGuard = (RadioGroup) getView().findViewById(R.id.rg_securitySafeGuard);

        mswt_SecuOnOff2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    Toast t = Toast.makeText(getActivity().getApplicationContext(), "保全啟動\n所有門窗關閉", Toast.LENGTH_SHORT);
                    t.show();
                    isClosed_rN1_window1 = 1;
                    mbtn_rN1_window1.setText(R.string.rN1_window1_close);
                    mbtn_rN1_window1.setBackgroundResource(R.drawable.btn_pressed);
                    mbtn_rN1_window1.setTextColor(Color.parseColor("#ef404040"));
                    isClosed_rN1_window2 = 1;
                    mbtn_rN1_window2.setText(R.string.rN1_window2_close);
                    mbtn_rN1_window2.setBackgroundResource(R.drawable.btn_pressed);
                    mbtn_rN1_window2.setTextColor(Color.parseColor("#ef404040"));
                    isClosed_rN2_window1 = 1;
                    mbtn_rN2_window1.setText(R.string.rN2_window1_close);
                    mbtn_rN2_window1.setBackgroundResource(R.drawable.btn_pressed);
                    mbtn_rN2_window1.setTextColor(Color.parseColor("#ef404040"));
                    isClosed_rN3_window1 = 1;
                    mbtn_rN3_window1.setText(R.string.rN3_window1_close);
                    mbtn_rN3_window1.setBackgroundResource(R.drawable.btn_pressed);
                    mbtn_rN3_window1.setTextColor(Color.parseColor("#ef404040"));
                    isClosed_rN3_window2 = 1;
                    mbtn_rN3_window2.setText(R.string.rN3_window2_close);
                    mbtn_rN3_window2.setBackgroundResource(R.drawable.btn_pressed);
                    mbtn_rN3_window2.setTextColor(Color.parseColor("#ef404040"));
                    isClosed_rN4_window1 = 1;
                    mbtn_rN4_window1.setText(R.string.rN4_window1_close);
                    mbtn_rN4_window1.setBackgroundResource(R.drawable.btn_pressed);
                    mbtn_rN4_window1.setTextColor(Color.parseColor("#ef404040"));
                }
                else{
                    Toast t = Toast.makeText(getActivity().getApplicationContext(), R.string.toast_switch_off, Toast.LENGTH_SHORT);
                    t.show();
                }
            }
        });

        mrg_securitySafeGuard.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener(){
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch(checkedId){
                    case R.id.rb_safeGuard:
                        fragSecuritySafeGuard fragS = new fragSecuritySafeGuard();
                        FragmentTransaction fragTransS = getFragmentManager().beginTransaction();
                        fragTransS.replace(R.id.framlaySecuritySafeGuard, fragS);
                        fragTransS.commit();
                        //Toast.makeText(getActivity().getApplicationContext(), "0 rb_safeGuard", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.rb_ringBell:
                        fragSecurityRingBell fragSRB = new fragSecurityRingBell();
                        FragmentTransaction fragTransSRB = getFragmentManager().beginTransaction();
                        fragTransSRB.replace(R.id.framlaySecuritySafeGuard, fragSRB);
                        fragTransSRB.commit();
                        //Toast.makeText(getActivity().getApplicationContext(), "1 rb_ringBell", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.rb_monitor:
                        fragSecurityMonitor fragSM = new fragSecurityMonitor();
                        FragmentTransaction fragTransSM = getFragmentManager().beginTransaction();
                        fragTransSM.replace(R.id.framlaySecuritySafeGuard, fragSM);
                        fragTransSM.commit();
                        //Toast.makeText(getActivity().getApplicationContext(), "2 rb_monitor", Toast.LENGTH_SHORT).show();
                        break;
                }
            }
        });

        mbtn_rN1_window1.setOnClickListener(btn_rN1_window1OnClick);
        mbtn_rN1_window2.setOnClickListener(btn_rN1_window2OnClick);
        mbtn_rN2_window1.setOnClickListener(btn_rN2_window1OnClick);
        mbtn_rN3_window1.setOnClickListener(btn_rN3_window1OnClick);
        mbtn_rN3_window2.setOnClickListener(btn_rN3_window2OnClick);
        mbtn_rN4_window1.setOnClickListener(btn_rN4_window1OnClick);
    }

    private View.OnClickListener btn_rN1_window1OnClick = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if(isClosed_rN1_window1 == 1){
                isClosed_rN1_window1 = 0;
                mbtn_rN1_window1.setText(R.string.rN1_window1_open);
                mbtn_rN1_window1.setBackgroundResource(R.drawable.btn_transparent);
                mbtn_rN1_window1.setTextColor(Color.BLACK);
            }
            else {
                isClosed_rN1_window1 = 1;
                mbtn_rN1_window1.setText(R.string.rN1_window1_close);
                mbtn_rN1_window1.setBackgroundResource(R.drawable.btn_pressed);
                mbtn_rN1_window1.setTextColor(Color.parseColor("#ef404040"));
            }
        }
    };
    private View.OnClickListener btn_rN1_window2OnClick = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if(isClosed_rN1_window2 == 1){
                isClosed_rN1_window2 = 0;
                mbtn_rN1_window2.setText(R.string.rN1_window2_open);
                mbtn_rN1_window2.setBackgroundResource(R.drawable.btn_transparent);
                mbtn_rN1_window2.setTextColor(Color.BLACK);
            }
            else {
                isClosed_rN1_window2 = 1;
                mbtn_rN1_window2.setText(R.string.rN1_window2_close);
                mbtn_rN1_window2.setBackgroundResource(R.drawable.btn_pressed);
                mbtn_rN1_window2.setTextColor(Color.parseColor("#ef404040"));
            }
        }
    };
    private View.OnClickListener btn_rN2_window1OnClick = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if(isClosed_rN2_window1 == 1){
                isClosed_rN2_window1 = 0;
                mbtn_rN2_window1.setText(R.string.rN2_window1_open);
                mbtn_rN2_window1.setBackgroundResource(R.drawable.btn_transparent);
                mbtn_rN2_window1.setTextColor(Color.BLACK);
            }
            else {
                isClosed_rN2_window1 = 1;
                mbtn_rN2_window1.setText(R.string.rN2_window1_close);
                mbtn_rN2_window1.setBackgroundResource(R.drawable.btn_pressed);
                mbtn_rN2_window1.setTextColor(Color.parseColor("#ef404040"));
            }
        }
    };
    private View.OnClickListener btn_rN3_window1OnClick = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if(isClosed_rN3_window1 == 1){
                isClosed_rN3_window1 = 0;
                mbtn_rN3_window1.setText(R.string.rN3_window1_open);
                mbtn_rN3_window1.setBackgroundResource(R.drawable.btn_transparent);
                mbtn_rN3_window1.setTextColor(Color.BLACK);
            }
            else {
                isClosed_rN3_window1 = 1;
                mbtn_rN3_window1.setText(R.string.rN3_window1_close);
                mbtn_rN3_window1.setBackgroundResource(R.drawable.btn_pressed);
                mbtn_rN3_window1.setTextColor(Color.parseColor("#ef404040"));
            }
        }
    };
    private View.OnClickListener btn_rN3_window2OnClick = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if(isClosed_rN3_window2 == 1){
                isClosed_rN3_window2 = 0;
                mbtn_rN3_window2.setText(R.string.rN3_window2_open);
                mbtn_rN3_window2.setBackgroundResource(R.drawable.btn_transparent);
                mbtn_rN3_window2.setTextColor(Color.BLACK);
            }
            else {
                isClosed_rN3_window2 = 1;
                mbtn_rN3_window2.setText(R.string.rN3_window2_close);
                mbtn_rN3_window2.setBackgroundResource(R.drawable.btn_pressed);
                mbtn_rN3_window2.setTextColor(Color.parseColor("#ef404040"));
            }
        }
    };
    private View.OnClickListener btn_rN4_window1OnClick = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if(isClosed_rN4_window1 == 1){
                isClosed_rN4_window1 = 0;
                mbtn_rN4_window1.setText(R.string.rN4_window1_open);
                mbtn_rN4_window1.setBackgroundResource(R.drawable.btn_transparent);
                mbtn_rN4_window1.setTextColor(Color.BLACK);
            }
            else {
                isClosed_rN4_window1 = 1;
                mbtn_rN4_window1.setText(R.string.rN4_window1_close);
                mbtn_rN4_window1.setBackgroundResource(R.drawable.btn_pressed);
                mbtn_rN4_window1.setTextColor(Color.parseColor("#ef404040"));
            }
        }
    };

}
//      public int isClosed_ = 0;
//      public int isClosed_ = 1;
//      private Button mbtn_;
//       = (Button) getView().findViewById(R.id.);
//      .setOnClickListener(OnClick);
//    private View.OnClickListener  = new View.OnClickListener() {
//        @Override
//        public void onClick(View v) {
//            if(isClosed_ == 1){
//                isClosed_ = 0;
//                mbtn_.setText(R.string._open);
//                mbtn_.setBackgroundResource(R.drawable.btn_transparent);
//                mbtn_.setTextColor(Color.BLACK);
//            }
//            else {
//                isClosed_ = 1;
//                mbtn_.setText(R.string._close);
//                mbtn_.setBackgroundResource(R.drawable.btn_pressed);
//                mbtn_.setTextColor(Color.parseColor("#ef404040"));
//            }
//        }
//    };
