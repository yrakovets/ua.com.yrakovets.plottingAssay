package given;

import auxiliaryClasses.WorkingTimePeriod;
import essences.*;

import java.util.*;

/**
 * Created by Legatus on 22.03.2016.
 */
public class GivenForTest {

    public static Map<Product, Technology> technologiesCaseWithoutCross(){
        //I'll make first primitive case
        // PRODUCT1B
        //      at MACHINE1 3
        //      then at WORKSHOP 2
        //
        // PRODUCT1A
        //      at WORKSHOP 2
        //      then at MACHINE2 1

        Map<Product, Technology> map = new HashMap<Product, Technology>();

        final Stage stage01 = new Stage(Workplace.MACHINE1, new WorkingTimePeriod(3));
        final Stage stage02 = new Stage(Workplace.WORKSHOP, new WorkingTimePeriod(2), new ArrayList<Stage>(){{add(stage01);}});

        Technology technology0 = new Technology(Product.PRODUCT1B);
        technology0.setStages(new ArrayList<Stage>(){{
            add(stage01);
            add(stage02);
        }});

        final Stage stage11 = new Stage(Workplace.WORKSHOP, new WorkingTimePeriod(2));
        final Stage stage12 = new Stage(Workplace.MACHINE2, new WorkingTimePeriod(1), new ArrayList<Stage>(){{add(stage11);}});

        Technology technology1 = new Technology(Product.PRODUCT1A);
        technology1.setStages(new ArrayList<Stage>(){{
            add(stage11);
            add(stage12);
        }});

        map.put(Product.PRODUCT1B, technology0);
        map.put(Product.PRODUCT1A, technology1);

        return map;
    }

    public static List<Task> tasksCaseWithoutCross(){
        return new ArrayList<Task>(Arrays.asList(new Task(Product.PRODUCT1B, 3, 50), new Task(Product.PRODUCT1A, 3, 50)));
    }

    public static Map<Product, Technology> technologiesCaseWithCross(){
        // PRODUCT1B
        //      at MACHINE1 2
        //      then at WORKSHOP 2
        //
        // PRODUCT1A
        //      at WORKSHOP 3
        //      then at MACHINE2 1

        Map<Product, Technology> map = new HashMap<Product, Technology>();

        final Stage stage01 = new Stage(Workplace.MACHINE1, new WorkingTimePeriod(2));
        final Stage stage02 = new Stage(Workplace.WORKSHOP, new WorkingTimePeriod(2), new ArrayList<Stage>(){{add(stage01);}});

        Technology technology0 = new Technology(Product.PRODUCT1B);
        technology0.setStages(new ArrayList<Stage>(){{
            add(stage01);
            add(stage02);
        }});

        final Stage stage11 = new Stage(Workplace.WORKSHOP, new WorkingTimePeriod(3));
        final Stage stage12 = new Stage(Workplace.MACHINE2, new WorkingTimePeriod(1), new ArrayList<Stage>(){{add(stage11);}});

        Technology technology1 = new Technology(Product.PRODUCT1A);
        technology1.setStages(new ArrayList<Stage>(){{
            add(stage11);
            add(stage12);
        }});

        map.put(Product.PRODUCT1B, technology0);
        map.put(Product.PRODUCT1A, technology1);

        return map;
    }

    public static List<Task> tasksCaseWithCross(){
        return new ArrayList<Task>(Arrays.asList(new Task(Product.PRODUCT1B, 3, 50), new Task(Product.PRODUCT1A, 3, 50)));
    }


}
