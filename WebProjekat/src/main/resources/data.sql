INSERT INTO KORISNIK (korisnicko_ime, lozinka, ime, prezime, datum_rodjenja, pol, uloga) VALUES ('milicak', 'milica213', 'Milica', 'Kondic', '1988-5-19', 'ZENSKO', MENADZER);
INSERT INTO KORISNIK (korisnicko_ime, lozinka, ime, prezime, datum_rodjenja, pol, uloga) VALUES ('peric8', 'bfwhekbfk', 'Luka', 'Peric', '1978-4-13', 'MUSKO', DOSTAVLJAC);
INSERT INTO KORISNIK (korisnicko_ime, lozinka, ime, prezime, datum_rodjenja, pol, uloga) VALUES ('aleksa1990', 'novisad', 'Aleksa', 'Petrovic', '1990-1-30', 'MUSKO', KUPAC);
INSERT INTO KORISNIK (korisnicko_ime, lozinka, ime, prezime, datum_rodjenja, pol, uloga) VALUES ('bojanasimic', 'volimkera', 'Bojana', 'Simic', '2000-10-5', 'ZENSKO', KUPAC);
INSERT INTO KORISNIK (korisnicko_ime, lozinka, ime, prezime, datum_rodjenja, pol, uloga) VALUES ('dostavljac2', 'hfiurfhw', 'Ema', 'Radovanovic', '2001-3-5', 'ZENSKO', DOSTAVLJAC);

INSERT INTO MENADZER (restoran, company_id) VALUES ('Menadžment', 1);
INSERT INTO DEPARTMENT (name, company_id) VALUES ('Računarski centar', 1);

INSERT INTO EMPLOYEE (first_name, last_name, position, department_id) VALUES ('Aleksandar', 'Aleksić', 'radnik', 1);
INSERT INTO EMPLOYEE (first_name, last_name, position, department_id) VALUES ('Milica', 'Milić', 'menadžer', 1);
INSERT INTO EMPLOYEE (first_name, last_name, position, department_id) VALUES ('Slavica', 'Slavić', 'radnik', 2);

INSERT INTO PROJECT (name, deadline) VALUES ('Biću student FTN', '2019-02-10');
INSERT INTO PROJECT (name, deadline) VALUES ('Podizanje sistema', '2019-05-1');

INSERT INTO WORKING (project_id, employee_id) VALUES (1, 1);
INSERT INTO WORKING (project_id, employee_id) VALUES (1, 2);
INSERT INTO WORKING (project_id, employee_id) VALUES (2, 3);
