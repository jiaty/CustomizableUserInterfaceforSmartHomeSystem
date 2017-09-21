package tw.edu.ncue.customizableuserinterfaceforsmarthomesystem;


import android.graphics.Color;
import android.os.Bundle;
import android.os.CountDownTimer;
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

import java.util.Timer;
import java.util.TimerTask;

public class fragControlCurtain extends Fragment {

    public int isClosed_rN1_w1_curtain = 1;
    public int isClosed_rN1_w2_curtain = 0;
    public int isClosed_rN2_w1_curtain = 0;
    public int isClosed_rN3_w1_curtain = 1;
    public int isClosed_rN3_w2_curtain = 1;
    public int isClosed_rN4_w1_curtain = 1;
    private Button mbtn_rN1_w1_curtain_open;
    private Button mbtn_rN1_w2_curtain_open;
    private Button mbtn_rN2_w1_curtain_open;
    private Button mbtn_rN3_w1_curtain_open;
    private Button mbtn_rN3_w2_curtain_open;
    private Button mbtn_rN4_w1_curtain_open;
    private Button mbtn_rN1_w1_curtain_close;
    private Button mbtn_rN1_w2_curtain_close;
    private Button mbtn_rN2_w1_curtain_close;
    private Button mbtn_rN3_w1_curtain_close;
    private Button mbtn_rN3_w2_curtain_close;
    private Button mbtn_rN4_w1_curtain_close;

    private TextView mtxv_rN1_w1_curtain;
    private TextView mtxv_rN1_w2_curtain;
    private TextView mtxv_rN2_w1_curtain;
    private TextView mtxv_rN3_w1_curtain;
    private TextView mtxv_rN3_w2_curtain;
    private TextView mtxv_rN4_w1_curtain;

    private ImageView miv_rN1_w1_curtain;
    private ImageView miv_rN1_w2_curtain;
    private ImageView miv_rN2_w1_curtain;
    private ImageView miv_rN3_w1_curtain;
    private ImageView miv_rN3_w2_curtain;
    private ImageView miv_rN4_w1_curtain;

    private int img_curtain_open = R.drawable.curtain_open;
    private int img_curtain_close = R.drawable.curtain_close;

    private Timer timer;

    private RadioGroup mrg_controlCurtain;

    public fragControlCurtain() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_frag_control_curtain, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mbtn_rN1_w1_curtain_open = (Button) getView().findViewById(R.id.btn_rN1_w1_curtain_open);
        mbtn_rN1_w2_curtain_open = (Button) getView().findViewById(R.id.btn_rN1_w2_curtain_open);
        mbtn_rN2_w1_curtain_open = (Button) getView().findViewById(R.id.btn_rN2_w1_curtain_open);
        mbtn_rN3_w1_curtain_open = (Button) getView().findViewById(R.id.btn_rN3_w1_curtain_open);
        mbtn_rN3_w2_curtain_open = (Button) getView().findViewById(R.id.btn_rN3_w2_curtain_open);
        mbtn_rN4_w1_curtain_open = (Button) getView().findViewById(R.id.btn_rN4_w1_curtain_open);
        mbtn_rN1_w1_curtain_close = (Button) getView().findViewById(R.id.btn_rN1_w1_curtain_close);
        mbtn_rN1_w2_curtain_close = (Button) getView().findViewById(R.id.btn_rN1_w2_curtain_close);
        mbtn_rN2_w1_curtain_close = (Button) getView().findViewById(R.id.btn_rN2_w1_curtain_close);
        mbtn_rN3_w1_curtain_close = (Button) getView().findViewById(R.id.btn_rN3_w1_curtain_close);
        mbtn_rN3_w2_curtain_close = (Button) getView().findViewById(R.id.btn_rN3_w2_curtain_close);
        mbtn_rN4_w1_curtain_close = (Button) getView().findViewById(R.id.btn_rN4_w1_curtain_close);

        mtxv_rN1_w1_curtain = (TextView) getView().findViewById(R.id.txv_rN1_w1_curtain);
        mtxv_rN1_w2_curtain = (TextView) getView().findViewById(R.id.txv_rN1_w2_curtain);
        mtxv_rN2_w1_curtain = (TextView) getView().findViewById(R.id.txv_rN2_w1_curtain);
        mtxv_rN3_w1_curtain = (TextView) getView().findViewById(R.id.txv_rN3_w1_curtain);
        mtxv_rN3_w2_curtain = (TextView) getView().findViewById(R.id.txv_rN3_w2_curtain);
        mtxv_rN4_w1_curtain = (TextView) getView().findViewById(R.id.txv_rN4_w1_curtain);

        miv_rN1_w1_curtain = (ImageView) getView().findViewById(R.id.iv_rN1_w1_curtain);
        miv_rN1_w2_curtain = (ImageView) getView().findViewById(R.id.iv_rN1_w2_curtain);
        miv_rN2_w1_curtain = (ImageView) getView().findViewById(R.id.iv_rN2_w1_curtain);
        miv_rN3_w1_curtain = (ImageView) getView().findViewById(R.id.iv_rN3_w1_curtain);
        miv_rN3_w2_curtain = (ImageView) getView().findViewById(R.id.iv_rN3_w2_curtain);
        miv_rN4_w1_curtain = (ImageView) getView().findViewById(R.id.iv_rN4_w1_curtain);

        mrg_controlCurtain = (RadioGroup) getView().findViewById(R.id.rg_controlCurtain);
        mrg_controlCurtain.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.rb_scenario:
                        fragControlScenario fragCS = new fragControlScenario();
                        FragmentTransaction fragTransCS = getFragmentManager().beginTransaction();
                        fragTransCS.replace(R.id.framlayControlCurtain, fragCS);
                        fragTransCS.commit();
                        //Toast.makeText(getActivity().getApplicationContext(), "0 rb_scenario", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.rb_curtain:
                        fragControlCurtain fragCC = new fragControlCurtain();
                        FragmentTransaction fragTransCC = getFragmentManager().beginTransaction();
                        fragTransCC.replace(R.id.framlayControlCurtain, fragCC);
                        fragTransCC.commit();
                        //Toast.makeText(getActivity().getApplicationContext(), "1 rb_curtain", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.rb_lights:
                        fragControlLights fragCL = new fragControlLights();
                        FragmentTransaction fragTransCL = getFragmentManager().beginTransaction();
                        fragTransCL.replace(R.id.framlayControlCurtain, fragCL);
                        fragTransCL.commit();
                        //Toast.makeText(getActivity().getApplicationContext(), "2 rb_lights", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.rb_airConditioning:
                        fragControlAirConditioning fragCA = new fragControlAirConditioning();
                        FragmentTransaction fragTransCA = getFragmentManager().beginTransaction();
                        fragTransCA.replace(R.id.framlayControlCurtain, fragCA);
                        fragTransCA.commit();
                        //Toast.makeText(getActivity().getApplicationContext(), "3 rb_airConditioning", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.rb_elevator:
                        fragControlElevator fragCE = new fragControlElevator();
                        FragmentTransaction fragTransCE = getFragmentManager().beginTransaction();
                        fragTransCE.replace(R.id.framlayControlCurtain, fragCE);
                        fragTransCE.commit();
                        //Toast.makeText(getActivity().getApplicationContext(), "4 rb_elevator", Toast.LENGTH_SHORT).show();
                        break;
                }
            }
        });
        mbtn_rN1_w1_curtain_open.setOnClickListener(btn_rN1_w1_curtain_openOnClick);
        mbtn_rN1_w2_curtain_open.setOnClickListener(btn_rN1_w2_curtain_openOnClick);
        mbtn_rN2_w1_curtain_open.setOnClickListener(btn_rN2_w1_curtain_openOnClick);
        mbtn_rN3_w1_curtain_open.setOnClickListener(btn_rN3_w1_curtain_openOnClick);
        mbtn_rN3_w2_curtain_open.setOnClickListener(btn_rN3_w2_curtain_openOnClick);
        mbtn_rN4_w1_curtain_open.setOnClickListener(btn_rN4_w1_curtain_openOnClick);
        mbtn_rN1_w1_curtain_close.setOnClickListener(btn_rN1_w1_curtain_closeOnClick);
        mbtn_rN1_w2_curtain_close.setOnClickListener(btn_rN1_w2_curtain_closeOnClick);
        mbtn_rN2_w1_curtain_close.setOnClickListener(btn_rN2_w1_curtain_closeOnClick);
        mbtn_rN3_w1_curtain_close.setOnClickListener(btn_rN3_w1_curtain_closeOnClick);
        mbtn_rN3_w2_curtain_close.setOnClickListener(btn_rN3_w2_curtain_closeOnClick);
        mbtn_rN4_w1_curtain_close.setOnClickListener(btn_rN4_w1_curtain_closeOnClick);
    }

    private View.OnClickListener btn_rN1_w1_curtain_openOnClick = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if (isClosed_rN1_w1_curtain == 1) {
                mtxv_rN1_w1_curtain.setText(R.string.rN1_w1_curtain_working);
                mbtn_rN1_w1_curtain_open.setText(R.string.curtain_pause);
                new CountDownTimer(2000, 1000) {
                    public void onTick(long millisUntilFinished) {
                    }

                    public void onFinish() {
                        isClosed_rN1_w1_curtain = 0;
                        mtxv_rN1_w1_curtain.setText(R.string.rN1_w1_curtain_open);
                        mtxv_rN1_w1_curtain.setTextColor(Color.BLACK);
                        miv_rN1_w1_curtain.setImageResource(img_curtain_open);
                        mbtn_rN1_w1_curtain_close.setBackgroundResource(R.drawable.btn_transparent);
                        mbtn_rN1_w1_curtain_open.setBackgroundResource(R.drawable.btn_pressed);
                        mbtn_rN1_w1_curtain_open.setText(R.string.curtain_open);
                    }
                }.start();
            } else {

            }
        }
    };
    private View.OnClickListener btn_rN1_w2_curtain_openOnClick = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if (isClosed_rN1_w2_curtain == 1) {
                mbtn_rN1_w2_curtain_open.setText(R.string.curtain_pause);
                mtxv_rN1_w2_curtain.setText(R.string.rN1_w2_curtain_working);
                new CountDownTimer(2000, 1000) {
                    public void onTick(long millisUntilFinished) {
                    }

                    public void onFinish() {
                        isClosed_rN1_w2_curtain = 0;
                        mbtn_rN1_w2_curtain_open.setText(R.string.curtain_open);
                        mtxv_rN1_w2_curtain.setText(R.string.rN1_w2_curtain_open);
                        mtxv_rN1_w2_curtain.setTextColor(Color.BLACK);
                        miv_rN1_w2_curtain.setImageResource(img_curtain_open);
                        mbtn_rN1_w2_curtain_close.setBackgroundResource(R.drawable.btn_transparent);
                        mbtn_rN1_w2_curtain_open.setBackgroundResource(R.drawable.btn_pressed);
                    }
                }.start();
            } else {

            }
        }
    };
    private View.OnClickListener btn_rN2_w1_curtain_openOnClick = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if (isClosed_rN2_w1_curtain == 1) {
                mbtn_rN2_w1_curtain_open.setText(R.string.curtain_pause);
                mtxv_rN2_w1_curtain.setText(R.string.rN2_w1_curtain_working);
                new CountDownTimer(2000, 1000) {
                    public void onTick(long millisUntilFinished) {
                    }

                    public void onFinish() {
                        isClosed_rN2_w1_curtain = 0;
                        mbtn_rN2_w1_curtain_open.setText(R.string.curtain_open);
                        mtxv_rN2_w1_curtain.setText(R.string.rN2_w1_curtain_open);
                        mtxv_rN2_w1_curtain.setTextColor(Color.BLACK);
                        miv_rN2_w1_curtain.setImageResource(img_curtain_open);
                        mbtn_rN2_w1_curtain_close.setBackgroundResource(R.drawable.btn_transparent);
                        mbtn_rN2_w1_curtain_open.setBackgroundResource(R.drawable.btn_pressed);
                    }
                }.start();
            } else {

            }
        }
    };
    private View.OnClickListener btn_rN3_w1_curtain_openOnClick = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if (isClosed_rN3_w1_curtain == 1) {
                mbtn_rN3_w1_curtain_open.setText(R.string.curtain_pause);
                mtxv_rN3_w1_curtain.setText(R.string.rN3_w1_curtain_working);
                new CountDownTimer(2000, 1000) {
                    public void onTick(long millisUntilFinished) {
                    }

                    public void onFinish() {
                        isClosed_rN3_w1_curtain = 0;
                        mbtn_rN3_w1_curtain_open.setText(R.string.curtain_open);
                        mtxv_rN3_w1_curtain.setText(R.string.rN3_w1_curtain_open);
                        mtxv_rN3_w1_curtain.setTextColor(Color.BLACK);
                        miv_rN3_w1_curtain.setImageResource(img_curtain_open);
                        mbtn_rN3_w1_curtain_close.setBackgroundResource(R.drawable.btn_transparent);
                        mbtn_rN3_w1_curtain_open.setBackgroundResource(R.drawable.btn_pressed);
                    }
                }.start();
            } else {

            }
        }
    };
    private View.OnClickListener btn_rN3_w2_curtain_openOnClick = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if (isClosed_rN3_w2_curtain == 1) {
                mbtn_rN3_w2_curtain_open.setText(R.string.curtain_pause);
                mtxv_rN3_w2_curtain.setText(R.string.rN3_w2_curtain_working);
                new CountDownTimer(2000, 1000) {
                    public void onTick(long millisUntilFinished) {
                    }

                    public void onFinish() {
                        isClosed_rN3_w2_curtain = 0;
                        mbtn_rN3_w2_curtain_open.setText(R.string.curtain_open);
                        mtxv_rN3_w2_curtain.setText(R.string.rN3_w2_curtain_open);
                        mtxv_rN3_w2_curtain.setTextColor(Color.BLACK);
                        miv_rN3_w2_curtain.setImageResource(img_curtain_open);
                        mbtn_rN3_w2_curtain_close.setBackgroundResource(R.drawable.btn_transparent);
                        mbtn_rN3_w2_curtain_open.setBackgroundResource(R.drawable.btn_pressed);
                    }
                }.start();
            } else {

            }
        }
    };
    private View.OnClickListener btn_rN4_w1_curtain_openOnClick = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if (isClosed_rN4_w1_curtain == 1) {
                mbtn_rN4_w1_curtain_open.setText(R.string.curtain_pause);
                mtxv_rN4_w1_curtain.setText(R.string.rN4_w1_curtain_working);
                new CountDownTimer(2000, 1000) {
                    public void onTick(long millisUntilFinished) {
                    }

                    public void onFinish() {
                        isClosed_rN4_w1_curtain = 0;
                        mbtn_rN4_w1_curtain_open.setText(R.string.curtain_open);
                        mtxv_rN4_w1_curtain.setText(R.string.rN4_w1_curtain_open);
                        mtxv_rN4_w1_curtain.setTextColor(Color.BLACK);
                        miv_rN4_w1_curtain.setImageResource(img_curtain_open);
                        mbtn_rN4_w1_curtain_close.setBackgroundResource(R.drawable.btn_transparent);
                        mbtn_rN4_w1_curtain_open.setBackgroundResource(R.drawable.btn_pressed);
                    }
                }.start();
            } else {

            }
        }
    };
    private View.OnClickListener btn_rN1_w1_curtain_closeOnClick = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if (isClosed_rN1_w1_curtain == 0) {
                mbtn_rN1_w1_curtain_close.setText(R.string.curtain_pause);
                mtxv_rN1_w1_curtain.setText(R.string.rN1_w1_curtain_working);
                new CountDownTimer(2000, 1000) {
                    public void onTick(long millisUntilFinished) {
                    }

                    public void onFinish() {
                        isClosed_rN1_w1_curtain = 1;
                        mbtn_rN1_w1_curtain_close.setText(R.string.curtain_open);
                        mtxv_rN1_w1_curtain.setText(R.string.rN1_w1_curtain_close);
                        mtxv_rN1_w1_curtain.setTextColor(Color.parseColor("#ef404040"));
                        miv_rN1_w1_curtain.setImageResource(img_curtain_close);
                        mbtn_rN1_w1_curtain_close.setBackgroundResource(R.drawable.btn_pressed);
                        mbtn_rN1_w1_curtain_open.setBackgroundResource(R.drawable.btn_transparent);
                    }
                }.start();
            } else {

            }
        }
    };
    private View.OnClickListener btn_rN1_w2_curtain_closeOnClick = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if (isClosed_rN1_w2_curtain == 0) {
                mbtn_rN1_w2_curtain_close.setText(R.string.curtain_pause);
                mtxv_rN1_w2_curtain.setText(R.string.rN1_w2_curtain_working);
                new CountDownTimer(2000, 1000) {
                    public void onTick(long millisUntilFinished) {
                    }

                    public void onFinish() {
                        isClosed_rN1_w2_curtain = 1;
                        mbtn_rN1_w2_curtain_close.setText(R.string.curtain_close);
                        mtxv_rN1_w2_curtain.setText(R.string.rN1_w2_curtain_close);
                        mtxv_rN1_w2_curtain.setTextColor(Color.parseColor("#ef404040"));
                        miv_rN1_w2_curtain.setImageResource(img_curtain_close);
                        mbtn_rN1_w2_curtain_close.setBackgroundResource(R.drawable.btn_pressed);
                        mbtn_rN1_w2_curtain_open.setBackgroundResource(R.drawable.btn_transparent);
                    }
                }.start();
            } else {

            }
        }
    };
    private View.OnClickListener btn_rN2_w1_curtain_closeOnClick = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if (isClosed_rN2_w1_curtain == 0) {
                mbtn_rN2_w1_curtain_close.setText(R.string.curtain_pause);
                mtxv_rN2_w1_curtain.setText(R.string.rN2_w1_curtain_working);
                new CountDownTimer(2000, 1000) {
                    public void onTick(long millisUntilFinished) {
                    }

                    public void onFinish() {
                        isClosed_rN2_w1_curtain = 1;
                        mbtn_rN2_w1_curtain_close.setText(R.string.curtain_close);
                        mtxv_rN2_w1_curtain.setText(R.string.rN2_w1_curtain_close);
                        mtxv_rN2_w1_curtain.setTextColor(Color.parseColor("#ef404040"));
                        miv_rN2_w1_curtain.setImageResource(img_curtain_close);
                        mbtn_rN2_w1_curtain_close.setBackgroundResource(R.drawable.btn_pressed);
                        mbtn_rN2_w1_curtain_open.setBackgroundResource(R.drawable.btn_transparent);
                    }
                }.start();
            } else {

            }
        }
    };
    private View.OnClickListener btn_rN3_w1_curtain_closeOnClick = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if (isClosed_rN3_w1_curtain == 0) {
                mbtn_rN3_w1_curtain_close.setText(R.string.curtain_pause);
                mtxv_rN3_w1_curtain.setText(R.string.rN3_w1_curtain_working);
                new CountDownTimer(2000, 1000) {
                    public void onTick(long millisUntilFinished) {
                    }

                    public void onFinish() {
                        isClosed_rN3_w1_curtain = 1;
                        mbtn_rN3_w1_curtain_close.setText(R.string.curtain_close);
                        mtxv_rN3_w1_curtain.setText(R.string.rN3_w1_curtain_close);
                        mtxv_rN3_w1_curtain.setTextColor(Color.parseColor("#ef404040"));
                        miv_rN3_w1_curtain.setImageResource(img_curtain_close);
                        mbtn_rN3_w1_curtain_close.setBackgroundResource(R.drawable.btn_pressed);
                        mbtn_rN3_w1_curtain_open.setBackgroundResource(R.drawable.btn_transparent);
                    }
                }.start();
            } else {

            }
        }
    };
    private View.OnClickListener btn_rN3_w2_curtain_closeOnClick = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if (isClosed_rN3_w2_curtain == 0) {
                mbtn_rN3_w2_curtain_close.setText(R.string.curtain_pause);
                mtxv_rN3_w2_curtain.setText(R.string.rN3_w2_curtain_working);
                new CountDownTimer(2000, 1000) {
                    public void onTick(long millisUntilFinished) {
                    }

                    public void onFinish() {
                        isClosed_rN3_w2_curtain = 1;
                        mbtn_rN3_w2_curtain_close.setText(R.string.curtain_close);
                        mtxv_rN3_w2_curtain.setText(R.string.rN3_w2_curtain_close);
                        mtxv_rN3_w2_curtain.setTextColor(Color.parseColor("#ef404040"));
                        miv_rN3_w2_curtain.setImageResource(img_curtain_close);
                        mbtn_rN3_w2_curtain_close.setBackgroundResource(R.drawable.btn_pressed);
                        mbtn_rN3_w2_curtain_open.setBackgroundResource(R.drawable.btn_transparent);
                    }
                }.start();
            } else {

            }
        }
    };
    private View.OnClickListener btn_rN4_w1_curtain_closeOnClick = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if (isClosed_rN4_w1_curtain == 0) {
                mbtn_rN4_w1_curtain_close.setText(R.string.curtain_pause);
                mtxv_rN4_w1_curtain.setText(R.string.rN4_w1_curtain_working);
                new CountDownTimer(2000, 1000) {
                    public void onTick(long millisUntilFinished) {
                    }

                    public void onFinish() {
                        isClosed_rN4_w1_curtain = 1;
                        mbtn_rN4_w1_curtain_close.setText(R.string.curtain_close);
                        mtxv_rN4_w1_curtain.setTextColor(Color.parseColor("#ef404040"));
                        miv_rN4_w1_curtain.setImageResource(img_curtain_close);
                        mbtn_rN4_w1_curtain_close.setBackgroundResource(R.drawable.btn_pressed);
                        mbtn_rN4_w1_curtain_open.setBackgroundResource(R.drawable.btn_transparent);
                    }
                }.start();
            } else {

            }
        }
    };
}
