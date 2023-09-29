# Developer Guide

Welcome to the TaskWise Developer Guide!

## Content
- [Acknowledgements](#acknowledgements)
- [Introduction](#introduction)
- [Getting Started](#getting-started)
- [Design](#design)
- [Implementation](#implementation)
- [Documentation, Logging, Testing, Configuration and DevOps](#Documentation-Logging-Testing-Configuration-and-DevOps)
- [Appendix: Requirements](#appendix-requirements)
    - [Product Scope](#Product-Scope)
        - [Value Proposition](#Value-Proposition)
        - [Target Audience](#Target-Audience)
    - [User Stories](#User-Stories)
    - [Use Cases](#Use-Cases)
    - [Non-Functional Requirements](#Non-Functional-Requirements)
    - [Glossary](#Glossary)
- [Appendix: Instruction for Manual Testing](#Appendix-Instruction-for-Manual-Testing)

# Acknowledgements

No acknowledgements.

# Introduction

Welcome to the TaskWise Developer Guide!

Through this guide you will learn more about the vision behind TaskWise, how TaskWise was built and how you as a Developer can use TaskWise and build upon it!

# Getting Started

wow start

# Design

wow design

# Implementation

wow implementation

# Documentation, Logging, Testing, Configuration and DevOps

wow documentation

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