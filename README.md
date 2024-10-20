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
- **POST**: Выйти из приложения

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

## Тестовые запросы для ребят с бека (тут отличается реализация, нужно посмотреть в код), фронт при желании может потестить их

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

### `/api/user/getUserCourses`

#### Описание

Тестовый запрос доступ чтобы получить курсы залогиненного пользователя

#### Метод

- **GET**: Общий тестовый запрос

### Параметры

- **user**. Залогиненный пользователнь

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

### `api/user/getThemeTasks/<course_id>_<theme_id>`

#### Описание

Тестовый запрос доступ чтобы получить получить задачи темы по id

#### Метод

- **GET**: Общий тестовый запрос

### Параметры

- **user**. Залогиненый пользователь.
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

### ` api/user/getCourseThemes/<course_id>`

#### Описание

Тестовый запрос, чтобы получить темы по id курса

#### Метод

- **GET**: Общий тестовый запрос

### Параметры

- **user**. Залогиненный пользователь.
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

### ` api/user/getThemeMaterials/<course_id>_<theme_id> -`

#### Описание

Тестовый запрос, чтобы получить материалы темы по id

#### Метод

- **GET**: Общий тестовый запрос

### Параметры

- **user**. Залогиненный пользователь.
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

### ` api/admin/getAllCourses  -`

#### Описание

Тестовый запрос, чтобы получить все возможные курсы

#### Метод

- **GET**: Общий тестовый запрос

### Параметры


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

### ` api/admin/getAllThemes  -`

#### Описание

Тестовый запросб, чтобы получить все возможные темы

#### Метод

- **GET**: Общий тестовый запрос

### Параметры


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
### `  api/admin/getAllTasks  -`

#### Описание

Тестовый запрос, чтобы получить все возможные задачи

#### Метод

- **GET**: Общий тестовый запрос

### Параметры


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

### `  api/admin/getCourse/<course_id>  -`

#### Описание

Тестовый запрос, чтобы получить курс по id

#### Метод

- **GET**: Общий тестовый запрос

### Параметры
- **course_id**. id курса.
#### Пример ответа

```json


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
}





```
### `   api/admin/getTheme/<theme_id>  -`

#### Описание

Тестовый запрос, чтобы получить тему по id

#### Метод

- **GET**: Общий тестовый запрос

### Параметры
- **theme_id**. id темы.
#### Пример ответа

```json


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





```