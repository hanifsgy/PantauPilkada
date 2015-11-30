package panawaapps.pantaupilkada.api;

import panawaapps.pantaupilkada.utility.Constants;
import com.google.gson.GsonBuilder;

import retrofit.RestAdapter;
import retrofit.converter.GsonConverter;

/**
 * Created by Sikikan on 11/23/2015.
 */
public class RestApiManager {

    private RestApi mRestApi;

    //
    private RestApi mContestApi;

    public RestApi getCommentApi(){
        if(mRestApi == null){
            GsonBuilder gson = new GsonBuilder();
            gson.registerTypeAdapter(String.class, new StringDesirializer());

            mRestApi = new RestAdapter.Builder()
                    .setEndpoint(Constants.BASE_URL)
                    .setConverter(new GsonConverter(gson.create()))
                    .build()
                    .create(RestApi.class);
        }
        return mRestApi;
    }

    //
    public RestApi getContestApi() {
        if(mContestApi == null){
            GsonBuilder gson = new GsonBuilder();
            gson.registerTypeAdapter(String.class, new StringDesirializer());

            mContestApi = new RestAdapter.Builder()
                    .setEndpoint(Constants.BASE_URL)
                    .setConverter(new GsonConverter(gson.create()))
                    .build()
                    .create(RestApi.class);
        }
        return mContestApi;
    }
}
