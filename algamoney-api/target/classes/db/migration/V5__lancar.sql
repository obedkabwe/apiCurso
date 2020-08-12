create table lancamento(

codigo int(20)PRIMARY KEY AUTO_INCREMENT,
descricao varchar(50)not null,
data_vencimento date not null,
data_pagamento date not null,
valor decimal (10,2)not null,
observacao varchar (100),
tipo varchar(20)not null,
codigo_categoria int(20)not null,
codigo_pessoa int(20)not null,
foreign key(codigo_categoria)references categoria(codigo),
foreign key(codigo_pessoa)references pessoa(codigo)

);

