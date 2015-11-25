package panawaapps.pantaupilkada.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import panawaapps.pantaupilkada.R;
import panawaapps.pantaupilkada.activity.ReplyHomeActivity;
import panawaapps.pantaupilkada.model.CardPostHome;

/**
 * Created by Sikikan on 11/22/2015.
 */
public class CardPostHomeAdapter extends RecyclerView.Adapter<CardPostHomeAdapter.CardPostHomeViewHolder> {

    Context context;
    List<CardPostHome> cardPostHomes;

    public CardPostHomeAdapter(Context context, List<CardPostHome> cardPostHomes) {
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

        ImageView btn_reply;

        FrameLayout btn_diApresiasi;
        FrameLayout btn_diPerhatikan;


        public CardPostHomeViewHolder(View itemView) {
            super(itemView);
            card_postHome = (FrameLayout) itemView.findViewById(R.id.card_postHome);
            judulPostHome = (TextView) itemView.findViewById(R.id.tv_judulPostHome);
//            fotoPostHome = (ImageView) itemView.findViewById(R.id.iv_fotoPostHome);
            isiPostHome = (TextView) itemView.findViewById(R.id.tv_isiPostHome);
            tglPostHome = (TextView) itemView.findViewById(R.id.tv_tglPostHome);
            jmlApresiasi = (TextView) itemView.findViewById(R.id.tv_jmlApresiasi);
            jmlPerhatian = (TextView) itemView.findViewById(R.id.tv_jmlPerhatian);
            btn_reply = (ImageView) itemView.findViewById(R.id.btn_reply);
            btn_reply.setOnClickListener(this);
            btn_diApresiasi = (FrameLayout) itemView.findViewById(R.id.btn_diApresiasi);
            btn_diApresiasi.setOnClickListener(this);
            btn_diPerhatikan = (FrameLayout) itemView.findViewById(R.id.btn_diPerhatikan);
            btn_diPerhatikan.setOnClickListener(this);

        }

        @Override
        public void onClick(View v) {
            switch (v.getId()){
                case R.id.btn_reply:
                    Intent toReplyHomeActivity = new Intent(context, ReplyHomeActivity.class);
                    context.startActivity(toReplyHomeActivity);
                    break;
                case R.id.btn_diApresiasi:
                    //tambah jmlDiapresiasi dan berubah warna
                    break;
                case R.id.btn_diPerhatikan:

                    break;
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
    public void onBindViewHolder(CardPostHomeAdapter.CardPostHomeViewHolder cardPostHomeViewHolder, int i) {
        cardPostHomeViewHolder.judulPostHome.setText(cardPostHomes.get(i).judulPostHome);
//        cardPostHomeViewHolder.fotoPostHome.setImageResource(cardPostHomes.get(i).fotoPostHome);
        cardPostHomeViewHolder.isiPostHome.setText(cardPostHomes.get(i).isiPostHome);
        cardPostHomeViewHolder.tglPostHome.setText(cardPostHomes.get(i).tglPostHome);
    }

    @Override
    public int getItemCount() {
        return cardPostHomes == null ? 0 : cardPostHomes.size();
    }
}
