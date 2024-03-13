# SA2024
HW1 資工碩一 王衍斌 112598041 

## Layers from high to low
| class         | function                              |
| ------------- | ------------------------------------- |
| Const         | singleton to get the various messages |
| Task          | data structure                        |
| TaskHolder    | singleton that have task instances    |
| TaskService   | access TaskHolder only                |
| TaskListModel | business logics                       |
| TaskList      | read and print                        |
| Main          | main class                            |

## Abstract Classes and Interfaces
| class          | function                                                   |
| -------------- | ---------------------------------------------------------- |
| ITaskService   | interface of TaskService for DIP                           |
| ITaskListModel | interface of TaskListModel for DIP                         |
| ITaskList      | interface of TaskList for DIP                                                        |
| BaseView       | command-based view that provide printline and readline etc |
| BaseModel      | recive service interface and stored it                     |

## Problems of HW1
- every interfaces are not doing the DIP
- the higher layer still directly access the lower layer
    - e.g. ```TaskListModel``` access the method ```printLine``` of ```BaseView```


## Class Diagram
```mermaid
classDiagram
direction TB
    class Main{
        +main(String[] args) $
    }
    Main o-- ITaskList


    class BaseView{
        -BufferedReader reader
        -PrintWriter writer
        +BaseView(BufferedReader, PrintWriter)
        +run()*
        #readLine() String
        #print(String)
        #printLine(String)
        #printLines(List~String~)
        #flush()
    }
    class BaseModel~IService~{
        #IService service
        +BaseModel(IService)
    }
    BaseView <|-- TaskList
    BaseModel <|-- TaskListModel: ITaskService
    
    class ITaskList{
        +run() *
    }
    class ITaskListModel{
        +getShow() List~String~
        +add(String[]) String
        +check(String) String
        +uncheck(String) String
    }
    class ITaskService{
        +getProjects() Map~String, List~Task~~
        +getTasks(String) List~Task~
        +addProject(String)
        +addTask(String, Task)
        +uncheckTask(String, int)
        +checkTask(String, int)   
    }
    ITaskList <|.. TaskList
    ITaskListModel <|.. TaskListModel
    ITaskService  <|.. TaskService

    class TaskList{
        -ITaskListModel model
        -boolean isRunning
        +TaskList(BufferedReader, PrintWriter)
        +run()
        -execute(String)
    }
    TaskList --> ITaskService
    TaskList --> ITaskListModel
    
    class TaskListModel{
        -long lastId
        +TaskListModel(ITaskService)
        +getShow() List~String~
        +add(String[]) String
        +check(String) String
        +uncheck(String) String
        -nextId() long
        -addProject(String) String
        -addTask(String, String) String
        -setDone(String, boolean)
    }
    TaskListModel --> ITaskService

    class TaskService{
        +getProjects() Map~String, List~Task~~
        +getTasks(String) List~Task~
        +addProject(String)
        +addTask(String, Task)
        +uncheckTask(String, int)
        +checkTask(String, int)   
    }
    TaskService --> TaskHolder
    
    class TaskHolder{
        #Map~String, List~Task~~ projects $
    }
    TaskHolder o-- Task
    class Task{
        -long id
        -String description
        -boolean done
        +Task(long, String, boolean)
        +getId() long
        +getDescription() String
        +isDone() boolean
        +setDone(boolean)
        +getShow() String
    }
    TaskListModel --> Task
    
    <<interface>> ITaskList
    <<interface>> ITaskListModel
    <<interface>> ITaskService
    <<abstract>> BaseView
    <<abstract>> BaseModel
    <<static>> TaskHolder
    
```
