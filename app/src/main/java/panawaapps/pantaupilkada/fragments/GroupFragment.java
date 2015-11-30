package panawaapps.pantaupilkada.fragments;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import panawaapps.pantaupilkada.R;
import panawaapps.pantaupilkada.adapter.CardGroupAdapter;
import panawaapps.pantaupilkada.model.CardGroup;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link GroupFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link GroupFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class GroupFragment extends Fragment {
    private List<CardGroup> mCardGroupList = new ArrayList<>();
    private RecyclerView mRecyclerView;
    private CardGroupAdapter mCardGroupAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View fragmentView = inflater.inflate(R.layout.fragment_group, container, false);

        mRecyclerView = (RecyclerView) fragmentView.findViewById(R.id.rv_group);

        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

//        for (int i = 0 ; i<5; i++){
//            CardGroup cardGroup = new CardGroup.CardGroupBuilder()
//                    .setDeskripsiGroup("Posisi CardGroup ini masih salah, seharusnya tidak ada di Recyclerview")
//                    .setNamaGroup("Group Salah" + String.valueOf(i))
//                    .setFotoGroup(R.drawable.user_dark_grey)
//                    .setJmlPengamat(123)
//                    .setJmlPengawas(666)
//                    .build();
//            mCardGroupList.add(cardGroup);
//        }
        mCardGroupAdapter = new CardGroupAdapter(mCardGroupList);
        mRecyclerView.setAdapter(mCardGroupAdapter);
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());

        return fragmentView;
    }
}
