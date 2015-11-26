package panawaapps.pantaupilkada.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import panawaapps.pantaupilkada.R;
import panawaapps.pantaupilkada.interfaces.ParentListItem;
import panawaapps.pantaupilkada.model.ChildViewHolder;
import panawaapps.pantaupilkada.model.CardTpsParent;

import java.util.List;

/**
 * An example custom implementation of the ExpandableRecyclerAdapter.
 *
 * @author Ryan Brooks
 * @version 1.0
 * @since 5/27/2015
 */
public class TpsCardAdapter extends ExpandableRecyclerAdapter<CardTpsParentViewHolder, CardTpsChildViewHolder> {

    private LayoutInflater mInflater;

    /**
     * Public primary constructor.
     *
     * @param parentItemList the list of parent items to be displayed in the RecyclerView
     */
    public TpsCardAdapter(Context context, List<? extends ParentListItem> parentItemList) {
        super(parentItemList);
        mInflater = LayoutInflater.from(context);
    }

    /**
     * OnCreateViewHolder implementation for parent items. The desired ParentViewHolder should
     * be inflated here
     *
     * @param parent for inflating the View
     * @return the user's custom parent ViewHolder that must extend ParentViewHolder
     */
    @Override
    public CardTpsParentViewHolder onCreateParentViewHolder(ViewGroup parent) {
        View view = mInflater.inflate(R.layout.card_parent_tps_pengawas, parent, false); //list_item_parent_vertical
        return new CardTpsParentViewHolder(view);
    }

    /**
     * OnCreateViewHolder implementation for child items. The desired ChildViewHolder should
     * be inflated here
     *
     * @param parent for inflating the View
     * @return the user's custom parent ViewHolder that must extend ParentViewHolder
     */
    @Override
    public CardTpsChildViewHolder onCreateChildViewHolder(ViewGroup parent) {
        View view = mInflater.inflate(R.layout.card_child_pengawas, parent, false); //list_item_child_vertical
        return new CardTpsChildViewHolder(view);
    }

    /**
     * OnBindViewHolder implementation for parent items. Any data or view modifications of the
     * parent view should be performed here.
     *
     * @param tpsParentViewHolder the ViewHolder of the parent item created in OnCreateParentViewHolder
     * @param position the position in the RecyclerView of the item
     */
    @Override
    public void onBindParentViewHolder(CardTpsParentViewHolder tpsParentViewHolder, int position, ParentListItem parentListItem) {
        CardTpsParent cardTpsParent = (CardTpsParent) parentListItem;
        tpsParentViewHolder.bind(cardTpsParent.getDaerahCardKontestan(), cardTpsParent.getJmlTps(), cardTpsParent.getNoTps(), cardTpsParent.getIdTps(), cardTpsParent.getPeranUser(),
                cardTpsParent.getStatusPengawasan(), cardTpsParent.getJmlTerawasi(), cardTpsParent.getJmlSaksi()); //cardTPSParent.getParentNumber(), cardTPSParent.getParentText()
    }

    /**
     * OnBindViewHolder implementation for child items. Any data or view modifications of the
     * child view should be performed here.
     *
     * @param childViewHolder the ViewHolder of the child item created in OnCreateChildViewHolder
     * @param position the position in the RecyclerView of the item
     */
    @Override
    public void onBindChildViewHolder(CardTpsChildViewHolder childViewHolder, int position, Object childListItem) {
        ChildViewHolder verticalChild = (ChildViewHolder) childListItem;
        childViewHolder.bind(verticalChild.getFotoCalon1(), verticalChild.getFotoWakil1(), verticalChild.getNamaCalon1(), verticalChild.getNamaWakil1(), verticalChild.getJmlPemilih1(),
                             verticalChild.getFotoCalon2(), verticalChild.getFotoWakil2(), verticalChild.getNamaCalon2(), verticalChild.getNamaWakil2(), verticalChild.getJmlPemilih2(),
                             verticalChild.getFotoCalon3(), verticalChild.getFotoWakil3(), verticalChild.getNamaCalon3(), verticalChild.getNamaWakil3(), verticalChild.getJmlPemilih3(),
                             verticalChild.getFotoCalon4(), verticalChild.getFotoWakil4(), verticalChild.getNamaCalon4(), verticalChild.getNamaWakil4(), verticalChild.getJmlPemilih4(),
                             verticalChild.getFotoCalon5(), verticalChild.getFotoWakil5(), verticalChild.getNamaCalon5(), verticalChild.getNamaWakil5(), verticalChild.getJmlPemilih5(),
                             verticalChild.getFotoCalon6(), verticalChild.getFotoWakil6(), verticalChild.getNamaCalon6(), verticalChild.getNamaWakil6(), verticalChild.getJmlPemilih6(),
                             verticalChild.getFotoBukti(), verticalChild.getTglMulai(), verticalChild.getJamMulai(), verticalChild.getTglSelesai(), verticalChild.getJamSelesai(),
                             verticalChild.getNamaSaksi(), verticalChild.getNamaGrupSaksi(), verticalChild.getJmlDownVote(), verticalChild.getJmlUpvote());
    }
}