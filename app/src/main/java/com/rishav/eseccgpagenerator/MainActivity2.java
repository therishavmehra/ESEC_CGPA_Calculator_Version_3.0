package com.rishav.eseccgpagenerator;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.InputFilter;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
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
import java.util.HashMap;
import java.util.Map;

public class MainActivity2 extends AppCompatActivity {
    private AdView mAdView;
    String GameID="5135551";
    String ADID="Interstitial_Android";
    Boolean Testmode=false;
    private InterstitialAd mInterstitialAd;

    protected static final String resultavgkey2 = "com.rishav.eseccgpacalculator.cgpa";
    protected static final String resultperkey2 = "com.rishav.eseccgpacalculator.percentage";

    private static final DecimalFormat decfor = new DecimalFormat("0.000");



    Spinner spinner1,spinner2,spinner3,spinner4,spinner5,spinner6,spinner7,spinner8,spinner9,spinner10,spinner11,spinner12;
    int grade1,grade2,grade3,grade4,grade5,grade6,grade7,grade8,grade9,grade10,grade11,grade12;
    EditText sub1,sub2,sub3,sub4,sub5,sub6,sub7,sub8,sub9,sub10,sub11,sub12;
    double sub1int,sub2int,sub3int,sub4int,sub5int,sub6int,sub7int,sub8int,sub9int,sub10int,sub11int,sub12int;
    String sub1str,sub2str,sub3str,sub4str,sub5str,sub6str,sub7str,sub8str,sub9str,sub10str,sub11str,sub12str;


    String[] grade={"Select","O","A+","A","B+","B"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);



        MobileAds.initialize(this, new OnInitializationCompleteListener() {
            @Override
            public void onInitializationComplete(InitializationStatus initializationStatus) {
                Log.i("Admob", "onInitializationComplete: BannerAD1");
            }
        });






        MobileAds.initialize(this, new OnInitializationCompleteListener() {
            @Override
            public void onInitializationComplete(InitializationStatus initializationStatus) {
                Log.i("Admob", "onInitializationComplete: BannerAD2");
            }
        });




//banner



        AdView adView = new AdView(this);
        adView.setAdSize(AdSize.BANNER);
        adView.setAdUnitId(getString(R.string.ADMOB_BANNER_ID_2));


        MobileAds.initialize(this, new OnInitializationCompleteListener() {
            @Override
            public void onInitializationComplete(InitializationStatus initializationStatus) {
                Log.i("Admob", "onInitializationComplete: BannerAD3");
            }
        });
        mAdView = findViewById(R.id.adView6);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);



        //UNITY


        UnityAds.initialize(MainActivity2.this,GameID, Testmode, new IUnityAdsInitializationListener() {
            @Override
            public void onInitializationComplete() {

            }

            @Override
            public void onInitializationFailed(UnityAds.UnityAdsInitializationError unityAdsInitializationError, String s) {

            }
        });











        EditText numSubjects = findViewById(R.id.num_subjects);

        numSubjects.setFilters(new InputFilter[]{ new InputFilterMinMax("0","12")});

        spinner1=findViewById(R.id.spinner1);
        spinner2=findViewById(R.id.spinner2);
        spinner3=findViewById(R.id.spinner3);
        spinner4=findViewById(R.id.spinner4);
        spinner5=findViewById(R.id.spinner5);
        spinner6=findViewById(R.id.spinner6);
        spinner7=findViewById(R.id.spinner7);
        spinner8=findViewById(R.id.spinner8);
        spinner9=findViewById(R.id.spinner9);
        spinner10=findViewById(R.id.spinner10);
        spinner11=findViewById(R.id.spinner11);
        spinner12=findViewById(R.id.spinner12);


        sub1=findViewById(R.id.sub1);
        sub2=findViewById(R.id.sub2);
        sub3=findViewById(R.id.sub3);
        sub4=findViewById(R.id.sub4);
        sub5=findViewById(R.id.sub5);
        sub6=findViewById(R.id.sub6);
        sub7=findViewById(R.id.sub7);
        sub8=findViewById(R.id.sub8);
        sub9=findViewById(R.id.sub9);
        sub10=findViewById(R.id.sub10);
        sub11=findViewById(R.id.sub11);
        sub12=findViewById(R.id.sub12);


        sub1.setFilters(new InputFilter[]{ new InputFilterMinMax("0","5")});
        sub2.setFilters(new InputFilter[]{ new InputFilterMinMax("0","5")});
        sub3.setFilters(new InputFilter[]{ new InputFilterMinMax("0","5")});
        sub4.setFilters(new InputFilter[]{ new InputFilterMinMax("0","5")});
        sub5.setFilters(new InputFilter[]{ new InputFilterMinMax("0","5")});
        sub6.setFilters(new InputFilter[]{ new InputFilterMinMax("0","5")});
        sub7.setFilters(new InputFilter[]{ new InputFilterMinMax("0","5")});
        sub8.setFilters(new InputFilter[]{ new InputFilterMinMax("0","5")});
        sub9.setFilters(new InputFilter[]{ new InputFilterMinMax("0","5")});
        sub10.setFilters(new InputFilter[]{ new InputFilterMinMax("0","5")});
        sub11.setFilters(new InputFilter[]{ new InputFilterMinMax("0","5")});
        sub12.setFilters(new InputFilter[]{ new InputFilterMinMax("0","5")});






        ArrayAdapter<String> adapter1 = new ArrayAdapter<String>(MainActivity2.this, R.layout.spinner,grade);
        adapter1.setDropDownViewResource(R.layout.spinner);
        spinner1.setAdapter(adapter1);
        spinner1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String value1 =parent.getItemAtPosition(position).toString();


            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {



            }
        });



        ArrayAdapter<String> adapter2 = new ArrayAdapter<String>(MainActivity2.this, R.layout.spinner,grade);
        adapter2.setDropDownViewResource(R.layout.spinner);
        spinner2.setAdapter(adapter2);

        spinner2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String value =parent.getItemAtPosition(position).toString();

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });



        ArrayAdapter<String> adapter3 = new ArrayAdapter<String>(MainActivity2.this, R.layout.spinner,grade);
        adapter3.setDropDownViewResource(R.layout.spinner);
        spinner3.setAdapter(adapter3);

        spinner3.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String value =parent.getItemAtPosition(position).toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


        ArrayAdapter<String> adapter4 = new ArrayAdapter<String>(MainActivity2.this, R.layout.spinner,grade);
        adapter4.setDropDownViewResource(R.layout.spinner);
        spinner4.setAdapter(adapter4);

        spinner4.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String value =parent.getItemAtPosition(position).toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


        ArrayAdapter<String> adapter5 = new ArrayAdapter<String>(MainActivity2.this, R.layout.spinner,grade);
        adapter5.setDropDownViewResource(R.layout.spinner);
        spinner5.setAdapter(adapter5);

        spinner5.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String value =parent.getItemAtPosition(position).toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


        ArrayAdapter<String> adapter6 = new ArrayAdapter<String>(MainActivity2.this, R.layout.spinner,grade);
        adapter6.setDropDownViewResource(R.layout.spinner);
        spinner6.setAdapter(adapter6);

        spinner6.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String value =parent.getItemAtPosition(position).toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


        ArrayAdapter<String> adapter7 = new ArrayAdapter<String>(MainActivity2.this, R.layout.spinner,grade);
        adapter7.setDropDownViewResource(R.layout.spinner);
        spinner7.setAdapter(adapter7);

        spinner7.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String value =parent.getItemAtPosition(position).toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


        ArrayAdapter<String> adapter8 = new ArrayAdapter<String>(MainActivity2.this, R.layout.spinner,grade);
        adapter8.setDropDownViewResource(R.layout.spinner);
        spinner8.setAdapter(adapter8);

        spinner8.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String value =parent.getItemAtPosition(position).toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


        ArrayAdapter<String> adapter9 = new ArrayAdapter<String>(MainActivity2.this, R.layout.spinner,grade);
        adapter9.setDropDownViewResource(R.layout.spinner);
        spinner9.setAdapter(adapter9);

        spinner9.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String value =parent.getItemAtPosition(position).toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


        ArrayAdapter<String> adapter10 = new ArrayAdapter<String>(MainActivity2.this, R.layout.spinner,grade);
        adapter10.setDropDownViewResource(R.layout.spinner);
        spinner10.setAdapter(adapter10);

        spinner10.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String value =parent.getItemAtPosition(position).toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


        ArrayAdapter<String> adapter11 = new ArrayAdapter<String>(MainActivity2.this, R.layout.spinner,grade);
        adapter11.setDropDownViewResource(R.layout.spinner);
        spinner11.setAdapter(adapter11);

        spinner11.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String value =parent.getItemAtPosition(position).toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


        ArrayAdapter<String> adapter12 = new ArrayAdapter<String>(MainActivity2.this, R.layout.spinner,grade);
        adapter12.setDropDownViewResource(R.layout.spinner);
        spinner12.setAdapter(adapter12);

        spinner12.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String value =parent.getItemAtPosition(position).toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });




    }

    public void calc(View view){

        Map<String, Integer> wordValueMap = new HashMap<>();
        wordValueMap.put("Select", 0);
        wordValueMap.put("O", 10);
        wordValueMap.put("A+", 9);
        wordValueMap.put("A", 8);
        wordValueMap.put("B+", 7);
        wordValueMap.put("B", 6);

        sub1str=sub1.getText().toString();
        sub2str=sub2.getText().toString();
        sub3str=sub3.getText().toString();
        sub4str=sub4.getText().toString();
        sub5str=sub5.getText().toString();
        sub6str=sub6.getText().toString();
        sub7str=sub7.getText().toString();
        sub8str=sub8.getText().toString();
        sub9str=sub9.getText().toString();
        sub10str=sub10.getText().toString();
        sub11str=sub11.getText().toString();
        sub12str=sub12.getText().toString();



        sub1int=sub1str.isEmpty() ? 0 : Double.parseDouble(sub1str);
        sub2int=sub2str.isEmpty() ? 0 : Double.parseDouble(sub2str);
        sub3int=sub3str.isEmpty() ? 0 : Double.parseDouble(sub3str);
        sub4int=sub4str.isEmpty() ? 0 : Double.parseDouble(sub4str);
        sub5int=sub5str.isEmpty() ? 0 : Double.parseDouble(sub5str);
        sub6int=sub6str.isEmpty() ? 0 : Double.parseDouble(sub6str);
        sub7int=sub7str.isEmpty() ? 0 : Double.parseDouble(sub7str);
        sub8int=sub8str.isEmpty() ? 0 : Double.parseDouble(sub8str);
        sub9int=sub9str.isEmpty() ? 0 : Double.parseDouble(sub9str);
        sub10int=sub10str.isEmpty() ? 0 : Double.parseDouble(sub10str);
        sub11int=sub11str.isEmpty() ? 0 : Double.parseDouble(sub11str);
        sub12int=sub12str.isEmpty() ? 0 : Double.parseDouble(sub12str);






        String value1=spinner1.getSelectedItem() != null ? spinner1.getSelectedItem().toString() : "0";
        String value2=spinner2.getSelectedItem()!= null ? spinner2.getSelectedItem().toString() : "0";
        String value3=spinner3.getSelectedItem()!= null ? spinner3.getSelectedItem().toString() : "0";
        String value4=spinner4.getSelectedItem()!= null ? spinner4.getSelectedItem().toString() : "0";
        String value5=spinner5.getSelectedItem()!= null ? spinner5.getSelectedItem().toString() : "0";
        String value6=spinner6.getSelectedItem()!= null ? spinner6.getSelectedItem().toString() : "0";
        String value7=spinner7.getSelectedItem()!= null ? spinner7.getSelectedItem().toString() : "0";
        String value8=spinner8.getSelectedItem()!= null ? spinner8.getSelectedItem().toString() : "0";
        String value9=spinner9.getSelectedItem()!= null ? spinner9.getSelectedItem().toString() : "0";
        String value10=spinner10.getSelectedItem()!= null ? spinner10.getSelectedItem().toString() : "0";
        String value11=spinner11.getSelectedItem()!= null ? spinner11.getSelectedItem().toString() : "0";
        String value12=spinner12.getSelectedItem()!= null ? spinner12.getSelectedItem().toString() : "0";


  /*      grade1=Integer.parseInt(value1);
        grade2=Integer.parseInt(value2);
        grade3=Integer.parseInt(value3);
        grade4=Integer.parseInt(value4);
        grade5=Integer.parseInt(value5);
        grade6=Integer.parseInt(value6);
        grade7=Integer.parseInt(value7);
        grade8=Integer.parseInt(value8);
        grade9=Integer.parseInt(value9);
        grade10=Integer.parseInt(value10);
        grade11=Integer.parseInt(value11);
        grade12=Integer.parseInt(value12);          */


         grade1 = wordValueMap.get(value1);
         grade2 = wordValueMap.get(value2);
         grade3 = wordValueMap.get(value3);
         grade4 = wordValueMap.get(value4);
         grade5 = wordValueMap.get(value5);
         grade6 = wordValueMap.get(value6);
         grade7 = wordValueMap.get(value7);
         grade8 = wordValueMap.get(value8);
         grade9 = wordValueMap.get(value9);
         grade10 = wordValueMap.get(value10);
         grade11 = wordValueMap.get(value11);
         grade12 = wordValueMap.get(value12);




        double avg=((grade1*sub1int)+(grade2*sub2int)+(grade3*sub3int)+(grade4*sub4int)+(grade5*sub5int)+(grade6*sub6int)+(grade7*sub7int)+(grade8*sub8int)+(grade9*sub9int)+(grade10*sub10int)+(grade11*sub11int)+(grade12*sub12int))/ (sub1int+sub2int+sub3int+sub4int+sub5int+sub6int+sub7int+sub8int+sub9int+sub10int+sub11int+sub12int);

        double per = avg * 9.5;


        double avgnew = Double.parseDouble(decfor.format(avg));
        double pernew = Double.parseDouble(decfor.format(per));


        String resultavg = Double.toString(avgnew);
        String percen = Double.toString(pernew);



        IUnityAdsShowListener iUnityAdsShowListener=new IUnityAdsShowListener() {
            @Override
            public void onUnityAdsShowFailure(String s, UnityAds.UnityAdsShowError unityAdsShowError, String s1) {
                UnityAds.load(ADID);
                UnityAds.show(MainActivity2.this,ADID);

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
        UnityAds.show(MainActivity2.this,ADID);




//interstitialinitialization



        MobileAds.initialize(MainActivity2.this, new OnInitializationCompleteListener() {
            @Override
            public void onInitializationComplete(InitializationStatus initializationStatus) {

            }
        });




        AdRequest adRequest1 = new AdRequest.Builder().build();

        InterstitialAd.load(MainActivity2.this,getString(R.string.ADMOB_INTERSTITIAL_AD), adRequest1,
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


        //implementation
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
                    Intent intent = new Intent(MainActivity2.this, accurategparesult.class);
                    intent.putExtra(resultavgkey2, resultavg);
                    intent.putExtra(resultperkey2, percen);
                    startActivity(intent);
                }

                @Override
                public void onAdFailedToShowFullScreenContent(AdError adError) {
                    // Called when ad fails to show.
                    Log.e("ADMOB", "Ad failed to show fullscreen content.");
                    Intent intent = new Intent(MainActivity2.this, accurategparesult.class);
                    intent.putExtra(resultavgkey2, resultavg);
                    intent.putExtra(resultperkey2, percen);
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

            mInterstitialAd.show(MainActivity2.this);
        } else {
            Log.d("TAG", "The interstitial ad wasn't ready yet.");
            Intent intent = new Intent(MainActivity2.this, accurategparesult.class);
            intent.putExtra(resultavgkey2, resultavg);
            intent.putExtra(resultperkey2, percen);
            startActivity(intent);

        }










    }


    public void result3(View view){




        EditText numSubjects = findViewById(R.id.num_subjects);

        numSubjects.setFilters(new InputFilter[]{ new InputFilterMinMax("0","12")});

        String enterednum=numSubjects.getText().toString();

        if(enterednum.isEmpty()){
            numSubjects.setError("Enter no. of subjects");
            numSubjects.requestFocus();
        }
        else {
            // Retrieve the entered number of subjects
            int enteredNumSubjects = Integer.parseInt(enterednum);





// Count the number of filled EditText fields
            int numFilledSubjects = 0;
            for (int i = 1; i <= 12; i++) {
                EditText editText = findViewById(getResources().getIdentifier("sub" + i, "id", getPackageName()));
                if (!editText.getText().toString().isEmpty()) {
                    numFilledSubjects++;
                }
            }



            if (enteredNumSubjects == numFilledSubjects) {
                int numSelectedSpinners = 0;
                for (int i = 1; i <= 12; i++) {
                    Spinner spinner = findViewById(getResources().getIdentifier("spinner" + i, "id", getPackageName()));
                    if (spinner.getSelectedItemPosition() != 0) {
                        numSelectedSpinners++;
                    }
                }

                if (enteredNumSubjects == numSelectedSpinners) {
                    calc(view);

                }
                else{
                    Toast.makeText(this, "Please enter grades for all subjects passed...", Toast.LENGTH_LONG).show();
                }


            } else {
                // Display an error message or take other appropriate action
                Toast.makeText(this, "The no. of subjects passed & no.of credit box filled does not match.", Toast.LENGTH_LONG).show();
            }

        }

}
public void clear(View view){

    for (int i = 1; i <= 12; i++) {
        EditText editText = findViewById(getResources().getIdentifier("sub" + i, "id", getPackageName()));
        editText.setText("");
    }

}

    public void reset(View view){

        for (int i = 1; i <= 12; i++) {
            Spinner spinner = findViewById(getResources().getIdentifier("spinner" + i, "id", getPackageName()));
            spinner.setSelection(0);
        }

    }
}