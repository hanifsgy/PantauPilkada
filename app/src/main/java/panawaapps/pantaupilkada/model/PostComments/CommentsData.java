package panawaapps.pantaupilkada.model.PostComments;

/**
 * Created by Sikikan on 12/1/2015.
 */
public class CommentsData {
    private String token;
    private String couple_id;
    private String title;
    private String text;
    private int feedback;

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getCouple_id() {
        return couple_id;
    }

    public void setCouple_id(String couple_id) {
        this.couple_id = couple_id;
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

    public int getFeedback() {
        return feedback;
    }

    public void setFeedback(int feedback) {
        this.feedback = feedback;
    }
}
