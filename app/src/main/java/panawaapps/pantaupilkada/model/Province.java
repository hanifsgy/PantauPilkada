package panawaapps.pantaupilkada.model;

import java.util.List;

/**
 * Created by ali on 16/11/15.
 */
public class Province {
    private String status;
    private List<Data> data;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<Data> getData() {
        return data;
    }

    public void setData(List<Data> data) {
        this.data = data;
    }
}
