package panawaapps.pantaupilkada.controller;

import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.List;

import panawaapps.pantaupilkada.api.RestApiManager;
import panawaapps.pantaupilkada.model.CardPostHome;
import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;

/**
 * Created by Sikikan on 11/28/2015.
 */
public class ControllerApiGetComments {
    private static final String TAG = ControllerApiGetComments.class.getSimpleName();
    private CommentCallbackListener mListener;
    private RestApiManager mApiManager;

    public ControllerApiGetComments(CommentCallbackListener listener){
        mListener = listener;
        mApiManager = new RestApiManager();
    }

    public void startFetching(){
        mApiManager.getCommentApi().getComments(new Callback<String>() {
            @Override
            public void success(String s, Response response) {
                Log.d(TAG, "JSON :: "+s);
                try {
                    JSONObject object = new JSONObject(s);
                    JSONArray arrayData = new JSONArray(object.getString("data"));
                    for(int i =0; i< arrayData.length(); i++){
                        JSONObject objectComment = arrayData.getJSONObject(i);
                        JSONObject objectSubstansiComment = objectComment.getJSONObject("comment");
                        CardPostHome cardPostHome = new CardPostHome.CardPostHomeBuilder()
                                .setTglPostHome(objectSubstansiComment.getString("created_at").substring(0,9))
                                .setJudulPostHome(objectSubstansiComment.getString("title"))
                                .setIsiPostHome(objectSubstansiComment.getString("text"))
                                .build();

                        mListener.onFetchProgress(cardPostHome);
                    }

                } catch (JSONException e) {
                    mListener.onFetchFailed();
                }
            }

            @Override
            public void failure(RetrofitError error) {
                Log.d(TAG, "Error :: " + error.getMessage());
                mListener.onFetchComplete();
            }
        });
    }

    public interface CommentCallbackListener {
        void onFetchStart();
        void onFetchProgress(CardPostHome card);
        void onFetchProgress(List<CardPostHome> cardPostHomeList);
        void onFetchComplete();
        void onFetchFailed();
    }
}
