<!-- README.md -->

<h1 align="center">💸 Expense Tracker (Backend)</h1>

<p align="center">
  Простое приложение для отслеживания расходов на Spring Boot без фронтенда.<br/>
  Тестирование происходило через <strong>Postman</strong>.
</p>

<p align="center">
  <img src="https://img.shields.io/badge/status-in%20progress-yellow" alt="Project Status" />
  <img src="https://img.shields.io/badge/backend-Spring%20Boot-green" alt="Backend: Spring Boot" />
  <img src="https://img.shields.io/badge/front-отсутствует-lightgrey" alt="No Frontend" />
</p>

<hr/>

## 📌 Описание

Данное приложение позволяет:

- Добавлять, изменять и удалять расходы
- Получать список всех трат
- Фильтровать и группировать расходы (опционально)
- Хранить данные в базе (PostgreSQL)

---

## 🧪 Проверка работоспособности

Все запросы выполнялись и проверялись через |Postman|  
Пример запроса `POST` для создания нового расхода:
POST /api/expenses
Content-Type: application/json

{
"title": "Продукты",
"amount": 1500,
"category": "Еда"
}

⚙️ Технологии

- Java 17
- Spring Boot
- Spring Data JPA
- PostgreSQL
- Maven
- Postman (для тестирования)

---

## 🚀 Запуск

```bash
# Клонируем репозиторий
git clone https://github.com/your-username/expense-tracker.git
cd expense-tracker

# Запускаем приложение
./mvnw spring-boot:run

Статус проекта
✅ Базовая логика CRUD реализована
🧪 Все эндпоинты протестированы через Postman
🚧 В планах: добавить авторизацию


