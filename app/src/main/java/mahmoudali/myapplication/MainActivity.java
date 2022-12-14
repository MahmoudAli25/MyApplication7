package mahmoudali.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.SearchView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import mahmoudali.myapplication.Data.Mahama;
import mahmoudali.myapplication.Data.MahmaAdapter;

public class MainActivity extends AppCompatActivity
{
    //3.1 تجهيز الوسيط
    MahmaAdapter mahmaAdapter;
    SearchView SV;//للبحث عن احد المهام
    ImageButton IbAdd;//لاضافة مهمه جديده الى القائمه
    ListView LisQ;//قائمة عرض المهم

    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);//نوع الشاشه افقي او عامودي
        //3.2 بناء الوسيط
        mahmaAdapter= new MahmaAdapter(getApplicationContext());

        SV = findViewById(R.id.SV);
        IbAdd = findViewById(R.id.IbAdd);

        //تجهيز مؤشر لقائمة العرض
        LisQ = findViewById(R.id.LisQ);
        //3.3 ربط ائمة العرض بالوسيط
        LisQ.setAdapter(mahmaAdapter);
        //تشغيل مراقب لاي تغيير على قاعدة البيانات
        //ويقوم بتنظيف المعطيات الموجوده وتنزيل المعلومات الجديده
        ReadMahamatFromFireBase();


        IbAdd.setOnClickListener(new View.OnClickListener()//لاضافة زر
        {
            @Override
            public void onClick(View view) {//دالة للزر لمعرفة ما يفعل عند ضغط الزلا
                Intent i=new Intent(MainActivity.this,AddTask.class);
                startActivity(i);//بدأ الامر
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(@NonNull Menu menu)
    {
        getMenuInflater().inflate(R.menu.main_menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId()==R.id.ITMset)
        {
            Intent i=new Intent(MainActivity.this,Settings.class);
            startActivity(i);
        }
        if (item.getItemId()==R.id.ITMsout)
        {
            //تسجيل الخروج
            //1
            // تجهيز البناء للدايلوج
            AlertDialog.Builder builder=new AlertDialog.Builder(this);
            builder.setTitle("Signing Out");
            builder.setMessage("are you sure?");
            builder.setPositiveButton("yes", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i)
                {
                    //اخفاء الديالوج
                    dialogInterface.dismiss();
                    //الخروج من الحساب
                    FirebaseAuth.getInstance().signOut();
                    //لخروج من الشاشه
                    finish();
                }
            });
            builder.setNegativeButton("no", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i)
                {
                    //الغاء الدايالوج
                    dialogInterface.cancel();
                }
            });
            //البناء
            AlertDialog dialog=builder.create();
            dialog.show();
        }

        if (item.getItemId()==R.id.ITMhistory)
        {
            Intent d=new Intent(MainActivity.this,History.class);
        }

        return true;
    }
    private void ReadMahamatFromFireBase()
    {
        //اشر لجزر قاعدة البيانات التابعه للمشروع يتخزن تحتها المهمات
        DatabaseReference reference = FirebaseDatabase.getInstance().getReference();
        //ليسينر لمراقبة اي تغيير يحدث تحت الجزر المحدد
        //اي تغيير بقيمة صفه او حذف او اضافة كائن يتم اعلام اليسينير
        //عندها يتم تنزيل كل المعطيات الموجوده تحت الجزر
        reference.child("mahamat").addValueEventListener(new ValueEventListener() {

            /**
             *             دالة معالجة الحدث عند تغيير اي قيمه
             * @param snapshot يحوي نسخه عن كل المعطيات تحت العنوان المراقب
             */
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot)
            {
                mahmaAdapter.clear();//يمحا كل اشي بداخله
                for (DataSnapshot d: snapshot.getChildren())//d يمر على جميع قيم مبنى المعطيات
                {
                    Mahama m =d.getValue(Mahama.class);//استخراج الكاىن المحفوظ
                    mahmaAdapter.add(m);//اضافة الكائن للوسيط
                }
            }
            private void onr(){

            }
            @Override
            public void onCancelled(@NonNull DatabaseError error)
            {

            }
        });

    }

}