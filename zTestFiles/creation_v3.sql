/*==============================================================*/
/* DBMS name:      PostgreSQL 9.x                               */
/* Created on:     09/12/2017 17:52:22                          */
/*==============================================================*/


drop table if exists ARBITRE cascade;

drop table if exists BALLET cascade;

drop table if exists CATEGORIE cascade;

drop table if exists CLUB cascade;

drop table if exists COMPETITION cascade;

drop table if exists DIRIGEANT cascade;

drop table if exists EPREUVE cascade;

drop table if exists EQUIPE cascade;

drop table if exists EQUIPECOMPETITION cascade;

drop table if exists EXECUTIONFIGURE cascade;

drop table if exists JUGE cascade;

drop table if exists JUGECOMPETITION cascade;

drop table if exists LIEU cascade;

drop table if exists NAGEUSE cascade;

drop table if exists NAGEUSECLUB cascade;

drop table if exists NAGEUSEEQUIPE cascade;

drop table if exists NOTE cascade;

drop table if exists TOUR cascade;

drop table if exists TYPEBALLET cascade;

drop table if exists TYPEEPREUVE cascade;

drop table if exists TYPEFIGURE cascade;

drop table if exists TYPEJUGE cascade;

drop table if exists TYPETOUR cascade;

drop table if exists UTILISATEUR cascade;

/*==============================================================*/
/* Table: ARBITRE                                               */
/*==============================================================*/
create table ARBITRE (
   IDUTILISATEUR        VARCHAR(50)          not null,
   constraint PK_ARBITRE primary key (IDUTILISATEUR)
);

/*==============================================================*/
/* Table: BALLET                                                */
/*==============================================================*/
create table BALLET (
   IDBALLET             SERIAL               not null,
   IDTYPEBALLET         INTEGER                 not null,
   IDEPREUVE            INTEGER                 not null,
   PENALITEBALLET       NUMERIC(2,1)         null,
   constraint PK_BALLET primary key (IDBALLET)
);

/*==============================================================*/
/* Table: CATEGORIE                                             */
/*==============================================================*/
create table CATEGORIE (
   IDCATEGORIE          SERIAL               not null,
   LIBELLECATEGORIE     VARCHAR(50)          not null,
   constraint PK_CATEGORIE primary key (IDCATEGORIE)
);

/*==============================================================*/
/* Table: CLUB                                                  */
/*==============================================================*/
create table CLUB (
   IDCLUB               SERIAL               not null,
   IDDIRIGEANT          INTEGER                 not null,
   NOMCLUB              VARCHAR(50)          not null,
   constraint PK_CLUB primary key (IDCLUB)
);

/*==============================================================*/
/* Table: COMPETITION                                           */
/*==============================================================*/
create table COMPETITION (
   IDCOMPETITION        SERIAL               not null,
   IDLIEU               INTEGER                 not null,
   IDCATEGORIE          INTEGER                 not null,
   IDUTILISATEUR        VARCHAR(50)          not null,
   DATEDEBUTCOMPETITION DATE                 not null,
   DATEFINCOMPETITION   DATE                 not null,
   LIBELLECOMPETITION   VARCHAR(50)          not null,
   constraint PK_COMPETITION primary key (IDCOMPETITION)
);

/*==============================================================*/
/* Table: DIRIGEANT                                             */
/*==============================================================*/
create table DIRIGEANT (
   IDDIRIGEANT          SERIAL               not null,
   IDLIEU               INTEGER                 not null,
   NOMDIRIGEANT         VARCHAR(50)          not null,
   PRENOMDIRIGEANT      VARCHAR(50)          not null,
   constraint PK_DIRIGEANT primary key (IDDIRIGEANT)
);

/*==============================================================*/
/* Table: EPREUVE                                               */
/*==============================================================*/
create table EPREUVE (
   IDEPREUVE            SERIAL               not null,
   IDTOUR               INTEGER                 not null,
   IDTYPEEPREUVE        INTEGER                 not null,
   constraint PK_EPREUVE primary key (IDEPREUVE)
);

/*==============================================================*/
/* Table: EQUIPE                                                */
/*==============================================================*/
create table EQUIPE (
   IDEQUIPE             SERIAL               not null,
   IDCLUB               INTEGER                 not null,
   LIBELLEEQUIPE        VARCHAR(50)          not null,
   constraint PK_EQUIPE primary key (IDEQUIPE)
);

/*==============================================================*/
/* Table: EQUIPECOMPETITION                                     */
/*==============================================================*/
create table EQUIPECOMPETITION (
   IDEQUIPE             INTEGER                 not null,
   IDCOMPETITION        INTEGER                 not null,
   constraint PK_EQUIPECOMPETITION primary key (IDEQUIPE, IDCOMPETITION)
);

/*==============================================================*/
/* Table: EXECUTIONFIGURE                                       */
/*==============================================================*/
create table EXECUTIONFIGURE (
   IDEXECUTION          SERIAL               not null,
   IDNAGEUSE            INTEGER                 not null,
   IDTYPEFIGURE         INTEGER                 not null,
   IDBALLET             INTEGER                 not null,
   IDUTILISATEUR        VARCHAR(50)          not null,
   constraint PK_EXECUTIONFIGURE primary key (IDEXECUTION)
);

/*==============================================================*/
/* Table: JUGE                                                  */
/*==============================================================*/
create table JUGE (
   IDUTILISATEUR        VARCHAR(50)          not null,
   IDTYPEJUGE           INTEGER                 not null,
   constraint PK_JUGE primary key (IDUTILISATEUR)
);

/*==============================================================*/
/* Table: JUGECOMPETITION                                       */
/*==============================================================*/
create table JUGECOMPETITION (
   IDUTILISATEUR        VARCHAR(50)          not null,
   IDCOMPETITION        INTEGER                 not null,
   constraint PK_JUGECOMPETITION primary key (IDUTILISATEUR, IDCOMPETITION)
);

/*==============================================================*/
/* Table: LIEU                                                  */
/*==============================================================*/
create table LIEU (
   IDLIEU               SERIAL               not null,
   NUMEROLIEU           INTEGER                 null,
   RUELIEU              VARCHAR(100)         not null,
   CODEPOSTALLIEU       INTEGER                 not null,
   VILLELIEU            VARCHAR(50)          not null,
   constraint PK_LIEU primary key (IDLIEU)
);

/*==============================================================*/
/* Table: NAGEUSE                                               */
/*==============================================================*/
create table NAGEUSE (
   IDNAGEUSE            SERIAL               not null,
   NOMNAGEUSE           VARCHAR(50)          not null,
   PRENOMNAGEUSE        VARCHAR(50)          not null,
   DATENAISSANCENAGEUSE DATE                 not null,
   constraint PK_NAGEUSE primary key (IDNAGEUSE)
);

/*==============================================================*/
/* Table: NAGEUSECLUB                                           */
/*==============================================================*/
create table NAGEUSECLUB (
   IDNAGEUSE            INTEGER                 not null,
   IDCLUB               INTEGER                 not null,
   DATEINSCRIPTIONNAGEUSECLUB DATE                 null,
   DATEDEPARTNAGEUSECLUB DATE                 null,
   constraint PK_NAGEUSECLUB primary key (IDNAGEUSE, IDCLUB)
);

/*==============================================================*/
/* Table: NAGEUSEEQUIPE                                         */
/*==============================================================*/
create table NAGEUSEEQUIPE (
   IDEQUIPE             INTEGER                 not null,
   IDNAGEUSE            INTEGER                 not null,
   ISTITULAIRE			BOOL					not null,
   DATEINSCRIPTIONNAGEUSEEQUIPE DATE                null,
   DATEDEPARTNAGEUSEEQUIPE DATE                 	null,
   constraint PK_NAGEUSEEQUIPE primary key (IDEQUIPE, IDNAGEUSE)
);

/*==============================================================*/
/* Table: NOTE                                                  */
/*==============================================================*/
create table NOTE (
   IDNOTE               SERIAL               not null,
   IDEXECUTION          INTEGER                 not null,
   NOTE                 INTEGER                 null,
   constraint PK_NOTE primary key (IDNOTE)
);

/*==============================================================*/
/* Table: TOUR                                                  */
/*==============================================================*/
create table TOUR (
   IDTOUR               SERIAL               not null,
   IDCOMPETITION        INTEGER                 not null,
   IDTYPETOUR           INTEGER                 not null,
   constraint PK_TOUR primary key (IDTOUR)
);

/*==============================================================*/
/* Table: TYPEBALLET                                            */
/*==============================================================*/
create table TYPEBALLET (
   IDTYPEBALLET         SERIAL               not null,
   LIBELLETYPEBALLET    VARCHAR(50)          not null,
   constraint PK_TYPEBALLET primary key (IDTYPEBALLET)
);

/*==============================================================*/
/* Table: TYPEEPREUVE                                           */
/*==============================================================*/
create table TYPEEPREUVE (
   IDTYPEEPREUVE        SERIAL               not null,
   LIBELLETYPEEPREUVE   VARCHAR(150)         not null,
   constraint PK_TYPEEPREUVE primary key (IDTYPEEPREUVE)
);

/*==============================================================*/
/* Table: TYPEFIGURE                                            */
/*==============================================================*/
create table TYPEFIGURE (
   IDTYPEFIGURE         SERIAL               not null,
   LIBELLETYPEFIGURE    VARCHAR(100)         not null,
   constraint PK_TYPEFIGURE primary key (IDTYPEFIGURE)
);

/*==============================================================*/
/* Table: TYPEJUGE                                              */
/*==============================================================*/
create table TYPEJUGE (
   IDTYPEJUGE           SERIAL               not null,
   COEFTYPEJUGE         NUMERIC(5,2)         not null,
   LIBELLETYPEJUGE      VARCHAR(50)          not null,
   constraint PK_TYPEJUGE primary key (IDTYPEJUGE)
);

/*==============================================================*/
/* Table: TYPETOUR                                              */
/*==============================================================*/
create table TYPETOUR (
   IDTYPETOUR           SERIAL               not null,
   LIBELLETYPETOUR      VARCHAR(50)          not null,
   constraint PK_TYPETOUR primary key (IDTYPETOUR)
);

/*==============================================================*/
/* Table: UTILISATEUR                                           */
/*==============================================================*/
create table UTILISATEUR (
   IDUTILISATEUR        VARCHAR(50)          not null,
   NOMUTILISATEUR       VARCHAR(50)          not null,
   PRENOMUTILISATEUR    VARCHAR(50)          not null,
   MDPUTILISATEUR       CHAR(128)             not null,
   ISADMIN              BOOL                 not null,
   constraint PK_UTILISATEUR primary key (IDUTILISATEUR)
);

alter table ARBITRE
   add constraint FK_ARBITRE_INHERITAN_UTILISAT foreign key (IDUTILISATEUR)
      references UTILISATEUR (IDUTILISATEUR)
      on delete restrict on update restrict;

alter table BALLET
   add constraint FK_BALLET_ASSOCIATI_TYPEBALL foreign key (IDTYPEBALLET)
      references TYPEBALLET (IDTYPEBALLET)
      on delete restrict on update restrict;

alter table BALLET
   add constraint FK_BALLET_ASSOCIATI_EPREUVE foreign key (IDEPREUVE)
      references EPREUVE (IDEPREUVE)
      on delete restrict on update restrict;

alter table CLUB
   add constraint FK_CLUB_ASSOCIATI_DIRIGEAN foreign key (IDDIRIGEANT)
      references DIRIGEANT (IDDIRIGEANT)
      on delete restrict on update restrict;

alter table COMPETITION
   add constraint FK_COMPETIT_ASSOCIATI_ARBITRE foreign key (IDUTILISATEUR)
      references ARBITRE (IDUTILISATEUR)
      on delete restrict on update restrict;

alter table COMPETITION
   add constraint FK_COMPETIT_ASSOCIATI_LIEU foreign key (IDLIEU)
      references LIEU (IDLIEU)
      on delete restrict on update restrict;

alter table COMPETITION
   add constraint FK_COMPETIT_ASSOCIATI_CATEGORI foreign key (IDCATEGORIE)
      references CATEGORIE (IDCATEGORIE)
      on delete restrict on update restrict;

alter table DIRIGEANT
   add constraint FK_DIRIGEAN_ASSOCIATI_LIEU foreign key (IDLIEU)
      references LIEU (IDLIEU)
      on delete restrict on update restrict;

alter table EPREUVE
   add constraint FK_EPREUVE_ASSOCIATI_TYPEEPRE foreign key (IDTYPEEPREUVE)
      references TYPEEPREUVE (IDTYPEEPREUVE)
      on delete restrict on update restrict;

alter table EPREUVE
   add constraint FK_EPREUVE_ASSOCIATI_TOUR foreign key (IDTOUR)
      references TOUR (IDTOUR)
      on delete restrict on update restrict;

alter table EQUIPE
   add constraint FK_EQUIPE_ASSOCIATI_CLUB foreign key (IDCLUB)
      references CLUB (IDCLUB)
      on delete restrict on update restrict;

alter table EQUIPECOMPETITION
   add constraint FK_EQUIPECO_EQUIPECOM_EQUIPE foreign key (IDEQUIPE)
      references EQUIPE (IDEQUIPE)
      on delete restrict on update restrict;

alter table EQUIPECOMPETITION
   add constraint FK_EQUIPECO_EQUIPECOM_COMPETIT foreign key (IDCOMPETITION)
      references COMPETITION (IDCOMPETITION)
      on delete restrict on update restrict;

alter table EXECUTIONFIGURE
   add constraint FK_EXECUTIO_ASSOCIATI_JUGE foreign key (IDUTILISATEUR)
      references JUGE (IDUTILISATEUR)
      on delete restrict on update restrict;

alter table EXECUTIONFIGURE
   add constraint FK_EXECUTIO_ASSOCIATI_NAGEUSE foreign key (IDNAGEUSE)
      references NAGEUSE (IDNAGEUSE)
      on delete restrict on update restrict;

alter table EXECUTIONFIGURE
   add constraint FK_EXECUTIO_ASSOCIATI_TYPEFIGU foreign key (IDTYPEFIGURE)
      references TYPEFIGURE (IDTYPEFIGURE)
      on delete restrict on update restrict;

alter table EXECUTIONFIGURE
   add constraint FK_EXECUTIO_ASSOCIATI_BALLET foreign key (IDBALLET)
      references BALLET (IDBALLET)
      on delete restrict on update restrict;

alter table JUGE
   add constraint FK_JUGE_ASSOCIATI_TYPEJUGE foreign key (IDTYPEJUGE)
      references TYPEJUGE (IDTYPEJUGE)
      on delete restrict on update restrict;

alter table JUGE
   add constraint FK_JUGE_INHERITAN_UTILISAT foreign key (IDUTILISATEUR)
      references UTILISATEUR (IDUTILISATEUR)
      on delete restrict on update restrict;

alter table JUGECOMPETITION
   add constraint FK_JUGECOMP_JUGECOMPE_JUGE foreign key (IDUTILISATEUR)
      references JUGE (IDUTILISATEUR)
      on delete restrict on update restrict;

alter table JUGECOMPETITION
   add constraint FK_JUGECOMP_JUGECOMPE_COMPETIT foreign key (IDCOMPETITION)
      references COMPETITION (IDCOMPETITION)
      on delete restrict on update restrict;

alter table NAGEUSECLUB
   add constraint FK_NAGEUSEC_NAGEUSECL_NAGEUSE foreign key (IDNAGEUSE)
      references NAGEUSE (IDNAGEUSE)
      on delete restrict on update restrict;

alter table NAGEUSECLUB
   add constraint FK_NAGEUSEC_NAGEUSECL_CLUB foreign key (IDCLUB)
      references CLUB (IDCLUB)
      on delete restrict on update restrict;

alter table NAGEUSEEQUIPE
   add constraint FK_NAGEUSEE_NAGEUSEEQ_EQUIPE foreign key (IDEQUIPE)
      references EQUIPE (IDEQUIPE)
      on delete restrict on update restrict;

alter table NAGEUSEEQUIPE
   add constraint FK_NAGEUSEE_NAGEUSEEQ_NAGEUSE foreign key (IDNAGEUSE)
      references NAGEUSE (IDNAGEUSE)
      on delete restrict on update restrict;

alter table NOTE
   add constraint FK_NOTE_ASSOCIATI_EXECUTIO foreign key (IDEXECUTION)
      references EXECUTIONFIGURE (IDEXECUTION)
      on delete restrict on update restrict;

alter table TOUR
   add constraint FK_TOUR_ASSOCIATI_TYPETOUR foreign key (IDTYPETOUR)
      references TYPETOUR (IDTYPETOUR)
      on delete restrict on update restrict;

alter table TOUR
   add constraint FK_TOUR_ASSOCIATI_COMPETIT foreign key (IDCOMPETITION)
      references COMPETITION (IDCOMPETITION)
      on delete restrict on update restrict;

