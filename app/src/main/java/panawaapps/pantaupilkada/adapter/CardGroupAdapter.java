package panawaapps.pantaupilkada.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.List;

import panawaapps.pantaupilkada.R;
import panawaapps.pantaupilkada.model.CardGroup;

/**
 * Created by Sikikan on 11/28/2015.
 */
public class CardGroupAdapter extends RecyclerView.Adapter<CardGroupAdapter.CardGroupViewHolder> {

    public List<CardGroup> cardGroupList;

    public CardGroupAdapter(List<CardGroup> cardGroupList) {
        this.cardGroupList = cardGroupList;
    }

    public void addCard(CardGroup cardGroup){
        cardGroupList.add(cardGroup);
        notifyDataSetChanged();
    }

    public class CardGroupViewHolder extends RecyclerView.ViewHolder {


        public RelativeLayout card_group;
        public TextView mNamaGroup;
        public TextView mDeskripsiGroup;
        public ImageView mFotoGroup;
        public TextView mJmlPengamat;
        public TextView mJmlPengawas;
        public TextView mJmlSaksi;

        public CardGroupViewHolder(View itemView) {
            super(itemView);
            card_group = (RelativeLayout) itemView.findViewById(R.id.card_group);
            mNamaGroup = (TextView) itemView.findViewById(R.id.tv_namaGroup);
            mDeskripsiGroup = (TextView) itemView.findViewById(R.id.tv_deskripsiGroup);
            mFotoGroup = (ImageView) itemView.findViewById(R.id.iv_fotoGroup);
            mJmlPengamat = (TextView) itemView.findViewById(R.id.tv_jmlPengamat);
            mJmlPengawas = (TextView) itemView.findViewById(R.id.tv_jmlPengawas);
            mJmlSaksi = (TextView) itemView.findViewById(R.id.tv_jmlSaksi);
        }


    }

    @Override
    public CardGroupAdapter.CardGroupViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View card = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_group, parent, false);
        return new CardGroupViewHolder(card);
    }

    @Override
    public void onBindViewHolder(CardGroupViewHolder holder, int position) {
        CardGroup currentCardGroup = cardGroupList.get(position);

        holder.mNamaGroup.setText(currentCardGroup.mNamaGroup);
        holder.mDeskripsiGroup.setText(currentCardGroup.mDeskripsiGroup);
        holder.mFotoGroup.setImageResource(currentCardGroup.mFotoGroup);
        holder.mJmlPengamat.setText(String.valueOf(currentCardGroup.mJmlPengamat));
        holder.mJmlPengawas.setText(String.valueOf(currentCardGroup.mJmlPengawas));
        holder.mJmlSaksi.setText(String.valueOf(currentCardGroup.mJmlSaksi));
    }

    @Override
    public int getItemCount() {
        return cardGroupList == null ? 0 : cardGroupList.size();
    }


}
