package essences;

import auxiliaryClasses.WorkingTime;

/**
 * Created by Legatus on 20.03.2016.
 */
public class Task {
    public Task(Product product, Integer quantity, Integer endTime){
        this.product = product;
        this.quantity = quantity;
        this.endTime = new WorkingTime(endTime);
    }

    Product product;
    Integer quantity;
    WorkingTime endTime;
}
