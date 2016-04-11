package com.megogrid.megoward;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;




public class ConnectActivity extends Activity {
    RelativeLayout card1, card2, card3;
//    AuthorisedPreference authorisedPreference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.connect_main);
//        authorisedPreference = new AuthorisedPreference(ConnectActivity.this);
        initView();
    }

    private void initView() {

        card1 = (RelativeLayout) findViewById(R.id.rl_card1);
        card2 = (RelativeLayout) findViewById(R.id.rl_card2);
        card3 = (RelativeLayout) findViewById(R.id.rl_card3);

        card1.setOnClickListener(mClick);
        card2.setOnClickListener(mClick);
        card3.setOnClickListener(mClick);


    }

    View.OnClickListener mClick = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            int id = view.getId();
//            if (id == card1.getId()) {
//                authorisedPreference.clear();
//                MeUserData.getInstance(ConnectActivity.this).clear();
//                authorisedPreference.setMeUserConfig("facegplus");
//                Toast.makeText(ConnectActivity.this, "Please relaunch application", Toast.LENGTH_SHORT).show();
//                System.out.println("<<<checking getmewardid" + authorisedPreference.getMewardId() + authorisedPreference.getMeUserConfig() + MeUserData.getInstance(ConnectActivity.this).getRegConfig());
//                finish();
//
//            } else if (id == card2.getId()) {
//                authorisedPreference.clear();
//                MeUserData.getInstance(ConnectActivity.this).clear();
//                authorisedPreference.setMeUserConfig("email");
//                Toast.makeText(ConnectActivity.this, "Please relaunch application", Toast.LENGTH_SHORT).show();
//                System.out.println("<<<checking getmewardid" + authorisedPreference.getMewardId() + authorisedPreference.getMeUserConfig() + MeUserData.getInstance(ConnectActivity.this).getRegConfig());
//                finish();
//            } else if (id == card3.getId()) {
//                authorisedPreference.clear();
//                MeUserData.getInstance(ConnectActivity.this).clear();
//                authorisedPreference.setMeUserConfig("phone");
//                Toast.makeText(ConnectActivity.this, "Please relaunch application", Toast.LENGTH_SHORT).show();
//                System.out.println("<<<checking getmewardid" + authorisedPreference.getMewardId() + authorisedPreference.getMeUserConfig() + MeUserData.getInstance(ConnectActivity.this).getRegConfig());
//                finish();
//            }
//            Intent intent = new Intent("Exit MainActivity");
//            LocalBroadcastManager.getInstance(ConnectActivity.this).sendBroadcast(intent);
    }
    };
}
