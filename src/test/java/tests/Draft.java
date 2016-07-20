package tests;

import main.Assay;
import org.junit.Test;

import static assertions.AssayAssertions.assertAssayIsConstructed;
import static given.GivenForTest.tasksCaseWithoutCross;
import static given.GivenForTest.technologiesCaseWithoutCross;

/**
 * Created by Legatus on 19.07.2016.
 */
public class Draft {

    @Test
    public void draft1(){

        Assay assay = new Assay();
        assay.setTasks(tasksCaseWithoutCross());
        assay.setTechnologyMap(technologiesCaseWithoutCross());
        assay.plote();

        assertAssayIsConstructed(assay.getWorks());

    }

}
