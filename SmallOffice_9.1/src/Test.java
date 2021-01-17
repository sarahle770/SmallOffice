import java.util.Calendar;

/**
 * This file is a part of SmallOffice_9.1 project.
 *
 * @author Sarah Cynamon
 * @version 1.0.0
 */
public class Test {
    public static void main(String[] args) {
        try {
            Boss boss = new Boss (new Secretary ());

            Calendar in5Seconds = Calendar.getInstance ();
            in5Seconds.add (Calendar.SECOND, 5);

            Calendar in10Seconds = Calendar.getInstance ();
            in5Seconds.add (Calendar.SECOND, 10);

            Calendar in15Seconds = Calendar.getInstance ();
            in5Seconds.add (Calendar.SECOND, 15);

            boss.add (new Job (Job.TYPE_OTHER, "Call mom", in10Seconds));
            boss.add (new Job (Job.TYPE_REMINDER, "Remind me to meet Sarah", in5Seconds));


            boss.start ();
            Thread.sleep (10_000);

            boss.add (new Job (Job.TYPE_REMINDER, "Remind me call Sarah", in15Seconds));

            Thread.sleep (5_000);

            boss.stop ();
        } catch (InterruptedException e) {
            e.printStackTrace ();
        }
    }
}
