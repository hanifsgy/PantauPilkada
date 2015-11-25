package panawaapps.pantaupilkada.api;

import retrofit.RestAdapter;

/**
 * Created by ali on 16/11/15.
 */
public class ApiAdapter {
    private static final String URL = "http://api.pantaubersama.com/api";
    private RestAdapter restAdapter;
    private RestApi restApi;

    public ApiAdapter(){
        restAdapter = new RestAdapter.Builder().setEndpoint(URL).setLogLevel(RestAdapter.LogLevel.FULL).build();
        restApi = restAdapter.create(RestApi.class);
    }

    public RestApi getRestApi() {
        return restApi;
    }
}
