import java.util.Date;

public class Plan {
     private String date;
     private String task;

    public Plan(String date, String task) {
        this.date = date;
        this.task = task;
    }

    @Override
    public String toString() {
        return this.date + ":"+ this.task;
    }
}
