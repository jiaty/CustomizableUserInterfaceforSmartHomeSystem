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
import android.widget.ImageView;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class fragControlAirConditioning extends Fragment {

    public int isClosed_rN1_airConditioning = 1;
    public int isClosed_rN2_airConditioning = 0;
    public int isClosed_rN3_airConditioning = 0;
    public int isClosed_rN4_airConditioning = 1;

    private Button mbtn_rN1_airConditioning;
    private Button mbtn_rN2_airConditioning;
    private Button mbtn_rN3_airConditioning;
    private Button mbtn_rN4_airConditioning;
    private RadioGroup mrg_controlAirConditioning;

    private int img_none = R.drawable.icon_none;
    private int img_airCon = R.drawable.snow;
    private int img_deHum = R.drawable.rain;
    private int img_fan = R.drawable.fan;

    private TextView mtxv_rN1_targetTemp;
    private ImageView miv_rN1_function;
    private TextView mtxv_rN1_fs;
    private TextView mtxv_rN1_time_off;
    private TextView mtxv_rN1_time_on;
    private TextView mtxv_rN2_targetTemp;
    private ImageView miv_rN2_function;
    private TextView mtxv_rN2_fs;
    private TextView mtxv_rN2_time_off;
    private TextView mtxv_rN2_time_on;
    private TextView mtxv_rN3_targetTemp;
    private ImageView miv_rN3_function;
    private TextView mtxv_rN3_fs;
    private TextView mtxv_rN3_time_off;
    private TextView mtxv_rN3_time_on;
    private TextView mtxv_rN4_targetTemp;
    private ImageView miv_rN4_function;
    private TextView mtxv_rN4_fs;
    private TextView mtxv_rN4_time_off;
    private TextView mtxv_rN4_time_on;


    public fragControlAirConditioning() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_frag_control_air_conditioning, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mbtn_rN1_airConditioning = (Button) getView().findViewById(R.id.btn_rN1_airConditioning);
        mbtn_rN2_airConditioning = (Button) getView().findViewById(R.id.btn_rN2_airConditioning);
        mbtn_rN3_airConditioning = (Button) getView().findViewById(R.id.btn_rN3_airConditioning);
        mbtn_rN4_airConditioning = (Button) getView().findViewById(R.id.btn_rN4_airConditioning);

        mtxv_rN1_targetTemp = (TextView) getView().findViewById(R.id.txv_rN1_targetTemp);
        miv_rN1_function = (ImageView) getView().findViewById(R.id.iv_rN1_function);
        mtxv_rN1_fs = (TextView) getView().findViewById(R.id.txv_rN1_fs);
        mtxv_rN1_time_off = (TextView) getView().findViewById(R.id.txv_rN1_time_off);
        mtxv_rN1_time_on = (TextView) getView().findViewById(R.id.txv_rN1_time_on);
        mtxv_rN2_targetTemp = (TextView) getView().findViewById(R.id.txv_rN2_targetTemp);
        miv_rN2_function = (ImageView) getView().findViewById(R.id.iv_rN2_function);
        mtxv_rN2_fs = (TextView) getView().findViewById(R.id.txv_rN2_fs);
        mtxv_rN2_time_off = (TextView) getView().findViewById(R.id.txv_rN2_time_off);
        mtxv_rN2_time_on = (TextView) getView().findViewById(R.id.txv_rN2_time_on);
        mtxv_rN3_targetTemp = (TextView) getView().findViewById(R.id.txv_rN3_targetTemp);
        miv_rN3_function = (ImageView) getView().findViewById(R.id.iv_rN3_function);
        mtxv_rN3_fs = (TextView) getView().findViewById(R.id.txv_rN3_fs);
        mtxv_rN3_time_off = (TextView) getView().findViewById(R.id.txv_rN3_time_off);
        mtxv_rN3_time_on = (TextView) getView().findViewById(R.id.txv_rN3_time_on);
        mtxv_rN4_targetTemp = (TextView) getView().findViewById(R.id.txv_rN4_targetTemp);
        miv_rN4_function = (ImageView) getView().findViewById(R.id.iv_rN4_function);
        mtxv_rN4_fs = (TextView) getView().findViewById(R.id.txv_rN4_fs);
        mtxv_rN4_time_off = (TextView) getView().findViewById(R.id.txv_rN4_time_off);
        mtxv_rN4_time_on = (TextView) getView().findViewById(R.id.txv_rN4_time_on);

        mrg_controlAirConditioning = (RadioGroup) getView().findViewById(R.id.rg_controlAirConditioning);
        mrg_controlAirConditioning.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener(){
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch(checkedId){
                    case R.id.rb_scenario:
                        fragControlScenario fragCS = new fragControlScenario();
                        FragmentTransaction fragTransCS = getFragmentManager().beginTransaction();
                        fragTransCS.replace(R.id.framlayControlAirConditioning, fragCS);
                        fragTransCS.commit();
                        //Toast.makeText(getActivity().getApplicationContext(), "0 rb_scenario", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.rb_curtain:
                        fragControlCurtain fragCC = new fragControlCurtain();
                        FragmentTransaction fragTransCC = getFragmentManager().beginTransaction();
                        fragTransCC.replace(R.id.framlayControlAirConditioning, fragCC);
                        fragTransCC.commit();
                        //Toast.makeText(getActivity().getApplicationContext(), "1 rb_curtain", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.rb_lights:
                        fragControlLights fragCL = new fragControlLights();
                        FragmentTransaction fragTransCL = getFragmentManager().beginTransaction();
                        fragTransCL.replace(R.id.framlayControlAirConditioning, fragCL);
                        fragTransCL.commit();
                        //Toast.makeText(getActivity().getApplicationContext(), "2 rb_lights", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.rb_airConditioning:
                        fragControlAirConditioning fragCA = new fragControlAirConditioning();
                        FragmentTransaction fragTransCA = getFragmentManager().beginTransaction();
                        fragTransCA.replace(R.id.framlayControlAirConditioning, fragCA);
                        fragTransCA.commit();
                        //Toast.makeText(getActivity().getApplicationContext(), "3 rb_airConditioning", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.rb_elevator:
                        fragControlElevator fragCE = new fragControlElevator();
                        FragmentTransaction fragTransCE = getFragmentManager().beginTransaction();
                        fragTransCE.replace(R.id.framlayControlAirConditioning, fragCE);
                        fragTransCE.commit();
                        //Toast.makeText(getActivity().getApplicationContext(), "4 rb_elevator", Toast.LENGTH_SHORT).show();
                        break;
                }
            }
        });
        mbtn_rN1_airConditioning.setOnClickListener(btn_rN1_airConditioningOnClick);
        mbtn_rN2_airConditioning.setOnClickListener(btn_rN2_airConditioningOnClick);
        mbtn_rN3_airConditioning.setOnClickListener(btn_rN3_airConditioningOnClick);
        mbtn_rN4_airConditioning.setOnClickListener(btn_rN4_airConditioningOnClick);

    }
    private View.OnClickListener btn_rN1_airConditioningOnClick = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if(isClosed_rN1_airConditioning == 1){
                isClosed_rN1_airConditioning = 0;
                mbtn_rN1_airConditioning.setText(R.string.rN1_airConditioning_on);
                mbtn_rN1_airConditioning.setBackgroundResource(R.drawable.btn_aircon_on);
                mbtn_rN1_airConditioning.setTextColor(Color.WHITE);
                mtxv_rN1_targetTemp.setText("25");
                miv_rN1_function.setImageResource(img_airCon);
                mtxv_rN1_fs.setText(R.string.airCon_fs1);
                mtxv_rN1_time_off.setText("-");
                mtxv_rN1_time_on.setText("-");
            }
            else {
                isClosed_rN1_airConditioning = 1;
                mbtn_rN1_airConditioning.setText(R.string.rN1_airConditioning_off);
                mbtn_rN1_airConditioning.setBackgroundResource(R.drawable.btn_aircon_off);
                mbtn_rN1_airConditioning.setTextColor(Color.parseColor("#ef404040"));
                mtxv_rN1_targetTemp.setText("-");
                miv_rN1_function.setImageResource(img_none);
                mtxv_rN1_fs.setText("-");
                mtxv_rN1_time_off.setText("-");
                mtxv_rN1_time_on.setText("-");
            }
        }
    };
    private View.OnClickListener btn_rN2_airConditioningOnClick = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if(isClosed_rN2_airConditioning == 1){
                isClosed_rN2_airConditioning = 0;
                mbtn_rN2_airConditioning.setText(R.string.rN2_airConditioning_on);
                mbtn_rN2_airConditioning.setBackgroundResource(R.drawable.btn_aircon_on);
                mbtn_rN2_airConditioning.setTextColor(Color.WHITE);
                mtxv_rN2_targetTemp.setText("26");
                miv_rN2_function.setImageResource(img_airCon);
                mtxv_rN2_fs.setText(R.string.airCon_fs1);
                mtxv_rN2_time_off.setText("-");
                mtxv_rN2_time_on.setText("-");
            }
            else {
                isClosed_rN2_airConditioning = 1;
                mbtn_rN2_airConditioning.setText(R.string.rN2_airConditioning_off);
                mbtn_rN2_airConditioning.setBackgroundResource(R.drawable.btn_aircon_off);
                mbtn_rN2_airConditioning.setTextColor(Color.parseColor("#ef404040"));
                mtxv_rN2_targetTemp.setText("-");
                miv_rN2_function.setImageResource(img_none);
                mtxv_rN2_fs.setText("-");
                mtxv_rN2_time_off.setText("-");
                mtxv_rN2_time_on.setText("-");
            }
        }
    };
    private View.OnClickListener btn_rN3_airConditioningOnClick = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if(isClosed_rN3_airConditioning == 1){
                isClosed_rN3_airConditioning = 0;
                mbtn_rN3_airConditioning.setText(R.string.rN3_airConditioning_on);
                mbtn_rN3_airConditioning.setBackgroundResource(R.drawable.btn_aircon_on);
                mbtn_rN3_airConditioning.setTextColor(Color.WHITE);
                mtxv_rN3_targetTemp.setText("-");
                miv_rN3_function.setImageResource(img_deHum);
                mtxv_rN3_fs.setText(R.string.airCon_fs1);
                mtxv_rN3_time_off.setText("-");
                mtxv_rN3_time_on.setText("-");
            }
            else {
                isClosed_rN3_airConditioning = 1;
                mbtn_rN3_airConditioning.setText(R.string.rN3_airConditioning_off);
                mbtn_rN3_airConditioning.setBackgroundResource(R.drawable.btn_aircon_off);
                mbtn_rN3_airConditioning.setTextColor(Color.parseColor("#ef404040"));
                mtxv_rN3_targetTemp.setText("-");
                miv_rN3_function.setImageResource(img_none);
                mtxv_rN3_fs.setText("-");
                mtxv_rN3_time_off.setText("-");
                mtxv_rN3_time_on.setText("-");
            }
        }
    };
    private View.OnClickListener btn_rN4_airConditioningOnClick = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if(isClosed_rN4_airConditioning == 1){
                isClosed_rN4_airConditioning = 0;
                mbtn_rN4_airConditioning.setText(R.string.rN4_airConditioning_on);
                mbtn_rN4_airConditioning.setBackgroundResource(R.drawable.btn_aircon_on);
                mbtn_rN4_airConditioning.setTextColor(Color.WHITE);
                mtxv_rN4_targetTemp.setText("-");
                miv_rN4_function.setImageResource(img_fan);
                mtxv_rN4_fs.setText(R.string.airCon_fs1);
                mtxv_rN4_time_off.setText("-");
                mtxv_rN4_time_on.setText("-");
            }
            else {
                isClosed_rN4_airConditioning = 1;
                mbtn_rN4_airConditioning.setText(R.string.rN4_airConditioning_off);
                mbtn_rN4_airConditioning.setBackgroundResource(R.drawable.btn_aircon_off);
                mbtn_rN4_airConditioning.setTextColor(Color.parseColor("#ef404040"));
                mtxv_rN4_targetTemp.setText("-");
                miv_rN4_function.setImageResource(img_none);
                mtxv_rN4_fs.setText("-");
                mtxv_rN4_time_off.setText("-");
                mtxv_rN4_time_on.setText("-");
            }
        }
    };
}
