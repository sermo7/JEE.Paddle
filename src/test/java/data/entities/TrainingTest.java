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
        //Calendar finishDate = startDate;
        //Training trainingTest = new Training (court, trainer, startDate, finishDate, null);
        Training trainingTest = new Training (court, trainer, startDate);
        //finishDate.add(Calendar.MINUTE, 60);
        //trainingTest.setFinishDate(finishDate);
        assertTrue(trainingTest.getCourt().getId()==court.getId());
        assertTrue(trainingTest.getTrainer().getId()==trainer.getId());
        //assertTrue(trainingTest.getPupils()==null);
        System.out.println(trainingTest.toString());
    }
    
}
