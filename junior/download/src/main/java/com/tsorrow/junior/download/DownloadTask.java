package com.tsorrow.junior.download;

import android.os.AsyncTask;

public class DownloadTask extends AsyncTask<String,Integer,Integer> {
    private static final int TYPE_SECCESS = 0;
    private static final int TYPE_FAILED = 1;
    private static final int TYPE_PAUSED = 2;
    private static final int TYPE_CANCELED = 3;



    @Override
    protected Integer doInBackground(String... strings) {
        return null;
    }
}
