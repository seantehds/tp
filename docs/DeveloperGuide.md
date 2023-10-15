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

Through this guide you will learn more about the vision behind TaskWise, how TaskWise was built and how you as a Developer can use TaskWise and build upon it!

# Getting Started

Work in Progress...

# Design

Work in Progress...

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
