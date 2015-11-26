package panawaapps.pantaupilkada.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.List;

import panawaapps.pantaupilkada.R;
import panawaapps.pantaupilkada.model.CardTpsSaksi;

/**
 * Created by Sikikan on 11/27/2015.
 */
public class CardTpsSaksiAdapter extends RecyclerView.Adapter<CardTpsSaksiAdapter.CardTpsSaksiViewHolder> {

    Context context;
    List<CardTpsSaksi> cardTpsSaksiList;

    public CardTpsSaksiAdapter(Context context, List<CardTpsSaksi> cardTpsSaksiList) {
        this.context = context;
        this.cardTpsSaksiList = cardTpsSaksiList;
    }

    public class CardTpsSaksiViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        LinearLayout card_tps_saksi;

        TextView daerah;
        TextView jmlTps;
        TextView noTps;
        TextView peranUser;

        public CardTpsSaksiViewHolder(View itemView) {
            super(itemView);
            card_tps_saksi = (LinearLayout) itemView.findViewById(R.id.card_tps_saksi);
            daerah = (TextView) itemView.findViewById(R.id.tv_daerah);
            jmlTps = (TextView) itemView.findViewById(R.id.tv_jmlTps);
            noTps  = (TextView) itemView.findViewById(R.id.tv_noTps);
            peranUser = (TextView) itemView.findViewById(R.id.tv_peranUser);
        }

        @Override
        public void onClick(View v) {

        }
    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }

    @Override
    public CardTpsSaksiAdapter.CardTpsSaksiViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.card_tps_saksi, viewGroup, false);
        CardTpsSaksiViewHolder ctsvh = new CardTpsSaksiViewHolder(v);
        return ctsvh;
    }

    @Override
    public void onBindViewHolder(CardTpsSaksiAdapter.CardTpsSaksiViewHolder holder, int i) {
        holder.daerah.setText(cardTpsSaksiList.get(i).daerah);
        holder.jmlTps.setText(cardTpsSaksiList.get(i).jmlTps);
        holder.noTps.setText(cardTpsSaksiList.get(i).noTps);
        holder.peranUser.setText(cardTpsSaksiList.get(i).peranUser);
    }

    @Override
    public int getItemCount() {
        return cardTpsSaksiList == null ? 0 : cardTpsSaksiList.size();
    }
}
