# SA2024
資工碩一 王衍斌 112598041 

## Fix HW3 by
- add the controller and call methods of model
- TaskResult as ResponseModel
- aggregate domain model

## Tree
```
.
├── base
│   ├── BaseController.java
│   ├── BaseModel.java
│   ├── BasePresenter.java
│   └── BaseView.java
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
    │   ├── Const.java
    │   └── task
    │       ├── IsDone.java
    │       ├── Project.java
    │       ├── ProjectName.java
    │       ├── Projects.java
    │       ├── TaskId.java
    │       └── Task.java
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