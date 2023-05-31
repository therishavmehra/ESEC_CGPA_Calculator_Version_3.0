package com.rishav.eseccgpagenerator;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

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

public class startpage extends AppCompatActivity {

    Button gpacalc, cgpacalc, gpacalc2;
    private AdView mAdView;
    private InterstitialAd mInterstitialAd;
    ImageView ig,fb,ln;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_startpage);




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
        mAdView = findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);


        //interstitial
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


        gpacalc = findViewById(R.id.gpacalc);
        gpacalc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                MobileAds.initialize(startpage.this, new OnInitializationCompleteListener() {
                    @Override
                    public void onInitializationComplete(InitializationStatus initializationStatus) {

                    }
                });




                AdRequest adRequest1 = new AdRequest.Builder().build();

                InterstitialAd.load(startpage.this,getString(R.string.ADMOB_INTERSTITIAL_AD), adRequest1,
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

                            startActivity(new Intent(startpage.this,MainActivity.class));
                        }

                        @Override
                        public void onAdFailedToShowFullScreenContent(AdError adError) {
                            // Called when ad fails to show.
                            Log.e("ADMOB", "Ad failed to show fullscreen content.");

                            startActivity(new Intent(startpage.this,MainActivity.class));
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

                    mInterstitialAd.show(startpage.this);
                } else {
                    Log.d("TAG", "The interstitial ad wasn't ready yet.");
                    startActivity(new Intent(startpage.this,MainActivity.class));
                }
            }
        });



        cgpacalc = findViewById(R.id.cgpacalc);
        cgpacalc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                MobileAds.initialize(startpage.this, new OnInitializationCompleteListener() {
                    @Override
                    public void onInitializationComplete(InitializationStatus initializationStatus) {

                    }
                });




                AdRequest adRequest1 = new AdRequest.Builder().build();

                InterstitialAd.load(startpage.this,getString(R.string.ADMOB_INTERSTITIAL_AD), adRequest1,
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
                            startActivity(new Intent(startpage.this,cgpacalc.class));
                        }

                        @Override
                        public void onAdFailedToShowFullScreenContent(AdError adError) {
                            // Called when ad fails to show.
                            Log.e("ADMOB", "Ad failed to show fullscreen content.");
                            startActivity(new Intent(startpage.this,cgpacalc.class));
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

                    mInterstitialAd.show(startpage.this);
                } else {
                    Log.d("TAG", "The interstitial ad wasn't ready yet.");
                    startActivity(new Intent(startpage.this,cgpacalc.class));
                }
            }
        });





        ig = findViewById(R.id.ig);
        fb=findViewById(R.id.fb);
        ln=findViewById(R.id.ln);


        ig.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri uri = Uri.parse("https://www.instagram.com/the_rishav_mehra");
                Intent insta = new Intent(Intent.ACTION_VIEW,uri);
                insta.setPackage("com.instagram.android");

                try{
                    startActivity(insta);
                }
                catch (ActivityNotFoundException e){

                    startActivity(new Intent(Intent.ACTION_VIEW,Uri.parse("https://www.instagram.com/the_rishav_mehra")));
                }
            }
        });


        fb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri uri = Uri.parse("https://facebook.com/therishavmehra");
                Intent face = new Intent(Intent.ACTION_VIEW,uri);
                face.setPackage("com.facebook.android");

                try{
                    startActivity(face);
                }
                catch (ActivityNotFoundException e){

                    startActivity(new Intent(Intent.ACTION_VIEW,Uri.parse("https://facebook.com/therishavmehra")));
                }
            }
        });

        ln.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri uri = Uri.parse("https://in.linkedin.com/in/therishavmehra");
                Intent linked = new Intent(Intent.ACTION_VIEW,uri);
                linked.setPackage("com.linkedin.android");

                try{
                    startActivity(linked);
                }
                catch (ActivityNotFoundException e){

                    startActivity(new Intent(Intent.ACTION_VIEW,Uri.parse("https://in.linkedin.com/in/rishav-kumar-47048b1b9")));
                }
            }
        });

    }

    public void mainactivity2(View view) {

        MobileAds.initialize(startpage.this, new OnInitializationCompleteListener() {
            @Override
            public void onInitializationComplete(InitializationStatus initializationStatus) {

            }
        });




        AdRequest adRequest1 = new AdRequest.Builder().build();

        InterstitialAd.load(startpage.this,getString(R.string.ADMOB_INTERSTITIAL_AD), adRequest1,
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


//showinginterstitial

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
                        startActivity(new Intent(startpage.this,MainActivity2.class));
                    }

                    @Override
                    public void onAdFailedToShowFullScreenContent(AdError adError) {
                        // Called when ad fails to show.
                        Log.e("ADMOB", "Ad failed to show fullscreen content.");
                        startActivity(new Intent(startpage.this,MainActivity2.class));
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

                mInterstitialAd.show(startpage.this);
            } else {
                Log.d("TAG", "The interstitial ad wasn't ready yet.");
                startActivity(new Intent(startpage.this,MainActivity2.class));

        }
    }
}