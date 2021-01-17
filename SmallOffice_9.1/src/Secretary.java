import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

/**
 * This file is a part of SmallOffice_9.1 project.
 *
 * @author Sarah Cynamon
 * @version 1.0.0
 */
public class Secretary implements Runnable {
    public OnJobNotifyListener listener;
    public List<Job> jobs;
    public boolean working;

    public Secretary() {
        jobs = new ArrayList<> ();
        working = false;

    }

    public void add(Job job) {
        jobs.add (job);
    }

    private void completeJob(Job job) {
        job.setDone (true);
        System.out.printf ("The job \"%s\" was done!\n", job.getDescription ());
    }

    private void notifyListener(Job job) {
        if (listener != null) {
            listener.onJobNotify (job);
        }
    }

    private List<Job> getJobsNotDone() {
        List<Job> notDoneJobs = new ArrayList<> ();
        for (Job job : jobs) {
            if (!job.isDone ()) {
                notDoneJobs.add (job);
            }
        }
        return notDoneJobs;
    }

    public void stop() {
        setWorking (false);
    }

    public void run() {
        while (working) {
            Calendar now = Calendar.getInstance ();
            List<Job> notDoneJobs = getJobsNotDone ();
            for (Job job : notDoneJobs) {
                if (now.after (job.getWhen ())) {
                    if (job.getType () == Job.TYPE_REMINDER) {
                        notifyListener (job);
                    } else {
                        completeJob (job);
                    }
                    job.setDone (true);
                }

            }
        }
    }


    public OnJobNotifyListener getListener() {
        return listener;
    }

    public void setListener(OnJobNotifyListener listener) {
        this.listener = listener;
    }

    public List<Job> getJobs() {
        return jobs;
    }

    public void setJobs(List<Job> jobs) {
        this.jobs = jobs;
    }

    public boolean isWorking() {
        return working;
    }

    public void setWorking(boolean working) {
        this.working = working;
    }
}
