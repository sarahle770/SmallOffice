/**
 * This file is a part of SmallOffice_9.1 project.
 *
 * @author Sarah Cynamon
 * @version 1.0.0
 */
public class Boss implements OnJobNotifyListener {
    public Secretary secretary;

    public Boss(Secretary secretary) {
        secretary.setListener (this);
        this.secretary = secretary;
    }

    public void add(Job job) {
        secretary.add (job);
    }

    public void start() {
        secretary.setWorking (true);
        Thread thread = new Thread (secretary);
        thread.start ();
    }

    public void stop() {
        secretary.setWorking (false);
    }

    @Override
    public void onJobNotify(Job job) {
        System.out.printf ("Thanks for reminding me about \"%s\"\n", job.getDescription ());
    }
}
