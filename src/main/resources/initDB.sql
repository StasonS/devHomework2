CREATE TABLE IF NOT EXISTS developers(
  id BIGINT NOT NULL PRIMARY KEY AUTO_INCREMENT,
  first_name VARCHAR(50) NOT NULL ,
  last_name VARCHAR(50) NOT NULL
);

CREATE TABLE IF NOT EXISTS skills(
  id BIGINT NOT NULL PRIMARY KEY AUTO_INCREMENT,
  skill_name VARCHAR(50) NOT NULL
);

CREATE TABLE IF NOT EXISTS projects(
  id BIGINT NOT NULL PRIMARY KEY AUTO_INCREMENT,
  project_name VARCHAR(50) NOT NULL
);

CREATE TABLE IF NOT EXISTS companies(
  id BIGINT NOT NULL PRIMARY KEY AUTO_INCREMENT,
  company_name VARCHAR(50) NOT NULL
);

CREATE TABLE IF NOT EXISTS customers(
  id BIGINT NOT NULL PRIMARY KEY AUTO_INCREMENT,
  customer_name VARCHAR(50) NOT NULL
);

CREATE TABLE IF NOT EXISTS dev_skill (
  dev_id BIGINT NOT NULL,
  skill_id BIGINT NOT NULL,

  FOREIGN KEY (dev_id) REFERENCES developers(id),
  FOREIGN KEY (skill_id) REFERENCES skills(id),

  UNIQUE (dev_id, skill_id)
);

CREATE TABLE IF NOT EXISTS project_developer (
  project_id BIGINT NOT NULL,
  dev_id BIGINT NOT NULL,

  FOREIGN KEY (project_id) REFERENCES projects(id),
  FOREIGN KEY (dev_id) REFERENCES developers(id),

  UNIQUE (project_id, dev_id)
);

CREATE TABLE IF NOT EXISTS company_projects (
  company_id BIGINT NOT NULL,
  project_id BIGINT NOT NULL,

  FOREIGN KEY (company_id) REFERENCES companies(id),
  FOREIGN KEY (project_id) REFERENCES projects(id),

  UNIQUE (company_id, project_id)
);

CREATE TABLE IF NOT EXISTS customer_project (
  customer_id BIGINT NOT NULL,
  project_id BIGINT NOT NULL,

  FOREIGN KEY (customer_id) REFERENCES customers(id),
  FOREIGN KEY (project_id) REFERENCES projects(id),

  UNIQUE (customer_id, project_id)
);