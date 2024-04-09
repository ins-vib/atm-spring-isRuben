delete from compte_corrent;
delete from compte_estalvi;
delete from targeta;
delete from client;
INSERT INTO `client` (`id`, `cognoms`, `data_naixement`, `dni`, `nom`, `email`) VALUES ('1', 'Pont Sants', '2014-04-01', '12312344A', 'Ana', 'ana@gmail.com');
INSERT INTO `client` (`id`, `cognoms`, `data_naixement`, `dni`, `nom`, `email`) VALUES ('2', 'Ricard', '2014-04-01', '12312344A', 'Raul', 'raul@gmail.com');
INSERT INTO `client` (`id`, `cognoms`, `data_naixement`, `dni`, `nom`, `email`) VALUES ('3', 'Alexander', '2014-04-01', '12312344A', 'Dani', 'dani@gmail.com');
INSERT INTO `client` (`id`, `cognoms`, `data_naixement`, `dni`, `nom`, `email`) VALUES ('4', 'Sants', '2014-04-01', '12312344A', 'Joan', 'joan@gmail.com');
INSERT INTO `client` (`id`, `cognoms`, `data_naixement`, `dni`, `nom`, `email`) VALUES ('5', 'Pont Sants', '2014-04-01', '12312344A', 'Miquel', 'miquel@gmail.com');

INSERT INTO `compte_corrent`(`numero`, `data_obertura`, `saldo`, `propietari_id`) VALUES ('ES102500000001','2024-12-01','300','1');
INSERT INTO `compte_corrent`(`numero`, `data_obertura`, `saldo`, `propietari_id`) VALUES ('ES102500000002','2024-12-02','300','1');
INSERT INTO `compte_corrent`(`numero`, `data_obertura`, `saldo`, `propietari_id`) VALUES ('ES102500000003','2024-12-03','300','2');
INSERT INTO `compte_corrent`(`numero`, `data_obertura`, `saldo`, `propietari_id`) VALUES ('ES102500000004','2024-12-04','300','2');
INSERT INTO `compte_corrent`(`numero`, `data_obertura`, `saldo`, `propietari_id`) VALUES ('ES102500000005','2024-12-05','300','3');
INSERT INTO `compte_corrent`(`numero`, `data_obertura`, `saldo`, `propietari_id`) VALUES ('ES102500000006','2024-12-06','300','3');

INSERT INTO `compte_estalvi`(`numero`, `data_obertura`, `saldo`, `propietari_id`, `interes`) VALUES ('ES102500000001','2024-12-01','330','1','1');
INSERT INTO `compte_estalvi`(`numero`, `data_obertura`, `saldo`, `propietari_id`, `interes`) VALUES ('ES102500000002','2024-12-02','340','2','1');
INSERT INTO `compte_estalvi`(`numero`, `data_obertura`, `saldo`, `propietari_id`, `interes`) VALUES ('ES102500000003','2024-12-03','350','3','1');

INSERT INTO `targeta` (`numero`, `activa`, `bloquejada`, `cvv`, `data_caducitat`, `num_intents`, `pin`, `compte_corrent_numero`) VALUES ('11112222333A', b'1', b'0', '123', '2025-04-10', '3', '1234', 'ES102500000001');
INSERT INTO `targeta` (`numero`, `activa`, `bloquejada`, `cvv`, `data_caducitat`, `num_intents`, `pin`, `compte_corrent_numero`) VALUES ('11112222333B', b'1', b'0', '123', '2025-04-09', '3', '1234', 'ES102500000002');
INSERT INTO `targeta` (`numero`, `activa`, `bloquejada`, `cvv`, `data_caducitat`, `num_intents`, `pin`, `compte_corrent_numero`) VALUES ('11112222333C', b'1', b'0', '123', '2026-04-15', '3', '1234', 'ES102500000003');
INSERT INTO `targeta` (`numero`, `activa`, `bloquejada`, `cvv`, `data_caducitat`, `num_intents`, `pin`, `compte_corrent_numero`) VALUES ('11112222333D', b'1', b'0', '123', '2026-04-15', '3', '1234', 'ES102500000004');
INSERT INTO `targeta` (`numero`, `activa`, `bloquejada`, `cvv`, `data_caducitat`, `num_intents`, `pin`, `compte_corrent_numero`) VALUES ('11112222333E', b'1', b'0', '123', '2025-04-09', '3', '1234', 'ES102500000005');
INSERT INTO `targeta` (`numero`, `activa`, `bloquejada`, `cvv`, `data_caducitat`, `num_intents`, `pin`, `compte_corrent_numero`) VALUES ('11112222333F', b'1', b'0', '123', '2026-04-08', '3', '1234', 'ES102500000006');