import java.util.Calendar;

/**
 * This file is a part of SmallOffice_9.1 project.
 *
 * @author Sarah Cynamon
 * @version 1.0.0
 */
public class Job {
    public static final int TYPE_REMINDER=0;
    public static final int TYPE_OTHER=1;

    public int type;
    public String description;
    public Calendar when;
    public boolean done;

    public Job( int type, String description, Calendar when) {
        this.type = type;
        this.description = description;
        this.when = when;
    }


    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Calendar getWhen() {
        return when;
    }

    public void setWhen(Calendar when) {
        this.when = when;
    }

    public boolean isDone() {
        return done;
    }

    public void setDone(boolean done) {
        this.done = done;
    }

    @Override
    public String toString() {
        return String.format ("Job{type=%d, description='%s', when=%s, done=%s}", type, description, when, done);
    }
}
