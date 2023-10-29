package seedu.address.ui;

import java.util.Comparator;
import java.util.Set;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Region;
import seedu.address.model.tag.Member;
import seedu.address.model.task.Task;

/**
 * An UI component that displays information of a {@code Task}.
 */
public class TaskCard extends UiPart<Region> {

    private static final String FXML = "TaskListCard.fxml";

    /**
     * Note: Certain keywords such as "location" and "resources" are reserved keywords in JavaFX.
     * As a consequence, UI elements' variable names cannot be set to such keywords
     * or an exception will be thrown by JavaFX during runtime.
     *
     * @see <a href="https://github.com/se-edu/addressbook-level4/issues/336">The issue on TaskWise level 4</a>
     */

    public final Task task;

    @FXML
    private GridPane cardPane;
    @FXML
    private Label description;
    @FXML
    private Label id;
    @FXML
    private Label status;
    @FXML
    private Label deadline;
    @FXML
    private Label note;
    @FXML
    private Label defaultPriority;
    @FXML
    private Label lowPriority;
    @FXML
    private Label mediumPriority;
    @FXML
    private Label highPriority;
    @FXML
    private FlowPane members;

    /**
     * Creates a {@code TaskCode} with the given {@code Task} and index to display.
     */
    public TaskCard(Task task, int displayedIndex) {
        super(FXML);
        this.task = task;
        id.setText(displayedIndex + ". ");
        description.setText(task.getDescription().fullDescription);
        status.setText(task.getStatus().toString());
        note.setText(task.getNote().fullNote);
        setPriority(task.getPriority().toString());
        deadline.setText(task.getDeadline().toString());
        setMembers(task.getMembers());
    }
    public void setPriority(String priorityText) {
        switch (priorityText.toLowerCase()) {
        case "low":
            lowPriority.setVisible(true);
            lowPriority.setManaged(true);
            lowPriority.setText(priorityText);
            break;
        case "medium":
            mediumPriority.setVisible(true);
            mediumPriority.setManaged(true);
            mediumPriority.setText(priorityText);
            break;
        case "high":
            highPriority.setVisible(true);
            highPriority.setManaged(true);
            highPriority.setText(priorityText);
            break;
        default:
            defaultPriority.setVisible(true);
            defaultPriority.setManaged(true);
            defaultPriority.setText(priorityText);
        }
    }

    private void setMembers(Set<Member> source) {
        if (source == null || source.isEmpty()) {
            return;
        }

        source.stream()
                .sorted(Comparator.comparing(member -> member.memberName))
                .forEach(member -> members.getChildren().add(new Label(member.memberName)));
        members.setHgap(5.00);

        members.getChildren().forEach(label -> label.getStyleClass().add("member_cell_label"));
    }

}
