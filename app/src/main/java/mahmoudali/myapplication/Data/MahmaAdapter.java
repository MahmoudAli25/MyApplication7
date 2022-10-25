package mahmoudali.myapplication.Data;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.ImageButton;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.annotation.NonNull;

import mahmoudali.myapplication.R;
//                                   وسيط من نوع مهمات فقط
public class MahmaAdapter extends ArrayAdapter<Mahama>
{
    public MahmaAdapter(@NonNull Context context) {
        super(context, R.layout.task_item);
    }

    @NonNull
    @Override
    public View getView(int position,View convertView, ViewGroup parent)
    {
        //بناء واجهه لعرض المهمه
        View vitem= LayoutInflater.from(getContext()).inflate(R.layout.task_item,parent,false);

        TextView TvTitle=vitem.findViewById(R.id.TvTitle);
        TextView TvSubject=vitem.findViewById(R.id.TvSubject);
        RatingBar Rb=vitem.findViewById(R.id.Rb);
        CheckBox box =vitem.findViewById(R.id.box);
        ImageButton IvInfo=vitem.findViewById(R.id.IvInfo);

        //grtting data source
        final Mahama mahama=getItem(position);

        //استخراج القيم من الحقول
        TvTitle.setText(mahama.getTitle());
        TvSubject.setText(mahama.getSubject());
        Rb.setRating(mahama.getImportant());
        box.setChecked(false);







        return vitem;
    }
}
