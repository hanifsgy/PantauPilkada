package panawaapps.pantaupilkada.adapter;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import panawaapps.pantaupilkada.R;


/**
 * Created by ali on 23/11/15.
 */
public class TPSViewHolder extends RecyclerView.ViewHolder {
    CardView cardView;
    TextView tvNoTps;
    TextView tvIdTps;
    TextView tvProvinsi;
    TextView tvKab;
    TextView tvKec;
    TextView tvKelur;
    TextView tvPeran;

    public TPSViewHolder(View v) {
        super(v);
        cardView = (CardView) v.findViewById(R.id.card_tps);
        tvIdTps = (TextView) v.findViewById(R.id.tv_idTps);
        tvNoTps = (TextView) v.findViewById(R.id.textNoTps);
        tvProvinsi = (TextView) v.findViewById(R.id.textProvinsi);
        tvKab = (TextView) v.findViewById(R.id.textKabupaten);
        tvKec = (TextView) v.findViewById(R.id.textKecamatan);
        tvKelur = (TextView) v.findViewById(R.id.textKelurahan);
    }
}
