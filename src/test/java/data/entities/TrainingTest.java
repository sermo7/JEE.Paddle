package data.entities;

import static org.junit.Assert.assertTrue;

import java.util.Calendar;

import org.junit.Test;

public class TrainingTest {

    @Test
    public void testTraining() {
        User trainer = new User("trainer", "trainer@gmail.com", "p", Calendar.getInstance());
        Court court = new Court();
        Calendar startDate = Calendar.getInstance();
        Training trainingTest = new Training (court, trainer, startDate);
        assertTrue(trainingTest.getCourt().getId()==court.getId());
        assertTrue(trainingTest.getTrainer().getId()==trainer.getId());
        System.out.println(trainingTest.toString());
    }
    
}
