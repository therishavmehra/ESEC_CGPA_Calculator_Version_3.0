package com.rishav.eseccgpacalculator;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.gms.ads.AdError;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.FullScreenContentCallback;
import com.google.android.gms.ads.LoadAdError;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;
import com.google.android.gms.ads.interstitial.InterstitialAd;
import com.google.android.gms.ads.interstitial.InterstitialAdLoadCallback;
import com.unity3d.ads.IUnityAdsInitializationListener;
import com.unity3d.ads.IUnityAdsShowListener;
import com.unity3d.ads.UnityAds;

public class getresult extends AppCompatActivity {
    TextView cgpa,perc;
    Button home,back;
    String GameID="5135551";
    String ADID="Interstitial_Android";
    private AdView mAdView;
    Boolean Testmode=false;

    private InterstitialAd mInterstitialAd;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_getresult);

        UnityAds.initialize(getresult.this,GameID, Testmode, new IUnityAdsInitializationListener() {
            @Override
            public void onInitializationComplete() {

            }

            @Override
            public void onInitializationFailed(UnityAds.UnityAdsInitializationError unityAdsInitializationError, String s) {

            }
        });



        cgpa=findViewById(R.id.cgparesult);
        perc=findViewById(R.id.perresult);
        Intent intent=getIntent();
        String cgpatxt=intent.getStringExtra(MainActivity.resultavgkey);
        String pertext=intent.getStringExtra(MainActivity.resultperkey);

        cgpa.setText(cgpatxt);
        perc.setText(pertext+" %");



        home=findViewById(R.id.back);
        back=findViewById(R.id.gotohome);


        MobileAds.initialize(this, new OnInitializationCompleteListener() {
            @Override
            public void onInitializationComplete(InitializationStatus initializationStatus) {

            }
        });









        MobileAds.initialize(this, new OnInitializationCompleteListener() {
            @Override
            public void onInitializationComplete(InitializationStatus initializationStatus) {

            }
        });




//banner



        AdView adView = new AdView(this);
        adView.setAdSize(AdSize.BANNER);
        adView.setAdUnitId("ca-app-pub-6926702628956925/3083598726");


        MobileAds.initialize(this, new OnInitializationCompleteListener() {
            @Override
            public void onInitializationComplete(InitializationStatus initializationStatus) {

            }
        });
        mAdView = findViewById(R.id.adView1);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);









        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                IUnityAdsShowListener iUnityAdsShowListener=new IUnityAdsShowListener() {
                    @Override
                    public void onUnityAdsShowFailure(String s, UnityAds.UnityAdsShowError unityAdsShowError, String s1) {
                        UnityAds.load(ADID);
                        UnityAds.show(getresult.this,ADID);
                    }

                    @Override
                    public void onUnityAdsShowStart(String s) {

                    }

                    @Override
                    public void onUnityAdsShowClick(String s) {

                    }

                    @Override
                    public void onUnityAdsShowComplete(String s, UnityAds.UnityAdsShowCompletionState unityAdsShowCompletionState) {

                    }
                };

                UnityAds.load(ADID);
                UnityAds.show(getresult.this,ADID);



                startActivity(new Intent(getresult.this,MainActivity.class));
            }
        });

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                IUnityAdsShowListener iUnityAdsShowListener=new IUnityAdsShowListener() {
                    @Override
                    public void onUnityAdsShowFailure(String s, UnityAds.UnityAdsShowError unityAdsShowError, String s1) {
                        UnityAds.load(ADID);
                        UnityAds.show(getresult.this,ADID);
                    }

                    @Override
                    public void onUnityAdsShowStart(String s) {

                    }

                    @Override
                    public void onUnityAdsShowClick(String s) {

                    }

                    @Override
                    public void onUnityAdsShowComplete(String s, UnityAds.UnityAdsShowCompletionState unityAdsShowCompletionState) {

                    }
                };

                UnityAds.load(ADID);
                UnityAds.show(getresult.this,ADID);
                startActivity(new Intent(getresult.this,startpage.class));

            }
        });





    }}