INSERT INTO category(id,name) values (1,'java');
INSERT INTO category(id,name) values (2,'spring');
INSERT INTO category(id,name) values (3,'sql');

INSERT INTO board(id,name,title,content,read_count,create_date,category_id)
values(1,'kim','title1','content 1',0,now(),1);
INSERT INTO board(id,name,title,content,read_count,create_date,category_id)
values(2,'lee','title2','content 2',0,now(),1);
INSERT INTO board(id,name,title,content,read_count,create_date,category_id)
values(3,'kang','title3','content 3',0,now(),1);
INSERT INTO board(id,name,title,content,read_count,create_date,category_id)
values(4,'park','title4','content 4',0,now(),1);

INSERT INTO board(id,name,title,content,read_count,create_date,category_id)
values(1,'kim','title1','content 1',0,now(),2);
INSERT INTO board(id,name,title,content,read_count,create_date,category_id)
values(2,'lee','title2','content 2',0,now(),2);

INSERT INTO board(id,name,title,content,read_count,create_date,category_id)
values(3,'kang','title3','content 3',0,now(),3);
INSERT INTO board(id,name,title,content,read_count,create_date,category_id)
values(4,'park','title4','content 4',0,now(),3);