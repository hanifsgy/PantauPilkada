package panawaapps.pantaupilkada.model.Home;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by ali on 27/11/15.
 */
public class Comment {
    @SerializedName("created_at")
    @Expose
    private String createdAt;
    @SerializedName("updated_at")
    @Expose
    private String updatedAt;
    @SerializedName("cpl_id")
    @Expose
    private String cplId;
    @SerializedName("couple_name")
    @Expose
    private CoupleName coupleName;
    @SerializedName("person_id")
    @Expose
    private String personId;
    @SerializedName("person_name")
    @Expose
    private String personName;
    @SerializedName("title")
    @Expose
    private String title;
    @SerializedName("text")
    @Expose
    private String text;
    @SerializedName("reply_from_premium")
    @Expose
    private ReplyFromPremium replyFromPremium;
    @SerializedName("feedback")
    @Expose
    private Integer feedback;
    @SerializedName("feedback_apresiasi_count")
    @Expose
    private Integer feedbackApresiasiCount;
    @SerializedName("feedback_perhatikan_count")
    @Expose
    private Integer feedbackPerhatikanCount;
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

    public String getCplId() {
        return cplId;
    }

    public void setCplId(String cplId) {
        this.cplId = cplId;
    }

    public CoupleName getCoupleName() {
        return coupleName;
    }

    public void setCoupleName(CoupleName coupleName) {
        this.coupleName = coupleName;
    }

    public String getPersonId() {
        return personId;
    }

    public void setPersonId(String personId) {
        this.personId = personId;
    }

    public String getPersonName() {
        return personName;
    }

    public void setPersonName(String personName) {
        this.personName = personName;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public ReplyFromPremium getReplyFromPremium() {
        return replyFromPremium;
    }

    public void setReplyFromPremium(ReplyFromPremium replyFromPremium) {
        this.replyFromPremium = replyFromPremium;
    }

    public Integer getFeedback() {
        return feedback;
    }

    public void setFeedback(Integer feedback) {
        this.feedback = feedback;
    }

    public Integer getFeedbackApresiasiCount() {
        return feedbackApresiasiCount;
    }

    public void setFeedbackApresiasiCount(Integer feedbackApresiasiCount) {
        this.feedbackApresiasiCount = feedbackApresiasiCount;
    }

    public Integer getFeedbackPerhatikanCount() {
        return feedbackPerhatikanCount;
    }

    public void setFeedbackPerhatikanCount(Integer feedbackPerhatikanCount) {
        this.feedbackPerhatikanCount = feedbackPerhatikanCount;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
