package panawaapps.pantaupilkada.adapter;

/**
 * Created by hanifsugiyanto on 04/11/15.
 */

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.List;

import panawaapps.pantaupilkada.R;
import panawaapps.pantaupilkada.activity.DariKandidatActivity;
import panawaapps.pantaupilkada.activity.KabupatenActivity;
import panawaapps.pantaupilkada.activity.KandidatActivity;
import panawaapps.pantaupilkada.model.CardKontestan;

public class CardKontestanAdapter extends RecyclerView.Adapter<CardKontestanAdapter.CardKontestanViewHolder> {

    Context context;

    List<CardKontestan> cardKotestans;

    public CardKontestanAdapter(Context context, List<CardKontestan> cardKotestans) {
        this.context = context;
        this.cardKotestans = cardKotestans;
    }

//    public void delete(int position){
//        kandidats.remove(position);
//        notifyItemRemoved(position);
//    }


    public class CardKontestanViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        LinearLayout card_kontestan;
        TextView  daerahKontestan;
        TextView jmlTps;
        ImageView btnCollapse;
        FrameLayout childCardKontestan;
        ImageView fotoCalon1;
        ImageView fotoWakil1;
        TextView  namaCalon1;
        TextView  namaWakil1;
        ImageView fotoCalon2;
        ImageView fotoWakil2;
        TextView  namaCalon2;
        TextView  namaWakil2;
        ImageView fotoCalon3;
        ImageView fotoWakil3;
        TextView  namaCalon3;
        TextView  namaWakil3;
        ImageView fotoCalon4;
        ImageView fotoWakil4;
        TextView  namaCalon4;
        TextView  namaWakil4;
        ImageView fotoCalon5;
        ImageView fotoWakil5;
        TextView  namaCalon5;
        TextView  namaWakil5;
        ImageView fotoCalon6;
        ImageView fotoWakil6;
        TextView  namaCalon6;
        TextView  namaWakil6;
        TextView  jmlPemilih1;
        TextView  jmlPemilih2;
        TextView  jmlPemilih3;
        TextView  jmlPemilih4;
        TextView  jmlPemilih5;
        TextView  jmlPemilih6;
        TextView  jmlPengamat;
        TextView  jmlPengawas;
        TextView  jmlSaksi;
        TextView  tglPemilihan;

        TextView btn_pengawas;


        CardKontestanViewHolder(View itemView) {
            super(itemView);
            card_kontestan = (LinearLayout)itemView.findViewById(R.id.card_kontestan);
            daerahKontestan = (TextView) itemView.findViewById(R.id.tv_daerahCardKontestan);
            jmlTps = (TextView) itemView.findViewById(R.id.tv_jmlTps);
            btnCollapse = (ImageView) itemView.findViewById(R.id.iv_btnCollapse);
            btnCollapse.setOnClickListener(this);
            childCardKontestan = (FrameLayout) itemView.findViewById(R.id.layoutChildCardKontestan);
            fotoCalon1 = (ImageView) itemView.findViewById(R.id.iv_fotoCalon1);
            fotoCalon1.setOnClickListener(this);
            fotoCalon2 = (ImageView) itemView.findViewById(R.id.iv_fotoCalon2);
            fotoCalon3 = (ImageView) itemView.findViewById(R.id.iv_fotoCalon3);
            fotoCalon4 = (ImageView) itemView.findViewById(R.id.iv_fotoCalon4);
            fotoCalon5 = (ImageView) itemView.findViewById(R.id.iv_fotoCalon5);
            fotoCalon6 = (ImageView) itemView.findViewById(R.id.iv_fotoCalon6);
            fotoWakil1 = (ImageView) itemView.findViewById(R.id.iv_fotoWakil1);
            fotoWakil2 = (ImageView) itemView.findViewById(R.id.iv_fotoWakil2);
            fotoWakil3 = (ImageView) itemView.findViewById(R.id.iv_fotoWakil3);
            fotoWakil4 = (ImageView) itemView.findViewById(R.id.iv_fotoWakil4);
            fotoWakil5 = (ImageView) itemView.findViewById(R.id.iv_fotoWakil5);
            fotoWakil6 = (ImageView) itemView.findViewById(R.id.iv_fotoWakil6);
            namaCalon1 = (TextView) itemView.findViewById(R.id.tv_namaCalon1);
            namaCalon2 = (TextView) itemView.findViewById(R.id.tv_namaCalon2);
            namaCalon3 = (TextView) itemView.findViewById(R.id.tv_namaCalon3);
            namaCalon4 = (TextView) itemView.findViewById(R.id.tv_namaCalon4);
            namaCalon5 = (TextView) itemView.findViewById(R.id.tv_namaCalon5);
            namaCalon6 = (TextView) itemView.findViewById(R.id.tv_namaCalon6);
            namaWakil1 = (TextView) itemView.findViewById(R.id.tv_namaWakil1);
            namaWakil2 = (TextView) itemView.findViewById(R.id.tv_namaWakil2);
            namaWakil3 = (TextView) itemView.findViewById(R.id.tv_namaWakil3);
            namaWakil4 = (TextView) itemView.findViewById(R.id.tv_namaWakil4);
            namaWakil5 = (TextView) itemView.findViewById(R.id.tv_namaWakil5);
            namaWakil6 = (TextView) itemView.findViewById(R.id.tv_namaWakil6);
            jmlPemilih1 = (TextView) itemView.findViewById(R.id.tv_jmlPemilih1);
            jmlPemilih2 = (TextView) itemView.findViewById(R.id.tv_jmlPemilih2);
            jmlPemilih3 = (TextView) itemView.findViewById(R.id.tv_jmlPemilih3);
            jmlPemilih4 = (TextView) itemView.findViewById(R.id.tv_jmlPemilih4);
            jmlPemilih5 = (TextView) itemView.findViewById(R.id.tv_jmlPemilih5);
            jmlPemilih6 = (TextView) itemView.findViewById(R.id.tv_jmlPemilih6);
            jmlPengamat = (TextView) itemView.findViewById(R.id.tv_jmlPengamat);
            jmlPengawas = (TextView) itemView.findViewById(R.id.tv_jmlPengawas);
            jmlSaksi    = (TextView) itemView.findViewById(R.id.tv_jmlSaksi);
            tglPemilihan = (TextView) itemView.findViewById(R.id.tv_tglPemilihan);

            btn_pengawas = (TextView) itemView.findViewById(R.id.btn_pengawas);
            btn_pengawas.setOnClickListener(this);
            /*
            personName = (TextView)itemView.findViewById(R.id.person_name);
            personAge = (TextView)itemView.findViewById(R.id.person_age);
            personPhoto1 = (ImageView)itemView.findViewById(R.id.person_photo1);
            personPhoto2 = (ImageView)itemView.findViewById(R.id.person_photo2);
            */
        }

        @Override
        public void onClick(View v) {
            switch (v.getId()){
                case R.id.iv_btnCollapse:
                    if (childCardKontestan.getVisibility()== View.VISIBLE) {
                    childCardKontestan.setVisibility(View.GONE);
                        btnCollapse.setImageResource(R.drawable.accordion_white);
                    } else {
                        childCardKontestan.setVisibility(View.VISIBLE);
                        btnCollapse.setImageResource(R.drawable.accordion_up_white);
                    }
                    //membuat collapse layoutChildCardKontestan
                    break;

                case R.id.iv_fotoCalon1:
                    Intent pilihKandidat = new Intent(context, DariKandidatActivity.class);
                    context.startActivity(pilihKandidat);
                    break;

                case R.id.btn_pengawas:
                    //start activity kabupaten and give TPS location id with "kind" from JSON. ex: if(kind=province) then start kabupaten activity. if(kind=kabupaten) then start kecamatan activity.
                    Intent PilihTPS = new Intent(context, KabupatenActivity.class);
                    context.startActivity(PilihTPS);
                    break;
//                case R.id.buttonCloseCard:
//                    delete(getAdapterPosition());
//                    break;
            }
        }
    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }

    @Override
    public CardKontestanViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.card_kontestan, viewGroup, false);
        CardKontestanViewHolder ckvh = new CardKontestanViewHolder(v);
        return ckvh;
    }

    @Override
    public void onBindViewHolder(CardKontestanViewHolder cardKontestanViewHolder, int i) {
        cardKontestanViewHolder.daerahKontestan.setText(cardKotestans.get(i).daerahCardKontestan);
        cardKontestanViewHolder.jmlTps.setText(cardKotestans.get(i).jmlTps);
        cardKontestanViewHolder.fotoCalon1.setImageResource(cardKotestans.get(i).fotoCalon1);
        cardKontestanViewHolder.fotoCalon2.setImageResource(cardKotestans.get(i).fotoCalon2);
        cardKontestanViewHolder.fotoCalon3.setImageResource(cardKotestans.get(i).fotoCalon3);
        cardKontestanViewHolder.fotoCalon4.setImageResource(cardKotestans.get(i).fotoCalon4);
        cardKontestanViewHolder.fotoCalon5.setImageResource(cardKotestans.get(i).fotoCalon5);
        cardKontestanViewHolder.fotoCalon6.setImageResource(cardKotestans.get(i).fotoCalon6);
        cardKontestanViewHolder.fotoWakil1.setImageResource(cardKotestans.get(i).fotoWakil1);
        cardKontestanViewHolder.fotoWakil2.setImageResource(cardKotestans.get(i).fotoWakil2);
        cardKontestanViewHolder.fotoWakil3.setImageResource(cardKotestans.get(i).fotoWakil3);
        cardKontestanViewHolder.fotoWakil4.setImageResource(cardKotestans.get(i).fotoWakil4);
        cardKontestanViewHolder.fotoCalon5.setImageResource(cardKotestans.get(i).fotoCalon5);
        cardKontestanViewHolder.fotoCalon6.setImageResource(cardKotestans.get(i).fotoCalon6);
        cardKontestanViewHolder.namaCalon1.setText(cardKotestans.get(i).namaCalon1);
        cardKontestanViewHolder.namaCalon2.setText(cardKotestans.get(i).namaCalon2);
        cardKontestanViewHolder.namaCalon3.setText(cardKotestans.get(i).namaCalon3);
        cardKontestanViewHolder.namaCalon4.setText(cardKotestans.get(i).namaCalon4);
        cardKontestanViewHolder.namaCalon5.setText(cardKotestans.get(i).namaCalon5);
        cardKontestanViewHolder.namaCalon6.setText(cardKotestans.get(i).namaCalon6);
        cardKontestanViewHolder.namaWakil1.setText(cardKotestans.get(i).namaWakil1);
        cardKontestanViewHolder.namaWakil2.setText(cardKotestans.get(i).namaWakil2);
        cardKontestanViewHolder.namaWakil3.setText(cardKotestans.get(i).namaWakil3);
        cardKontestanViewHolder.namaWakil4.setText(cardKotestans.get(i).namaWakil4);
        cardKontestanViewHolder.namaCalon5.setText(cardKotestans.get(i).namaCalon5);
        cardKontestanViewHolder.namaCalon6.setText(cardKotestans.get(i).namaCalon6);
        cardKontestanViewHolder.jmlPemilih1.setText(cardKotestans.get(i).jmlPemilih1);
        cardKontestanViewHolder.jmlPemilih2.setText(cardKotestans.get(i).jmlPemilih2);
        cardKontestanViewHolder.jmlPemilih3.setText(cardKotestans.get(i).jmlPemilih3);
        cardKontestanViewHolder.jmlPemilih4.setText(cardKotestans.get(i).jmlPemilih4);
        cardKontestanViewHolder.jmlPemilih5.setText(cardKotestans.get(i).jmlPemilih5);
        cardKontestanViewHolder.jmlPemilih6.setText(cardKotestans.get(i).jmlPemilih6);
        cardKontestanViewHolder.jmlPengamat.setText(cardKotestans.get(i).jmlPengamat);
        cardKontestanViewHolder.jmlPengawas.setText(cardKotestans.get(i).jmlPengawas);
        cardKontestanViewHolder.jmlSaksi.setText(cardKotestans.get(i).jmlSaksi);
        cardKontestanViewHolder.tglPemilihan.setText(cardKotestans.get(i).tglPemilihan);
        /*
        cardKontestanViewHolder.personName.setText(kandidats.get(i).name);
        cardKontestanViewHolder.personAge.setText(kandidats.get(i).age);
        cardKontestanViewHolder.personPhoto1.setImageResource(kandidats.get(i).photoId1);
        cardKontestanViewHolder.personPhoto2.setImageResource(kandidats.get(i).photoId2);
        */
    }

    @Override
    public int getItemCount() {
        return cardKotestans == null ? 0 : cardKotestans.size();
    }
//    @Override
//    public int getItemCount() {
//        return cardKotestans.size();
//    }
}