INSERT INTO tip_kupca (ime, popust, trazeni_broj_bodova) VALUES ('Zlatni', 0.30, 200);
INSERT INTO tip_kupca (ime, popust, trazeni_broj_bodova) VALUES ('Srebrni', 0.20, 100);
INSERT INTO tip_kupca (ime, popust, trazeni_broj_bodova) VALUES ('Bronzani', 0.10, 50);

insert into KORISNIK (DTYPE, korisnicko_ime, ime, prezime, pol, datum_rodjenja, uloga, lozinka) values (1, 'gberston0', 'Gardy', 'Berston', 'Male', '2001-08-05', 0, 'GdeAcmE');
insert into KORISNIK (DTYPE, korisnicko_ime, ime, prezime, pol, datum_rodjenja, uloga, lozinka, tip_kupca_id, broj_bodova) values (2, 'earmall1', 'Elyse', 'Armall', 'Genderfluid', '1981-05-07', 1, 'oFiCf3p6YL', 1, 202);
insert into KORISNIK (DTYPE, korisnicko_ime, ime, prezime, pol, datum_rodjenja, uloga, lozinka, tip_kupca_id, broj_bodova) values (3, 'gmudd2', 'Godart', 'Mudd', 'Male', '2006-04-06', 1, 'KkfSA2Qn6y5', 2, 101);
insert into KORISNIK (DTYPE, korisnicko_ime, ime, prezime, pol, datum_rodjenja, uloga, lozinka) values (4, 'rvlasin3', 'Randell', 'Vlasin', 'Male', '2002-12-10', 2, 'BTHxZShr94RF');
insert into KORISNIK (DTYPE, korisnicko_ime, ime, prezime, pol, datum_rodjenja, uloga, lozinka) values (5, 'hpawnsford4', 'Harrison', 'Pawnsford', 'Male', '1980-01-01', 3, 'DTNMOmJo');
insert into KORISNIK (DTYPE, korisnicko_ime, ime, prezime, pol, datum_rodjenja, uloga, lozinka) values (6, 'acosin5', 'Ailina', 'Cosin', 'Female', '1985-03-02', 0, 'vtTw9RvDa');
insert into KORISNIK (DTYPE, korisnicko_ime, ime, prezime, pol, datum_rodjenja, uloga, lozinka, tip_kupca_id, broj_bodova) values (7, 'ntomkins6', 'Nolan', 'Tomkins', 'Male', '1994-05-01', 1, 'C61mYsqqpt', 3, 55);
insert into KORISNIK (DTYPE, korisnicko_ime, ime, prezime, pol, datum_rodjenja, uloga, lozinka) values (8, 'aspacy7', 'Aldo', 'Spacy', 'Male', '1991-08-02', 2, 'SYcbA5');
insert into KORISNIK (DTYPE, korisnicko_ime, ime, prezime, pol, datum_rodjenja, uloga, lozinka) values (9, 'mbesnardeau8', 'Marshal', 'Besnardeau', 'Male', '1996-11-01', 3, 'KBdexO9o1');
insert into KORISNIK (DTYPE, korisnicko_ime, ime, prezime, pol, datum_rodjenja, uloga, lozinka) values (10, 'bwillmer9', 'Bondy', 'Willmer', 'Male', '2010-12-12', 0, 'TYECbSvg');


insert into LOKACIJA (duzina, sirina, adresa) values (31278, 4, 'Lunder');
insert into LOKACIJA (duzina, sirina, adresa) values (4147, 65268, 'Hermina');
insert into LOKACIJA (duzina, sirina, adresa) values (953, 8726, 'Pleasure');
insert into LOKACIJA (duzina, sirina, adresa) values (162, 0357, 'Maple Wood');
insert into LOKACIJA (duzina, sirina, adresa) values (600, 241, 'Lakeland');
insert into LOKACIJA (duzina, sirina, adresa) values (0678, 8240, 'Commercial');
insert into LOKACIJA (duzina, sirina, adresa) values (1, 7975, 'Sunbrook');
insert into LOKACIJA (duzina, sirina, adresa) values (21, 42, 'Hudson');
insert into LOKACIJA (duzina, sirina, adresa) values (01731, 1705, 'Green');
insert into LOKACIJA (duzina, sirina, adresa) values (1, 47, 'Vernon');

insert into RESTORAN (naziv, tip, lokacija_id) values ('Marks, Lakin and Morissette', 'Campanula shetleri Heckard', 1);
insert into RESTORAN (naziv, tip, lokacija_id) values ('Nicolas-Ritchie', 'Aerva sericea Moq.', 2);
insert into RESTORAN (naziv, tip, lokacija_id) values ('Dicki and Sons', 'Cyanea kunthiana (Gaudich.) Hillebr.', 3);
insert into RESTORAN (naziv, tip, lokacija_id) values ('Stamm and Sons', 'Rubus bartonianus M. Peck', 4);
insert into RESTORAN (naziv, tip, lokacija_id) values ('O''Keefe-Hahn', 'Phacelia coerulea Greene', 5);
insert into RESTORAN (naziv, tip, lokacija_id) values ('Mills, Armstrong and Purdy', 'Arthonia reniformis (Pers.) Ach.', 6);
insert into RESTORAN (naziv, tip, lokacija_id) values ('Bergstrom, Sporer and Bashirian', 'Pseudognaphalium sandwicensium (Gaudich.) Anderb.', 7);
insert into RESTORAN (naziv, tip, lokacija_id) values ('Keeling-Runolfsson', 'Croton cascarilla (L.) L.', 8);
insert into RESTORAN (naziv, tip, lokacija_id) values ('Skiles Group', 'Ribes cruentum Greene var. oregonense A. Berger', 9);
insert into RESTORAN (naziv, tip, lokacija_id) values ('Reichert Inc', 'Lagetta lagetto (Sw.) Nash', 10);

insert into ARTIKLI (cena, kolicina, naziv, opis, tip) values (57.23, 58, 'Tart Shells - Sweet, 3', 'Quisque ut erat.', 'Jelo');
insert into ARTIKLI (cena, kolicina, naziv, opis, tip) values (69.73, 30, 'Ecolab - Balanced Fusion', 'Suspendisse potenti.', 'Pice');
insert into ARTIKLI (cena, kolicina, naziv, opis, tip) values (95.03, 54, 'Bread Crumbs - Panko', 'In hac habitasse platea dictumst.', 'Jelo');
insert into ARTIKLI (cena, kolicina, naziv, opis, tip) values (96.04, 87, 'Coffee - Cafe Moreno', 'Praesent id massa id nisl venenatis lacinia.', 'Pice');
insert into ARTIKLI (cena, kolicina, naziv, opis, tip) values (22.35, 81, 'Table Cloth 91x91 Colour', 'Cras pellentesque volutpat dui.', 'Jelo');
insert into ARTIKLI (cena, kolicina, naziv, opis, tip) values (63.62, 35, 'Thyme - Fresh', 'Duis at velit eu est congue elementum.', 'Pice');
insert into ARTIKLI (cena, kolicina, naziv, opis, tip) values (26.02, 42, 'Veal - Striploin', 'Phasellus sit amet erat.', 'Jelo');
insert into ARTIKLI (cena, kolicina, naziv, opis, tip) values (14.00, 98, 'Nestea - Ice Tea, Diet', 'Pellentesque at nulla.', 'Pice');
insert into ARTIKLI (cena, kolicina, naziv, opis, tip) values (14.95, 100, 'Buffalo - Tenderloin', 'Nam congue, risus semper porta volutpat, quam pede lobortis ligula, sit amet eleifend pede libero quis orci.', 'Jelo');
insert into ARTIKLI (cena, kolicina, naziv, opis, tip) values (75.31, 6, 'Soup Campbells - Tomato Bisque', 'Pellentesque viverra pede ac diam.', 'Pice');

/*INSERT INTO ima_artikle (artikli_id, restoran_id) VALUES (1, 5);
INSERT INTO ima_artikle (artikli_id, restoran_id) VALUES (2, 4);
INSERT INTO ima_artikle (artikli_id, restoran_id) VALUES (3, 3);
INSERT INTO ima_artikle (artikli_id, restoran_id) VALUES (4, 2);
INSERT INTO ima_artikle (artikli_id, restoran_id) VALUES (5, 1);*/


/*INSERT INTO porudzbina (id, dostavljac_id, datum, cena, status, kupac_id) VALUES (NEXTVAL('hibernate_sequence'), 5, NOW(), 100, 0, 2);
INSERT INTO porudzbina (id, dostavljac_id, datum, cena, status, kupac_id) VALUES (NEXTVAL('hibernate_sequence'), 5, NOW(), 120, 1, 3);
INSERT INTO porudzbina (id, dostavljac_id, datum, cena, status, kupac_id) VALUES (NEXTVAL('hibernate_sequence'), 9, NOW(), 130, 2, 7);

INSERT INTO porudzbina_restoran (Porudzbina_id, restoran_id) VALUES (NEXTVAL('hibernate_sequence'), 1);
INSERT INTO porudzbina_restoran (Porudzbina_id, restoran_id) VALUES (NEXTVAL('hibernate_sequence'), 2);
INSERT INTO porudzbina_restoran (Porudzbina_id, restoran_id) VALUES (NEXTVAL('hibernate_sequence'), 3);


INSERT INTO komentar (tekst, ocena) VALUES ('Lepo je', 5);
INSERT INTO komentar (tekst, ocena) VALUES ('OK je', 3);
INSERT INTO komentar (tekst, ocena) VALUES ('Nista ne valja', 1);

INSERT INTO pripada_porudzbini (porudzbina_id, restoran_id) VALUES (NEXTVAL('hibernate_sequence'), 1);
INSERT INTO pripada_porudzbini (porudzbina_id, restoran_id) VALUES (NEXTVAL('hibernate_sequence'), 2);
INSERT INTO pripada_porudzbini (porudzbina_id, restoran_id) VALUES (NEXTVAL('hibernate_sequence'), 3);*/