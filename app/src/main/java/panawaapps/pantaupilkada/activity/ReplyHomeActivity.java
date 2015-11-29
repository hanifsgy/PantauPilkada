package panawaapps.pantaupilkada.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import panawaapps.pantaupilkada.R;
import panawaapps.pantaupilkada.adapter.CardReplyAdapter;
import panawaapps.pantaupilkada.adapter.CustomLinearLayoutManager;
import panawaapps.pantaupilkada.adapter.WrappingLayoutManager;
import panawaapps.pantaupilkada.model.CardReply;

public class ReplyHomeActivity extends AppCompatActivity {

   public List<CardReply> cardReplies;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reply_home);

    }
}
