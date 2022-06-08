create database clinica3
go
use clinica3
go
create table Medico(
IdMedico				int			 not null,
crm						varchar(255) not null,
nome					varchar(255) not null,
lougradouro				char(255)    not null,
Numero					char(100)    not null,
cep						char(8)      not null,
Bairro					char(255)    not null,
Telefone_Residencial	char(10)     not null,
Telefone_Celular		char(11)     not null,
Especialidade			varchar(255) not null
primary key(IdMedico)
)

go
create table Paciente (
IdPaciente				int				not null,
nome					varchar(255)    not null,
lougradouro				char(255)       not null,
Numero					char(100)       not null,
cep						char(8)         not null,
Bairro					char(255)       not null,
Telefone_Residencial	char(10)        not null,
Telefone_Celular		char(11)        not null,
Email					varchar(255)    not null,
sexo					char(1)         not null,
ConsIdMedicamentos		int		        not null,
IdfatuPaciente		    int			    not null,
ConsIdMedico			int		   	    not null
primary key(IdPaciente),
foreign key(ConsIdMedico) references Medico(IdMedico)

)
go 
create table fatura (
FatId			int			 not null,
FatNome			varchar(100) not null,
FatDescricao	varchar(100) not null,
FatValor		decimal(7,2) not null,
FatData			datetime	 not null,
FatIdPaciente	int			 not null
PRIMARY KEY (FatId)
foreign key(fatIdPaciente) references paciente(IdPaciente)


)

go
create table consulta(
ConsId			   int					not null,
ConsNome		   varchar(100)         not null,
consData		   datetime	            not null,
IdPaciente         int 		            not null,
ConsIdMedico	   int			        not null,
ConsIdExame		   int		            not null,
ConsIdPaciente	   int					not null
primary key(ConsId), 
foreign key(ConsIdPaciente) references Paciente(IdPaciente),
foreign key(ConsIdMedico) references Medico(IdMedico)

)

go 
create table exame(
ExaId			int				not null,
ExaNome			varchar(150)	not null unique,
ExaDescricao	varchar(255)	not null,
ExaResultado	varchar(200)	not null,
ExaIdMedico		int				not null,
ExaIdPaciente	int				not null,
ExaData			datetime		not null
PRIMARY KEY(ExaId)
foreign key(ExaIdMedico) references Medico(IdMedico),
foreign key (ExaIdPaciente) references Paciente(IdPaciente)



)