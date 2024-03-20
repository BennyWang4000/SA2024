# SA2024
HW1 資工碩一 王衍斌 112598041 

## Fix HW2 by
- let ```TaskPresenter.java``` be stateless
- let ```TaskModel.java``` be stateful
- value object
- move the command business logic into TaskPresenter
- print by callback in view

## Tree
```
.
├── Main.java
├── base
│   ├── BaseModel.java
│   ├── BasePresenter.java
│   └── BaseView.java
└── tasks
    ├── entity
    │   ├── Const.java
    │   ├── response
    │   │   └── TaskResult.java
    │   └── task
    │       ├── IsDone.java
    │       ├── Project.java
    │       ├── ProjectName.java
    │       ├── Projects.java
    │       ├── Task.java
    │       └── TaskId.java
    ├── model
    │   ├── ITaskModel.java
    │   └── TaskModel.java
    ├── presenter
    │   ├── ITaskPresenter.java
    │   └── TaskPresenter.java
    └── view
        ├── CommandCallback.java
        ├── ITaskView.java
        └── TaskView.java
```

## Layers
- entity

| class       | function                              |
| ----------- | ------------------------------------- |
| Const       | singleton to get the various messages |
| TaskId      | id of task                            |
| IsDone      | whether a task is done                |
| Task        | task with IsDone, description         |
| Project     | map of TaskId and Task                |
| ProjectName | name of project                       |
| Projects    | map of ProjectName and Project        |
| TaskResult  | response of TaskModel                 |

- model

| class      | function            |
| ---------- | ------------------- |
| ITaskModel | interface for DIP   |
| TaskModel  | contact with entity |

- presenter

| class          | function                       |
| -------------- | ------------------------------ |
| ITaskPresenter | interface for DIP              |
| TaskPresenter  | contact between model and view |

- view

| class           | function                |
| --------------- | ----------------------- |
| CommandCallback | callback on success etc |
| ITaskView       | interface for DIP       |
| TaskView        | read and print          |

- base

| class         | function                                    |
| ------------- | ------------------------------------------- |
| BaseModel     | abstract model                              |
| BasePresenter | abstract presneter and inject model into it |
| BaseView      | abstract view and inject reader and printer |
