package mahmoudali.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageButton;
import android.widget.SeekBar;

import com.google.android.material.textfield.TextInputEditText;

public class AddTask extends AppCompatActivity
{
    private TextInputEditText EtEmail;
    private TextInputEditText EtSubject;
    private SeekBar SbImport;
    private ImageButton ImPhoto;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_task);

        EtEmail=findViewById(R.id.EtEmail);
        EtSubject=findViewById(R.id.EtSubject);
        SbImport=findViewById(R.id.SbImport);
        ImPhoto=findViewById(R.id.ImPhoto);
    }
}