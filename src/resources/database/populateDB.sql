use Cars;
insert into roles values (DEFAULT,'client');
insert into roles values (DEFAULT,'manager');
insert into roles values (DEFAULT,'admin');

insert into users(login,password,role_id) select 'admin','admin',roles.id from roles where roles.role='admin';
insert into users(login,password,role_id) select 'man','man',roles.id from roles where roles.role='manager';

insert into cars(producer, make, rang, price, year, imageLocAdress) VALUES ('Ford','Model T','A',222,1914,'1914 FORD MODEL T.jpg');
insert into cars(producer, make, rang, price, year, imageLocAdress) VALUES ('Ford','Model T','A',250,1919,'1919 FORD MODEL T.jpg');
insert into cars(producer, make, rang, price, year, imageLocAdress) VALUES ('Rolls-Royce','Silver Ghost T','B',199,1923,'1923 Rolls-Royce Silver Ghost.jpg');
insert into cars(producer, make, rang, price, year, imageLocAdress) VALUES ('Peugeot','Quadrilette Torpedo','B',221,1924,'1924 Peugeot Quadrilette Torpedo.jpg');
insert into cars(producer, make, rang, price, year, imageLocAdress) VALUES ('Rolls-Royce','-Royce Silver Ghost','B',275,1925,'1925 Rolls-Royce Silver Ghost.jpg');
insert into cars(producer, make, rang, price, year, imageLocAdress) VALUES ('Ford','Model A','B',265,1929,'1929 FORD MODEL A.jpg');
insert into cars(producer, make, rang, price, year, imageLocAdress) VALUES ('Rolls-Royce','PHANTOM II','B',268,1930,'1930 ROLLS-ROYCE PHANTOM II.jpg');
insert into cars(producer, make, rang, price, year, imageLocAdress) VALUES ('Chevrolet','Sedan','B',246,1931,'1931 CHEVROLET SEDAN.jpg');
insert into cars(producer, make, rang, price, year, imageLocAdress) VALUES ('Praga-Alfa','6 Serie XVIII','B',301,1931,'1931 Praga-Alfa 6 Serie XVIII.jpg');
insert into cars(producer, make, rang, price, year, imageLocAdress) VALUES ('Auburn',' 8-100A','B',305,1932,'1932 Auburn 8-100A.jpg');
insert into cars(producer, make, rang, price, year, imageLocAdress) VALUES ('Ford','Hi-Boy Roadster','B',288,1932,'1932 Ford ''Hi-Boy'' Roadster.jpg');
insert into cars(producer, make, rang, price, year, imageLocAdress) VALUES ('Ford','ROADSTER','B',291,1932,'1932 FORD ROADSTER.jpg');
insert into cars(producer, make, rang, price, year, imageLocAdress) VALUES ('Ford','VICTORIA','B',300,1933,'1933 FORD VICTORIA.jpg');
insert into cars(producer, make, rang, price, year, imageLocAdress) VALUES ('Chevrolet','ABRIOLET STREET ROD','',275,1934,'1934 CHEVROLET CABRIOLET STREET ROD.jpg');
insert into cars(producer, make, rang, price, year, imageLocAdress) VALUES ('Ford','FORD STREET ROD','B',311,1934,'1934 FORD STREET ROD.jpg');
insert into cars(producer, make, rang, price, year, imageLocAdress) VALUES ('Mercedes-Benz','500 K','B',307,1934,'1934 Mercedes-Benz 500 K.jpg');
insert into cars(producer, make, rang, price, year, imageLocAdress) VALUES ('Peugeot','601','B',302,19,'1934 Peugeot 601.jpg');
insert into cars(producer, make, rang, price, year, imageLocAdress) VALUES ('Auburn','851 SC','B',302,1935,'1935 AUBURN 851 SC.jpg');
insert into cars(producer, make, rang, price, year, imageLocAdress) VALUES ('Ford','V-8','B',288,1935,'1935 FORD V-8.jpg');
insert into cars(producer, make, rang, price, year, imageLocAdress) VALUES ('Ford','DELUXE PHAETON','B',275,1936,'1936 FORD DELUXE PHAETON.jpg');
insert into cars(producer, make, rang, price, year, imageLocAdress) VALUES ('Buick','ROADMASTER','B',288,1937,'1937 BUICK ROADMASTER.jpg');
insert into cars(producer, make, rang, price, year, imageLocAdress) VALUES ('Mercedes-Benz','540 K','B',288,1937,'1937 Mercedes-Benz 540 K.jpg');
insert into cars(producer, make, rang, price, year, imageLocAdress) VALUES ('Peugeot','402','B',222,1937,'1937 PEUGEOT 402.jpg');
insert into cars(producer, make, rang, price, year, imageLocAdress) VALUES ('Mercedes-Benz','Pre-War','B',223,1938,'1938 Mercedes-Benz Pre-War.jpgg');
insert into cars(producer, make, rang, price, year, imageLocAdress) VALUES ('Rolls-Royce','Phantom III','B',302,1938,'1938 Rolls-Royce Phantom III.jpg');
insert into cars(producer, make, rang, price, year, imageLocAdress) VALUES ('Chevrolet','Master 85','B',285,1939,'1939 Chevrolet Master 85.jpg');
insert into cars(producer, make, rang, price, year, imageLocAdress) VALUES ('Lancia','Aprilia','B',322,1939,'1939 Lancia Aprilia.jpg');
insert into cars(producer, make, rang, price, year, imageLocAdress) VALUES ('Mercedes-Benz','Typ 320','B',332,1939,'1939 Mercedes-Benz Typ 320.jpg');
