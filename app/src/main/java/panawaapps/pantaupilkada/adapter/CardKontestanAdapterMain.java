package panawaapps.pantaupilkada.adapter;

/**
 * Created by hanifsugiyanto on 04/11/15.
 */

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import panawaapps.pantaupilkada.R;
import panawaapps.pantaupilkada.activity.KandidatActivity;
import panawaapps.pantaupilkada.activity.PengamatActivity;
import panawaapps.pantaupilkada.activity.PickLocationActivity;
import panawaapps.pantaupilkada.api.ApiAdapter;
import panawaapps.pantaupilkada.model.Candidate;

import java.net.URI;
import java.util.ArrayList;

import panawaapps.pantaupilkada.model.Pengamat;
import panawaapps.pantaupilkada.model.Status;
import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;

public class CardKontestanAdapterMain extends RecyclerView.Adapter<CardKontestanAdapterMain.CardKontestanViewHolder> {



    Context context;
    private ArrayList<Candidate> candidateList;
    private Pengamat pengamat;
    private String province, provinceId;
    private boolean isPengamatActivity;

    public CardKontestanAdapterMain(Context context, Pengamat pengamat, String province, String provinceId, boolean isPengamatActivity) {
        this.context = context;
        this.pengamat = pengamat;
        this.province = province;
        this.provinceId = provinceId;
        this.isPengamatActivity = isPengamatActivity;
    }

    public CardKontestanAdapterMain(Context context, Pengamat pengamat, boolean isPengamatActivity) {
        this.context = context;
        this.pengamat = pengamat;
        this.isPengamatActivity = isPengamatActivity;
    }


    public class CardKontestanViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        CardView card_kontestan;
        TextView daerahKontestan;
        TextView jmlTps;
        ImageView btnCollapse;
        FrameLayout childCardKontestan;
        ImageView fotoCalon1;
        ImageView fotoWakil1;
        TextView namaCalon1;
        TextView namaWakil1;
        ImageView fotoCalon2;
        ImageView fotoWakil2;
        TextView namaCalon2;
        TextView namaWakil2;
        ImageView fotoCalon3;
        ImageView fotoWakil3;
        TextView namaCalon3;
        TextView namaWakil3;
        ImageView fotoCalon4;
        ImageView fotoWakil4;
        TextView namaCalon4;
        TextView namaWakil4;
        ImageView fotoCalon5;
        ImageView fotoWakil5;
        TextView namaCalon5;
        TextView namaWakil5;
        ImageView fotoCalon6;
        ImageView fotoWakil6;
        TextView namaCalon6;
        TextView namaWakil6;

        ImageView fotoCalon7;
        ImageView fotoWakil7;
        TextView namaCalon7;
        TextView namaWakil7;
        ImageView fotoCalon8;
        ImageView fotoWakil8;
        TextView namaCalon8;
        TextView namaWakil8;
        ImageView fotoCalon9;
        ImageView fotoWakil9;
        TextView namaCalon9;
        TextView namaWakil9;
        TextView jmlPemilih1;
        TextView jmlPemilih2;
        TextView jmlPemilih3;
        TextView jmlPemilih4;
        TextView jmlPemilih5;
        TextView jmlPemilih6;
        TextView jmlPemilih7;
        TextView jmlPemilih8;
        TextView jmlPemilih9;
        TextView jmlPengamat;
        TextView jmlPengawas;
        TextView jmlSaksi;
        TextView tglPemilihan;

        FrameLayout frameKandidat1;
        FrameLayout frameKandidat2;
        FrameLayout frameKandidat3;
        FrameLayout frameKandidat4;
        FrameLayout frameKandidat5;
        FrameLayout frameKandidat6;
        FrameLayout frameKandidat7;
        FrameLayout frameKandidat8;
        FrameLayout frameKandidat9;

        TextView btn_pengamat;
        TextView btn_pengawas;
        TextView btn_saksi;


        CardKontestanViewHolder(View itemView) {
            super(itemView);
            card_kontestan = (CardView) itemView.findViewById(R.id.card_kontestan);
            daerahKontestan = (TextView) itemView.findViewById(R.id.tv_daerahCardKontestan);
            jmlTps = (TextView) itemView.findViewById(R.id.tv_jmlTps);
            btnCollapse = (ImageView) itemView.findViewById(R.id.iv_btnCollapse);
            btnCollapse.setOnClickListener(this);
            childCardKontestan = (FrameLayout) itemView.findViewById(R.id.layoutChildCardKontestan);
            fotoCalon1 = (ImageView) itemView.findViewById(R.id.iv_fotoCalon1);
            fotoCalon2 = (ImageView) itemView.findViewById(R.id.iv_fotoCalon2);
            fotoCalon3 = (ImageView) itemView.findViewById(R.id.iv_fotoCalon3);
            fotoCalon4 = (ImageView) itemView.findViewById(R.id.iv_fotoCalon4);
            fotoCalon5 = (ImageView) itemView.findViewById(R.id.iv_fotoCalon5);
            fotoCalon6 = (ImageView) itemView.findViewById(R.id.iv_fotoCalon6);
            fotoCalon7 = (ImageView) itemView.findViewById(R.id.iv_fotoCalon7);
            fotoCalon8 = (ImageView) itemView.findViewById(R.id.iv_fotoCalon8);
            fotoCalon9 = (ImageView) itemView.findViewById(R.id.iv_fotoCalon9);
            fotoWakil1 = (ImageView) itemView.findViewById(R.id.iv_fotoWakil1);
            fotoWakil2 = (ImageView) itemView.findViewById(R.id.iv_fotoWakil2);
            fotoWakil3 = (ImageView) itemView.findViewById(R.id.iv_fotoWakil3);
            fotoWakil4 = (ImageView) itemView.findViewById(R.id.iv_fotoWakil4);
            fotoWakil5 = (ImageView) itemView.findViewById(R.id.iv_fotoWakil5);
            fotoWakil6 = (ImageView) itemView.findViewById(R.id.iv_fotoWakil6);
            fotoWakil7 = (ImageView) itemView.findViewById(R.id.iv_fotoWakil7);
            fotoWakil8 = (ImageView) itemView.findViewById(R.id.iv_fotoWakil8);
            fotoWakil9 = (ImageView) itemView.findViewById(R.id.iv_fotoWakil9);
            namaCalon1 = (TextView) itemView.findViewById(R.id.tv_namaCalon1);
            namaCalon2 = (TextView) itemView.findViewById(R.id.tv_namaCalon2);
            namaCalon3 = (TextView) itemView.findViewById(R.id.tv_namaCalon3);
            namaCalon4 = (TextView) itemView.findViewById(R.id.tv_namaCalon4);
            namaCalon5 = (TextView) itemView.findViewById(R.id.tv_namaCalon5);
            namaCalon6 = (TextView) itemView.findViewById(R.id.tv_namaCalon6);
            namaCalon7 = (TextView) itemView.findViewById(R.id.tv_namaCalon7);
            namaCalon8 = (TextView) itemView.findViewById(R.id.tv_namaCalon8);
            namaCalon9 = (TextView) itemView.findViewById(R.id.tv_namaCalon9);
            namaWakil1 = (TextView) itemView.findViewById(R.id.tv_namaWakil1);
            namaWakil2 = (TextView) itemView.findViewById(R.id.tv_namaWakil2);
            namaWakil3 = (TextView) itemView.findViewById(R.id.tv_namaWakil3);
            namaWakil4 = (TextView) itemView.findViewById(R.id.tv_namaWakil4);
            namaWakil5 = (TextView) itemView.findViewById(R.id.tv_namaWakil5);
            namaWakil6 = (TextView) itemView.findViewById(R.id.tv_namaWakil6);
            namaWakil7 = (TextView) itemView.findViewById(R.id.tv_namaWakil7);
            namaWakil8 = (TextView) itemView.findViewById(R.id.tv_namaWakil8);
            namaWakil9 = (TextView) itemView.findViewById(R.id.tv_namaWakil9);
            jmlPemilih1 = (TextView) itemView.findViewById(R.id.tv_jmlPemilih1);
            jmlPemilih2 = (TextView) itemView.findViewById(R.id.tv_jmlPemilih2);
            jmlPemilih3 = (TextView) itemView.findViewById(R.id.tv_jmlPemilih3);
            jmlPemilih4 = (TextView) itemView.findViewById(R.id.tv_jmlPemilih4);
            jmlPemilih5 = (TextView) itemView.findViewById(R.id.tv_jmlPemilih5);
            jmlPemilih6 = (TextView) itemView.findViewById(R.id.tv_jmlPemilih6);
            jmlPemilih7 = (TextView) itemView.findViewById(R.id.tv_jmlPemilih7);
            jmlPemilih8 = (TextView) itemView.findViewById(R.id.tv_jmlPemilih8);
            jmlPemilih9 = (TextView) itemView.findViewById(R.id.tv_jmlPemilih9);
            jmlPengamat = (TextView) itemView.findViewById(R.id.tv_jmlPengamat);
            jmlPengawas = (TextView) itemView.findViewById(R.id.tv_jmlPengawas);
            jmlSaksi = (TextView) itemView.findViewById(R.id.tv_jmlSaksi);
            tglPemilihan = (TextView) itemView.findViewById(R.id.tv_tglPemilihan);

            frameKandidat1 = (FrameLayout) itemView.findViewById(R.id.frameKandidat1);
            frameKandidat2 = (FrameLayout) itemView.findViewById(R.id.frameKandidat2);
            frameKandidat3 = (FrameLayout) itemView.findViewById(R.id.frameKandidat3);
            frameKandidat4 = (FrameLayout) itemView.findViewById(R.id.frameKandidat4);
            frameKandidat5 = (FrameLayout) itemView.findViewById(R.id.frameKandidat5);
            frameKandidat6 = (FrameLayout) itemView.findViewById(R.id.frameKandidat6);
            frameKandidat7 = (FrameLayout) itemView.findViewById(R.id.frameKandidat7);
            frameKandidat8 = (FrameLayout) itemView.findViewById(R.id.frameKandidat8);
            frameKandidat9 = (FrameLayout) itemView.findViewById(R.id.frameKandidat9);

            frameKandidat1.setOnClickListener(this);
            frameKandidat2.setOnClickListener(this);
            frameKandidat3.setOnClickListener(this);
            frameKandidat4.setOnClickListener(this);
            frameKandidat5.setOnClickListener(this);
            frameKandidat6.setOnClickListener(this);
            frameKandidat7.setOnClickListener(this);
            frameKandidat8.setOnClickListener(this);
            frameKandidat9.setOnClickListener(this);

            btn_pengamat = (TextView) itemView.findViewById(R.id.btn_pengamat);
            btn_pengawas = (TextView) itemView.findViewById(R.id.btn_pengawas);
            btn_saksi = (TextView) itemView.findViewById(R.id.btn_saksi);

            btn_pengamat.setOnClickListener(this);
            btn_pengawas.setOnClickListener(this);
            btn_saksi.setOnClickListener(this);
            /*
            personName = (TextView)itemView.findViewById(R.id.person_name);
            personAge = (TextView)itemView.findViewById(R.id.person_age);
            personPhoto1 = (ImageView)itemView.findViewById(R.id.person_photo1);
            personPhoto2 = (ImageView)itemView.findViewById(R.id.person_photo2);
            */
        }

        @Override
        public void onClick(View v) {
            int position = getAdapterPosition();
            switch (v.getId()) {
                case R.id.iv_btnCollapse:
                    if (childCardKontestan.getVisibility() == View.VISIBLE) {
                        childCardKontestan.setVisibility(View.GONE);
                        btnCollapse.setImageResource(R.drawable.accordion_white);
                    } else {
                        childCardKontestan.setVisibility(View.VISIBLE);
                        btnCollapse.setImageResource(R.drawable.accordion_up_white);
                    }
                    //membuat collapse layoutChildCardKontestan
                    break;
//                case R.id.buttonCloseCard:
//                    delete(getAdapterPosition());
//                    break;
                case R.id.frameKandidat1:
                    newActivity(pengamat.getCandidatesList(position).get(0).getCouple_id());
                    break;
                case R.id.frameKandidat2:
                    newActivity(pengamat.getCandidatesList(position).get(1).getCouple_id());
                    break;
                case R.id.frameKandidat3:
                    newActivity(pengamat.getCandidatesList(position).get(2).getCouple_id());
                    break;
                case R.id.frameKandidat4:
                    newActivity(pengamat.getCandidatesList(position).get(3).getCouple_id());
                    break;
                case R.id.frameKandidat5:
                    newActivity(pengamat.getCandidatesList(position).get(4).getCouple_id());
                    break;
                case R.id.frameKandidat6:
                    newActivity(pengamat.getCandidatesList(position).get(5).getCouple_id());
                    break;
                case R.id.frameKandidat7:
                    newActivity(pengamat.getCandidatesList(position).get(6).getCouple_id());
                    break;
                case R.id.frameKandidat8:
                    newActivity(pengamat.getCandidatesList(position).get(7).getCouple_id());
                    break;
                case R.id.frameKandidat9:
                    newActivity(pengamat.getCandidatesList(position).get(8).getCouple_id());
                    break;

                case R.id.btn_pengamat:
                    if (isPengamatActivity) {
                        unpinCard(pengamat.getCandidatesList(position).get(0).getRegion_id());
                        Toast.makeText(context, "Anda telah berhenti menjadi pengamat Pemilihan" + " " +
                                pengamat.getCandidatesList(position).get(0).getKind_label() + ", " +
                                pengamat.getCandidatesList(position).get(0).getKind() + " " +
                                pengamat.getCandidatesList(position).get(0).getRegion_name()
                                , Toast.LENGTH_SHORT).show();
                    }
                    else{
                        pinCard(pengamat.getCandidatesList(position).get(0).getRegion_id());
                        Toast.makeText(context, "Anda telah menjadi pengamat Pemilihan " + " " +
                                pengamat.getCandidatesList(position).get(0).getKind_label() + ", " +
                                pengamat.getCandidatesList(position).get(0).getKind() + " " +
                                pengamat.getCandidatesList(position).get(0).getRegion_name(), Toast.LENGTH_SHORT).show();
                    }
                    break;
                case R.id.btn_pengawas:
                    pickLocationActivity(pengamat.getCandidatesList(position).get(0).getKind(), position);
                    break;
                case R.id.btn_saksi:
                    pickLocationActivity(pengamat.getCandidatesList(position).get(0).getKind(), position);
                    break;
            }
        }

        private void unpinCard(String regionID) {
            new ApiAdapter().getRestApi().unpinPengamat(regionID, new Callback<Status>() {
                @Override
                public void success(Status s, Response response) {
                    Log.d("MyLogs", "Status - " + s.getStatus());
                    notifyDataSetChanged();
                }

                @Override
                public void failure(RetrofitError error) {
                    Log.d("MyLogs", "Error - " + error.getMessage());
                }
            });
        }

        private void pinCard(String regionID) {
            new ApiAdapter().getRestApi().pinPengamat("{}", regionID, new Callback<Status>() {
                @Override
                public void success(Status s, Response response) {
                    Log.d("MyLogs", "Status - " + s.getStatus());
                    context.startActivity(new Intent(context, PengamatActivity.class));
                }

                @Override
                public void failure(RetrofitError error) {
                    Log.d("MyLogs", "Error - " + error.getMessage());
                }
            });
        }

        private void newActivity(String couple_id) {
            Intent intent = new Intent();
            intent.setClass(context, KandidatActivity.class);
            intent.putExtra("couple_id", couple_id);
            context.startActivity(intent);
        }

        private void pickLocationActivity(String kind, int position) {
            Intent intent = new Intent();
            intent.setClass(context, PickLocationActivity.class);
            Log.d("MyLogs", "KIND - " + kind);
            if (!kind.toLowerCase().equals("provinsi")) {
                intent.putExtra("id", pengamat.getCandidatesList(position).get(0).getRegion_id());
                intent.putExtra("name", daerahKontestan.getText().toString());
                intent.putExtra("area", 1);
            } else {
                if (pengamat.getCandidatesList(position).get(0).getProvince_id() != null)
                    provinceId = pengamat.getCandidatesList(position).get(0).getProvince_id();
                intent.putExtra("id", provinceId);
                if (pengamat.getCandidatesList(position).get(0).getProvince_name() != null)
                    province = pengamat.getCandidatesList(position).get(0).getProvince_name();
                intent.putExtra("name", pengamat.getCandidatesList(position).get(0).getKind_label() + ", " + province);
                intent.putExtra("area", 0);
            }
            intent.putExtra("kind", kind.toLowerCase());
            context.startActivity(intent);
        }
    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }

    @Override
    public CardKontestanViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.card_kontestan, viewGroup, false);
        return new CardKontestanViewHolder(v);
    }

    @Override
    public void onBindViewHolder(CardKontestanViewHolder cardKontestanViewHolder, int i) {
        if (isPengamatActivity)
            province = pengamat.getCandidatesList(i).get(0).getProvince_name();
        String header = pengamat.getCandidatesList(i).get(0).getKind_label() + ", " + province;
        if (!pengamat.getCandidatesList(i).get(0).getKind().toLowerCase().equals("provinsi"))
            header += ", " + pengamat.getCandidatesList(i).get(0).getRegion_name();
        cardKontestanViewHolder.daerahKontestan.setText(header);
        cardKontestanViewHolder.jmlTps.setText("");
       /* cardKontestanViewHolder.fotoCalon1.setImageResource(cardKotestans.get(i).fotoCalon1);
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
        cardKontestanViewHolder.fotoCalon6.setImageResource(cardKotestans.get(i).fotoCalon6);*/
        candidateList = pengamat.getCandidatesList(i);
        int size = candidateList.size();
        if (size >= 1) {
//            URI fotoCalonUrl =  ;
            cardKontestanViewHolder.frameKandidat1.setVisibility(View.VISIBLE);
            Picasso.with(cardKontestanViewHolder.itemView.getContext()).load(candidateList.get(0).getCalon_avatar()).into(cardKontestanViewHolder.fotoCalon1);
            cardKontestanViewHolder.namaCalon1.setText(candidateList.get(0).getCalon_name());
            cardKontestanViewHolder.namaWakil1.setText(candidateList.get(0).getWakil_name());
            cardKontestanViewHolder.jmlPemilih1.setText(String.valueOf(candidateList.get(0).getTotal_vote_in_1_region()));
            if(candidateList.get(0).getTotal_vote_in_1_region() > 0){
                cardKontestanViewHolder.jmlPemilih1.setVisibility(View.VISIBLE);
            }
        }
        if (size >= 2) {
            cardKontestanViewHolder.frameKandidat2.setVisibility(View.VISIBLE);
            Picasso.with(cardKontestanViewHolder.itemView.getContext()).load(candidateList.get(1).getCalon_avatar()).into(cardKontestanViewHolder.fotoCalon1);
            cardKontestanViewHolder.namaCalon2.setText(candidateList.get(1).getCalon_name());
            cardKontestanViewHolder.namaWakil2.setText(candidateList.get(1).getWakil_name());
            cardKontestanViewHolder.jmlPemilih2.setText(String.valueOf(candidateList.get(1).getTotal_vote_in_1_region()));
            if(candidateList.get(1).getTotal_vote_in_1_region() > 0){
                cardKontestanViewHolder.jmlPemilih1.setVisibility(View.VISIBLE);
            }
        }
        if (size >= 3) {
            cardKontestanViewHolder.frameKandidat3.setVisibility(View.VISIBLE);
            Picasso.with(cardKontestanViewHolder.itemView.getContext()).load(candidateList.get(2).getCalon_avatar()).into(cardKontestanViewHolder.fotoCalon1);
            cardKontestanViewHolder.namaCalon3.setText(candidateList.get(2).getCalon_name());
            cardKontestanViewHolder.namaWakil3.setText(candidateList.get(2).getWakil_name());
            cardKontestanViewHolder.jmlPemilih3.setText(String.valueOf(candidateList.get(2).getTotal_vote_in_1_region()));
            if(candidateList.get(2).getTotal_vote_in_1_region() > 0){
                cardKontestanViewHolder.jmlPemilih1.setVisibility(View.VISIBLE);
            }
        }
        if (size >= 4) {
            cardKontestanViewHolder.frameKandidat4.setVisibility(View.VISIBLE);
            Picasso.with(cardKontestanViewHolder.itemView.getContext()).load(candidateList.get(3).getCalon_avatar()).into(cardKontestanViewHolder.fotoCalon1);
            cardKontestanViewHolder.namaCalon4.setText(candidateList.get(3).getCalon_name());
            cardKontestanViewHolder.namaWakil4.setText(candidateList.get(3).getWakil_name());
            cardKontestanViewHolder.jmlPemilih4.setText(String.valueOf(candidateList.get(3).getTotal_vote_in_1_region()));
            if(candidateList.get(3).getTotal_vote_in_1_region() > 0){
                cardKontestanViewHolder.jmlPemilih1.setVisibility(View.VISIBLE);
            }
        }
        if (size >= 5) {
            cardKontestanViewHolder.frameKandidat5.setVisibility(View.VISIBLE);
            Picasso.with(cardKontestanViewHolder.itemView.getContext()).load(candidateList.get(4).getCalon_avatar()).into(cardKontestanViewHolder.fotoCalon1);
            cardKontestanViewHolder.namaCalon5.setText(candidateList.get(4).getCalon_name());
            cardKontestanViewHolder.namaWakil5.setText(candidateList.get(4).getWakil_name());
            cardKontestanViewHolder.jmlPemilih5.setText(String.valueOf(candidateList.get(4).getTotal_vote_in_1_region()));
            if(candidateList.get(4).getTotal_vote_in_1_region() > 0){
                cardKontestanViewHolder.jmlPemilih1.setVisibility(View.VISIBLE);
            }
        }
        if (size >= 6) {
            cardKontestanViewHolder.frameKandidat6.setVisibility(View.VISIBLE);
            Picasso.with(cardKontestanViewHolder.itemView.getContext()).load(candidateList.get(5).getCalon_avatar()).into(cardKontestanViewHolder.fotoCalon1);
            cardKontestanViewHolder.namaCalon6.setText(candidateList.get(5).getCalon_name());
            cardKontestanViewHolder.namaWakil6.setText(candidateList.get(5).getWakil_name());
            cardKontestanViewHolder.jmlPemilih6.setText(String.valueOf(candidateList.get(5).getTotal_vote_in_1_region()));
            if(candidateList.get(5).getTotal_vote_in_1_region() > 0){
                cardKontestanViewHolder.jmlPemilih1.setVisibility(View.VISIBLE);
            }
        }
        if (size >= 7) {
            cardKontestanViewHolder.frameKandidat7.setVisibility(View.VISIBLE);
            Picasso.with(cardKontestanViewHolder.itemView.getContext()).load(candidateList.get(6).getCalon_avatar()).into(cardKontestanViewHolder.fotoCalon1);
            cardKontestanViewHolder.namaCalon7.setText(candidateList.get(6).getCalon_name());
            cardKontestanViewHolder.namaWakil7.setText(candidateList.get(6).getWakil_name());
            cardKontestanViewHolder.jmlPemilih7.setText(String.valueOf(candidateList.get(6).getTotal_vote_in_1_region()));
            if(candidateList.get(6).getTotal_vote_in_1_region() > 0){
                cardKontestanViewHolder.jmlPemilih1.setVisibility(View.VISIBLE);
            }
        }

//        cardKontestanViewHolder.jmlPemilih1.setText(cardKotestans.get(i).jmlPemilih1);
//        cardKontestanViewHolder.jmlPemilih2.setText(cardKotestans.get(i).jmlPemilih2);
//        cardKontestanViewHolder.jmlPemilih3.setText(cardKotestans.get(i).jmlPemilih3);
//        cardKontestanViewHolder.jmlPemilih4.setText(cardKotestans.get(i).jmlPemilih4);
//        cardKontestanViewHolder.jmlPemilih5.setText(cardKotestans.get(i).jmlPemilih5);
//        cardKontestanViewHolder.jmlPemilih6.setText(cardKotestans.get(i).jmlPemilih6);

//        cardKontestanViewHolder.jmlPengamat.setText(cardKotestans.get(i).jmlPengamat);
//        cardKontestanViewHolder.jmlPengawas.setText(cardKotestans.get(i).jmlPengawas);
//        cardKontestanViewHolder.jmlSaksi.setText(cardKotestans.get(i).jmlSaksi);
//        cardKontestanViewHolder.tglPemilihan.setText(cardKotestans.get(i).tglPemilihan);
        /*
        cardKontestanViewHolder.personName.setText(kandidats.get(i).name);
        cardKontestanViewHolder.personAge.setText(kandidats.get(i).age);
        cardKontestanViewHolder.personPhoto1.setImageResource(kandidats.get(i).photoId1);
        cardKontestanViewHolder.personPhoto2.setImageResource(kandidats.get(i).photoId2);
        */
    }

    @Override
    public int getItemCount() {
        return pengamat == null ? 0 : pengamat.size();
    }
//    @Override
//    public int getItemCount() {
//        return cardKotestans.size();
//    }

    public void notifyDataSetChanged(Pengamat pengamat, String province, String provinceId) {
        this.pengamat = pengamat;
        this.province = province;
        this.provinceId = provinceId;
        notifyDataSetChanged();
    }

    public void notifyDataSetChanged(Pengamat pengamat) {
        this.pengamat = pengamat;
        notifyDataSetChanged();
    }
}