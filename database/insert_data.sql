INSERT INTO role (code, name, wage_every_hour) VALUES ("ADMIN", "Quản lý", 100);
INSERT INTO role (code, name, wage_every_hour) VALUES ("RECEPTION", "Tiếp tân", 60);
INSERT INTO role (code, name, wage_every_hour) VALUES ("LABOR", "Lao công", 40);


INSERT INTO token (code) 
VALUES ("iupqwoeijsdkjshlakfhakjfhalskdfj1");
INSERT INTO token (code) 
VALUES ("iupqwoeijsdkjshlakfhakjfhalskdfj2");
INSERT INTO token (code) 
VALUES ("iupqwoeijsdkjshlakfhakjfhalskdfj3");
INSERT INTO token (code) 
VALUES ("iupqwoeijsdkjshlakfhakjfhalskdfj4");
INSERT INTO token (code) 
VALUES ("iupqwoeijsdkjshlakfhakjfhalskdfj5");
INSERT INTO token (code) 
VALUES ("iupqwoeijsdkjshlakfhakjfhalskdfj6");
INSERT INTO token (code) 
VALUES ("iupqwoeijsdkjshlakfhakjfhalskdfj7");
INSERT INTO token (code) 
VALUES ("iupqwoeijsdkjshlakfhakjfhalskdfj8");
INSERT INTO token (code) 
VALUES ("iupqwoeijsdkjshlakfhakjfhalskdfj9");
INSERT INTO token (code) 
VALUES ("iupqwoeijsdkjshlakfhakjfhalskdfj10");
INSERT INTO token (code) 
VALUES ("iupqwoeijsdkjshlakfhakjfhalskdfj11");
INSERT INTO token (code) 
VALUES ("iupqwoeijsdkjshlakfhakjfhalskdfj12");


INSERT INTO staff (username, password, fullname, birthday, phone, address, role_id, token_id) 
VALUES ("admin1", "123456", "Quản lý 1", "2021-03-17", "0987654321", "Quảng Bình", 1, 1);
INSERT INTO staff (username, password, fullname, birthday, phone, address, role_id, token_id) 
VALUES ("admin2", "123456", "Quản lý 2", "2021-01-17", "0987654321", "Quảng Bình", 1, 2);

INSERT INTO staff (username, password, fullname, birthday, phone, address, role_id, token_id) 
VALUES ("reception1", "123456", "Tiếp tân 1", "2021-03-17", "0987654321", "Quảng Bình", 2, 3);
INSERT INTO staff (username, password, fullname, birthday, phone, address, role_id, token_id) 
VALUES ("reception2", "123456", "Tiếp tân 2", "2021-03-17", "0987654321", "Quảng Bình", 2, 4);
INSERT INTO staff (username, password, fullname, birthday, phone, address, role_id, token_id) 
VALUES ("reception3", "123456", "Tiếp tân 3", "2021-03-17", "0987654321", "Quảng Bình", 2, 5);
INSERT INTO staff (username, password, fullname, birthday, phone, address, role_id, token_id) 
VALUES ("reception4", "123456", "Tiếp tân 4", "2021-03-17", "0987654321", "Quảng Bình", 2, 6);

INSERT INTO staff (username, password, fullname, birthday, phone, address, role_id, token_id) 
VALUES ("labor1", "123456", "Lao công 1", "2021-03-17", "0987654321", "Quảng Bình", 3, 7);
INSERT INTO staff (username, password, fullname, birthday, phone, address, role_id, token_id) 
VALUES ("labor2", "123456", "Lao công 2", "2021-03-17", "0987654321", "Quảng Bình", 3, 8);
INSERT INTO staff (username, password, fullname, birthday, phone, address, role_id, token_id) 
VALUES ("labor3", "123456", "Lao công 3", "2021-03-17", "0987654321", "Quảng Bình", 3, 9);
INSERT INTO staff (username, password, fullname, birthday, phone, address, role_id, token_id) 
VALUES ("labor4", "123456", "Lao công 4", "2021-03-17", "0987654321", "Quảng Bình", 3, 10);
INSERT INTO staff (username, password, fullname, birthday, phone, address, role_id, token_id) 
VALUES ("labor5", "123456", "Lao công 5", "2021-03-17", "0987654321", "Quảng Bình", 3, 11);
INSERT INTO staff (username, password, fullname, birthday, phone, address, role_id, token_id) 
VALUES ("labor6", "123456", "Lao công 6", "2021-03-17", "0987654321", "Quảng Bình", 3, 12);


INSERT INTO task (code, name) 
VALUES ("MNG_STAFF", "Quản lý Nhân viên");
INSERT INTO task (code, name) 
VALUES ("MNG_ROOM", "Quản lý Phòng");
INSERT INTO task (code, name) 
VALUES ("CLEAN", "Lau dọn");
INSERT INTO task (code, name) 
VALUES ("CHECK_IN", "Check in");
INSERT INTO task (code, name) 
VALUES ("CHECK_OUT", "Check out");


INSERT INTO role_task (role_id, task_id) 
VALUES (1, 1);
INSERT INTO role_task (role_id, task_id) 
VALUES (1, 2);
INSERT INTO role_task (role_id, task_id) 
VALUES (1, 4);
INSERT INTO role_task (role_id, task_id) 
VALUES (1, 5);
INSERT INTO role_task (role_id, task_id) 
VALUES (2, 2);
INSERT INTO role_task (role_id, task_id) 
VALUES (2, 4);
INSERT INTO role_task (role_id, task_id) 
VALUES (2, 5);
INSERT INTO role_task (role_id, task_id) 
VALUES (3, 3);
INSERT INTO role_task (role_id, task_id) 
VALUES (3, 4);
INSERT INTO role_task (role_id, task_id) 
VALUES (3, 5);


INSERT INTO shift_requirement (num_of_admin, num_of_reception, num_of_labor) 
VALUES (1, 2, 4);
INSERT INTO shift_requirement (num_of_admin, num_of_reception, num_of_labor) 
VALUES (1, 1, 3);

INSERT INTO shift_requirement (num_of_admin, num_of_reception, num_of_labor) 
VALUES (1, 2, 4);
INSERT INTO shift_requirement (num_of_admin, num_of_reception, num_of_labor) 
VALUES (1, 1, 1);

INSERT INTO shift_requirement (num_of_admin, num_of_reception, num_of_labor) 
VALUES (1, 2, 4);
INSERT INTO shift_requirement (num_of_admin, num_of_reception, num_of_labor) 
VALUES (1, 1, 1);

INSERT INTO shift_requirement (num_of_admin, num_of_reception, num_of_labor) 
VALUES (1, 2, 4);
INSERT INTO shift_requirement (num_of_admin, num_of_reception, num_of_labor) 
VALUES (1, 1, 1);

INSERT INTO shift_requirement (num_of_admin, num_of_reception, num_of_labor) 
VALUES (1, 2, 4);
INSERT INTO shift_requirement (num_of_admin, num_of_reception, num_of_labor) 
VALUES (1, 1, 1);

INSERT INTO shift_requirement (num_of_admin, num_of_reception, num_of_labor) 
VALUES (1, 2, 4);
INSERT INTO shift_requirement (num_of_admin, num_of_reception, num_of_labor) 
VALUES (1, 1, 1);

INSERT INTO shift_requirement (num_of_admin, num_of_reception, num_of_labor) 
VALUES (1, 2, 4);
INSERT INTO shift_requirement (num_of_admin, num_of_reception, num_of_labor) 
VALUES (1, 1, 3);


INSERT INTO shift (code, name, start_time, end_time, weekday, shift_req_id) 
VALUES ("DURING_DAY", "Buổi ngày", "1900-01-01 07:00:00", "1900-01-01 19:00:00", 1, 1);
INSERT INTO shift (code, name, start_time, end_time, weekday, shift_req_id) 
VALUES ("THROUGH_NIGHT", "Buổi đêm", "1900-01-01 20:00:00", "1900-01-01 06:00:00", 1, 2);

INSERT INTO shift (code, name, start_time, end_time, weekday, shift_req_id) 
VALUES ("DURING_DAY", "Buổi ngày", "1900-01-01 07:00:00", "1900-01-01 19:00:00", 2, 3);
INSERT INTO shift (code, name, start_time, end_time, weekday, shift_req_id) 
VALUES ("THROUGH_NIGHT", "Buổi đêm", "1900-01-01 20:00:00", "1900-01-01 06:00:00", 2, 4);

INSERT INTO shift (code, name, start_time, end_time, weekday, shift_req_id) 
VALUES ("DURING_DAY", "Buổi ngày", "1900-01-01 07:00:00", "1900-01-01 19:00:00", 3, 5);
INSERT INTO shift (code, name, start_time, end_time, weekday, shift_req_id) 
VALUES ("THROUGH_NIGHT", "Buổi đêm", "1900-01-01 20:00:00", "1900-01-01 06:00:00", 3, 6);

INSERT INTO shift (code, name, start_time, end_time, weekday, shift_req_id) 
VALUES ("DURING_DAY", "Buổi ngày", "1900-01-01 07:00:00", "1900-01-01 19:00:00", 4, 7);
INSERT INTO shift (code, name, start_time, end_time, weekday, shift_req_id) 
VALUES ("THROUGH_NIGHT", "Buổi đêm", "1900-01-01 20:00:00", "1900-01-01 06:00:00", 4, 8);

INSERT INTO shift (code, name, start_time, end_time, weekday, shift_req_id) 
VALUES ("DURING_DAY", "Buổi ngày", "1900-01-01 07:00:00", "1900-01-01 19:00:00", 5, 9);
INSERT INTO shift (code, name, start_time, end_time, weekday, shift_req_id) 
VALUES ("THROUGH_NIGHT", "Buổi đêm", "1900-01-01 20:00:00", "1900-01-01 06:00:00", 5, 10);

INSERT INTO shift (code, name, start_time, end_time, weekday, shift_req_id) 
VALUES ("DURING_DAY", "Buổi ngày", "1900-01-01 07:00:00", "1900-01-01 19:00:00", 6, 11);
INSERT INTO shift (code, name, start_time, end_time, weekday, shift_req_id) 
VALUES ("THROUGH_NIGHT", "Buổi đêm", "1900-01-01 20:00:00", "1900-01-01 06:00:00", 6, 12);

INSERT INTO shift (code, name, start_time, end_time, weekday, shift_req_id) 
VALUES ("DURING_DAY", "Buổi ngày", "1900-01-01 07:00:00", "1900-01-01 19:00:00", 7, 13);
INSERT INTO shift (code, name, start_time, end_time, weekday, shift_req_id) 
VALUES ("THROUGH_NIGHT", "Buổi đêm", "1900-01-01 20:00:00", "1900-01-01 06:00:00", 7, 14);


INSERT INTO staff_shift (staff_id, shift_id) 
VALUES (1, 1);
INSERT INTO staff_shift (staff_id, shift_id) 
VALUES (1, 3);
INSERT INTO staff_shift (staff_id, shift_id) 
VALUES (1, 5);
INSERT INTO staff_shift (staff_id, shift_id) 
VALUES (1, 7);
INSERT INTO staff_shift (staff_id, shift_id) 
VALUES (1, 9);
INSERT INTO staff_shift (staff_id, shift_id) 
VALUES (1, 11);
INSERT INTO staff_shift (staff_id, shift_id) 
VALUES (1, 13);

INSERT INTO staff_shift (staff_id, shift_id) 
VALUES (2, 2);
INSERT INTO staff_shift (staff_id, shift_id) 
VALUES (2, 4);
INSERT INTO staff_shift (staff_id, shift_id) 
VALUES (2, 6);
INSERT INTO staff_shift (staff_id, shift_id) 
VALUES (2, 8);
INSERT INTO staff_shift (staff_id, shift_id) 
VALUES (2, 10);
INSERT INTO staff_shift (staff_id, shift_id) 
VALUES (2, 12);
INSERT INTO staff_shift (staff_id, shift_id) 
VALUES (2, 14);

INSERT INTO staff_shift (staff_id, shift_id) 
VALUES (3, 1);
INSERT INTO staff_shift (staff_id, shift_id) 
VALUES (3, 3);
INSERT INTO staff_shift (staff_id, shift_id) 
VALUES (3, 5);
INSERT INTO staff_shift (staff_id, shift_id) 
VALUES (3, 7);
INSERT INTO staff_shift (staff_id, shift_id) 
VALUES (3, 9);
INSERT INTO staff_shift (staff_id, shift_id) 
VALUES (3, 11);
INSERT INTO staff_shift (staff_id, shift_id) 
VALUES (3, 13);

INSERT INTO staff_shift (staff_id, shift_id) 
VALUES (4, 1);
INSERT INTO staff_shift (staff_id, shift_id) 
VALUES (4, 3);
INSERT INTO staff_shift (staff_id, shift_id) 
VALUES (4, 5);
INSERT INTO staff_shift (staff_id, shift_id) 
VALUES (4, 7);
INSERT INTO staff_shift (staff_id, shift_id) 
VALUES (4, 9);
INSERT INTO staff_shift (staff_id, shift_id) 
VALUES (4, 11);
INSERT INTO staff_shift (staff_id, shift_id) 
VALUES (4, 13);

INSERT INTO staff_shift (staff_id, shift_id) 
VALUES (5, 2);
INSERT INTO staff_shift (staff_id, shift_id) 
VALUES (5, 4);
INSERT INTO staff_shift (staff_id, shift_id) 
VALUES (5, 6);
INSERT INTO staff_shift (staff_id, shift_id) 
VALUES (5, 8);
INSERT INTO staff_shift (staff_id, shift_id) 
VALUES (5, 10);
INSERT INTO staff_shift (staff_id, shift_id) 
VALUES (5, 12);
INSERT INTO staff_shift (staff_id, shift_id) 
VALUES (5, 14);

INSERT INTO staff_shift (staff_id, shift_id) 
VALUES (7, 1);
INSERT INTO staff_shift (staff_id, shift_id) 
VALUES (7, 3);
INSERT INTO staff_shift (staff_id, shift_id) 
VALUES (7, 5);
INSERT INTO staff_shift (staff_id, shift_id) 
VALUES (7, 7);
INSERT INTO staff_shift (staff_id, shift_id) 
VALUES (7, 9);
INSERT INTO staff_shift (staff_id, shift_id) 
VALUES (7, 11);
INSERT INTO staff_shift (staff_id, shift_id) 
VALUES (7, 13);

INSERT INTO staff_shift (staff_id, shift_id) 
VALUES (8, 1);
INSERT INTO staff_shift (staff_id, shift_id) 
VALUES (8, 3);
INSERT INTO staff_shift (staff_id, shift_id) 
VALUES (8, 5);
INSERT INTO staff_shift (staff_id, shift_id) 
VALUES (8, 7);
INSERT INTO staff_shift (staff_id, shift_id) 
VALUES (8, 9);
INSERT INTO staff_shift (staff_id, shift_id) 
VALUES (8, 11);
INSERT INTO staff_shift (staff_id, shift_id) 
VALUES (8, 13);

INSERT INTO staff_shift (staff_id, shift_id) 
VALUES (9, 1);
INSERT INTO staff_shift (staff_id, shift_id) 
VALUES (9, 3);
INSERT INTO staff_shift (staff_id, shift_id) 
VALUES (9, 5);
INSERT INTO staff_shift (staff_id, shift_id) 
VALUES (9, 7);
INSERT INTO staff_shift (staff_id, shift_id) 
VALUES (9, 9);
INSERT INTO staff_shift (staff_id, shift_id) 
VALUES (9, 11);
INSERT INTO staff_shift (staff_id, shift_id) 
VALUES (9, 13);

INSERT INTO staff_shift (staff_id, shift_id) 
VALUES (10, 1);
INSERT INTO staff_shift (staff_id, shift_id) 
VALUES (10, 3);
INSERT INTO staff_shift (staff_id, shift_id) 
VALUES (10, 5);
INSERT INTO staff_shift (staff_id, shift_id) 
VALUES (10, 7);
INSERT INTO staff_shift (staff_id, shift_id) 
VALUES (10, 9);
INSERT INTO staff_shift (staff_id, shift_id) 
VALUES (10, 11);
INSERT INTO staff_shift (staff_id, shift_id) 
VALUES (10, 13);

INSERT INTO staff_shift (staff_id, shift_id) 
VALUES (11, 2);
INSERT INTO staff_shift (staff_id, shift_id) 
VALUES (11, 4);
INSERT INTO staff_shift (staff_id, shift_id) 
VALUES (11, 6);
INSERT INTO staff_shift (staff_id, shift_id) 
VALUES (11, 8);
INSERT INTO staff_shift (staff_id, shift_id) 
VALUES (11, 10);
INSERT INTO staff_shift (staff_id, shift_id) 
VALUES (11, 12);
INSERT INTO staff_shift (staff_id, shift_id) 
VALUES (11, 14);

INSERT INTO staff_shift (staff_id, shift_id) 
VALUES (10, 2);
INSERT INTO staff_shift (staff_id, shift_id) 
VALUES (10, 14);

VALUES (12, 2);
INSERT INTO staff_shift (staff_id, shift_id) 
VALUES (12, 14);






