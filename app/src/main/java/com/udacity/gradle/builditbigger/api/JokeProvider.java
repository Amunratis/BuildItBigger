package com.udacity.gradle.builditbigger.api;

import android.os.AsyncTask;

import java.io.IOException;

public class JokeProvider extends AsyncTask<Void, Void, String> {

    private JokeCallback callback;

    public JokeProvider(JokeCallback callback) {
        this.callback = callback;
    }

    @Override
    protected String doInBackground(Void... voids) {
        try {
            //curiously, the method indulge() exists only in the build folder, it isn't present after we run 'gradle clean'
            return MyApiService
                    .getInstance()/*get MyApi instance(generated class) T*/
                    .indulge()/*Create a request for the method "indulge". This request holds the parameters needed by the myApi server.  After setting any optional
             * parameters, call the {@link Indulge#execute()} method to invoke the remote operation.*/
                    .execute()
                    .getData();
        } catch (IOException e) {
            return e.getMessage();
        }
    }

    @Override
    protected void onPostExecute(String joke) {
        callback.onJokeDownloaded(joke);
    }
}
