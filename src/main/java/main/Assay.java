package main;

import essences.Product;
import essences.Task;
import essences.Technology;
import essences.Work;

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
