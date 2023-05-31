package com.rishav.eseccgpagenerator;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.InputFilter;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

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

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {
    protected static final String resultavgkey = "com.rishav.eseccgpacalculator.cgpa";
    protected static final String resultperkey = "com.rishav.eseccgpacalculator.percentage";

    private static final DecimalFormat decfor = new DecimalFormat("0.000");

    EditText o,aplus,a,bplus,b,subj;

    String GameID="5135551";
    String ADID="Interstitial_Android";
    Boolean Testmode=false;
    private AdView mAdView;

    private InterstitialAd mInterstitialAd;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        o=findViewById(R.id.o_edtxt);
        aplus=findViewById(R.id.aplus_edtxt);
        a=findViewById(R.id.a_edtxt);
        bplus=findViewById(R.id.bplus_edtxt);
        b=findViewById(R.id.b_edtxt);
        subj=findViewById(R.id.subj);
        o.setFilters(new InputFilter[]{ new InputFilterMinMax("0","12")});
        aplus.setFilters(new InputFilter[]{ new InputFilterMinMax("0","12")});
        a.setFilters(new InputFilter[]{ new InputFilterMinMax("0","12")});
        bplus.setFilters(new InputFilter[]{ new InputFilterMinMax("0","12")});
        b.setFilters(new InputFilter[]{ new InputFilterMinMax("0","12")});
        subj.setFilters(new InputFilter[]{ new InputFilterMinMax("0","12")});



//banner



        AdView adView = new AdView(this);
        adView.setAdSize(AdSize.BANNER);
        adView.setAdUnitId(getString(R.string.ADMOB_BANNER_ID));


        MobileAds.initialize(this, new OnInitializationCompleteListener() {
            @Override
            public void onInitializationComplete(InitializationStatus initializationStatus) {
                Log.i("Admob", "onInitializationComplete: BannerAD3");
            }
        });
        mAdView = findViewById(R.id.adView5);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);

        // interstitial ad


        MobileAds.initialize(this, new OnInitializationCompleteListener() {
            @Override
            public void onInitializationComplete(InitializationStatus initializationStatus) {

            }
        });




        AdRequest adRequest1 = new AdRequest.Builder().build();

        InterstitialAd.load(this,getString(R.string.ADMOB_INTERSTITIAL_AD), adRequest1,
                new InterstitialAdLoadCallback() {
                    @Override
                    public void onAdLoaded(@NonNull InterstitialAd interstitialAd) {
                        // The mInterstitialAd reference will be null until
                        // an ad is loaded.
                        mInterstitialAd = interstitialAd;
                        Log.i("ADMOB", "oninterstitialAdLoaded");
                    }

                    @Override
                    public void onAdFailedToLoad(@NonNull LoadAdError loadAdError) {
                        // Handle the error
                        Log.d("ADMOB", loadAdError.toString());
                        mInterstitialAd = null;
                    }
                });








    }

    public void result(View view) {



        String ostr=o.getText().toString();
        String aplusstr=aplus.getText().toString();
        String astr=a.getText().toString();
        String bplusstr=bplus.getText().toString();
        String bstr=b.getText().toString();

        String subjstr=subj.getText().toString();


        if(subjstr.isEmpty()){
            subj.setError("Please Enter Number of Subj Passed");
            subj.requestFocus();
        }

        else if(ostr.isEmpty() && aplusstr.isEmpty() && astr.isEmpty() && bplusstr.isEmpty() && bstr.isEmpty()) {
            o.setError("PLEASE ENTER A VALUE");
            aplus.setError("PLEASE ENTER A VALUE");
            a.setError("PLEASE ENTER A VALUE");
            bplus.setError("PLEASE ENTER A VALUE");
            b.setError("PLEASE ENTER A VALUE");
            o.requestFocus();
            aplus.requestFocus();
            a.requestFocus();
            bplus.requestFocus();
            b.requestFocus();

        }

        else if(ostr.isEmpty() && aplusstr.isEmpty() && astr.isEmpty() && bplusstr.isEmpty() ){
            o.setText("0");
            aplus.setText("0");
            a.setText("0");
            bplus.setText("0");
            calculation(view);

        }
        else if(ostr.isEmpty() && aplusstr.isEmpty() && astr.isEmpty() && bstr.isEmpty() ){
            o.setText("0");
            aplus.setText("0");
            a.setText("0");
            b.setText("0");
            calculation(view);

        }
        else if(ostr.isEmpty() && astr.isEmpty() && bstr.isEmpty() && bplusstr.isEmpty() ){
            o.setText("0");
            a.setText("0");
            bplus.setText("0");
            b.setText("0");
            calculation(view);

        }
        else if(ostr.isEmpty() && aplusstr.isEmpty() && bstr.isEmpty() && bplusstr.isEmpty() ){
            o.setText("0");
            aplus.setText("0");
            bplus.setText("0");
            b.setText("0");
            calculation(view);

        }
        else if(aplusstr.isEmpty() && astr.isEmpty() && bstr.isEmpty() && bplusstr.isEmpty() ){
            aplus.setText("0");
            a.setText("0");
            bplus.setText("0");
            b.setText("0");
            calculation(view);

        }else if(ostr.isEmpty() && aplusstr.isEmpty() && astr.isEmpty() ){
            o.setText("0");
            a.setText("0");
            aplus.setText("0");
            calculation(view);

        }
        else if(ostr.isEmpty() && astr.isEmpty()  && bplusstr.isEmpty() ){
            o.setText("0");
            a.setText("0");
            bplus.setText("0");
            calculation(view);

        }
        else if(ostr.isEmpty() && aplusstr.isEmpty()  && bplusstr.isEmpty() ){
            o.setText("0");
            aplus.setText("0");
            bplus.setText("0");
            calculation(view);

        }
        else if(ostr.isEmpty() && aplusstr.isEmpty()  && bstr.isEmpty() ){
            o.setText("0");
            aplus.setText("0");
            b.setText("0");
            calculation(view);

        }
        else if(ostr.isEmpty() && astr.isEmpty()  && bstr.isEmpty() ){
            o.setText("0");
            a.setText("0");
            b.setText("0");
            calculation(view);

        }
        else if(ostr.isEmpty() && bplusstr.isEmpty()  && bstr.isEmpty() ){
            o.setText("0");
            b.setText("0");
            bplus.setText("0");
            calculation(view);

        }
        else if(aplusstr.isEmpty() && astr.isEmpty()  && bstr.isEmpty() ){
            b.setText("0");
            a.setText("0");
            aplus.setText("0");
            calculation(view);

        }
        else if(aplusstr.isEmpty() && astr.isEmpty()  && bplusstr.isEmpty() ){
            bplus.setText("0");
            a.setText("0");
            aplus.setText("0");
            calculation(view);

        }
        else if(aplusstr.isEmpty() && bstr.isEmpty()  && bplusstr.isEmpty() ){
            bplus.setText("0");
            b.setText("0");
            aplus.setText("0");
            calculation(view);

        }
        else if(astr.isEmpty() && bplusstr.isEmpty()  && bstr.isEmpty() ){
            b.setText("0");
            a.setText("0");
            bplus.setText("0");
            calculation(view);

        }
        else if(ostr.isEmpty() && aplusstr.isEmpty()){
            o.setText("0");
            aplus.setText("0");
            calculation(view);

        }
        else if(ostr.isEmpty() && astr.isEmpty()){
            o.setText("0");
            a.setText("0");
            calculation(view);

        }
        else if(ostr.isEmpty() && bplusstr.isEmpty()){
            o.setText("0");
            bplus.setText("0");
            calculation(view);

        }
        else if(ostr.isEmpty() && bstr.isEmpty()){
            o.setText("0");
            b.setText("0");
            calculation(view);

        }
        else if(bplusstr.isEmpty() && bstr.isEmpty()){
            bplus.setText("0");
            b.setText("0");
            calculation(view);
        }
        else if(aplusstr.isEmpty() && astr.isEmpty()){
            aplus.setText("0");
            a.setText("0");
            calculation(view);
        }
        else if(aplusstr.isEmpty() && bplusstr.isEmpty()){
            aplus.setText("0");
            bplus.setText("0");
            calculation(view);
        }
        else if(aplusstr.isEmpty() && bstr.isEmpty()){
            aplus.setText("0");
            b.setText("0");
            calculation(view);
        }
        else if(astr.isEmpty() && bplusstr.isEmpty()){
            a.setText("0");
            bplus.setText("0");
            calculation(view);
        }
        else if(astr.isEmpty() && bstr.isEmpty()){
            a.setText("0");
            b.setText("0");
            calculation(view);
        }

        else if(ostr.isEmpty()) {
            o.setText("0");
            calculation(view);
        }
        else  if(aplusstr.isEmpty()) {
            aplus.setText("0");
            calculation(view);
        }
        else  if(astr.isEmpty()) {
            a.setText("0");
            calculation(view);
        }
        else  if(bplusstr.isEmpty()) {
            bplus.setText("0");
            calculation(view);
        }
        else  if(bstr.isEmpty()) {
            b.setText("0");
            calculation(view);
        }

        else{
            calculation(view);
        }

    }

    public void calculation(View view){

        String ostr=o.getText().toString();
        String aplusstr=aplus.getText().toString();
        String astr=a.getText().toString();
        String bplusstr=bplus.getText().toString();
        String bstr=b.getText().toString();

        String subjstr=subj.getText().toString();


        int onum=Integer.parseInt(ostr);
        int aplusnum=Integer.parseInt(aplusstr);
        int anum=Integer.parseInt(astr);
        int bplusnum=Integer.parseInt(bplusstr);
        int bnum=Integer.parseInt(bstr);

        int subnum=Integer.parseInt(subjstr);


        if(subnum==(onum+aplusnum+anum+bplusnum+bnum)) {

            double avg = ((onum * 10) + (aplusnum * 9) + (anum * 8) + (bplusnum * 7) + (bnum * 6)) / (double) (onum + aplusnum + anum + bplusnum + bnum);
            double per = avg * 9.5;

            double avgnew = Double.parseDouble(decfor.format(avg));
            double pernew = Double.parseDouble(decfor.format(per));


            String resultavg = Double.toString(avgnew);
            String percen = Double.toString(pernew);


            if (mInterstitialAd != null) {
                mInterstitialAd.setFullScreenContentCallback(new FullScreenContentCallback(){
                    @Override
                    public void onAdClicked() {
                        // Called when a click is recorded for an ad.
                        Log.d("ADMOB", "Ad was clicked.");
                    }

                    @Override
                    public void onAdDismissedFullScreenContent() {
                        // Called when ad is dismissed.
                        // Set the ad reference to null so you don't show the ad a second time.
                        Log.d("ADMOB", "Ad dismissed fullscreen content.");
                        mInterstitialAd = null;
                        Intent intent = new Intent(MainActivity.this, getresult.class);
                        intent.putExtra(resultavgkey, resultavg);
                        intent.putExtra(resultperkey, percen);
                        startActivity(intent);
                    }

                    @Override
                    public void onAdFailedToShowFullScreenContent(AdError adError) {
                        // Called when ad fails to show.
                        Log.e("ADMOB", "Ad failed to show fullscreen content.");
                        Intent intent = new Intent(MainActivity.this, getresult.class);
                        intent.putExtra(resultavgkey, resultavg);
                        intent.putExtra(resultperkey, percen);
                        startActivity(intent);
                    }

                    @Override
                    public void onAdImpression() {
                        // Called when an impression is recorded for an ad.
                        Log.d("ADMOB", "Ad recorded an impression.");
                    }

                    @Override
                    public void onAdShowedFullScreenContent() {
                        // Called when ad is shown.
                        Log.d("ADMOB", "Ad showed fullscreen content.");
                    }
                });

                mInterstitialAd.show(MainActivity.this);

            } else {
                Log.d("TAG", "The interstitial ad wasn't ready yet.");
                Intent intent = new Intent(MainActivity.this, getresult.class);
                intent.putExtra(resultavgkey, resultavg);
                intent.putExtra(resultperkey, percen);
                startActivity(intent);
            }


        }
        else{

            Toast.makeText(MainActivity.this, "Number of SUBJ PASSED must be equal total number of GRADE", Toast.LENGTH_LONG).show();
        }


    }



}