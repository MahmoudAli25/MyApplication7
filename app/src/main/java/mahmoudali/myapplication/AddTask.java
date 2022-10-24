package mahmoudali.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.FileObserver;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.SeekBar;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;

import mahmoudali.myapplication.Data.Mahama;

public class AddTask extends AppCompatActivity {
    private TextInputEditText EtTitle;
    private TextInputEditText EtSubject;
    private SeekBar SbImport;
    private ImageButton ImPhoto;
    private Button BtSave;
    private Button BtCancel;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_task);

        EtTitle = findViewById(R.id.EtTitle);
        EtSubject = findViewById(R.id.EtSubject);
        SbImport = findViewById(R.id.SbImport);
        ImPhoto = findViewById(R.id.ImPhoto);
        BtSave = findViewById(R.id.BtSave);
        BtCancel = findViewById(R.id.BtCancel);

        BtSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkAndSave();

            }
        });
        BtCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                Intent i =new Intent(AddTask.this,MainActivity.class);
                startActivity(i);

            }
        });
    }

    private void checkAndSave()
    {
        String title = EtTitle.getText().toString();
        String subject = EtSubject.getText().toString();
        int imp = SbImport.getProgress();

        Mahama m = new Mahama();
        m.setTitle(title);
        m.setSubject(subject);
        m.setImportant(imp);
        //استخراج الرقم المميز للمستخدم UID
        //                                          مستخدم مسبق
        String owner = FirebaseAuth.getInstance().getCurrentUser().getUid();
        m.setOwner(owner);
        //استخراج الرقم المميز للمهمه
        String key = FirebaseDatabase.getInstance().getReference().
                child("mahamat").
                //اضافة قيمه جديده
                child(owner).push().getKey();
        m.setKey(key);
        //عنوان جذر قاعدة البيانات
        FirebaseDatabase.getInstance().getReference().
                child("mahamat").
                child(owner).
                child(key).
                setValue(m).addOnCompleteListener(new OnCompleteListener<Void>()
                {
                    @Override
                    public void onComplete(@NonNull Task<Void> task)
                    {
                        if (task.isSuccessful())
                        {
                            finish();
                            Toast.makeText(AddTask.this, "added Succesfully", Toast.LENGTH_SHORT).show();
                        }
                        else
                        {
                            Toast.makeText(AddTask.this, "Add Failled", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
    }
}