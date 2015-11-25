package panawaapps.pantaupilkada.model;


import panawaapps.pantaupilkada.interfaces.ParentListItem;

import java.util.List;

/**
 * Custom parent list item that holds a string and an int for displaying data in the parent item. You
 * can use any Object here as long as it implements ParentListItem and sets the list to a private
 * variable.
 *
 * @author Ryan Brooks
 * @version 1.0
 * @since 5/27/2015
 */
public class CardTpsParent implements ParentListItem {

    private List<ChildViewHolder> mChildItemList;

    private String daerahCardKontestan, jmlTps, noTps, idTps, peranUser, statusPengawasan, jmlTerawasi, jmlSaksi;

//    private String mParentText;
//    private int mParentNumber;
    private boolean mInitiallyExpanded;


    public List<ChildViewHolder> getmChildItemList() {
        return mChildItemList;
    }

    public void setmChildItemList(List<ChildViewHolder> mChildItemList) {
        this.mChildItemList = mChildItemList;
    }

    public String getDaerahCardKontestan() {
        return daerahCardKontestan;
    }

    public void setDaerahCardKontestan(String daerahCardKontestan) {
        this.daerahCardKontestan = daerahCardKontestan;
    }

    public String getJmlTps() {
        return jmlTps;
    }

    public void setJmlTps(String jmlTps) {
        this.jmlTps = jmlTps;
    }

    public String getNoTps() {
        return noTps;
    }

    public void setNoTps(String noTps) {
        this.noTps = noTps;
    }

    public String getIdTps() {
        return idTps;
    }

    public void setIdTps(String idTps) {
        this.idTps = idTps;
    }

    public String getPeranUser() {
        return peranUser;
    }

    public void setPeranUser(String peranUser) {
        this.peranUser = peranUser;
    }

    public String getStatusPengawasan() {
        return statusPengawasan;
    }

    public void setStatusPengawasan(String statusPengawasan) {
        this.statusPengawasan = statusPengawasan;
    }

    public String getJmlTerawasi() {
        return jmlTerawasi;
    }

    public void setJmlTerawasi(String jmlTerawasi) {
        this.jmlTerawasi = jmlTerawasi;
    }

    public String getJmlSaksi() {
        return jmlSaksi;
    }

    public void setJmlSaksi(String jmlSaksi) {
        this.jmlSaksi = jmlSaksi;
    }

    public boolean ismInitiallyExpanded() {
        return mInitiallyExpanded;
    }

    public void setmInitiallyExpanded(boolean mInitiallyExpanded) {
        this.mInitiallyExpanded = mInitiallyExpanded;
    }

    /**
     * Getter method for the list of children associated with this parent list item
     *
     * @return list of all children associated with this specific parent list item
     */
    @Override
    public List<ChildViewHolder> getChildItemList() {
        return mChildItemList;
    }

    /**
     * Setter method for the list of children associated with this parent list item
     *
     * @param childItemList the list of all children associated with this parent list item
     */
    public void setChildItemList(List<ChildViewHolder> childItemList) {
        mChildItemList = childItemList;
    }

    @Override
    public boolean isInitiallyExpanded() {
        return mInitiallyExpanded;
    }

    public void setInitiallyExpanded(boolean initiallyExpanded) {
        mInitiallyExpanded = initiallyExpanded;
    }
}
