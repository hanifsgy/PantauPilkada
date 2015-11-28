package panawaapps.pantaupilkada.api;

import panawaapps.pantaupilkada.model.District;
import panawaapps.pantaupilkada.model.Province;
import panawaapps.pantaupilkada.model.Region;
import panawaapps.pantaupilkada.model.SubDistricts;
import panawaapps.pantaupilkada.model.TPS.TPS;
import retrofit.Callback;
import retrofit.http.GET;
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

}
