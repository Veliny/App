package com.example.remindcalender.remindercalendar;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
import com.huawei.hmf.tasks.OnFailureListener;
import com.huawei.hmf.tasks.OnSuccessListener;
import com.huawei.hmf.tasks.Task;
import com.huawei.hms.ads.AdParam;
import com.huawei.hms.ads.BannerAdSize;
import com.huawei.hms.ads.HwAds;
import com.huawei.hms.ads.banner.BannerView;
import com.huawei.hms.common.ApiException;
import com.huawei.hms.support.account.AccountAuthManager;
import com.huawei.hms.support.account.request.AccountAuthParams;
import com.huawei.hms.support.account.request.AccountAuthParamsHelper;
import com.huawei.hms.support.account.result.AuthAccount;
import com.huawei.hms.support.account.service.AccountAuthService;

public class MainActivity extends AppCompatActivity {
    
    private int currentDays;
    private int currentMonths;
    private int currentYears;
    private int Daysindex;
    private int Monthsindex;
    private int Yearsindex;
    arrayClass arr = new arrayClass();
//    private static final String TAG = "Account";
//    private AccountAuthParams mAuthParam;
//    private AccountAuthService mAuthService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        CalendarView calendarView = findViewById(R.id.calendarview);
        TextView text = findViewById(R.id.tampilkan);
        Button addActivity = findViewById(R.id.buttonadd);

//        findViewById(R.id.HuaweiIdSignOutButton).setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Task<Void> signOutTask = mAuthService.signOut();
//            signOutTask.addOnSuccessListener(new OnSuccessListener<Void>() {
//                @Override
//                public void onSuccess(Void aVoid) {
//                    Log.i(TAG, "signOut Success");
//                    Intent intent = new Intent(MainActivity.this, QuickStartActivity.class);
//                    startActivity(intent);
//                    finish();
//                }
//            }).addOnFailureListener(new OnFailureListener() {
//                @Override
//                public void onFailure(Exception e) {
//                    Log.i(TAG, "signOut fail");
//                }
//            });
//        }
//
//        });


        // Initialize the HUAWEI Ads SDK.
        HwAds.init(this);

        // Obtain BannerView based on the configuration in layout/ad_fragment.xml.
        BannerView bottomBannerView = findViewById(R.id.hw_banner_view);
        AdParam adParam = new AdParam.Builder().build();
        bottomBannerView.loadAd(adParam);

        // Call new BannerView(Context context) to create a BannerView class.
//        BannerView topBannerView = new BannerView(this);
//        topBannerView.setAdId("testw6vs28auh3");
//        topBannerView.setBannerAdSize(BannerAdSize.BANNER_SIZE_SMART);
//        topBannerView.loadAd(adParam);
//
//        RelativeLayout rootView = findViewById(R.id.root_view);
//        rootView.addView(topBannerView);



        calendarView.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(@NonNull CalendarView view, int year, int month, int dayOfMonth) {
                Log.e("OnSelectedDayChange", "User moved");

                if (arr.isEmpty()) {
                    Log.e("Main", "Array Empty");
                    text.setText("");
                } else if (arr.isEventExist(year, month + 1, dayOfMonth)) {
                    Log.e("Main", "Event Exist");
                    Remind data = arr.getTimeData(year, month + 1, dayOfMonth);

                    text.setText("Event : " + data.getActivity() + " Time : " + data.getHour() + ":" + data.getMinute());
                } else {
                    Log.e("Main", "Event doesnt exist");
                }


                addActivity.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(MainActivity.this , input.class);
                        intent.putExtra("day", dayOfMonth );
                        intent.putExtra("month", month+1);
                        intent.putExtra("year", year);
                        startActivity(intent);
                    }
                });
            }
        });

//        private void signOut() {
//            Task<Void> signOutTask = mAuthService.signOut();
//            signOutTask.addOnSuccessListener(new OnSuccessListener<Void>() {
//                @Override
//                public void onSuccess(Void aVoid) {
//                    Log.i(TAG, "signOut Success");
//                }
//            }).addOnFailureListener(new OnFailureListener() {
//                @Override
//                public void onFailure(Exception e) {
//                    Log.i(TAG, "signOut fail");
//                }
//            });
//        }

        Intent intent = this.getIntent();


//        if(!rem.isEmpty()) {
////        Remind rem = getIntent().getParcelableExtra("time");
//
//        String show = "Date : " + rem.get(0);
////                +"\nMonth : " + rem.getMonth()
////                +"\nYear : " + rem.getYear()
////                +"\nTime: " + rem.getHour() + ":" + rem.getMinute();
//        text.setText(show);
//        }
    }
}