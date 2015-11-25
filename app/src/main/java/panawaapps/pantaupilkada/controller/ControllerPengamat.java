package panawaapps.pantaupilkada.controller;

import android.util.Log;

import panawaapps.pantaupilkada.api.RestApiManager;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.List;

import panawaapps.pantaupilkada.model.Card;
import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;

/**
 * Created by Sikikan on 11/23/2015.
 */
public class ControllerPengamat {

    private static final String TAG = ControllerPengamat.class.getSimpleName();
    private ContestCallbackListener mListener;
    private RestApiManager mApiManager;

    public ControllerPengamat(ContestCallbackListener listener) {
        mListener = listener;
        mApiManager = new RestApiManager();
    }

    public void startFetching() {
        mApiManager.getContestApi().getContests(new Callback<String>() {
            @Override
            public void success(String s, Response response) {
                Log.d(TAG, "JSON :: " + s);
                try {
                    JSONObject j = new JSONObject(s);
                    JSONArray a = j.getJSONArray("data");

                    Log.d(TAG, "JSON object :: " + a.getJSONArray(0));
//                    Card card = new Card.Builder()
//                                .setRegionId(object.getInt("region_id"))
//                                .setCalonId(object.getInt("calon_id"))
//                                .setWakilId(object.getInt("wakil_id"))
//                                .setRegioName(object.getString("region_name"))
//                                .setCalonName(object.getString("calon_name"))
//                                .setWakilName(object.getString("wakil_name"))
//                                .setCoupleId(object.getString("couple_id"))
//                                .setKind(object.getString("kind"))
//                                .build();

//                        mListener.onFetchProgress(card);
                }catch (JSONException ex){
                    Log.d(TAG, "exception ...."+ex);
                }

                Card card = new Card.Builder()
                                .setRegionId(99)
                                .setCalonId(88)
                                .setWakilId(11)
                                .setRegioName("region 1")
                                .setCalonName("calon 1")
                                .setWakilName("wakil 1")
                                .setCoupleId("abc-33")
                                .setKind("kabupaten")
                                .build();

                mListener.onFetchProgress(card);

                Card card2 = new Card.Builder()
                        .setRegionId(99)
                        .setCalonId(88)
                        .setWakilId(11)
                        .setRegioName("region 1")
                        .setCalonName("calon 2")
                        .setWakilName("wakil 2")
                        .setCoupleId("abc-44")
                        .setKind("kabupaten")
                        .build();

                mListener.onFetchProgress(card2);

//                try {
//                    JSONArray array = new JSONArray(s);
//
//
//                    for (int i = 0; i < array.length(); i++) {
//                        JSONObject object = array.getJSONObject(i);
//
//                        Card card = new Card.Builder()
//                                .setRegionId(object.getInt("region_id"))
//                                .setCalonId(object.getInt("calon_id"))
//                                .setWakilId(object.getInt("wakil_id"))
//                                .setRegioName(object.getString("region_name"))
//                                .setCalonName(object.getString("calon_name"))
//                                .setWakilName(object.getString("wakil_name"))
//                                .setCoupleId(object.getString("couple_id"))
//                                .setKind(object.getString("kind"))
//                                .build();
//
//                        mListener.onFetchProgress(card);
//
//
//                    }
//
//
//                } catch (JSONException e) {
//                    mListener.onFetchFailed();
//                }

                mListener.onFetchComplete();
        }

            @Override
            public void failure(RetrofitError error) {
                Log.d(TAG, "ERROR :: " + error.getMessage());

            }
        });

    }

    public interface ContestCallbackListener{
        void onFetchStart();
        void onFetchProgress(Card card);
        void onFetchProgress(List<Card> cardList);
        void onFetchComplete();

        void onFetchFailed();
    }
}
