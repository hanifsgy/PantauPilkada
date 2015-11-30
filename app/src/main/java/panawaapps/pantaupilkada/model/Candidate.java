package panawaapps.pantaupilkada.model;

public class Candidate {

    private String province_id;
    private String province_name;

    private String region_id;
    private String region_name;

    private String calon_id;
    private String calon_name;
    private String calon_avatar;

    private String wakil_id;
    private String wakil_name;
    private String wakil_avatar;

    private String couple_id;

    private String kind;
    private String kind_label;

    private int total_vote_in_1_region;

    public String getProvince_id() {
        return province_id;
    }

    public void setProvince_id(String province_id) {
        this.province_id = province_id;
    }

    public String getProvince_name() {
        return province_name;
    }

    public void setProvince_name(String province_name) {
        this.province_name = province_name;
    }

    public int getTotal_vote_in_1_region() {
        return total_vote_in_1_region;
    }

    public void setTotal_vote_in_1_region(int total_vote_in_1_region) {
        this.total_vote_in_1_region = total_vote_in_1_region;
    }

    public String getRegion_id() {
        return region_id;
    }

    public void setRegion_id(String region_id) {
        this.region_id = region_id;
    }

    public String getRegion_name() {
        return region_name;
    }

    public void setRegion_name(String region_name) {
        this.region_name = region_name;
    }

    public String getCalon_id() {
        return calon_id;
    }

    public void setCalon_id(String calon_id) {
        this.calon_id = calon_id;
    }

    public String getCalon_name() {
        return calon_name;
    }

    public void setCalon_name(String calon_name) {
        this.calon_name = calon_name;
    }

    public String getCalon_avatar() {
        return calon_avatar;
    }

    public void setCalon_avatar(String calon_avatar) {
        this.calon_avatar = calon_avatar;
    }

    public String getWakil_id() {
        return wakil_id;
    }

    public void setWakil_id(String wakil_id) {
        this.wakil_id = wakil_id;
    }

    public String getWakil_name() {
        return wakil_name;
    }

    public void setWakil_name(String wakil_name) {
        this.wakil_name = wakil_name;
    }

    public String getWakil_avatar() {
        return wakil_avatar;
    }

    public void setWakil_avatar(String wakil_avatar) {
        this.wakil_avatar = wakil_avatar;
    }

    public String getCouple_id() {
        return couple_id;
    }

    public void setCouple_id(String couple_id) {
        this.couple_id = couple_id;
    }

    public String getKind() {
        return kind;
    }

    public void setKind(String kind) {
        this.kind = kind;
    }

    public String getKind_label() {
        return kind_label;
    }

    public void setKind_label(String kind_label) {
        this.kind_label = kind_label;
    }
}
