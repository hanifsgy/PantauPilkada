package panawaapps.pantaupilkada.adapter;

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

import com.ms.square.android.expandabletextview.ExpandableTextView;

import java.util.List;

import panawaapps.pantaupilkada.R;
import panawaapps.pantaupilkada.activity.ReplyHomeActivity;
import panawaapps.pantaupilkada.model.Home.Datum;

/**
 * Created by Sikikan on 11/22/2015.
 */
public class CardPostHomeAdapter extends RecyclerView.Adapter<CardPostHomeAdapter.CardPostHomeViewHolder> {

    Context context;
    List<Datum> cardPostHomes;


    public CardPostHomeAdapter(Context context, List<Datum> cardPostHomes) {
        this.context = context;
        this.cardPostHomes = cardPostHomes;
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

        TextView btn_readMore;
        TextView btn_readLess;

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
            isiPostHome = (TextView) itemView.findViewById(R.id.tv_isiPostHome);

            btn_readMore = (TextView) itemView.findViewById(R.id.btn_readMore);
            btn_readMore.setOnClickListener(this);

            btn_readLess = (TextView) itemView.findViewById(R.id.btn_readLess);
            btn_readLess.setOnClickListener(this);


            tglPostHome = (TextView) itemView.findViewById(R.id.tv_tglPostHome);
            tvPoster = (TextView) itemView.findViewById(R.id.tv_userPoster);
            tvCalon = (TextView) itemView.findViewById(R.id.tv_namaCalon);
            tvWakil = (TextView) itemView.findViewById(R.id.tv_namaWakil);
            jmlApresiasi = (TextView) itemView.findViewById(R.id.tv_jmlApresiasi);
            jmlPerhatian = (TextView) itemView.findViewById(R.id.tv_jmlPerhatian);
            btn_reply = (ImageView) itemView.findViewById(R.id.btn_reply);
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


        }

        @Override
        public void onClick(View v) {

            switch (v.getId()){
                case R.id.btn_reply:
                    Intent toReplyHomeActivity = new Intent(context, ReplyHomeActivity.class);
                    context.startActivity(toReplyHomeActivity);
                    break;
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

        cardPostHomeViewHolder.judulPostHome.setText(cardPostHomes.get(i).getComment().getTitle());
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
        cardPostHomeViewHolder.tglPostHome.setText(cardPostHomes.get(i).getComment().getCreatedAt().substring(0, 9));
        cardPostHomeViewHolder.jmlApresiasi.setText(String.valueOf(cardPostHomes.get(i).getComment().getFeedbackApresiasiCount()));
        cardPostHomeViewHolder.jmlPerhatian.setText(String.valueOf(cardPostHomes.get(i).getComment().getFeedbackPerhatikanCount()));
//        if(cardPostHomes.get(i).getComment().getFeedbackApresiasiCount() > 0) {
//            cardPostHomeViewHolder.jmlApresiasi.setVisibility(View.VISIBLE);
//        }
//        if(cardPostHomes.get(i).getComment().getFeedbackPerhatikanCount() != 0) {
//            cardPostHomeViewHolder.jmlPerhatian.setVisibility(View.VISIBLE);
//        }

//        cardPostHomeViewHolder.tglReply.setText(cardPostHomes.get(i).tglReply);
//        if (cardPostHomes.get(i).getComment().getReplyFromPremium() != null) {
//            cardPostHomeViewHolder.card_reply.setVisibility(View.VISIBLE);
//            cardPostHomeViewHolder.tglReply.setText(cardPostHomes.get(i).getComment().getReplyFromPremium().getReply().getCreatedAt().substring(0, 9));
//            cardPostHomeViewHolder.isiReply.setText(cardPostHomes.get(i).getComment().getReplyFromPremium().getReply().getText());
//        }
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
        cardPostHomeViewHolder.btn_diApresiasi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (diApresiasi[0] == false){
                    diApresiasi[0] = true;
                    cardPostHomeViewHolder.icon_diApresiasi.setImageResource(R.drawable.heart_merah_tua);
                    cardPostHomeViewHolder.jmlApresiasi.setText(String.valueOf((cardPostHomes.get(i).getComment().getFeedbackApresiasiCount())+1));
                } else
                if (diApresiasi[0] == true){
                    diApresiasi[0] = false;
                    cardPostHomeViewHolder.icon_diApresiasi.setImageResource(R.drawable.heart_merah_utama);
                    cardPostHomeViewHolder.jmlApresiasi.setText(String.valueOf(cardPostHomes.get(i).getComment().getFeedbackApresiasiCount()));
                }
            }
        });
        cardPostHomeViewHolder.btn_diPerhatikan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (diPerhatikan[0] == false) {
                    diPerhatikan[0] = true;
                    cardPostHomeViewHolder.icon_diPerhatikan.setImageResource(R.drawable.tanda_seru_merah_tua);
                    cardPostHomeViewHolder.jmlPerhatian.setText(String.valueOf((cardPostHomes.get(i).getComment().getFeedbackPerhatikanCount()) + 1));
                } else if (diPerhatikan[0] == true) {
                    diPerhatikan[0] = false;
                    cardPostHomeViewHolder.icon_diPerhatikan.setImageResource(R.drawable.tanda_seru_merah_utama);
                    cardPostHomeViewHolder.jmlPerhatian.setText(String.valueOf(cardPostHomes.get(i).getComment().getFeedbackPerhatikanCount()));
                }
            }
        });
        cardPostHomeViewHolder.btn_reply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent toReplyHomeActivity = new Intent(context, ReplyHomeActivity.class);
                context.startActivity(toReplyHomeActivity);
            }
        });
        cardPostHomeViewHolder.btn_readMore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                cardPostHomeViewHolder.isiPostHome.setMaxLines(10);
                cardPostHomeViewHolder.btn_readMore.setVisibility(View.GONE);
                cardPostHomeViewHolder.btn_readLess.setVisibility(View.VISIBLE);
            }
        });
        cardPostHomeViewHolder.btn_readLess.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cardPostHomeViewHolder.isiPostHome.setMaxLines(3);
                cardPostHomeViewHolder.btn_readMore.setVisibility(View.VISIBLE);
                cardPostHomeViewHolder.btn_readLess.setVisibility(View.GONE);
            }
        });
    }

    @Override
    public int getItemCount() {
        return cardPostHomes == null ? 0 : cardPostHomes.size();
    }
}
