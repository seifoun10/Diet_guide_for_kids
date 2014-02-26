-- phpMyAdmin SQL Dump
-- version 3.5.1
-- http://www.phpmyadmin.net
--
-- Client: localhost
-- Généré le: Mer 26 Février 2014 à 14:20
-- Version du serveur: 5.0.27-community-nt
-- Version de PHP: 5.3.13

SET SQL_MODE="NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Base de données: `diet_guide_for_kids`
--

-- --------------------------------------------------------

--
-- Structure de la table `evaluations_pediatres`
--

CREATE TABLE IF NOT EXISTS `evaluations_pediatres` (
  `Login_Pediatre` varchar(20) NOT NULL,
  `Login_Parent` varchar(20) NOT NULL,
  `Note` int(2) NOT NULL,
  PRIMARY KEY  (`Login_Pediatre`,`Login_Parent`),
  KEY `fk_parents_evaluations` (`Login_Parent`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `parents`
--

CREATE TABLE IF NOT EXISTS `parents` (
  `Login` varchar(20) NOT NULL COMMENT 'Pseudo',
  `Travail` varchar(50) default NULL,
  PRIMARY KEY  (`Login`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `pediatres`
--

CREATE TABLE IF NOT EXISTS `pediatres` (
  `Login` varchar(20) NOT NULL COMMENT 'Pseudo',
  `CIN` int(8) NOT NULL,
  `Doc` text NOT NULL,
  `isAccepted` tinyint(1) NOT NULL default '0',
  PRIMARY KEY  (`Login`),
  UNIQUE KEY `CIN` (`CIN`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Contenu de la table `pediatres`
--

INSERT INTO `pediatres` (`Login`, `CIN`, `Doc`, `isAccepted`) VALUES
('Akrem', 56332679, 'akrem.pdf', 0),
('Altair', 12345678, 'sa_aqtaou_yadayka.pdf', 0),
('Aymen', 98356723, 'aymen.pdf', 0),
('barha', 74523443, 'blazebr.docx', 0),
('EzioAudi', 12345679, 'leonardo_sadi9i.pdf', 0),
('fat7ya', 56437621, 'faty.pdf', 0),
('greeny', 96775441, 'sen.pdf', 0),
('Seifoun', 56733421, 'seifoun.pdf', 0),
('tictacf12', 7654343, 'taha_fersi.pdf', 0),
('Zoro', 67335478, 'zoro.pdf', 0);

-- --------------------------------------------------------

--
-- Structure de la table `users`
--

CREATE TABLE IF NOT EXISTS `users` (
  `Login` varchar(20) NOT NULL COMMENT 'Pseudo',
  `Nom` varchar(30) NOT NULL,
  `Prenom` varchar(30) NOT NULL,
  `Email` varchar(50) NOT NULL,
  `pwd` varchar(100) NOT NULL COMMENT 'Mot de passe',
  `Date_De_Naissance` date NOT NULL,
  `Nationalité` varchar(20) NOT NULL,
  `Sexe` tinyint(1) NOT NULL COMMENT '1=homme|0=femme',
  `Date_Inscription` date NOT NULL COMMENT 'Date d''inscription',
  `Type` tinytext NOT NULL COMMENT 'Type de l''utilisateur',
  PRIMARY KEY  (`Login`),
  UNIQUE KEY `Login` (`Login`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Contenu de la table `users`
--

INSERT INTO `users` (`Login`, `Nom`, `Prenom`, `Email`, `pwd`, `Date_De_Naissance`, `Nationalité`, `Sexe`, `Date_Inscription`, `Type`) VALUES
('Akrem', 'Jlassi', 'Akrem', 'akrem@live.com', '836648iyrut1', '1990-09-25', 'Tunisienne', 1, '0000-00-00', 'Pediatre'),
('Altair', 'Ibn La''Ahad', 'Altair', 'Altair@gmail.com', 'abcdef', '1513-04-10', 'Syrienne', 1, '0000-00-00', 'Pediatre'),
('Aymen', 'Souilmi', 'Aymen', 'aymen@gmail.com', '93uro765', '1991-12-24', 'Tunisienne', 1, '0000-00-00', 'Pediatre'),
('barha', 'Jomni', 'Brahim', 'barha@k3ab.fr', 'uueyyz55o', '1991-04-04', 'Tunisienne', 1, '0000-00-00', 'Pediatre'),
('EzioAudi', 'Auditori Da Firenze', 'Ezio', 'Ezio@live.fr', 'abcdef', '1797-02-28', 'Italienne', 1, '0000-00-00', 'Pediatre'),
('fat7ya', 'Ben Zokra', 'Fathya', 'faty@live.tn', 'peori665', '1993-03-24', 'Française', 0, '0000-00-00', 'Pediatre'),
('greeny', 'Benlakhdhar', 'Ahmed Mohamed', 'greeny@live.fr', 'poaaeyyre', '1992-01-27', 'Tunisienne', 1, '0000-00-00', 'Pediatre'),
('Seifoun', 'Jemal', 'Seif', 'seifoun@gmail.fr', '8734iuyor1', '1991-09-04', 'Tunisienne', 1, '0000-00-00', 'Pediatre'),
('tictacf12', 'Fersi', 'Taha', 'tictac@chab.com', '987aaze', '1993-02-02', 'Tunisienne', 1, '0000-00-00', 'Pediatre'),
('Zoro', 'Lanbouba', 'Zohra', 'zoro@hotmail.com', '983662zuor56', '1984-04-18', 'Americaine', 0, '0000-00-00', 'Pediatre');

--
-- Contraintes pour les tables exportées
--

--
-- Contraintes pour la table `evaluations_pediatres`
--
ALTER TABLE `evaluations_pediatres`
  ADD CONSTRAINT `fk_parents_evaluations` FOREIGN KEY (`Login_Parent`) REFERENCES `parents` (`Login`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `fk_pediatres_evaluations` FOREIGN KEY (`Login_Pediatre`) REFERENCES `pediatres` (`Login`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Contraintes pour la table `pediatres`
--
ALTER TABLE `pediatres`
  ADD CONSTRAINT `fk_pediatres_users` FOREIGN KEY (`Login`) REFERENCES `users` (`Login`) ON DELETE CASCADE ON UPDATE CASCADE;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
