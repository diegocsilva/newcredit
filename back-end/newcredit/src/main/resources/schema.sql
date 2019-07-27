create table customer
(
	id bigint not null
		constraint customer_pkey
			primary key,
	age integer,
	cpf varchar(255),
	dependents integer,
	income double precision,
	marital_status integer,
	name varchar(255),
	sex integer,
	state varchar(255)
);

alter table customer owner to postgres;

create table credit_proposal
(
	id bigint not null
		constraint credit_proposal_pkey
			primary key,
	description_result varchar(255),
	margin varchar(255),
	status integer,
	customer_id bigint not null
		constraint fkdc5ac1apwk4iiq6e6f2151ifh
			references customer
);

alter table credit_proposal owner to postgres;

