package panawaapps.pantaupilkada.model;

/**
 * Created by Sikikan on 11/28/2015.
 */
public class CardFriend {
    public int mFotoFriend,mJmlPengamat, mJmlPengawas, mJmlSaksi;
    public String mNamaFriend;

    public CardFriend (CardFriendBuilder builder){
        mFotoFriend = builder.mFotoFriend;
        mNamaFriend = builder.mNamaFriend;
        mJmlPengamat = builder.mJmlPengamat;
        mJmlPengawas = builder.mJmlPengawas;
        mJmlSaksi = builder.mJmlSaksi;
    }

    public static class CardFriendBuilder {
        private int mFotoFriend,mJmlPengamat, mJmlPengawas, mJmlSaksi;
        private String mNamaFriend;

        public CardFriendBuilder setFotoFriend (int fotoFriend){
            mFotoFriend = fotoFriend;
            return CardFriendBuilder.this;        }

        public CardFriendBuilder setJmlPengamat (int jmlPengamat){
            mJmlPengamat = jmlPengamat;
            return CardFriendBuilder.this;
        }
        public CardFriendBuilder setJmlPengawas (int jmlPengawas){
            mJmlPengawas = jmlPengawas;
            return CardFriendBuilder.this;
        }
        public CardFriendBuilder setJmlSaksi (int jmlSaksi){
            mJmlSaksi = jmlSaksi;
            return CardFriendBuilder.this;
        }
        public CardFriendBuilder setNamaFriend (String namaFriend){
            mNamaFriend = namaFriend;
            return CardFriendBuilder.this;
        }

        public CardFriend build() {
            return new CardFriend(CardFriendBuilder.this);
        }
    }
}
