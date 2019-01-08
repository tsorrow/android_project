package com.tsorrow.junior.device;

import android.hardware.Camera;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;
import android.widget.Toast;

import com.tsorrow.junior.device.adapter.CameraAdapter;
import com.tsorrow.junior.device.bean.CameraInfo;

import java.util.ArrayList;

public class CameraInfoActivity extends AppCompatActivity {
    private final static String TAG = "CameraInfoActivity";
    private ListView lv_camera;
    private String mDesc = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_camera_info);
        lv_camera = (ListView) findViewById(R.id.lv_camera);
        checkCamera();
    }

    private void checkCamera() {
        ArrayList<CameraInfo> cameraList = new ArrayList<CameraInfo>();
        int cameraCount = Camera.getNumberOfCameras();
        mDesc = String.format("%s摄像头个数=%d",mDesc,cameraCount);
        for (int i=0;i<cameraCount;i++){
            CameraInfo info = new CameraInfo();
            Camera camera = Camera.open(i);
            Camera.Parameters params = camera.getParameters();
            info.camera_type = (i==0)?"前置":"后置";
            info.flash_mode = params.getFlashMode();
            info.focus_mode = params.getFocusMode();
            info.scene_mode = params.getSceneMode();
            info.color_effect = params.getColorEffect();
            info.white_balance = params.getWhiteBalance();
            info.max_zoom = params.getMaxZoom();
            info.zoom = params.getZoom();
            info.resolutionList = params.getSupportedPreviewSizes();
            camera.release();
            cameraList.add(info);
        }
        CameraAdapter adapter = new CameraAdapter(this,cameraList);
        lv_camera.setAdapter(adapter);

    }
}
