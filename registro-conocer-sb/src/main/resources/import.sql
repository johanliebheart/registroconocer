	/* example table */
	
INSERT INTO usuario (id_usuario, password, tipo_de_usuario, estado) VALUES(1, '12345', 1, 1);
INSERT INTO usuario (id_usuario, password, tipo_de_usuario, estado) VALUES(2, '56478', 2, 1);
INSERT INTO usuario (id_usuario, password, tipo_de_usuario, estado) VALUES(3, '91011', 3, 1);
INSERT INTO usuario (id_usuario, password, tipo_de_usuario, estado) VALUES(4, '12131', 1, 0);

/* ejemplo de ei */

INSERT INTO evaluador_independiente (estado, fecha_alta, no_evaluadores, nombre) VALUES(1, '2017-08-28',3, 'ADMIN IT OK CENTER');
INSERT INTO evaluador_independiente (estado, fecha_alta, no_evaluadores, nombre) VALUES(1, '2017-04-26',3, 'Javier de la Rosa');
INSERT INTO evaluador_independiente (estado, fecha_alta, no_evaluadores, nombre) VALUES(1, '2017-03-12',3, 'Innoversitas');

/* ejemplo de estandar */

INSERT INTO estandar (id_clave_estandar, clave, nombre, vigencia) VALUES(76, 'EC0076', 'Evaluación de estandares de competencia', 365);
INSERT INTO estandar (id_clave_estandar, clave, nombre, vigencia) VALUES(211, 'EC0211', 'Prestación de servicios para modificar la coloración del cabello.', 365);
INSERT INTO estandar (id_clave_estandar, clave, nombre, vigencia) VALUES(859, 'EC0859', 'Diseño de maquillaje profesional', 365);

/* estandares autorizados */ 

INSERT INTO estandares_autorizados (id_clave_estandar, id_evaluador_independiente, fecha_acreditacion, fecha_finalizacion) VALUES(76,1,'2020-03-23','2021-03-23');

INSERT INTO lote_dictamen (id_lote_dictamen, numero_fichas, procedente,  contador) VALUES (0,0,0,0);

INSERT INTO usuario (username, password, enabled) VALUES('admin', '$2a$10$DOMDxjYyfZ/e7RcBfUpzqeaCs8pLgcizuiQWXPkU35nOhZlFcE9MS', 1);
INSERT INTO usuario (username, password, enabled) VALUES('hector', '$2a$10$O9wxmH/AeyZZzIS09Wp8YOEMvFnbRVJ8B4dmAMVSGloR62lj.yqXG', 1);


INSERT INTO authorities (user_id, authority) VALUES(1, 'ROLE_ADMIN');
INSERT INTO authorities (user_id, authority) VALUES(1, 'ROLE_USER');
INSERT INTO authorities (user_id, authority) VALUES(2, 'ROLE_USER');

 