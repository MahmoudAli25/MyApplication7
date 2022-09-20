package mahmoudali.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

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

     BTup.setOnClickListener(new View.OnClickListener() {
         @Override
         public void onClick(View view) {
             checkAndSave();
         }
     });

    }

    private void checkAndSave()
    {
        String email=ETsignUP.getText().toString();
        String ReEmail=ETCON.getText().toString();
        String passw=ETpasUp.getText().toString();


    }
}