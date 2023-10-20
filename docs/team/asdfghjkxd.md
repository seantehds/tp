# George's Project Portfolio Page

## Project Name: TaskWise
TaskWise is a task managing application used by CS2103/T task managers.

The user interacts with it via the Command Line Interface (CLI) and it has a Graphical User
Interface (GUI) made using JavaFX. It is written in Java, and it has about 10813 LoC.

Given below are my contributions to the project.

* **New Feature: Sorting Tasks**
  * **What it does:** Sorts the tasks by task by the task status, deadline and priority, and displays the new sorted 
    order to the user.
  * **Justifications:** The user may wish to find tasks that are not completed, tasks with the earliest deadline and 
    tasks that are high priority and needs attention immediately. Providing users with a feature to sort by these 
    criteria would help enhance the user 
  * **Highlights:** [TODO]
  * **Credits:** [TODO]

* **Code contributed:** [link to RepoSense](https://nus-cs2103-ay2324s1.github.io/tp-dashboard/?search=&sort=groupTitle&sortWithin=title&timeframe=commit&mergegroup=&groupSelect=groupByRepos&breakdown=true&checkedFileTypes=docs~functional-code~test-code&since=2023-09-22&tabOpen=true&tabType=authorship&tabAuthor=asdfghjkxd&tabRepo=AY2324S1-CS2103T-T17-1%2Ftp%5Bmaster%5D&authorshipIsMergeGroup=false&authorshipFileTypes=docs~functional-code~test-code&authorshipIsBinaryFileTypeChecked=false&authorshipIsIgnoredFilesChecked=false)

* **Project management:**
  * Set up the team organisation on GitHub
  * Set up the team's repository with the relevant issue trackers and tags
  * Created project boards used for Issue Tracking and User Stories
  * Managed team DevOps processes such as CI/CD

* **Enhancement to existing features:**
  * **Enhanced Exception Handling** [#57](https://github.com/AY2324S1-CS2103T-T17-1/tp/pull/57)
    * **What it does:** Introduced new exception classes and error messages to provide developers and users with a
      better idea of what exactly went wrong, building upon the old exception handling system and enhancing it with 
    * **Justifications:** A user who tries to execute an invalid or illegal command needs to be told exactly why the
      task/command used was wrong. Developers who are working on the code base may also be confused by the exceptions
      thrown since there was previously only a few exception classes available for use in the app.
    * **Highlights:** This enhancement affects almost all files within the code base which uses exceptions to handle 
      errors and generate error messages for the users. This proved to be challenging due to the sheer number of methods
      which throws exceptions for vastly different reasons. Methods have to be checked one-by-one to determine what 
      exactly was the cause of the error.
  * **Proposition to enhance Functional Programming code** [#57](https://github.com/AY2324S1-CS2103T-T17-1/tp/pull/57)

* **Documentation:**
  * User Guide: Added documentation on the "Check for Valid Command" feature
  * Developer Guide: Added documentation on the "Check for Valid Command" feature

* **Contribution to team-based tasks**
  * Set up the relevant administrative and DevOps requirements for the project

* **Review/mentoring contributions**
  * Frequent PR and Code Reviews
  * Helping to answer questions regarding DevOps processes from other team members

* **Contributions to community:** 
  * PRs Reviewed (with non-trivial comments): [#55](https://github.com/AY2324S1-CS2103T-T17-1/tp/pull/55),
    [#61](https://github.com/AY2324S1-CS2103T-T17-1/tp/pull/61),
    [#62](https://github.com/AY2324S1-CS2103T-T17-1/tp/pull/62)
  * Reported Bugs within the Code and Documentations: [#54](https://github.com/AY2324S1-CS2103T-T17-1/tp/issues/54)
