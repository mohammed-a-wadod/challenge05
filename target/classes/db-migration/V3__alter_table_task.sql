alter table tasks alter column due_date type timestamp using due_date::timestamp;

alter table tasks add user_task_mail varchar;

update tasks set user_task_mail = 'eng.mohamed.abdelwadod@gmail.com';