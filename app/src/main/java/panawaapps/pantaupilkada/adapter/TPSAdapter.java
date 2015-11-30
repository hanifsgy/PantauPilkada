package panawaapps.pantaupilkada.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;


import java.util.List;

import panawaapps.pantaupilkada.R;
import panawaapps.pantaupilkada.activity.PengawasActivity;
import panawaapps.pantaupilkada.activity.SaksiActivity;
import panawaapps.pantaupilkada.model.TPS.Datum;

/**
 * Created by ali on 23/11/15.
 */
public class TPSAdapter extends RecyclerView.Adapter<TPSAdapter.TPSViewHolder>{
    private List<Datum> tpsCard;
    private Context context;

    public TPSAdapter(Context context, List<Datum> tpsCard) {
        this.context = context;
        this.tpsCard = tpsCard;
    }

    @Override
    public TPSViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_tps, parent, false);
        return new TPSViewHolder(v);
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

    public class TPSViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        CardView cardView;
        TextView tvNoTps;
        TextView tvIdTps;
        TextView tvProvinsi;
        TextView tvKab;
        TextView tvKec;
        TextView tvKelur;
        TextView tvPeran;
        TextView btnPengawas;
        TextView btnSaksi;

        public TPSViewHolder(View v) {
            super(v);
            cardView = (CardView) v.findViewById(R.id.card_tps);
            tvIdTps = (TextView) v.findViewById(R.id.tv_idTps);
            tvNoTps = (TextView) v.findViewById(R.id.textNoTps);
            tvProvinsi = (TextView) v.findViewById(R.id.textProvinsi);
            tvKab = (TextView) v.findViewById(R.id.textKabupaten);
            tvKec = (TextView) v.findViewById(R.id.textKecamatan);
            tvKelur = (TextView) v.findViewById(R.id.textKelurahan);
            btnPengawas = (TextView) v.findViewById(R.id.btn_pengawas);
            btnSaksi = (TextView) v.findViewById(R.id.btn_saksi);

            btnPengawas.setOnClickListener(this);
            btnSaksi.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            Intent intent = new Intent();
            switch (view.getId()) {
                case R.id.btn_pengawas:
                    intent.setClass(context, PengawasActivity.class);
                    break;
                case R.id.btn_saksi:
                    intent.setClass(context, SaksiActivity.class);
                    break;
            }
            context.startActivity(intent);
        }
    }
}
