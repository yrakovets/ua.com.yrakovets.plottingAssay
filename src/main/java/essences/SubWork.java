package essences;

import auxiliaryClasses.WorkingTime;
import auxiliaryClasses.WorkingTimePeriod;

/**
 * Created by Legatus on 20.03.2016.
 */
public class SubWork {
    public Workplace workplace;
    public WorkingTime start;
    public WorkingTimePeriod duration;
    public WorkingTime end;
    public WorkingTimePeriod reserve;

    private boolean active = false;

    public SubWork(Workplace workplace, WorkingTimePeriod duration){
        this.workplace = workplace;
        this.duration = duration;
    }

    public WorkingTimePeriod getReserve(){
        return reserve;
    }

    public void setReserve(WorkingTimePeriod reserve){
        this.reserve = reserve;
    }

    public void setStart(WorkingTime start){
        this.start = start;
        this.end = (new WorkingTime(start)).add(duration);
        active = true;
    }

    public boolean isActive(){
        return active;
    }


    public WorkingTimePeriod getDuration() {
        return duration;
    }
}


