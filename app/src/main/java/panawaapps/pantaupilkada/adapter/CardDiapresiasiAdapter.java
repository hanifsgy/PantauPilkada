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
import panawaapps.pantaupilkada.model.Home.Datum;

/**
 * Created by Sikikan on 11/28/2015.
 */
public class CardDiapresiasiAdapter extends RecyclerView.Adapter<CardDiapresiasiAdapter.CardDiapresiasiViewHolder> {

    public List<Datum> cardDiapresiasiList;

    public CardDiapresiasiAdapter(List<Datum> cardDiapresiasiList) {
        this.cardDiapresiasiList = cardDiapresiasiList;
    }


//    public void addCard(CardDariKandidat cardDariKandidat){
//        cardDariKandidatList.add(cardDariKandidat);
//        notifyDataSetChanged();
//    }

    public class CardDiapresiasiViewHolder extends RecyclerView.ViewHolder {

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


        public CardDiapresiasiViewHolder(View itemView) {
            super(itemView);
            mJudulPost = (TextView) itemView.findViewById(R.id.tv_judulPost);
            mIsiPost = (TextView) itemView.findViewById(R.id.tv_isiPost);
            mTglPost = (TextView) itemView.findViewById(R.id.tv_tglPost);
            mNamaUser = (TextView) itemView.findViewById(R.id.tv_namaUser);
            mJmlDiapresiasi = (TextView) itemView.findViewById(R.id.tv_jmlDiApresiasi);
            mJmlDiperhatikan = (TextView) itemView.findViewById(R.id.tv_jmldiPerhatikan);
            btn_diApresiasi = (FrameLayout) itemView.findViewById(R.id.btn_diApresiasi);
            btn_diPerhatikan = (FrameLayout) itemView.findViewById(R.id.btn_diPerhatikan);
            btn_diPerhatikan.setVisibility(View.GONE);

            icon_diApresiasi = (ImageView) itemView.findViewById(R.id.iv_iconDiApresiasi);
            icon_diPerhatikan = (ImageView) itemView.findViewById(R.id.iv_iconDiPerhatikan);

        }

    }

    @Override
    public CardDiapresiasiViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_dari_kandidat, parent, false);
        CardDiapresiasiAdapter.CardDiapresiasiViewHolder cdvh = new CardDiapresiasiViewHolder(v);
        return cdvh;
    }

    @Override
    public void onBindViewHolder(final CardDiapresiasiViewHolder holder, final int i) {

        final int jml_diApresiasi = cardDiapresiasiList.get(i).getComment().getFeedbackApresiasiCount();
        final int jml_diPerhatikan = cardDiapresiasiList.get(i).getComment().getFeedbackPerhatikanCount();

        final boolean[] diApresiasi = {false};
        final boolean[] diPerhatikan = {false};

        holder.mTglPost.setText(cardDiapresiasiList.get(i).getComment().getCreatedAt().substring(0, 9));
        holder.mIsiPost.setText(cardDiapresiasiList.get(i).getComment().getText());
        holder.mJmlDiapresiasi.setText(String.valueOf(jml_diApresiasi));
        holder.mJmlDiperhatikan.setText(String.valueOf(jml_diPerhatikan));
        holder.mNamaUser.setText(cardDiapresiasiList.get(i).getComment().getPersonName());
        holder.mJudulPost.setText(cardDiapresiasiList.get(i).getComment().getTitle());
        if(cardDiapresiasiList.get(i).getComment().getFeedbackApresiasiCount() > 0){
            holder.mJmlDiapresiasi.setVisibility(View.VISIBLE);
        }
        if(cardDiapresiasiList.get(i).getComment().getFeedbackPerhatikanCount() > 0){
            holder.mJmlDiperhatikan.setVisibility(View.VISIBLE);
        }
        holder.btn_diApresiasi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (diApresiasi[0] == false){
                    diApresiasi[0] = true;
                    holder.icon_diApresiasi.setImageResource(R.drawable.heart_merah_tua);
                    holder.mJmlDiapresiasi.setText(String.valueOf((cardDiapresiasiList.get(i).getComment().getFeedbackApresiasiCount())+1));
                } else
                if (diApresiasi[0] == true){
                    diApresiasi[0] = false;
                    holder.icon_diApresiasi.setImageResource(R.drawable.heart_merah_utama);
                    holder.mJmlDiapresiasi.setText(String.valueOf(cardDiapresiasiList.get(i).getComment().getFeedbackApresiasiCount()));
                }
            }
        });
        holder.btn_diPerhatikan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (diPerhatikan[0] == false) {
                    diPerhatikan[0] = true;
                    holder.icon_diPerhatikan.setImageResource(R.drawable.tanda_seru_merah_tua);
                    holder.mJmlDiperhatikan.setText(String.valueOf((cardDiapresiasiList.get(i).getComment().getFeedbackPerhatikanCount()) + 1));
                } else if (diPerhatikan[0] == true) {
                    diPerhatikan[0] = false;
                    holder.icon_diPerhatikan.setImageResource(R.drawable.tanda_seru_merah_utama);
                    holder.mJmlDiperhatikan.setText(String.valueOf(cardDiapresiasiList.get(i).getComment().getFeedbackPerhatikanCount()));
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return cardDiapresiasiList == null ? 0 : cardDiapresiasiList.size();
    }
}
