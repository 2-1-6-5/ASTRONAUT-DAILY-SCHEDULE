# ASTRONAUT DAILY SCHEDULE ORGANIZER 🚀

## Project Overview

This repository contains the deliverables for the assignment on creating a system to manage and organize the daily schedule of an astronaut.

The project is structured into two main exercises, focusing on different aspects of scheduling and organization, likely implemented using **Java** as the primary language.
This repository contains the deliverables for an assignment focused on software design and implementation using Java. The project is divided into two parts:

1.  **Exercise 1:** Implementation and demonstration of various software Design Patterns.
2.  **Exercise 2:** A mini-project simulating an **Astronaut Daily Schedule Organizer**.


**🎯 Features**
The Astronaut Daily Schedule Organizer (Exercise 2) includes the following core functionalities:

✅ Add and manage tasks with defined priorities.

✅ Schedule management (add/view/remove tasks).

✅ Automatic task notification system (Alert Console).

✅ Use of software design patterns for code flexibility and maintainability (Factory, Observer).

✅ Console-based user interface for interaction.

**Key Components:** 

* `ConsoleApp.java`: The main entry point for the console application.
* `ScheduleManager.java`: Handles the core logic for managing the schedule (add, remove, view tasks).
* `Task.java`: The primary data structure representing a scheduled activity.
* `TaskFactory.java`: (Likely using the Factory Pattern) Used for creating different types of tasks.
* `TaskNotifier.java` / `TaskObserver.java`: (Likely implementing the Observer Pattern) Used for handling alerts and notifications.

**🏗️ Design Patterns Demonstrated**
1. Exercise 1: Pattern Implementations
This section contains clean, isolated examples of various design patterns, organized by category:

Category	  Pattern Implemented	     Folder	                       Purpose
Behavioural	  Command Pattern	    command_pattern_demo/	Demonstrates encapsulating a request as an object.  
Behavioural   Memento Pattern	    memento_patter/	        Shows how to save and restore an object's state.  
Creational	  Builder Pattern	    Builder_pattern/	    Demonstrates constructing a complex object step-by-step.  
Creational	  Singleton Pattern	    singleton_pattern/	    Ensures a class has only one instance.  
Structural	  Composite Pattern	    composite_pattern/	    Demonstrates composing objects into tree structures.  
Structural	  Decorator Pattern	    decorator_pattern/	    Shows how to add responsibilities to objects dynamically.  

## 📂 Repository Structure
ASTRONAUT-DAILY-SCHEDULE/  
├── Exercise_1/    
│   ├── Behavioural_Pattern/  
│   │   ├── command_pattern_demo/  
│   │   └── memento_patter/  
│   ├── Creational_Patterns/  
│   │   ├── Builder_pattern/  
│   │   └── singleton_pattern/  
│   └── Structural_Pattern/  
│       ├── composite_pattern/  
│       └── decorator_pattern/  
│  
└── Exercise_2/Astronaut Daily Schedule Organizer/   
    ├── AlertConsole.class   
    ├── AlertConsole.java  
    ├── ConsoleApp.class  
    ├── ConsoleApp.java      <-- Main application entry point  
    ├── ScheduleManager.class  
    ├── ScheduleManager.java  
    ├── Task.class  
    ├── Task.java  
    ├── Task$Priority.class  
    ├── TaskFactory.class  
    ├── TaskFactory.java  
    ├── TaskNotifier.class  
    ├── TaskNotifier.java  
    ├── TaskObserver.class  
    └── TaskObserver.java  
    

The project is organized into two main directories corresponding to the two exercises:

**Exercise 1: Design Patterns Implementation**
**Behavioural Patterns**

Command Pattern: Demonstrated via the command_pattern_demo/ folder.

Memento Pattern: Demonstrated via the memento_patter/ folder.

**Creational Patterns**

Builder Pattern: Demonstrated via the Builder_pattern/ folder.

Singleton Pattern: Demonstrated via the singleton_pattern/ folder.

**Structural Patterns**

Composite Pattern: Demonstrated via the composite_pattern/ folder.

Decorator Pattern: Demonstrated via the decorator_pattern/ folder.


## 🛠️ Technical Details & Execution

**Language:** Java

**To Run Exercise 2 (The Organizer):**

1.  Navigate to the main directory of the Organizer:

    cd Exercise_2/Astronaut Daily Schedule Organizer

2.  Compile all the Java source files:

    javac *.java

3.  Run the main application:

    java ConsoleApp 


