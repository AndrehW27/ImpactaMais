CREATE TABLE `tb_postagem` (
	`id_postagem` bigint NOT NULL AUTO_INCREMENT,
	`titulo` varchar(120) NOT NULL DEFAULT 'not  null',
	`text_box` varchar(2200) NOT NULL,
	`data_time` DATETIME NOT NULL DEFAULT 'not  null',
	`localizacao` varchar(120) NOT NULL,
	`tema_id` bigint NOT NULL DEFAULT 'not null',
	`usuario_id` bigint NOT NULL DEFAULT 'not  null',
	PRIMARY KEY (`id_postagem`)
);

CREATE TABLE `tb_tema` (
	`id_tema` bigint NOT NULL AUTO_INCREMENT,
	`pedido` varchar(255) NOT NULL DEFAULT 'not null',
	`ajudei` varchar(255) NOT NULL DEFAULT 'not null',
	`info` varchar(255) NOT NULL DEFAULT 'not null',
	PRIMARY KEY (`id_tema`)
);

CREATE TABLE `tb_usuario` (
	`id_usuario` bigint NOT NULL AUTO_INCREMENT,
	`nome_completo` varchar(60) NOT NULL DEFAULT 'not null',
	`email` varchar(80) NOT NULL DEFAULT 'not null',
	`senha` varchar(20) NOT NULL DEFAULT 'not null',
	PRIMARY KEY (`id_usuario`)
);

ALTER TABLE `tb_postagem` ADD CONSTRAINT `tb_postagem_fk0` FOREIGN KEY (`tema_id`) REFERENCES `tb_tema`(`id_tema`);

ALTER TABLE `tb_postagem` ADD CONSTRAINT `tb_postagem_fk1` FOREIGN KEY (`usuario_id`) REFERENCES `tb_usuario`(`id_usuario`);

