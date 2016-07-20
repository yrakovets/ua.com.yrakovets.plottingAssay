package main;

import essences.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by Legatus on 23.03.2016.
 */
public class Assay {
    private Map<Product,Technology> technologyMap;
    private List<Task> tasks;
    private List<Work> works;


    public void plote(){
        works = buildWorks();
        constructAssay(works);
    }

    private void constructAssay(List<Work> works) {
        List<SubWork> subWorks = getAllSubWorks(works);
        
    }

    private List<SubWork> getAllSubWorks(List<Work> works) {
        List<SubWork> subWorks = new ArrayList<SubWork>();
        for(Work work: works){
            subWorks.addAll(work.getSubWorks());
        }
        return subWorks;
    }

    private List<Work> buildWorks() {
        List<Work> works = new ArrayList<Work>();
        for(Task task: tasks){
            works.add(new Work(task, task.getEndTime(), technologyMap.get(task.getProduct())));
        }
        return works;
    }

    public List<Work> getWorks(){
        return works;
    }

    public void setTechnologyMap(Map<Product,Technology> technologyMap){
        this.technologyMap = technologyMap;
    }

    public void setTasks(List<Task> tasks){
        this.tasks = tasks;
    }
}
