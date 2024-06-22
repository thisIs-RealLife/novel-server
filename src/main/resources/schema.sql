CREATE TABLE e_role(
    id BIGSERIAL PRIMARY KEY,
    role_name VARCHAR(255) NOT NULL
);

CREATE TABLE e_user(
    id BIGSERIAL PRIMARY KEY ,
    login VARCHAR(255) NOT NULL,
    password VARCHAR(255) NOT NULL,
    email VARCHAR(255),
    role_id BIGINT not null ,
    FOREIGN KEY (role_id) REFERENCES e_role(id)
);