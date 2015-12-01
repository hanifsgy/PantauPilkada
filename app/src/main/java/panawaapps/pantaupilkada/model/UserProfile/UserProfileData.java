package panawaapps.pantaupilkada.model.UserProfile;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by Sikikan on 12/1/2015.
 */
public class UserProfileData {
    @SerializedName("created_at")
    @Expose
    public String createdAt;
    @SerializedName("updated_at")
    @Expose
    public String updatedAt;
    @SerializedName("avatar_file_name")
    @Expose
    public Object avatarFileName;
    @SerializedName("avatar_content_type")
    @Expose
    public Object avatarContentType;
    @SerializedName("avatar_file_size")
    @Expose
    public Object avatarFileSize;
    @SerializedName("avatar_updated_at")
    @Expose
    public Object avatarUpdatedAt;
    @SerializedName("email")
    @Expose
    public String email;
    @SerializedName("name")
    @Expose
    public String name;
    @SerializedName("dob")
    @Expose
    public String dob;
    @SerializedName("address")
    @Expose
    public String address;
    @SerializedName("description")
    @Expose
    public Object description;
    @SerializedName("avatar_url")
    @Expose
    public String avatarUrl;
    @SerializedName("is_premium")
    @Expose
    public Object isPremium;
    @SerializedName("granted_access")
    @Expose
    public Object grantedAccess;
    @SerializedName("as_spectator")
    @Expose
    public Integer asSpectator;
    @SerializedName("as_supervisor")
    @Expose
    public Integer asSupervisor;
    @SerializedName("as_observer")
    @Expose
    public Integer asObserver;
    @SerializedName("group")
    @Expose
    public Object group;

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

    public Object getAvatarFileName() {
        return avatarFileName;
    }

    public void setAvatarFileName(Object avatarFileName) {
        this.avatarFileName = avatarFileName;
    }

    public Object getAvatarContentType() {
        return avatarContentType;
    }

    public void setAvatarContentType(Object avatarContentType) {
        this.avatarContentType = avatarContentType;
    }

    public Object getAvatarFileSize() {
        return avatarFileSize;
    }

    public void setAvatarFileSize(Object avatarFileSize) {
        this.avatarFileSize = avatarFileSize;
    }

    public Object getAvatarUpdatedAt() {
        return avatarUpdatedAt;
    }

    public void setAvatarUpdatedAt(Object avatarUpdatedAt) {
        this.avatarUpdatedAt = avatarUpdatedAt;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Object getDescription() {
        return description;
    }

    public void setDescription(Object description) {
        this.description = description;
    }

    public String getAvatarUrl() {
        return avatarUrl;
    }

    public void setAvatarUrl(String avatarUrl) {
        this.avatarUrl = avatarUrl;
    }

    public Object getIsPremium() {
        return isPremium;
    }

    public void setIsPremium(Object isPremium) {
        this.isPremium = isPremium;
    }

    public Object getGrantedAccess() {
        return grantedAccess;
    }

    public void setGrantedAccess(Object grantedAccess) {
        this.grantedAccess = grantedAccess;
    }

    public Integer getAsSpectator() {
        return asSpectator;
    }

    public void setAsSpectator(Integer asSpectator) {
        this.asSpectator = asSpectator;
    }

    public Integer getAsSupervisor() {
        return asSupervisor;
    }

    public void setAsSupervisor(Integer asSupervisor) {
        this.asSupervisor = asSupervisor;
    }

    public Integer getAsObserver() {
        return asObserver;
    }

    public void setAsObserver(Integer asObserver) {
        this.asObserver = asObserver;
    }

    public Object getGroup() {
        return group;
    }

    public void setGroup(Object group) {
        this.group = group;
    }
}
