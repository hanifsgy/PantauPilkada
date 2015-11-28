package panawaapps.pantaupilkada.model.Kandidat;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by ali on 28/11/15.
 */
public class Data {
    @SerializedName("created_at")
    @Expose
    public String createdAt;
    @SerializedName("updated_at")
    @Expose
    public String updatedAt;
    @SerializedName("calon_id")
    @Expose
    public Integer calonId;
    @SerializedName("calon_name")
    @Expose
    public String calonName;
    @SerializedName("calon_avatar")
    @Expose
    public String calonAvatar;
    @SerializedName("wakil_id")
    @Expose
    public Integer wakilId;
    @SerializedName("wakil_name")
    @Expose
    public String wakilName;
    @SerializedName("wakil_avatar")
    @Expose
    public String wakilAvatar;
    @SerializedName("province_id")
    @Expose
    public Integer provinceId;
    @SerializedName("province_name")
    @Expose
    public String provinceName;
    @SerializedName("region_id")
    @Expose
    public Integer regionId;
    @SerializedName("region_name")
    @Expose
    public String regionName;
    @SerializedName("total_vote_in_1_region")
    @Expose
    public Integer totalVoteIn1Region;
    @SerializedName("from_candidates")
    @Expose
    public Integer fromCandidates;
    @SerializedName("from_voter")
    @Expose
    public Integer fromVoter;
    @SerializedName("from_voter_apresiasi")
    @Expose
    public Integer fromVoterApresiasi;
    @SerializedName("from_voter_perhatikan")
    @Expose
    public Integer fromVoterPerhatikan;

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

    public Integer getFromCandidates() {
        return fromCandidates;
    }

    public void setFromCandidates(Integer fromCandidates) {
        this.fromCandidates = fromCandidates;
    }

    public Integer getFromVoter() {
        return fromVoter;
    }

    public void setFromVoter(Integer fromVoter) {
        this.fromVoter = fromVoter;
    }

    public Integer getFromVoterApresiasi() {
        return fromVoterApresiasi;
    }

    public void setFromVoterApresiasi(Integer fromVoterApresiasi) {
        this.fromVoterApresiasi = fromVoterApresiasi;
    }

    public Integer getFromVoterPerhatikan() {
        return fromVoterPerhatikan;
    }

    public void setFromVoterPerhatikan(Integer fromVoterPerhatikan) {
        this.fromVoterPerhatikan = fromVoterPerhatikan;
    }
}
