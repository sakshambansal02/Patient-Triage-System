Patient Triage System

<br>
<br>

The Patient Triage System is a Java-based application designed to assist healthcare facilities in efficiently managing and triaging patients. This system prioritizes patients based on the severity of their conditions, ensuring that critical cases receive immediate attention. Utilizing advanced data structures and algorithms, the system provides a robust and scalable solution for patient management.

<br>
<br>

Installation
To install the Patient Triage System, follow these steps:

<br>

Clone the repository from GitHub to your local machine.
Ensure Java (version 8 or later) is installed on your system.
Import the project into your preferred IDE (e.g., Eclipse, IntelliJ).
Add junit-4.12.jar and hamcrest-core-1.3.jar to your project's build path for testing purposes.

<br>

After installation, the system can be run from the main class AppMain.java. The user interface will guide you through the process of adding, managing, and triaging patients.

<br>

AppMain.java
<br>
This is likely the entry point of the application. It initializes the system and may handle the primary user interface logic, allowing users to interact with the Patient Triage System.

<br>

Patient.java
Represents the Patient entity. This class likely contains patient-related information such as name, age, condition, and other personal or medical details.

<br>

Condition.java
Defines the Condition class or enum. This might represent various health conditions or triage levels for patients, serving as a criterion for prioritization in the triage process.

<br>

PatientAgeComparator.java
A comparator class used for sorting or comparing patients based on their age. This could be used in prioritizing patients or organizing patient lists.

<br>

PatientConditionComparator.java
Similar to PatientAgeComparator, but this class compares patients based on their medical condition or severity of their health status.

<br>

TriageSystemParser.java
Likely handles parsing of input data or commands for the triage system. This could involve reading and interpreting data from files, user input, or other sources.

<br>

Heap.java
Implements the Heap data structure, possibly used for efficient sorting and retrieval of patient data. Heaps are often used in priority queues, which are crucial in triage systems for managing patient order based on urgency.

<br>

PriorityQueueADT.java
An Abstract Data Type (ADT) for a priority queue. This interface or class defines the operations for the priority queue used in the system, such as enqueue, dequeue, and peek, tailored to handle patients based on priority.

<br>

QueueUnderflowException.java
Defines an exception that is thrown when an operation is performed on an empty queue, such as attempting to remove an element from an empty queue.

<br>

ProjectTests.java
Contains unit tests for the system. This file likely includes tests for various components of the system, ensuring that functionality like patient prioritization, data parsing, and queue operations work as expected.

