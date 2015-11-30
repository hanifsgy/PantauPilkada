package panawaapps.pantaupilkada.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;

import panawaapps.pantaupilkada.activity.PickLocationActivity;
import panawaapps.pantaupilkada.activity.TPSActivity;


public class PickLocationAdapter extends RecyclerView.Adapter<PickLocationAdapter.PickLocationViewHolder> {

    private Context context;
    private ArrayList<HashMap<String, String>> locationsList;
    private int area;
    private String name, kind;

    private static final int REGION = 0;
    private static final int DISTRICT = 1;
    private static final int SUBDISTRICT = 2;

    public PickLocationAdapter(Context context, ArrayList<HashMap<String, String>> locationsList, int area, String name, String kind) {
        this.context = context;
        this.locationsList = locationsList;
        this.area = area;
        this.name = name;
        this.kind = kind;
    }

    public class PickLocationViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView locationName;


        PickLocationViewHolder(View itemView) {
            super(itemView);
            locationName = (TextView) itemView.findViewById(android.R.id.text1);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            int position = getAdapterPosition();
            Intent intent = new Intent();
            switch (area) {
                case REGION:
                    intent.setClass(context, PickLocationActivity.class);
                    intent.putExtra("name", name + ", " + locationsList.get(position).get("name"));
                    intent.putExtra("id", locationsList.get(position).get("id"));
                    intent.putExtra("area", DISTRICT);
                    break;
                case DISTRICT:
                    intent.setClass(context, PickLocationActivity.class);
                    intent.putExtra("name", name + ", " + locationsList.get(position).get("name"));
                    intent.putExtra("id", locationsList.get(position).get("id"));
                    intent.putExtra("area", SUBDISTRICT);
                    break;
                case SUBDISTRICT:
                    intent.setClass(context, TPSActivity.class);
                    intent.putExtra("tps", locationsList.get(position).get("id"));
                    break;
            }
            intent.putExtra("kind", kind);
            context.startActivity(intent);
        }
    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }

    @Override
    public PickLocationViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(android.R.layout.simple_list_item_1, viewGroup, false);
        return new PickLocationViewHolder(v);
    }

    @Override
    public void onBindViewHolder(PickLocationViewHolder cardKontestanViewHolder, int position) {
        cardKontestanViewHolder.locationName.setText(locationsList.get(position).get("name"));
    }

    @Override
    public int getItemCount() {
        return locationsList == null ? 0 : locationsList.size();
    }
}
