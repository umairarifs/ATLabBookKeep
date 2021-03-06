package com.example.saksheeagarwal.bookkeep1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.content.Intent;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Color;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class TeacherHome extends AppCompatActivity implements SensorEventListener{

    Button search, seerec, rate, profile;
    private SensorManager mSensorManager;
    private Sensor mSensorProximity;
    private Sensor mSensorLight;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.thome);

        setContentView(R.layout.activity_main);
        mSensorManager =
                (SensorManager) getSystemService(SENSOR_SERVICE);
        mSensorLight = mSensorManager.getDefaultSensor(Sensor.TYPE_LIGHT);

        //mSensorManager.registerListener(this, mSensorLight,
        //  SensorManager.SENSOR_DELAY_NORMAL);



        Sensor mSensorProximity;
        Sensor mSensorLight;
        String mTextSensorLight;
        String mTextSensorProximity;

        mSensorProximity = mSensorManager.getDefaultSensor(Sensor.TYPE_PROXIMITY);


        search = (Button) findViewById(R.id.search2);
        seerec = (Button) findViewById(R.id.seerec2);
        rate= (Button) findViewById(R.id.rate2);
        profile = (Button) findViewById(R.id.upload);




        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i = new Intent(TeacherHome.this,search.class);
                startActivity(i);
                //setContentView(R.layout.search);

            }
        });
        seerec.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i = new Intent(TeacherHome.this,SeeRec.class);
                startActivity(i);
               // setContentView(R.layout.seerecom);

            }
        });




    }

    protected void onStart() {
        super.onStart();

        // mSensorManager.registerListener(this, mSensorProximity,
        //       SensorManager.SENSOR_DELAY_NORMAL);


        mSensorManager.registerListener(this, mSensorLight,
                SensorManager.SENSOR_DELAY_NORMAL);

    }

    protected void onStop() {
        super.onStop();
        mSensorManager.unregisterListener(this);
    }

    @Override
    public void onSensorChanged(SensorEvent sensorEvent) {
        int sensorType = sensorEvent.sensor.getType();
        float currentValue = sensorEvent.values[0];
        switch (sensorType) {
            // Event came from the light sensor.
            case Sensor.TYPE_LIGHT:
                if(currentValue>20000)
                {
                    //setTheme(android.R.style.Theme_Holo_Light);
                    //this.recreate();
                    // Utils.changeToTheme(this, Utils.THEME_BLUE);
                    findViewById(R.id.ff).setBackgroundColor(Color.parseColor("#ffffff"));
                }
                else{
                    //setTheme(android.R.style.Theme_Holo);
                    //this.recreate();
                    //Utils.changeToTheme(this, Utils.THEME_WHITE);


                    findViewById(R.id.ff).setBackgroundColor(Color.parseColor("#000000"));

                }

                break;
            default:
                // do nothing
        }
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int i) {

    }
}
