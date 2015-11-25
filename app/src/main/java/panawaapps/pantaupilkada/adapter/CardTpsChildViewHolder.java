package panawaapps.pantaupilkada.adapter;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import panawaapps.pantaupilkada.R;


/**
 * Custom child ViewHolder. Any views should be found and set to public variables here to be
 * referenced in your custom ExpandableAdapter later.
 *
 * Must extend ChildViewHolder.
 *
 * @author Ryan Brooks
 * @version 1.0
 * @since 5/27/2015
 */
public class CardTpsChildViewHolder extends ChildViewHolder {

    public TextView tvNamaCalon1;
    public TextView tvNamaCalon2;
    public TextView tvNamaCalon3;
    public TextView tvNamaCalon4;
    public TextView tvNamaCalon5;
    public TextView tvNamaCalon6;

    public TextView tvNamaWakil1;
    public TextView tvNamaWakil2;
    public TextView tvNamaWakil3;
    public TextView tvNamaWakil4;
    public TextView tvNamaWakil5;
    public TextView tvNamaWakil6;

    public ImageView ivFotoCalon1;
    public ImageView ivFotoCalon2;
    public ImageView ivFotoCalon3;
    public ImageView ivFotoCalon4;
    public ImageView ivFotoCalon5;
    public ImageView ivFotoCalon6;

    public ImageView ivFotoWakil1;
    public ImageView ivFotoWakil2;
    public ImageView ivFotoWakil3;
    public ImageView ivFotoWakil4;
    public ImageView ivFotoWakil5;
    public ImageView ivFotoWakil6;

    public TextView tvJmlPemilih1;
    public TextView tvJmlPemilih2;
    public TextView tvJmlPemilih3;
    public TextView tvJmlPemilih4;
    public TextView tvJmlPemilih5;
    public TextView tvJmlPemilih6;

    public ImageView ivFotoBukti;
    public TextView tvTglMulai;
    public TextView tvJamMulai;
    public TextView tvTglSelesai;
    public TextView tvJamSelesai;
    public TextView tvNamaSaksi;
    public TextView tvNamaGroup;
    public TextView tvJmlDownvote;
    public TextView tvJmlUpvote;

//    public TextView mDataTextView;

    /**
     * Public constructor for the custom child ViewHolder
     *
     * @param itemView the child ViewHolder's view
     */
    public CardTpsChildViewHolder(View itemView) {
        super(itemView);

        tvNamaCalon1 = (TextView) itemView.findViewById(R.id.tv_namaCalon1);
        tvNamaCalon2 = (TextView) itemView.findViewById(R.id.tv_namaCalon2);
        tvNamaCalon3 = (TextView) itemView.findViewById(R.id.tv_namaCalon3);
        tvNamaCalon4 = (TextView) itemView.findViewById(R.id.tv_namaCalon4);
        tvNamaCalon5 = (TextView) itemView.findViewById(R.id.tv_namaCalon5);
        tvNamaCalon6 = (TextView) itemView.findViewById(R.id.tv_namaCalon6);
        tvNamaWakil1 = (TextView) itemView.findViewById(R.id.tv_namaWakil1);
        tvNamaWakil2 = (TextView) itemView.findViewById(R.id.tv_namaWakil2);
        tvNamaWakil3 = (TextView) itemView.findViewById(R.id.tv_namaWakil3);
        tvNamaWakil4 = (TextView) itemView.findViewById(R.id.tv_namaWakil4);
        tvNamaWakil5 = (TextView) itemView.findViewById(R.id.tv_namaWakil5);
        tvNamaWakil6 = (TextView) itemView.findViewById(R.id.tv_namaWakil6);

        ivFotoCalon1 = (ImageView) itemView.findViewById(R.id.iv_fotoCalon1);
        ivFotoCalon2 = (ImageView) itemView.findViewById(R.id.iv_fotoCalon2);
        ivFotoCalon3 = (ImageView) itemView.findViewById(R.id.iv_fotoCalon3);
        ivFotoCalon4 = (ImageView) itemView.findViewById(R.id.iv_fotoCalon4);
        ivFotoCalon5 = (ImageView) itemView.findViewById(R.id.iv_fotoCalon5);
        ivFotoCalon6 = (ImageView) itemView.findViewById(R.id.iv_fotoCalon6);
        ivFotoWakil1 = (ImageView) itemView.findViewById(R.id.iv_fotoWakil1);
        ivFotoWakil2 = (ImageView) itemView.findViewById(R.id.iv_fotoWakil2);
        ivFotoWakil3 = (ImageView) itemView.findViewById(R.id.iv_fotoWakil3);
        ivFotoWakil4 = (ImageView) itemView.findViewById(R.id.iv_fotoWakil4);
        ivFotoWakil5 = (ImageView) itemView.findViewById(R.id.iv_fotoWakil5);
        ivFotoWakil6 = (ImageView) itemView.findViewById(R.id.iv_fotoWakil6);

        tvJmlPemilih1 = (TextView) itemView.findViewById(R.id.tv_jmlPemilih1);
        tvJmlPemilih2 = (TextView) itemView.findViewById(R.id.tv_jmlPemilih2);
        tvJmlPemilih3 = (TextView) itemView.findViewById(R.id.tv_jmlPemilih3);
        tvJmlPemilih4 = (TextView) itemView.findViewById(R.id.tv_jmlPemilih4);
        tvJmlPemilih5 = (TextView) itemView.findViewById(R.id.tv_jmlPemilih5);
        tvJmlPemilih6 = (TextView) itemView.findViewById(R.id.tv_jmlPemilih6);

        ivFotoBukti = (ImageView) itemView.findViewById(R.id.iv_fotoBukti);
        tvTglMulai = (TextView) itemView.findViewById(R.id.tv_tglMulai);
        tvJamMulai = (TextView) itemView.findViewById(R.id.tv_jamMulai);
        tvTglSelesai = (TextView) itemView.findViewById(R.id.tv_tglSelesai);
        tvJamSelesai = (TextView) itemView.findViewById(R.id.tv_jamSelesai);
        tvNamaSaksi = (TextView) itemView.findViewById(R.id.tv_namaSaksi);
        tvNamaGroup = (TextView) itemView.findViewById(R.id.tv_namaGroup);
        tvJmlDownvote = (TextView) itemView.findViewById(R.id.tv_jmlDownVote);
        tvJmlUpvote = (TextView) itemView.findViewById(R.id.tv_jmlUpVote);
//        mDataTextView = (TextView) itemView.findViewById(R.id.list_item_vertical_child_textView);
    }

    public void bind(int fotoCalon1, int fotoWakil1, String namaCalon1, String namaWakil1, String jmlPemilih1,
                     int fotoCalon2, int fotoWakil2, String namaCalon2, String namaWakil2, String jmlPemilih2,
                     int fotoCalon3, int fotoWakil3, String namaCalon3, String namaWakil3, String jmlPemilih3,
                     int fotoCalon4, int fotoWakil4, String namaCalon4, String namaWakil4, String jmlPemilih4,
                     int fotoCalon5, int fotoWakil5, String namaCalon5, String namaWakil5, String jmlPemilih5,
                     int fotoCalon6, int fotoWakil6, String namaCalon6, String namaWakil6, String jmlPemilih6,
                     int fotoBukti, String tglMulai, String jamMulai, String tglSelesai, String jamSelesai,
                     String namaSaksi, String namaGroup, String jmlDownvote, String jmlUpvote) {
        ivFotoCalon1.setImageResource(fotoCalon1);
        ivFotoCalon2.setImageResource(fotoCalon2);
        ivFotoCalon3.setImageResource(fotoCalon3);
        ivFotoCalon4.setImageResource(fotoCalon4);
        ivFotoCalon5.setImageResource(fotoCalon5);
        ivFotoCalon6.setImageResource(fotoCalon6);
        ivFotoWakil1.setImageResource(fotoWakil1);
        ivFotoWakil2.setImageResource(fotoWakil2);
        ivFotoWakil3.setImageResource(fotoWakil3);
        ivFotoWakil4.setImageResource(fotoWakil4);
        ivFotoWakil5.setImageResource(fotoWakil5);
        ivFotoWakil6.setImageResource(fotoWakil6);
        tvNamaCalon1.setText(namaCalon1);
        tvNamaCalon2.setText(namaCalon2);
        tvNamaCalon3.setText(namaCalon3);
        tvNamaCalon4.setText(namaCalon4);
        tvNamaCalon5.setText(namaCalon5);
        tvNamaCalon6.setText(namaCalon6);
        tvNamaWakil1.setText(namaWakil1);
        tvNamaWakil2.setText(namaWakil2);
        tvNamaWakil3.setText(namaWakil3);
        tvNamaWakil4.setText(namaWakil4);
        tvNamaWakil5.setText(namaWakil5);
        tvNamaWakil6.setText(namaWakil6);
        tvJmlPemilih1.setText(jmlPemilih1);
        tvJmlPemilih2.setText(jmlPemilih2);
        tvJmlPemilih3.setText(jmlPemilih3);
        tvJmlPemilih4.setText(jmlPemilih4);
        tvJmlPemilih5.setText(jmlPemilih5);
        tvJmlPemilih6.setText(jmlPemilih6);
        ivFotoBukti.setImageResource(fotoBukti);
        tvTglMulai.setText(tglMulai);
        tvJamMulai.setText(jamMulai);
        tvTglSelesai.setText(tglSelesai);
        tvJamSelesai.setText(jamSelesai);
        tvNamaSaksi.setText(namaSaksi);
        tvNamaGroup.setText(namaGroup);
        tvJmlDownvote.setText(jmlDownvote);
        tvJmlUpvote.setText(jmlUpvote);
    } //mDataTextView
}