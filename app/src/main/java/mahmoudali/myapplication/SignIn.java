package mahmoudali.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.android.material.textfield.TextInputEditText;

public class SignIn extends AppCompatActivity {
    private TextInputEditText EtEmail;
    private TextInputEditText EtPass;
    private Button button5;
    private Button button6;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in); //يبني واجهة المستعمل بحيث تبني كل الكاىنات الموجوده في ملف التنسيق
        EtEmail=findViewById(R.id.EtEmail);
        EtPass=findViewById(R.id.EtPass);
        button5=findViewById(R.id.button5);
        button6=findViewById(R.id.button6);

        button6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i= new Intent(SignIn.this,SignUp.class);
                startActivity(i);
            }
        });
    }
}