package panawaapps.pantaupilkada.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.List;

import panawaapps.pantaupilkada.R;
import panawaapps.pantaupilkada.model.CardReply;

/**
 * Created by Sikikan on 11/22/2015.
 */
public class CardReplyAdapter extends RecyclerView.Adapter<CardReplyAdapter.CardReplyViewHolder> {

    Context context;

    List<CardReply> cardReplies;

    public CardReplyAdapter(Context context, List<CardReply> cardReplies){
        this.context = context;
        this.cardReplies = cardReplies;
    }

    public class CardReplyViewHolder extends RecyclerView.ViewHolder{

        LinearLayout card_reply;
        TextView isiReply;
        TextView tglReply;

        public CardReplyViewHolder(View itemView) {
            super(itemView);
            card_reply = (LinearLayout) itemView.findViewById(R.id.card_reply);
            isiReply = (TextView) itemView.findViewById(R.id.tv_isiReply);
            tglReply = (TextView) itemView.findViewById(R.id.tv_tglReply);
        }
    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }

    @Override
    public CardReplyViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.card_reply, viewGroup, false);
        CardReplyViewHolder crvh = new CardReplyViewHolder(v);
        return crvh;
    }

    @Override
    public void onBindViewHolder(CardReplyViewHolder cardReplyViewHolder, int i) {
        cardReplyViewHolder.isiReply.setText(cardReplies.get(i).isiReply);
        cardReplyViewHolder.tglReply.setText(cardReplies.get(i).tglReply);
    }

    @Override
    public int getItemCount() {
        return cardReplies == null ? 0 : cardReplies.size();
    }
}
