create table t_barang (
    id bigint PRIMARY KEY AUTO_INCREMENT,
    kode_barang varchar(8) NOT NULL,
    nama_barang varchar(255) NOT NULL,
    harga decimal(19,2) NOT NULL DEFAULT 0
) ENGINE=InnoDB;