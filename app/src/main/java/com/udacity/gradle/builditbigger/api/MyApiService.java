package com.udacity.gradle.builditbigger.api;

import com.google.api.client.extensions.android.http.AndroidHttp;
import com.google.api.client.extensions.android.json.AndroidJsonFactory;
import com.google.api.client.googleapis.services.AbstractGoogleClientRequest;
import com.google.api.client.googleapis.services.GoogleClientRequestInitializer;
import com.udacity.gradle.builditbigger.backend.myApi.MyApi;

import java.io.IOException;

public final class MyApiService {

    //This is default emulator address
    private static final String BASE_URL = "http://10.0.2.2:8080/_ah/api/";

    //The MyApi class originates from the build folder, it isn't present if you run "gradle clean" task
    private static MyApi instance;

    private MyApiService() {
    }

    public static MyApi getInstance() {
        if (instance == null) {
            instance = getNewInstance();
        }
        return instance;
    }

    //generated MyApi class
    private static MyApi getNewInstance() {
        MyApi.Builder builder = new MyApi.Builder(AndroidHttp.newCompatibleTransport(),
                new AndroidJsonFactory(), null)
                .setRootUrl(BASE_URL)
                .setGoogleClientRequestInitializer(new GoogleClientRequestInitializer() {
                    @Override
                    public void initialize(AbstractGoogleClientRequest<?> abstractGoogleClientRequest) throws IOException {
                        abstractGoogleClientRequest.setDisableGZipContent(true);
                    }
                });
        return builder.build();
    }
}
