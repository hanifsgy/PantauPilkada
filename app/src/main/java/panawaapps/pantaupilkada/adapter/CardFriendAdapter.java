package panawaapps.pantaupilkada.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import panawaapps.pantaupilkada.R;
import panawaapps.pantaupilkada.model.CardFriend;

/**
 * Created by Sikikan on 11/28/2015.
 */
public class CardFriendAdapter extends RecyclerView.Adapter<CardFriendAdapter.CardFriendViewHolder>{

    public List<CardFriend> cardFriendList;
    public CardFriendAdapter(List<CardFriend> cardFriendList) {
        this.cardFriendList = cardFriendList;
    }

    public void addCard(CardFriend cardFriend) {
        cardFriendList.add(cardFriend);
        notifyDataSetChanged();
    }

    public class CardFriendViewHolder extends RecyclerView.ViewHolder {

        public TextView mNamaFriend;
        public TextView mJmlPengamat;
        public TextView mJmlPengawas;
        public TextView mJmlSaksi;
        public ImageView mFotoFriend;

        public CardFriendViewHolder(View itemView) {
            super(itemView);

            mNamaFriend = (TextView) itemView.findViewById(R.id.tv_namaFriend);
            mFotoFriend = (ImageView) itemView.findViewById(R.id.iv_fotoFriend);
            mJmlPengawas = (TextView) itemView.findViewById(R.id.tv_jmlPengawas);
            mJmlPengamat = (TextView) itemView.findViewById(R.id.tv_jmlPengamat);
            mJmlPengawas = (TextView) itemView.findViewById(R.id.tv_jmlPengawas);
            mJmlSaksi = (TextView) itemView.findViewById(R.id.tv_jmlSaksi);
        }
    }

    @Override
    public CardFriendAdapter.CardFriendViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View card = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_friend, parent, false);
        return  new CardFriendViewHolder(card);
    }

    @Override
    public void onBindViewHolder(CardFriendAdapter.CardFriendViewHolder holder, int position) {
        CardFriend currentCardFriend = cardFriendList.get(position);

        holder.mFotoFriend.setImageResource(currentCardFriend.mFotoFriend);
        holder.mNamaFriend.setText(currentCardFriend.mNamaFriend);
        holder.mJmlPengamat.setText(String.valueOf(currentCardFriend.mJmlPengamat));
        holder.mJmlPengawas.setText(String.valueOf(currentCardFriend.mJmlPengawas));
        holder.mJmlSaksi.setText(String.valueOf(currentCardFriend.mJmlSaksi));
    }

    @Override
    public int getItemCount() {
        return cardFriendList == null ? 0 : cardFriendList.size();
    }
}
