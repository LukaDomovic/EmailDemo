CREATE TABLE IF NOT EXISTS mails (
    id          INTEGER AUTO_INCREMENT,
    email       VARCHAR(128) NOT NULL,
    subject     VARCHAR(128) NOT NULL,
    content     VARCHAR(1024) NOT NULL,
    pending     BOOLEAN NOT NULL,
    PRIMARY KEY (id)
)