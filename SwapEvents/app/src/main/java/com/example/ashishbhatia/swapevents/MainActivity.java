package com.example.ashishbhatia.swapevents;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MotionEvent;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    float x1,x2,y1,y2;
    TextView mtv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mtv = (TextView) findViewById(R.id.tvTextView);

    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        switch (event.getAction()){

            case MotionEvent.ACTION_DOWN:
            {
                x1 = event.getX();
                y1 = event.getY();
                Log.d("Touch Event","X1 value" + x1);
                Log.d("Touch Event","Y1 value" + y1);
                break;
            }
            case MotionEvent.ACTION_UP:
            {
                x2 = event.getX();
                y2 = event.getY();

                Log.d("Touch Event","X2 value" + x2);
                Log.d("Touch Event","Y2 value" + y2);

                float diffx = Math.abs(x2 - x1) ;
                float diffy = Math.abs(y2 - y1) ;

                Log.d("Touch Event","diffX value" + diffx);
                Log.d("Touch Event","diffy value" + diffy);

                if(x2 > x1 && diffx > diffy ){
                    mtv.setText("Left to Right Swap");
                }
                if(x2 < x1 && diffx > diffy){
                    mtv.setText("Right to Left Swap");
                }
                if(y2 > y1 && diffy > diffx){
                    mtv.setText("Top to Bottom Swap");
                }

                if (y2 < y1 && diffy > diffx){
                    mtv.setText("Bottom to Top Swap");
                }
                break;

            }

        }
        return false;
    }
}
