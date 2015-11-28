package panawaapps.pantaupilkada.api;

import java.io.File;

import panawaapps.pantaupilkada.model.CardPostHome;
import panawaapps.pantaupilkada.model.District;
import panawaapps.pantaupilkada.model.Kandidat.KandidatPojo;
import panawaapps.pantaupilkada.model.Province;
import panawaapps.pantaupilkada.model.Region;
import panawaapps.pantaupilkada.model.SubDistricts;
import panawaapps.pantaupilkada.model.TPS.TPS;
import panawaapps.pantaupilkada.model.UserData.UserData;
import retrofit.Callback;
import retrofit.http.Field;
import retrofit.http.FormUrlEncoded;
import retrofit.http.GET;
import retrofit.http.POST;
import retrofit.http.Path;
import retrofit.http.Query;

/**
 * Created by Sikikan on 11/23/2015.
 */
public interface RestApi {

    @GET("/cards/contest_cards.json?province_id=16")
    void getContests(Callback<String> contests);

    //location
    @GET("/locations/provinces")
    void getProvinces(Callback<Province> provinceCallback);

    @GET("/locations/{province_id}/regions.json?sort=asc")
    void getRegion(@Path("province_id") String provinceId, Callback<Region> regionCallback);

    @GET("/locations/{region_id}/districts?sort=asc")
    void getDistrict(@Path("region_id") String regionId, Callback<District> districtCallback);

    @GET("/locations/{districts_id}/subdistricts?sort=asc")
    void getSubDistrict(@Path("districts_id") String district_id, Callback<SubDistricts> subDistrictsCallback);

    //Test parsing comments
    @GET("/comments.json?page=1&per_page=5")
    void getComments(Callback<String> comments);

    //tps
    @GET("/cards/tps_cards")
    void getTPS(@Query("subdistrict_id") String subdistrict_id, Callback<TPS> tpslCallback);

    //comment
    @GET("/comments")
    void getComment(Callback<CardPostHome> cardPostHomeCallback);

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

}
