# API Documentation

## Введение

Добро пожаловать в документацию нашего API Этот документ предназначен для предоставления информации о доступных конечных точках, их параметрах и возвращаемых данных.

## Авторизация

### `/api/csrf`

#### Описание
Получение CSRF токена необходимо для по сути любого post запроса, действителен одну сессию (до выхода с вкладки или выхода из аккаута, потом нужен новый)
Обычна сессия начинается с него, так же с ним приходят куки спринга, их нужно оставить у себя и предавать с каждым следующим запросом как и сам токен.
#### Метод
- **GET**: Получить новый токен.

#### Пример ответа
```json
{
  "token": "токен"
}
```

### `/api/login`

#### Описание
Вход в апи, нужны куки спринга а так же CSRF токен.<br>
Может кинуть 401 если не будет кук или csrf токена <br>(в теории если уже залогинены может кинуть и 403)
#### Метод
- **POST**: Войти в приложение

#### Параметры
- **username**: Логин пользователя.
- **password**: Пароль пользователя.

#### Примеры ответа
```json
{
  "result": "all_ok"
}
```
```json
{
  "message": "Invalid username or password", "code": 400
}
```
```json
{
  "message": "Please logout first.", "code": 400
}
```

### `/api/logout`

#### Описание
Выход из апи, нужны куки спринга а так же CSRF токен.<br>
Может кинуть 401 если не будет кук или csrf токена <br>Если не залогинены кинет 403
#### Метод
- **GET**: Выйти из приложения

#### Пример ответа
```json
{
  "result": "all_ok"
}
```

### `/api/current-user`

#### Описание
Получить текущего пользователя<br>
Может кинуть 401 если не будет кук или csrf токена <br>Если не залогинены кинет 403
#### Метод
- **GET**: Получить инормацию о пользователе

#### Пример ответа
```json
{
  "username": "qwet",
  "email": "a@a.a",
  "name": "Иванов Иван Иванович",
  "role": "Штатный дебил",
  "dateOfRegistration": "2024-10-12T23:47:14.949381",
  "admin": true
}
```

### `/api/signup`

#### Описание
Зарегестироваться в апи, нужны куки спринга а так же CSRF токен.<br>
Может кинуть 401 если не будет кук или csrf токена
#### Метод
- **POST**: Зарегестировать нового пользователя

#### Параметры
- **username**: Логин пользователя.
- **password**: Пароль пользователя.
- **email**: Email пользователя.
- **name**: Имя пользователя.
- **role**: Должность пользователя (не путать с флагом админ).

#### Пример ответа
```json
{
  "result": "all_ok"
}
```

## Запросы для пользователя/админа

### `/api/test`

#### Описание
Тестовый запрос доступ к которому имеют авторизированные пользователи<br>
Может кинуть 401 если не будет кук или csrf токена <br>Если не залогинены кинет 403
#### Метод
- **GET**: Общий тестовый запрос

#### Пример ответа (а так же сообщения в консоль)
```
Текст ответа:
запрос с общим доступом

Текст в консоли:
com.ytrewq.rosLearning.Entities.User@147d4023
Иванов Иван Иванович Штатный дебил
```

### `/api/test-user`

#### Описание
Тестовый запрос доступ к которому имеют только обычные пользователи<br>
Может кинуть 401 если не будет кук или csrf токена <br>Если не залогинены кинет 403
#### Метод
- **GET**: Только пользовательский тестовый запрос

#### Пример ответа (а так же сообщения в консоль)
```
Текст ответа:
запрос с доступом только пользователя


Текст в консоли:
com.ytrewq.rosLearning.Entities.User@147d4023
Иванов Иван Иванович Штатный дебил и он пользователь
```

### `/api/test-admin`

#### Описание
Тестовый запрос доступ к которому имеют авторизированные пользователи<br>
Может кинуть 401 если не будет кук или csrf токена <br>Если не залогинены кинет 403
#### Метод
- **GET**: Только админский тестовый запрос

#### Пример ответа (а так же сообщения в консоль)
```
Текст ответа:
запрос с доступом только админа


Текст в консоли:
com.ytrewq.rosLearning.Entities.User@147d4023
Иванов Иван Иванович Штатный дебил и он админ
```

### `/api/admin/addUserCourse?username=&course_id`

#### Описание
Связывание пользователя и курса.<br>
Проверяет на наличие пользователя и курса
#### Метод
- **GET**: Связать пользователя и курс

#### Параметры
- **username**: Имя пользователя.
- **course_id**: ID курса.

#### Пример ответа
```json
{
  "result": "all_ok"
}
```

### `/api/admin/removeUserCourse?username=&course_id`

#### Описание
Удаляет связь пользователя и курса.<br>
Проверяет на наличие пользователя и курса
#### Метод
- **GET**: Удалить связь пользователя и курса

#### Параметры
- **username**: Имя пользователя.
- **course_id**: ID курса.

#### Пример ответа
```json
{
  "result": "all_ok"
}
```

## Запросы для курса

### `/api/admin/createCourse`

#### Описание
Создает новый курс.<br>
Проверяет на null
#### Метод
- **POST**: Создать новый курс

#### Параметры
- **title**: Название курса.
- **dateOfCreation**: Дата создания курса.
- **description**: Описание курса.

#### Пример ответа
```json
{
  "result": "all_ok"
}
```

### `api/user/getUserCourses`

#### Описание

Получить курсы залогиненного пользователя

#### Метод
- **GET**: Получить все курсы пользователя

#### Пример ответа

```json

[
  {
    "id": 1,
    "title": "Курс 1",
    "description": "Описание курса 1",
    "dateOfCreation": "22-09-2024",
    "themes": [
      {
        "id": 1,
        "title": "Тема 1",
        "description": "Описание темы 1",
        "dateOfCreation": "22-09-2024",
        "tasks": [
          {
            "id": 1,
            "title": "Задача 1",
            "description": "Описание задачи 1",
            "dateOfCreation": "22-10-2024",
            "lessonTitle": "Тема 1",
            "courseTitle": "Курс 1",
            "emulation": {
              "id": 1,
              "private_title": "Эмуляция 1",
              "dateOfCreation": "22-09-2024",
              "timerTime": "",
              "timerDescription": "",
              "screenImageURL": "",
              "blockSchemeJSON": "",
              "blockCodeJS": "",
              "byteArrayInterface": ""
            }
          }
        ],
        "materials": [
          {
            "id": 1,
            "title": "Название материала 1",
            "materialType": "Тип материала 1",
            "materialURL": "Ссылка на материал 1",
            "materialText": "Описание материала 1"
          }
        ]
      }
    ]
  },
  {
    "id": 2,
    "title": "Курс 2",
    "description": "Описание курса 2",
    "dateOfCreation": "22-09-2024",
    "themes": []
  }
]

```

### `api/admin/getAllCourses`

#### Описание

Получение всех курсов.

#### Метод
- **GET**: Получить все курсы.

#### Пример ответа

```json

[
  {
    "id": 1,
    "title": "Курс 1",
    "description": "Описание курса 1",
    "dateOfCreation": "22-09-2024",
    "themes": [
      {
        "id": 1,
        "title": "Тема 1",
        "description": "Описание темы 1",
        "dateOfCreation": "22-09-2024",
        "tasks": [
          {
            "id": 1,
            "title": "Задача 1",
            "description": "Описание задачи 1",
            "dateOfCreation": "22-10-2024",
            "lessonTitle": "Тема 1",
            "courseTitle": "Курс 1",
            "emulation": {
              "id": 1,
              "private_title": "Эмуляция 1",
              "dateOfCreation": "22-09-2024",
              "timerTime": "",
              "timerDescription": "",
              "screenImageURL": "",
              "blockSchemeJSON": "",
              "blockCodeJS": "",
              "byteArrayInterface": ""
            }
          }
        ],
        "materials": [
          {
            "id": 1,
            "title": "Название материала 1",
            "materialType": "Тип материала 1",
            "materialURL": "Ссылка на материал 1",
            "materialText": "Описание материала 1"
          }
        ]
      }
    ]
  },
  {
    "id": 2,
    "title": "Курс 2",
    "description": "Описание курса 2",
    "dateOfCreation": "22-09-2024",
    "themes": []
  },
  {
    "id": 3,
    "title": "Курс 3",
    "description": "Описание курса 3",
    "dateOfCreation": "22-09-2024",
    "themes": []
  }
]
```

[//]: # (### `  api/admin/getCourse/?course_id`)

[//]: # ()
[//]: # (#### Описание)

[//]: # ()
[//]: # (Получение курса по id.)

[//]: # ()
[//]: # (#### Метод)

[//]: # (- **GET**: Получить курс по id.)

[//]: # ()
[//]: # (### Параметры)

[//]: # (- **course_id**. id курса.)

[//]: # (#### Пример ответа)

[//]: # ()
[//]: # (```json)

[//]: # ({)

[//]: # (  "id": 1,)

[//]: # (  "title": "Курс 1",)

[//]: # (  "description": "Описание курса 1",)

[//]: # (  "dateOfCreation": "22-09-2024",)

[//]: # (  "themes": [)

[//]: # (    {)

[//]: # (      "id": 1,)

[//]: # (      "title": "Тема 1",)

[//]: # (      "description": "Описание темы 1",)

[//]: # (      "dateOfCreation": "22-09-2024",)

[//]: # (      "tasks": [)

[//]: # (        {)

[//]: # (          "id": 1,)

[//]: # (          "title": "Задача 1",)

[//]: # (          "description": "Описание задачи 1",)

[//]: # (          "dateOfCreation": "22-10-2024",)

[//]: # (          "lessonTitle": "Тема 1",)

[//]: # (          "courseTitle": "Курс 1",)

[//]: # (          "emulation": {)

[//]: # (            "id": 1,)

[//]: # (            "private_title": "Эмуляция 1",)

[//]: # (            "dateOfCreation": "22-09-2024",)

[//]: # (            "timerTime": "",)

[//]: # (            "timerDescription": "",)

[//]: # (            "screenImageURL": "",)

[//]: # (            "blockSchemeJSON": "",)

[//]: # (            "blockCodeJS": "",)

[//]: # (            "byteArrayInterface": "")

[//]: # (          })

[//]: # (        })

[//]: # (      ],)

[//]: # (      "materials": [)

[//]: # (        {)

[//]: # (          "id": 1,)

[//]: # (          "title": "Название материала 1",)

[//]: # (          "materialType": "Тип материала 1",)

[//]: # (          "materialURL": "Ссылка на материал 1",)

[//]: # (          "materialText": "Описание материала 1")

[//]: # (        })

[//]: # (      ])

[//]: # (    })

[//]: # (  ])

[//]: # (})

[//]: # (```)

### `/api/admin/addCourseThemes?course_id=&theme_id`

#### Описание
Связывание курса и темы.<br>
Проверяет на наличие курса и темы
#### Метод
- **GET**: Связать курс и тему

#### Параметры
- **course_id**: ID курса.
- **theme_id**: ID темы.

#### Пример ответа
```json
{
  "result": "all_ok"
}
```

### `/api/admin/removeCourseThemes?course_id=&theme_id`

#### Описание
Удаляет связь курса и темы.<br>
Проверяет на наличие курса и темы
#### Метод
- **GET**: Удалить связь курс и тему

#### Параметры
- **course_id**: ID курса.
- **theme_id**: ID темы.

#### Пример ответа
```json
{
  "result": "all_ok"
}
```

## Запросы для тем

### `/api/admin/createTheme`

#### Описание
Создать новую тему.<br>
Проверяет на null
#### Метод
- **POST**: Создать новую тему

#### Параметры
- **title**: Название темы.
- **dateOfCreation**: Дата создания темы.
- **title**: Описание темы.

#### Пример ответа
```json
{
  "result": "all_ok"
}
```

### `api/user/getCourseThemes?course_id=`

#### Описание

Получение тем курса по id курса.\
Проверка, что у пользователя есть доступ к этому курсу.

#### Метод

- **GET**: Получить темы курса.

### Параметры
- **course_id**. id курса.

#### Пример ответа

```json
[
  {
    "id": 1,
    "title": "Тема 1",
    "description": "Описание темы 1",
    "dateOfCreation": "22-09-2024",
    "tasks": [
      {
        "id": 1,
        "title": "Задача 1",
        "description": "Описание задачи 1",
        "dateOfCreation": "22-10-2024",
        "lessonTitle": "Тема 1",
        "courseTitle": "Курс 1",
        "emulation": {
          "id": 1,
          "private_title": "Эмуляция 1",
          "dateOfCreation": "22-09-2024",
          "timerTime": "",
          "timerDescription": "",
          "screenImageURL": "",
          "blockSchemeJSON": "",
          "blockCodeJS": "",
          "byteArrayInterface": ""
        }
      }
    ],
    "materials": [
      {
        "id": 1,
        "title": "Название материала 1",
        "materialType": "Тип материала 1",
        "materialURL": "Ссылка на материал 1",
        "materialText": "Описание материала 1"
      }
    ]
  },
  {
    "id": 2,
    "title": "Тема 2",
    "description": "Описание темы 2",
    "dateOfCreation": "22-09-2024",
    "tasks": [
      {
        "id": 3,
        "title": "Задача 2",
        "description": "Описание задачи 2",
        "dateOfCreation": "22-10-2024",
        "lessonTitle": "Тема 2",
        "courseTitle": "Курс 1",
        "emulation": {
          "id": 2,
          "private_title": "Эмуляция 2",
          "dateOfCreation": "22-09-2024",
          "timerTime": "",
          "timerDescription": "",
          "screenImageURL": "",
          "blockSchemeJSON": "",
          "blockCodeJS": "",
          "byteArrayInterface": ""
        }
      }
    ],
    "materials": [
      {
        "id": 3,
        "title": "Название материала 3",
        "materialType": "Тип материала 3",
        "materialURL": "Ссылка на материал 3",
        "materialText": "Описание материала 3"
      }
    ]
  }
]
```

### `api/admin/getAllThemes`

#### Описание

Получение всех тем.

#### Метод
- **GET**: Получить все темы.

#### Пример ответа

```json
[
  {
    "id": 1,
    "title": "Тема 1",
    "description": "Описание темы 1",
    "dateOfCreation": "22-09-2024",
    "tasks": [
      {
        "id": 1,
        "title": "Задача 1",
        "description": "Описание задачи 1",
        "dateOfCreation": "22-10-2024",
        "lessonTitle": "Тема 1",
        "courseTitle": "Курс 1",
        "emulation": {
          "id": 1,
          "private_title": "Эмуляция 1",
          "dateOfCreation": "22-09-2024",
          "timerTime": "",
          "timerDescription": "",
          "screenImageURL": "",
          "blockSchemeJSON": "",
          "blockCodeJS": "",
          "byteArrayInterface": ""
        }
      }
    ],
    "materials": [
      {
        "id": 1,
        "title": "Название материала 1",
        "materialType": "Тип материала 1",
        "materialURL": "Ссылка на материал 1",
        "materialText": "Описание материала 1"
      }
    ]
  },
  {
    "id": 2,
    "title": "Тема 2",
    "description": "Описание темы 2",
    "dateOfCreation": "22-09-2024",
    "tasks": [
      {
        "id": 3,
        "title": "Задача 2",
        "description": "Описание задачи 2",
        "dateOfCreation": "22-10-2024",
        "lessonTitle": "Тема 2",
        "courseTitle": "Курс 1",
        "emulation": {
          "id": 2,
          "private_title": "Эмуляция 2",
          "dateOfCreation": "22-09-2024",
          "timerTime": "",
          "timerDescription": "",
          "screenImageURL": "",
          "blockSchemeJSON": "",
          "blockCodeJS": "",
          "byteArrayInterface": ""
        }
      }
    ],
    "materials": [
      {
        "id": 3,
        "title": "Название материала 3",
        "materialType": "Тип материала 3",
        "materialURL": "Ссылка на материал 3",
        "materialText": "Описание материала 3"
      }
    ]
  },
  {
    "id": 3,
    "title": "Тема 3",
    "description": "Описание темы 3",
    "dateOfCreation": "22-09-2024",
    "tasks": [],
    "materials": []
  }
]
```

[//]: # (### `   api/admin/getTheme/?theme_id= `)

[//]: # ()
[//]: # (#### Описание)

[//]: # ()
[//]: # (Получение темы по id.)

[//]: # ()
[//]: # (#### Метод)

[//]: # ()
[//]: # (- **GET**: Получить тему по id.)

[//]: # ()
[//]: # (### Параметры)

[//]: # (- **theme_id**. id темы.)

[//]: # (#### Пример ответа)

[//]: # ()
[//]: # (```json)

[//]: # ({)

[//]: # (  "id": 1,)

[//]: # (  "title": "Тема 1",)

[//]: # (  "description": "Описание темы 1",)

[//]: # (  "dateOfCreation": "22-09-2024",)

[//]: # (  "tasks": [)

[//]: # (    {)

[//]: # (      "id": 1,)

[//]: # (      "title": "Задача 1",)

[//]: # (      "description": "Описание задачи 1",)

[//]: # (      "dateOfCreation": "22-10-2024",)

[//]: # (      "lessonTitle": "Тема 1",)

[//]: # (      "courseTitle": "Курс 1",)

[//]: # (      "emulation": {)

[//]: # (        "id": 1,)

[//]: # (        "private_title": "Эмуляция 1",)

[//]: # (        "dateOfCreation": "22-09-2024",)

[//]: # (        "timerTime": "",)

[//]: # (        "timerDescription": "",)

[//]: # (        "screenImageURL": "",)

[//]: # (        "blockSchemeJSON": "",)

[//]: # (        "blockCodeJS": "",)

[//]: # (        "byteArrayInterface": "")

[//]: # (      })

[//]: # (    })

[//]: # (  ],)

[//]: # (  "materials": [)

[//]: # (    {)

[//]: # (      "id": 1,)

[//]: # (      "title": "Название материала 1",)

[//]: # (      "materialType": "Тип материала 1",)

[//]: # (      "materialURL": "Ссылка на материал 1",)

[//]: # (      "materialText": "Описание материала 1")

[//]: # (    })

[//]: # (  ])

[//]: # (})

[//]: # (```)

### `/api/admin/addThemeTask?theme_id=&task_id`

#### Описание
Связывание темы и задачи.<br>
Проверяет на наличие темы и задачи
#### Метод
- **GET**: Связать тему и задачу

#### Параметры
- **theme_id**: ID темы.
- **task_id**: ID задачи.

#### Пример ответа
```json
{
  "result": "all_ok"
}
```

### `/api/admin/addThemeMaterial?theme_id=&material_id`

#### Описание
Связывание темы и учебных материалов к ней.<br>
Проверяет на наличие темы и материалов
#### Метод
- **GET**: Связать курс и учебные материалы к ней

#### Параметры
- **theme_id**: ID темы.
- **material_id**: ID материалов.

#### Пример ответа
```json
{
  "result": "all_ok"
}
```

### `/api/admin/removeThemeTask?theme_id=&task_id`

#### Описание
Удаляет связь темы и задачи.<br>
Проверяет на наличие темы и задачи
#### Метод
- **GET**: Удалить связь темы и задачи

#### Параметры
- **theme_id**: ID темы.
- **task_id**: ID задачи.

#### Пример ответа
```json
{
  "result": "all_ok"
}
```

### `/api/admin/removeThemeMaterial?theme_id=&material_id`

#### Описание
Удаляет связь темы и учебных материалов к ней.<br>
Проверяет на наличие темы и материалов
#### Метод
- **GET**: Удалить связь курса и учебных материалов к ней

#### Параметры
- **theme_id**: ID темы.
- **material_id**: ID материалов.

#### Пример ответа
```json
{
  "result": "all_ok"
}
```

## Запросы для задач

### `/api/admin/createTask`

#### Описание
Создает новую задачу.<br>
Проверяет на null
#### Метод
- **POST**: Создать новую задачу

#### Параметры
- **title**: Название задачи.
- **dateOfCreation**: Дата создания задачи.
- **description**: Описание задачи.
- **lessonTitle**: Название связанного урока.
- **courseTitle**: Название связанного курса.
- **emulation**: Эмуляция.

#### Пример ответа
```json
{
  "result": "all_ok"
}
```

### `api/user/getTask/?course_id=&theme_id=&task_id=`

#### Описание

Получение задачи по id курса, id темы и id задачи.\
Проверка на то, что у пользователя есть доступ к этому курсу и к этой теме.

#### Метод
- **GET**: Получить задачу.

### Параметры
- **course_id**. id курса.
- **theme_id**. id темы.
- **task_id**. id задачи

#### Пример ответа

```json
[
  {
    "title": "Задача 1",
    "description": "Описание задачи 1",
    "dateOfCreation": "22-10-2024",
    "id": 1
  }
]

```

### `api/user/getThemeTasks/?course_id=&theme_id=`

#### Описание

Получение задач темы по id курса и id темы.\
Проверка на то, что у пользователя есть доступ к этому курсу и к этой теме.

#### Метод
- **GET**: Получить задачи темы.

### Параметры
- **course_id**. id курса.
- **theme_id**. id темы.

#### Пример ответа

```json
[
  {
    "id": 1,
    "title": "Задача 1",
    "description": "Описание задачи 1",
    "dateOfCreation": "22-10-2024",
    "lessonTitle": "Тема 1",
    "courseTitle": "Курс 1",
    "emulation": {
      "id": 1,
      "private_title": "Эмуляция 1",
      "dateOfCreation": "22-09-2024",
      "timerTime": "",
      "timerDescription": "",
      "screenImageURL": "",
      "blockSchemeJSON": "",
      "blockCodeJS": "",
      "byteArrayInterface": ""
    }
  },
  {
    "id": 2,
    "title": "Задача 2",
    "description": "Описание задачи 2",
    "dateOfCreation": "22-10-2024",
    "lessonTitle": "Тема 1",
    "courseTitle": "Курс 1",
    "emulation": {
      "id": 2,
      "private_title": "Эмуляция 2",
      "dateOfCreation": "22-09-2024",
      "timerTime": "",
      "timerDescription": "",
      "screenImageURL": "",
      "blockSchemeJSON": "",
      "blockCodeJS": "",
      "byteArrayInterface": ""
    }
  }
]

```

### `  api/admin/getAllTasks`

#### Описание

Получение всех задач.

#### Метод
- **GET**: Получить все задачи.

#### Пример ответа

```json
[
  {
    "id": 1,
    "title": "Название материала 1",
    "materialType": "Тип материала 1",
    "materialURL": "Ссылка на материал 1",
    "materialText": "Описание материала 1"
  },
  {
    "id": 2,
    "title": "Название материала 2",
    "materialType": "Тип материала 2",
    "materialURL": "Ссылка на материал 2",
    "materialText": "Описание материала 2"
  },
  {
    "id": 3,
    "title": "Название материала 3",
    "materialType": "Тип материала 3",
    "materialURL": "Ссылка на материал 3",
    "materialText": "Описание материала 3"
  }
]
```

## Запросы для материалов тем

### `/api/admin/createThemeMaterial`

#### Описание
Добавить учебные материалы для темы.<br>
Проверяет на null
#### Метод
- **POST**: Добавить учебные материалы

#### Параметры
- **title**: Название учебных материалов.
- **materialType**: Тип учебных материалов.
- **materialURL**: Ссылки на исходные и дополнительные источники.
- **materialText**: Текстовое поле для информации.

#### Пример ответа
```json
{
  "result": "all_ok"
}
```

### `api/user/getThemeMaterials?course_id=&theme_id= `

#### Описание

Получение материалов темы по id курса и id темы.\
Проверка, что у пользователя есть доступ к этому курсу и к этой теме.

#### Метод
- **GET**: Получить материалы темы.

### Параметры
- **course_id**. id курса.
- **theme_id**. id темы.

#### Пример ответа

```json

[
  {
    "id": 1,
    "title": "Название материала 1",
    "materialType": "Тип материала 1",
    "materialURL": "Ссылка на материал 1",
    "materialText": "Описание материала 1"
  },
  {
    "id": 3,
    "title": "Название материала 2",
    "materialType": "Тип материала 2",
    "materialURL": "Ссылка на материал 2",
    "materialText": "Описание материала 2"
  }
]




```

### `  api/admin/getAllMaterials`

#### Описание

Получение всех материалов.

#### Метод
- **GET**: Получить все материалы.

#### Пример ответа

```json
[
  {
    "id": 1,
    "title": "Задача 1",
    "description": "Описание задачи 1",
    "dateOfCreation": "22-10-2024",
    "lessonTitle": "Тема 1",
    "courseTitle": "Курс 1",
    "emulation": {
      "id": 1,
      "private_title": "Эмуляция 1",
      "dateOfCreation": "22-09-2024",
      "timerTime": "",
      "timerDescription": "",
      "screenImageURL": "",
      "blockSchemeJSON": "",
      "blockCodeJS": "",
      "byteArrayInterface": ""
    }
  },
  {
    "id": 2,
    "title": "Задача 2",
    "description": "Описание задачи 2",
    "dateOfCreation": "22-10-2024",
    "lessonTitle": "Тема 1",
    "courseTitle": "Курс 1",
    "emulation": {
      "id": 2,
      "private_title": "Эмуляция 2",
      "dateOfCreation": "22-09-2024",
      "timerTime": "",
      "timerDescription": "",
      "screenImageURL": "",
      "blockSchemeJSON": "",
      "blockCodeJS": "",
      "byteArrayInterface": ""
    }
  },
  {
    "id": 3,
    "title": "Задача 3",
    "description": "Описание задачи 3",
    "dateOfCreation": "22-10-2024",
    "lessonTitle": "Тема 1",
    "courseTitle": "Курс 1",
    "emulation": {
      "id": 3,
      "private_title": "Эмуляция 3",
      "dateOfCreation": "22-09-2024",
      "timerTime": "",
      "timerDescription": "",
      "screenImageURL": "",
      "blockSchemeJSON": "",
      "blockCodeJS": "",
      "byteArrayInterface": ""
    }
  }

]
```

## Запросы для эмуляций

### `/api/admin/createEmulation`

#### Описание
Создает новую эмуляцию.<br>
Проверяет на null
#### Метод
- **POST**: Создать новую эмуляцию

#### Параметры
- **private_title**: Название эмуляции.
- **dateOfCreation**: Дата создания эмуляции.
- **timerTime**: Таймер для задачи.
- **timerDescription**: Описание таймера для задачи.
- **screenImageURL**: Ссылка на изображение.
- **blockSchemeJSON**: JSON-файл с блок-схемой.
- **blockCodeJS**: Код для эмуляции на JS.
- **byteArrayInterface**: Дамп интерфейса в виде байт-кода.
- **task**: Задача.

#### Пример ответа
```json
{
  "result": "all_ok"
}
```

### `api/user/getTaskEmulation/?course_id=&theme_id=&task_id=`

#### Описание

Получение пользователем эмуляции по id курса, id темы и id задачи.\
Проверка на то, что у пользователя есть доступ к этому курсу и к этой теме.

#### Метод
- **GET**: Получить эмуляцию задачи.

### Параметры
- **course_id**. id курса.
- **theme_id**. id темы.
- **task_id**. id задачи

#### Пример ответа

```json
[
  {
    "id": 1,
    "private_title": "Эмуляция 1",
    "dateOfCreation": "22-09-2024",
    "timerTime": "",
    "timerDescription": "",
    "screenImageURL": "",
    "blockSchemeJSON": "",
    "blockCodeJS": "",
    "byteArrayInterface": ""
  }
]

```

### `api/admin/getTaskEmulation/?task_id=`

#### Описание

Получение админом эмуляции по id задачи.\
Проверка на то, что задача существует.

#### Метод
- **GET**: Получить эмуляцию задачи.

### Параметры
- **task_id**. id задачи

#### Пример ответа

```json
[
  {
    "id": 1,
    "private_title": "Эмуляция 1",
    "dateOfCreation": "22-09-2024",
    "timerTime": "",
    "timerDescription": "",
    "screenImageURL": "",
    "blockSchemeJSON": "",
    "blockCodeJS": "",
    "byteArrayInterface": ""
  }
]

```

### `api/admin/getAllEmulations`

#### Описание

Получение админом всех эмуляций.

#### Метод
- **GET**: Получить все эмуляции.

#### Пример ответа

```json
[
  {
    "id": 1,
    "private_title": "Эмуляция 1",
    "dateOfCreation": "22-09-2024",
    "timerTime": "",
    "timerDescription": "",
    "screenImageURL": "",
    "blockSchemeJSON": "",
    "blockCodeJS": "",
    "byteArrayInterface": ""
  },
  {
    "id": 2,
    "private_title": "Эмуляция 2",
    "dateOfCreation": "22-09-2024",
    "timerTime": "",
    "timerDescription": "",
    "screenImageURL": "",
    "blockSchemeJSON": "",
    "blockCodeJS": "",
    "byteArrayInterface": ""
  },
  {
    "id": 3,
    "private_title": "Эмуляция 3",
    "dateOfCreation": "22-09-2024",
    "timerTime": "",
    "timerDescription": "",
    "screenImageURL": "",
    "blockSchemeJSON": "",
    "blockCodeJS": "",
    "byteArrayInterface": ""
  }
]

```