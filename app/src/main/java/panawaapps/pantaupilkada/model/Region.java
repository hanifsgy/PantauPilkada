package panawaapps.pantaupilkada.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ali on 19/11/15.
 */
public class Region {
    private String status;
    private List<RegionData> data = new ArrayList<RegionData>();

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<RegionData> getData() {
        return data;
    }

    public void setData(List<RegionData> data) {
        this.data = data;
    }
}
