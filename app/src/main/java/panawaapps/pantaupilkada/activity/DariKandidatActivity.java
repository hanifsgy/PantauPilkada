package panawaapps.pantaupilkada.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import panawaapps.pantaupilkada.R;
import panawaapps.pantaupilkada.adapter.CardDariKandidatAdapter;
import panawaapps.pantaupilkada.model.CardDariKandidat;

public class DariKandidatActivity extends AppCompatActivity {

    private List<CardDariKandidat> mCardDariKandidatList = new ArrayList<>();
    private RecyclerView mRecyclerView;
    private CardDariKandidatAdapter mCardDariKandidatAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dari_kandidat);

        mRecyclerView = (RecyclerView) findViewById(R.id.rv_dariKandidat);

        LinearLayoutManager layoutCardDariKandidat = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(layoutCardDariKandidat);
        mRecyclerView.setHasFixedSize(true);

        for (int i=0; i<6; i++) {
            CardDariKandidat cardDariKandidat = new CardDariKandidat.CardDariKandidatBuilder()
                    .setJudulPost("Jargon" + String.valueOf(i))
                    .setIsiPost("Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.")
                    .setNamaUser("Nama User")
                    .build();

            mCardDariKandidatList.add(cardDariKandidat);
        }

        CardDariKandidat cardDariKandidat = new CardDariKandidat.CardDariKandidatBuilder()
                .setJudulPost("Jargon")
                .setIsiPost("Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.")
                .setNamaUser("Nama User")
                .build();

        mCardDariKandidatList.add(cardDariKandidat);

        mCardDariKandidatAdapter = new CardDariKandidatAdapter(mCardDariKandidatList);
        mRecyclerView.setAdapter(mCardDariKandidatAdapter);
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());
    }
}
