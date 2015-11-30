package panawaapps.pantaupilkada.model.TPS;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ali on 24/11/15.
 */
public class Datum {
    @SerializedName("_index")
    @Expose
    public String Index;
    @SerializedName("_type")
    @Expose
    public String Type;
    @SerializedName("_id")
    @Expose
    public String Id;
    @SerializedName("_score")
    @Expose
    public Double Score;
    @SerializedName("id")
    @Expose
    public Integer id;
    @SerializedName("name")
    @Expose
    public String name;
    @SerializedName("total_pemilih")
    @Expose
    public Object totalPemilih;
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
    @SerializedName("district_id")
    @Expose
    public Integer districtId;
    @SerializedName("district_name")
    @Expose
    public String districtName;
    @SerializedName("subdistrict_id")
    @Expose
    public Integer subdistrictId;
    @SerializedName("subdistrict_name")
    @Expose
    public String subdistrictName;
    @SerializedName("spectator_count")
    @Expose
    public Integer spectatorCount;
    @SerializedName("supervisor_count")
    @Expose
    public Integer supervisorCount;
    @SerializedName("observer_count")
    @Expose
    public Object observerCount;
    @SerializedName("calons")
    @Expose
    public List<Calon> calons = new ArrayList<Calon>();
    @SerializedName("kind")
    @Expose
    public String kind;
    @SerializedName("kind_label")
    @Expose
    public String kind_label;

    public String getKind_label() {
        return kind_label;
    }

    public String getIndex() {
        return Index;
    }

    public void setIndex(String index) {
        Index = index;
    }

    public String getType() {
        return Type;
    }

    public void setType(String type) {
        Type = type;
    }

    public String getId() {
        return Id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Object getTotalPemilih() {
        return totalPemilih;
    }

    public void setTotalPemilih(Object totalPemilih) {
        this.totalPemilih = totalPemilih;
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

    public Integer getDistrictId() {
        return districtId;
    }

    public void setDistrictId(Integer districtId) {
        this.districtId = districtId;
    }

    public String getDistrictName() {
        return districtName;
    }

    public void setDistrictName(String districtName) {
        this.districtName = districtName;
    }

    public Integer getSubdistrictId() {
        return subdistrictId;
    }

    public void setSubdistrictId(Integer subdistrictId) {
        this.subdistrictId = subdistrictId;
    }

    public String getSubdistrictName() {
        return subdistrictName;
    }

    public void setSubdistrictName(String subdistrictName) {
        this.subdistrictName = subdistrictName;
    }

    public Integer getSpectatorCount() {
        return spectatorCount;
    }

    public void setSpectatorCount(Integer spectatorCount) {
        this.spectatorCount = spectatorCount;
    }

    public Integer getSupervisorCount() {
        return supervisorCount;
    }

    public void setSupervisorCount(Integer supervisorCount) {
        this.supervisorCount = supervisorCount;
    }

    public Object getObserverCount() {
        return observerCount;
    }

    public void setObserverCount(Object observerCount) {
        this.observerCount = observerCount;
    }

    public List<Calon> getCalons() {
        return calons;
    }

    public void setCalons(List<Calon> calons) {
        this.calons = calons;
    }

    public String getKind() {
        return kind;
    }

    public void setKind(String kind) {
        this.kind = kind;
    }

    public void setId(String id) {
        Id = id;
    }

    public Double getScore() {
        return Score;
    }

    public void setScore(Double score) {
        Score = score;
    }
}
