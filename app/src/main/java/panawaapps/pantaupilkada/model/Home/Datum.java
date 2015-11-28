package panawaapps.pantaupilkada.model.Home;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by ali on 27/11/15.
 */
public class Datum {
    @SerializedName("comment")
    @Expose
    private Comment comment;

    public Comment getComment() {
        return comment;
    }

    public void setComment(Comment comment) {
        this.comment = comment;
    }
}
