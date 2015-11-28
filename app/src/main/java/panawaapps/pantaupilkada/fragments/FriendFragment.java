package panawaapps.pantaupilkada.fragments;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.renderscript.ScriptIntrinsicLUT;
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
import panawaapps.pantaupilkada.adapter.CardFriendAdapter;
import panawaapps.pantaupilkada.model.CardFriend;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link FriendFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link FriendFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FriendFragment extends Fragment {

    private List<CardFriend> mCardFriendList = new ArrayList<>();
    private RecyclerView mRecyclerView;
    private CardFriendAdapter mCardFriendAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View fragmentView = inflater.inflate(R.layout.fragment_friend, container, false);

        mRecyclerView = (RecyclerView) fragmentView.findViewById(R.id.rv_friend);

        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        for (int i=0; i<5; i++){
            CardFriend cardFriend = new CardFriend.CardFriendBuilder()
                    .setFotoFriend(R.drawable.user_dark_grey)
                    .setNamaFriend("Friend" + String.valueOf(i))
                    .setJmlPengawas(666)
                    .build();

            mCardFriendList.add(cardFriend);
        }

        mCardFriendAdapter = new CardFriendAdapter(mCardFriendList);
        mRecyclerView.setAdapter(mCardFriendAdapter);
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());
        // Inflate the layout for this fragment
        return fragmentView;
    }


}
