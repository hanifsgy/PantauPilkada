package panawaapps.pantaupilkada.adapter;

import android.annotation.SuppressLint;
import android.os.Build;
import android.view.View;
import android.widget.TextView;

import panawaapps.pantaupilkada.R;


/**
 * Custom parent ViewHolder. Any views should be found and set to public variables here to be
 * referenced in your custom ExpandableRecyclerAdapter later.
 *
 * Must extend ParentViewHolder
 *
 * @author Ryan Brooks
 * @version 1.0
 * @since 5/27/2015
 */
public class CardTpsParentViewHolder extends ParentViewHolder {

    private static final float INITIAL_POSITION = 0.0f;
    private static final float ROTATED_POSITION = 180f;
    private static final float PIVOT_VALUE = 0.5f;
    private static final long DEFAULT_ROTATE_DURATION_MS = 200;
    private static final boolean HONEYCOMB_AND_ABOVE = Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB;

    public TextView tvDaerahCardKontestan;
    public TextView tvJmlTps;
    public TextView tvNoTps;
    public TextView tvIdTps;
    public TextView tvStatusPengawasan;
    public TextView tvJmlTerawasi;
    public TextView tvJmlSaksi;
    public TextView tvPeranUser;

//    public TextView mNumberTextView;
//    public TextView mDataTextView;
//    public ImageView mArrowExpandImageView;

    /**
     * Public constructor for the CustomViewHolder.
     *
     * @param itemView the view of the parent item. Find/modify views using this.
     */
    public CardTpsParentViewHolder(View itemView) {
        super(itemView);

        tvDaerahCardKontestan = (TextView) itemView.findViewById(R.id.tv_daerahCardKontestan);
        tvJmlTps = (TextView) itemView.findViewById(R.id.tv_jmlTps);
        tvNoTps = (TextView) itemView.findViewById(R.id.tv_noTps);
        tvIdTps = (TextView) itemView.findViewById(R.id.tv_idTps);
        tvStatusPengawasan = (TextView) itemView.findViewById(R.id.tv_statusTerpenuhi);
        tvJmlTerawasi = (TextView) itemView.findViewById(R.id.tv_jmlTerawasi);
        tvJmlSaksi = (TextView) itemView.findViewById(R.id.tv_jmlSaksi);
        tvPeranUser = (TextView) itemView.findViewById(R.id.tv_peranUser);

//        mNumberTextView = (TextView) itemView.findViewById(R.id.list_item_parent_vertical_number_textView);
//        mDataTextView = (TextView) itemView.findViewById(R.id.list_item_parent_vertical_parent_textView);
//        mArrowExpandImageView = (ImageView) itemView.findViewById(R.id.list_item_parent_horizontal_arrow_imageView);
    }

    public void bind(String daerahCardKontestan, String jmlTps, String noTps, String idTps,
                     String statusTerawasi, String jmlTerawasi,String jmlSaksi, String peranUser) {
        tvDaerahCardKontestan.setText(daerahCardKontestan);
        tvJmlTps.setText(jmlTps);
        tvNoTps.setText(noTps);
        tvIdTps.setText(idTps);
        tvStatusPengawasan.setText(statusTerawasi);
        tvJmlTerawasi.setText(jmlTerawasi);
        tvJmlSaksi.setText(jmlSaksi);
        tvPeranUser.setText(peranUser);
//        mNumberTextView.setText(String.valueOf(parentNumber));
//        mDataTextView.setText(parentText);
    }

    @SuppressLint("NewApi")
    @Override
    public void setExpanded(boolean expanded) {
        super.setExpanded(expanded);
        if (!HONEYCOMB_AND_ABOVE) {
            return;
        }

//        if (expanded) {
//            mArrowExpandImageView.setRotation(ROTATED_POSITION);
//        } else {
//            mArrowExpandImageView.setRotation(INITIAL_POSITION);
//        }
    }

    @Override
    public void onExpansionToggled(boolean expanded) {
        super.onExpansionToggled(expanded);
        if (!HONEYCOMB_AND_ABOVE) {
            return;
        }

//        RotateAnimation rotateAnimation = new RotateAnimation(ROTATED_POSITION,
//                INITIAL_POSITION,
//                RotateAnimation.RELATIVE_TO_SELF, PIVOT_VALUE,
//                RotateAnimation.RELATIVE_TO_SELF, PIVOT_VALUE);
//        rotateAnimation.setDuration(DEFAULT_ROTATE_DURATION_MS);
//        rotateAnimation.setFillAfter(true);
//        mArrowExpandImageView.startAnimation(rotateAnimation);
    }
}