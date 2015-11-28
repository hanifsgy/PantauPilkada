package panawaapps.pantaupilkada.model;

/**
 * Created by Sikikan on 11/23/2015.
 */
public class Card {
    public int mRegionId, mCalonId, mWakilId;
    public String mRegionName, mCalonName, mWakilName, mCoupleId, mKind;

    public Card(CardBuilder builder){
        mRegionId = builder.mRegionId;
        mCalonId = builder.mCalonId;
        mWakilId = builder.mWakilId;
        mRegionName = builder.mRegionName;
        mCalonName = builder.mCalonName;
        mWakilName = builder.mWakilName;
        mCoupleId = builder.mCoupleId;
        mKind = builder.mKind;
    }

    public static class CardBuilder {
        private int mRegionId, mCalonId, mWakilId;
        private String mRegionName, mCalonName, mWakilName, mCoupleId, mKind;

        public CardBuilder setRegionId(int region) {
            mRegionId = region;
            return CardBuilder.this;
        }

        public CardBuilder setCalonId(int calonId) {
            mCalonId = calonId;
            return CardBuilder.this;
        }

        public CardBuilder setWakilId(int wakilId) {
            mWakilId = wakilId;
            return CardBuilder.this;
        }

        public CardBuilder setRegioName(String regioName) {
            mRegionName = regioName;
            return CardBuilder.this;
        }

        public CardBuilder setCalonName(String calonName) {
            mCalonName = calonName;
            return CardBuilder.this;
        }

        public CardBuilder setWakilName(String wakilName) {
            mWakilName = wakilName;
            return CardBuilder.this;
        }

        public CardBuilder setCoupleId(String coupleId) {
            mCoupleId = coupleId;
            return CardBuilder.this;
        }

        public CardBuilder setKind(String kind) {
            mKind = kind;
            return CardBuilder.this;
        }

        public Card build(){
            return new Card(CardBuilder.this);
        }
    }


}
