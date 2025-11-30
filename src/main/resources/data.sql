INSERT INTO universities (id, name) VALUES
                                        ('U1', 'Technical University'),
                                        ('U2', 'Medical University'),
                                        ('U3', 'Business University'),
                                        ('U4', 'Arts University'),
                                        ('U5', 'Engineering University'),
                                        ('U6', 'Polytechnic Institute'),
                                        ('U7', 'University of Sciences'),
                                        ('U8', 'International University'),
                                        ('U9', 'National University'),
                                        ('U10', 'European University');

INSERT INTO departments (id, name, faculty, university_id) VALUES
                                                               ('D1', 'Computer Science', 'Informatics', 'U1'),
                                                               ('D2', 'Electrical Engineering', 'Engineering', 'U1'),
                                                               ('D3', 'Mathematics', 'Sciences', 'U7'),
                                                               ('D4', 'Physics', 'Sciences', 'U7'),
                                                               ('D5', 'Chemistry', 'Sciences', 'U7'),
                                                               ('D6', 'Economics', 'Business', 'U3'),
                                                               ('D7', 'History', 'Humanities', 'U9'),
                                                               ('D8', 'Psychology', 'Social Sciences', 'U9'),
                                                               ('D9', 'Architecture', 'Architecture', 'U10'),
                                                               ('D10', 'Automatics', 'Engineering', 'U1');

INSERT INTO rooms (id, capacity, number, building) VALUES
                                                       ('R1', 25, '101', 'A'),
                                                       ('R2', 30, '102', 'A'),
                                                       ('R3', 40, '201', 'B'),
                                                       ('R4', 35, '202', 'B'),
                                                       ('R5', 20, '301', 'C'),
                                                       ('R6', 50, '302', 'C'),
                                                       ('R7', 45, '401', 'D'),
                                                       ('R8', 28, '402', 'D'),
                                                       ('R9', 60, '501', 'E'),
                                                       ('R10', 32, '502', 'E');

INSERT INTO students (id, name, email) VALUES
                                           ('S1', 'Ana Popa', 'ana.popa@university.com'),
                                           ('S2', 'Mihai Ion', 'mihai.ion@university.com'),
                                           ('S3', 'Elena Dobre', 'elena.dobre@university.com'),
                                           ('S4', 'Vlad Ene', 'vlad.ene@university.com'),
                                           ('S5', 'Teodora Stan', 'teodora.stan@university.com'),
                                           ('S6', 'Radu Marin', 'radu.marin@university.com'),
                                           ('S7', 'Andreea Pavel', 'andreea.pavel@university.com'),
                                           ('S8', 'Bianca Iacob', 'bianca.iacob@university.com'),
                                           ('S9', 'George Luca', 'george.luca@university.com'),
                                           ('S10', 'Cristian Bratu', 'cristian.bratu@university.com');

INSERT INTO teachers (id, name, phone_number, rank, department_id) VALUES
                                                                       ('T1', 'Ionescu Dan', '0711111111', 'Professor', 'D1'),
                                                                       ('T2', 'Popescu Ana', '0722222222', 'Lecturer', 'D1'),
                                                                       ('T3', 'Matei Ioan', '0733333333', 'Professor', 'D2'),
                                                                       ('T4', 'Sava Elena', '0744444444', 'Assistant', 'D3'),
                                                                       ('T5', 'Ciobanu Radu', '0755555555', 'Lecturer', 'D4'),
                                                                       ('T6', 'Moldovan Maria', '0766666666', 'Professor', 'D5'),
                                                                       ('T7', 'Enache Florin', '0777777777', 'Assistant', 'D6'),
                                                                       ('T8', 'Toma Silviu', '0788888888', 'Lecturer', 'D7'),
                                                                       ('T9', 'Oprea Larisa', '0799999999', 'Professor', 'D8'),
                                                                       ('T10', 'Sandu Iulian', '0700000000', 'Assistant', 'D9');

INSERT INTO courses (id, title, credits, semester, department_id, room_id) VALUES
                                                                               ('C1', 'Algorithms', 6, 'Fall', 'D1', 'R1'),
                                                                               ('C2', 'Databases', 5, 'Spring', 'D1', 'R2'),
                                                                               ('C3', 'Physics 1', 4, 'Fall', 'D4', 'R3'),
                                                                               ('C4', 'Chemistry Basics', 5, 'Spring', 'D5', 'R4'),
                                                                               ('C5', 'Microeconomics', 6, 'Fall', 'D6', 'R5'),
                                                                               ('C6', 'Macroeconomics', 6, 'Spring', 'D6', 'R6'),
                                                                               ('C7', 'European History', 4, 'Fall', 'D7', 'R7'),
                                                                               ('C8', 'Programming 1', 5, 'Spring', 'D1', 'R8'),
                                                                               ('C9', 'Linear Algebra', 5, 'Fall', 'D3', 'R9'),
                                                                               ('C10', 'Architecture Planning', 6, 'Spring', 'D9', 'R10');

INSERT INTO enrollments (id, student_id, course_id, grade) VALUES
                                                               ('E1', 'S1', 'C1', 'A'),
                                                               ('E2', 'S1', 'C2', 'B'),
                                                               ('E3', 'S2', 'C3', 'C'),
                                                               ('E4', 'S3', 'C1', 'A'),
                                                               ('E5', 'S4', 'C4', 'D'),
                                                               ('E6', 'S5', 'C5', 'F'),
                                                               ('E7', 'S6', 'C6', 'B'),
                                                               ('E8', 'S7', 'C7', 'A'),
                                                               ('E9', 'S8', 'C8', 'NA'),
                                                               ('E10', 'S9', 'C9', 'C');

INSERT INTO teaching_assignments (id, teacher_id, course_id, role) VALUES
                                                                       ('TA1', 'T1', 'C1', 'LAB'),
                                                                       ('TA2', 'T2', 'C2', 'TA'),
                                                                       ('TA3', 'T3', 'C3', 'GRADER'),
                                                                       ('TA4', 'T4', 'C4', 'LAB'),
                                                                       ('TA5', 'T5', 'C5', 'TA'),
                                                                       ('TA6', 'T6', 'C6', 'GRADER'),
                                                                       ('TA7', 'T7', 'C7', 'LAB'),
                                                                       ('TA8', 'T8', 'C8', 'TA'),
                                                                       ('TA9', 'T9', 'C9', 'GRADER'),
                                                                       ('TA10', 'T10', 'C10', 'LAB');

INSERT INTO assistants (id, name, phone_number, role) VALUES
                                                          ('A1', 'Laura Dragan', '0711111111', 'LAB'),
                                                          ('A2', 'Rares Pop', '0722222222', 'TA'),
                                                          ('A3', 'Ioana Mihai', '0733333333', 'GRADER'),
                                                          ('A4', 'Daniel Anton', '0744444444', 'LAB'),
                                                          ('A5', 'Cristina Pavel', '0755555555', 'TA'),
                                                          ('A6', 'Diana Ionescu', '0766666666', 'GRADER'),
                                                          ('A7', 'Alex Marin', '0777777777', 'LAB'),
                                                          ('A8', 'Oana Tudor', '0788888888', 'TA'),
                                                          ('A9', 'Claudiu Ene', '0799999999', 'GRADER'),
                                                          ('A10', 'Andra Stoica', '0700000000', 'LAB');
