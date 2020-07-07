CREATE SCHEMA IF NOT EXISTS vger_support;

CREATE TABLE IF NOT EXISTS vger_support.reserve_items_course_term
(
srs_number	VARCHAR(10),
course_name	VARCHAR(50),
location	VARCHAR(60),
library_name	VARCHAR(60),
map_link	VARCHAR(100),
item_id	        INT,
title	        VARCHAR(2000),
item_enum	VARCHAR(80),
copy_number	INT,
call_no	        VARCHAR(300),
item_status	VARCHAR(4000),
quarter	        VARCHAR(4000),
oclc	        VARCHAR(4000)
);

CREATE TABLE IF NOT EXISTS vger_support.reserve_courses
(
course_number	VARCHAR(40),
course_name	VARCHAR(40),
section_id	INT,
department_id	INT,
srs_number	VARCHAR(10),
quarter	        VARCHAR(4000),
url	        VARCHAR(4000)
);

CREATE TABLE IF NOT EXISTS vger_support.reserve_departments
(
department_id	INT,
department_code	VARCHAR(10),
department_name	VARCHAR(40),
quarter	        VARCHAR(4000)
);

CREATE ALIAS IF NOT EXISTS vger_support.get_current_quarter AS  '
import java.time.LocalDate;
@CODE
String get_current_quarter()
{
  String quarter;

  switch ( LocalDate.now().getMonthValue() )
  {
    case 1 :
    case 2 :
    case 3 :
      quarter = "W";
      break;
    case 4 :
    case 5 :
    case 6 :
      quarter = "S";
      break;
    case 7 :
    case 8 :
    case 9 :
      quarter = "1";
      break;
    case 10 :
    case 11 :
    case 12 :
      quarter = "F";
      break;
    default:
      quarter = "?";
  }
  
  return String.valueOf( LocalDate.now().getYear() % 2000 ).concat( quarter );
}
';