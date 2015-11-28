package panawaapps.pantaupilkada.model;

/**
 * Created by Sikikan on 11/28/2015.
 */
public class CardGroup {
    public String mNamaGroup, mDeskripsiGroup;
    public int mFotoGroup, mJmlPengamat, mJmlPengawas, mJmlSaksi;

    public CardGroup (CardGroupBuilder builder){
        mNamaGroup = builder.mNamaGroup;
        mDeskripsiGroup = builder.mDeskripsiGroup;
        mFotoGroup = builder.mFotoGroup;
        mJmlPengamat = builder.mJmlPengamat;
        mJmlPengawas = builder.mJmlPengawas;
        mJmlSaksi = builder.mJmlSaksi;
    }

    public static class CardGroupBuilder {
        private String mNamaGroup, mDeskripsiGroup;
        private int mFotoGroup, mJmlPengamat, mJmlPengawas, mJmlSaksi;

        public CardGroupBuilder setNamaGroup(String namaGroup){
            mNamaGroup = namaGroup;
            return CardGroupBuilder.this;
        }
        public CardGroupBuilder setDeskripsiGroup(String deskripsiGroup){
            mDeskripsiGroup = deskripsiGroup;
            return CardGroupBuilder.this;
        }
        public CardGroupBuilder setFotoGroup(int fotoGroup){
            mFotoGroup = fotoGroup;
            return CardGroupBuilder.this;
        }
        public CardGroupBuilder setJmlPengamat(int jmlPengamat){
            mJmlPengamat = jmlPengamat;
            return CardGroupBuilder.this;
        }
        public CardGroupBuilder setJmlPengawas(int jmlPengawas){
            mJmlPengawas = jmlPengawas;
            return CardGroupBuilder.this;
        }

        public CardGroupBuilder setJmlSaksi(int jmlSaksi){
            mJmlSaksi = jmlSaksi;
            return CardGroupBuilder.this;
        }

        public CardGroup build() {
            return  new CardGroup(CardGroupBuilder.this);
        }
    }
}
