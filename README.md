# SA2024
HW1 資工碩一 王衍斌 112598041 

## Layers from high to low
| class         | function                  |
| ------------- | ------------------------- |
| Task          | data structure            |
| TaskHolder    | singleton that have tasks |
| TaskService   | access TaskHolder only    |
| TaskListModel | business logics           |
| TaskList      | read and print            |
| Main          | main class                |

## Abstract Classes and Interfaces
| class          | function                                               |
| -------------- | ------------------------------------------------------ |
| ITaskService   | DIP                                                    |
| ITaskListModel | DIP                                                    |
| ITaskList      | DIP                                                    |
| BaseView       | command-based view that provide printline and readline |
| BaseModel      | recive service interface and stored it                 |



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






# HW1 Review
## Layers from high to low
| class         | function                  |
| ------------- | ------------------------- |
| Task          | data structure            |
| TaskHolder    | singleton that have tasks |
| TaskService   | access TaskHolder only    |
| TaskListModel | business logics           |
| TaskList      | read and print            |
| Main          | runable                   |

## Problems
- every interfaces are not doing the DIP
- the higher layer still directly access the lower layer
    - e.g. ```TaskListModel``` access the method ```printLine``` of ```BaseView```


```mermaid
classDiagram 
direction TB
    class Main{
        +main(String[] args)
    }
    Main o-- BaseView
    class BaseView{
        # BufferedReader reader
        # PrintWriter writer
        + BaseView(BufferReader reader, PrintWriter writer)
        + printLine(String line)
        + printLines(List~String~ lines)
        + run()*
    }
    <<abstract>> BaseView
    BaseView <|-- TaskList
    
    

    class BaseModel{
        # BaseView view
        + BaseModel(BaseView view)
    }
    <<abstract>> BaseModel
    BaseModel <|-- TaskListModel

    class Task{
        - final long id
        - final String description
        - boolean done
        + Task(long id, String description, boolean done)
        + getId() long
        + getDescription() String 
        + isDone() boolean 
        + setDone(boolean done)
        + getShow() String
    }

    class TaskHolder{
        + Map~String, List~Task~~ projects
    }
    <<static>> TaskHolder

    class ITaskService{
        + getProjects() Map~String, List~Task~~
        + getTasks(String pName) List~Task~
        + addProject(String pName)
        + addTask(String pName, Task task)
        + uncheckTask(String pName, int tid)
        + checkTask(String pName, int tid) 
    }
    <<interface>> ITaskService
    ITaskService <|.. TaskService

    class TaskService{
        + getProjects() Map~String, List~Task~~
        + getTasks(String pName) List~Task~
        + addProject(String pName)
        + addTask(String pName, Task task)
        + uncheckTask(String pName, int tid)
        + checkTask(String pName, int tid)
    }
    TaskService --> TaskHolder

    class TaskList{
        - TaskListModel model
        + run()
        - execute(String commandLine)
    }
    TaskList o-- TaskListModel
    
    class TaskListModel{
        - long lastId
        - TaskService taskService
    }
    TaskListModel o-- TaskService
    TaskListModel o-- Task
    TaskListModel --> BaseView
    
```

ideas
- TaskList: read and write for client
- TaskListModel: logic for TaskList
- TaskService: interface for accessing the data
- TaskHolder: singleton
