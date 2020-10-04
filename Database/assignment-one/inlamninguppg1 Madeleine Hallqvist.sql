--Skapar databas
create database bocker;

--Skapar alla tabler
create table amnesOmrade(
amnesOmradeID int not null auto_increment,
amnesNamn varchar(50),
primary key(amnesOmradeID)
);

create table bok(
bokId int not null auto_increment,
bokTitle varchar(50),
bokNummer int not null,
bokAmnesOmradeId int, 
bokInkopsDatum date, 
bokPris int,
primary key(bokId),
UNIQUE(bokNummer),
FOREIGN KEY (bokAmnesOmradeId) REFERENCES amnesOmrade(amnesOmradeID)
);

create table avdelning(
avdelningID int not null auto_increment,
avdelningNamn varchar(50),
primary key(avdelningID)
);

create table anstallda(
anstalldaId int not null auto_increment,
anstalldaNamn varchar(50),
anstalldaAvdelningId int, 
anstalldaTelefonNr int,
anstalldaPersNr int, 
primary key(anstalldaId),
FOREIGN key(anstalldaAvdelningId) REFERENCES avdelning(avdelningID)
);

create table utlaning(
utlanId  int not null auto_increment,
utlanAid int, 
utlanBId int, 
utlanLamnaIn date,
utlanDatum date, 
primary key(utlanId),
FOREIGN key(utlanAid) REFERENCES anstallda(anstalldaId),
FOREIGN key(utlanBId) REFERENCES bok(bokid)
);

--Lägger till info i tablerna

insert into amnesOmrade(amnesNamn) values('Webb'),('Databas'),('Programering'),('Ekonomi och Juridik'),('Ordbehandling'),('Sälj'),('Marknadsföring');

insert into bok(bokTitle,bokNummer,bokAmnesOmradeId,bokInkopsDatum,bokPris,bokForfattare) 
	values('SQL-introduktion',999,2,'2018-10-20',100,'Mikael SegerLund'),('Mathemtische Modellierung',1000,2,'2013-03-26',500,'Ulrich Knauer'),
	('Journal on Data Sematics VII',1001,2,'2015-09-01',500,'Stefano Spaccapietra'),('Big Java',1002,3,'2018-05-07',500,'Cay S.Horstmann'),
	('Clean Code',1004,3,'2018-10-20',200,'Robert C.Martin'),('Clean Architecture',1005,3,'2018-03-26',200,'Robert C.Martin'),
	('User Story Mapping',1006,3,'2015-09-01',100,'Jeff Patton'),('Beginning JavaScript',1007,1,'2018-03-26',200,'Jermy McPeak'),
	('Learning Web Design: A',1008,1,'2018-10-20',500,'Jennifer Robbins'),('HTML and CSS: Design and Build Websites',1009,1,'2018-05-07',200,'Jon Duckett'),
	('Skattelagstiftning 19:1',1010,4,'2015-09-01',100,'Gunnar Rabe'),('FactFulness',1011,4,'2018-03-26',500,'Hans Rosling'),
	('Tänka, snabbt och långsamt',1012,4,'2018-10-20',200,'Daniel Kahneman'),('Grejen med substantiv och pronomen',1013,5,'2013-03-26',100,'Sara LöveStam'),
	('Grundhjulet',1014,5,'2013-03-26',100,'Kristin Asker'),('Snacka snyggt: den stora boken',1015,5,'2015-09-01',200,'Elaine Eksvärd'),
	('Sälj! Konsten att sälja vad som helst',1016,6,'2018-05-07',100,'Fredrik Eklund'),('Sälj bra eller sälj bäst',1017,6,'2018-03-26',200,'Peppe Ekmark'),
	('Marknadsföring - modeller och principer',1018,7,'2015-09-01',500,'Per Wildenstam'),('Marknadsföring teorier',1019,7,'2018-05-07',500,'Anders Parment'),
	('Marknadsföring',1020,7,'2013-03-26',200,'Jens NordFält');

insert into avdelning(avdelningNamn) values('Administration'),('Ekonomi'),('Sälj'),('Utveckling'),('Marknadsföring');

insert into anstallda(anstalldaNamn,anstalldaAvdelningId,anstalldaTelefonNr,anstalldaPersNr)
values('Alice',1,0706665454,940402),('Liam',2,0708992930,890102),('Walter',3,0706578890,780903),
('Maja',4,0702222445,900503),('Fia',5,0700056868,8807083888),('Oliver',1,0766545454,770330),
('Hans',2,031324566,6410129),('Maryam',3,0755340302,920507),('Mira',4,0755443322,901224),
('Gabriel',5,0709992345,750626),('Harry',1,0706057788,770727),('Greta',2,0704040404,501111),
('Märta',3,0709999999,660809),('Alex',4,0707775566,910530);


insert into utlaning(utlanAid,utlanBId,utlanLamnaIn,utlanDatum)
	values(1,1,'2019-01-20','2019-01-10'),(2,11,'2019-03-09','2019-03-19'),
	(3,17,'2019-02-03','2019-02-13'),(4,4,'2019-03-10','2019-03-01'),
	(5,19,'2018-12-22','2018-12-12'),(6,12,'2018-11-21','2018-11-11'),
	(6,18,'2018-08-08','2018-07-28'),(3,1,'2018-02-15','2018-02-05'),
	(7,7,'2018-05-01','2018-04-21'),(8,21,'2019-03-19','2019-03-01'),
	(9,4, '2018-04-10','2018-04-01'),(10,10,'2018-06-01','2018-05-20'),
	(11,11,'2018-03-09','2018-03-19'),(12,12,'2018-12-01','2018-11-22'),
	(13,1,'2018-07-30','2018-07-20'),(14,7,'2018-12-22','2018-12-01');

insert into utlaning(utlanAid,utlanBId,utlanLamnaIn,utlanDatum)
values(1,12,'2019-04-10','2019-03-24'),(3,14,'2019-03-23','2019-04-13');

--Lägg till författare i bok tabel och utlaningsStatus i utlaning.  
alter table bok
add bokForfattare varchar(50);
alter table utlaning add utlanStatus varchar(50);



--Kontroll frågor
select *from bok;

SELECT bok.bokTitel, anstallda.anstalldaNamn
FROM anstallda INNER JOIN utlaning 
ON anstallda.anstalldaId = utlaning.utlanAid
INNER JOIN bok 
ON utlaning.utlanBId = bok.bokId;

--view som visar anställda ur avdelning 1 och vilka böcker de anställda lånat
create view ViewUtlanAns as
SELECT bok.bokTitle, anstallda.anstalldaNamn, utlaning.utlanDatum
FROM anstallda INNER JOIN utlaning 
ON anstallda.anstalldaId = utlaning.utlanAid
INNER JOIN bok 
ON utlaning.utlanBId = bok.bokId
where anstallda.anstalldaAvdId = 1;

select * from ViewUtlanAns;

--avg kostnad för böckerna
select avg(bokPris)from bok;

--sum kostnad för böckerna
select sum(bokPris)from bok;


--stored procedure, visar alla böckerna i en kategori. 
delimiter //
create procedure GetAmnesOmrade(in amnesOmrade varchar(50))
begin 
select bok.bokTitle, bok.bokForfattare, amnesOmrade.amnesOmradeNamn
from
amnesOmrade
inner join bok
on amnesOmrade.amnesOmradeId = bok.bokAmnesOmradeId
where
amnesOmrade.amnesOmradeNamn = amnesOmrade;
end //
-- Kör
CALL GetAmnesOmrade('programering');

DROP PROCEDURE IF EXISTS GetAmnesOmrade;

--Storde procedure, ändrar utlåningsstatus
delimiter //
create procedure UpdateUtlaningsStatus(in utlanNr varchar(50), in inStatus varchar(50))
begin
declare status varchar(50) default 'ej utlånad';
if inStatus <> status then
update utlaning set utlanStatus = inStatus where utlanBid = utlanNr;
end if;
end//

call UpdateUtlaningsStatus('2','utlånad');

DROP PROCEDURE IF EXISTS UpdateUtlaningsStatus;