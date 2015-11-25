package panawaapps.pantaupilkada.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ali on 21/11/15.
 */
public class TPSCardModel {
    public String status;
    public List<DataTPS> data = new ArrayList<DataTPS>();
    public Integer total;
    public Integer page;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<DataTPS> getData() {
        return data;
    }

    public void setData(List<DataTPS> data) {
        this.data = data;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }
}
