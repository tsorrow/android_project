package com.tsorrow.junior.uhf;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.rscja.deviceapi.RFIDWithUHF;
import com.rscja.deviceapi.entity.SimpleRFIDEntity;
import com.rscja.deviceapi.exception.ConfigurationException;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    private RFIDWithUHF mReader = null;
    private Button scan;
    private EditText scan_text;
    private Button start_scan;
    private Button stop_scan;
    private EditText uhf_text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        scan = (Button) findViewById(R.id.scan);
        scan_text = (EditText)findViewById(R.id.scan_text);
        start_scan = findViewById(R.id.start_scan);
        stop_scan = findViewById(R.id.stop_scan);
        uhf_text = findViewById(R.id.uhf_text);
        scan.setOnClickListener(this);
        start_scan.setOnClickListener(this);
        stop_scan.setOnClickListener(this);
        try {
            mReader = RFIDWithUHF.getInstance();
            mReader.init();
            mReader.setPower(20);
            mReader.setEPCTIDMode(true);
            //mReader.setFrequencyMode();
        } catch (ConfigurationException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.scan:
                //String accessPwd, RFIDWithUHF.BankEnum filterBank, int filterPtr, int filterCnt, String filterData, RFIDWithUHF.BankEnum bank, int ptr, int cnt
                String s = mReader.readData("00000000", RFIDWithUHF.BankEnum.TID,0,0,"00",RFIDWithUHF.BankEnum.TID,0,2);
                //Toast.makeText(MainActivity.this,s,Toast.LENGTH_SHORT).show();
                scan_text.setText(s);
                break;
            case R.id.start_scan:
                mReader.startInventory(0,1);
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        //while(true){}
                            //String[] read = mReader.readTagFromBuffer();
                            //Log.d("aaa","aaa");
                        String strTid;
                        String strResult;
                        String[] res = null;
                        while (true) {
                            res = mReader.readTagFromBuffer();
                            if (res != null) {
                                strTid = res[0];
                                if (strTid.length() != 0 && !strTid.equals("0000000" +
                                        "000000000") && !strTid.equals("000000000000000000000000")) {
                                    strResult = "TID:" + strTid + "\n";
                                } else {
                                    strResult = "";
                                }
                                Log.i("data","EPC:"+res[1]+"|"+strResult);

                            }
                        }

                    }
                }).start();
                break;
            case R.id.stop_scan:
                mReader.stopInventory();
                break;
            default:
                break;
        }


    }

    @Override
    protected void onDestroy(){
        super.onDestroy();
        mReader.free();
    }
}
