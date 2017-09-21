package tw.edu.ncue.customizableuserinterfaceforsmarthomesystem;


import android.content.DialogInterface;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RadioGroup;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class fragCommunityBillboard extends Fragment {

    private RadioGroup mrg_communityBillboard;
    private ListView mlv_billboard;
    private int img_info = R.drawable.info;
    private int img_new = R.drawable.icon_new;
    private int img_none = R.drawable.icon_none;
    private int position_lvOnClick;

    private int[] billboardImgList = {
            R.drawable.icon_new,
            R.drawable.icon_new,
            R.drawable.icon_new,
            R.drawable.icon_none,
            R.drawable.icon_none,
            R.drawable.icon_none,
            R.drawable.icon_none
    };
    private String[] billboardList = {
            "公告事項7：內容內容內容內容",
            "公告事項6：內容內容內容內容",
            "公告事項5：內容內容內容內容",
            "公告事項4：內容內容內容內容",
            "公告事項3：內容內容內容內容",
            "公告事項2：內容內容內容內容",
            "公告事項1：內容內容內容內容"
    };
    private String[] billboardDateList = {
            "2017/3/1",
            "2017/2/15",
            "2017/2/1",
            "2017/1/15",
            "2017/1/1",
            "2016/12/15",
            "2016/12/1"
    };

    public fragCommunityBillboard() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = (View) inflater.inflate(R.layout.fragment_frag_community_billboard, container, false);

//        int img_new = getResources().getIdentifier("@drawable/icon_new", "drawable", getActivity().getPackageName());
        mlv_billboard = (ListView) rootView.findViewById(R.id.lv_billBoard);
        List<Map<String, Object>> mList;
        mList = new ArrayList<Map<String, Object>>();
        for(int i = 0; i < billboardList.length; i++){
            Map<String, Object> item = new HashMap<String, Object>();
            item.put("iv_lvItem", Integer.toString(billboardImgList[i]) );
            item.put("txv_lvItem", billboardList[i]);
            item.put("txv_lvDate", billboardDateList[i]);
            mList.add(item);
        }
        SimpleAdapter arrAdapBillboard = new SimpleAdapter(
                getActivity(),
                mList,
                R.layout.lv_item_billboard,
                new String[] {"iv_lvItem", "txv_lvItem", "txv_lvDate"},
                new int[] {R.id.iv_lvItem, R.id.txv_lvItem, R.id.txv_lvDate}
        );
//        ArrayAdapter<String> arrAdapBillboard = new ArrayAdapter<String>(
//                getActivity(),
//                R.layout.lv_item_billboard,
//                R.id.txv_lvItem,
//                billboardList
//        );
        mlv_billboard.setAdapter(arrAdapBillboard);
        return rootView;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mrg_communityBillboard = (RadioGroup) getView().findViewById(R.id.rg_communityBillboard);
        mrg_communityBillboard.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener(){
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch(checkedId){
                    case R.id.rb_mailBox:
                        fragCommunityMailBox fragCM = new fragCommunityMailBox();
                        FragmentTransaction fragTransCM = getFragmentManager().beginTransaction();
                        fragTransCM.replace(R.id.framlayCommunityBillboard, fragCM);
                        fragTransCM.commit();
                        //Toast.makeText(getActivity().getApplicationContext(), "0 rb_mailBox", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.rb_billboard:
                        fragCommunityBillboard fragCB = new fragCommunityBillboard();
                        FragmentTransaction fragTransCB = getFragmentManager().beginTransaction();
                        fragTransCB.replace(R.id.framlayCommunityBillboard, fragCB);
                        fragTransCB.commit();
                        //Toast.makeText(getActivity().getApplicationContext(), "1 rb_billboard", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.rb_contactManagementRoom:
                        fragCommunityContactManagementRoom fragCC = new fragCommunityContactManagementRoom();
                        FragmentTransaction fragTransCC = getFragmentManager().beginTransaction();
                        fragTransCC.replace(R.id.framlayCommunityBillboard, fragCC);
                        fragTransCC.commit();
                        //Toast.makeText(getActivity().getApplicationContext(), "2 rb_contactManagementRoom", Toast.LENGTH_SHORT).show();
                        break;
                }
            }
        });
        mlv_billboard.setOnItemClickListener(listViewOnItemClick);
    }
    private AdapterView.OnItemClickListener listViewOnItemClick = new AdapterView.OnItemClickListener() {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            String s = ((TextView) view.findViewById(R.id.txv_lvItem)).getText().toString();
            String s_date = ((TextView) view.findViewById(R.id.txv_lvDate)).getText().toString();

            MyAlertDialog myAltDlg = new MyAlertDialog(getActivity());
            myAltDlg.setTitle(s_date);
            myAltDlg.setMessage(s);
            myAltDlg.setIcon(img_info);
            myAltDlg.setCancelable(true);
            myAltDlg.setButton(DialogInterface.BUTTON_POSITIVE, "確認", altDlgPositiveBtnOnClk);

            position_lvOnClick = position;

            myAltDlg.show();
        }
    };
    private  DialogInterface.OnClickListener altDlgPositiveBtnOnClk = new
            DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
//                    billboardImgList[position_lvOnClick] = img_none;
                }
            };
}
