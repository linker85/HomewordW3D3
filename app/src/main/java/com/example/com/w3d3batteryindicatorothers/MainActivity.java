package com.example.com.w3d3batteryindicatorothers;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.example.com.mybatterymodule.BatteryModule;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "TAG_";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Register the receiver which triggers event
        //when battery charge is changed
        registerReceiver(mBatInfoReceiver, new IntentFilter(
                Intent.ACTION_BATTERY_CHANGED));

        /////////////// Singleton
        String salida = "";

        BatteryModule mySingleton1 = BatteryModule.getMySingleton();
        salida = mySingleton1.fromAToB("hello1");
        System.out.println(mySingleton1);

        BatteryModule mySingleton2 = BatteryModule.getMySingleton();
        salida = mySingleton1.fromAToB("hello2");
        System.out.println(mySingleton2);
        Log.d(TAG, "Singleton: " + salida);

        Car car = new Car.MyBuilder().
                setBrand("Nissan").
                setLicencePlate("JSA-123").
                build();
        Log.d(TAG, "Builder: " + car.toString());

    }

    //Create Broadcast Receiver Object along with class definition
    private BroadcastReceiver mBatInfoReceiver = new BroadcastReceiver() {
        @Override
        //When Event is published, onReceive method is called
        public void onReceive(Context c, Intent i) {
            //Get Battery %
            int level = i.getIntExtra("level", 0);
            MyBatteryFactory myFactory = MyBatteryFactory.Factory.create(level);
            //Find the progressbar creating in main.xml
            ProgressBar pb = (ProgressBar) findViewById(R.id.progressbar);
            //Set progress level with battery % value
            pb.setProgress(myFactory.getLevel());
            //Find textview control created in main.xml
            TextView tv = (TextView) findViewById(R.id.textfield);
            //Set TextView with text
            tv.setText("Battery Level: " + Integer.toString(level) + "%");
        }

    };

}
