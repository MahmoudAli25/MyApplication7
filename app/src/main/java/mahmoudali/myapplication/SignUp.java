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
import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class SignUp extends AppCompatActivity {

    private TextInputEditText ETsignUP;
    private TextInputEditText ETpasUp;
    private TextInputEditText ETCON;
    private Button BTup;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        ETsignUP=findViewById(R.id.ETsignUP);
        ETpasUp=findViewById(R.id.ETpasUp);
        ETCON=findViewById(R.id.ETCON);
        BTup=findViewById(R.id.BTup);

     BTup.setOnClickListener(new View.OnClickListener() {
         @Override
         public void onClick(View view) {
             checkAndSave();
         }
     });

    }

    private void checkAndSave()//داله تفحص اذا اليميل صحيح وكلمة السر تطابق الاخرى
    {
        String email=ETsignUP.getText().toString();
        String RePasw=ETCON.getText().toString();
        String passw=ETpasUp.getText().toString();
        boolean isok=true;

        if(email.length()*passw.length()*RePasw.length()==0)
        {
            ETsignUP.setError("One of files are eror");
            isok=false;
        }

        if(passw.equals(RePasw)==false)
        {
            ETCON.setError("enter the same password");
            isok=false;
        }
        if(passw.length()==0)
        {
            ETpasUp.setError("enter your password");
            isok=false;
        }
        if(email.indexOf("@")<=0)
        {
            ETsignUP.setError("wrong email");
            isok=false;
        }
        if(passw.length()<7)
        {
            ETpasUp.setError("password at least 7 character");
            isok=false;
        }
        if(isok)
        {
            FirebaseAuth auth= FirebaseAuth.getInstance();//انشاء حساب من ايميل وسسما
            auth.createUserWithEmailAndPassword(email,passw).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task)
                {
                    if(task.isSuccessful())
                    {
                        Toast.makeText(SignUp.this, "Successful", Toast.LENGTH_SHORT).show();
                        finish();
                    }
                    else
                    {
                        Toast.makeText(SignUp.this, "not Successful"+task.getException().getMessage(), Toast.LENGTH_SHORT).show();

                    }

                }
            });

        }


    }
}