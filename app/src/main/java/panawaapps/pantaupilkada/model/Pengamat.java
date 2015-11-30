package panawaapps.pantaupilkada.model;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class Pengamat {

    public Pengamat() {
        candidatesList = new ArrayList<>();
    }

    public String status;

    @SerializedName("data")
    public ArrayList<ArrayList<Candidate>> candidatesList;

    public String total;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public ArrayList<ArrayList<Candidate>> getCandidatesList() {
        return candidatesList;
    }

    public void setCandidatesList(ArrayList<ArrayList<Candidate>> candidatesList) {
        this.candidatesList = candidatesList;
    }

    public ArrayList<Candidate> getCandidatesList(int pos) {
        return candidatesList.get(pos);
    }

    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
    }

    public int size() {
        return candidatesList.size();
    }
}