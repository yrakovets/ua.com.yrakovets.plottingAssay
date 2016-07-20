package essences;

import java.util.List;

/**
 * Created by Legatus on 20.03.2016.
 */
public class Technology {
    public Technology(Product product){
        this.product = product;
    }

    Product product;
    List<Stage> stages;

    public void setStages(List<Stage> stages){
        this.stages =stages;
    }

    public List<Stage> getStages(){
        return stages;
    }
}
