package panawaapps.pantaupilkada.model.Home;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by ali on 27/11/15.
 */
public class Couple {
    @SerializedName("created_at")
    @Expose
    private String createdAt;
    @SerializedName("updated_at")
    @Expose
    private String updatedAt;
    @SerializedName("calon_id")
    @Expose
    private Integer calonId;
    @SerializedName("calon_name")
    @Expose
    private String calonName;
    @SerializedName("calon_avatar")
    @Expose
    private String calonAvatar;
    @SerializedName("wakil_id")
    @Expose
    private Integer wakilId;
    @SerializedName("wakil_name")
    @Expose
    private String wakilName;
    @SerializedName("wakil_avatar")
    @Expose
    private String wakilAvatar;
    @SerializedName("province_id")
    @Expose
    private Integer provinceId;
    @SerializedName("province_name")
    @Expose
    private String provinceName;
    @SerializedName("region_id")
    @Expose
    private Integer regionId;
    @SerializedName("region_name")
    @Expose
    private String regionName;
    @SerializedName("total_vote_in_1_region")
    @Expose
    private Integer totalVoteIn1Region;
    @SerializedName("id")
    @Expose
    private String id;

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }

    public Integer getCalonId() {
        return calonId;
    }

    public void setCalonId(Integer calonId) {
        this.calonId = calonId;
    }

    public String getCalonName() {
        return calonName;
    }

    public void setCalonName(String calonName) {
        this.calonName = calonName;
    }

    public String getCalonAvatar() {
        return calonAvatar;
    }

    public void setCalonAvatar(String calonAvatar) {
        this.calonAvatar = calonAvatar;
    }

    public Integer getWakilId() {
        return wakilId;
    }

    public void setWakilId(Integer wakilId) {
        this.wakilId = wakilId;
    }

    public String getWakilName() {
        return wakilName;
    }

    public void setWakilName(String wakilName) {
        this.wakilName = wakilName;
    }

    public String getWakilAvatar() {
        return wakilAvatar;
    }

    public void setWakilAvatar(String wakilAvatar) {
        this.wakilAvatar = wakilAvatar;
    }

    public Integer getProvinceId() {
        return provinceId;
    }

    public void setProvinceId(Integer provinceId) {
        this.provinceId = provinceId;
    }

    public String getProvinceName() {
        return provinceName;
    }

    public void setProvinceName(String provinceName) {
        this.provinceName = provinceName;
    }

    public Integer getRegionId() {
        return regionId;
    }

    public void setRegionId(Integer regionId) {
        this.regionId = regionId;
    }

    public String getRegionName() {
        return regionName;
    }

    public void setRegionName(String regionName) {
        this.regionName = regionName;
    }

    public Integer getTotalVoteIn1Region() {
        return totalVoteIn1Region;
    }

    public void setTotalVoteIn1Region(Integer totalVoteIn1Region) {
        this.totalVoteIn1Region = totalVoteIn1Region;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
