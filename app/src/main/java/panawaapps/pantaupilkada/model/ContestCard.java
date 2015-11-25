package panawaapps.pantaupilkada.model;

/**
 * Created by ali on 20/11/15.
 */
public class ContestCard {
    private String status;
    private DataCalons data;
    private Integer total;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public DataCalons getData() {
        return data;
    }

    public void setData(DataCalons data) {
        this.data = data;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }
}
