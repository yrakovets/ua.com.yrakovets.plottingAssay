package auxiliaryClasses;

/**
 * Created by Legatus on 20.03.2016.
 */
public class WorkingTimePeriod {
    private int value = 0;

    public WorkingTimePeriod(int value) {
        this.value = value;
    }

    public WorkingTimePeriod(WorkingTimePeriod copyWorkingTimePeriod, int quantity){
        this.value = copyWorkingTimePeriod.getValue() * quantity;
    }

    public WorkingTimePeriod(WorkingTimePeriod copyWorkingTimePeriod){
        this.value = copyWorkingTimePeriod.getValue();
    }

    public int getValue(){
        return value;
    }

    public WorkingTimePeriod min(WorkingTimePeriod valueForComparation) {
        return (this.getValue()<valueForComparation.getValue())?this:valueForComparation;
    }

    public void copyValue(WorkingTimePeriod workingTimePeriodForCopy) {
        this.value = workingTimePeriodForCopy.getValue();
    }

    public void substract(WorkingTimePeriod periodForSubstruct) {
        this.value = value - periodForSubstruct.getValue();
    }
}
