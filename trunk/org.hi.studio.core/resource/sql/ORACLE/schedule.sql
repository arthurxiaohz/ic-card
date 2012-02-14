BEGIN
  EXECUTE IMMEDIATE 'DROP TABLE HI_JobDetailDef';
EXCEPTION WHEN OTHERS THEN
    NULL;
END;
/---
CREATE TABLE HI_JobDetailDef (
    id number NOT NULL ,
    version number NOT NULL ,
    jobName varchar2(80) NOT NULL,
    jobGroup varchar2(80) NULL,
    jobClassName varchar2(128) NOT NULL,
    durable number NULL,
    volatiled number NULL,
    shouldRecover number NULL,
    description varchar2(300) NULL,
    creator number  NULL )
/---
ALTER TABLE HI_JobDetailDef ADD (
      CONSTRAINT pk_HI_JobDetailDef PRIMARY KEY (id)
)

/---

BEGIN
  EXECUTE IMMEDIATE 'DROP TABLE HI_TriggerDef';
EXCEPTION WHEN OTHERS THEN
    NULL;
END;
/---
CREATE TABLE HI_TriggerDef (
    id number NOT NULL ,
    version number NOT NULL ,
    triggerName varchar2(80) NOT NULL,
    triggerGroup varchar2(80) NULL,
    jobDetail number  NULL,
    volatiled number NULL,
    nextFireTime date NULL,
    prevFireTime date NULL,
    priority number NULL,
    triggerStats number NULL,
    startTime date NULL,
    endTime date NULL,
    misfireInstr number NULL,
    cronExpression varchar2(80) NOT NULL,
    enabled number NULL,
    timeZone number NULL,
    description varchar2(300) NULL,
    creator number  NULL )
/---
ALTER TABLE HI_TriggerDef ADD (
      CONSTRAINT pk_HI_TriggerDef PRIMARY KEY (id)
)

/---

