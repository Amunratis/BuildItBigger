package com.udacity.gradle.builditbigger;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.justjoking.DisplayJoke;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;
import com.udacity.gradle.builditbigger.api.JokeCallback;
import com.udacity.gradle.builditbigger.api.JokeProvider;


/**
 * A placeholder fragment containing a simple view.
 */
public class MainActivityFragment extends Fragment {

    public MainActivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_main, container, false);

        AdView mAdView = (AdView) root.findViewById(R.id.adView);
        // Create an ad request. Check logcat output for the hashed device ID to
        // get test ads on a physical device. e.g.
        // "Use AdRequest.Builder.addTestDevice("ABCDEF012345") to get test ads on this device."
        MobileAds.initialize(getContext(), "ca-app-pub-3940256099942544~3347511713");
        AdRequest adRequest = new AdRequest.Builder()
                .addTestDevice(AdRequest.DEVICE_ID_EMULATOR)
                .build();
        mAdView.loadAd(adRequest);
        tellJoke(root);

        return root;
    }

    private void tellJoke(View root) {


        Button clickButton = (Button) root.findViewById(R.id.button);
        clickButton.setOnClickListener( new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                new JokeProvider(getJokeCallback()).execute();
            }
        });


    }



    public JokeCallback getJokeCallback() {
        return new JokeCallback() {
            @Override
            public void onJokeDownloaded(String joke) {

                Intent intent = new Intent(getContext(), DisplayJoke.class);
                intent.putExtra(DisplayJoke.JOKE_EXTRA, joke);
                startActivity(intent);
            }
        };
    }
}
