package panawaapps.pantaupilkada.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class SpinnerProvincesAdapter extends ArrayAdapter<String> {

    private Context context;
    private int textViewResourceId;
    private ArrayList<String> spinnerList;

    public SpinnerProvincesAdapter(Context context, ArrayList<String> spinnerList) {
        super(context, android.R.layout.simple_spinner_dropdown_item, spinnerList);
        this.context = context;
        this.textViewResourceId = android.R.layout.simple_spinner_dropdown_item;
        this.spinnerList = spinnerList;
    }

    private static class ViewHolder {
        TextView provinceName;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if (convertView == null) {
            convertView = View.inflate(context, textViewResourceId, null);
            holder = new ViewHolder();
            holder.provinceName = (TextView) convertView.findViewById(android.R.id.text1);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        holder.provinceName.setText(spinnerList.get(position));
        return convertView;
    }
}
