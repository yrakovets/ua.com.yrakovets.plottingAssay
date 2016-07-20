package essences;

import auxiliaryClasses.WorkingTime;
import auxiliaryClasses.WorkingTimePeriod;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Legatus on 20.03.2016.
 */
public class Work {
    Task task;
    List<SubWork> subWorks;
    WorkingTime end;

    public List<SubWork> getSubWorks() {
        return subWorks;
    }

    private static class Dependency{
        SubWork preceding;
        SubWork following;

        public Dependency(SubWork preceding, SubWork following){
            this.preceding = preceding;
            this.following = following;
        }
    }

    List<Dependency> dependencies = new ArrayList<Dependency>();

    public Work(Task task, WorkingTime endTime, Technology technology){
        this.task = task;
        this.end = endTime;
        subWorks = new ArrayList<SubWork>();
        construct(technology, subWorks, dependencies, task);
        calcReserves(subWorks, endTime, dependencies);
    }

    private static void calcReserves(List<SubWork> subWorks, WorkingTime endTime, List<Dependency> dependencies) {
        int count = subWorks.size();
        for(int i=0; i<count;){
            outer: //
            for(SubWork subWork : subWorks){
                //the subWork has calculated reserve
                if(subWork.getReserve() != null){
                    continue;
                }

                //the subWork has following subWork without calculated reserve
                for(Dependency dependency: dependencies){
                    if((dependency.preceding == subWork) & (dependency.following.getReserve() == null)){
                        continue outer;
                    }
                }

                WorkingTimePeriod minReserve = new WorkingTimePeriod(endTime.substract(new WorkingTime(0)).getValue());
                for(Dependency dependency: dependencies){
                    if(dependency.preceding == subWork){
                        minReserve.copyValue(minReserve.min(dependency.following.getReserve()));

                    }
                }
                minReserve.substract(subWork.getDuration());
                subWork.setReserve(minReserve);
                i++;
            }
        }
    }

    //fill dependecies and subWorks
    private static void construct(Technology technology, List<SubWork> subworks, List<Dependency> dependencies, Task task) {
        Map<Stage, SubWork> stageSubWorkReferences = new HashMap<Stage, SubWork>();
        for(Stage stage: technology.getStages()){
            SubWork subWork = new SubWork(stage.workplace, new WorkingTimePeriod(stage.duration, task.getQuantity()));
            subworks.add(subWork);
            stageSubWorkReferences.put(stage, subWork);
            for(Stage prev: stage.previous){
                dependencies.add(new Dependency(stageSubWorkReferences.get(prev), subWork));
            }
        }

    }
}
