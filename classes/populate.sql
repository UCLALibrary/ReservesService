DELETE FROM vger_support.reserve_items_course_term;
DELETE FROM vger_support.reserve_courses;
DELETE FROM vger_support.reserve_departments;

COMMIT;

INSERT INTO vger_support.reserve_items_course_term(srs_number,course_name,location,library_name,map_link,item_id,title,item_enum,copy_number,call_no,item_status,quarter,oclc) VALUES ('028318110','DIS STDM103 MONSTER FREAK CYBORG RE IMAGININ','Powell Library Inquiry Desk 2-Hour Reserves','College Library','http://www.library.ucla.edu/about/2065.cfm',27344,'DIS STD M103 : E - RESERVES : Butler Parable',null,null,null,'Not Charged','201',null);
INSERT INTO vger_support.reserve_items_course_term(srs_number,course_name,location,library_name,map_link,item_id,title,item_enum,copy_number,call_no,item_status,quarter,oclc) VALUES ('121030110','ASIA AM010 HISTORY OF ASIAN AMERICANS','Powell Library Inquiry Desk 2-Hour Reserves','College Library','http://www.library.ucla.edu/about/2065.cfm',27304,'ASIA AM 10 : E - RESERVES : Asian/Pacific Islander American women',null,null,null,'Not Charged','201',null);

COMMIT;

INSERT INTO vger_support.reserve_courses(course_number,course_name,section_id,department_id,srs_number,quarter,url) VALUES('015','Women and Power in Ancient World',26722,2,'286045200','201','http://this.com');
INSERT INTO vger_support.reserve_courses(course_number,course_name,section_id,department_id,srs_number,quarter,url) VALUES('001','Introduction to Black Studies',25603,2,'413001910','201','http://that.com');

COMMIT;

INSERT INTO vger_support.reserve_departments(department_id,department_code,department_name,quarter) VALUES (2,'AN N EA','Ancient and Near East','201');
INSERT INTO vger_support.reserve_departments(department_id,department_code,department_name,quarter) VALUES (2,'AF AMER','African American Studies','201');

COMMIT;
