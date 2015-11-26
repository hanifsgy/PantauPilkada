package panawaapps.pantaupilkada.model;

/**
 * Created by Sikikan on 11/22/2015.
 */
public class CardPostHome {

    public String tglPostHome;
    public String namaCalon;
    public String namaWakil;
    public String judulPostHome;
    public int fotoPostHome;
    public String isiPostHome;
    public int jmlApresiasi = 0;
    public int jmlPerhatian = 0;
    public String isiReply = null;
    public String tglReply = null;

    public CardPostHome(String judulPost, int fotoPost, String isiPost, String tglPost, int jmlApresiasi, int jmlPerhatian, String isiReply, String tglReply) {
        this.judulPostHome = judulPost;
        this.fotoPostHome = fotoPost;
        this.isiPostHome = isiPost;
        this.tglPostHome = tglPost;
        this.jmlApresiasi = Integer.parseInt(String.valueOf(jmlApresiasi));
        this.jmlPerhatian = Integer.parseInt(String.valueOf(jmlPerhatian));
        this.isiReply = isiReply;
        this.tglReply = tglReply;
    }
}
