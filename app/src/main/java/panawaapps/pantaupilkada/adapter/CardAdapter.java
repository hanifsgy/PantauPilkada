package panawaapps.pantaupilkada.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import panawaapps.pantaupilkada.R;
import panawaapps.pantaupilkada.model.Card;

/**
 * Created by Sikikan on 11/23/2015.
 */
public class CardAdapter extends RecyclerView.Adapter<CardAdapter.CardViewHolder>{

    public static String TAG = CardAdapter.class.getSimpleName();

//    public Context mContext;
    public  List<Card> mCards;

    public CardAdapter(List<Card> cards) {
//        this.mContext = context;
        mCards = cards;
    }

    public void addCard(Card card){
        mCards.add(card);
        notifyDataSetChanged();
    }

    @Override
    public CardAdapter.CardViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View row = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_kontestan, parent, false);
        return new CardViewHolder(row);
    }

    @Override
    public void onBindViewHolder(CardAdapter.CardViewHolder holder, int position) {

        Card currentCard = mCards.get(position);

        holder.namaCalon.setText(currentCard.mCalonName);
        holder.namaWakil.setText(currentCard.mWakilName);
        holder.regionName.setText(currentCard.mRegionName);
    }

    @Override
    public int getItemCount() {
        return mCards == null ? 0 : mCards.size();
    }


    public class CardViewHolder extends RecyclerView.ViewHolder{

        public TextView regionName;
        public TextView namaCalon;
        public TextView namaWakil;


        public CardViewHolder(View itemView) {
            super(itemView);

            regionName = (TextView) itemView.findViewById(R.id.tv_daerahCardKontestan);
            namaCalon = (TextView) itemView.findViewById(R.id.tv_namaCalon1);
            namaWakil = (TextView) itemView.findViewById(R.id.tv_namaWakil1);
        }
    }
}
