CREATE TABLE users (
    user_id IDENTITY PRIMARY KEY,
    username VARCHAR(50),
    password VARCHAR(255),
    role VARCHAR(50),
    enabled BOOL DEFAULT true
)