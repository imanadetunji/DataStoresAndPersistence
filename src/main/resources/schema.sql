CREATE TABLE IF NOT EXISTS candy (
    id BIGINT NOT NULL,
    name NVARCHAR(255),
    price DECIMAL(12,4),
    primary key (id)
);