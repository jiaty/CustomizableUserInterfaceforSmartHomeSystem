package tw.edu.ncue.customizableuserinterfaceforsmarthomesystem;


import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.RadioGroup;

public class fragControlElevator extends Fragment {

    private int isPressed_E1_up = 0;
    private int isPressed_E1_down = 0;
    private int isPressed_E2_up = 0;
    private int isPressed_E2_down = 0;
    private ImageButton mbtn_E1_up;
    private ImageButton mbtn_E1_down;
    private ImageButton mbtn_E2_up;
    private ImageButton mbtn_E2_down;
    private int[] imgList = {
            R.drawable.btn_arrow_up,
            R.drawable.btn_arrow_up_pressed,
            R.drawable.btn_arrow_down,
            R.drawable.btn_arrow_down_pressed
    };

    private RadioGroup mrg_controlElevator;

    public fragControlElevator() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_frag_control_elevator, container, false);
        mbtn_E1_up = (ImageButton) rootView.findViewById(R.id.btn_E1_up);
        mbtn_E1_down = (ImageButton) rootView.findViewById(R.id.btn_E1_down);
        mbtn_E2_up = (ImageButton) rootView.findViewById(R.id.btn_E2_up);
        mbtn_E2_down = (ImageButton) rootView.findViewById(R.id.btn_E2_down);
        return rootView;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mrg_controlElevator = (RadioGroup) getView().findViewById(R.id.rg_controlElevator);
        mrg_controlElevator.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.rb_scenario:
                        fragControlScenario fragCS = new fragControlScenario();
                        FragmentTransaction fragTransCS = getFragmentManager().beginTransaction();
                        fragTransCS.replace(R.id.framlayControlElevator, fragCS);
                        fragTransCS.commit();
                        //Toast.makeText(getActivity().getApplicationContext(), "0 rb_scenario", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.rb_curtain:
                        fragControlCurtain fragCC = new fragControlCurtain();
                        FragmentTransaction fragTransCC = getFragmentManager().beginTransaction();
                        fragTransCC.replace(R.id.framlayControlElevator, fragCC);
                        fragTransCC.commit();
                        //Toast.makeText(getActivity().getApplicationContext(), "1 rb_curtain", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.rb_lights:
                        fragControlLights fragCL = new fragControlLights();
                        FragmentTransaction fragTransCL = getFragmentManager().beginTransaction();
                        fragTransCL.replace(R.id.framlayControlElevator, fragCL);
                        fragTransCL.commit();
                        //Toast.makeText(getActivity().getApplicationContext(), "2 rb_lights", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.rb_airConditioning:
                        fragControlAirConditioning fragCA = new fragControlAirConditioning();
                        FragmentTransaction fragTransCA = getFragmentManager().beginTransaction();
                        fragTransCA.replace(R.id.framlayControlElevator, fragCA);
                        fragTransCA.commit();
                        //Toast.makeText(getActivity().getApplicationContext(), "3 rb_airConditioning", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.rb_elevator:
                        fragControlElevator fragCE = new fragControlElevator();
                        FragmentTransaction fragTransCE = getFragmentManager().beginTransaction();
                        fragTransCE.replace(R.id.framlayControlElevator, fragCE);
                        fragTransCE.commit();
                        //Toast.makeText(getActivity().getApplicationContext(), "4 rb_elevator", Toast.LENGTH_SHORT).show();
                        break;
                }
            }
        });
        mbtn_E1_up.setOnClickListener(btn_E1_upOnClick);
        mbtn_E1_down.setOnClickListener(btn_E1_downOnClick);
        mbtn_E2_up.setOnClickListener(btn_E2_upOnClick);
        mbtn_E2_down.setOnClickListener(btn_E2_downOnClick);
    }

    private View.OnClickListener btn_E1_upOnClick = new View.OnClickListener() {
        @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
        @Override
        public void onClick(View v) {
            if (isPressed_E1_up == 1) {
                isPressed_E1_up = 0;
                mbtn_E1_up.setImageResource(imgList[0]);
            } else {
                isPressed_E1_up = 1;
                mbtn_E1_up.setImageResource(imgList[1]);
            }
        }
    };
    private View.OnClickListener btn_E1_downOnClick = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if (isPressed_E1_down == 1) {
                isPressed_E1_down = 0;
                mbtn_E1_down.setImageResource(imgList[2]);
            } else {
                isPressed_E1_down = 1;
                mbtn_E1_down.setImageResource(imgList[3]);
            }
        }
    };
    private View.OnClickListener btn_E2_upOnClick = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if (isPressed_E2_up == 1) {
                isPressed_E2_up = 0;
                mbtn_E2_up.setImageResource(imgList[0]);
            } else {
                isPressed_E2_up = 1;
                mbtn_E2_up.setImageResource(imgList[1]);
            }
        }
    };
    private View.OnClickListener btn_E2_downOnClick = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if (isPressed_E2_down == 1) {
                isPressed_E2_down = 0;
                mbtn_E2_down.setImageResource(imgList[2]);
            } else {
                isPressed_E2_down = 1;
                mbtn_E2_down.setImageResource(imgList[3]);
            }
        }
    };
}
