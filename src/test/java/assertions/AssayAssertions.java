package assertions;

import essences.Work;

import java.util.List;

import static org.junit.Assert.assertFalse;

/**
 * Created by Legatus on 23.03.2016.
 */
public class AssayAssertions {
    public static void assertAssayIsConstructed(List<Work> works){
        assertFalse(works.isEmpty());
    }

    public static void assertAssayIsSequential(List<Work> works) throws Exception {
        throw new Exception();
    }

    public static void assertAssayIsConsistent(List<Work> works) throws Exception {
        throw new Exception();
    }
}
