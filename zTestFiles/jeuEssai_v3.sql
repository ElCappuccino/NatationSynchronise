/*==============================================================*/
/* Table: CATEGORIE                                             */
/*==============================================================*/
insert into CATEGORIE (LIBELLECATEGORIE) values('Avenirs');
insert into CATEGORIE (LIBELLECATEGORIE) values('Jeunes');
insert into CATEGORIE (LIBELLECATEGORIE) values('Juniors');
insert into CATEGORIE (LIBELLECATEGORIE) values('Seniors');
insert into CATEGORIE (LIBELLECATEGORIE) values('Toutes categories');

/*==============================================================*/
/* Table: TYPEBALLET                                            */
/*==============================================================*/
insert into TYPEBALLET (LIBELLETYPEBALLET) values('Impose');
insert into TYPEBALLET (LIBELLETYPEBALLET) values('Libre');

/*==============================================================*/
/* Table: TYPEEPREUVE                                           */
/*==============================================================*/
insert into TYPEEPREUVE (LIBELLETYPEEPREUVE) values('solo');
insert into TYPEEPREUVE (LIBELLETYPEEPREUVE) values('duo');
insert into TYPEEPREUVE (LIBELLETYPEEPREUVE) values('equipe');

/*==============================================================*/
/* Table: TYPEFIGURE                                            */
/*==============================================================*/
insert into TYPEFIGURE (LIBELLETYPEFIGURE) values('Galipette cendree');
insert into TYPEFIGURE (LIBELLETYPEFIGURE) values('Triple salto sans fromage');
insert into TYPEFIGURE (LIBELLETYPEFIGURE) values('Carpe-avant vide-piscine');
insert into TYPEFIGURE (LIBELLETYPEFIGURE) values('Salto godille à la tisane');
insert into TYPEFIGURE (LIBELLETYPEFIGURE) values('La fierte du flamant rose');
insert into TYPEFIGURE (LIBELLETYPEFIGURE) values('Le flamenco');
insert into TYPEFIGURE (LIBELLETYPEFIGURE) values('Position verticale');
insert into TYPEFIGURE (LIBELLETYPEFIGURE) values('L''oeil du sphinx');

/*==============================================================*/
/* Table: TYPETOUR                                              */
/*==============================================================*/
insert into TYPETOUR (LIBELLETYPETOUR) values('Preliminaires');
insert into TYPETOUR (LIBELLETYPETOUR) values('Eliminatoires');
insert into TYPETOUR (LIBELLETYPETOUR) values('Finale');

/*==============================================================*/
/* Table: LIEU                                                  */
/*==============================================================*/
insert into LIEU ( NUMEROLIEU , RUELIEU , CODEPOSTALLIEU , VILLELIEU )
    values( '12', 'Rue des grands Hommes', '75009', 'Paris' );
insert into LIEU ( NUMEROLIEU , RUELIEU , CODEPOSTALLIEU , VILLELIEU )
    values( '65', 'Rue de l''apéro', '69360', 'Simandres' );
insert into LIEU ( NUMEROLIEU , RUELIEU , CODEPOSTALLIEU , VILLELIEU )
    values( '1', 'Rue du thé', '38100', 'Grenoble' );

/*==============================================================*/
/* Table: UTILISATEUR                                           */
/*==============================================================*/
insert into UTILISATEUR ( IDUTILISATEUR , NOMUTILISATEUR , PRENOMUTILISATEUR , MDPUTILISATEUR , ISADMIN )
    values( 'juge1' , 'Tagada' , 'Roger', '3c9909afec25354d551dae21590bb26e38d53f2173b8d3dc3eee4c047e7ab1c1eb8b85103e3be7ba613b31bb5c9c36214dc9f14a42fd7a2fdb84856bca5c44c2', false );
insert into UTILISATEUR ( IDUTILISATEUR , NOMUTILISATEUR , PRENOMUTILISATEUR , MDPUTILISATEUR , ISADMIN )
    values( 'juge2' , 'Jugdeman' , 'Patrick', '3c9909afec25354d551dae21590bb26e38d53f2173b8d3dc3eee4c047e7ab1c1eb8b85103e3be7ba613b31bb5c9c36214dc9f14a42fd7a2fdb84856bca5c44c2', false );
insert into UTILISATEUR ( IDUTILISATEUR , NOMUTILISATEUR , PRENOMUTILISATEUR , MDPUTILISATEUR , ISADMIN )
    values( 'juge3' , 'Jugdewoman' , 'Sheik', '3c9909afec25354d551dae21590bb26e38d53f2173b8d3dc3eee4c047e7ab1c1eb8b85103e3be7ba613b31bb5c9c36214dc9f14a42fd7a2fdb84856bca5c44c2', false );
insert into UTILISATEUR ( IDUTILISATEUR , NOMUTILISATEUR , PRENOMUTILISATEUR , MDPUTILISATEUR , ISADMIN )
    values( 'juge4' , 'Goudemornine' , 'Sava', '3c9909afec25354d551dae21590bb26e38d53f2173b8d3dc3eee4c047e7ab1c1eb8b85103e3be7ba613b31bb5c9c36214dc9f14a42fd7a2fdb84856bca5c44c2', false );
insert into UTILISATEUR ( IDUTILISATEUR , NOMUTILISATEUR , PRENOMUTILISATEUR , MDPUTILISATEUR , ISADMIN )
    values('arbitre1' , 'Arbitreman' , 'Fulbert', '3c9909afec25354d551dae21590bb26e38d53f2173b8d3dc3eee4c047e7ab1c1eb8b85103e3be7ba613b31bb5c9c36214dc9f14a42fd7a2fdb84856bca5c44c2', false );
insert into UTILISATEUR ( IDUTILISATEUR , NOMUTILISATEUR , PRENOMUTILISATEUR , MDPUTILISATEUR , ISADMIN )
    values('admin' , 'Dadmin' , 'Jélédroi', '3c9909afec25354d551dae21590bb26e38d53f2173b8d3dc3eee4c047e7ab1c1eb8b85103e3be7ba613b31bb5c9c36214dc9f14a42fd7a2fdb84856bca5c44c2', true );

/*==============================================================*/
/* Table: TYPEJUGE                                              */
/*==============================================================*/
insert into TYPEJUGE ( COEFTYPEJUGE , LIBELLETYPEJUGE )
    values( 100, 'Execution' );
insert into TYPEJUGE ( COEFTYPEJUGE , LIBELLETYPEJUGE )
    values( 100, 'Artistique' );
insert into TYPEJUGE ( COEFTYPEJUGE , LIBELLETYPEJUGE )
    values( 100, 'Difficulté' );
insert into TYPEJUGE ( COEFTYPEJUGE , LIBELLETYPEJUGE )
    values( 100, 'Element' );

/*==============================================================*/
/* Table: JUGE                                                  */
/*==============================================================*/
insert into JUGE ( IDUTILISATEUR , IDTYPEJUGE )
    values( 'juge1' , 1 );
insert into JUGE ( IDUTILISATEUR , IDTYPEJUGE )
    values( 'juge2' , 2 );
insert into JUGE ( IDUTILISATEUR , IDTYPEJUGE )
    values( 'juge3' , 3 );
insert into JUGE ( IDUTILISATEUR , IDTYPEJUGE )
    values( 'juge4' , 4 );

/*==============================================================*/
/* Table: ARBITRE                                               */
/*==============================================================*/
insert into ARBITRE ( IDUTILISATEUR )
    values ( 'arbitre1' );

/*==============================================================*/
/* Table: COMPETITION                                           */
/*==============================================================*/
insert into COMPETITION ( IDLIEU , IDCATEGORIE , IDUTILISATEUR , DATEDEBUTCOMPETITION , DATEFINCOMPETITION , LIBELLECOMPETITION )
    values( 1, 4, 'arbitre1', '2018-01-20 09:00:00', '2018-01-20 18:30:00', 'Competition Senior departementale de Saint-Bidule');
insert into COMPETITION ( IDLIEU , IDCATEGORIE , IDUTILISATEUR , DATEDEBUTCOMPETITION , DATEFINCOMPETITION , LIBELLECOMPETITION )
	values( 2, 5, 'arbitre1', '2018-01-20 09:00:00', '2018-01-20 18:30:00', 'Competition des fripouilles');
insert into COMPETITION ( IDLIEU , IDCATEGORIE , IDUTILISATEUR , DATEDEBUTCOMPETITION , DATEFINCOMPETITION , LIBELLECOMPETITION )
    values( 3, 1, 'arbitre1', '2018-01-20 09:00:00', '2018-01-20 18:30:00', 'Competition des gens qui pesent');
	
/*==============================================================*/
/* Table: JUGECOMPETITION                                           */
/*==============================================================*/
insert into JUGECOMPETITION(IDUTILISATEUR, IDCOMPETITION) values ('juge1', 1);
insert into JUGECOMPETITION(IDUTILISATEUR, IDCOMPETITION) values ('juge2', 1);
insert into JUGECOMPETITION(IDUTILISATEUR, IDCOMPETITION) values ('juge3', 1);
insert into JUGECOMPETITION(IDUTILISATEUR, IDCOMPETITION) values ('juge4', 1);
insert into JUGECOMPETITION(IDUTILISATEUR, IDCOMPETITION) values ('juge1', 2);
insert into JUGECOMPETITION(IDUTILISATEUR, IDCOMPETITION) values ('juge2', 2);
insert into JUGECOMPETITION(IDUTILISATEUR, IDCOMPETITION) values ('juge3', 2);
insert into JUGECOMPETITION(IDUTILISATEUR, IDCOMPETITION) values ('juge4', 2);
  
/*==============================================================*/
/* Table: TOUR                                           */
/*==============================================================*/
insert into TOUR(idCompetition, idTypeTour) values(1, 1);
insert into TOUR(idCompetition, idTypeTour) values(1, 2);
insert into TOUR(idCompetition, idTypeTour) values(1, 3);
 
/*==============================================================*/
/* Table: EPREUVE                                         */
/*==============================================================*/
insert into EPREUVE(idTour, idTypeEpreuve) values(1, 1);
insert into EPREUVE(idTour, idTypeEpreuve) values(1, 2);
insert into EPREUVE(idTour, idTypeEpreuve) values(1, 3);
insert into EPREUVE(idTour, idTypeEpreuve) values(2, 1);
insert into EPREUVE(idTour, idTypeEpreuve) values(2, 2);
insert into EPREUVE(idTour, idTypeEpreuve) values(2, 3);
insert into EPREUVE(idTour, idTypeEpreuve) values(3, 1);
insert into EPREUVE(idTour, idTypeEpreuve) values(3, 2);
insert into EPREUVE(idTour, idTypeEpreuve) values(3, 3);

/*==============================================================*/
/* Table: BALLET                                         */
/*==============================================================*/
insert into BALLET(idEpreuve, idTypeBallet, penaliteBallet) values (1, 1, 0);
insert into BALLET(idEpreuve, idTypeBallet, penaliteBallet) values (1, 2, 0);
insert into BALLET(idEpreuve, idTypeBallet, penaliteBallet) values (2, 1, 0);
insert into BALLET(idEpreuve, idTypeBallet, penaliteBallet) values (2, 2, 0);
insert into BALLET(idEpreuve, idTypeBallet, penaliteBallet) values (3, 1, 0);
insert into BALLET(idEpreuve, idTypeBallet, penaliteBallet) values (3, 2, 0);
insert into BALLET(idEpreuve, idTypeBallet, penaliteBallet) values (4, 1, 0);
insert into BALLET(idEpreuve, idTypeBallet, penaliteBallet) values (4, 2, 0);
insert into BALLET(idEpreuve, idTypeBallet, penaliteBallet) values (5, 1, 0);
insert into BALLET(idEpreuve, idTypeBallet, penaliteBallet) values (5, 2, 0);
insert into BALLET(idEpreuve, idTypeBallet, penaliteBallet) values (6, 1, 0);
insert into BALLET(idEpreuve, idTypeBallet, penaliteBallet) values (6, 2, 0);
insert into BALLET(idEpreuve, idTypeBallet, penaliteBallet) values (7, 1, 0);
insert into BALLET(idEpreuve, idTypeBallet, penaliteBallet) values (7, 2, 0);
insert into BALLET(idEpreuve, idTypeBallet, penaliteBallet) values (8, 1, 0);
insert into BALLET(idEpreuve, idTypeBallet, penaliteBallet) values (8, 2, 0);
insert into BALLET(idEpreuve, idTypeBallet, penaliteBallet) values (9, 1, 0);
insert into BALLET(idEpreuve, idTypeBallet, penaliteBallet) values (9, 2, 0);
 

/* 
	*************************************************************
	*************************************************************
	*************************************************************
*/ 
    
    
    
/*==============================================================*/
/* Table: DIRIGEANT                                             */
/*==============================================================*/
insert into Dirigeant (idlieu, nomDirigeant, prenomDirigeant) values(2, 'Jean', 'Poney');
insert into Dirigeant (idlieu, nomDirigeant, prenomDirigeant) values(2, 'Bernard', 'Poirier');
insert into Dirigeant (idlieu, nomDirigeant, prenomDirigeant) values(2, 'Corentin', 'Pinpin');
insert into Dirigeant (idlieu, nomDirigeant, prenomDirigeant) values(2, 'Alexandre', 'Salamandre');
insert into Dirigeant (idlieu, nomDirigeant, prenomDirigeant) values(2, 'Sebastien', 'Bwass');

/*==============================================================*/
/* Table: CLUB                                                  */
/*==============================================================*/
insert into Club(iddirigeant, nomClub) values(1, 'Club Venissieux Natation');
insert into Club(iddirigeant, nomClub) values(2, 'Club Bron Natation');
insert into Club(iddirigeant, nomClub) values(3, 'Club Simandres Natation');

/*==============================================================*/
/* Table: NAGEUSE                                               */
/*==============================================================*/
insert into Nageuse(nomNageuse, prenomNageuse, dateNaissanceNageuse) values ('Azura', 'Courcelle',  '2000-03-05 00:00:00');
insert into Nageuse(nomNageuse, prenomNageuse, dateNaissanceNageuse) values ('Eglantine', 'Ouellet',  '2001-03-02 00:00:00');
insert into Nageuse(nomNageuse, prenomNageuse, dateNaissanceNageuse) values ('Fleurette', 'Denis',  '1999-03-14 00:00:00');
insert into Nageuse(nomNageuse, prenomNageuse, dateNaissanceNageuse) values ('Joanna', 'Labbe',  '1998-03-26 00:00:00');
insert into Nageuse(nomNageuse, prenomNageuse, dateNaissanceNageuse) values ('Valerie', 'Dubois',  '1999-03-16 00:00:00');
insert into Nageuse(nomNageuse, prenomNageuse, dateNaissanceNageuse) values ('Agathe', 'Souplet',  '1998-11-16 00:00:00');
insert into Nageuse(nomNageuse, prenomNageuse, dateNaissanceNageuse) values ('Blanche', 'Verreau',  '2000-10-16 00:00:00');
insert into Nageuse(nomNageuse, prenomNageuse, dateNaissanceNageuse) values ('Daisi', 'Lecuyer',  '2001-03-05 00:00:00');
insert into Nageuse(nomNageuse, prenomNageuse, dateNaissanceNageuse) values ('Roxanne', 'Charpentier',  '1990-03-26 00:00:00');
insert into Nageuse(nomNageuse, prenomNageuse, dateNaissanceNageuse) values ('Parnella', 'Asselin',  '1988-03-16 00:00:00');
insert into Nageuse(nomNageuse, prenomNageuse, dateNaissanceNageuse) values ('Olympia', 'Perrault',  '1989-11-16 00:00:00');
insert into Nageuse(nomNageuse, prenomNageuse, dateNaissanceNageuse) values ('Eulalie', 'Rocheleau',  '1991-10-16 00:00:00');
insert into Nageuse(nomNageuse, prenomNageuse, dateNaissanceNageuse) values ('Jacqueline', 'Narcisse',  '1990-03-05 00:00:00');
insert into Nageuse(nomNageuse, prenomNageuse, dateNaissanceNageuse) values ('Aubrette', 'Avare',  '1989-03-05 00:00:00');
insert into Nageuse(nomNageuse, prenomNageuse, dateNaissanceNageuse) values ('Aubine', 'Beauchesne',  '1970-03-02 00:00:00');
insert into Nageuse(nomNageuse, prenomNageuse, dateNaissanceNageuse) values ('Luce', 'Chicoine',  '1972-03-14 00:00:00');

/*==============================================================*/
/* Table: EQUIPE                                   	            */
/*==============================================================*/
insert into Equipe(idclub, libelleEquipe) values(1, 'L''eau tarie');
insert into Equipe(idclub, libelleEquipe) values(1, 'Les poissons noyes');
insert into Equipe(idclub, libelleEquipe) values(2, 'L''Aquaclub Patrick Bruel');
insert into Equipe(idclub, libelleEquipe) values(2, 'Aquafun++');
insert into Equipe(idclub, libelleEquipe) values(3, 'Les fleurs fanees');
insert into Equipe(idclub, libelleEquipe) values(2, 'Solitude');
insert into Equipe(idclub, libelleEquipe) values(2, 'J''ai plus d''idee');


/*==============================================================*/
/* Table: NAGEUSECLUB                                           */
/*==============================================================*/
insert into NageuseClub(idClub, idNageuse, dateInscriptionNageuseClub, dateDepartNageuseClub) values(1, 1, '2010-03-16 00:00:00', null);
insert into NageuseClub(idClub, idNageuse, dateInscriptionNageuseClub, dateDepartNageuseClub) values(1, 2, '2012-11-16 00:00:00', null);
insert into NageuseClub(idClub, idNageuse, dateInscriptionNageuseClub, dateDepartNageuseClub) values(1, 3, '2009-10-16 00:00:00', null);
insert into NageuseClub(idClub, idNageuse, dateInscriptionNageuseClub, dateDepartNageuseClub) values(1, 4, '2013-03-05 00:00:00', null);
insert into NageuseClub(idClub, idNageuse, dateInscriptionNageuseClub, dateDepartNageuseClub) values(2, 5, '2009-03-05 00:00:00', null);
insert into NageuseClub(idClub, idNageuse, dateInscriptionNageuseClub, dateDepartNageuseClub) values(2, 6, '2010-03-02 00:00:00', null);
insert into NageuseClub(idClub, idNageuse, dateInscriptionNageuseClub, dateDepartNageuseClub) values(2, 7, '2011-01-26 00:00:00', null);
insert into NageuseClub(idClub, idNageuse, dateInscriptionNageuseClub, dateDepartNageuseClub) values(2, 8, '2008-06-16 00:00:00', null);
insert into NageuseClub(idClub, idNageuse, dateInscriptionNageuseClub, dateDepartNageuseClub) values(3, 9, '2009-10-06 00:00:00', null);
insert into NageuseClub(idClub, idNageuse, dateInscriptionNageuseClub, dateDepartNageuseClub) values(3, 10, '2011-05-21 00:00:00', null);
insert into NageuseClub(idClub, idNageuse, dateInscriptionNageuseClub, dateDepartNageuseClub) values(3, 11, '2015-12-05 00:00:00', null);
insert into NageuseClub(idClub, idNageuse, dateInscriptionNageuseClub, dateDepartNageuseClub) values(3, 12, '2015-09-10 00:00:00', null);
insert into NageuseClub(idClub, idNageuse, dateInscriptionNageuseClub, dateDepartNageuseClub) values(3, 13, '2014-07-17 00:00:00', null);
insert into NageuseClub(idClub, idNageuse, dateInscriptionNageuseClub, dateDepartNageuseClub) values(3, 14, '2013-08-19 00:00:00', null);
insert into NageuseClub(idClub, idNageuse, dateInscriptionNageuseClub, dateDepartNageuseClub) values(3, 15, '2013-02-07 00:00:00', null);
insert into NageuseClub(idClub, idNageuse, dateInscriptionNageuseClub, dateDepartNageuseClub) values(3, 16, '2014-08-14 00:00:00', null);

/*==============================================================*/
/* Table: NAGEUSEEQUIPE                                         */
/*==============================================================*/
insert into NageuseEquipe(idEquipe, idNageuse, isTitulaire, dateInscriptionNageuseEquipe, dateDepartNageuseEquipe) values(1, 1, true, '2010-03-16 00:00:00', null);
insert into NageuseEquipe(idEquipe, idNageuse, isTitulaire, dateInscriptionNageuseEquipe, dateDepartNageuseEquipe) values(1, 2, true, '2012-11-16 00:00:00', null);
insert into NageuseEquipe(idEquipe, idNageuse, isTitulaire, dateInscriptionNageuseEquipe, dateDepartNageuseEquipe) values(1, 3, true, '2009-10-16 00:00:00', null);
insert into NageuseEquipe(idEquipe, idNageuse, isTitulaire, dateInscriptionNageuseEquipe, dateDepartNageuseEquipe) values(1, 4, false, '2013-03-05 00:00:00', null);
insert into NageuseEquipe(idEquipe, idNageuse, isTitulaire, dateInscriptionNageuseEquipe, dateDepartNageuseEquipe) values(2, 5, true, '2009-03-05 00:00:00', null);
insert into NageuseEquipe(idEquipe, idNageuse, isTitulaire, dateInscriptionNageuseEquipe, dateDepartNageuseEquipe) values(2, 6, true, '2010-03-02 00:00:00', null);
insert into NageuseEquipe(idEquipe, idNageuse, isTitulaire, dateInscriptionNageuseEquipe, dateDepartNageuseEquipe) values(2, 7, true, '2011-01-26 00:00:00', null);
insert into NageuseEquipe(idEquipe, idNageuse, isTitulaire, dateInscriptionNageuseEquipe, dateDepartNageuseEquipe) values(2, 8, true, '2008-06-16 00:00:00', null);
insert into NageuseEquipe(idEquipe, idNageuse, isTitulaire, dateInscriptionNageuseEquipe, dateDepartNageuseEquipe) values(3, 9, true, '2009-10-06 00:00:00', null);
insert into NageuseEquipe(idEquipe, idNageuse, isTitulaire, dateInscriptionNageuseEquipe, dateDepartNageuseEquipe) values(3, 10, true, '2011-05-21 00:00:00', null);
insert into NageuseEquipe(idEquipe, idNageuse, isTitulaire, dateInscriptionNageuseEquipe, dateDepartNageuseEquipe) values(4, 11, true, '2015-12-05 00:00:00', null);
insert into NageuseEquipe(idEquipe, idNageuse, isTitulaire, dateInscriptionNageuseEquipe, dateDepartNageuseEquipe) values(4, 12, true, '2015-09-10 00:00:00', null);
insert into NageuseEquipe(idEquipe, idNageuse, isTitulaire, dateInscriptionNageuseEquipe, dateDepartNageuseEquipe) values(5, 15, true, '2013-02-07 00:00:00', null);
insert into NageuseEquipe(idEquipe, idNageuse, isTitulaire, dateInscriptionNageuseEquipe, dateDepartNageuseEquipe) values(5, 16, true, '2014-08-14 00:00:00', null);
insert into NageuseEquipe(idEquipe, idNageuse, isTitulaire, dateInscriptionNageuseEquipe, dateDepartNageuseEquipe) values(6, 13, true, '2014-07-17 00:00:00', null);
insert into NageuseEquipe(idEquipe, idNageuse, isTitulaire, dateInscriptionNageuseEquipe, dateDepartNageuseEquipe) values(7, 14, true, '2013-08-19 00:00:00', null);

/*==============================================================*/
/* Table: EquipeCompetition                                         */
/*==============================================================*/
insert into EquipeCompetition(idEquipe, idCompetition) values (1, 1);
insert into EquipeCompetition(idEquipe, idCompetition) values (2, 1);
insert into EquipeCompetition(idEquipe, idCompetition) values (3, 1);
insert into EquipeCompetition(idEquipe, idCompetition) values (4, 1);
insert into EquipeCompetition(idEquipe, idCompetition) values (6, 1);
insert into EquipeCompetition(idEquipe, idCompetition) values (7, 1);


