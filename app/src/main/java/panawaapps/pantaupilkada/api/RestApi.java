package panawaapps.pantaupilkada.api;

import java.io.File;

import panawaapps.pantaupilkada.model.CardPostHome;
import panawaapps.pantaupilkada.model.District;
import panawaapps.pantaupilkada.model.Kandidat.KandidatPojo;
import panawaapps.pantaupilkada.model.Pengamat;
import panawaapps.pantaupilkada.model.Province;
import panawaapps.pantaupilkada.model.Region;
import panawaapps.pantaupilkada.model.Status;
import panawaapps.pantaupilkada.model.SubDistricts;
import panawaapps.pantaupilkada.model.TPS.TPS;
import panawaapps.pantaupilkada.model.UserData.UserData;
import panawaapps.pantaupilkada.model.UserProfile.UserProfile;
import retrofit.Callback;
import retrofit.http.Body;
import retrofit.http.DELETE;
import retrofit.http.Field;
import retrofit.http.FormUrlEncoded;
import retrofit.http.GET;
import retrofit.http.Header;
import retrofit.http.Headers;
import retrofit.http.POST;
import retrofit.http.Path;
import retrofit.http.Query;

/**
 * Created by Sikikan on 11/23/2015.
 */
public interface RestApi {

    //location
    @GET("/locations/provinces")
    void getProvinces(Callback<Province> provinceCallback);

    @GET("/locations/{province_id}/regions.json?sort=asc")
    void getRegion(@Path("province_id") String provinceId, Callback<Region> regionCallback);

//    @GET("/locations/{region_id}/districts?sort=asc")
//    void getDistrict(@Path("region_id") String regionId, Callback<District> districtCallback);
//
//    @GET("/locations/{districts_id}/subdistricts?sort=asc")
//    void getSubDistrict(@Path("districts_id") String district_id, Callback<SubDistricts> subDistrictsCallback);

    //tps
    @GET("/cards/tps_cards")
    void getTPS(@Query("subdistrict_id") String subdistrict_id, @Query("kind") String kind, Callback<TPS> tpslCallback);

    @Headers("Token: B2_rPTygD5p5HRxY4P9L")
    @GET("/cards/fulllist_bookmarks")
    void getPengamat(Callback<Pengamat> callback);

    //Untuk mendapatkan Contest Card
    @GET("/cards/contest_cards")
    void getCards(@Query("province_id") String province_id, Callback<Pengamat> tpslCallback);

    @Headers("Token: B2_rPTygD5p5HRxY4P9L")
    @POST("/card_actions/observe/{region_id}")
    void pinPengamat(@Body String task, @Path("region_id") String provinceId, Callback<Status> status);

    @Headers("Token: B2_rPTygD5p5HRxY4P9L")
    @DELETE("/card_actions/observe/{region_id}/remove.json")
    void unpinPengamat(@Path("region_id") String provinceId, Callback<Status> status);

    //kecamatan
    @GET("/locations/{region_id}/districts?sort=asc")
    void getDistrict(@Path("region_id") String regionId, Callback<District> districtCallback);

    //kelurahan
    @GET("/locations/{districts_id}/subdistricts?sort=asc")
    void getSubDistrict(@Path("districts_id") String district_id, Callback<SubDistricts> subDistrictsCallback);

    //harus dihapus
    @GET("/cards/contest_cards.json?province_id=16")
    void getContests(Callback<String> contests);

    //comment
    @GET("/comments")
    void getComment(Callback<CardPostHome> cardPostHomeCallback);

    //kandidat
    @GET("/participants/{couple_id}/detail")
    void getKandidat(@Path("couple_id") String couple_id, Callback<KandidatPojo> kandidatCallback);

    //register
    @FormUrlEncoded
    @POST("/people/create")
    void sendUserData(@Field("email") String userEmail,
                      @Field("password") String userPassword,
                      @Field("password_confirmation") String userPasswordConf,
                      @Field("name") String userName,
                      @Field("dob") String userDOB,
                      @Field("address") String userAddr,
                      @Field("avatar") File avatar,
                      Callback<UserData> userDataCallback
    );

    //single kandidat comment
    @GET("/comments/{couple_id}/list")
    void dariKandidat(@Path("couple_id") String couple_id, @Query("from") String from, @Query("feedback") int feedback, Callback<CardPostHome>callback);

    //userprofile
    @GET("/me")
    void getMyProfile(@Header("Token") String token, Callback<UserProfile> callback);

}
