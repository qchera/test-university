INSERT INTO lecturer (name, degree, salary) VALUES
  ('John Doe', 'ASSISTANT', 14000.00),
  ('Jane Doe', 'ASSOCIATE_PROFESSOR', 20000.00),
  ('Walter White', 'PROFESSOR', 25000.00),
  ('Jesse Pinkman', 'ASSISTANT', 13000.00);

INSERT INTO department (name, head_id) VALUES
  ('Computer Science', 3),
  ('Mathematics', 2),
  ('Physics', 1);

INSERT INTO department_lecturer (department_id, lecturer_id) VALUES
  (1, 1),
  (1, 3),
  (1, 4),

  (2, 1),
  (2, 2),

  (3, 2),
  (3, 4);
