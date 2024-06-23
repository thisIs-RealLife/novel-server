CREATE TABLE e_role
(
    id        BIGSERIAL PRIMARY KEY,
    role_name VARCHAR(255) NOT NULL
);

CREATE TABLE e_user
(
    id       BIGSERIAL PRIMARY KEY,
    login    VARCHAR(255) NOT NULL,
    password VARCHAR(255) NOT NULL,
    email    VARCHAR(255),
    role_id  BIGINT       not null,
    FOREIGN KEY (role_id) REFERENCES e_role (id)
);



CREATE TABLE e_novel
(
    id            BIGSERIAL PRIMARY KEY,
    name          VARCHAR(255) NOT NULL,
    author        VARCHAR(255) NOT NULL,
    description   VARCHAR(400) NOT NULL,
    image         bytea        NOT NULL,
    image_name    VARCHAR(255) NOT NULL,
    chapter_count INTEGER,
    amount        BIGINT       NOT NULL
);

CREATE TABLE e_chapter
(
    id       BIGSERIAL PRIMARY KEY,
    title    VARCHAR(100) NOT NULL,
    index    int          not null,
    novel_id BIGINT       NOT NULL,
    FOREIGN KEY (novel_id) references e_novel (id)
);

CREATE TABLE e_scene
(
    id         BIGSERIAL primary key,
    text       VARCHAR(255) NOT NULL,
    chapter_id BIGINT       NOT NULL,
    FOREIGN KEY (chapter_id) references e_chapter (id)
);

CREATE TABLE e_choice
(
    id          BIGSERIAL PRIMARY KEY,
    choiceText  VARCHAR(255),
    action_type VARCHAR(100) NOT NULL
);

CREATE TABLE choice_scenes
(
    choice_id     BIGINT NOT NULL,
    next_scene_id BIGINT NOT NULL,
    FOREIGN KEY (choice_id) REFERENCES choices (id),
    FOREIGN KEY (next_scene_id) REFERENCES scenes (id)
);
