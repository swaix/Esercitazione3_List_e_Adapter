package corso.swaix.listAdapter.adapters;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import corso.swaix.listAdapter.R;

/**
 * Created by SwaiX on 23/05/2015.
 */
public class CustomListAdapter extends ArrayAdapter<String> {

    private final List<String> data;
    private final Activity context;

    public CustomListAdapter(Activity context, List<String> objects) {
        super(context, R.layout.adapter_row, objects);
        this.context = context;
        this.data = objects;
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View rowView = convertView;
        final int fPosition = position;
        // evitiamo di reinizializzare l'oggetto in caso in cui sia già stato usato
        // per migliorare le performance
        if (rowView == null) {
            LayoutInflater inflater = context.getLayoutInflater();
            rowView = inflater.inflate(R.layout.adapter_row, null);

            ViewHolder viewHolder = new ViewHolder();
            viewHolder.image = (ImageView) rowView.findViewById(R.id.image);
            viewHolder.image.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(context,"Clickato la freccia accanto a " + data.get(fPosition), Toast.LENGTH_LONG).show();
                }
            });
            viewHolder.text = (TextView) rowView.findViewById(R.id.text);
            viewHolder.text.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(context,"clickato la riga " + fPosition, Toast.LENGTH_LONG).show();
                }
            });
            rowView.setTag(viewHolder);
        }

        ViewHolder holder = (ViewHolder) rowView.getTag();
        holder.text.setText(data.get(position));
        return rowView;
    }


    static class ViewHolder {
        public TextView text;
        public ImageView image;
    }

}
