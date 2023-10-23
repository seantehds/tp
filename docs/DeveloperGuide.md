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

## Exception Handling

There are 3 main classes of Exceptions or Errors that are recognised by the application, namely the `CommandException`,
`ParseException` and `StorageException` Exception classes. Most Exceptions or Errors that are thrown during normal 
operation of the app should extend from these 3 classes. Any other Exceptions or Errors that are thrown that do not
extend from the prior 3 classes will **not** be caught and handled, and will instead be thrown back to the user.

Here is a quick overview of the 3 main Exception classes in TaskWise:

![overview](images/exceptions/RecognisableExceptionsDiagram.svg?raw=true&sanitize=true)

We shall now go through the 3 different classes of recognised Exceptions and Errors, before going through the other 
unrecognised Exceptions and Errors that may be thrown.

### `CommandException`

`CommandException` represents a generic error which occurred when a `Command` object is executed. 

You are strongly discouraged from throwing this Exception class as a general catch-all exception when something went 
wrong when the user tries to execute a `Command`, as it may lack the necessary information which you need to find out 
what is wrong with the code and prevent you from debugging later on!

Should you find yourself requiring more Exception classes to handle any new errors that arises when you extend the app,
create new Exception classes, extend from `CommandException`, and throw the new class instead!

There are *3* other derived classes of `CommandException`, which are the `DuplicatedTaskException`,  
`IllegalCommandException` and `IllegalTaskIndexException` classes. We shall explore the classes in detail in the next
few sections.

![overview](images/exceptions/CommandExceptionDiagram.svg?raw=true&sanitize=true)

#### `DuplicatedTaskException`

This Exception is thrown when the user attempts to create a new Task with the same Task name as any Tasks already 
existing in their Task List. 

This is due to the fact that duplicated Tasks are not permitted in the current version of the application.

#### `IllegalCommandException`

This Exception is thrown when the user attempts to do something that they do not have sufficient permission for,
or are attempting to invoke undefined behaviour within TaskWise.

This Exception is meant to be a generic error which other Exceptions can extend from, but it may be thrown if necessary.

#### `IllegalTaskIndexException`

This Exception is thrown when the user attempts to input a Task index that is not permitted. This Exception extends 
from the above `IllegalCommandException`.

Some examples of task indices that are not permitted include: `-1` (negative indices), 
`10.0` (floating points) and `10` (when there is only `9` tasks in the task list).

### `ParseException`

`ParseException` is another generic error which occurs when there was an issue encountered when a `Parser` tries to 
parse an input from the user. Usually, this error arises due to user error (e.g. wrong commands, invalid or illegal
inputs), and should **not** be the result of developer error.

![overview](images/exceptions/ParseExceptionDiagram.svg?raw=true&sanitize=true)

#### `DuplicatedPrefixException`

This Exception is thrown when the same `Prefix` is detected in the same command.

For example, if the command `add t/task t/another task` is entered, the duplicated `t/` `Prefix` will be detected, and
this Exception will be thrown.

#### `IllegalArgumentException`

This Exception is thrown when the user enters a valid command, but with invalid arguments. This Exception is mainly
thrown by parsing methods found in `ParserUtil`, which handles the parsing of Task Index, Description, Tag, Sort Order
and Sort Type.

#### `InvalidCommandException`

This Exception is thrown when the user attempts to execute a command that is not recognised by TaskWise.

Only commands recognised by TaskWise will be parsed and executed. Any unknown command will result in this Exception
being thrown, alerting users that the input command they have entered is invalid.

#### `InvalidFormatException`

This Exception is thrown when the user inputs a command with essential arguments to the command missing.

An example of this would be the `add` command: `add` is invalid, and will result in this Exception being thrown. 

#### `NoRecordedModificationException`

This Exception is thrown when the user indicates that they would like to edit a certain Task on their Task list, but 
failed to specify any changes made to said Task, i.e. they failed to properly modify the Task.

### `StorageException`

`StorageException` is the final class of generic error which occurs when there is an issue loading data from the 
save files of TaskWise. 

![overview](images/exceptions/StorageExceptionDiagram.svg?raw=true&sanitize=true)

#### `IllegalJsonValueException`

This Exception is thrown when the data stored in TaskWise's JSON data files do not meet some constraints imposed by the 
Task model.

#### `IllegalJsonDescriptionValueException`

This Exception is thrown when the stored Task Description is corrupted and cannot be read from the JSON data file.

#### `IllegalJsonNameValueException`

This Exception is thrown when the stored Task Name is corrupted and cannot be read from the JSON data file.

#### `IllegalJsonTagValueException`

This Exception is thrown when the stored Task Tags are corrupted and cannot be read from the JSON data file.

#### `IllegalJsonDuplicatedValueException`

This Exception is thrown when the JSON data file is illegally modified or corrupted, resulting in the inclusion of 
a duplicate Task.

#### `FileStorageLoadException`

This Exception is thrown when there are any issues encountered when loading data from any data files.

#### `InsufficientStoragePrivilegeException`

This Exception is thrown when the user failed to grant TaskWise sufficient access privilege to their file system, 
resulting in TaskWise being unable to read or write to the data files TaskWise creates while in operation.

#### `StorageReadWriteException`

This Exception is thrown when there is an error encountered when TaskWise is trying to read or write from the 
data files.

Note that this errors differs from `InsufficientStoragePrivilegeException` in that access is granted, but the data file
could not be recognised and hence parsed within TaskWise, hence leading to an error being raised.

### Unrecognised Exceptions

Any other Exceptions not mentioned above should not, under most circumstances, be thrown by any method within TaskWise,
as they will not be caught by TaskWise's internal Exception handling system, leading to the user's application 
crashing catastrophically.

Developers are recommended to extend on the current Exception classes already provided to specify new Exceptions that 
they would like to handle, rather than throwing any Exceptions that are not on the list of pre-approved Exceptions.

# Implementation

Work in Progress...

# Documentation, Logging, Testing, Configuration and DevOps

Work in Progress...

# Appendix: Requirements

## Product Scope

### Value Proposition

Provide the project manager of a CS2103T group a fast and intuitive CLI to manage their team project, by providing them a platform to manage different deadlines for different tasks, allowing them to be more on task and keep up with deadlines within one project.

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

1. User inputs an illegal command (valid command but the user has no permission to execute the command or argument is invalid).
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
* **CLI**: A Command Line Interface is a text-based interface where users can interact with the software by typing commands.
* **Command**: A sequence of words that represents an action that TaskWise can understand and execute.
* **Deadline**: A date that the task needs to be completed by.
* **GUI**: A Graphical User Interface is a visual interface where users can interact with the software through on-screen elements like buttons and windows.
* **JAR**: A file that contains all the resources needed for TaskWise to run.
* **Java**: A general-purpose programming language which TextWise is built on.
* **System**: The TaskWise program.
* **Task**: A Task is a completable objective with or without deadline.

# Appendix: Instruction for Manual Testing

Work in Progress...
