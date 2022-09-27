package mahmoudali.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.SearchView;

public class MainActivity extends AppCompatActivity
{
    SearchView SV;//للبحث عن احد المهام
    ImageButton IBadd;//لاضافة مهمه جديده الى القائمه
    RecyclerView LST;//قائمة المهم

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);//نوع الشاشه افقي او عامودي

        SV.findViewById(R.id.SV);
        IBadd.findViewById(R.id.IBadd);
        LST.findViewById(R.id.LST);

        IBadd.setOnClickListener(new View.OnClickListener()//لاضافة زر
        {
            @Override
            public void onClick(View view) {//دالة للزر لمعرفة ما يفعل عند ضغط الزلا
                Intent i=new Intent(MainActivity.this,AddTask.class);
                startActivity(i);//بدأ الامر
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(@NonNull Menu menu) {
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
        if (item.getItemId()==R.id.ITMhistory)
        {
            Intent d=new Intent(MainActivity.this,History.class);
        }
        return true;
    }

}