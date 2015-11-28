package panawaapps.pantaupilkada.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import panawaapps.pantaupilkada.R;
import panawaapps.pantaupilkada.model.CardDariKandidat;

/**
 * Created by Sikikan on 11/28/2015.
 */
public class CardDariKandidatAdapter extends RecyclerView.Adapter<CardDariKandidatAdapter.CardDariKandidatViewHolder> {

    public List<CardDariKandidat> cardDariKandidatList;
    public CardDariKandidatAdapter (List<CardDariKandidat> cardDariKandidats){
        this.cardDariKandidatList = cardDariKandidatList;
    }

    public boolean diApresiasi = false;
    public boolean diPerhatikan = false;

    public void addCard(CardDariKandidat cardDariKandidat){
        cardDariKandidatList.add(cardDariKandidat);
        notifyDataSetChanged();
    }

    public class CardDariKandidatViewHolder extends RecyclerView.ViewHolder {

        public TextView mJudulPost;
        public TextView mIsiPost;
        public TextView mTglPost;
        public TextView mNamaUser;
        public TextView mJmlDiapresiasi;
        public TextView mJmlDiperhatikan;

        FrameLayout btn_diApresiasi;
        FrameLayout btn_diPerhatikan;
        ImageView icon_diApresiasi;
        ImageView icon_diPerhatikan;


        public CardDariKandidatViewHolder(View itemView) {
            super(itemView);
            mJudulPost = (TextView) itemView.findViewById(R.id.tv_judulPost);
            mIsiPost = (TextView) itemView.findViewById(R.id.tv_isiPost);
            mTglPost = (TextView) itemView.findViewById(R.id.tv_tglPost);
            mNamaUser = (TextView) itemView.findViewById(R.id.tv_namaUser);
            mJmlDiapresiasi = (TextView) itemView.findViewById(R.id.tv_jmlDiApresiasi);
            mJmlDiperhatikan = (TextView) itemView.findViewById(R.id.tv_jmldiPerhatikan);
            btn_diApresiasi = (FrameLayout) itemView.findViewById(R.id.btn_diApresiasi);
            btn_diPerhatikan = (FrameLayout) itemView.findViewById(R.id.btn_diPerhatikan);

            icon_diApresiasi = (ImageView) itemView.findViewById(R.id.iv_iconDiApresiasi);
            icon_diPerhatikan = (ImageView) itemView.findViewById(R.id.iv_iconDiPerhatikan);

        }

//        @Override
//        public void onClick(View v) {
//            switch (v.getId()) {
//                case R.id.btn_diApresiasi:
//
//            }
//        }
    }

    @Override
    public CardDariKandidatAdapter.CardDariKandidatViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_dari_kandidat, parent, false);
        CardDariKandidatViewHolder cdkvh = new CardDariKandidatViewHolder(v);
        return cdkvh;
    }

    @Override
    public void onBindViewHolder(final CardDariKandidatAdapter.CardDariKandidatViewHolder holder, final int i) {

        final int jml_diApresiasi = cardDariKandidatList.get(i).mJmlDiapresiasi;
        final int jml_diPerhatikan = cardDariKandidatList.get(i).mJmlDiperhatikan;

        holder.mTglPost.setText(cardDariKandidatList.get(i).mJudulPost);
        holder.mIsiPost.setText(cardDariKandidatList.get(i).mIsiPost);
        holder.mJmlDiapresiasi.setText(String.valueOf(cardDariKandidatList.get(i).mJmlDiapresiasi));
        holder.mJmlDiperhatikan.setText(String.valueOf(cardDariKandidatList.get(i).mJmlDiperhatikan));
        holder.mNamaUser.setText(cardDariKandidatList.get(i).mNamaUser);
        holder.mJudulPost.setText(cardDariKandidatList.get(i).mJudulPost);
        holder.btn_diApresiasi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!diApresiasi) {
                    diApresiasi = true;
                    holder.icon_diApresiasi.setBackgroundResource(R.drawable.heart_red);
                    holder.mJmlDiapresiasi.setText(String.valueOf(jml_diApresiasi) + 1);
                } else if (diApresiasi == true) {
                    diApresiasi = false;
                    holder.icon_diApresiasi.setImageResource(R.drawable.heart_grey);
                    holder.mJmlDiapresiasi.setText(String.valueOf(jml_diPerhatikan));
                }
            }
        });
        holder.btn_diPerhatikan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!diPerhatikan) {
                    diPerhatikan = true;
                    holder.icon_diPerhatikan.setBackgroundResource(R.drawable.tanda_seru_merah_utama);
                    holder.mJmlDiperhatikan.setText(String.valueOf(jml_diPerhatikan)+1);
                } else
                if (diApresiasi == true){
                    diApresiasi = false;
                    holder.icon_diPerhatikan.setImageResource(R.drawable.tanda_seru_abu_lbh_tua);
                    holder.mJmlDiperhatikan.setText(String.valueOf(jml_diPerhatikan));
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return cardDariKandidatList == null ? 0 : cardDariKandidatList.size();
    }
}
