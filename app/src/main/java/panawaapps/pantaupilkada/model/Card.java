package panawaapps.pantaupilkada.model;

/**
 * Created by Sikikan on 11/23/2015.
 */
public class Card {
    public int mRegionId, mCalonId, mWakilId;
    public String mRegionName, mCalonName, mWakilName, mCoupleId, mKind;

    public Card(Builder builder){
        mRegionId = builder.mRegionId;
        mCalonId = builder.mCalonId;
        mWakilId = builder.mWakilId;
        mRegionName = builder.mRegionName;
        mCalonName = builder.mCalonName;
        mWakilName = builder.mWakilName;
        mCoupleId = builder.mCoupleId;
        mKind = builder.mKind;
    }

    public static class Builder {
        private int mRegionId, mCalonId, mWakilId;
        private String mRegionName, mCalonName, mWakilName, mCoupleId, mKind;

        public Builder setRegionId(int region) {
            mRegionId = region;
            return Builder.this;
        }

        public Builder setCalonId(int calonId) {
            mCalonId = calonId;
            return Builder.this;
        }

        public Builder setWakilId(int wakilId) {
            mWakilId = wakilId;
            return Builder.this;
        }

        public Builder setRegioName(String regioName) {
            mRegionName = regioName;
            return Builder.this;
        }

        public Builder setCalonName(String calonName) {
            mCalonName = calonName;
            return Builder.this;
        }

        public Builder setWakilName(String wakilName) {
            mWakilName = wakilName;
            return Builder.this;
        }

        public Builder setCoupleId(String coupleId) {
            mCoupleId = coupleId;
            return Builder.this;
        }

        public Builder setKind(String kind) {
            mKind = kind;
            return Builder.this;
        }

        public Card build(){
            return new Card(Builder.this);
        }
    }


}
