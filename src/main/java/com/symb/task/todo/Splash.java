package com.symb.task.todo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;

public class Splash extends AppCompatActivity {
    private static int sl=3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_splash);
        getSupportActionBar().hide();
        logo lg=new logo();
        lg.start();
    }
    private class logo extends Thread{
        public void run(){
            try{
                sleep(1000*sl);
            }catch (InterruptedException e){
                e.printStackTrace();
            }

            Intent intent=new Intent(Splash.this,second.class);
            startActivity(intent);
            Splash.this.finish();
        }
    }
}
