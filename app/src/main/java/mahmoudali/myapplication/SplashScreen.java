package mahmoudali.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import com.google.firebase.auth.FirebaseAuth;

public class SplashScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        Handler h=new Handler();
        Runnable r=new Runnable()
        {
            @Override
            public void run()
            {
                //فحص هل تم الدخول مسبقا
                FirebaseAuth auth=FirebaseAuth.getInstance();
                if (auth.getCurrentUser()==null)
                {
                    //اذا لا يدحلنا الى التسجيل
                    Intent i=new Intent(SplashScreen.this,SignIn.class);
                    startActivity(i);
                    finish();
                }
                else
                {
                    //اذا تواجد تسجيل مسبق يدخل للصفحه الرئيسيه
                    Intent i=new Intent(SplashScreen.this,MainActivity.class);
                    startActivity(i);
                    finish();
                }
            }
        } ;
        h.postDelayed(r,3000);
    }
}
