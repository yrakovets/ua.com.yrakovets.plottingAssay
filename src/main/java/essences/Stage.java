package essences;

import auxiliaryClasses.WorkingTimePeriod;

import java.util.List;

/**
 * Created by Legatus on 20.03.2016.
 */
public class Stage {
    public Stage(Workplace workplace, WorkingTimePeriod duration){
        this.workplace = workplace;
        this.duration = duration;
    }

    public Stage(Workplace workplace, WorkingTimePeriod duration, List<Stage> previous){
        this.workplace = workplace;
        this.duration = duration;
        this.previous = previous;
    }

    public List<Stage> previous;
    public WorkingTimePeriod duration;
    public Workplace workplace;
}
