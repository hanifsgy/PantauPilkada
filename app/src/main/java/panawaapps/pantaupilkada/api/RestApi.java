package panawaapps.pantaupilkada.api;

import java.io.File;

import panawaapps.pantaupilkada.model.CardPostHome;
import panawaapps.pantaupilkada.model.CheckReplyPremium;
import panawaapps.pantaupilkada.model.District;
import panawaapps.pantaupilkada.model.Kandidat.KandidatPojo;
import panawaapps.pantaupilkada.model.Pengamat;
import panawaapps.pantaupilkada.model.PostComments.CommentsData;
import panawaapps.pantaupilkada.model.Premium;
import panawaapps.pantaupilkada.model.Province;
import panawaapps.pantaupilkada.model.Region;
import panawaapps.pantaupilkada.model.PremiumReply;
import panawaapps.pantaupilkada.model.Status;
import panawaapps.pantaupilkada.model.SubDistricts;
import panawaapps.pantaupilkada.model.TPS.TPS;
import panawaapps.pantaupilkada.model.UserData.UserData;
import panawaapps.pantaupilkada.model.UserProfile.UserProfile;
import panawaapps.pantaupilkada.model.comments.ApresiasiData;
import retrofit.Callback;
import retrofit.http.Body;
import retrofit.http.DELETE;
import retrofit.http.Field;
import retrofit.http.FormUrlEncoded;
import retrofit.http.GET;
import retrofit.http.Header;
import retrofit.http.Multipart;
import retrofit.http.POST;
import retrofit.http.Part;
import retrofit.http.Path;
import retrofit.http.Query;
import retrofit.mime.TypedFile;

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


    @GET("/cards/fulllist_bookmarks")
    void getPengamat(@Header("Token") String token, Callback<Pengamat> callback);

    //Untuk mendapatkan Contest Card
    @GET("/cards/contest_cards")
    void getCards(@Query("province_id") String province_id, Callback<Pengamat> tpslCallback);


    @POST("/card_actions/observe/{region_id}")
    void pinPengamat(@Body String task, @Path("region_id") String provinceId, @Header("Token") String token, Callback<Status> status);


    @DELETE("/card_actions/observe/{region_id}/remove.json")
    void unpinPengamat(@Path("region_id") String provinceId, @Header("Token") String token, Callback<Status> status);

    //kecamatan
    @GET("/locations/{region_id}/districts?sort=asc")
    void getDistrict(@Path("region_id") String regionId, Callback<District> districtCallback);

    //kelurahan
    @GET("/locations/{districts_id}/subdistricts?sort=asc")
    void getSubDistrict(@Path("districts_id") String district_id, Callback<SubDistricts> subDistrictsCallback);

    //harus dihapus
    @GET("/cards/contest_cards.json?province_id=16")
    void getContests(Callback<String> contests);

    //comment with query
    @GET("/comments")
    void getComment(@Header("Token") String token, @Query("page") int page, @Query("per_page") int perpage, Callback<CardPostHome> cardPostHomeCallback);

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

    //update profile
    @FormUrlEncoded
    @POST("/me/update")
    void updateProfile(@Header("Token") String token, @Field("name") String name, @Field("bio") String bio, Callback<UserData> callback);

    //postCommentdarikandidat
    @FormUrlEncoded
    @POST("/comments")
    void postComments(@Header("Token") String token, @Field("couple_id") String cpid, @Field("title") String title, @Field("text") String text, @Field("feedback") int feedback, Callback<CommentsData> callback);

    @FormUrlEncoded
    @POST("/comments")
    void postApresiasi(@Header("Token") String token, @Field("comment_id") String commentId, Callback<ApresiasiData> callback);

    //getPremium
    @GET("/premium/check_authorization")
    void getPremium(@Header("Token") String token, Callback<Premium> premiumCallback);

    @GET("/premium/check_authorization")
    void getPremiumReply(@Header("Token") String token, @Query("couple_id") String coupleId, Callback<CheckReplyPremium> callback);

    @FormUrlEncoded
    @POST("/premium/comments/{comment_id}/replies")
    void replyPremium(@Path("comment_id") String commentId, @Header("Token") String token, @Field("text") String text, Callback<PremiumReply> callback);

    @POST("/comments/{comment_id}/vote_apresiasi")
    void sendApresiasi(@Body Object dummy, @Header("Token") String token, @Path("comment_id") String commentId, Callback<Status> callback);

    @POST("/comments/{comment_id}/vote_perhatikan")
    void sendPerhatikan(@Body Object dummy, @Header("Token") String token, @Path("comment_id") String commentId, Callback<Status> callback);

    //logout
    @DELETE("/sessions/logout")
    void Logout(@Query("token") String token, Callback<Status> status);

    //update avatar
    @Multipart
//    @FormUrlEncoded
    @POST("/me/update_picture.json")
    void updateAvatar(@Header("Token") String token, @Part("avatar") TypedFile file, Callback<String> callback);
}
