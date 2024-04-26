INSERT INTO usuario (email, username, password, role)
VALUES ('maria.silva@email.com', 'maria.silva', '$2a$12$DIQGEp7B3SeVQ0UknRYmlumcT7IdDI6uzIZbq0ojn0ngNgGdmZPBK', 'ADMIN');--St@rG@z3r^#
INSERT INTO usuario (email, username, password, role)
VALUES ('joao.santos@email.com', 'joao.santos', '$2a$12$DIQGEp7B3SeVQ0UknRYmlumcT7IdDI6uzIZbq0ojn0ngNgGdmZPBK', 'ADMIN');--St@rG@z3r^#
INSERT INTO usuario (email, username, password, role)
VALUES ('ana.pereira@email.com', 'ana.pereira', '$2a$12$MdXcPrWYTc/8xIywxdaGee6GTrZDPJtPW.25gDiIybUTe7Pxha/tq', 'CLIENTE');--M0n3yB@g#*
INSERT INTO usuario (email, username, password, role)
VALUES ('pedro.oliveira@email.com', 'pedro.oliveira', '$2a$12$MdXcPrWYTc/8xIywxdaGee6GTrZDPJtPW.25gDiIybUTe7Pxha/tq', 'CLIENTE');--M0n3yB@g#*
INSERT INTO usuario (email, username, password, role)
VALUES ('laura.costa@email.com', 'laura.costa', '$2a$12$E288ErO3fVIlKbySkcrhcOT8h98snV.O68zugp8AjJww730EcK27y', 'CLIENTE');--Blu3B1rd!^
INSERT INTO usuario (email, username, password, role)
VALUES ('luis.rodrigues@email.com', 'luis.rodrigues', '$2a$12$E288ErO3fVIlKbySkcrhcOT8h98snV.O68zugp8AjJww730EcK27y', 'CLIENTE');--Blu3B1rd!^
INSERT INTO usuario (email, username, password, role)
VALUES ('sofia.almeida@email.com', 'sofia.almeida', '$2a$12$WFs8E6S.CfmIyayf/Bj1x.Vyn/aWN9rcBk2ejuFLWoa1yFJHm9GWy', 'CLIENTE');--C0mpl1c@ted#
INSERT INTO usuario (email, username, password, role)
VALUES ('miguel.ferreira@email.com', 'miguel.ferreira', '$2a$12$WFs8E6S.CfmIyayf/Bj1x.Vyn/aWN9rcBk2ejuFLWoa1yFJHm9GWy', 'CLIENTE');--C0mpl1c@ted#
INSERT INTO usuario (email, username, password, role)
VALUES ('carolina.sousa@email.com', 'carolina.sousa', '$2a$12$5bKXaKm01zJH5HLhjfNkcOHaWOBIFxJP3XUIWkoVRcNuKIgzbQvfm', 'CONVIDADO');--Pr0t3g1d0!
INSERT INTO usuario (email, username, password, role)
VALUES ('tiago.santos@email.com', 'tiago.santos', '$2a$12$5bKXaKm01zJH5HLhjfNkcOHaWOBIFxJP3XUIWkoVRcNuKIgzbQvfm', 'CONVIDADO');--Pr0t3g1d0!


INSERT INTO todo_item (titulo, detalhes, data, prioridade, usuario_id)
VALUES ('Tarefa aula 1', 'Completar nossa API', '2024-04-15 22:00:00', 'ALTA', 1);
INSERT INTO todo_item (titulo, detalhes, data, prioridade, usuario_id)
VALUES ('Ler um livro - técnico', 'Ler o livro Código Limpo', '2024-04-30 19:00:00', 'MEDIA', 1);
INSERT INTO todo_item (titulo, detalhes, data, prioridade, usuario_id)
VALUES ('Ler um livro - cotidiano', 'O poder do hábito', '2024-04-30 19:00:00', 'MEDIA', 1);
INSERT INTO todo_item (titulo, detalhes, data, prioridade, usuario_id)
VALUES ('Ver um filme', 'Matrix', '2024-04-20 22:00:00', 'BAIXA', 2);
INSERT INTO todo_item (titulo, detalhes, data, prioridade, usuario_id)
VALUES ('Ver um filme', 'A Origem', '2024-04-25 23:00:00', 'BAIXA', 2);
INSERT INTO todo_item (titulo, detalhes, data, prioridade, usuario_id)
VALUES ('Finalizar o projeto do projeto', 'Nosso projeto', '2024-04-17 19:00:00', 'ALTA', 3);
INSERT INTO todo_item (titulo, detalhes, data, prioridade, usuario_id)
VALUES ('Ir ao café', 'Tomar um cafezinho e apreciar a rua', '2024-04-16 09:00:00', 'MEDIA', 3);
INSERT INTO todo_item (titulo, detalhes, data, prioridade, usuario_id)
VALUES ('Dar uma volta', 'Andar pela cidade como um turista', '2024-04-19 10:00:00', 'BAIXA', 3);
INSERT INTO todo_item (titulo, detalhes, data, prioridade, usuario_id)
VALUES ('Levar o cachorro pra passear', 'Viva os doguinhos!', '2024-04-16 10:00:00', 'ALTA', 4);
INSERT INTO todo_item (titulo, detalhes, data, prioridade, usuario_id)
VALUES ('Pizza e cerveja', 'Relaxar! O trabalho já está finalizado', '2024-04-26 19:00:00', 'BAIXA', 4);