CREATE TABLE businesses (
    id          VARCHAR(255)    NOT NULL,
    name        VARCHAR(255)    NOT NULL,
    owner_name  VARCHAR(255)    NOT NULL,
    city        VARCHAR(100)    NOT NULL,
    segment     VARCHAR(50)     NOT NULL,
    contact     VARCHAR(255)    NOT NULL,
    status      VARCHAR(20)     NOT NULL,

    CONSTRAINT pk_businesses PRIMARY KEY (id),
    CONSTRAINT chk_businesses_segment CHECK (segment IN ('TECHNOLOGY', 'COMMERCE', 'INDUSTRY', 'SERVICES', 'AGRIBUSINESS')),
    CONSTRAINT chk_businesses_status CHECK (status IN ('ACTIVE', 'INACTIVE'))
);

CREATE INDEX idx_businesses_status ON businesses (status);
CREATE INDEX idx_businesses_segment ON businesses (segment);
CREATE INDEX idx_businesses_city ON businesses (city);
