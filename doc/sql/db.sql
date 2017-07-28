/*
警告: 字段名可能非法 - desc
警告: 字段名可能非法 - type
警告: 字段名可能非法 - status
警告: 字段名可能非法 - comment
*/
create table  t_wk_projects
(
       id                VARCHAR(4000) not null,
       name              VARCHAR(4000),
       DESC              VARCHAR(4000),
       TYPE              INTEGER,
       creator           VARCHAR(4000),
       createdate        DATETIME,
       STATUS            INTEGER,
       COMMENT           VARCHAR(4000)
);
alter  table t_wk_projects
       add constraint PK_t_wk_projects_id primary key (id);


/*
警告: 字段名可能非法 - desc
警告: 字段名可能非法 - status
警告: 字段名可能非法 - comment
*/
create table  t_wk_tasks
(
       id                VARCHAR(4000) not null,
       pid               VARCHAR(4000),
       title             VARCHAR(4000),
       DESC              VARCHAR(4000),
       STATUS            INTEGER,
       creator           VARCHAR(4000),
       createtime        DATETIME,
       COMMENT           VARCHAR(4000),
       planid            VARCHAR(4000),
       owner             VARCHAR(4000),
       typeid            VARCHAR(4000)
);
alter  table t_wk_tasks
       add constraint PK_t_wk_tasks_id primary key (id);


/*
警告: 字段名可能非法 - type
警告: 字段名可能非法 - comment
*/
create table  t_wk_tasktimes
(
       id                VARCHAR(4000) not null,
       pid               VARCHAR(4000),
       TYPE              VARCHAR(4000),
       mintime           VARCHAR(4000),
       maxtime           VARCHAR(4000),
       istimeout         INTEGER,
       creator           VARCHAR(4000),
       createtime        DATETIME,
       COMMENT           VARCHAR(4000)
);
alter  table t_wk_tasktimes
       add constraint PK_t_wk_tasktimes_id primary key (id);


/*
警告: 字段名可能非法 - time
警告: 字段名可能非法 - comment
*/
create table  t_wk_times
(
       id                VARCHAR(4000) not null,
       pid               INTEGER,
       TIME              DATETIME,
       COMMENT           VARCHAR(4000),
       creator           VARCHAR(4000),
       createtime        DATETIME,
       istimeout         INTEGER
);
alter  table t_wk_times
       add constraint PK_t_wk_times_id primary key (id);


/*
警告: 字段名可能非法 - status
*/
create table  t_wk_task2proj
(
       id                VARCHAR(4000) not null,
       pid               VARCHAR(4000),
       tid               VARCHAR(4000),
       STATUS            INTEGER
);
alter  table t_wk_task2proj
       add constraint PK_t_wk_task2proj_id primary key (id);


/*
警告: 字段名可能非法 - desc
警告: 字段名可能非法 - status
警告: 字段名可能非法 - comment
*/
create table  t_wk_plans
(
       id                VARCHAR(4000) not null,
       name              VARCHAR(4000),
       DESC              VARCHAR(4000),
       creator           VARCHAR(4000),
       createtime        DATETIME,
       STATUS            INTEGER,
       COMMENT           VARCHAR(4000)
);
alter  table t_wk_plans
       add constraint PK_t_wk_plans_id primary key (id);


/*
警告: 字段名可能非法 - status
警告: 字段名可能非法 - desc
警告: 字段名可能非法 - comment
*/
create table  t_wk_depts
(
       id                VARCHAR(4000) not null,
       pid               INTEGER,
       STATUS            INTEGER,
       name              VARCHAR(4000),
       DESC              VARCHAR(4000),
       COMMENT           VARCHAR(4000)
);
alter  table t_wk_depts
       add constraint PK_t_wk_depts_id primary key (id);


/*
警告: 字段名可能非法 - status
*/
create table  t_wk_employees
(
       id                VARCHAR(4000) not null,
       employid          INTEGER,
       name              VARCHAR(4000),
       age               INTEGER,
       tel               VARCHAR(4000),
       email             VARCHAR(4000),
       sex               DATETIME,
       STATUS            INTEGER,
       deptid            VARCHAR(4000)
);
alter  table t_wk_employees
       add constraint PK_t_wk_employees_id primary key (id);


/*
警告: 字段名可能非法 - desc
警告: 字段名可能非法 - status
警告: 字段名可能非法 - comment
*/
create table  t_wk_tasktypes
(
       id                INTEGER not null,
       name              INTEGER,
       DESC              VARCHAR(4000),
       color             VARCHAR(4000),
       ctype             INTEGER,
       cclore            INTEGER,
       STATUS            INTEGER,
       COMMENT           VARCHAR(4000)
);
alter  table t_wk_tasktypes
       add constraint PK_t_wk_tasktypes_id primary key (id);


/*
警告: 字段名可能非法 - desc
警告: 字段名可能非法 - type
警告: 字段名可能非法 - status
警告: 字段名可能非法 - comment
*/


/*
警告: 字段名可能非法 - desc
警告: 字段名可能非法 - status
警告: 字段名可能非法 - comment
*/
alter  table t_wk_tasks
       add constraint FK_t_wk_tasks_planid foreign key (planid)
       references t_wk_plans(id);
alter  table t_wk_tasks
       add constraint FK_t_wk_tasks_owner foreign key (owner)
       references t_wk_employees(id);
alter  table t_wk_tasks
       add constraint FK_t_wk_tasks_typeid foreign key (typeid)
       references t_wk_tasktypes(id);

/*
警告: 字段名可能非法 - type
警告: 字段名可能非法 - comment
*/
alter  table t_wk_tasktimes
       add constraint FK_t_wk_tasktimes_pid foreign key (pid)
       references t_wk_tasks(id);

/*
警告: 字段名可能非法 - time
警告: 字段名可能非法 - comment
*/
alter  table t_wk_times
       add constraint FK_t_wk_times_pid foreign key (pid)
       references t_wk_tasktimes(id);

/*
警告: 字段名可能非法 - status
*/
alter  table t_wk_task2proj
       add constraint FK_t_wk_task2proj_pid foreign key (pid)
       references 项目名称(id);
alter  table t_wk_task2proj
       add constraint FK_t_wk_task2proj_tid foreign key (tid)
       references t_wk_tasks(id);

/*
警告: 字段名可能非法 - desc
警告: 字段名可能非法 - status
警告: 字段名可能非法 - comment
*/


/*
警告: 字段名可能非法 - status
警告: 字段名可能非法 - desc
警告: 字段名可能非法 - comment
*/


/*
警告: 字段名可能非法 - status
*/
alter  table t_wk_employees
       add constraint FK_t_wk_employees_deptid foreign key (deptid)
       references t_wk_depts(id);

/*
警告: 字段名可能非法 - desc
警告: 字段名可能非法 - status
警告: 字段名可能非法 - comment
*/


