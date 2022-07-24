--    DROP TABLE IF EXISTS EMPLOYEE;
--    CREATE TABLE EMPLOYEE(
--    id INT  PRIMARY KEY,
--    name VARCHAR(50) NOT NULL,
--    department VARCHAR(50) NOT NULL
--    );
    select * FROM users;
    select * from users_roles;
    select * from roles;
    select * from EMPLOYEE;
--    Modify the satring values of Sequence considering already inserted values
    ALTER SEQUENCE employee_sequence RESTART WITH 7;
    ALTER SEQUENCE role_sequence RESTART WITH 1;
    ALTER SEQUENCE user_sequence RESTART WITH 1;