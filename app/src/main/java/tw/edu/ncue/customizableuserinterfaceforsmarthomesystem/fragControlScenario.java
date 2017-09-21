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

public class fragControlScenario extends Fragment {
    public int isOn_homeOut = 1;
    public int isOn_morning = 0;
    public int isOn_night = 0;
    public int isOn_reading = 0;
    public int isOn_media = 0;
    public int isOn_party = 0;
    private Button mbtn_homeOut;
    private Button mbtn_morning;
    private Button mbtn_night;
    private Button mbtn_reading;
    private Button mbtn_media;
    private Button mbtn_party;

    private RadioGroup mrg_controlScenario;

    public fragControlScenario() {
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
        return inflater.inflate(R.layout.fragment_frag_control_scenario, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mbtn_homeOut = (Button) getView().findViewById(R.id.btn_homeOut);
        mbtn_morning = (Button) getView().findViewById(R.id.btn_morning);
        mbtn_night = (Button) getView().findViewById(R.id.btn_night);
        mbtn_reading = (Button) getView().findViewById(R.id.btn_reading);
        mbtn_media = (Button) getView().findViewById(R.id.btn_media);
        mbtn_party = (Button) getView().findViewById(R.id.btn_party);

        mrg_controlScenario = (RadioGroup) getView().findViewById(R.id.rg_controlScenario);
        mrg_controlScenario.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.rb_scenario:
                        fragControlScenario fragCS = new fragControlScenario();
                        FragmentTransaction fragTransCS = getFragmentManager().beginTransaction();
                        fragTransCS.replace(R.id.framlayControlScenario, fragCS);
                        fragTransCS.commit();
                        //Toast.makeText(getActivity().getApplicationContext(), "0 rb_scenario", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.rb_curtain:
                        fragControlCurtain fragCC = new fragControlCurtain();
                        FragmentTransaction fragTransCC = getFragmentManager().beginTransaction();
                        fragTransCC.replace(R.id.framlayControlScenario, fragCC);
                        fragTransCC.commit();
                        //Toast.makeText(getActivity().getApplicationContext(), "1 rb_curtain", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.rb_lights:
                        fragControlLights fragCL = new fragControlLights();
                        FragmentTransaction fragTransCL = getFragmentManager().beginTransaction();
                        fragTransCL.replace(R.id.framlayControlScenario, fragCL);
                        fragTransCL.commit();
                        //Toast.makeText(getActivity().getApplicationContext(), "2 rb_lights", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.rb_airConditioning:
                        fragControlAirConditioning fragCA = new fragControlAirConditioning();
                        FragmentTransaction fragTransCA = getFragmentManager().beginTransaction();
                        fragTransCA.replace(R.id.framlayControlScenario, fragCA);
                        fragTransCA.commit();
                        //Toast.makeText(getActivity().getApplicationContext(), "3 rb_airConditioning", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.rb_elevator:
                        fragControlElevator fragCE = new fragControlElevator();
                        FragmentTransaction fragTransCE = getFragmentManager().beginTransaction();
                        fragTransCE.replace(R.id.framlayControlScenario, fragCE);
                        fragTransCE.commit();
                        //Toast.makeText(getActivity().getApplicationContext(), "4 rb_elevator", Toast.LENGTH_SHORT).show();
                        break;
                }
            }
        });
        mbtn_homeOut.setOnClickListener(btn_homeOutOnClick);
        mbtn_morning.setOnClickListener(btn_morningOnClick);
        mbtn_night.setOnClickListener(btn_nightOnClick);
        mbtn_reading.setOnClickListener(btn_readingOnClick);
        mbtn_media.setOnClickListener(btn_mediaOnClick);
        mbtn_party.setOnClickListener(btn_partyOnClick);
    }

    private View.OnClickListener btn_homeOutOnClick = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if(isOn_homeOut == 1){
                isOn_homeOut = 0;
                mbtn_homeOut.setText("外出");
                //mbtn_homeOut.setText(R.string.homeOut_off);
                mbtn_homeOut.setBackgroundResource(R.drawable.btn_pressed);
                mbtn_homeOut.setTextColor(Color.parseColor("#ef404040"));
                Toast t = Toast.makeText(getActivity().getApplicationContext(), "外出", Toast.LENGTH_SHORT);
                t.show();
            }
            else {
                isOn_homeOut = 1;
                mbtn_homeOut.setText("到家");
                //mbtn_homeOut.setText(R.string.homeOut_on);
                mbtn_homeOut.setBackgroundResource(R.drawable.btn_transparent);
                mbtn_homeOut.setTextColor(Color.BLACK);
                Toast t = Toast.makeText(getActivity().getApplicationContext(), "到家", Toast.LENGTH_SHORT);
                t.show();
            }
        }
    };
    private View.OnClickListener btn_morningOnClick = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if(isOn_morning == 1){
                isOn_morning = 0;
                //mbtn_morning.setText(R.string.morning_off);
                mbtn_morning.setBackgroundResource(R.drawable.btn_pressed);
                mbtn_morning.setTextColor(Color.parseColor("#ef404040"));
            }
            else {
                isOn_morning = 1;
                //mbtn_morning.setText(R.string.morning_on);
                mbtn_morning.setBackgroundResource(R.drawable.btn_transparent);
                mbtn_morning.setTextColor(Color.BLACK);
                Toast t = Toast.makeText(getActivity().getApplicationContext(), "晨起模式 開啟", Toast.LENGTH_SHORT);
                t.show();
            }
        }
    };
    private View.OnClickListener btn_nightOnClick = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if(isOn_night == 1){
                isOn_night = 0;
                //mbtn_night.setText(R.string.night_off);
                mbtn_night.setBackgroundResource(R.drawable.btn_pressed);
                mbtn_night.setTextColor(Color.parseColor("#ef404040"));
            }
            else {
                isOn_night = 1;
                //mbtn_night.setText(R.string.night_on);
                mbtn_night.setBackgroundResource(R.drawable.btn_transparent);
                mbtn_night.setTextColor(Color.BLACK);
                Toast t = Toast.makeText(getActivity().getApplicationContext(), "就寢模式 開啟", Toast.LENGTH_SHORT);
                t.show();
            }
        }
    };
    private View.OnClickListener btn_readingOnClick = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if(isOn_reading == 1){
                isOn_reading = 0;
                //mbtn_reading.setText(R.string.reading_off);
                mbtn_reading.setBackgroundResource(R.drawable.btn_pressed);
                mbtn_reading.setTextColor(Color.parseColor("#ef404040"));
            }
            else {
                isOn_reading = 1;
                //mbtn_reading.setText(R.string.reading_on);
                mbtn_reading.setBackgroundResource(R.drawable.btn_transparent);
                mbtn_reading.setTextColor(Color.BLACK);
                Toast t = Toast.makeText(getActivity().getApplicationContext(), "閱讀模式 開啟", Toast.LENGTH_SHORT);
                t.show();
            }
        }
    };
    private View.OnClickListener btn_mediaOnClick = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if(isOn_media == 1){
                isOn_media = 0;
                //mbtn_media.setText(R.string.media_off);
                mbtn_media.setBackgroundResource(R.drawable.btn_pressed);
                mbtn_media.setTextColor(Color.parseColor("#ef404040"));
            }
            else {
                isOn_media = 1;
                //mbtn_media.setText(R.string.media_on);
                mbtn_media.setBackgroundResource(R.drawable.btn_transparent);
                mbtn_media.setTextColor(Color.BLACK);
                Toast t = Toast.makeText(getActivity().getApplicationContext(), "視聽模式 開啟", Toast.LENGTH_SHORT);
                t.show();
            }
        }
    };
    private View.OnClickListener btn_partyOnClick = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if(isOn_party == 1){
                isOn_party = 0;
                //mbtn_party.setText(R.string.party_off);
                mbtn_party.setBackgroundResource(R.drawable.btn_pressed);
                mbtn_party.setTextColor(Color.parseColor("#ef404040"));
            }
            else {
                isOn_party = 1;
                //mbtn_party.setText(R.string.party_on);
                mbtn_party.setBackgroundResource(R.drawable.btn_transparent);
                mbtn_party.setTextColor(Color.BLACK);
                Toast t = Toast.makeText(getActivity().getApplicationContext(), "派對模式 開啟", Toast.LENGTH_SHORT);
                t.show();
            }
        }
    };
}
