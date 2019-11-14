# taller4.1-JSolarte-JAlvarez
Programa Agencia de viajes usando MVC Y Cliente- Servidor
Scrip para base de datos
DROP TABLE CLIENTE
DROP TABLE PLAN

create table CLIENTE 
(
   ID        NUMERIC         not null,
   NOMBRES       VARCHAR(50),
   APELLIDOS     VARCHAR(50),
   DIRECCION     VARCHAR(128),
   CELULAR         NUMERIC,
   EMAIL         VARCHAR(100),
   SEXO          VARCHAR(1),
   FECHANAC      DATE,
   primary key (ID)
);

create TABLE PLAN
(
    ID   NUMERIC NOT NULL,
    NOMBRE  VARCHAR(50),
    DESCRIPCION VARCHAR(1200),
    RANGOEDADMENOR  NUMERIC,
    RANGOEDADMAYOR  NUMERIC,
    SEXO          VARCHAR(1),
    PRIMARY KEY(ID)
);

insert into CLIENTE values(98000001,'Antonio','Vega Soto',null,null,'libardo@hotmail.com','M','2000-02-01');
insert into CLIENTE values(98000002,'Carlos','Pantoja',null,null,'carlos@hotmail.com','M','1994-02-01');
insert into CLIENTE values(98000003,'Andrea Elizabeth','Sanchez',null,null,'andreaeli@hotmail.com','F','1994-02-01');
insert into CLIENTE values(98000004,'Fernanda','Arevalo',null,null,'fercha@hotmail.com','F','1993-01-01');

insert into CLIENTE values(98000005,'Ana','Torres',null,null,'anita@hotmail.com','F','1994-02-04');
insert into CLIENTE values(98000006,'Manuel','Perez',null,null,'manuel@hotmail.com','M','1980-05-01');
insert into CLIENTE values(98000007,'Alejandro','Mosquera',null,null,'ajemos@hotmail.com','M','1981-05-01');
insert into CLIENTE values(98000008,'Cesar','Gutierres',null,null,'cesar@hotmail.com','M','1982-05-01');
insert into CLIENTE values(98000009,'Marcos','Bravo',null,null,'julio@hotmail.com','M','1982-05-01');
insert into CLIENTE values(98000010,'Alberto','Mendez',null,null,'alberto@hotmail.com','M','1985-05-01');
insert into CLIENTE values(98000011,'Alexandra','Ponce',null,null,'anita@hotmail.com','F','1979-04-08');

insert into PLAN values(1,'Popayan-Purace','Conocer el avistamiento de cóndores, cascadas de agua, naturaleza. Viernes a domingo.',18,80,'M');
insert into PLAN values(2,'Popayan-Silvia','Conocer silvia, comunidades indigenas. Viernes a domingo.',25,80,'F');
insert into PLAN values(3,'Popayan-Caloto','Conocer caloto y sus sitios naturales',35,60,'T');

