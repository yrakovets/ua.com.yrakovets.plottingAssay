package tests;

import main.Assay;
import org.junit.Test;

import static assertions.AssayAssertions.assertAssayIsConstructed;
import static given.GivenForTest.tasksCaseWithoutCross;
import static given.GivenForTest.technologiesCaseWithoutCross;

/**
 * Created by Legatus on 23.03.2016.
 */
public class SimpleTest {

    @Test
    public void testWithoutCross(){
        Assay assay = new Assay();
        assay.setTasks(tasksCaseWithoutCross());
        assay.setTechnologyMap(technologiesCaseWithoutCross());
        assay.plote();

        assertAssayIsConstructed(assay.getWorks());

    }
}
