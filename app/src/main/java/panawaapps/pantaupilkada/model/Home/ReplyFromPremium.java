package panawaapps.pantaupilkada.model.Home;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by ali on 27/11/15.
 */
public class ReplyFromPremium {
    @SerializedName("reply")
    @Expose
    private Reply reply;

    public Reply getReply() {
        return reply;
    }

    public void setReply(Reply reply) {
        this.reply = reply;
    }
}
