-- phpMyAdmin SQL Dump
-- version 4.7.1
-- https://www.phpmyadmin.net/
--
-- Hôte : sql9.freemysqlhosting.net
-- Généré le :  Dim 28 oct. 2018 à 20:55
-- Version du serveur :  5.5.58-0ubuntu0.14.04.1
-- Version de PHP :  7.0.32-0ubuntu0.16.04.1

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données :  `sql9262676`
--

-- --------------------------------------------------------

--
-- Structure de la table `activites`
--

CREATE TABLE `activites` (
  `activiteId` int(11) NOT NULL,
  `nom` varchar(45) DEFAULT NULL,
  `date` datetime DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `nb_enfants_max` int(11) DEFAULT NULL,
  `lieu` varchar(45) DEFAULT NULL,
  `prix` double DEFAULT NULL,
  `visible` tinyint(4) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `activites`
--

INSERT INTO `activites` (`activiteId`, `nom`, `date`, `description`, `nb_enfants_max`, `lieu`, `prix`, `visible`) VALUES
(1, 'Cinema', '2018-10-31 10:00:00', 'Dessin animé Kuzco', 20, 'Cinéma Odyssée', 5, 1),
(2, 'Zoo', '2018-11-16 10:00:00', 'Visite du zoo', 20, 'Zoo St Felicien', 10, 1),
(3, 'Peinture', '2018-10-29 13:00:00', 'Peinture sur toile', 15, 'Garderie', 0, 1);

-- --------------------------------------------------------

--
-- Structure de la table `adresses`
--

CREATE TABLE `adresses` (
  `adresseId` int(11) NOT NULL,
  `ligne_1` varchar(50) DEFAULT NULL,
  `ligne_2` varchar(50) DEFAULT NULL,
  `ligne_3` varchar(50) DEFAULT NULL,
  `ville` varchar(50) DEFAULT NULL,
  `code_postal` varchar(10) DEFAULT NULL,
  `pays` varchar(20) DEFAULT NULL,
  `visible` tinyint(4) DEFAULT '1'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `adresses`
--

INSERT INTO `adresses` (`adresseId`, `ligne_1`, `ligne_2`, `ligne_3`, `ville`, `code_postal`, `pays`, `visible`) VALUES
(1, '375', 'Rue Bégin', NULL, 'Chicoutimi', 'G7H 4M6', 'Canada', 1),
(2, '154', 'Chemin Saint Thomas', NULL, 'Chicoutimi', 'G7H 2P9', 'Canada', 1),
(3, '1412', 'Boulevard Talbot', NULL, 'Chicoutimi', 'G7H 5N8', 'Canada', 1);

-- --------------------------------------------------------

--
-- Structure de la table `articles`
--

CREATE TABLE `articles` (
  `articleId` int(11) NOT NULL,
  `nom` varchar(45) DEFAULT NULL,
  `quantite` int(11) DEFAULT NULL,
  `photo` tinytext,
  `visible` tinyint(4) DEFAULT '1',
  `description` tinytext,
  `inventaireId` int(11) DEFAULT NULL,
  `enfant_inventaireId` int(11) DEFAULT NULL,
  `enfantId` int(11) DEFAULT NULL,
  `categorieId` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `articles`
--

INSERT INTO `articles` (`articleId`, `nom`, `quantite`, `photo`, `visible`, `description`, `inventaireId`, `enfant_inventaireId`, `enfantId`, `categorieId`) VALUES
(1, 'maracas', 8, 'https://www.jbd-jouetsenbois.com/images/Image/Maracas_des_animaux_-_JBD_Jouet_en_Bois.jpg', 1, 'maracas en bois ', 1, NULL, NULL, 3),
(2, 'piano', 3, 'https://images-na.ssl-images-amazon.com/images/I/71XjXkQUKgL._SX355_.jpg', 1, 'piano colorer enfant', 1, NULL, NULL, 3);

-- --------------------------------------------------------

--
-- Structure de la table `calendriers`
--

CREATE TABLE `calendriers` (
  `calendrierId` int(11) NOT NULL,
  `dateDebut` date DEFAULT NULL,
  `dateFin` date DEFAULT NULL,
  `employeId` int(11) NOT NULL,
  `visible` tinyint(4) DEFAULT '1'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `calendriers`
--

INSERT INTO `calendriers` (`calendrierId`, `dateDebut`, `dateFin`, `employeId`, `visible`) VALUES
(1, '2018-09-01', '2019-08-31', 2, 1),
(2, '2018-09-01', '2019-08-31', 3, 1),
(3, '2018-09-01', '2019-08-31', 15, 1),
(4, '2018-09-01', '2019-08-31', 16, 1);

-- --------------------------------------------------------

--
-- Structure de la table `categories_article`
--

CREATE TABLE `categories_article` (
  `categorieId` int(11) NOT NULL,
  `nom` varchar(45) DEFAULT NULL,
  `visible` tinyint(4) DEFAULT '1'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `categories_article`
--

INSERT INTO `categories_article` (`categorieId`, `nom`, `visible`) VALUES
(1, 'Mobilier', 1),
(2, 'Vetements', 1),
(3, 'Jouets', 1),
(4, 'Livres', 1),
(5, 'Accessoires propreté et bain', 1),
(6, 'Alimentation', 1);

-- --------------------------------------------------------

--
-- Structure de la table `comptes_user`
--

CREATE TABLE `comptes_user` (
  `userId` int(11) NOT NULL,
  `login` varchar(45) DEFAULT NULL,
  `password` varchar(45) DEFAULT NULL,
  `privilege` tinyint(4) NOT NULL DEFAULT '0',
  `personneId` int(11) NOT NULL,
  `visible` tinyint(4) DEFAULT '1'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `comptes_user`
--

INSERT INTO `comptes_user` (`userId`, `login`, `password`, `privilege`, `personneId`, `visible`) VALUES
(1, 'jdoe', 'doeJohn95', 1, 1, 1),
(2, 'ptremblay', 'tremblayPaul18', 1, 2, 1),
(3, 'egagnon', 'gElena76', 1, 3, 1),
(4, 'jmbappe', 'mJoe09', 0, 8, 1),
(5, 'kasayo', 'aKylian32', 0, 9, 1),
(6, 'lprimavera', 'pLouis65', 0, 11, 1),
(7, 'mniva', 'nMarie32', 0, 12, 1),
(8, 'mbelle', 'bMichael43', 0, 13, 1),
(9, 'jbelorno', 'bJulie41', 0, 14, 1);

-- --------------------------------------------------------

--
-- Structure de la table `conges`
--

CREATE TABLE `conges` (
  `congeId` int(11) NOT NULL,
  `debut` datetime DEFAULT NULL,
  `duree` int(11) DEFAULT NULL,
  `type_congeId` int(11) NOT NULL,
  `employeId` int(11) NOT NULL,
  `visible` tinyint(4) DEFAULT '1'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Structure de la table `contacts_urgence`
--

CREATE TABLE `contacts_urgence` (
  `contactId` int(11) NOT NULL,
  `telephone` varchar(15) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Structure de la table `documents_officiels`
--

CREATE TABLE `documents_officiels` (
  `documentId` int(11) NOT NULL,
  `nom` varchar(45) DEFAULT NULL,
  `url` tinytext,
  `dossierId` int(11) NOT NULL,
  `enfantId` int(11) NOT NULL,
  `visible` tinyint(4) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Structure de la table `dossiers_contacts_urgence`
--

CREATE TABLE `dossiers_contacts_urgence` (
  `contactId` int(11) NOT NULL,
  `dossierId` int(11) NOT NULL,
  `enfantId` int(11) NOT NULL,
  `lien_parente` varchar(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Structure de la table `dossiers_employe`
--

CREATE TABLE `dossiers_employe` (
  `dossierId` int(11) NOT NULL,
  `date_entree` datetime DEFAULT NULL,
  `nb_mois_anciennete` int(11) DEFAULT NULL,
  `taux_horaire_brut` double DEFAULT NULL,
  `taux_horaire_net` double DEFAULT NULL,
  `visible` tinyint(4) DEFAULT '1',
  `type_contrat` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `dossiers_employe`
--

INSERT INTO `dossiers_employe` (`dossierId`, `date_entree`, `nb_mois_anciennete`, `taux_horaire_brut`, `taux_horaire_net`, `visible`, `type_contrat`) VALUES
(1, '2017-09-05 00:00:00', 15, 13, 10, 1, 2),
(2, '2012-12-12 00:00:00', 0, 24, 20, 1, 2),
(3, '2017-09-05 00:00:00', 5, 13, 10, 1, 2),
(4, '2017-07-13 00:00:00', 30, 13, 10, 1, 2),
(5, '2018-08-15 00:00:00', 0, 13, 10, 1, 2);

-- --------------------------------------------------------

--
-- Structure de la table `dossiers_inscription`
--

CREATE TABLE `dossiers_inscription` (
  `dossierId` int(11) NOT NULL,
  `dateInscription` datetime DEFAULT NULL,
  `nb_demi_journees_inscrit` int(11) DEFAULT NULL,
  `nb_demi_journees_absent` int(11) DEFAULT NULL,
  `medecin_traitant` varchar(255) DEFAULT NULL,
  `enfantId` int(11) NOT NULL,
  `visible` tinyint(4) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Structure de la table `employes`
--

CREATE TABLE `employes` (
  `employeId` int(11) NOT NULL,
  `poste` varchar(45) DEFAULT NULL,
  `externe` tinyint(4) DEFAULT NULL,
  `telephone` varchar(15) DEFAULT NULL,
  `dossierId` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `employes`
--

INSERT INTO `employes` (`employeId`, `poste`, `externe`, `telephone`, `dossierId`) VALUES
(1, 'Directeur', 0, '(418)431-1698', 2),
(2, 'Puericultrice', 0, '(418)431-2596', 1),
(3, 'Puericultrice', 0, '(418)314-2654', 3),
(15, 'Puericultrice', 0, '(418)654-7895', 4),
(16, 'Puericultrice', 0, '(418)369-9658', 5);

-- --------------------------------------------------------

--
-- Structure de la table `employe_edite_rapport`
--

CREATE TABLE `employe_edite_rapport` (
  `rapports_journaliers_rapportId` int(11) NOT NULL,
  `rapports_journaliers_enfantId` int(11) NOT NULL,
  `employeId` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Structure de la table `enfants`
--

CREATE TABLE `enfants` (
  `enfantId` int(11) NOT NULL,
  `visible` tinyint(4) DEFAULT '1',
  `photo` tinytext,
  `groupeId` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `enfants`
--

INSERT INTO `enfants` (`enfantId`, `visible`, `photo`, `groupeId`) VALUES
(4, 1, 'https://goo.gl/images/eUETZ9', 2),
(5, 1, 'https://goo.gl/images/9cSTcy', 3),
(6, 1, 'https://goo.gl/images/wLPxZ7', 1),
(7, 1, 'https://goo.gl/images/ArRn1y', 1),
(10, 1, 'https://goo.gl/images/MY4LXD', 2);

-- --------------------------------------------------------

--
-- Structure de la table `factures`
--

CREATE TABLE `factures` (
  `factureId` int(11) NOT NULL,
  `date_emission` datetime DEFAULT NULL,
  `date_paiement` datetime DEFAULT NULL,
  `montant_ttc` double DEFAULT NULL,
  `visible` tinyint(4) DEFAULT '1',
  `statut` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Structure de la table `filiation`
--

CREATE TABLE `filiation` (
  `personneId` int(11) NOT NULL,
  `enfantId` int(11) NOT NULL,
  `lien_parente` varchar(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Structure de la table `gerer`
--

CREATE TABLE `gerer` (
  `groupeId` int(11) NOT NULL,
  `employeId` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `gerer`
--

INSERT INTO `gerer` (`groupeId`, `employeId`) VALUES
(1, 2),
(2, 3),
(3, 15),
(2, 16);

-- --------------------------------------------------------

--
-- Structure de la table `groupes`
--

CREATE TABLE `groupes` (
  `groupeId` int(11) NOT NULL,
  `descriptif` varchar(2555) DEFAULT NULL,
  `referant` int(11) DEFAULT NULL,
  `visible` tinyint(4) DEFAULT NULL,
  `nom_groupe` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `groupes`
--

INSERT INTO `groupes` (`groupeId`, `descriptif`, `referant`, `visible`, `nom_groupe`) VALUES
(1, 'A', 2, 1, 2),
(2, 'B', 3, 1, 3),
(3, 'C', 15, 1, 1);

-- --------------------------------------------------------

--
-- Structure de la table `horaires`
--

CREATE TABLE `horaires` (
  `horaireId` int(11) NOT NULL,
  `date` date DEFAULT NULL,
  `heureDebut` time DEFAULT NULL,
  `heureFin` time DEFAULT NULL,
  `calendrierId` int(11) NOT NULL,
  `visible` tinyint(4) DEFAULT '1'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `horaires`
--

INSERT INTO `horaires` (`horaireId`, `date`, `heureDebut`, `heureFin`, `calendrierId`, `visible`) VALUES
(1, '2018-09-02', '07:00:00', '13:00:00', 1, 1),
(2, '2018-09-02', '13:00:00', '19:00:00', 2, 1),
(3, '2018-09-02', '07:00:00', '13:00:00', 3, 1),
(4, '2018-09-02', '13:00:00', '19:00:00', 4, 1);

-- --------------------------------------------------------

--
-- Structure de la table `inventaires`
--

CREATE TABLE `inventaires` (
  `inventaireId` int(11) NOT NULL,
  `stock_max` int(11) DEFAULT NULL,
  `stock_actuel` int(11) DEFAULT NULL,
  `employeId` int(11) NOT NULL,
  `visible` tinyint(4) DEFAULT '1'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `inventaires`
--

INSERT INTO `inventaires` (`inventaireId`, `stock_max`, `stock_actuel`, `employeId`, `visible`) VALUES
(1, 100, 6, 1, 1);

-- --------------------------------------------------------

--
-- Structure de la table `inventaires_enfant`
--

CREATE TABLE `inventaires_enfant` (
  `inventaireId` int(11) NOT NULL,
  `enfantId` int(11) NOT NULL,
  `visible` tinyint(4) DEFAULT '1'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Structure de la table `lignes_factures`
--

CREATE TABLE `lignes_factures` (
  `ligneId` int(11) NOT NULL,
  `total_ht` double DEFAULT NULL,
  `total_ttc` double DEFAULT NULL,
  `quantite` int(11) DEFAULT NULL,
  `factureId` int(11) NOT NULL,
  `objet_facturableId` int(11) NOT NULL,
  `visible` tinyint(4) DEFAULT '1'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Structure de la table `maladies`
--

CREATE TABLE `maladies` (
  `maladieId` int(11) NOT NULL,
  `nom` varchar(45) DEFAULT NULL,
  `descriptif` tinytext,
  `visible` tinyint(4) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Structure de la table `objets_facturables`
--

CREATE TABLE `objets_facturables` (
  `objet_facturableId` int(11) NOT NULL,
  `reference` varchar(45) DEFAULT NULL,
  `prix_ht` double DEFAULT NULL,
  `type` varchar(45) DEFAULT NULL,
  `nom` varchar(45) DEFAULT NULL,
  `tvaId` int(11) NOT NULL,
  `visible` tinyint(4) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Structure de la table `parents`
--

CREATE TABLE `parents` (
  `parentId` int(11) NOT NULL,
  `nb_enfants_inscrits` int(11) DEFAULT NULL,
  `telephone` varchar(15) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `parents`
--

INSERT INTO `parents` (`parentId`, `nb_enfants_inscrits`, `telephone`) VALUES
(8, 1, '(450)539-1850'),
(9, 1, '(418)457-3644'),
(11, 2, '(418)543-9978'),
(12, 2, '(418)549-4708'),
(13, 2, '(418)347-5313'),
(14, 2, '(418)545-2434');

-- --------------------------------------------------------

--
-- Structure de la table `parents_factures`
--

CREATE TABLE `parents_factures` (
  `factureId` int(11) NOT NULL,
  `personneId` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Structure de la table `participation`
--

CREATE TABLE `participation` (
  `date` datetime NOT NULL,
  `activiteId` int(11) NOT NULL,
  `groupeId` int(11) NOT NULL,
  `salleId` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Structure de la table `personnes`
--

CREATE TABLE `personnes` (
  `personneId` int(11) NOT NULL,
  `nom` varchar(45) DEFAULT NULL,
  `prenom` varchar(45) DEFAULT NULL,
  `sexe` enum('masculin','feminin') DEFAULT NULL,
  `date_naissance` date DEFAULT NULL,
  `numSecu` varchar(45) DEFAULT NULL,
  `visible` tinyint(4) DEFAULT '1'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `personnes`
--

INSERT INTO `personnes` (`personneId`, `nom`, `prenom`, `sexe`, `date_naissance`, `numSecu`, `visible`) VALUES
(1, 'Doe', 'John', 'masculin', '1985-10-03', 'DOEJ97441816', 1),
(2, 'Tremblay', 'Paul', 'masculin', '1971-10-11', 'TREP46541236', 1),
(3, 'Gagnon', 'Elena', 'feminin', '1982-04-18', 'GAGE73524132', 1),
(4, 'Rooti', 'Lola', 'feminin', '2016-01-10', 'ROOL73659891', 1),
(5, 'Ulysse', 'Matthieu', 'masculin', '2017-06-20', 'ULYM15471439', 1),
(6, 'Baton', 'Rose', 'feminin', '2018-06-02', 'BATR97451172', 1),
(7, 'Pommier', 'Yanis', 'masculin', '2017-03-28', 'POMY98351162', 1),
(8, 'Mbappe', 'Joe', 'masculin', '1990-01-07', 'MBAJ16723789', 1),
(9, 'Asayo', 'Kylian', 'masculin', '1989-04-19', 'ASAK78356471', 1),
(10, 'Lonsi', 'Maryline', 'feminin', '2017-08-15', 'LONM16789365', 1),
(11, 'Primavera', 'Louis', 'masculin', '1982-07-25', 'PRIL76521789', 1),
(12, 'Niva', 'Marie', 'feminin', '1979-04-11', 'NIVM87291003', 1),
(13, 'Belle', 'Michael', 'masculin', '1983-12-29', 'BELM17820941', 1),
(14, 'Belorno', 'Julie', 'feminin', '1980-07-20', 'BELJ97351172', 1),
(15, 'Gagne', 'Manon', 'feminin', '1983-10-09', 'GAGM59625448', 1),
(16, 'Bertier', 'Joanne', 'feminin', '1982-08-12', 'BERJ486531348', 1);

-- --------------------------------------------------------

--
-- Structure de la table `personnes_adresses`
--

CREATE TABLE `personnes_adresses` (
  `adresseId` int(11) NOT NULL,
  `personneId` int(11) NOT NULL,
  `domicile` tinyint(4) DEFAULT NULL,
  `facturation` tinyint(4) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Structure de la table `rapports_journaliers`
--

CREATE TABLE `rapports_journaliers` (
  `rapportId` int(11) NOT NULL,
  `date` datetime DEFAULT NULL,
  `present` tinyint(4) DEFAULT NULL,
  `resume` tinytext,
  `enfantId` int(11) NOT NULL,
  `visible` tinyint(4) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Structure de la table `salles`
--

CREATE TABLE `salles` (
  `salleId` int(11) NOT NULL,
  `libelle` varchar(50) DEFAULT NULL,
  `capacite` int(11) DEFAULT NULL,
  `occupe` tinyint(4) DEFAULT NULL,
  `visible` tinyint(4) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `salles`
--

INSERT INTO `salles` (`salleId`, `libelle`, `capacite`, `occupe`, `visible`) VALUES
(1, 'P1-5020', 15, 0, 1),
(2, 'P1-5030', 40, 0, 1);

-- --------------------------------------------------------

--
-- Structure de la table `statuts_facture`
--

CREATE TABLE `statuts_facture` (
  `statutId` int(11) NOT NULL,
  `libelle` varchar(45) DEFAULT NULL,
  `visible` tinyint(4) DEFAULT '1'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `statuts_facture`
--

INSERT INTO `statuts_facture` (`statutId`, `libelle`, `visible`) VALUES
(1, 'paye', 1),
(2, 'en attente', 1),
(3, 'en retard', 1);

-- --------------------------------------------------------

--
-- Structure de la table `traitements`
--

CREATE TABLE `traitements` (
  `maladieId` int(11) NOT NULL,
  `enfantId` int(11) NOT NULL,
  `nom_medicament` varchar(45) DEFAULT NULL,
  `specification` tinytext,
  `type` varchar(45) DEFAULT NULL,
  `quantite` double DEFAULT NULL,
  `frequence` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Structure de la table `tva`
--

CREATE TABLE `tva` (
  `tvaId` int(11) NOT NULL,
  `nom` varchar(45) DEFAULT NULL,
  `valeur` double DEFAULT NULL,
  `visible` tinyint(4) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `tva`
--

INSERT INTO `tva` (`tvaId`, `nom`, `valeur`, `visible`) VALUES
(1, 'Normal', 20, 1),
(2, 'Intermediaire', 10, 1),
(3, 'Reduit', 5.5, 1);

-- --------------------------------------------------------

--
-- Structure de la table `types_conges`
--

CREATE TABLE `types_conges` (
  `type_congeId` int(11) NOT NULL,
  `type` varchar(50) DEFAULT NULL,
  `visible` tinyint(4) DEFAULT '1'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `types_conges`
--

INSERT INTO `types_conges` (`type_congeId`, `type`, `visible`) VALUES
(1, 'Individuel de formation', 1),
(2, 'Paye', 1),
(3, 'Maternite', 1),
(4, 'Paternite', 1),
(5, 'Sabbatique', 1),
(6, 'Raison familiale', 1),
(7, 'Parental education', 1),
(8, 'Reclassement', 1),
(9, 'Adoption', 1),
(10, 'Longue Maladie', 1),
(11, 'Engagement associatif', 1);

-- --------------------------------------------------------

--
-- Structure de la table `type_contrat`
--

CREATE TABLE `type_contrat` (
  `typeId` int(11) NOT NULL,
  `libelle` varchar(45) DEFAULT NULL,
  `visible` tinyint(4) DEFAULT '1'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `type_contrat`
--

INSERT INTO `type_contrat` (`typeId`, `libelle`, `visible`) VALUES
(1, 'CDD', 1),
(2, 'CDI', 1),
(3, 'Interim', 1);

-- --------------------------------------------------------

--
-- Structure de la table `type_groupe`
--

CREATE TABLE `type_groupe` (
  `nomId` int(11) NOT NULL,
  `libelle` varchar(45) DEFAULT NULL,
  `visible` tinyint(4) DEFAULT '1'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `type_groupe`
--

INSERT INTO `type_groupe` (`nomId`, `libelle`, `visible`) VALUES
(1, 'trotteur', 1),
(2, 'bebe', 1),
(3, 'moyen', 1);

--
-- Index pour les tables déchargées
--

--
-- Index pour la table `activites`
--
ALTER TABLE `activites`
  ADD PRIMARY KEY (`activiteId`);

--
-- Index pour la table `adresses`
--
ALTER TABLE `adresses`
  ADD PRIMARY KEY (`adresseId`);

--
-- Index pour la table `articles`
--
ALTER TABLE `articles`
  ADD PRIMARY KEY (`articleId`),
  ADD KEY `fk_articles_inventaires1` (`inventaireId`),
  ADD KEY `fk_articles_inventaires_enfant1` (`enfant_inventaireId`,`enfantId`),
  ADD KEY `fk_articles_categories_article1` (`categorieId`);

--
-- Index pour la table `calendriers`
--
ALTER TABLE `calendriers`
  ADD PRIMARY KEY (`calendrierId`,`employeId`),
  ADD KEY `fk_calendriers_employes1` (`employeId`);

--
-- Index pour la table `categories_article`
--
ALTER TABLE `categories_article`
  ADD PRIMARY KEY (`categorieId`);

--
-- Index pour la table `comptes_user`
--
ALTER TABLE `comptes_user`
  ADD PRIMARY KEY (`userId`),
  ADD KEY `fk_comptes_user_personnes2` (`personneId`);

--
-- Index pour la table `conges`
--
ALTER TABLE `conges`
  ADD PRIMARY KEY (`congeId`,`employeId`),
  ADD KEY `fk_conges_types_conges1` (`type_congeId`),
  ADD KEY `fk_conges_employes1` (`employeId`);

--
-- Index pour la table `contacts_urgence`
--
ALTER TABLE `contacts_urgence`
  ADD PRIMARY KEY (`contactId`);

--
-- Index pour la table `documents_officiels`
--
ALTER TABLE `documents_officiels`
  ADD PRIMARY KEY (`documentId`,`dossierId`,`enfantId`),
  ADD KEY `fk_documents_officiels_dossiers_inscription1` (`dossierId`,`enfantId`);

--
-- Index pour la table `dossiers_contacts_urgence`
--
ALTER TABLE `dossiers_contacts_urgence`
  ADD PRIMARY KEY (`contactId`,`dossierId`,`enfantId`),
  ADD KEY `fk_contacts_urgence_has_dossiers_inscription_dossiers_inscrip1` (`dossierId`,`enfantId`);

--
-- Index pour la table `dossiers_employe`
--
ALTER TABLE `dossiers_employe`
  ADD PRIMARY KEY (`dossierId`),
  ADD KEY `fk_dossiers_employe_type_contrat1` (`type_contrat`);

--
-- Index pour la table `dossiers_inscription`
--
ALTER TABLE `dossiers_inscription`
  ADD PRIMARY KEY (`dossierId`,`enfantId`),
  ADD KEY `fk_dossiers_inscription_enfants1` (`enfantId`);

--
-- Index pour la table `employes`
--
ALTER TABLE `employes`
  ADD PRIMARY KEY (`employeId`),
  ADD KEY `fk_employes_dossiers_employe1` (`dossierId`);

--
-- Index pour la table `employe_edite_rapport`
--
ALTER TABLE `employe_edite_rapport`
  ADD PRIMARY KEY (`rapports_journaliers_rapportId`,`rapports_journaliers_enfantId`,`employeId`),
  ADD KEY `fk_rapports_journaliers_has_employes_employes1` (`employeId`);

--
-- Index pour la table `enfants`
--
ALTER TABLE `enfants`
  ADD PRIMARY KEY (`enfantId`),
  ADD KEY `fk_enfants_groupes1` (`groupeId`);

--
-- Index pour la table `factures`
--
ALTER TABLE `factures`
  ADD PRIMARY KEY (`factureId`),
  ADD KEY `fk_factures_statuts_facture1` (`statut`);

--
-- Index pour la table `filiation`
--
ALTER TABLE `filiation`
  ADD PRIMARY KEY (`personneId`,`enfantId`),
  ADD KEY `fk_parents_has_enfants_enfants1` (`enfantId`);

--
-- Index pour la table `gerer`
--
ALTER TABLE `gerer`
  ADD PRIMARY KEY (`groupeId`,`employeId`),
  ADD KEY `fk_groupes_has_employes_employes1` (`employeId`);

--
-- Index pour la table `groupes`
--
ALTER TABLE `groupes`
  ADD PRIMARY KEY (`groupeId`),
  ADD KEY `fk_groupes_type_groupe1` (`nom_groupe`),
  ADD KEY `fk_groupes_referant` (`referant`);

--
-- Index pour la table `horaires`
--
ALTER TABLE `horaires`
  ADD PRIMARY KEY (`horaireId`,`calendrierId`),
  ADD KEY `fk_horaires_calendriers1` (`calendrierId`);

--
-- Index pour la table `inventaires`
--
ALTER TABLE `inventaires`
  ADD PRIMARY KEY (`inventaireId`),
  ADD KEY `fk_inventaires_employes1` (`employeId`);

--
-- Index pour la table `inventaires_enfant`
--
ALTER TABLE `inventaires_enfant`
  ADD PRIMARY KEY (`inventaireId`,`enfantId`),
  ADD KEY `fk_inventaires_enfant_enfants1` (`enfantId`);

--
-- Index pour la table `lignes_factures`
--
ALTER TABLE `lignes_factures`
  ADD PRIMARY KEY (`ligneId`,`factureId`),
  ADD KEY `fk_lignes_factures_factures1` (`factureId`),
  ADD KEY `fk_lignes_factures_objets_facturables1` (`objet_facturableId`);

--
-- Index pour la table `maladies`
--
ALTER TABLE `maladies`
  ADD PRIMARY KEY (`maladieId`);

--
-- Index pour la table `objets_facturables`
--
ALTER TABLE `objets_facturables`
  ADD PRIMARY KEY (`objet_facturableId`),
  ADD KEY `fk_objets_facturables_tva1` (`tvaId`);

--
-- Index pour la table `parents`
--
ALTER TABLE `parents`
  ADD PRIMARY KEY (`parentId`);

--
-- Index pour la table `parents_factures`
--
ALTER TABLE `parents_factures`
  ADD PRIMARY KEY (`factureId`,`personneId`),
  ADD KEY `fk_factures_has_parents_parents1` (`personneId`);

--
-- Index pour la table `participation`
--
ALTER TABLE `participation`
  ADD PRIMARY KEY (`activiteId`,`groupeId`,`salleId`),
  ADD KEY `fk_participer_groupes1` (`groupeId`),
  ADD KEY `fk_participer_salles1` (`salleId`);

--
-- Index pour la table `personnes`
--
ALTER TABLE `personnes`
  ADD PRIMARY KEY (`personneId`);

--
-- Index pour la table `personnes_adresses`
--
ALTER TABLE `personnes_adresses`
  ADD PRIMARY KEY (`adresseId`,`personneId`),
  ADD KEY `fk_adresses_has_personnes_personnes1` (`personneId`);

--
-- Index pour la table `rapports_journaliers`
--
ALTER TABLE `rapports_journaliers`
  ADD PRIMARY KEY (`rapportId`,`enfantId`) USING BTREE,
  ADD KEY `enfantId` (`enfantId`);

--
-- Index pour la table `salles`
--
ALTER TABLE `salles`
  ADD PRIMARY KEY (`salleId`);

--
-- Index pour la table `statuts_facture`
--
ALTER TABLE `statuts_facture`
  ADD PRIMARY KEY (`statutId`);

--
-- Index pour la table `traitements`
--
ALTER TABLE `traitements`
  ADD PRIMARY KEY (`maladieId`,`enfantId`),
  ADD KEY `fk_traitements_enfants1` (`enfantId`);

--
-- Index pour la table `tva`
--
ALTER TABLE `tva`
  ADD PRIMARY KEY (`tvaId`);

--
-- Index pour la table `types_conges`
--
ALTER TABLE `types_conges`
  ADD PRIMARY KEY (`type_congeId`);

--
-- Index pour la table `type_contrat`
--
ALTER TABLE `type_contrat`
  ADD PRIMARY KEY (`typeId`);

--
-- Index pour la table `type_groupe`
--
ALTER TABLE `type_groupe`
  ADD PRIMARY KEY (`nomId`);

--
-- AUTO_INCREMENT pour les tables déchargées
--

--
-- AUTO_INCREMENT pour la table `activites`
--
ALTER TABLE `activites`
  MODIFY `activiteId` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;
--
-- AUTO_INCREMENT pour la table `adresses`
--
ALTER TABLE `adresses`
  MODIFY `adresseId` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;
--
-- AUTO_INCREMENT pour la table `articles`
--
ALTER TABLE `articles`
  MODIFY `articleId` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
--
-- AUTO_INCREMENT pour la table `calendriers`
--
ALTER TABLE `calendriers`
  MODIFY `calendrierId` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;
--
-- AUTO_INCREMENT pour la table `categories_article`
--
ALTER TABLE `categories_article`
  MODIFY `categorieId` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;
--
-- AUTO_INCREMENT pour la table `comptes_user`
--
ALTER TABLE `comptes_user`
  MODIFY `userId` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;
--
-- AUTO_INCREMENT pour la table `conges`
--
ALTER TABLE `conges`
  MODIFY `congeId` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT pour la table `dossiers_employe`
--
ALTER TABLE `dossiers_employe`
  MODIFY `dossierId` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;
--
-- AUTO_INCREMENT pour la table `dossiers_inscription`
--
ALTER TABLE `dossiers_inscription`
  MODIFY `dossierId` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT pour la table `factures`
--
ALTER TABLE `factures`
  MODIFY `factureId` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT pour la table `groupes`
--
ALTER TABLE `groupes`
  MODIFY `groupeId` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;
--
-- AUTO_INCREMENT pour la table `horaires`
--
ALTER TABLE `horaires`
  MODIFY `horaireId` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;
--
-- AUTO_INCREMENT pour la table `inventaires`
--
ALTER TABLE `inventaires`
  MODIFY `inventaireId` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;
--
-- AUTO_INCREMENT pour la table `inventaires_enfant`
--
ALTER TABLE `inventaires_enfant`
  MODIFY `inventaireId` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT pour la table `lignes_factures`
--
ALTER TABLE `lignes_factures`
  MODIFY `ligneId` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT pour la table `maladies`
--
ALTER TABLE `maladies`
  MODIFY `maladieId` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT pour la table `objets_facturables`
--
ALTER TABLE `objets_facturables`
  MODIFY `objet_facturableId` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT pour la table `personnes`
--
ALTER TABLE `personnes`
  MODIFY `personneId` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=17;
--
-- AUTO_INCREMENT pour la table `rapports_journaliers`
--
ALTER TABLE `rapports_journaliers`
  MODIFY `rapportId` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT pour la table `salles`
--
ALTER TABLE `salles`
  MODIFY `salleId` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
--
-- AUTO_INCREMENT pour la table `statuts_facture`
--
ALTER TABLE `statuts_facture`
  MODIFY `statutId` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;
--
-- AUTO_INCREMENT pour la table `tva`
--
ALTER TABLE `tva`
  MODIFY `tvaId` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;
--
-- AUTO_INCREMENT pour la table `types_conges`
--
ALTER TABLE `types_conges`
  MODIFY `type_congeId` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=12;
--
-- AUTO_INCREMENT pour la table `type_contrat`
--
ALTER TABLE `type_contrat`
  MODIFY `typeId` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;
--
-- AUTO_INCREMENT pour la table `type_groupe`
--
ALTER TABLE `type_groupe`
  MODIFY `nomId` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;
--
-- Contraintes pour les tables déchargées
--

--
-- Contraintes pour la table `articles`
--
ALTER TABLE `articles`
  ADD CONSTRAINT `fk_articles_inventaires1` FOREIGN KEY (`inventaireId`) REFERENCES `inventaires` (`inventaireId`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_articles_inventaires_enfant1` FOREIGN KEY (`enfant_inventaireId`,`enfantId`) REFERENCES `inventaires_enfant` (`inventaireId`, `enfantId`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_articles_categories_article1` FOREIGN KEY (`categorieId`) REFERENCES `categories_article` (`categorieId`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Contraintes pour la table `calendriers`
--
ALTER TABLE `calendriers`
  ADD CONSTRAINT `fk_calendriers_employes1` FOREIGN KEY (`employeId`) REFERENCES `employes` (`employeId`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Contraintes pour la table `comptes_user`
--
ALTER TABLE `comptes_user`
  ADD CONSTRAINT `fk_comptes_user_personnes2` FOREIGN KEY (`personneId`) REFERENCES `personnes` (`personneId`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Contraintes pour la table `conges`
--
ALTER TABLE `conges`
  ADD CONSTRAINT `fk_conges_types_conges1` FOREIGN KEY (`type_congeId`) REFERENCES `types_conges` (`type_congeId`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_conges_employes1` FOREIGN KEY (`employeId`) REFERENCES `employes` (`employeId`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Contraintes pour la table `contacts_urgence`
--
ALTER TABLE `contacts_urgence`
  ADD CONSTRAINT `fk_personneId_contact` FOREIGN KEY (`contactId`) REFERENCES `personnes` (`personneId`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Contraintes pour la table `documents_officiels`
--
ALTER TABLE `documents_officiels`
  ADD CONSTRAINT `fk_documents_officiels_dossiers_inscription1` FOREIGN KEY (`dossierId`,`enfantId`) REFERENCES `dossiers_inscription` (`dossierId`, `enfantId`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Contraintes pour la table `dossiers_contacts_urgence`
--
ALTER TABLE `dossiers_contacts_urgence`
  ADD CONSTRAINT `fk_contacts_urgence_has_dossiers_inscription_contacts_urgence1` FOREIGN KEY (`contactId`) REFERENCES `contacts_urgence` (`contactId`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_contacts_urgence_has_dossiers_inscription_dossiers_inscrip1` FOREIGN KEY (`dossierId`,`enfantId`) REFERENCES `dossiers_inscription` (`dossierId`, `enfantId`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Contraintes pour la table `dossiers_employe`
--
ALTER TABLE `dossiers_employe`
  ADD CONSTRAINT `fk_dossiers_employe_type_contrat1` FOREIGN KEY (`type_contrat`) REFERENCES `type_contrat` (`typeId`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Contraintes pour la table `dossiers_inscription`
--
ALTER TABLE `dossiers_inscription`
  ADD CONSTRAINT `fk_dossiers_inscription_enfants1` FOREIGN KEY (`enfantId`) REFERENCES `enfants` (`enfantId`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Contraintes pour la table `employes`
--
ALTER TABLE `employes`
  ADD CONSTRAINT `fk_employes_dossiers_employe1` FOREIGN KEY (`dossierId`) REFERENCES `dossiers_employe` (`dossierId`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_employes_personne` FOREIGN KEY (`employeId`) REFERENCES `personnes` (`personneId`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Contraintes pour la table `employe_edite_rapport`
--
ALTER TABLE `employe_edite_rapport`
  ADD CONSTRAINT `fk_rapports_journaliers_has_employes_rapports_journaliers1` FOREIGN KEY (`rapports_journaliers_rapportId`,`rapports_journaliers_enfantId`) REFERENCES `rapports_journaliers` (`rapportId`, `enfantId`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_rapports_journaliers_has_employes_employes1` FOREIGN KEY (`employeId`) REFERENCES `employes` (`employeId`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Contraintes pour la table `enfants`
--
ALTER TABLE `enfants`
  ADD CONSTRAINT `fk_personneId` FOREIGN KEY (`enfantId`) REFERENCES `personnes` (`personneId`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_enfants_groupes1` FOREIGN KEY (`groupeId`) REFERENCES `groupes` (`groupeId`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Contraintes pour la table `factures`
--
ALTER TABLE `factures`
  ADD CONSTRAINT `fk_factures_statuts_facture1` FOREIGN KEY (`statut`) REFERENCES `statuts_facture` (`statutId`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Contraintes pour la table `filiation`
--
ALTER TABLE `filiation`
  ADD CONSTRAINT `fk_parents_has_enfants_parents1` FOREIGN KEY (`personneId`) REFERENCES `parents` (`parentId`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_parents_has_enfants_enfants1` FOREIGN KEY (`enfantId`) REFERENCES `enfants` (`enfantId`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Contraintes pour la table `gerer`
--
ALTER TABLE `gerer`
  ADD CONSTRAINT `fk_groupes_has_employes_groupes1` FOREIGN KEY (`groupeId`) REFERENCES `groupes` (`groupeId`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_groupes_has_employes_employes1` FOREIGN KEY (`employeId`) REFERENCES `employes` (`employeId`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Contraintes pour la table `groupes`
--
ALTER TABLE `groupes`
  ADD CONSTRAINT `fk_groupes_referant` FOREIGN KEY (`referant`) REFERENCES `employes` (`employeId`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_groupes_type_groupe1` FOREIGN KEY (`nom_groupe`) REFERENCES `type_groupe` (`nomId`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Contraintes pour la table `horaires`
--
ALTER TABLE `horaires`
  ADD CONSTRAINT `fk_horaires_calendriers1` FOREIGN KEY (`calendrierId`) REFERENCES `calendriers` (`calendrierId`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Contraintes pour la table `inventaires`
--
ALTER TABLE `inventaires`
  ADD CONSTRAINT `fk_inventaires_employes1` FOREIGN KEY (`employeId`) REFERENCES `employes` (`employeId`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Contraintes pour la table `inventaires_enfant`
--
ALTER TABLE `inventaires_enfant`
  ADD CONSTRAINT `fk_inventaires_enfant_enfants1` FOREIGN KEY (`enfantId`) REFERENCES `enfants` (`enfantId`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Contraintes pour la table `lignes_factures`
--
ALTER TABLE `lignes_factures`
  ADD CONSTRAINT `fk_lignes_factures_factures1` FOREIGN KEY (`factureId`) REFERENCES `factures` (`factureId`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_lignes_factures_objets_facturables1` FOREIGN KEY (`objet_facturableId`) REFERENCES `objets_facturables` (`objet_facturableId`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Contraintes pour la table `objets_facturables`
--
ALTER TABLE `objets_facturables`
  ADD CONSTRAINT `fk_objets_facturables_tva1` FOREIGN KEY (`tvaId`) REFERENCES `tva` (`tvaId`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Contraintes pour la table `parents`
--
ALTER TABLE `parents`
  ADD CONSTRAINT `fk_parents_personnes1` FOREIGN KEY (`parentId`) REFERENCES `personnes` (`personneId`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Contraintes pour la table `parents_factures`
--
ALTER TABLE `parents_factures`
  ADD CONSTRAINT `fk_factures_has_parents_factures1` FOREIGN KEY (`factureId`) REFERENCES `factures` (`factureId`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_factures_has_parents_parents1` FOREIGN KEY (`personneId`) REFERENCES `parents` (`parentId`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Contraintes pour la table `participation`
--
ALTER TABLE `participation`
  ADD CONSTRAINT `fk_participer_activites` FOREIGN KEY (`activiteId`) REFERENCES `activites` (`activiteId`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_participer_groupes1` FOREIGN KEY (`groupeId`) REFERENCES `groupes` (`groupeId`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_participer_salles1` FOREIGN KEY (`salleId`) REFERENCES `salles` (`salleId`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Contraintes pour la table `personnes_adresses`
--
ALTER TABLE `personnes_adresses`
  ADD CONSTRAINT `fk_adresses_has_personnes_adresses1` FOREIGN KEY (`adresseId`) REFERENCES `adresses` (`adresseId`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_adresses_has_personnes_personnes1` FOREIGN KEY (`personneId`) REFERENCES `personnes` (`personneId`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Contraintes pour la table `rapports_journaliers`
--
ALTER TABLE `rapports_journaliers`
  ADD CONSTRAINT `enfantId` FOREIGN KEY (`enfantId`) REFERENCES `enfants` (`enfantId`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Contraintes pour la table `traitements`
--
ALTER TABLE `traitements`
  ADD CONSTRAINT `fk_traitements_maladies1` FOREIGN KEY (`maladieId`) REFERENCES `maladies` (`maladieId`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_traitements_enfants1` FOREIGN KEY (`enfantId`) REFERENCES `enfants` (`enfantId`) ON DELETE NO ACTION ON UPDATE NO ACTION;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
