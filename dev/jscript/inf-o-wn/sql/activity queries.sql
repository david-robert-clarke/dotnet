select * from activity;

delete from activity;

ALTER TABLE activity AUTO_INCREMENT = 1;

Insert into activity (date,type_id,location_id,distance,height)
values ('2012-12-28 00:00:00',1,1,NULL,4572);