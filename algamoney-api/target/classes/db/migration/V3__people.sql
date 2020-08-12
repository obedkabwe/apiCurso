      
create table algamoneyapi.pessoa(

codigo int not null primary key AUTO_INCREMENT,
nome varchar(100) not null,
endereco varchar(60) not null,
logradouro varchar(80) not null,
complemento varchar(90) not null,
bairo varchar(40) not null,
cep varchar(70) not null,
cidade varchar(110) not null,
estado varchar(80) not null,
ativo BOOLEAN NOT NULL
);


