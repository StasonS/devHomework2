INSERT INTO developers (first_name, last_name) VALUES
  ('Ivan', 'Ivanov'), ('Petr', 'Petrov'), ('Stepan', 'Stepanov'),
  ('Egor', 'Egorov'), ('Danny', 'Smith'), ('John', 'Boobs');

INSERT INTO skills (skill_name) VALUES
  ('Java'), ('SQL'), ('C++'), ('C#'), ('Ruby'), ('HTML'), ('Python');

INSERT INTO projects (project_name) VALUES
  ('project1'), ('project2'), ('project3'), ('project4'),
  ('project5'), ('project6'), ('project7');

INSERT INTO companies (company_name) VALUES
  ('MegaDev'), ('ProgiDarom'), ('Coders'), ('Google');

INSERT INTO customers (customer_name) VALUES
  ('OOO Rosinka'), ('OOO Podsolnushek'), ('OOO Gazprom');

INSERT INTO customer_project (customer_id, project_id) VALUES
  (1, 1), (2, 3), (1, 5), (2, 2), (2, 4), (3, 6), (3, 7);

INSERT INTO company_projects (company_id, project_id) VALUES
  (1, 2), (1, 4), (1, 7), (2, 1), (2, 3), (3, 5), (3, 6);

INSERT INTO dev_skill (dev_id, skill_id) VALUES
  (1, 1), (1, 2), (1, 6), (2, 5), (2, 6), (3, 1), (4, 2), (4, 7), (5, 2), (5, 3),
  (5, 4), (5, 5), (6, 1), (6, 2), (6, 3), (6, 4), (6, 5), (6, 6), (6, 7);

INSERT INTO project_developer (project_id, dev_id) VALUES
  (1, 1), (1, 2), (1, 3), (2, 2), (2, 3), (3, 3), (3, 4), (3, 5), (3, 6), (4, 4),
  (4, 5), (4, 6), (5, 5), (5, 6), (6, 6), (7, 6), (7, 1), (7, 2);