create table tasks
(
    id          bigserial
        primary key,
    description varchar(255),
    due_date    date,
    priority    varchar(255),
    status      varchar(255),
    title       varchar(255)
);


INSERT INTO tasks (id, description, due_date, priority, status, title)
VALUES (DEFAULT, 'task1', '2024-10-18', 'LOW', 'TODO', 'task1');

INSERT INTO tasks (id, description, due_date, priority, status, title)
VALUES (DEFAULT, 'task2', '2024-11-18', 'MEDIUM', 'TODO', 'task2');

INSERT INTO tasks (id, description, due_date, priority, status, title)
VALUES (DEFAULT, 'task3', '2024-12-18', 'HIGH', 'IN_PROGRESS', 'task3');

INSERT INTO tasks (id, description, due_date, priority, status, title)
VALUES (DEFAULT, 'task4', '2024-06-18', 'HIGH', 'DONE', 'task4');