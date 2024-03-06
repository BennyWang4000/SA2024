# SA2024
HW1 資工碩一 王衍斌 112598041 

- return value instead of calling the method of BaseView 

```mermaid
classDiagram
direction LR
    class Main{

    }
    Main o-- BaseView
    class TaskList{

    }
    TaskList --> BaseModel
    class TaskListModel{
        
    }
    class BaseView{

    }
    BaseView <|-- TaskList
    class BaseModel{

    }
    BaseModel <|-- TaskListModel
    class TaskService{

    }
    class ITaskService{

    }
    TaskService <|.. ITaskService
    class Task{

    }
```
# HW1
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
