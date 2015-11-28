package panawaapps.pantaupilkada.model;

/**
 * Created by Sikikan on 11/28/2015.
 */
public class CardDariKandidat {
    public String mTglPost;
    public String mJudulPost;
    public String mIsiPost;
    public String mNamaUser;
    public int mJmlDiapresiasi;
    public int mJmlDiperhatikan;

    public CardDariKandidat(CardDariKandidatBuilder builder){
        mTglPost = builder.mTglPost;
        mJudulPost = builder.mJudulPost;
        mIsiPost = builder.mIsiPost;
        mNamaUser = builder.mNamaUser;
        mJmlDiapresiasi = builder.mJmlDiapresiasi;
        mJmlDiperhatikan = builder.mJmlDiperhatikan;
    }

    public static class CardDariKandidatBuilder {
        public String mTglPost;
        public String mJudulPost;
        public String mIsiPost;
        public String mNamaUser;
        public int mJmlDiapresiasi;
        public int mJmlDiperhatikan;

        public CardDariKandidatBuilder setTglPost(String tglPost){
            mTglPost = tglPost;
            return CardDariKandidatBuilder.this;
        }
        public CardDariKandidatBuilder setJudulPost(String judulPost){
            mJudulPost = judulPost;
            return CardDariKandidatBuilder.this;
        }
        public CardDariKandidatBuilder setIsiPost(String isiPost){
            mIsiPost = isiPost;
            return CardDariKandidatBuilder.this;
        }
        public CardDariKandidatBuilder setNamaUser(String namaUser){
            mNamaUser = namaUser;
            return CardDariKandidatBuilder.this;
        }
        public CardDariKandidatBuilder setJmlDiapresiasi(int jmlDiapresiasi){
            mJmlDiapresiasi = jmlDiapresiasi;
            return CardDariKandidatBuilder.this;
        }
        public CardDariKandidatBuilder setJmlDiperhatikan(int jmlDiperhatikan){
            mJmlDiperhatikan = jmlDiperhatikan;
            return CardDariKandidatBuilder.this;
        }

        public CardDariKandidat build() {
            return new CardDariKandidat(CardDariKandidatBuilder.this);
        }
    }
}
