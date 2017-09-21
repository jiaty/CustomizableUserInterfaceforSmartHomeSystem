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
import android.widget.Toast;

public class fragControlLights extends Fragment {
    public int isClosed_rN1_m1_lights = 1;
    public int isClosed_rN1_m2_lights = 0;
    public int isClosed_rN1_m3_lights = 0;
    public int isClosed_rN1_m4_lights = 1;
    public int isClosed_rN1_m5_lights = 0;
    public int isClosed_rN1_m6_lights = 0;
    public int isClosed_rN1_m7_lights = 1;
    public int isClosed_rN2_m1_lights = 1;
    public int isClosed_rN3_m1_lights = 0;
    public int isClosed_rN3_m2_lights = 1;
    public int isClosed_rN3_m3_lights = 0;
    public int isClosed_rN4_m1_lights = 1;
    public int isClosed_rN4_m2_lights = 0;
    private Button mbtn_rN1_m1_lights;
    private Button mbtn_rN1_m2_lights;
    private Button mbtn_rN1_m3_lights;
    private Button mbtn_rN1_m4_lights;
    private Button mbtn_rN1_m5_lights;
    private Button mbtn_rN1_m6_lights;
    private Button mbtn_rN1_m7_lights;
    private Button mbtn_rN2_m1_lights;
    private Button mbtn_rN3_m1_lights;
    private Button mbtn_rN3_m2_lights;
    private Button mbtn_rN3_m3_lights;
    private Button mbtn_rN4_m1_lights;
    private Button mbtn_rN4_m2_lights;
    private RadioGroup mrg_controlLights;

    public fragControlLights() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_frag_control_lights, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mbtn_rN1_m1_lights = (Button) getView().findViewById(R.id.btn_rN1_m1_lights);
        mbtn_rN1_m2_lights = (Button) getView().findViewById(R.id.btn_rN1_m2_lights);
        mbtn_rN1_m3_lights = (Button) getView().findViewById(R.id.btn_rN1_m3_lights);
        mbtn_rN1_m4_lights = (Button) getView().findViewById(R.id.btn_rN1_m4_lights);
        mbtn_rN1_m5_lights = (Button) getView().findViewById(R.id.btn_rN1_m5_lights);
        mbtn_rN1_m6_lights = (Button) getView().findViewById(R.id.btn_rN1_m6_lights);
        mbtn_rN1_m7_lights = (Button) getView().findViewById(R.id.btn_rN1_m7_lights);
        mbtn_rN2_m1_lights = (Button) getView().findViewById(R.id.btn_rN2_m1_lights);
        mbtn_rN3_m1_lights = (Button) getView().findViewById(R.id.btn_rN3_m1_lights);
        mbtn_rN3_m2_lights = (Button) getView().findViewById(R.id.btn_rN3_m2_lights);
        mbtn_rN3_m3_lights = (Button) getView().findViewById(R.id.btn_rN3_m3_lights);
        mbtn_rN4_m1_lights = (Button) getView().findViewById(R.id.btn_rN4_m1_lights);
        mbtn_rN4_m2_lights = (Button) getView().findViewById(R.id.btn_rN4_m2_lights);
        mrg_controlLights = (RadioGroup) getView().findViewById(R.id.rg_controlLights);
        mrg_controlLights.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener(){
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch(checkedId){
                    case R.id.rb_scenario:
                        fragControlScenario fragCS = new fragControlScenario();
                        FragmentTransaction fragTransCS = getFragmentManager().beginTransaction();
                        fragTransCS.replace(R.id.framlayControlLights, fragCS);
                        fragTransCS.commit();
                        //Toast.makeText(getActivity().getApplicationContext(), "0 rb_scenario", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.rb_curtain:
                        fragControlCurtain fragCC = new fragControlCurtain();
                        FragmentTransaction fragTransCC = getFragmentManager().beginTransaction();
                        fragTransCC.replace(R.id.framlayControlLights, fragCC);
                        fragTransCC.commit();
                        //Toast.makeText(getActivity().getApplicationContext(), "1 rb_curtain", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.rb_lights:
                        fragControlLights fragCL = new fragControlLights();
                        FragmentTransaction fragTransCL = getFragmentManager().beginTransaction();
                        fragTransCL.replace(R.id.framlayControlLights, fragCL);
                        fragTransCL.commit();
                        //Toast.makeText(getActivity().getApplicationContext(), "2 rb_lights", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.rb_airConditioning:
                        fragControlAirConditioning fragCA = new fragControlAirConditioning();
                        FragmentTransaction fragTransCA = getFragmentManager().beginTransaction();
                        fragTransCA.replace(R.id.framlayControlLights, fragCA);
                        fragTransCA.commit();
                        //Toast.makeText(getActivity().getApplicationContext(), "3 rb_airConditioning", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.rb_elevator:
                        fragControlElevator fragCE = new fragControlElevator();
                        FragmentTransaction fragTransCE = getFragmentManager().beginTransaction();
                        fragTransCE.replace(R.id.framlayControlLights, fragCE);
                        fragTransCE.commit();
                        //Toast.makeText(getActivity().getApplicationContext(), "4 rb_elevator", Toast.LENGTH_SHORT).show();
                        break;
                }
            }
        });
        mbtn_rN1_m1_lights.setOnClickListener(btn_rN1_m1_lightsOnClick);
        mbtn_rN1_m2_lights.setOnClickListener(btn_rN1_m2_lightsOnClick);
        mbtn_rN1_m3_lights.setOnClickListener(btn_rN1_m3_lightsOnClick);
        mbtn_rN1_m4_lights.setOnClickListener(btn_rN1_m4_lightsOnClick);
        mbtn_rN1_m5_lights.setOnClickListener(btn_rN1_m5_lightsOnClick);
        mbtn_rN1_m6_lights.setOnClickListener(btn_rN1_m6_lightsOnClick);
        mbtn_rN1_m7_lights.setOnClickListener(btn_rN1_m7_lightsOnClick);
        mbtn_rN2_m1_lights.setOnClickListener(btn_rN2_m1_lightsOnClick);
        mbtn_rN3_m1_lights.setOnClickListener(btn_rN3_m1_lightsOnClick);
        mbtn_rN3_m2_lights.setOnClickListener(btn_rN3_m2_lightsOnClick);
        mbtn_rN3_m3_lights.setOnClickListener(btn_rN3_m3_lightsOnClick);
        mbtn_rN4_m1_lights.setOnClickListener(btn_rN4_m1_lightsOnClick);
        mbtn_rN4_m2_lights.setOnClickListener(btn_rN4_m2_lightsOnClick);
    }
    private View.OnClickListener btn_rN1_m1_lightsOnClick = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if(isClosed_rN1_m1_lights == 1){
                isClosed_rN1_m1_lights = 0;
                mbtn_rN1_m1_lights.setText(R.string.rN1_m1_lights_open);
                mbtn_rN1_m1_lights.setBackgroundResource(R.drawable.btn_lights_on);
                mbtn_rN1_m1_lights.setTextColor(Color.BLACK);
            }
            else {
                isClosed_rN1_m1_lights = 1;
                mbtn_rN1_m1_lights.setText(R.string.rN1_m1_lights_close);
                mbtn_rN1_m1_lights.setBackgroundResource(R.drawable.btn_lights_off);
                mbtn_rN1_m1_lights.setTextColor(Color.parseColor("#ef404040"));
            }
        }
    };
    private View.OnClickListener btn_rN1_m2_lightsOnClick = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if(isClosed_rN1_m2_lights == 1){
                isClosed_rN1_m2_lights = 0;
                mbtn_rN1_m2_lights.setText(R.string.rN1_m2_lights_open);
                mbtn_rN1_m2_lights.setBackgroundResource(R.drawable.btn_lights_on);
                mbtn_rN1_m2_lights.setTextColor(Color.BLACK);
            }
            else {
                isClosed_rN1_m2_lights = 1;
                mbtn_rN1_m2_lights.setText(R.string.rN1_m2_lights_close);
                mbtn_rN1_m2_lights.setBackgroundResource(R.drawable.btn_lights_off);
                mbtn_rN1_m2_lights.setTextColor(Color.parseColor("#ef404040"));
            }
        }
    };
    private View.OnClickListener btn_rN1_m3_lightsOnClick = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if(isClosed_rN1_m3_lights == 1){
                isClosed_rN1_m3_lights = 0;
                mbtn_rN1_m3_lights.setText(R.string.rN1_m3_lights_open);
                mbtn_rN1_m3_lights.setBackgroundResource(R.drawable.btn_lights_on);
                mbtn_rN1_m3_lights.setTextColor(Color.BLACK);
            }
            else {
                isClosed_rN1_m3_lights = 1;
                mbtn_rN1_m3_lights.setText(R.string.rN1_m3_lights_close);
                mbtn_rN1_m3_lights.setBackgroundResource(R.drawable.btn_lights_off);
                mbtn_rN1_m3_lights.setTextColor(Color.parseColor("#ef404040"));
            }
        }
    };
    private View.OnClickListener btn_rN1_m4_lightsOnClick = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if(isClosed_rN1_m4_lights == 1){
                isClosed_rN1_m4_lights = 0;
                mbtn_rN1_m4_lights.setText(R.string.rN1_m4_lights_open);
                mbtn_rN1_m4_lights.setBackgroundResource(R.drawable.btn_lights_on);
                mbtn_rN1_m4_lights.setTextColor(Color.BLACK);
            }
            else {
                isClosed_rN1_m4_lights = 1;
                mbtn_rN1_m4_lights.setText(R.string.rN1_m4_lights_close);
                mbtn_rN1_m4_lights.setBackgroundResource(R.drawable.btn_lights_off);
                mbtn_rN1_m4_lights.setTextColor(Color.parseColor("#ef404040"));
            }
        }
    };
    private View.OnClickListener btn_rN1_m5_lightsOnClick = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if(isClosed_rN1_m5_lights == 1){
                isClosed_rN1_m5_lights = 0;
                mbtn_rN1_m5_lights.setText(R.string.rN1_m5_lights_open);
                mbtn_rN1_m5_lights.setBackgroundResource(R.drawable.btn_lights_on);
                mbtn_rN1_m5_lights.setTextColor(Color.BLACK);
            }
            else {
                isClosed_rN1_m5_lights = 1;
                mbtn_rN1_m5_lights.setText(R.string.rN1_m5_lights_close);
                mbtn_rN1_m5_lights.setBackgroundResource(R.drawable.btn_lights_off);
                mbtn_rN1_m5_lights.setTextColor(Color.parseColor("#ef404040"));
            }
        }
    };
    private View.OnClickListener btn_rN1_m6_lightsOnClick = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if(isClosed_rN1_m6_lights == 1){
                isClosed_rN1_m6_lights = 0;
                mbtn_rN1_m6_lights.setText(R.string.rN1_m6_lights_open);
                mbtn_rN1_m6_lights.setBackgroundResource(R.drawable.btn_lights_on);
                mbtn_rN1_m6_lights.setTextColor(Color.BLACK);
            }
            else {
                isClosed_rN1_m6_lights = 1;
                mbtn_rN1_m6_lights.setText(R.string.rN1_m6_lights_close);
                mbtn_rN1_m6_lights.setBackgroundResource(R.drawable.btn_lights_off);
                mbtn_rN1_m6_lights.setTextColor(Color.parseColor("#ef404040"));
            }
        }
    };
    private View.OnClickListener btn_rN1_m7_lightsOnClick = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if(isClosed_rN1_m7_lights == 1){
                isClosed_rN1_m7_lights = 0;
                mbtn_rN1_m7_lights.setText(R.string.rN1_m7_lights_open);
                mbtn_rN1_m7_lights.setBackgroundResource(R.drawable.btn_lights_on);
                mbtn_rN1_m7_lights.setTextColor(Color.BLACK);
            }
            else {
                isClosed_rN1_m7_lights = 1;
                mbtn_rN1_m7_lights.setText(R.string.rN1_m7_lights_close);
                mbtn_rN1_m7_lights.setBackgroundResource(R.drawable.btn_lights_off);
                mbtn_rN1_m7_lights.setTextColor(Color.parseColor("#ef404040"));
            }
        }
    };
    private View.OnClickListener btn_rN2_m1_lightsOnClick = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if(isClosed_rN2_m1_lights == 1){
                isClosed_rN2_m1_lights = 0;
                mbtn_rN2_m1_lights.setText(R.string.rN2_m1_lights_open);
                mbtn_rN2_m1_lights.setBackgroundResource(R.drawable.btn_lights_on);
                mbtn_rN2_m1_lights.setTextColor(Color.BLACK);
            }
            else {
                isClosed_rN2_m1_lights = 1;
                mbtn_rN2_m1_lights.setText(R.string.rN2_m1_lights_close);
                mbtn_rN2_m1_lights.setBackgroundResource(R.drawable.btn_lights_off);
                mbtn_rN2_m1_lights.setTextColor(Color.parseColor("#ef404040"));
            }
        }
    };
    private View.OnClickListener btn_rN3_m1_lightsOnClick = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if(isClosed_rN3_m1_lights == 1){
                isClosed_rN3_m1_lights = 0;
                mbtn_rN3_m1_lights.setText(R.string.rN3_m1_lights_open);
                mbtn_rN3_m1_lights.setBackgroundResource(R.drawable.btn_lights_on);
                mbtn_rN3_m1_lights.setTextColor(Color.BLACK);
            }
            else {
                isClosed_rN3_m1_lights = 1;
                mbtn_rN3_m1_lights.setText(R.string.rN3_m1_lights_close);
                mbtn_rN3_m1_lights.setBackgroundResource(R.drawable.btn_lights_off);
                mbtn_rN3_m1_lights.setTextColor(Color.parseColor("#ef404040"));
            }
        }
    };
    private View.OnClickListener btn_rN3_m2_lightsOnClick = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if(isClosed_rN3_m2_lights == 1){
                isClosed_rN3_m2_lights = 0;
                mbtn_rN3_m2_lights.setText(R.string.rN3_m2_lights_open);
                mbtn_rN3_m2_lights.setBackgroundResource(R.drawable.btn_lights_on);
                mbtn_rN3_m2_lights.setTextColor(Color.BLACK);
            }
            else {
                isClosed_rN3_m2_lights = 1;
                mbtn_rN3_m2_lights.setText(R.string.rN3_m2_lights_close);
                mbtn_rN3_m2_lights.setBackgroundResource(R.drawable.btn_lights_off);
                mbtn_rN3_m2_lights.setTextColor(Color.parseColor("#ef404040"));
            }
        }
    };
    private View.OnClickListener btn_rN3_m3_lightsOnClick = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if(isClosed_rN3_m3_lights == 1){
                isClosed_rN3_m3_lights = 0;
                mbtn_rN3_m3_lights.setText(R.string.rN3_m3_lights_open);
                mbtn_rN3_m3_lights.setBackgroundResource(R.drawable.btn_lights_on);
                mbtn_rN3_m3_lights.setTextColor(Color.BLACK);
            }
            else {
                isClosed_rN3_m3_lights = 1;
                mbtn_rN3_m3_lights.setText(R.string.rN3_m3_lights_close);
                mbtn_rN3_m3_lights.setBackgroundResource(R.drawable.btn_lights_off);
                mbtn_rN3_m3_lights.setTextColor(Color.parseColor("#ef404040"));
            }
        }
    };
    private View.OnClickListener btn_rN4_m1_lightsOnClick = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if(isClosed_rN4_m1_lights == 1){
                isClosed_rN4_m1_lights = 0;
                mbtn_rN4_m1_lights.setText(R.string.rN4_m1_lights_open);
                mbtn_rN4_m1_lights.setBackgroundResource(R.drawable.btn_lights_on);
                mbtn_rN4_m1_lights.setTextColor(Color.BLACK);
            }
            else {
                isClosed_rN4_m1_lights = 1;
                mbtn_rN4_m1_lights.setText(R.string.rN4_m1_lights_close);
                mbtn_rN4_m1_lights.setBackgroundResource(R.drawable.btn_lights_off);
                mbtn_rN4_m1_lights.setTextColor(Color.parseColor("#ef404040"));
            }
        }
    };
    private View.OnClickListener btn_rN4_m2_lightsOnClick = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if(isClosed_rN4_m2_lights == 1){
                isClosed_rN4_m2_lights = 0;
                mbtn_rN4_m2_lights.setText(R.string.rN4_m2_lights_open);
                mbtn_rN4_m2_lights.setBackgroundResource(R.drawable.btn_lights_on);
                mbtn_rN4_m2_lights.setTextColor(Color.BLACK);
            }
            else {
                isClosed_rN4_m2_lights = 1;
                mbtn_rN4_m2_lights.setText(R.string.rN4_m2_lights_close);
                mbtn_rN4_m2_lights.setBackgroundResource(R.drawable.btn_lights_off);
                mbtn_rN4_m2_lights.setTextColor(Color.parseColor("#ef404040"));
            }
        }
    };
}
