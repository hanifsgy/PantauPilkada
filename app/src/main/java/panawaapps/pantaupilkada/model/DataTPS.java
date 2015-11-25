package panawaapps.pantaupilkada.model;

/**
 * Created by ali on 21/11/15.
 */
public class DataTPS {
    public String Index;
    public String Type;
    public String Ids;
    public Double Score;
    public Integer id;
    public String name;
    public Object totalPemilih;
    public Integer provinceId;
    public String provinceName;
    public Integer regionId;
    public String regionName;
    public Integer districtId;
    public String districtName;
    public Integer subdistrictId;
    public Integer spectatorCount;
    public Integer supervisorCount;
    public Object observerCount;
    public Calons calons;

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

    public String getIds() {
        return Ids;
    }

    public void setIds(String ids) {
        Ids = ids;
    }

    public Double getScore() {
        return Score;
    }

    public void setScore(Double score) {
        Score = score;
    }

    public Integer getId() {
        return id;
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

    public Calons getCalons() {
        return calons;
    }

    public void setCalons(Calons calons) {
        this.calons = calons;
    }
}
