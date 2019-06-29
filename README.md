Описание 
---

Промежуточный проект по курсу  "Автоматизированное тестирование" проекта "Технополис".

Цель
---

Демонстрация применения паттерна "promise" при тестировании сайта "Одноклассники" 
на примере групп. 
Они бывают нескольких видов:
* Пользователь состоит в группе 
* Пользователь является администратором группы
* Пользователь не состоит в группе
* Пользователь ожидает одобрения заявки

Конфигурационный файл
---

Пример конфигурационного файла:

    login = login@email.com
    password = 12345
    groupInWhichUserIsMember = https://ok.ru/groupInWhichUserIsMember 
    groupInWhichUserIsNotMember = https://ok.ru/groupInWhichUserIsNotMember
    groupInWhichUserIsAdministrator = https://ok.ru/groupInWhichUserIsAdministrator
    groupInWhichUserWaitingForConfirmation = https://ok.ru/groupInWhichUserWaitingForConfirmation
    
login - логин пользователя на сайте Одноклассники
password - пароль пользователя на сайте Одноклассники
groupInWhichUserIsMember - ссылка на группу, в которой пользователь является участником 
groupInWhichUserIsNotMember - ссылка на группу, в которой пользователь не состоит
groupInWhichUserIsAdministrator - ссылка на группу, в которой пользователь является администратором
groupInWhichUserWaitingForConfirmation - ссылка на группу, в которой пользователь ожидает одобрение подтверждения