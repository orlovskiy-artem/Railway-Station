INSERT INTO platform VALUES (1, 'Kyiv 1','Kyiv');
INSERT INTO platform VALUES (2, 'Kyiv 2','Kyiv');
INSERT INTO platform VALUES (3, 'Kyiv 3','Kyiv');
INSERT INTO platform VALUES (4, 'Lviv 1','Lviv');
INSERT INTO platform VALUES (5, 'Lviv 2','Lviv');
INSERT INTO platform VALUES (6, 'Kharkiv 1','Kharkiv');
INSERT INTO platform VALUES (7, 'Kharkiv 2','Kharkiv');
INSERT INTO platform VALUES (8, 'Dnipro 1','Dnipro');
INSERT INTO platform VALUES (9, 'Dnipro 2','Dnipro');


INSERT INTO train VALUES (1, 'Hyundai','Inter-city');
INSERT INTO train VALUES (2, 'Hyundai','Inter-city');
INSERT INTO train VALUES (3, 'Hyundai','Inter-city');


INSERT INTO route VALUES (1,1,4,1,'2021-07-11 08:00:00','2021-07-11 15:00:00');
INSERT INTO route VALUES (2,2,6,2,'2021-07-09 10:00:00','2021-07-09 15:00:00');
INSERT INTO route VALUES (3,8,7,3,'2021-07-14 13:00:00','2021-07-14 21:00:00');
INSERT INTO route VALUES (4,1,5,1,'2021-07-11 22:00:00','2021-07-12 05:00:00');

INSERT INTO SEAT VALUES (1, 'first-class', 1);
INSERT INTO SEAT VALUES (2, 'first-class', 1);
INSERT INTO SEAT VALUES (3, 'first-class', 1);
INSERT INTO SEAT VALUES (4, 'first-class', 1);

INSERT INTO SEAT VALUES (5, 'second-class', 1);
INSERT INTO SEAT VALUES (6, 'second-class', 1);
INSERT INTO SEAT VALUES (7, 'second-class', 1);
INSERT INTO SEAT VALUES (8, 'second-class', 1);

INSERT INTO SEAT VALUES (9, 'second-class', 1);
INSERT INTO SEAT VALUES (10, 'second-class', 1);
INSERT INTO SEAT VALUES (11, 'second-class', 1);
INSERT INTO SEAT VALUES (12, 'second-class', 1);


INSERT INTO SEAT VALUES (13, 'first-class', 2);
INSERT INTO SEAT VALUES (14, 'first-class', 2);
INSERT INTO SEAT VALUES (15, 'first-class', 2);
INSERT INTO SEAT VALUES (16, 'first-class', 2);
INSERT INTO SEAT VALUES (17, 'first-class', 2);
INSERT INTO SEAT VALUES (18, 'first-class', 2);
INSERT INTO SEAT VALUES (19, 'second-class', 2);
INSERT INTO SEAT VALUES (20, 'second-class', 2);
INSERT INTO SEAT VALUES (21, 'second-class', 2);
INSERT INTO SEAT VALUES (22, 'second-class', 2);

INSERT INTO SEAT VALUES (23, 'first-class', 3);
INSERT INTO SEAT VALUES (24, 'first-class', 3);
INSERT INTO SEAT VALUES (25, 'first-class', 3);
INSERT INTO SEAT VALUES (26, 'first-class', 3);
INSERT INTO SEAT VALUES (27, 'first-class', 3);
INSERT INTO SEAT VALUES (28, 'first-class', 3);
INSERT INTO SEAT VALUES (29, 'second-class', 3);
INSERT INTO SEAT VALUES (30, 'second-class', 3);
INSERT INTO SEAT VALUES (31, 'second-class', 3);
INSERT INTO SEAT VALUES (32, 'second-class', 3);



SELECT * FROM route r
INNER JOIN  platform p ON p.id = r.departure_platform_id
  INNER JOIN  platform p2 ON p2.id = r.arrival_platform_id
  INNER JOIN  train t ON t.id = r.train_id
 WHERE p.city='Kyiv' AND p2.city='Lviv';


SELECT * FROM ticket t
INNER JOIN  order_details od ON t.id = od.ticket_id
INNER JOIN route r ON r.id = od.route_id
INNER JOIN platform p on r.departure_platform_id = p.id
INNER JOIN platform p2 on p2.id = r.arrival_platform_id
WHERE t.id=1;

SELECT * FROM route r
INNER JOIN train t on r.train_id = t.id
INNER JOIN platform p on p.id = r.departure_platform_id
INNER JOIN platform p2 on p2.id = r.arrival_platform_id
WHERE r.id=1;

SELECT * FROM route r
                  INNER JOIN train t on r.train_id = t.id
                  INNER JOIN platform p on p.id = r.departure_platform_id
                  INNER JOIN platform p2 on p2.id = r.arrival_platform_id
WHERE r.id=1;

SELECT
       r.id as route_id,
        r.departure_datetime as route_departure_datetime,
        r.arrival_datetime as route_arrival_datetime,
        r.departure_platform_id as departure_platform_id,
        r.arrival_platform_id as arrival_platform_id,
        t.id as train_id,
        t.type as train_type,
        t.name as train_name,
        p.city as departure_city,
        p2.city as arrival_city,
        p.name as departure_platform_name,
        p2.name as arrival_platform_name
 FROM route r
  INNER JOIN  platform p ON p.id = r.departure_platform_id
  INNER JOIN  platform p2 ON p2.id = r.arrival_platform_id
  INNER JOIN  train t ON t.id = r.train_id
 WHERE p.city='Kyiv' AND p2.city='Lviv';