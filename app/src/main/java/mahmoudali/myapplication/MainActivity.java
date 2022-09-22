package mahmoudali.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.SearchView;

public class MainActivity extends AppCompatActivity
{
    SearchView SV;
    ImageButton IBadd;
    RecyclerView LST;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SV.findViewById(R.id.SV);
        IBadd.findViewById(R.id.IBadd);
        LST.findViewById(R.id.LST);

        IBadd.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(MainActivity.this,AddTask.class);
                startActivity(i);
            }
        });
    }
}