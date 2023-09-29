# TaskWise User Guide

Welcome to the TaskWise User Guide!

- [Introduction](#introduction)
    - [Usage of User Guide](#usage-of-user-guide)
- [Quick Start Guide](#quick-start-guide)
    - [Using the GUI](#Using-the-GUI)
    - [Using the Command Line](#Using-the-Command-Line)
- [Features](#Features)
    - [Features Summary](#Features-summary)
    - [Add Tasks](#Add-Tasks)
    - [Delete Tasks](#Delete-Tasks)
    - [See All Tasks Added](#See-All-Tasks-Added)
    - [Mark Tasks As Complete](#Mark-Tasks-As-Complete)
    - [Unmark Tasks as Incomplete](#Unmark-Tasks-as-Incomplete)
    - [Check for Valid Command](#Check-for-Valid-Command)
- [Commands](#Commands)
    - [Commands Summary](#Commands-summary)
- [FAQ](#FAQ)

# Introduction
[(Jump to top)](#TaskWise-User-Guide)

From this User Guide, you will learn:

- what TaskWise is
- what TaskWise can do
- how TaskWise can help enhance your project management workflows
- and much, much more!

## Usage of User Guide
[(Jump to top)](#TaskWise-User-Guide)

This User Guide will guide you along in learning how to use TaskWise and what the different features of TaskWise is. If you are already an experienced user, click [here](#Features) to get to the summary of the different features of TaskWise and [here](#Commands) to get to the summary of commands that you can enter into TaskWise.

Otherwise, read on to find out more on how TaskWise can help you be a more effective project manager for your CS2103T project!

# Quick Start Guide
[(Jump to top)](#TaskWise-User-Guide)

[scenario wowowowowowowowowoowowowowowowoow]

## Using the GUI
[(Jump to top)](#TaskWise-User-Guide)

[:0]

## Using the Command Line
[(Jump to top)](#TaskWise-User-Guide)

[:0]

# Features
[(Jump to top)](#TaskWise-User-Guide)

The next few sections will detail the different features that

## Feature Summaries

[wow summary here :0]

## Add Tasks
[(Jump to top)](#TaskWise-User-Guide)

### What it does:

* Adds a task to the task list

### Command

* `add [task name]`

### Example

* `add` meeting
* `add` user guide

### Acceptable values for each parameter

* Any valid Strings

### Expected output

* Popup window with text: “[task status][task name] has been added successfully!”
* The task entry will be displayed on the main GUI screen

### Expected output (fail)

#### Cause: Missing description
| Explanation | Description |
|---|---|
| Example | `add` |
| Expected Outputs | Popup window displaying text: “Please enter a <br>valid task in this format “add {task name}”! |

### UI

![Image](https://github.com/AY2324S1-CS2103T-T17-1/tp/assets/111076731/c2cdf5ba-87cb-43df-9b62-94833b373a98)

## Delete Tasks
[(Jump to top)](#TaskWise-User-Guide)

### What it does

* Deletes a task from the task list

### Command

* `delete [task number within task list]`

### Example

* `delete 1`

### Acceptable values for each parameter

* string `delete`, followed by a space ` `, followed by an integer

### Expected output

* Popup window showing the task: “[task status][task name] has been deleted successfully!”
* The original task on the GUI window will be struck through

### Expected output (fail)

#### Cause: Wrong Number - Out of Bounds

| Explanation | Description |
|---|---|
| Example | `delete 3` (when there are only 2 tasks) |
| Expected Outputs | Popup window displaying text:  “Please provide a valid integer task number” |

#### Cause: No Index Provided

| Explanation | Description |
|---|---|
| Example | `delete` (no task number provided) |
| Expected Outputs | Popup window displaying text:  “Please provide a valid integer task number” |

#### Cause: Non-Integer Input for List Index

| Explanation | Description |
|---|---|
| Example | `delete this` (no task number provided) |
| Expected Outputs | Popup window displaying text:  “Please provide a valid integer task number” |

### UI

![Image](https://github.com/AY2324S1-CS2103T-T17-1/tp/assets/111076731/e5a3e2c5-2326-4320-a187-8a739f772262)

## See All Tasks Added
[(Jump to top)](#TaskWise-User-Guide)

### What it does

* Displays the task list to the user

### Command

* `list`
* `display`

### Example

* `list`
* `display`

### Acceptable values for each parameter

* One of “list” or “display”, case-sensitive

### Expected output

* A popup with the text ”Here are all your tasks!”

### Expected output (fail)

The task list is empty! Try adding tasks with the add command first! (when task list is empty)

#### Cause: Task List is Empty

| Explanation | Description |
|---|---|
| Example | `list` or `display` |
| Expected Outputs | Popup window displaying text: “The task list is empty!<br/>Try adding tasks with the add command first!" |

### UI

![Image](https://github.com/AY2324S1-CS2103T-T17-1/tp/assets/73705042/8c4dbe98-8815-4fca-a37b-e5730c70a28a)

## Mark Tasks As Complete
[(Jump to top)](#TaskWise-User-Guide)

### What it does
* Marks tasks as done

### Command
* `mark [task index]`

### Example

* `mark 1`

### Acceptable values for each parameter

* Any integer that is between 0 to (total number of tasks - 1) inclusive

### Expected output

* Popup window displaying string: "Task [Task name] has been marked as done!"
* GUI strikethrough removed

### Expected output (fail)

#### Cause: Wrong Number - Out of Bounds

| Explanation | Description |
|---|---|
| Example | `mark 3` (when there are only 2 tasks) |
| Expected Outputs | Popup window displaying text: “Please provide a valid integer task number” |

#### Cause: No Index Provided

| Explanation | Description |
|---|---|
| Example | `mark` (no task number provided) |
| Expected Outputs | Popup window displaying text: “Please provide a valid integer task number” |

#### Cause: Non-Integer Input for List Index

| Explanation | Description |
|---|---|
| Example | `mark this` (no task number provided) |
| Expected Outputs | Popup window displaying text: “Please provide a valid integer task number” |

### UI

![Image](https://github.com/AY2324S1-CS2103T-T17-1/tp/assets/73705042/51640f4e-db06-4297-87ee-703ed847ff8a)

![Image](https://github.com/AY2324S1-CS2103T-T17-1/tp/assets/111076731/da07283a-0ca4-4f5e-b299-097d39871c45)

## Mark Tasks as Incomplete
[(Jump to top)](#TaskWise-User-Guide)

### What it does
* Unmark tasks as undone

### Command
* `unmark [task index]`

### Example

* `unmark 1`

### Acceptable values for each parameter

* Any integer that is between 0 to (total number of tasks - 1) inclusive

### Expected output

* Popup window displaying string: "Task [Task name] has been marked as undone!"
* GUI strikethrough removed

### Expected output (fail)

#### Cause: Task Number does not Exist

| Explanation | Description |
|---|---|
| Example | `unmark 3` (when there are only 2 tasks) |
| Expected Outputs | Popup window displaying text: “Please provide a valid integer task number” |

#### Cause: No Task Number Provided

| Explanation | Description |
|---|---|
| Example | `unmark` (no task number provided) |
| Expected Outputs | Popup window displaying text: “Please provide a valid integer task number” |

#### Cause: Task Number is not a Number

| Explanation | Description |
|---|---|
| Example | `unmark this` (no task number provided) |
| Expected Outputs | Popup window displaying text: “Please provide a valid integer task number” |

### UI

![Image](https://github.com/AY2324S1-CS2103T-T17-1/tp/assets/111076731/bf62789a-5ccf-4906-9fb1-131db2d9cd96)

![Image](https://github.com/AY2324S1-CS2103T-T17-1/tp/assets/111076731/e8a3fd69-695d-4232-93b6-38d375af1786)

