package tw.edu.ncue.customizableuserinterfaceforsmarthomesystem;


import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.TabHost;
import android.widget.TextView;
import android.widget.Toast;

public class fragHome extends Fragment {
    //介面相關變數宣告

    public int isHome = 1;
    public int isAwake = 0;
    public int isSleep = 0;
    private Switch mswt_SecuOnOff;
    private TextView mtxv_DateTime;
    private TextView mtxv_HomeName;
    private TextView mtxv_Notification;
    private TextView mtxv_FavorSituation;
    private TextView mtxv_FavorFunction;
    private Button mbtn_DoorBell;
    private Button mbtn_noti_DoorBell;
    private Button mbtn_MailBox;
    private Button mbtn_noti_MailBox;
    private Button mbtn_Situation1;
    private Button mbtn_Situation2;
    private Button mbtn_Situation3;
    private Button mbtn_favor_elevator;
    private Button mbtn_favor_sensor;
    private Button mbtn_favor_curtain;
    private Button mbtn_favor_lights;
    private Button mbtn_favor_aircon;
    private Button mbtn_favor_billboard;

    public fragHome() {
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
        return inflater.inflate(R.layout.fragment_home, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);



        mswt_SecuOnOff = (Switch) getView().findViewById(R.id.swt_SecuOnOff);
        mtxv_DateTime = (TextView) getView().findViewById(R.id.txv_DateTime);
        mtxv_HomeName = (TextView) getView().findViewById(R.id.txv_HomeName);
        mtxv_Notification = (TextView) getView().findViewById(R.id.txv_Notification);
        mtxv_FavorSituation = (TextView) getView().findViewById(R.id.txv_FavorSituation);
        mtxv_FavorFunction = (TextView) getView().findViewById(R.id.txv_FavorFunction);
        mbtn_DoorBell = (Button) getView().findViewById(R.id.btn_DoorBell);
        mbtn_noti_DoorBell = (Button) getView().findViewById(R.id.btn_noti_DoorBell);
        mbtn_MailBox = (Button) getView().findViewById(R.id.btn_MailBox);
        mbtn_noti_MailBox = (Button) getView().findViewById(R.id.btn_noti_MailBox);
        mbtn_Situation1 = (Button) getView().findViewById(R.id.btn_Situation1);
        mbtn_Situation2 = (Button) getView().findViewById(R.id.btn_Situation2);
        mbtn_Situation3 = (Button) getView().findViewById(R.id.btn_Situation3);
        mbtn_favor_elevator = (Button) getView().findViewById(R.id.btn_favor_elevator);
        mbtn_favor_sensor = (Button) getView().findViewById(R.id.btn_favor_sensor);
        mbtn_favor_curtain = (Button) getView().findViewById(R.id.btn_favor_curtain);
        mbtn_favor_lights = (Button) getView().findViewById(R.id.btn_favor_lights);
        mbtn_favor_aircon = (Button) getView().findViewById(R.id.btn_favor_aircon);
        mbtn_favor_billboard = (Button) getView().findViewById(R.id.btn_favor_billboard);

        mswt_SecuOnOff.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    Toast t = Toast.makeText(getActivity().getApplicationContext(), R.string.toast_switch_on, Toast.LENGTH_SHORT);
                    t.show();
                }
                else{
                    Toast t = Toast.makeText(getActivity().getApplicationContext(), R.string.toast_switch_off, Toast.LENGTH_SHORT);
                    t.show();
                }
            }
        });
        mbtn_DoorBell.setOnClickListener(btn_DoorBellOnClick);
        mbtn_MailBox.setOnClickListener(btn_MailBoxOnClick);
        mbtn_Situation1.setOnClickListener(btn_Situation1OnClick);
        mbtn_Situation2.setOnClickListener(btn_Situation2OnClick);
        mbtn_Situation3.setOnClickListener(btn_Situation3OnClick);
        mbtn_favor_elevator.setOnClickListener(btn_Function1OnClick);
        mbtn_favor_sensor.setOnClickListener(btn_Function2OnClick);
        mbtn_favor_curtain.setOnClickListener(btn_Function3OnClick);
        mbtn_favor_lights.setOnClickListener(btn_Function4OnClick);
        mbtn_favor_aircon.setOnClickListener(btn_Function5OnClick);
        mbtn_favor_billboard.setOnClickListener(btn_Function6OnClick);
    }
    //可客製化的主畫面編輯按鈕
    private View.OnClickListener btn_DoorBellOnClick = new View.OnClickListener() {
        @Override
        public void onClick(View v) {

        }
    };
    private View.OnClickListener btn_MailBoxOnClick = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            //tab切換再切換內頁
//            fragCommunityMailBox fragCM = new fragCommunityMailBox();
//            FragmentTransaction fragTransCM = getFragmentManager().beginTransaction();
//            fragTransCM.replace(R.id.layout_home, fragCM);
//            fragTransCM.commit();
        }
    };
    private View.OnClickListener btn_Situation1OnClick = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if(isHome == 1){
                isHome = 0;
                mbtn_Situation1.setText("外出");
                mbtn_Situation1.setBackgroundResource(R.drawable.btn_pressed);
                Toast t = Toast.makeText(getActivity().getApplicationContext(), "外出", Toast.LENGTH_SHORT);
                t.show();
                /*mswt_SecuOnOff.setChecked(true);*/
            }
            else {
                isHome = 1;
                mbtn_Situation1.setText("到家");
                mbtn_Situation1.setBackgroundResource(R.drawable.btn_transparent);
                Toast t = Toast.makeText(getActivity().getApplicationContext(), "到家", Toast.LENGTH_SHORT);
                t.show();
            }
        }
    };
    private View.OnClickListener btn_Situation2OnClick = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if(isAwake == 1){
                isAwake = 0;
                mbtn_Situation2.setBackgroundResource(R.drawable.btn_pressed);
                mbtn_Situation2.setTextColor(Color.parseColor("#ef404040"));
            }
            else {
                isAwake = 1;
                mbtn_Situation2.setBackgroundResource(R.drawable.btn_transparent);
                mbtn_Situation2.setTextColor(Color.BLACK);
                Toast t = Toast.makeText(getActivity().getApplicationContext(), "晨起模式 開啟", Toast.LENGTH_SHORT);
                t.show();
            }
        }
    };
    private View.OnClickListener btn_Situation3OnClick = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if(isSleep == 1){
                isSleep = 0;
                mbtn_Situation3.setBackgroundResource(R.drawable.btn_pressed);
                mbtn_Situation3.setTextColor(Color.parseColor("#ef404040"));
            }
            else {
                isSleep = 1;
                mbtn_Situation3.setBackgroundResource(R.drawable.btn_transparent);
                mbtn_Situation3.setTextColor(Color.BLACK);
                Toast t = Toast.makeText(getActivity().getApplicationContext(), "就寢模式 開啟", Toast.LENGTH_SHORT);
                t.show();
            }
        }
    };
    private View.OnClickListener btn_Function1OnClick = new View.OnClickListener() {
        @Override
        public void onClick(View v) {

        }
    };
    private View.OnClickListener btn_Function2OnClick = new View.OnClickListener() {
        @Override
        public void onClick(View v) {

        }
    };
    private View.OnClickListener btn_Function3OnClick = new View.OnClickListener() {
        @Override
        public void onClick(View v) {

        }
    };
    private View.OnClickListener btn_Function4OnClick = new View.OnClickListener() {
        @Override
        public void onClick(View v) {

        }
    };
    private View.OnClickListener btn_Function5OnClick = new View.OnClickListener() {
        @Override
        public void onClick(View v) {

        }
    };
    private View.OnClickListener btn_Function6OnClick = new View.OnClickListener() {
        @Override
        public void onClick(View v) {

        }
    };
}
