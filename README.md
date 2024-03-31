# SA2024
資工碩一 王衍斌 112598041 

## Fix HW4 by
- set IsDone as value object
- rename TaskModel to TaskRepository
- entity, value object marker interface

## Tree
```
.
├── base
│   ├── BaseController.java
│   ├── BaseModel.java
│   ├── BasePresenter.java
│   ├── BaseView.java
│   └── entity
│       ├── BaseAggregate.java
│       ├── BaseEntity.java
│       ├── BaseService.java
│       └── BaseValueObject.java
├── Main.java
└── tasks
    ├── adapter
    │   ├── controller
    │   │   ├── ITaskController.java
    │   │   └── TaskController.java
    │   └── presenter
    │       ├── ITaskPresenter.java
    │       └── TaskPresenter.java
    ├── entity
    │   ├── IsDone.java
    │   ├── MessageService.java
    │   ├── Project.java
    │   ├── ProjectName.java
    │   ├── Projects.java
    │   ├── TaskId.java
    │   └── Task.java
    ├── usecase
    │   ├── ITaskModel.java
    │   ├── response
    │   │   └── TaskResult.java
    │   └── TaskModel.java
    └── view
        ├── CommandCallback.java
        ├── ITaskView.java
        └── TaskView.java
``` 