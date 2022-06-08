create database clinica3
go
use clinica3
go
create table medico(
IdMedico				int			 not null,
crm						varchar(255) not null,
nome					varchar(255) not null,
logradouro				char(255)    not null,
numero					char(100)    not null,
cep						char(8)      not null,
bairro					char(255)    not null,
telefone_residencial	char(10)     not null,
telefone_celular		char(11)     not null,
especialidade			varchar(255) not null
primary key(IdMedico)
)

go
create table paciente (
id						int				not null,
nome					varchar(255)    not null,
logradouro				char(255)       not null,
numero					char(100)       not null,
cep						char(8)         not null,
bairro					char(255)       not null,
telefone_residencial	char(10)        not null,
telefone_celular		char(11)        not null,
email					varchar(255)    not null,
sexo					char(1)         not null,
IdMedico				int		   	    not null
primary key(id),
foreign key(IdMedico) references Medico(IdMedico)
)
go 
create table fatura (
FatId			int			 not null,
FatNome			varchar(100) not null,
FatDescricao	varchar(100) not null,
FatValor		decimal(7,2) not null,
FatIdPaciente	int			 not null
PRIMARY KEY (FatId)
foreign key(fatIdPaciente) references paciente(id)
)

go
create table consulta(
ConsId			   int					not null,
ConsNome		   varchar(100)         not null,
consData		   datetime	            not null,
IdPaciente         int 		            not null,
ConsIdMedico	   int			        not null,
ConsIdExame		   int		            not null,
ConsIdPaciente	   int					not null,
primary key(ConsId), 
foreign key(ConsIdPaciente) references Paciente(id),
foreign key(ConsIdMedico) references Medico(IdMedico)
)

go 
create table exame(
ExaId			int				not null,
ExaNome			varchar(150)	not null,
ExaDescricao	varchar(255)	not null,
ExaIdPaciente	int				not null,
PRIMARY KEY(ExaId),
foreign key (ExaIdPaciente) references Paciente(id)
)


