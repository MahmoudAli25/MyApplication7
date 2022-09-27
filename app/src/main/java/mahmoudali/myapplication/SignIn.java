package mahmoudali.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class SignIn extends AppCompatActivity {
    TextInputEditText EtEmail;
    TextInputEditText EtPass;
    private Button button5;
    private Button BTsignUp;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in); //يبني واجهة المستعمل بحيث تبني كل الكاىنات الموجوده في ملف التنسيق

        EtEmail = findViewById(R.id.EtEmail);
        EtPass = findViewById(R.id.EtPass);
        button5 = findViewById(R.id.button5);
        BTsignUp = findViewById(R.id.BTsignUp);

        BTsignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                Intent i = new Intent(SignIn.this,SignUp.class);
                startActivity(i);
            }
        }
        );

        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                checkAndSave();
            }
        });
    }
    private void checkAndSave()//دالة تفحص الحساب وكلمة السر ان كانت مكوبه بشكل صحيح
    {
        String email=EtEmail.getText().toString();
        String passw=EtPass.getText().toString();
        boolean isOK=true;
        if(email.length()==0)
        {
            EtEmail.setError("enter your email");
            isOK=false;
        }
        if(passw.length()==0)
        {
            EtPass.setError("enter your password");
            isOK=false;
        }
        if(email.indexOf("@")<=0)
        {
            EtEmail.setError("wrong email");
            isOK=false;
        }
        if(passw.length()<7)
        {
            EtPass.setError("password at least 7 character");
            isOK=false;
        }
        if(isOK)
        {
            FirebaseAuth auth = FirebaseAuth.getInstance();//امر للفاير بيس
            auth.signInWithEmailAndPassword(email,passw).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override
                /**
                 * event handler when the mesion is completed
                 */
                public void onComplete(@NonNull Task<AuthResult> task)
                {
                    if(task.isSuccessful())//يفحص اذا المهم تمت بنجاح
                    {
                        Toast.makeText(SignIn.this, "Successful", Toast.LENGTH_SHORT).show();//تظهر رساله في الشاشه من الاسفل
                        Intent i=new Intent(SignIn.this,MainActivity.class);
                        startActivity(i);
                        finish();//يغلق الشاشه الحاليه
                    }
                    else
                    {
                        Toast.makeText(SignIn.this, "Not Successful"+task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                    }

                }
            });

        }
    }
}