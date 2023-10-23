package seedu.address.model.task;

public class DeadlineTask extends Task {

    public DeadlineTask(Description description, Status status, Deadline deadline) {
        super(description, status, deadline);
    }

    @Override
    public Task createNewInstance(Task oldTask) {
        return new DeadlineTask(oldTask.getDescription(),
                oldTask.getStatus(), oldTask.getDeadline());
    }
}
