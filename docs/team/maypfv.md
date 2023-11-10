---
layout: page
title: May's Project Portfolio Page
---

## Project Name: TaskWise
TaskWise is a task managing application used by CS2103/T task managers.
The user interacts with it via the Command Line Interface (CLI) and it has a Graphical User
Interface (GUI) made using JavaFX. It is written in Java, and it has about _______ LoC.

Given below are my contributions to the project.

* **New Feature:** Add Tasks
  * **What it does:** Adds a task to the task list.
  * **Justifications:** Allows project managers to be able to add tasks to the list of tasks so that they can
    be tracked easily. We have made **ONLY** the `description` of the task compulsory, since it
    defines the task and it is our unique identifier. Other parameters of a task such as `deadline`, `priority`,
    `status` and `member` are made optional to be included when using the `add` command.
  * **Highlights:** The `add` command is extremely easy and intuitive to use, due to its nature of only having 1
    compulsory parameter. Furthermore, its paramters are easily editable with the `edit` command.
  * **Credits:** The validation REGEX to check for validity of `description`'s input by user was reused from ChatGPT's
    generated code. I have edited and tried a few variations before using the one that we currently have now.

* **New Feature:** Priority of Tasks
  * **What it does:** Allow tasks to have a 1 priority level of NONE, LOW, MEDIUM, HIGH.
  * **Justifications:** With tasks of different deadlines and importance, project managers may want to be able to
  categorize how important each task is to them. Therefore, they can associate priority levels to those tasks.
  We allow the priority level to be assigned at the level of adding a task with the `add` command, or to change 
  default or existing priority level with the `edit` command. 
  * **Highlights:** [TODO]
  * **Credits:** [TODO]

* **Code contributed:** [Link to RepoSense](https://nus-cs2103-ay2324s1.github.io/tp-dashboard/?search=maypfv&sort=groupTitle&sortWithin=title&timeframe=commit&mergegroup=&groupSelect=groupByRepos&breakdown=true&checkedFileTypes=docs~functional-code~test-code&since=2023-09-22&tabOpen=true&tabType=authorship&tabAuthor=maypfv&tabRepo=AY2324S1-CS2103T-T17-1%2Ftp%5Bmaster%5D&authorshipIsMergeGroup=false&authorshipFileTypes=docs~functional-code~test-code&authorshipIsBinaryFileTypeChecked=false&authorshipIsIgnoredFilesChecked=false)

* **Project management:** 
  * Ensures that meetings' discussions are properly documented.
  * Keeps track of deadlines and upcoming meeting dates and agendas.
  * Regularly update meeting dates and times to allow members to stay in the loop.

* **Enhancement to existing features:**
  * **Updated User Interface** [#64](https://github.com/AY2324S1-CS2103T-T17-1/tp/pull/64)
    * What it does: Changed the user interface to be more user-friendly with a different colour scheme.
    * Justifications: We wanted a more vibrant and bright user interface which is readable by users. The use of different 
      colours in the tags also highlight different significance such as priority levels.

* **Documentation:**
  * **User Guide:** 
    * Added the introduction and add feature in the user guide.
    * Worked heavily on the `add` feature and `clear` feature documentation, under implementations.
    * Contributed to `edit` feature component, mostly reused `add` command's parameter descriptions in the `edit`
      command.
    * Proposed Enhancement for `add` feature to allow same `description` but different other parameters to be added to
      task list.
    * Formatting of all implementation for the different features.
  * **Developer Guide:** 
    * Added the introduction and some sections at the start in developer guide.
    * Model Component's diagrams.
    * Model Component's refactoring of any mentions of AB3 to TaskWise.
    * `Add` feature process descriptions.
    * `Add` feature sequence and activity diagrams.
    * `Delete` feature process descriptions.
    * Edited `Delete` feature's sequence diagram.
    * `Clear` feature process descriptions.
    * `Clear` feature sequence diagram.
    * Update user story and use cases for `add`, `delete`, `clear`. 
    * Propose Enhancement for `add` feature. 
* **Contribution to team-based tasks:** 
  * Created the UI mockup
  * [TODO]
* **Review/mentoring contributions:**   
  * Reviewed some PRs on GitHub
