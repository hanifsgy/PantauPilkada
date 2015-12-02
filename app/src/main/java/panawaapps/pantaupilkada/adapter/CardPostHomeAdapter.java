package panawaapps.pantaupilkada.adapter;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.ms.square.android.expandabletextview.ExpandableTextView;

import java.util.List;

import panawaapps.pantaupilkada.R;
import panawaapps.pantaupilkada.activity.DariKandidatActivity;
import panawaapps.pantaupilkada.activity.DariKandidatTambahPostActivity;
import panawaapps.pantaupilkada.activity.KandidatActivity;
import panawaapps.pantaupilkada.activity.ReplyHomeActivity;
import panawaapps.pantaupilkada.api.ApiAdapter;
import panawaapps.pantaupilkada.model.CardPostHome;
import panawaapps.pantaupilkada.model.CheckReplyPremium;
import panawaapps.pantaupilkada.model.Home.Comment;
import panawaapps.pantaupilkada.model.Home.Datum;
import panawaapps.pantaupilkada.model.Premium;
import panawaapps.pantaupilkada.model.PremiumReply;
import panawaapps.pantaupilkada.model.Status;
import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;

/**
 * Created by Sikikan on 11/22/2015.
 */
public class CardPostHomeAdapter extends RecyclerView.Adapter<CardPostHomeAdapter.CardPostHomeViewHolder> {

    Context context;
    List<Datum> cardPostHomes;
    String commentid;

    ApiAdapter apiAdapter;

    String token;
    String idcomment;

    public CardPostHomeAdapter(Context context, List<Datum> cardPostHomes, String token) {
        this.context = context;
        this.cardPostHomes = cardPostHomes;
        this.token = token;
    }

    public class CardPostHomeViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        FrameLayout card_postHome;
        TextView judulPostHome;
        //        ImageView fotoPostHome;
        TextView isiPostHome;
        TextView tglPostHome;
        TextView jmlApresiasi;
        TextView jmlPerhatian;
        TextView tvPoster;
        TextView tvCalon;
        TextView tvWakil;
        TextView namaProvinsi;

        ImageView btn_reply;

        FrameLayout btn_diApresiasi;
        FrameLayout btn_diPerhatikan;
        ImageView icon_diApresiasi;
        ImageView icon_diPerhatikan;

        LinearLayout card_reply;

        TextView isiReply;
        TextView tglReply;

        ExpandableTextView isiPost;

        int jmlDiapresiasi;
        int jmlDiperhatikan;


        public CardPostHomeViewHolder(View itemView) {
            super(itemView);
            card_postHome = (FrameLayout) itemView.findViewById(R.id.card_postHome);
            judulPostHome = (TextView) itemView.findViewById(R.id.tv_judulPostHome);
//            fotoPostHome = (ImageView) itemView.findViewById(R.id.iv_fotoPostHome);
            namaProvinsi = (TextView) itemView.findViewById(R.id.tv_namaProvinsi);
            isiPostHome = (TextView) itemView.findViewById(R.id.tv_isiPostHome);

            tglPostHome = (TextView) itemView.findViewById(R.id.tv_tglPostHome);
            tvPoster = (TextView) itemView.findViewById(R.id.tv_userPoster);
            tvCalon = (TextView) itemView.findViewById(R.id.tv_namaCalon);
            tvWakil = (TextView) itemView.findViewById(R.id.tv_namaWakil);
            jmlApresiasi = (TextView) itemView.findViewById(R.id.tv_jmlApresiasi);
            jmlPerhatian = (TextView) itemView.findViewById(R.id.tv_jmlPerhatian);
            btn_reply = (ImageView) itemView.findViewById(R.id.btn_reply_home);
            btn_reply.setOnClickListener(this);
            btn_diApresiasi = (FrameLayout) itemView.findViewById(R.id.btn_diApresiasi);
            btn_diApresiasi.setOnClickListener(this);
            btn_diPerhatikan = (FrameLayout) itemView.findViewById(R.id.btn_diPerhatikan);
            btn_diPerhatikan.setOnClickListener(this);

            isiPost = (ExpandableTextView) itemView.findViewById(R.id.card_postHome).findViewById(R.id.expand_text_view);

            icon_diApresiasi = (ImageView) itemView.findViewById(R.id.iv_iconDiApresiasi);
            icon_diPerhatikan = (ImageView) itemView.findViewById(R.id.iv_iconDiPerhatikan);

            card_reply = (LinearLayout) itemView.findViewById(R.id.card_reply);

            isiReply = (TextView) itemView.findViewById(R.id.tv_isiReply);
            tglReply = (TextView) itemView.findViewById(R.id.tv_tglReply);

            apiAdapter = new ApiAdapter();


            btn_reply.setOnClickListener(this);


        }

        @Override
        public void onClick(View v) {

            switch (v.getId()){
//                case R.id.btn_reply:
//                    authorized();
//                    break;
//                case R.id.btn_readMore:
//                    isiPostHome.setMaxLines(10);
//                    btn_readMore.setVisibility(View.GONE);
//                    btn_readLess.setVisibility(View.VISIBLE);
//                    break;
//                case R.id.btn_readLess:
//                    isiPostHome.setMaxLines(3);
//                    btn_readMore.setVisibility(View.VISIBLE);
//                    btn_readLess.setVisibility(View.GONE);
//                    break;

//                case R.id.btn_diApresiasi:
//                    //tambah jmlDiapresiasi dan berubah warna
//                    if(diApresiasi == false){
//                        diApresiasi = true;
//
//                    }
//                    break;
//                case R.id.btn_diPerhatikan:
//
//                    break;
            }
        }
        public void authorized(){

        }
    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }

    @Override
    public CardPostHomeAdapter.CardPostHomeViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.card_post_home,viewGroup, false);
        CardPostHomeViewHolder cphvh = new CardPostHomeViewHolder(v);
        return cphvh;
    }

    @Override
    public void onBindViewHolder(final CardPostHomeAdapter.CardPostHomeViewHolder cardPostHomeViewHolder, final int i) {
        final boolean[] diApresiasi = {false};
        final boolean[] diPerhatikan = {false};

        final int jml_diApresiasi = cardPostHomes.get(i).getComment().getFeedbackApresiasiCount();
        final int jml_diPerhatikan = cardPostHomes.get(i).getComment().getFeedbackPerhatikanCount();

        final String couple_id = cardPostHomes.get(i).getComment().getCplId();

        cardPostHomeViewHolder.card_postHome.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(context, KandidatActivity.class);
                intent.putExtra("couple_id", couple_id);
                context.startActivity(intent);
            }
        });

        cardPostHomeViewHolder.judulPostHome.setText(cardPostHomes.get(i).getComment().getTitle());
        cardPostHomeViewHolder.namaProvinsi.setText(cardPostHomes.get(i).getComment().getCoupleName().getCouple().getProvinceName());
//        cardPostHomeViewHolder.fotoPostHome.setImageResource(cardPostHomes.get(i).fotoPostHome);
        cardPostHomeViewHolder.tvCalon.setText(cardPostHomes.get(i).getComment().getCoupleName().getCouple().getCalonName());
        cardPostHomeViewHolder.tvWakil.setText(cardPostHomes.get(i).getComment().getCoupleName().getCouple().getWakilName());
//        cardPostHomeViewHolder.isiPostHome.setText(cardPostHomes.get(i).getComment().getText());
        cardPostHomeViewHolder.isiPost.setText(cardPostHomes.get(i).getComment().getText());
//        if (cardPostHomes.get(i).getComment().getText().length() > 200){
//
//            cardPostHomeViewHolder.isiPostHome.setMaxLines(3);
//            cardPostHomeViewHolder.btn_readMore.setVisibility(View.VISIBLE);
//
//        }
        cardPostHomeViewHolder.tvPoster.setText(cardPostHomes.get(i).getComment().getPersonName());
        cardPostHomeViewHolder.tglPostHome.setText(cardPostHomes.get(i).getComment().getCreatedAt().substring(0, 10));
        cardPostHomeViewHolder.jmlApresiasi.setText(String.valueOf(cardPostHomes.get(i).getComment().getFeedbackApresiasiCount()));
        cardPostHomeViewHolder.jmlPerhatian.setText(String.valueOf(cardPostHomes.get(i).getComment().getFeedbackPerhatikanCount()));
        if(cardPostHomes.get(i).getComment().getFeedbackApresiasiCount() != 0) {
            cardPostHomeViewHolder.jmlApresiasi.setVisibility(View.VISIBLE);
        }
        if(cardPostHomes.get(i).getComment().getFeedbackPerhatikanCount() != 0) {
            cardPostHomeViewHolder.jmlPerhatian.setVisibility(View.VISIBLE);
        }
        if (cardPostHomes.get(i).getComment().getReplyFromPremium() == null) {
            cardPostHomeViewHolder.btn_reply.setVisibility(View.VISIBLE);
            cardPostHomeViewHolder.card_reply.setVisibility(View.GONE);
        }
        else {
            cardPostHomeViewHolder.tglReply.setText(cardPostHomes.get(i).getComment().getReplyFromPremium().getReply().getCreatedAt().substring(0, 10));
            cardPostHomeViewHolder.isiReply.setText(cardPostHomes.get(i).getComment().getReplyFromPremium().getReply().getText());
            cardPostHomeViewHolder.card_reply.setVisibility(View.VISIBLE);
            cardPostHomeViewHolder.btn_reply.setVisibility(View.GONE);
        }
        if (cardPostHomes.get(i).getComment().getFeedback() == 99){
            cardPostHomeViewHolder.btn_diPerhatikan.setVisibility(View.VISIBLE);
            cardPostHomeViewHolder.btn_diApresiasi.setVisibility(View.VISIBLE);
            cardPostHomeViewHolder.btn_reply.setVisibility(View.GONE);
        } else
        if (cardPostHomes.get(i).getComment().getFeedback() == 1){
            cardPostHomeViewHolder.btn_diApresiasi.setVisibility(View.VISIBLE);
            cardPostHomeViewHolder.btn_reply.setVisibility(View.VISIBLE);
            cardPostHomeViewHolder.btn_diPerhatikan.setVisibility(View.GONE);
        } else
        if (cardPostHomes.get(i).getComment().getFeedback() == 0){
            cardPostHomeViewHolder.btn_diPerhatikan.setVisibility(View.VISIBLE);
            cardPostHomeViewHolder.btn_reply.setVisibility(View.VISIBLE);
            cardPostHomeViewHolder.btn_diApresiasi.setVisibility(View.GONE);
        }
        if (cardPostHomes.get(i).getComment().isAlreadyParticipate1()){
            cardPostHomeViewHolder.icon_diApresiasi.setImageResource(R.drawable.heart_merah_tua);
        }
        if (cardPostHomes.get(i).getComment().isAlreadyParticipate0()){
            cardPostHomeViewHolder.icon_diPerhatikan.setImageResource(R.drawable.tanda_seru_merah_tua);
        }
        cardPostHomeViewHolder.btn_diApresiasi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                commentid = cardPostHomes.get(i).getComment().getId();
                if(!cardPostHomes.get(i).getComment().isAlreadyParticipate0or1()){
                    if (!cardPostHomes.get(i).getComment().isAlreadyParticipate1()){
                        apiAdapter.getRestApi().sendApresiasi("", token, commentid, new Callback<Status>() {
                            @Override
                            public void success(Status s, Response response) {
                                Toast.makeText(context, "Anda mengapresiasi comment ini", Toast.LENGTH_SHORT).show();
                                cardPostHomeViewHolder.icon_diApresiasi.setImageResource(R.drawable.heart_merah_tua);
//                                cardPostHomeViewHolder.jmlApresiasi.setText(String.valueOf(cardPostHomes.get(i).getComment().getFeedbackApresiasiCount()));
//                                Toast.makeText(context, cardPostHomes.get(i).getComment().getFeedbackApresiasiCount().toString(), Toast.LENGTH_SHORT).show();
                                cardPostHomeViewHolder.jmlApresiasi.setVisibility(View.VISIBLE);
                            }

                            @Override
                            public void failure(RetrofitError error) {
                                Toast.makeText(context, "Please wait ----", Toast.LENGTH_SHORT).show();
                            }
                        });
                        cardPostHomeViewHolder.jmlApresiasi.setText(String.valueOf((cardPostHomes.get(i).getComment().getFeedbackApresiasiCount())));
                    }
                    else  {
//                        Toast.makeText(context, "Anda telah mengapresiasi comment ini", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
        cardPostHomeViewHolder.btn_diPerhatikan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                commentid = cardPostHomes.get(i).getComment().getId();
                if(!cardPostHomes.get(i).getComment().isAlreadyParticipate0or1()){
                    if (!cardPostHomes.get(i).getComment().isAlreadyParticipate0()){
                        apiAdapter.getRestApi().sendPerhatikan("", token, commentid, new Callback<Status>() {
                            @Override
                            public void success(Status s, Response response) {
                                Toast.makeText(context, "Anda memperhatikan comment ini", Toast.LENGTH_SHORT).show();
                                cardPostHomeViewHolder.icon_diPerhatikan.setImageResource(R.drawable.tanda_seru_merah_tua);
                                cardPostHomeViewHolder.jmlPerhatian.setText(String.valueOf(cardPostHomes.get(i).getComment().getFeedbackPerhatikanCount()));
                                cardPostHomeViewHolder.jmlPerhatian.setVisibility(View.VISIBLE);
                            }

                            @Override
                            public void failure(RetrofitError error) {
                                Toast.makeText(context, "Please wait ----", Toast.LENGTH_SHORT).show();
                            }
                        });
                        cardPostHomeViewHolder.jmlPerhatian.setText(String.valueOf((cardPostHomes.get(i).getComment().getFeedbackPerhatikanCount())));
                    }
                    else  {
                        Toast.makeText(context, "Anda telah memperhatikan comment ini", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
        cardPostHomeViewHolder.btn_reply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (cardPostHomes.get(i).getComment().getReplyFromPremium() != null){
                    Toast.makeText(context, "Tidak bisa berkomentar lebih dari sekali", Toast.LENGTH_SHORT).show();
                }else {
                    apiAdapter.getRestApi().getPremiumReply(token, couple_id, new Callback<CheckReplyPremium>() {
                        @Override
                        public void success(CheckReplyPremium checkReplyPremium, Response response) {
                            Intent intent = new Intent(context, ReplyHomeActivity.class);
                            intent.putExtra("judul", cardPostHomes.get(i).getComment().getTitle());
                            intent.putExtra("text", cardPostHomes.get(i).getComment().getText());
                            intent.putExtra("commentId", cardPostHomes.get(i).getComment().getId());
                            intent.putExtra("namaProvinsi", cardPostHomes.get(i).getComment().getCoupleName().getCouple().getProvinceName());
                            intent.putExtra("jmlApresiasi", cardPostHomes.get(i).getComment().getFeedbackApresiasiCount());
                            intent.putExtra("jmlPerhatikan", cardPostHomes.get(i).getComment().getFeedbackPerhatikanCount());
                            intent.putExtra("namaCalon", cardPostHomes.get(i).getComment().getCoupleName().getCouple().getCalonName());
                            intent.putExtra("namaWakil", cardPostHomes.get(i).getComment().getCoupleName().getCouple().getWakilName());
                            intent.putExtra("feedback", cardPostHomes.get(i).getComment().getFeedback());
                            intent.putExtra("tglComment", cardPostHomes.get(i).getComment().getCreatedAt());
                            intent.putExtra("personName", cardPostHomes.get(i).getComment().getPersonName());
                            context.startActivity(intent);

                        }

                        @Override
                        public void failure(RetrofitError error) {
                            Toast.makeText(context, "Fitur ini hanya untuk pengguna premium " + cardPostHomes.get(i).getComment().getCoupleName().getCouple().getCalonName(), Toast.LENGTH_SHORT).show();
                        }
                    });
                }
            }
        });

    }



    @Override
    public int getItemCount() {
        return cardPostHomes == null ? 0 : cardPostHomes.size();
    }
}
