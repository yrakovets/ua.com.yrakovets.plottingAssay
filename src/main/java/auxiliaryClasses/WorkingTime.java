package auxiliaryClasses;

/**
 * Created by Legatus on 20.03.2016.
 */
public class WorkingTime {
    private int value;

    public WorkingTime(int value){
        this.value =value;
    }

    public WorkingTime(WorkingTime copyWorkingTime){
        this.value = copyWorkingTime.getValue();
    }

    public int getValue() {
        return value;
    }

    public WorkingTime add(WorkingTimePeriod duration){
        this.value = this.value + duration.getValue();
        return this;
    }

    public WorkingTimePeriod substract(WorkingTime timeToSubstruct) {
        return new WorkingTimePeriod(this.getValue() - timeToSubstruct.getValue());
    }
}
