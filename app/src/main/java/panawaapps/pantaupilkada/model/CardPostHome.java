package panawaapps.pantaupilkada.model;

/**
 * Created by Sikikan on 11/22/2015.
 */
public class CardPostHome {
    public String judulPostHome;
    public int fotoPostHome;
    public String isiPostHome;
    public String tglPostHome;
    int jmlApresiasi;
    int jmlPerhatian;

    public CardPostHome(String judulPost, int fotoPost, String isiPost, String tglPost, int jmlApresiasi, int jmlPerhatian) {
        this.judulPostHome = judulPost;
        this.fotoPostHome = fotoPost;
        this.isiPostHome = isiPost;
        this.tglPostHome = tglPost;
        this.jmlApresiasi = Integer.parseInt(String.valueOf(jmlApresiasi));
        this.jmlPerhatian = Integer.parseInt(String.valueOf(jmlPerhatian));
    }
}
