package panawaapps.pantaupilkada.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import panawaapps.pantaupilkada.R;
import panawaapps.pantaupilkada.adapter.CardReplyAdapter;
import panawaapps.pantaupilkada.model.CardReply;

public class ReplyHomeActivity extends AppCompatActivity {

    public RecyclerView rv_replyHome;
    public List<CardReply> cardReplies;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reply_home);

        rv_replyHome = (RecyclerView) findViewById(R.id.rv_replyHome);

        LinearLayoutManager llm = new LinearLayoutManager(this);
        rv_replyHome.setLayoutManager(llm);
        rv_replyHome.setHasFixedSize(true);

        initializeData();

        CardReplyAdapter adapterCardReply = new CardReplyAdapter(this, cardReplies);
        rv_replyHome.setAdapter(adapterCardReply);
    }

    private void initializeData(){
        cardReplies = new ArrayList<>();
        for(int i=0; i<15; i++){
            cardReplies.add(new CardReply(
                    "Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.",
                    "12-12-15"
            ));
            cardReplies.add(new CardReply(
                    "Consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.",
                    "14-11-15"
            ));
        }

    }
}
