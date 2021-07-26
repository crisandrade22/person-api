INSERT INTO people (id, first_name, surname, cpf, birth_date) VALUES
 (1, 'Bruce', 'Wayne', '111.111.111-11', DATE'1980-05-27'),
 (2, 'Mark', 'Grayson', '222.222.222-22', DATE'1988-03-30');

 INSERT INTO phone (id, type, phone_number) VALUES
 (1, 1, '(11) 9 1111-2222'),
 (2, 2, '(11) 9 3333-4444');

 INSERT INTO people_phones (person_entity_id, phones_id) VALUES
 (1,1),
 (1,2);