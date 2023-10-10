package seedu.address.model.task;

import static seedu.address.commons.util.CollectionUtil.requireAllNonNull;

import java.util.Collections;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import seedu.address.commons.util.ToStringBuilder;
import seedu.address.model.tag.Tag;

public class Task {
    private final Name name;
    private final Mark mark;

    public Task(Name name, Mark mark) {
        requireAllNonNull(name, mark);
        this.name = name;
        this.mark = mark;
    }
}
