# Developer Guide

Welcome to the TaskWise Developer Guide!

## Content

- [Acknowledgements](#acknowledgements)
- [Introduction](#introduction)
- [Getting Started](#getting-started)
- [Design](#design)
- [Implementation](#implementation)
- [Documentation, Logging, Testing, Configuration and DevOps](#documentation-logging-testing-configuration-and-devops)
- [Appendix: Requirements](#appendix-requirements)
    - [Product Scope](#product-scope)
        - [Value Proposition](#Value-Proposition)
        - [Target Audience](#Target-Audience)
    - [User Stories](#user-stories)
    - [Use Cases](#use-cases)
    - [Non-Functional Requirements](#non-functional-requirements)
    - [Glossary](#glossary)
- [Appendix: Instruction for Manual Testing](#appendix-instruction-for-manual-testing)

# Acknowledgements

No acknowledgements.

# Introduction

Welcome to the TaskWise Developer Guide!

Through this guide you will learn more about the vision behind TaskWise, how TaskWise was built and how you as a
Developer can use TaskWise and build upon it!

# Getting Started

Work in Progress...

# Design

### UI component

The **API** of this component is specified in [`Ui.java`](https://github.com/AY2324S1-CS2103T-T17-1/tp/tree/master/src/main/java/seedu/address/ui/Ui.java)

![Structure of the UI Component](./images/UiClassDiagram.png)

The UI consists of a `MainWindow` that is made up of parts e.g.`CommandBox`, `ResultDisplay`, `TaskListPanel`, `StatusBarFooter` etc. All these, including the `MainWindow`, inherit from the abstract `UiPart` class which captures the commonalities between classes that represent parts of the visible GUI.

The `UI` component uses the JavaFx UI framework. The layout of these UI parts are defined in matching `.fxml` files that are in the `src/main/resources/view` folder. For example, the layout of the [`MainWindow`](https://github.com/AY2324S1-CS2103T-T17-1/tp/tree/master/src/main/java/seedu/address/ui/MainWindow.java) is specified in [`MainWindow.fxml`](https://github.com/AY2324S1-CS2103T-T17-1/tp/tree/master/src/main/resources/view/MainWindow.fxml)

The `UI` component,

* executes user commands using the `Logic` component.
* listens for changes to `Model` data so that the UI can be updated with the modified data.
* keeps a reference to the `Logic` component, because the `UI` relies on the `Logic` to execute commands.
* depends on some classes in the `Model` component, as it displays `Task` objects residing in the `Model`.

### Model component

Included inside the Task model are the following attributes:
* Description
* Status
    * Encapsulates a boolean attribute indicating the completion status of the task containing that status instance.
* Deadline
    * Encapsulates a LocalDateTime object as an attribute, indicating a certain deadline for the task the Deadline
is associated with.
* Note
* Assignees
    * A set of assignee instances, each encapsulating the name of the respective members assigned to the task.
* Priority

# Implementation
This section describes some noteworthy details on how certain features are implemented.

## Mark/Unmark Command
The mark/unmark mechanism is done through the `MarkCommand` and `UnmarkCommand` classes respectively.
They both implement the `Command` interface.

### Mark Command
When a user inputs a `mark` command, the Logic class passes it on to the `TaskWiseParser` object. 
This object then in turn creates a `MarkCommandParser`, as the command received is a `mark` command.  
The newly created `MarkCommandParser` then parses the incoming command and creates a `MarkCommand` object.
This newly created `MarkCommand` is then executed by `LogicManager`. The command can modify and change the `Model`  
currently inside TaskWise to change its contents.  
Lastly, the result of the execution of the `MarkCommand` is encapsulated as a `CommandResult` object that is returned
from `Logic`.  

We implemented the `mark` command this way as we wanted to preserve the original architecture that was present in
AddressBook3. Furthermore, by separating the `mark` command into multiple steps, involving multiple components
that all handle different responsibilities, we believe that it satisfies the Single Responsibility principle.

Given below is the sequence diagram from when a user enters a `mark` command.

![Mark Sequence Diagram](./images/MarkSequenceDiagram.png)

Alternatives Considered:
Instead of having multiple components, we could have just had one `MarkCommand` class and have that class
be in charge of handling everything, from parsing the inputs from the user to modifying the model when the command
is executed. However, we did not proceed with that plan, as doing so would create a `MarkCommand` class that
would have multiple responsibilities, which may lead to the singular `MarkCommand` class requiring multiple changes
when different, separate requirements change.

### Unmark Command
When a user inputs an `unmark` command, the Logic class passes it on to the `TaskWiseParser` object.
This object then in turn creates a `UnmarkCommandParser`, as the command received is a `unmark` command.  
The newly created `UnmarkCommandParser` then parses the incoming command and creates a `UnmarkCommand` object.
This newly created `UnmarkCommand` is then executed by `LogicManager`. The command can modify and change the `Model`  
currently inside TaskWise to change its contents.  
Lastly, the result of the execution of the `UnmarkCommand` is encapsulated as a `CommandResult` object that is returned
from `Logic`.

We implemented the `unmark` command this way as we wanted to preserve the original architecture that was present in
AddressBook3. Furthermore, by separating the `unmark` command into multiple steps, involving multiple components
that all handle different responsibilities, we believe that it satisfies the Single Responsibility principle.

Given below is the sequence diagram from when a user enters a `unmark` command.

![Mark Sequence Diagram](./images/MarkSequenceDiagram.png)

Alternatives Considered:
Instead of having multiple components, we could have just had one `UnmarkCommand` class and have that class
be in charge of handling everything, from parsing the inputs from the user to modifying the model when the command
is executed. However, we did not proceed with that plan, as doing so would create a `UnmarkCommand` class that
would have multiple responsibilities, which may lead to the singular `UnmarkCommand` class requiring multiple changes
when different, separate requirements change.

## Edit Command

### Adding Deadlines to existing Tasks

# Documentation, Logging, Testing, Configuration and DevOps

Work in Progress...

# Appendix: Requirements

## Product Scope

### Value Proposition

Provide the project manager of a CS2103T group a fast and intuitive CLI to manage their team project, by providing them
a platform to manage different deadlines for different tasks, allowing them to be more on task and keep up with
deadlines within one project.

### Target Audience

Our target audience of this application are Project Managers of CS2103T Group Projects.

## User Stories

| Priority           | As a ...               | I want to ...                                                               | So that I can...                                     |
| ------------------ | ---------------------- | --------------------------------------------------------------------------- | ---------------------------------------------------- |
| :star::star::star: | user                   | be able to add tasks to my list of tasks                                    | so that tasks can be tracked                         |
| :star::star::star: | project manager        | be able to delete tasks from my list of tasks                               | remove tasks that are completed or wrongly added     |
| :star::star::star: | project manager        | be able to view all my tasks                                                | get a high level overview of what needs to be done   |
| :star::star::star: | project manager        | be able to mark tasks that were unmarked                                    | update the progress of the task                      |
| :star::star::star: | clumsy project manager | be able to unmark tasks that were marked in case I accidentally marked them | I can undo my mistake                                |
| :star::star::star: | forgetful manager      | be told that I have entered an invalid command                              | so that I know that the command I entered is invalid |

{More to be added soon}

## Use Cases

### UC01: Add a task

Actor(s): Project Manager  
Guarantees:

* A task is added into the system list of tasks.

**MSS**

1. User inputs command to add a task.
2. System adds the task into list of task and <u>[displays the updated task list (UC03)](#UC03-View-all-tasks)</u>.

Use case ends.

**Extensions:**
1a. User enters an illegal command.  
&ensp;&ensp;1a1. System warns that the <u>[command is illegal (UC07)](#UC07-Warn-on-Illegal-Command)</u>.  
&ensp;&ensp;1a2. User acknowledges and closes the warning.

Use case ends.

### UC02: Delete a task

Actor(s): Project Manager  
Guarantees:

* The specified task is successfully deleted from the system.

**MSS**

1. User inputs command to delete a certain task.
2. System deletes the task and <u>[displays the updated task list (UC03)](#UC03-View-all-tasks)</u>.

Use case ends.

**Extensions:**

1a. User enters an invalid command.  
&ensp;&ensp;1a1. System warns that the <u>[command is invalid (UC06)](#UC06-Warn-on-Invalid-Command)</u>.  
&ensp;&ensp;1a2. User acknowledges and closes the warning.  
1b. User enters an illegal command.  
&ensp;&ensp;1b1. System warns that the <u>[command is illegal (UC07)](#UC07-Warn-on-Illegal-Command)</u>.  
&ensp;&ensp;1b2. User acknowledges and closes the warning.

Use case ends.

### UC03: View all tasks

Actor(s): Project Manager

**MSS**

1. User opens up the application.
2. System displays a list of tasks to the user.

Use case ends.

**Extensions:**

1a. User enters an invalid command.  
&ensp;&ensp;1a1. System warns that the <u>[command is invalid (UC06)](#UC06-Warn-on-Invalid-Command)</u>.  
&ensp;&ensp;1a2. User acknowledges and closes the warning.

Use case ends.

### UC04: Marks a task as done

Actor(s): Project Manager  
Guarantees:

* The specified task is successfully marked as complete in the system.

**MSS**

1. User inputs command to mark a certain task as done.
2. System updates and marks the task as done.
3. Updated list of tasks is <u>[displayed to the user (UC03)](#UC03-View-all-tasks)</u>.

Use case ends.

**Extensions:**

1a. User enters an invalid command.  
&ensp;&ensp;1a1. System warns that the <u>[command is invalid (UC06)](#UC06-Warn-on-Invalid-Command)</u>.  
&ensp;&ensp;1a2. User acknowledges and closes the warning.  
1b. User enters an illegal command.  
&ensp;&ensp;1b1. System warns that the <u>[command is illegal (UC07)](#UC07-Warn-on-Illegal-Command)</u>.  
&ensp;&ensp;1b2. User acknowledges and closes the warning.

Use case ends.

### UC05: Unmarks a task that was marked as done

Actor(s): Project Manager  
Guarantees:

* The specified task is successfully marked as incomplete in the system.

**MSS**

1. User inputs command to unmark certain task.
2. System updates and marks the task as incomplete.
3. Updated list of tasks is <u>[displayed to the user (UC03)](#UC03-View-all-tasks)</u>.

Use case ends.

**Extensions:**
1a. User enters an invalid command.  
&ensp;&ensp;1a1. System warns that the <u>[command is invalid (UC06)](#UC06-Warn-on-Invalid-Command)</u>.  
&ensp;&ensp;1a2. User acknowledges and closes the warning.  
1b. User enters an illegal command.  
&ensp;&ensp;1b1. System warns that the <u>[command is illegal (UC07)](#UC07-Warn-on-Illegal-Command)</u>.  
&ensp;&ensp;1b2. User acknowledges and closes the warning.

Use case ends.

### UC06: Warn on invalid command

Actor(s): Project Manager, System  
Guarantee(s):

* No commands will be executed.

**MSS**

1. User inputs an invalid command.
2. System warns user that the command entered is invalid.

Use case ends.

### UC07: Warn on illegal command

Actor(s): Project Manager, System  
Guarantee(s):

* Illegal command will not be executed.

**MSS**

1. User inputs an illegal command (valid command but the user has no permission to execute the command or argument is
   invalid).
2. System warns user that the command entered is illegal and cannot be completed.

Use case ends.

![diagram](https://hackmd.io/_uploads/SJJ2cW4lT.png)

## Non-Functional Requirements

1. TaskWise should work on Windows/MacOS/Linux as long as the device has `Java 11` or above installed.
2. A user should be able to accomplish all of the tasks using commands rather than using a mouse.
3. The size of the JAR file should not be larger than 100 MB.
4. TaskWise should work without Internet connectivity.

## Glossary

* **Argument**: A word or number or a sequence of words or numbers that represent.
* **CLI**: A Command Line Interface is a text-based interface where users can interact with the software by typing
  commands.
* **Command**: A sequence of words that represents an action that TaskWise can understand and execute.
* **Deadline**: A date that the task needs to be completed by.
* **GUI**: A Graphical User Interface is a visual interface where users can interact with the software through on-screen
  elements like buttons and windows.
* **JAR**: A file that contains all the resources needed for TaskWise to run.
* **Java**: A general-purpose programming language which TextWise is built on.
* **System**: The TaskWise program.
* **Task**: A Task is a completable objective with or without deadline.

# Appendix: Instruction for Manual Testing

Work in Progress...
