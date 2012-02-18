DROP TABLE IF EXISTS HI_JobDetailDef;
--
CREATE TABLE HI_JobDetailDef (
    id int auto_increment NOT NULL ,
    version int NOT NULL ,
    jobName nvarchar (80) NOT NULL,
    jobGroup nvarchar (80)  NULL,
    jobClassName nvarchar (128) NOT NULL,
    durable int   NULL,
    volatiled int   NULL,
    shouldRecover int   NULL,
    description nvarchar (300)  NULL,
    creator int  NULL,
    primary key (id));
--

DROP TABLE IF EXISTS HI_TriggerDef;
--
CREATE TABLE HI_TriggerDef (
    id int auto_increment NOT NULL ,
    version int NOT NULL ,
    triggerName nvarchar (80) NOT NULL,
    triggerGroup nvarchar (80)  NULL,
    jobDetail int  NULL,
    volatiled int   NULL,
    nextFireTime datetime   NULL,
    prevFireTime datetime   NULL,
    priority int   NULL,
    triggerStats int   NULL,
    startTime datetime   NULL,
    endTime datetime   NULL,
    misfireInstr int   NULL,
    cronExpression nvarchar (80) NOT NULL,
    enabled int   NULL,
    timeZone int   NULL,
    description nvarchar (300)  NULL,
    creator int  NULL,
    primary key (id));
--

