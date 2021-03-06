

create table YELPUSERS(
YELPING_SINCE  date,
NAME varchar2(150),
REVIEW_COUNT number,
USER_ID varchar2(100),
AVG_STARS float,
FRIENDS_COUNT number,
PRIMARY KEY(USER_ID)
);




Create table business (
business_id VARCHAR2(100),
CITY VARCHAR2(50),
REVIEW_COUNT NUMBER,
STARS number(5,3),
STATE varchar2(15),
NAME varchar2(150),
PRIMARY KEY (business_id)
);

CREATE TABLE MAINCATEGORY(
  CAT_ID VARCHAR2(100) NOT NULL,
  NAME VARCHAR2(255) NOT NULL,
  PRIMARY KEY (CAT_ID),
  CONSTRAINT unique_category UNIQUE (NAME));



CREATE TABLE SUB_CATEGORY (
  SUBCATNAME VARCHAR2(255) NOT NULL,
  PRIMARY KEY (SUBCATNAME));



CREATE TABLE cat_rel_sub (
  cat_id VARCHAR2(100) NOT NULL,
  subname VARCHAR2(100) NOT NULL,
  PRIMARY KEY (cat_id, subname)
 ,
  CONSTRAINT SUB_CATEGORY
    FOREIGN KEY (subname)
    REFERENCES SUB_CATEGORY (SUBCATNAME)
    ON DELETE CASCADE
   ,
  CONSTRAINT MAINCATEGORY
    FOREIGN KEY (cat_id)
    REFERENCES MAINCATEGORY (cat_id)
    ON DELETE CASCADE
   );




CREATE TABLE check_in (
  DAYANDTIME NUMBER(8,5),
  IN_COUNT NUMBER(5),
  business_id VARCHAR2(100) NULL,
  PRIMARY KEY (DAYANDTIME,business_id)
 ,
    FOREIGN KEY (business_id)
    REFERENCES business (business_id)
   )
;


CREATE TABLE REVIEW (
  REVIEW_ID VARCHAR2(100) NOT NULL,
  DATE_OF_REVIEW date NULL,
  STARS NUMBER(5,3) NULL,
  USER_ID VARCHAR2(100) NULL,
  business_id  VARCHAR2(100) NULL,
  VOTES number(5),
  TEXT LONG,
  PRIMARY KEY (REVIEW_ID)
 ,
  CONSTRAINT review_author
    FOREIGN KEY (USER_ID)
    REFERENCES YELPUSERS (USER_ID)
   ,
  CONSTRAINT business_review
    FOREIGN KEY (business_id)
    REFERENCES business (business_id) ON DELETE CASCADE
   )
;






create table BUS_CAT_SUB(
CATEGORY_NAME VARCHAR2(150) NOT NULL,
SUB_CATEGORY_NAME VARCHAR2(150) NOT NULL,
business_id VARCHAR2(100) NULL,
PRIMARY KEY(Business_Id,SUB_CATEGORY_NAME,CATEGORY_NAME)
  ,
  CONSTRAINT business_id
    FOREIGN KEY (business_id)
    REFERENCES business (business_id) ON DELETE CASCADE
);

