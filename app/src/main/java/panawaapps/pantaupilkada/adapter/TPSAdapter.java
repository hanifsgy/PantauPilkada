package panawaapps.pantaupilkada.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;



import java.util.List;

import panawaapps.pantaupilkada.R;
import panawaapps.pantaupilkada.model.TPS.Datum;

/**
 * Created by ali on 23/11/15.
 */
public class TPSAdapter extends RecyclerView.Adapter<TPSViewHolder>{
    private List<Datum> tpsCard;

    public TPSAdapter(List<Datum> tpsCard) {
        this.tpsCard = tpsCard;
    }

    @Override
    public TPSViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_tps, parent, false);
        TPSViewHolder holder = new TPSViewHolder(v);
        return holder;
    }

    @Override
    public void onBindViewHolder(TPSViewHolder holder, int position) {
        final Datum tps = tpsCard.get(position);
        holder.tvNoTps.setText(tps.getName());
        holder.tvIdTps.setText(tps.getId());
        holder.tvProvinsi.setText(tps.getProvinceName());
        holder.tvKab.setText(tps.getRegionName());
        holder.tvKec.setText(tps.getDistrictName());
        holder.tvKelur.setText(tps.getSubdistrictName());
    }

    @Override
    public int getItemCount() {
        return tpsCard.size();
    }
}
