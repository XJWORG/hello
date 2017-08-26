/*
警告: 字段名可能非法 - DESCRIPTION
警告: 字段名可能非法 - type
警告: 字段名可能非法 - status
警告: 字段名可能非法 - comment
*/
create table  t_wk_projects
(
       id                VARCHAR(256) not null,
       name              VARCHAR(256),
       DESCRIPTION              VARCHAR(256),
       TYPE              INTEGER,
       creator           VARCHAR(256),
       createdate        DATETIME,
       STATUS            INTEGER,
       COMMENT           VARCHAR(256)
);
alter  table t_wk_projects
       add constraint PK_t_wk_projects_id primary key (id);


/*
警告: 字段名可能非法 - DESCRIPTION
警告: 字段名可能非法 - status
警告: 字段名可能非法 - comment
*/
create table  t_wk_tasks
(
       id                VARCHAR(256) not null,
       pid               VARCHAR(256),
       title             VARCHAR(256),
       DESCRIPTION              VARCHAR(256),
       STATUS            INTEGER,
       creator           VARCHAR(256),
       createtime        DATETIME,
       COMMENT           VARCHAR(256),
       planid            VARCHAR(256),
       owner             VARCHAR(256),
       typeid            VARCHAR(256)
);
alter  table t_wk_tasks
       add constraint PK_t_wk_tasks_id primary key (id);


/*
警告: 字段名可能非法 - type
警告: 字段名可能非法 - comment
*/
create table  t_wk_tasktimes
(
       id                VARCHAR(256) not null,
       pid               VARCHAR(256),
       TYPE              VARCHAR(256),
       mintime           VARCHAR(256),
       maxtime           VARCHAR(256),
       istimeout         INTEGER,
       creator           VARCHAR(256),
       createtime        DATETIME,
       COMMENT           VARCHAR(256)
);
alter  table t_wk_tasktimes
       add constraint PK_t_wk_tasktimes_id primary key (id);


/*
警告: 字段名可能非法 - time
警告: 字段名可能非法 - comment
*/
create table  t_wk_times
(
       id                VARCHAR(256) not null,
       pid               INTEGER,
       TIME              DATETIME,
       COMMENT           VARCHAR(256),
       creator           VARCHAR(256),
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
       id                VARCHAR(256) not null,
       pid               VARCHAR(256),
       tid               VARCHAR(256),
       STATUS            INTEGER
);
alter  table t_wk_task2proj
       add constraint PK_t_wk_task2proj_id primary key (id);


/*
警告: 字段名可能非法 - DESCRIPTION
警告: 字段名可能非法 - status
警告: 字段名可能非法 - comment
*/
create table  t_wk_plans
(
       id                VARCHAR(256) not null,
       name              VARCHAR(256),
       DESCRIPTION              VARCHAR(256),
       creator           VARCHAR(256),
       createtime        DATETIME,
       STATUS            INTEGER,
       COMMENT           VARCHAR(256)
);
alter  table t_wk_plans
       add constraint PK_t_wk_plans_id primary key (id);


/*
警告: 字段名可能非法 - status
警告: 字段名可能非法 - DESCRIPTION
警告: 字段名可能非法 - comment
*/
create table  t_wk_depts
(
       id                VARCHAR(256) not null,
       pid               INTEGER,
       STATUS            INTEGER,
       name              VARCHAR(256),
       DESCRIPTION              VARCHAR(256),
       COMMENT           VARCHAR(256)
);
alter  table t_wk_depts
       add constraint PK_t_wk_depts_id primary key (id);


/*
警告: 字段名可能非法 - status
*/
create table  t_wk_employees
(
       id                VARCHAR(256) not null,
       employid          INTEGER,
       name              VARCHAR(256),
       age               INTEGER,
       tel               VARCHAR(256),
       email             VARCHAR(256),
       sex               DATETIME,
       STATUS            INTEGER,
       deptid            VARCHAR(256)
);
alter  table t_wk_employees
       add constraint PK_t_wk_employees_id primary key (id);


/*
警告: 字段名可能非法 - DESCRIPTION
警告: 字段名可能非法 - status
警告: 字段名可能非法 - comment
*/
create table  t_wk_tasktypes
(
       id                INTEGER not null,
       name              INTEGER,
       DESCRIPTION              VARCHAR(256),
       color             VARCHAR(256),
       ctype             INTEGER,
       cclore            INTEGER,
       STATUS            INTEGER,
       COMMENT           VARCHAR(256)
);
alter  table t_wk_tasktypes
       add constraint PK_t_wk_tasktypes_id primary key (id);


/*
警告: 字段名可能非法 - DESCRIPTION
警告: 字段名可能非法 - type
警告: 字段名可能非法 - status
警告: 字段名可能非法 - comment
*/


/*
警告: 字段名可能非法 - DESCRIPTION
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
警告: 字段名可能非法 - DESCRIPTION
警告: 字段名可能非法 - status
警告: 字段名可能非法 - comment
*/


/*
警告: 字段名可能非法 - status
警告: 字段名可能非法 - DESCRIPTION
警告: 字段名可能非法 - comment
*/


/*
警告: 字段名可能非法 - status
*/
alter  table t_wk_employees
       add constraint FK_t_wk_employees_deptid foreign key (deptid)
       references t_wk_depts(id);

/*
警告: 字段名可能非法 - DESCRIPTION
警告: 字段名可能非法 - status
警告: 字段名可能非法 - comment
*/


