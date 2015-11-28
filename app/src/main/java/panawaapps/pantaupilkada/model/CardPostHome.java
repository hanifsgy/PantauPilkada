package panawaapps.pantaupilkada.model;

/**
 * Created by Sikikan on 11/22/2015.
 */
public class CardPostHome {

    public String tglPostHome, namaCalon, namaWakil, judulPostHome, isiPostHome, isiReply, tglReply;
    public int fotoPostHome, jmlApresiasi, jmlPerhatian;

    public CardPostHome(CardPostHomeBuilder builder){
        tglPostHome = builder.tglPostHome;
        judulPostHome = builder.judulPostHome;
        isiPostHome = builder.isiPostHome;
    }


    public static class CardPostHomeBuilder {
        private String tglPostHome, namaCalon, namaWakil, judulPostHome, isiPostHome, isiReply, tglReply;
        private int fotoPostHome, jmlApresiasi, jmlPerhatian;

        public CardPostHomeBuilder setTglPostHome (String tglPostHome){
            this.tglPostHome = tglPostHome;
            return CardPostHomeBuilder.this;
        }
        public CardPostHomeBuilder setJudulPostHome (String judulPostHome){
            this.judulPostHome = judulPostHome;
            return CardPostHomeBuilder.this;
        }
        public CardPostHomeBuilder setIsiPostHome (String isiPostHome){
            this.isiPostHome = isiPostHome;
            return CardPostHomeBuilder.this;
        }

        public CardPostHome build() {
            return new CardPostHome(CardPostHomeBuilder.this);
        }
    }
}
