--
-- Base de données :  `proxibanque`
--
CREATE DATABASE IF NOT EXISTS `proxibanque` DEFAULT CHARACTER SET latin1 COLLATE latin1_swedish_ci;
USE `proxibanque`;
-- --------------------------------------------------------

--
-- Structure de la table `client`
--

CREATE TABLE `client` (
  `idClient` int(11) NOT NULL,
  `adresse` varchar(255) DEFAULT NULL,
  `nom` varchar(255) NOT NULL,
  `prenom` varchar(255) DEFAULT NULL,
  `codePostal` varchar(255) DEFAULT NULL,
  `ville` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `situationFinanciere` varchar(255) DEFAULT 'normal',
  `situationProfessionnel` varchar(255) DEFAULT 'particulier',
  `idConseiller` int(10) DEFAULT NULL,
  `telephone` varchar(255) DEFAULT NULL,
  `soldeTotal` decimal(15,2) DEFAULT '0.00'
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Contenu de la table `client`
--

INSERT INTO `client` (`idClient`, `adresse`, `nom`, `prenom`, `codePostal`, `ville`, `email`, `situationFinanciere`, `situationProfessionnel`, `idConseiller`, `telephone`, `soldeTotal`) VALUES
(1, '1 cours Lafayette', 'Gaillard', 'Pierre', '69006', 'Lyon', 'pierre@gmail.com', 'normal', 'particulier', 1, '123456789', '-8000.00'),
(2, '2 cours Lafayette', 'Barbier', 'Paul', '69006', 'Lyon', 'paul@gmail.com', 'normal', 'particulier', 1, '134567892', '100000.00'),
(3, '20 cours Lafayette', 'Agostini', 'Jean', '69006', 'Lyon', 'jean@gmail.com', 'riche', 'particulier', 1, '134565842', '900000.00'),
(4, '18 cours Lafayette', 'Raoult', 'Alain', '69006', 'Lyon', 'alain@gmail.com', 'normal', 'particulier', 1, '134562536', '105000.00'),
(5, '150 cours Lafayette', 'Fabre', 'Valérie', '69006', 'Lyon', 'valérie@gmail.com', 'normal', 'entreprise', 1, '134561274', '400000.00'),
(6, '87 cours Lafayette', 'Domingues', 'Laurence', '69006', 'Lyon', 'laurence@gmail.com', 'normal', 'particulier', 1, '134560325', '500.00'),
(7, '65 cours Lafayette', 'Bouyer', 'Louis', '69006', 'Lyon', 'louis@gmail.com', 'riche', 'particulier', 1, '134569012', '700000.00'),
(8, '42 cours Lafayette', 'Franck', 'David', '69006', 'Lyon', 'david@gmail.com', 'normal', 'entreprise', 1, '134566590', '100000.00'),
(9, '15 cours Lafayette', 'Kieffer', 'Nolwen', '69006', 'Lyon', 'nolwen@gmail.com', 'normal', 'entreprise', 1, '134563673', '-61000.00');

-- --------------------------------------------------------

--
-- Structure de la table `compte`
--

CREATE TABLE `compte` (
  `idCompte` int(10) NOT NULL,
  `numeroCompte` int(10) NOT NULL,
  `decouvertAutorise` decimal(15,2) DEFAULT NULL,
  `tauxInteret` decimal(4,2) DEFAULT NULL,
  `solde` decimal(15,2) DEFAULT NULL,
  `typeCarte` varchar(255) DEFAULT NULL,
  `typeDeCompte` varchar(255) DEFAULT 'courant',
  `idClient` int(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Contenu de la table `compte`
--

INSERT INTO `compte` (`idCompte`, `numeroCompte`, `decouvertAutorise`, `tauxInteret`, `solde`, `typeCarte`, `typeDeCompte`, `idClient`) VALUES
(1, 17838547, '-1000.00', NULL, '-8000.00', 'ELECTRON', 'courant', 1),
(2, 12457896, NULL, '3.00', '100000.00', NULL, 'épargne', 2),
(3, 79461325, '-1000.00', NULL, '100000.00', 'PREMIER', 'courant', 3),
(4, 46937145, NULL, '3.00', '800000.00', NULL, 'épargne', 3),
(5, 26845248, '-1000.00', NULL, '2500.00', 'ELECTRON', 'courant', 4),
(6, 12541236, NULL, '3.00', '8000.00', NULL, 'épargne', 4),
(7, 521436712, '-1000.00', NULL, '100000.00', 'PREMIER', 'courant', 5),
(8, 12352458, NULL, '3.00', '300000.00', NULL, 'épargne', 5),
(9, 142541325, '-1000.00', NULL, '500.00', 'ELECTRON', 'courant', 6),
(10, 236521451, NULL, '3.00', '700000.00', NULL, 'épargne', 7),
(11, 1365857412, '-1000.00', NULL, '100000.00', 'ELECTRON', 'courant', 8),
(12, 41257895, '-1000.00', NULL, '-61000.00', 'PREMIER', 'courant', 9);

-- --------------------------------------------------------

--
-- Structure de la table `conseiller`
--

CREATE TABLE `conseiller` (
  `idConseiller` int(11) NOT NULL,
  `nom` varchar(255) NOT NULL,
  `prenom` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Contenu de la table `conseiller`
--

INSERT INTO `conseiller` (`idConseiller`, `nom`, `prenom`) VALUES
(1, 'Jackson', 'Michael');

-- --------------------------------------------------------

--
-- Structure de la table `login`
--

CREATE TABLE `login` (
  `idLogin` int(10) NOT NULL,
  `login` varchar(255) DEFAULT NULL,
  `motDePasse` varchar(255) DEFAULT NULL,
  `idConseiller` int(10) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Contenu de la table `login`
--

INSERT INTO `login` (`idLogin`, `login`, `motDePasse`, `idConseiller`) VALUES
(1, 'theboss', '412563', 1);

--
-- Index pour les tables exportées
--

--
-- Index pour la table `client`
--
ALTER TABLE `client`
  ADD PRIMARY KEY (`idClient`),
  ADD KEY `fk_conseiller` (`idConseiller`);

--
-- Index pour la table `compte`
--
ALTER TABLE `compte`
  ADD PRIMARY KEY (`idCompte`),
  ADD KEY `fk_client` (`idClient`);

--
-- Index pour la table `conseiller`
--
ALTER TABLE `conseiller`
  ADD PRIMARY KEY (`idConseiller`);

--
-- Index pour la table `login`
--
ALTER TABLE `login`
  ADD PRIMARY KEY (`idLogin`),
  ADD KEY `fk_conseiller_login` (`idConseiller`);

--
-- AUTO_INCREMENT pour les tables exportées
--

--
-- AUTO_INCREMENT pour la table `client`
--
ALTER TABLE `client`
  MODIFY `idClient` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;
--
-- AUTO_INCREMENT pour la table `compte`
--
ALTER TABLE `compte`
  MODIFY `idCompte` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=13;
--
-- AUTO_INCREMENT pour la table `conseiller`
--
ALTER TABLE `conseiller`
  MODIFY `idConseiller` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
--
-- AUTO_INCREMENT pour la table `login`
--
ALTER TABLE `login`
  MODIFY `idLogin` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

