CREATE TABLE IF NOT EXISTS lecturer (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    degree VARCHAR(50) NOT NULL,
    salary DECIMAL(19,2) NOT NULL
);

CREATE TABLE IF NOT EXISTS department (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) NOT NULL UNIQUE,
    head_id BIGINT,
    CONSTRAINT fk_department_head
      FOREIGN KEY (head_id)
      REFERENCES lecturer(id)
);

CREATE TABLE IF NOT EXISTS department_lecturer (
    department_id BIGINT NOT NULL,
    lecturer_id BIGINT NOT NULL,
    PRIMARY KEY (department_id, lecturer_id),
    CONSTRAINT fk_dl_department FOREIGN KEY (department_id) REFERENCES department(id),
    CONSTRAINT fk_dl_lecturer FOREIGN KEY (lecturer_id) REFERENCES lecturer(id)
);
