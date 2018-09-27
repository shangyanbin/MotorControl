package com.easicare.motorcontrol;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity implements SerialPortOperation.OnDataReceiveListener {

    @BindView(R.id.et_distance_main)
    EditText etDistanceMain;
    @BindView(R.id.lv_data_receive_main)
    ListView lvDataReceiveMain;
    @BindView(R.id.sp_selectMotor_main)
    Spinner spSelectMotorMain;
    @BindView(R.id.et_speed_main)
    EditText etSpeedMain;
    @BindView(R.id.sp_selectOrientation_main)
    Spinner spSelectOrientationMain;
    @BindView(R.id.et_position_main)
    EditText etPositionMain;

    private SerialPortOperation serialPortOperation;
    private ArrayList<String> messageList;
    private ArrayAdapter<String> adapter;

    private String[] motorArr = {"M1", "M2"};
    private String motorName = "M1";

    private String[] orientationArr = {"正向", "反向"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        initDate();
        initListener();
    }

    private void initListener() {
        spSelectMotorMain.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                motorName = motorArr[i];
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        spSelectOrientationMain.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                serialPortOperation.sendSerialPort(SerialPortCommand.order18 + motorName + " " + i);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }

    private void initDate() {
        serialPortOperation = MotorApplication.getSerialPortOperation();
        serialPortOperation.setOnDataReceiveListener(this);

        messageList = new ArrayList<>();
        adapter = new ArrayAdapter<>(this, R.layout.simple_item, messageList);
        lvDataReceiveMain.setAdapter(adapter);

        ArrayAdapter<String> motorAdapter = new ArrayAdapter<>(this, R.layout.simple_item, motorArr);
        spSelectMotorMain.setAdapter(motorAdapter);

        ArrayAdapter<String> orientationAdapter = new ArrayAdapter<>(this, R.layout.simple_item, orientationArr);
        spSelectOrientationMain.setAdapter(orientationAdapter);

    }


    @OnClick({R.id.btn_changePosition_main, R.id.btn_searchPosition_main, R.id.btn_absoluteMove_main, R.id.btn_speed_main, R.id.btn_open_main, R.id.btn_close_main, R.id.btn_addMove_main, R.id.btn_back_main, R.id.btn_stop_main})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btn_open_main:
                serialPortOperation.openSerialPort();
                break;
            case R.id.btn_close_main:
                serialPortOperation.closeSerialPort();
                break;
            case R.id.btn_speed_main:
                serialPortOperation.sendSerialPort(SerialPortCommand.order12 + motorName + " " + etSpeedMain.getText().toString().trim());
                break;
            case R.id.btn_addMove_main:
                serialPortOperation.sendSerialPort(SerialPortCommand.move + motorName + " " + etDistanceMain.getText().toString().trim());
                break;
            case R.id.btn_back_main:
                serialPortOperation.sendSerialPort(SerialPortCommand.order06 + motorName);
                break;
            case R.id.btn_stop_main:
                serialPortOperation.sendSerialPort(SerialPortCommand.stop + motorName);
                break;
            case R.id.btn_absoluteMove_main:
                serialPortOperation.sendSerialPort(SerialPortCommand.back + motorName + " " + etPositionMain.getText().toString().trim());
                break;
            case R.id.btn_searchPosition_main:
                serialPortOperation.sendSerialPort(SerialPortCommand.order10 + "?");
                break;
            case R.id.btn_changePosition_main:
                serialPortOperation.sendSerialPort(SerialPortCommand.order11 + motorName + " " + etPositionMain);
                break;
        }
    }


    @Override
    public void onDataReceive(byte[] buffer, int size) {
        try {
          String data =  new String(buffer);
            Log.e("receiver", data);
        } catch (Exception e) {
            e.printStackTrace();
            Log.e("receiver", e.getMessage());
        }
    }

    public static String byteArrayToHexStr(byte[] byteArray) {
        if (byteArray == null) {
            return null;
        }
        char[] hexArray = "0123456789ABCDEF".toCharArray();
        char[] hexChars = new char[byteArray.length * 2];
        for (int j = 0; j < byteArray.length; j++) {
            int v = byteArray[j] & 0xFF;
            hexChars[j * 2] = hexArray[v >>> 4];
            hexChars[j * 2 + 1] = hexArray[v & 0x0F];
        }
        return new String(hexChars);
    }

}
