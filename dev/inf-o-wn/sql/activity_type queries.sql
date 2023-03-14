SELECT 
    *
FROM
    activity_type;

SELECT 
    *
FROM
    activity_type
ORDER by
	name asc;


ALTER TABLE activity_type AUTO_INCREMENT = 1;

DELETE FROM activity_type;

INSERT INTO activity_type (name)
VALUES ('Swimmingming'),('Hiking');