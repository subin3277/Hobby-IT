-- -----------------------------------------------------
-- insertUser 
-- -----------------------------------------------------
/*
-- Query: select * from member
LIMIT 0, 1000

-- Date: 2023-02-10 09:32
*/
INSERT INTO `member` (`email`,`name`,`nickname`,`password`,`intro`, `is_sns`,`owned_hobby_cnt`,`point`,`img_url`,`state`,`resd_req_dt`,`reg_dt`,`chg_dt`) VALUES ('orlando@gmail.com','올란도','올란도','$2a$10$wITYnelQ6hN3l12QzUqE6.2sN2BaTyeNcYgKL1HIY3a7j96N9m49y',NULL,'FALSE',0,0,'/static/images/defaultimg.png','ACTIVE',NULL,'2023-02-09 12:32:55','2023-02-09 12:32:55');
INSERT INTO `member_privilege` (`member_id`, `privilege`) Values (1, 'GENERAL');
INSERT INTO `member` (`email`,`name`,`nickname`,`password`,`intro`, `is_sns`,`owned_hobby_cnt`,`point`,`img_url`,`state`,`resd_req_dt`,`reg_dt`,`chg_dt`) VALUES ('hobanggirl@gmail.com','김수빈','호방걸','$2a$10$Ai1XiEKza8N0FBjGWG0ERuUcu2fHuK/FPkLYLR.crRJI6Y1pXVfvG',NULL,'FALSE',0,0,'/static/images/defaultimg.png','ACTIVE',NULL,'2023-02-10 08:28:00','2023-02-10 08:28:00');
INSERT INTO `member_privilege` (`member_id`, `privilege`) Values (2, 'GENERAL');
INSERT INTO `member` (`email`,`name`,`nickname`,`password`,`intro`,`is_sns`,`owned_hobby_cnt`,`point`,`img_url`,`state`,`resd_req_dt`,`reg_dt`,`chg_dt`) VALUES ('charles@gmail.com','김찰수','찰스1','$2a$10$tABTAQIfzpeRSIAjiPykuePoEUOE.C9eyDGU1RC3kujRSCRcKJ9oC',NULL,'FALSE',0,0,'/static/images/defaultimg.png','ACTIVE',NULL,'2023-02-10 08:29:25','2023-02-10 08:29:25');
INSERT INTO `member_privilege` (`member_id`, `privilege`) Values (3, 'GENERAL');
INSERT INTO `member` (`email`,`name`,`nickname`,`password`,`intro`,`is_sns`,`owned_hobby_cnt`,`point`,`img_url`,`state`,`resd_req_dt`,`reg_dt`,`chg_dt`) VALUES ('kangkang@gmail.com','강현수','칭찬맨','$2a$10$vAsiV596MNfkYRQyfhFqCez2phP6jTtRf5OEJxht1CjIh/TIiGeJy',NULL,'FALSE',0,0,'/static/images/defaultimg.png','ACTIVE',NULL,'2023-02-10 08:40:58','2023-02-10 08:40:58');
INSERT INTO `member_privilege` (`member_id`, `privilege`) Values (4, 'GENERAL');
INSERT INTO `member` (`email`,`name`,`nickname`,`password`,`intro`,`is_sns`,`owned_hobby_cnt`,`point`,`img_url`,`state`,`resd_req_dt`,`reg_dt`,`chg_dt`) VALUES ('thisisibm@gmail.com','김진수','착한진수','$2a$10$iKYdz9p6JSFcTt31eyW/E.pA.jHKpYViR1fwIXSKvmh..tGOWNOEW',NULL,'FALSE',0,0,'/static/images/defaultimg.png','ACTIVE',NULL,'2023-02-10 08:55:39','2023-02-10 08:55:39');
INSERT INTO `member_privilege` (`member_id`, `privilege`) Values (5, 'GENERAL');
INSERT INTO `member` (`email`,`name`,`nickname`,`password`,`intro`,`is_sns`,`owned_hobby_cnt`,`point`,`img_url`,`state`,`resd_req_dt`,`reg_dt`,`chg_dt`) VALUES ('bbuck01@gmail.com','민창기','헬스쟁이','$2a$10$zL5AT7A5bIM2O4o7NkGYKOE7LadNK8yX1UfO4gGndVuWcDeX5aagK',NULL,'FALSE',0,0,'/static/images/defaultimg.png','ACTIVE',NULL,'2023-02-10 08:56:37','2023-02-10 08:56:37');
INSERT INTO `member_privilege` (`member_id`, `privilege`) Values (6, 'GENERAL');
INSERT INTO `member` (`email`,`name`,`nickname`,`password`,`intro`,`is_sns`,`owned_hobby_cnt`,`point`,`img_url`,`state`,`resd_req_dt`,`reg_dt`,`chg_dt`) VALUES ('kkj96@gmail.com','권경지','권굥디','$2a$10$gVwcxpV2s86esMvJk/F0P.gC0PNl9MtLMzSDX2qhbo5jgHbH6K3J6',NULL,'FALSE',0,0,'/static/images/defaultimg.png','ACTIVE',NULL,'2023-02-10 08:57:14','2023-02-10 08:57:14');
INSERT INTO `member_privilege` (`member_id`, `privilege`) Values (7, 'GENERAL');
INSERT INTO `member` (`email`,`name`,`nickname`,`password`,`intro`,`is_sns`,`owned_hobby_cnt`,`point`,`img_url`,`state`,`resd_req_dt`,`reg_dt`,`chg_dt`) VALUES ('syjf@gmail.com','신예준','갓예준','$2a$10$AlWis9KLNwWlAUDnGYuTnu16DtLRL9Bod77V63zWYXF4zetdGeHBS',NULL,'FALSE',0,0,'/static/images/defaultimg.png','ACTIVE',NULL,'2023-02-10 09:05:11','2023-02-10 09:05:11');
INSERT INTO `member_privilege` (`member_id`, `privilege`) Values (8, 'GENERAL');
INSERT INTO `member` (`email`,`name`,`nickname`,`password`,`intro`,`is_sns`,`owned_hobby_cnt`,`point`,`img_url`,`state`,`resd_req_dt`,`reg_dt`,`chg_dt`) VALUES ('blueocean04@naver.com','박준현','ars','$2a$10$hjuGwsLrOHE3jihJjYsCRe.xc1y5jElV5ljEHsvTet9OtTWkwVUwO',NULL,'FALSE',0,0,'/static/images/defaultimg.png','ACTIVE',NULL,'2023-02-10 09:06:20','2023-02-10 09:06:20');
INSERT INTO `member_privilege` (`member_id`, `privilege`) Values (9, 'GENERAL');
INSERT INTO `member` (`email`,`name`,`nickname`,`password`,`intro`,`is_sns`,`owned_hobby_cnt`,`point`,`img_url`,`state`,`resd_req_dt`,`reg_dt`,`chg_dt`) VALUES ('easythis@naver.com','이시운','또르링','$2a$10$nrfLRYph56gHnaZaRVrIN.wCsr8l5mm/EieihFQcis9AHS4J31t7K',NULL,'FALSE',0,0,'/static/images/defaultimg.png','ACTIVE',NULL,'2023-02-10 09:06:48','2023-02-10 09:06:48');
INSERT INTO `member_privilege` (`member_id`, `privilege`) Values (10, 'GENERAL');
INSERT INTO `member` (`email`,`name`,`nickname`,`password`,`intro`,`is_sns`,`owned_hobby_cnt`,`point`,`img_url`,`state`,`resd_req_dt`,`reg_dt`,`chg_dt`) VALUES ('ych0604@naver.com','윤창현','지슈냥','$2a$10$DeiYona3ou7FHGy89MoMNOcfp03axQgWKeQq2V.yz7y0ypFnsmiWO',NULL,'FALSE',0,0,'/static/images/defaultimg.png','ACTIVE',NULL,'2023-02-10 09:07:16','2023-02-10 09:07:16');
INSERT INTO `member_privilege` (`member_id`, `privilege`) Values (11, 'GENERAL');
INSERT INTO `member` (`email`,`name`,`nickname`,`password`,`intro`,`is_sns`,`owned_hobby_cnt`,`point`,`img_url`,`state`,`resd_req_dt`,`reg_dt`,`chg_dt`) VALUES ('ljj96@naver.com','이정재','Anarchy','$2a$10$yNkJIP/.p0/U61ZeHtNhFOjyu8PCGHTZ0b8yUZKeMBZNqZ.MR4GxW',NULL,'FALSE',0,0,'/static/images/defaultimg.png','ACTIVE',NULL,'2023-02-10 09:08:27','2023-02-10 09:08:27');
INSERT INTO `member_privilege` (`member_id`, `privilege`) Values (12, 'GENERAL');
INSERT INTO `member` (`email`,`name`,`nickname`,`password`,`intro`,`is_sns`,`owned_hobby_cnt`,`point`,`img_url`,`state`,`resd_req_dt`,`reg_dt`,`chg_dt`) VALUES ('ljk96@naver.com','이재근','헌이돼지','$2a$10$WAGBrtg3V4YtPVKRscm4UeV87f119xUhIcLzRYRgjDBTggWMqVLyO',NULL,'FALSE',0,0,'/static/images/defaultimg.png','ACTIVE',NULL,'2023-02-10 09:11:32','2023-02-10 09:11:32');
INSERT INTO `member_privilege` (`member_id`, `privilege`) Values (13, 'GENERAL');
INSERT INTO `member` (`email`,`name`,`nickname`,`password`,`intro`,`is_sns`,`owned_hobby_cnt`,`point`,`img_url`,`state`,`resd_req_dt`,`reg_dt`,`chg_dt`) VALUES ('rhm96@naver.com','류한민','류함밈','$2a$10$4l8Pzw6yeJsrGndUOjeUs.vrExD/Kp0NSStlLbMMzOEZDFdNjGncu',NULL,'FALSE',0,0,'/static/images/defaultimg.png','ACTIVE',NULL,'2023-02-10 09:12:02','2023-02-10 09:12:02');
INSERT INTO `member_privilege` (`member_id`, `privilege`) Values (14, 'GENERAL');
INSERT INTO `member` (`email`,`name`,`nickname`,`password`,`intro`,`is_sns`,`owned_hobby_cnt`,`point`,`img_url`,`state`,`resd_req_dt`,`reg_dt`,`chg_dt`) VALUES ('jjw30@naver.com','장지웅','장지움','$2a$10$wS6Urf1MrO11U.PuRQZrau93sv77puQdaKxaan4GDzLNlRSVCJBmC',NULL,'FALSE',0,0,'/static/images/defaultimg.png','ACTIVE',NULL,'2023-02-10 09:12:21','2023-02-10 09:12:21');
INSERT INTO `member_privilege` (`member_id`, `privilege`) Values (15, 'GENERAL');
INSERT INTO `member` (`email`,`name`,`nickname`,`password`,`intro`,`is_sns`,`owned_hobby_cnt`,`point`,`img_url`,`state`,`resd_req_dt`,`reg_dt`,`chg_dt`) VALUES ('sdh9501@naver.com','신동희','극북곰','$2a$10$t.KhD1AvxfRxmdQa1cfIW.GLBNYkCOfJ254OGzYMPbn6B.kb03Oyy',NULL,'FALSE',0,0,'/static/images/defaultimg.png','ACTIVE',NULL,'2023-02-10 09:12:55','2023-02-10 09:12:55');
INSERT INTO `member_privilege` (`member_id`, `privilege`) Values (16, 'GENERAL');
INSERT INTO `member` (`email`,`name`,`nickname`,`password`,`intro`,`is_sns`,`owned_hobby_cnt`,`point`,`img_url`,`state`,`resd_req_dt`,`reg_dt`,`chg_dt`) VALUES ('ksg96@naver.com','강승권','미치광이과학자','$2a$10$Fn.cOVuQxfNTkuSH5DwY7et0n5pfGdMsYd.XzgtSeJn3ZlrUiJmh.',NULL,'FALSE',0,0,'/static/images/defaultimg.png','ACTIVE',NULL,'2023-02-10 09:17:27','2023-02-10 09:17:27');
INSERT INTO `member_privilege` (`member_id`, `privilege`) Values (17, 'GENERAL');
INSERT INTO `member` (`email`,`name`,`nickname`,`password`,`intro`,`is_sns`,`owned_hobby_cnt`,`point`,`img_url`,`state`,`resd_req_dt`,`reg_dt`,`chg_dt`) VALUES ('kwg96@naver.com','강원경','우효만','$2a$10$IW97CinJtEkDZnlubRYik..2gpDniHqfOKy5Of38P4Amyl70HUv9.',NULL,'FALSE',0,0,'/static/images/defaultimg.png','ACTIVE',NULL,'2023-02-10 09:17:52','2023-02-10 09:17:52');
INSERT INTO `member_privilege` (`member_id`, `privilege`) Values (18, 'GENERAL');
INSERT INTO `member` (`email`,`name`,`nickname`,`password`,`intro`,`is_sns`,`owned_hobby_cnt`,`point`,`img_url`,`state`,`resd_req_dt`,`reg_dt`,`chg_dt`) VALUES ('dlaalstn97@naver.com','임민수','알코올러버','$2a$10$YkFqaIqedSLvqORbmCfTAu7Nnk.H.8SOlrL88WhYA6/N.GdbV/Izu',NULL,'FALSE',0,0,'/static/images/defaultimg.png','ACTIVE',NULL,'2023-02-10 09:22:29','2023-02-10 09:22:29');
INSERT INTO `member_privilege` (`member_id`, `privilege`) Values (19, 'GENERAL');
INSERT INTO `member` (`email`,`name`,`nickname`,`password`,`intro`,`is_sns`,`owned_hobby_cnt`,`point`,`img_url`,`state`,`resd_req_dt`,`reg_dt`,`chg_dt`) VALUES ('djagmlwjd@naver.com','엄희정','까비엄마','$2a$10$5t.Ro5o0v98BaUKw7fwXBeAr/scGFj7g2R3Js.OWIey5gCdXVpCmO',NULL,'FALSE',0,0,'/static/images/defaultimg.png','ACTIVE',NULL,'2023-02-10 09:23:06','2023-02-10 09:23:06');
INSERT INTO `member_privilege` (`member_id`, `privilege`) Values (20, 'GENERAL');


-- -----------------------------------------------------
-- insertHobby
-- -----------------------------------------------------
INSERT INTO `hobby` (`name`,`category`,`intro`,`cur_mem_cnt`,`max_mem_cnt`,`free`,`img_url`,`resd_req_dt`,`reg_dt`) VALUES ('john, 나 여행가고싶어','여행','여행가고 싶은 사람들의 모임',1,14,'FREE','/static/images/defaulthobbyimg.png',NULL,now());
INSERT INTO `hobby` (`name`,`category`,`intro`,`cur_mem_cnt`,`max_mem_cnt`,`free`,`img_url`,`resd_req_dt`,`reg_dt`) VALUES ('Chefs Kiss','요리','위클리 쿡킹을 지향하는 모임',1,12,'FREE','/static/images/defaulthobbyimg.png',NULL, now());
INSERT INTO `hobby` (`name`,`category`,`intro`,`cur_mem_cnt`,`max_mem_cnt`,`free`,`img_url`,`resd_req_dt`,`reg_dt`) VALUES ('두둥탁','음악','밴드 좋아하시나요?',1,16,'FREE','/static/images/defaulthobbyimg.png',NULL, now());
INSERT INTO `hobby` (`name`,`category`,`intro`,`cur_mem_cnt`,`max_mem_cnt`,`free`,`img_url`,`resd_req_dt`,`reg_dt`) VALUES ('개발 마스터','코딩','클린 코드/아키텍처를 목표로 해요',1,14,'FREE','/static/images/defaulthobbyimg.png',NULL, now());
INSERT INTO `hobby` (`name`,`category`,`intro`,`cur_mem_cnt`,`max_mem_cnt`,`free`,`img_url`,`resd_req_dt`,`reg_dt`) VALUES ('창작의 고통','예술','잠겨죽어도 좋으니 너는 물처럼 내게 밀려오라',1,12,'FREE','/static/images/defaulthobbyimg.png',NULL, now());
INSERT INTO `hobby` (`name`,`category`,`intro`,`cur_mem_cnt`,`max_mem_cnt`,`free`,`img_url`,`resd_req_dt`,`reg_dt`) VALUES ('뫄리오!','게임','고전게임부터 신작게임까지!',1,14,'FREE','/static/images/defaulthobbyimg.png',NULL, now());
INSERT INTO `hobby` (`name`,`category`,`intro`,`cur_mem_cnt`,`max_mem_cnt`,`free`,`img_url`,`resd_req_dt`,`reg_dt`) VALUES ('디저트덕후','요리','죽어도 디저트! 죽어도 디저트!',1,14,'FREE','/static/images/defaulthobbyimg.png',NULL, now());
INSERT INTO `hobby` (`name`,`category`,`intro`,`cur_mem_cnt`,`max_mem_cnt`,`free`,`img_url`,`resd_req_dt`,`reg_dt`) VALUES ('집사들','파티','주인님을 모시는 사람들의 모임',1,14,'FREE','/static/images/defaulthobbyimg.png',NULL, now());
INSERT INTO `hobby` (`name`,`category`,`intro`,`cur_mem_cnt`,`max_mem_cnt`,`free`,`img_url`,`resd_req_dt`,`reg_dt`) VALUES ('Metaverse','게임','2x세, 장남일세',1,16,'FREE','/static/images/defaulthobbyimg.png',NULL, now());
INSERT INTO `hobby` (`name`,`category`,`intro`,`cur_mem_cnt`,`max_mem_cnt`,`free`,`img_url`,`resd_req_dt`,`reg_dt`) VALUES ('자아를 찾아서','여행','당신은 지금 어디에 있나요',1,12,'FREE','/static/images/defaulthobbyimg.png',NULL, now());
INSERT INTO `hobby` (`name`,`category`,`intro`,`cur_mem_cnt`,`max_mem_cnt`,`free`,`img_url`,`resd_req_dt`,`reg_dt`) VALUES ('공부만합니다','스터디','진짜 공부만합니다. 소리내면 강퇴입니다',1,14,'FREE','/static/images/defaulthobbyimg.png',NULL, now());
INSERT INTO `hobby` (`name`,`category`,`intro`,`cur_mem_cnt`,`max_mem_cnt`,`free`,`img_url`,`resd_req_dt`,`reg_dt`) VALUES ('비건s','요리','진짜 비건식 탐구',1,14,'FREE','/static/images/defaulthobbyimg.png',NULL, now());
INSERT INTO `hobby` (`name`,`category`,`intro`,`cur_mem_cnt`,`max_mem_cnt`,`free`,`img_url`,`resd_req_dt`,`reg_dt`) VALUES ('lo-fi Study','스터디','공부도 힙하게 한번 해보자',1,12,'FREE','/static/images/defaulthobbyimg.png',NULL, now());
INSERT INTO `hobby` (`name`,`category`,`intro`,`cur_mem_cnt`,`max_mem_cnt`,`free`,`img_url`,`resd_req_dt`,`reg_dt`) VALUES ('artsy','예술','아름다움은 무언인가',1,16,'FREE','/static/images/defaulthobbyimg.png',NULL, now());
INSERT INTO `hobby` (`name`,`category`,`intro`,`cur_mem_cnt`,`max_mem_cnt`,`free`,`img_url`,`resd_req_dt`,`reg_dt`) VALUES ('서핑라이프','운동','서핑에 대한 고찰',1,14,'FREE','/static/images/defaulthobbyimg.png',NULL, now());
INSERT INTO `hobby` (`name`,`category`,`intro`,`cur_mem_cnt`,`max_mem_cnt`,`free`,`img_url`,`resd_req_dt`,`reg_dt`) VALUES ('파티피플','파티','비대면 파티파티 파티~',1,14,'NONFREE','/static/images/defaulthobbyimg.png',NULL, now());
INSERT INTO `hobby` (`name`,`category`,`intro`,`cur_mem_cnt`,`max_mem_cnt`,`free`,`img_url`,`resd_req_dt`,`reg_dt`) VALUES ('추억의닌텐도','게임','진짜 공부만합니다. 소리내면 강퇴입니다',1,14,'FREE','/static/images/defaulthobbyimg.png',NULL, now());
INSERT INTO `hobby` (`name`,`category`,`intro`,`cur_mem_cnt`,`max_mem_cnt`,`free`,`img_url`,`resd_req_dt`,`reg_dt`) VALUES ('알고리즘좋아','코딩','알고리즘...그기 돈이 됩니까...?',1,14,'NONFREE','/static/images/defaulthobbyimg.png',NULL, now());
INSERT INTO `hobby` (`name`,`category`,`intro`,`cur_mem_cnt`,`max_mem_cnt`,`free`,`img_url`,`resd_req_dt`,`reg_dt`) VALUES ('팝뮤직','음악','24시간 노동을 위한 팝송 센터',1,14,'FREE','/static/images/defaulthobbyimg.png',NULL, now());
INSERT INTO `hobby` (`name`,`category`,`intro`,`cur_mem_cnt`,`max_mem_cnt`,`free`,`img_url`,`resd_req_dt`,`reg_dt`) VALUES ('팝송좋아하는사람모여라','음악','팝송 좋아하시나용',1,14,'FREE','/static/images/defaulthobbyimg.png',NULL, now());
INSERT INTO `hobby` (`name`,`category`,`intro`,`cur_mem_cnt`,`max_mem_cnt`,`free`,`img_url`,`resd_req_dt`,`reg_dt`) VALUES ('팝콘서트','음악','팝콘서드?',1,14,'FREE','/static/images/defaulthobbyimg.png',NULL, now());
INSERT INTO `hobby` (`name`,`category`,`intro`,`cur_mem_cnt`,`max_mem_cnt`,`free`,`img_url`,`resd_req_dt`,`reg_dt`) VALUES ('힙팝','음악','외힙 맛만보고가',1,14,'FREE','/static/images/defaulthobbyimg.png',NULL, now());
INSERT INTO `hobby` (`name`,`category`,`intro`,`cur_mem_cnt`,`max_mem_cnt`,`free`,`img_url`,`resd_req_dt`,`reg_dt`) VALUES ('팝콘','음악','팝송을 전파하기 위한 콘서트',1,14,'FREE','/static/images/defaulthobbyimg.png',NULL, now());
INSERT INTO `hobby` (`name`,`category`,`intro`,`cur_mem_cnt`,`max_mem_cnt`,`free`,`img_url`,`resd_req_dt`,`reg_dt`) VALUES ('팝바이브','음악','그냥 팝송 들으려고 만든 모임',1,14,'FREE','/static/images/defaulthobbyimg.png',NULL, now());
INSERT INTO `hobby` (`name`,`category`,`intro`,`cur_mem_cnt`,`max_mem_cnt`,`free`,`img_url`,`resd_req_dt`,`reg_dt`) VALUES ('기타&팝','음악','기타를 베이스로한 팝송을 공유해요',1,14,'FREE','/static/images/defaulthobbyimg.png',NULL, now());
INSERT INTO `hobby` (`name`,`category`,`intro`,`cur_mem_cnt`,`max_mem_cnt`,`free`,`img_url`,`resd_req_dt`,`reg_dt`) VALUES ('팝들어보쉴?','음악','ㅈㄱㄴ',1,14,'FREE','/static/images/defaulthobbyimg.png',NULL, now());
INSERT INTO `hobby` (`name`,`category`,`intro`,`cur_mem_cnt`,`max_mem_cnt`,`free`,`img_url`,`resd_req_dt`,`reg_dt`) VALUES ('마스터오브팝','음악','팝송 모임은 여기가 최고인듯',1,16,'FREE','/static/images/defaulthobbyimg.png',NULL, now());
INSERT INTO `hobby` (`name`,`category`,`intro`,`cur_mem_cnt`,`max_mem_cnt`,`free`,`img_url`,`resd_req_dt`,`reg_dt`) VALUES ('뜨개질로 세계정복','공예','뜨개질스킬을 공유하고 무언가를 만들어보려해요',1,16,'FREE','/static/images/defaulthobbyimg.png',NULL, now());
INSERT INTO `hobby` (`name`,`category`,`intro`,`cur_mem_cnt`,`max_mem_cnt`,`free`,`img_url`,`resd_req_dt`,`reg_dt`) VALUES ('애니 상영회','문화','오타쿠가 아니라능', 1, 12,'FREE','/static/images/defaulthobbyimg.png',NULL, now());


INSERT INTO `hobby` (`name`,`category`,`intro`,`cur_mem_cnt`,`max_mem_cnt`,`free`,`img_url`,`resd_req_dt`,`reg_dt`) VALUES ('john, 나 여행가고싶어요','여행','여행가고 싶은 사람들의 모임',1,14,'NONFREE','/static/images/defaulthobbyimg.png',NULL,now());
INSERT INTO `hobby_member` (`member_id`,`hobby_id`,`state`,`privilege`,`reg_dt`,`chg_dt`,`resd_dt`) VALUES (1,30,'ACTIVE','OWNER',now(), now(),NULL);


-- -----------------------------------------------------
-- insertHobbyMember
-- -----------------------------------------------------
-- 소유자 회원
INSERT INTO `hobby_member` (`member_id`,`hobby_id`,`state`,`privilege`,`reg_dt`,`chg_dt`,`resd_dt`) VALUES (1,1,'ACTIVE','OWNER',now(), now(),NULL);
INSERT INTO `hobby_member` (`member_id`,`hobby_id`,`state`,`privilege`,`reg_dt`,`chg_dt`,`resd_dt`) VALUES (2,2,'ACTIVE','OWNER',now(), now(),NULL);
INSERT INTO `hobby_member` (`member_id`,`hobby_id`,`state`,`privilege`,`reg_dt`,`chg_dt`,`resd_dt`) VALUES (3,3,'ACTIVE','OWNER',now(), now(),NULL);
INSERT INTO `hobby_member` (`member_id`,`hobby_id`,`state`,`privilege`,`reg_dt`,`chg_dt`,`resd_dt`) VALUES (4,4,'ACTIVE','OWNER',now(),now(),NULL);
INSERT INTO `hobby_member` (`member_id`,`hobby_id`,`state`,`privilege`,`reg_dt`,`chg_dt`,`resd_dt`) VALUES (5,5,'ACTIVE','OWNER',now(),now(),NULL);
INSERT INTO `hobby_member` (`member_id`,`hobby_id`,`state`,`privilege`,`reg_dt`,`chg_dt`,`resd_dt`) VALUES (6,6,'ACTIVE','OWNER',now(),now(),NULL);
INSERT INTO `hobby_member` (`member_id`,`hobby_id`,`state`,`privilege`,`reg_dt`,`chg_dt`,`resd_dt`) VALUES (7,7,'ACTIVE','OWNER',now(),now(),NULL);
INSERT INTO `hobby_member` (`member_id`,`hobby_id`,`state`,`privilege`,`reg_dt`,`chg_dt`,`resd_dt`) VALUES (8,8,'ACTIVE','OWNER',now(),now(),NULL);
INSERT INTO `hobby_member` (`member_id`,`hobby_id`,`state`,`privilege`,`reg_dt`,`chg_dt`,`resd_dt`) VALUES (9,9,'ACTIVE','OWNER',now(), now(),NULL);
INSERT INTO `hobby_member` (`member_id`,`hobby_id`,`state`,`privilege`,`reg_dt`,`chg_dt`,`resd_dt`) VALUES (10,10,'ACTIVE','OWNER',now(), now(),NULL);
INSERT INTO `hobby_member` (`member_id`,`hobby_id`,`state`,`privilege`,`reg_dt`,`chg_dt`,`resd_dt`) VALUES (1,11,'ACTIVE','OWNER',now(), now(),NULL);
INSERT INTO `hobby_member` (`member_id`,`hobby_id`,`state`,`privilege`,`reg_dt`,`chg_dt`,`resd_dt`) VALUES (2,12,'ACTIVE','OWNER',now(), now(),NULL);
INSERT INTO `hobby_member` (`member_id`,`hobby_id`,`state`,`privilege`,`reg_dt`,`chg_dt`,`resd_dt`) VALUES (3,13,'ACTIVE','OWNER',now(), now(),NULL);
INSERT INTO `hobby_member` (`member_id`,`hobby_id`,`state`,`privilege`,`reg_dt`,`chg_dt`,`resd_dt`) VALUES (4,14,'ACTIVE','OWNER',now(), now(),NULL);
INSERT INTO `hobby_member` (`member_id`,`hobby_id`,`state`,`privilege`,`reg_dt`,`chg_dt`,`resd_dt`) VALUES (5,15,'ACTIVE','OWNER',now(), now(),NULL);
INSERT INTO `hobby_member` (`member_id`,`hobby_id`,`state`,`privilege`,`reg_dt`,`chg_dt`,`resd_dt`) VALUES (6,16,'ACTIVE','OWNER',now(), now(),NULL);
INSERT INTO `hobby_member` (`member_id`,`hobby_id`,`state`,`privilege`,`reg_dt`,`chg_dt`,`resd_dt`) VALUES (7,17,'ACTIVE','OWNER',now(), now(),NULL);
INSERT INTO `hobby_member` (`member_id`,`hobby_id`,`state`,`privilege`,`reg_dt`,`chg_dt`,`resd_dt`) VALUES (8,18,'ACTIVE','OWNER',now(), now(),NULL);
INSERT INTO `hobby_member` (`member_id`,`hobby_id`,`state`,`privilege`,`reg_dt`,`chg_dt`,`resd_dt`) VALUES (9,19,'ACTIVE','OWNER',now(), now(),NULL);
INSERT INTO `hobby_member` (`member_id`,`hobby_id`,`state`,`privilege`,`reg_dt`,`chg_dt`,`resd_dt`) VALUES (10,20,'ACTIVE','OWNER',now(),now(),NULL);
INSERT INTO `hobby_member` (`member_id`,`hobby_id`,`state`,`privilege`,`reg_dt`,`chg_dt`,`resd_dt`) VALUES (1,21,'ACTIVE','OWNER',now(), now(),NULL);
INSERT INTO `hobby_member` (`member_id`,`hobby_id`,`state`,`privilege`,`reg_dt`,`chg_dt`,`resd_dt`) VALUES (2,22,'ACTIVE','OWNER',now(), now(),NULL);
INSERT INTO `hobby_member` (`member_id`,`hobby_id`,`state`,`privilege`,`reg_dt`,`chg_dt`,`resd_dt`) VALUES (3,23,'ACTIVE','OWNER',now(), now(),NULL);
INSERT INTO `hobby_member` (`member_id`,`hobby_id`,`state`,`privilege`,`reg_dt`,`chg_dt`,`resd_dt`) VALUES (4,24,'ACTIVE','OWNER',now(), now(),NULL);
INSERT INTO `hobby_member` (`member_id`,`hobby_id`,`state`,`privilege`,`reg_dt`,`chg_dt`,`resd_dt`) VALUES (5,25,'ACTIVE','OWNER',now(), now(),NULL);
INSERT INTO `hobby_member` (`member_id`,`hobby_id`,`state`,`privilege`,`reg_dt`,`chg_dt`,`resd_dt`) VALUES (6,26,'ACTIVE','OWNER',now(), now(),NULL);
INSERT INTO `hobby_member` (`member_id`,`hobby_id`,`state`,`privilege`,`reg_dt`,`chg_dt`,`resd_dt`) VALUES (7,27,'ACTIVE','OWNER',now(), now(),NULL);
INSERT INTO `hobby_member` (`member_id`,`hobby_id`,`state`,`privilege`,`reg_dt`,`chg_dt`,`resd_dt`) VALUES (8,28,'ACTIVE','OWNER',now(), now(),NULL);
INSERT INTO `hobby_member` (`member_id`,`hobby_id`,`state`,`privilege`,`reg_dt`,`chg_dt`,`resd_dt`) VALUES (9,29,'ACTIVE','OWNER',now(), now(),NULL);

-- 1번 hobby(john, 나 여행가고 싶어)
-- 관리자 회원
INSERT INTO `hobby_member` (`member_id`,`hobby_id`,`state`,`privilege`,`reg_dt`,`chg_dt`,`resd_dt`) VALUES (2,1,'ACTIVE','MANAGER',now(), now(),NULL);
INSERT INTO `hobby_member` (`member_id`,`hobby_id`,`state`,`privilege`,`reg_dt`,`chg_dt`,`resd_dt`) VALUES (3,1,'ACTIVE','MANAGER',now(), now(),NULL);
INSERT INTO `hobby_member` (`member_id`,`hobby_id`,`state`,`privilege`,`reg_dt`,`chg_dt`,`resd_dt`) VALUES (4,1,'ACTIVE','MANAGER',now(), now(),NULL);
-- 일반 회원
INSERT INTO `hobby_member` (`member_id`,`hobby_id`,`state`,`privilege`,`reg_dt`,`chg_dt`,`resd_dt`) VALUES (5,1,'ACTIVE','GENERAL',now(), now(),NULL);
INSERT INTO `hobby_member` (`member_id`,`hobby_id`,`state`,`privilege`,`reg_dt`,`chg_dt`,`resd_dt`) VALUES (6,1,'ACTIVE','GENERAL',now(), now(),NULL);
INSERT INTO `hobby_member` (`member_id`,`hobby_id`,`state`,`privilege`,`reg_dt`,`chg_dt`,`resd_dt`) VALUES (7,1,'ACTIVE','GENERAL',now(), now(),NULL);
INSERT INTO `hobby_member` (`member_id`,`hobby_id`,`state`,`privilege`,`reg_dt`,`chg_dt`,`resd_dt`) VALUES (8,1,'ACTIVE','GENERAL',now(), now(),NULL);
INSERT INTO `hobby_member` (`member_id`,`hobby_id`,`state`,`privilege`,`reg_dt`,`chg_dt`,`resd_dt`) VALUES (9,1,'ACTIVE','GENERAL',now(), now(),NULL);
INSERT INTO `hobby_member` (`member_id`,`hobby_id`,`state`,`privilege`,`reg_dt`,`chg_dt`,`resd_dt`) VALUES (10,1,'ACTIVE','GENERAL',now(), now(),NULL);
INSERT INTO `hobby_member` (`member_id`,`hobby_id`,`state`,`privilege`,`reg_dt`,`chg_dt`,`resd_dt`) VALUES (11,1,'ACTIVE','GENERAL',now(), now(),NULL);
INSERT INTO `hobby_member` (`member_id`,`hobby_id`,`state`,`privilege`,`reg_dt`,`chg_dt`,`resd_dt`) VALUES (12,1,'ACTIVE','GENERAL',now(), now(),NULL);
INSERT INTO `hobby_member` (`member_id`,`hobby_id`,`state`,`privilege`,`reg_dt`,`chg_dt`,`resd_dt`) VALUES (13,1,'ACTIVE','GENERAL',now(), now(),NULL);

-- 2번 hobby 삽입
-- 관리자 회원
INSERT INTO `hobby_member` (`member_id`,`hobby_id`,`state`,`privilege`,`reg_dt`,`chg_dt`,`resd_dt`) VALUES (10,2,'ACTIVE','MANAGER',now(), now(),NULL);
INSERT INTO `hobby_member` (`member_id`,`hobby_id`,`state`,`privilege`,`reg_dt`,`chg_dt`,`resd_dt`) VALUES (11,2,'ACTIVE','MANAGER',now(), now(),NULL);
INSERT INTO `hobby_member` (`member_id`,`hobby_id`,`state`,`privilege`,`reg_dt`,`chg_dt`,`resd_dt`) VALUES (12,2,'ACTIVE','MANAGER',now(), now(),NULL);
-- 일반 회원
INSERT INTO `hobby_member` (`member_id`,`hobby_id`,`state`,`privilege`,`reg_dt`,`chg_dt`,`resd_dt`) VALUES (13,2,'ACTIVE','GENERAL',now(), now(),NULL);
INSERT INTO `hobby_member` (`member_id`,`hobby_id`,`state`,`privilege`,`reg_dt`,`chg_dt`,`resd_dt`) VALUES (14,2,'ACTIVE','GENERAL',now(), now(),NULL);
INSERT INTO `hobby_member` (`member_id`,`hobby_id`,`state`,`privilege`,`reg_dt`,`chg_dt`,`resd_dt`) VALUES (15,2,'ACTIVE','GENERAL',now(), now(),NULL);
INSERT INTO `hobby_member` (`member_id`,`hobby_id`,`state`,`privilege`,`reg_dt`,`chg_dt`,`resd_dt`) VALUES (16,2,'ACTIVE','GENERAL',now(), now(),NULL);
INSERT INTO `hobby_member` (`member_id`,`hobby_id`,`state`,`privilege`,`reg_dt`,`chg_dt`,`resd_dt`) VALUES (17,2,'ACTIVE','GENERAL',now(), now(),NULL);
INSERT INTO `hobby_member` (`member_id`,`hobby_id`,`state`,`privilege`,`reg_dt`,`chg_dt`,`resd_dt`) VALUES (18,2,'ACTIVE','GENERAL',now(), now(),NULL);
INSERT INTO `hobby_member` (`member_id`,`hobby_id`,`state`,`privilege`,`reg_dt`,`chg_dt`,`resd_dt`) VALUES (19,2,'ACTIVE','GENERAL',now(), now(),NULL);
INSERT INTO `hobby_member` (`member_id`,`hobby_id`,`state`,`privilege`,`reg_dt`,`chg_dt`,`resd_dt`) VALUES (20,2,'ACTIVE','GENERAL',now(), now(),NULL);

-- 3번 hobby 삽입
-- 관리자 회원
INSERT INTO `hobby_member` (`member_id`,`hobby_id`,`state`,`privilege`,`reg_dt`,`chg_dt`,`resd_dt`) VALUES (4,3,'ACTIVE','MANAGER',now(), now(),NULL);
INSERT INTO `hobby_member` (`member_id`,`hobby_id`,`state`,`privilege`,`reg_dt`,`chg_dt`,`resd_dt`) VALUES (5,3,'ACTIVE','MANAGER',now(), now(),NULL);
INSERT INTO `hobby_member` (`member_id`,`hobby_id`,`state`,`privilege`,`reg_dt`,`chg_dt`,`resd_dt`) VALUES (6,3,'ACTIVE','MANAGER',now(), now(),NULL);
-- 일반 회원
INSERT INTO `hobby_member` (`member_id`,`hobby_id`,`state`,`privilege`,`reg_dt`,`chg_dt`,`resd_dt`) VALUES (7,3,'ACTIVE','GENERAL',now(), now(),NULL);
INSERT INTO `hobby_member` (`member_id`,`hobby_id`,`state`,`privilege`,`reg_dt`,`chg_dt`,`resd_dt`) VALUES (8,3,'ACTIVE','GENERAL',now(), now(),NULL);
INSERT INTO `hobby_member` (`member_id`,`hobby_id`,`state`,`privilege`,`reg_dt`,`chg_dt`,`resd_dt`) VALUES (9,3,'ACTIVE','GENERAL',now(), now(),NULL);
INSERT INTO `hobby_member` (`member_id`,`hobby_id`,`state`,`privilege`,`reg_dt`,`chg_dt`,`resd_dt`) VALUES (10,3,'ACTIVE','GENERAL',now(), now(),NULL);
INSERT INTO `hobby_member` (`member_id`,`hobby_id`,`state`,`privilege`,`reg_dt`,`chg_dt`,`resd_dt`) VALUES (11,3,'ACTIVE','GENERAL',now(), now(),NULL);
INSERT INTO `hobby_member` (`member_id`,`hobby_id`,`state`,`privilege`,`reg_dt`,`chg_dt`,`resd_dt`) VALUES (12,3,'ACTIVE','GENERAL',now(), now(),NULL);
INSERT INTO `hobby_member` (`member_id`,`hobby_id`,`state`,`privilege`,`reg_dt`,`chg_dt`,`resd_dt`) VALUES (13,3,'ACTIVE','GENERAL',now(), now(),NULL);
INSERT INTO `hobby_member` (`member_id`,`hobby_id`,`state`,`privilege`,`reg_dt`,`chg_dt`,`resd_dt`) VALUES (14,3,'ACTIVE','GENERAL',now(), now(),NULL);
INSERT INTO `hobby_member` (`member_id`,`hobby_id`,`state`,`privilege`,`reg_dt`,`chg_dt`,`resd_dt`) VALUES (15,3,'ACTIVE','GENERAL',now(), now(),NULL);
INSERT INTO `hobby_member` (`member_id`,`hobby_id`,`state`,`privilege`,`reg_dt`,`chg_dt`,`resd_dt`) VALUES (16,3,'ACTIVE','GENERAL',now(), now(),NULL);

-- 4번 회원
-- 관리자 회원
INSERT INTO `hobby_member` (`member_id`,`hobby_id`,`state`,`privilege`,`reg_dt`,`chg_dt`,`resd_dt`) VALUES (5,4,'ACTIVE','MANAGER',now(), now(),NULL);
INSERT INTO `hobby_member` (`member_id`,`hobby_id`,`state`,`privilege`,`reg_dt`,`chg_dt`,`resd_dt`) VALUES (6,4,'ACTIVE','MANAGER',now(), now(),NULL);
INSERT INTO `hobby_member` (`member_id`,`hobby_id`,`state`,`privilege`,`reg_dt`,`chg_dt`,`resd_dt`) VALUES (7,4,'ACTIVE','MANAGER',now(), now(),NULL);
INSERT INTO `hobby_member` (`member_id`,`hobby_id`,`state`,`privilege`,`reg_dt`,`chg_dt`,`resd_dt`) VALUES (8,4,'ACTIVE','MANAGER',now(), now(),NULL);

-- 일반 회원
INSERT INTO `hobby_member` (`member_id`,`hobby_id`,`state`,`privilege`,`reg_dt`,`chg_dt`,`resd_dt`) VALUES (9,4,'ACTIVE','GENERAL',now(), now(),NULL);
INSERT INTO `hobby_member` (`member_id`,`hobby_id`,`state`,`privilege`,`reg_dt`,`chg_dt`,`resd_dt`) VALUES (10,4,'ACTIVE','GENERAL',now(), now(),NULL);
INSERT INTO `hobby_member` (`member_id`,`hobby_id`,`state`,`privilege`,`reg_dt`,`chg_dt`,`resd_dt`) VALUES (11,4,'ACTIVE','GENERAL',now(), now(),NULL);
INSERT INTO `hobby_member` (`member_id`,`hobby_id`,`state`,`privilege`,`reg_dt`,`chg_dt`,`resd_dt`) VALUES (12,4,'ACTIVE','GENERAL',now(), now(),NULL);
INSERT INTO `hobby_member` (`member_id`,`hobby_id`,`state`,`privilege`,`reg_dt`,`chg_dt`,`resd_dt`) VALUES (13,4,'ACTIVE','GENERAL',now(), now(),NULL);
INSERT INTO `hobby_member` (`member_id`,`hobby_id`,`state`,`privilege`,`reg_dt`,`chg_dt`,`resd_dt`) VALUES (14,4,'ACTIVE','GENERAL',now(), now(),NULL);
INSERT INTO `hobby_member` (`member_id`,`hobby_id`,`state`,`privilege`,`reg_dt`,`chg_dt`,`resd_dt`) VALUES (15,4,'ACTIVE','GENERAL',now(), now(),NULL);
INSERT INTO `hobby_member` (`member_id`,`hobby_id`,`state`,`privilege`,`reg_dt`,`chg_dt`,`resd_dt`) VALUES (16,4,'ACTIVE','GENERAL',now(), now(),NULL);

-- 5번 회원
-- 관리자 회원
INSERT INTO `hobby_member` (`member_id`,`hobby_id`,`state`,`privilege`,`reg_dt`,`chg_dt`,`resd_dt`) VALUES (6,5,'ACTIVE','MANAGER',now(), now(),NULL);
INSERT INTO `hobby_member` (`member_id`,`hobby_id`,`state`,`privilege`,`reg_dt`,`chg_dt`,`resd_dt`) VALUES (7,5,'ACTIVE','MANAGER',now(), now(),NULL);
-- 일반 회원
INSERT INTO `hobby_member` (`member_id`,`hobby_id`,`state`,`privilege`,`reg_dt`,`chg_dt`,`resd_dt`) VALUES (8,5,'ACTIVE','GENERAL',now(), now(),NULL);
INSERT INTO `hobby_member` (`member_id`,`hobby_id`,`state`,`privilege`,`reg_dt`,`chg_dt`,`resd_dt`) VALUES (9,5,'ACTIVE','GENERAL',now(), now(),NULL);
INSERT INTO `hobby_member` (`member_id`,`hobby_id`,`state`,`privilege`,`reg_dt`,`chg_dt`,`resd_dt`) VALUES (10,5,'ACTIVE','GENERAL',now(), now(),NULL);
INSERT INTO `hobby_member` (`member_id`,`hobby_id`,`state`,`privilege`,`reg_dt`,`chg_dt`,`resd_dt`) VALUES (11,5,'ACTIVE','GENERAL',now(), now(),NULL);
INSERT INTO `hobby_member` (`member_id`,`hobby_id`,`state`,`privilege`,`reg_dt`,`chg_dt`,`resd_dt`) VALUES (12,5,'ACTIVE','GENERAL',now(), now(),NULL);
INSERT INTO `hobby_member` (`member_id`,`hobby_id`,`state`,`privilege`,`reg_dt`,`chg_dt`,`resd_dt`) VALUES (13,5,'ACTIVE','GENERAL',now(), now(),NULL);
INSERT INTO `hobby_member` (`member_id`,`hobby_id`,`state`,`privilege`,`reg_dt`,`chg_dt`,`resd_dt`) VALUES (14,5,'ACTIVE','GENERAL',now(), now(),NULL);
INSERT INTO `hobby_member` (`member_id`,`hobby_id`,`state`,`privilege`,`reg_dt`,`chg_dt`,`resd_dt`) VALUES (15,5,'ACTIVE','GENERAL',now(), now(),NULL);
INSERT INTO `hobby_member` (`member_id`,`hobby_id`,`state`,`privilege`,`reg_dt`,`chg_dt`,`resd_dt`) VALUES (16,5,'ACTIVE','GENERAL',now(), now(),NULL);
INSERT INTO `hobby_member` (`member_id`,`hobby_id`,`state`,`privilege`,`reg_dt`,`chg_dt`,`resd_dt`) VALUES (17,5,'ACTIVE','GENERAL',now(), now(),NULL);

-- 6번 회원
-- 관리자 회원
INSERT INTO `hobby_member` (`member_id`,`hobby_id`,`state`,`privilege`,`reg_dt`,`chg_dt`,`resd_dt`) VALUES (7,6,'ACTIVE','MANAGER',now(), now(),NULL);
INSERT INTO `hobby_member` (`member_id`,`hobby_id`,`state`,`privilege`,`reg_dt`,`chg_dt`,`resd_dt`) VALUES (8,6,'ACTIVE','MANAGER',now(), now(),NULL);
-- 일반 회원
INSERT INTO `hobby_member` (`member_id`,`hobby_id`,`state`,`privilege`,`reg_dt`,`chg_dt`,`resd_dt`) VALUES (8,6,'ACTIVE','GENERAL',now(), now(),NULL);
INSERT INTO `hobby_member` (`member_id`,`hobby_id`,`state`,`privilege`,`reg_dt`,`chg_dt`,`resd_dt`) VALUES (9,6,'ACTIVE','GENERAL',now(), now(),NULL);
INSERT INTO `hobby_member` (`member_id`,`hobby_id`,`state`,`privilege`,`reg_dt`,`chg_dt`,`resd_dt`) VALUES (10,6,'ACTIVE','GENERAL',now(), now(),NULL);
INSERT INTO `hobby_member` (`member_id`,`hobby_id`,`state`,`privilege`,`reg_dt`,`chg_dt`,`resd_dt`) VALUES (11,6,'ACTIVE','GENERAL',now(), now(),NULL);
INSERT INTO `hobby_member` (`member_id`,`hobby_id`,`state`,`privilege`,`reg_dt`,`chg_dt`,`resd_dt`) VALUES (12,6,'ACTIVE','GENERAL',now(), now(),NULL);
INSERT INTO `hobby_member` (`member_id`,`hobby_id`,`state`,`privilege`,`reg_dt`,`chg_dt`,`resd_dt`) VALUES (13,6,'ACTIVE','GENERAL',now(), now(),NULL);
INSERT INTO `hobby_member` (`member_id`,`hobby_id`,`state`,`privilege`,`reg_dt`,`chg_dt`,`resd_dt`) VALUES (14,6,'ACTIVE','GENERAL',now(), now(),NULL);
INSERT INTO `hobby_member` (`member_id`,`hobby_id`,`state`,`privilege`,`reg_dt`,`chg_dt`,`resd_dt`) VALUES (15,6,'ACTIVE','GENERAL',now(), now(),NULL);
INSERT INTO `hobby_member` (`member_id`,`hobby_id`,`state`,`privilege`,`reg_dt`,`chg_dt`,`resd_dt`) VALUES (16,6,'ACTIVE','GENERAL',now(), now(),NULL);
INSERT INTO `hobby_member` (`member_id`,`hobby_id`,`state`,`privilege`,`reg_dt`,`chg_dt`,`resd_dt`) VALUES (17,6,'ACTIVE','GENERAL',now(), now(),NULL);

-- 7번 회원
-- 관리자 회원
INSERT INTO `hobby_member` (`member_id`,`hobby_id`,`state`,`privilege`,`reg_dt`,`chg_dt`,`resd_dt`) VALUES (8,7,'ACTIVE','MANAGER',now(), now(),NULL);
-- 일반 회원
INSERT INTO `hobby_member` (`member_id`,`hobby_id`,`state`,`privilege`,`reg_dt`,`chg_dt`,`resd_dt`) VALUES (9,7,'ACTIVE','GENERAL',now(), now(),NULL);
INSERT INTO `hobby_member` (`member_id`,`hobby_id`,`state`,`privilege`,`reg_dt`,`chg_dt`,`resd_dt`) VALUES (10,7,'ACTIVE','GENERAL',now(), now(),NULL);

-- 8번 회원
-- 관리자 회원
INSERT INTO `hobby_member` (`member_id`,`hobby_id`,`state`,`privilege`,`reg_dt`,`chg_dt`,`resd_dt`) VALUES (9, 8,'ACTIVE','MANAGER',now(), now(),NULL);
INSERT INTO `hobby_member` (`member_id`,`hobby_id`,`state`,`privilege`,`reg_dt`,`chg_dt`,`resd_dt`) VALUES (10, 8,'ACTIVE','MANAGER',now(), now(),NULL);
-- 일반 회원
INSERT INTO `hobby_member` (`member_id`,`hobby_id`,`state`,`privilege`,`reg_dt`,`chg_dt`,`resd_dt`) VALUES (11,8,'ACTIVE','GENERAL',now(), now(),NULL);

-- 9번 회원
-- 관리자 회원
INSERT INTO `hobby_member` (`member_id`,`hobby_id`,`state`,`privilege`,`reg_dt`,`chg_dt`,`resd_dt`) VALUES (10, 9,'ACTIVE','MANAGER',now(), now(),NULL);
INSERT INTO `hobby_member` (`member_id`,`hobby_id`,`state`,`privilege`,`reg_dt`,`chg_dt`,`resd_dt`) VALUES (11, 9,'ACTIVE','MANAGER',now(), now(),NULL);
-- 일반 회원
INSERT INTO `hobby_member` (`member_id`,`hobby_id`,`state`,`privilege`,`reg_dt`,`chg_dt`,`resd_dt`) VALUES (12,9,'ACTIVE','GENERAL',now(), now(),NULL);
INSERT INTO `hobby_member` (`member_id`,`hobby_id`,`state`,`privilege`,`reg_dt`,`chg_dt`,`resd_dt`) VALUES (13,9,'ACTIVE','GENERAL',now(), now(),NULL);
INSERT INTO `hobby_member` (`member_id`,`hobby_id`,`state`,`privilege`,`reg_dt`,`chg_dt`,`resd_dt`) VALUES (14,9,'ACTIVE','GENERAL',now(), now(),NULL);

-- 10번 회원
-- 관리자 회원
INSERT INTO `hobby_member` (`member_id`,`hobby_id`,`state`,`privilege`,`reg_dt`,`chg_dt`,`resd_dt`) VALUES (11, 10,'ACTIVE','MANAGER',now(), now(),NULL);
INSERT INTO `hobby_member` (`member_id`,`hobby_id`,`state`,`privilege`,`reg_dt`,`chg_dt`,`resd_dt`) VALUES (12, 10,'ACTIVE','MANAGER',now(), now(),NULL);
INSERT INTO `hobby_member` (`member_id`,`hobby_id`,`state`,`privilege`,`reg_dt`,`chg_dt`,`resd_dt`) VALUES (13, 10,'ACTIVE','MANAGER',now(), now(),NULL);
-- 일반 회원
INSERT INTO `hobby_member` (`member_id`,`hobby_id`,`state`,`privilege`,`reg_dt`,`chg_dt`,`resd_dt`) VALUES (14,10,'ACTIVE','GENERAL',now(), now(),NULL);
INSERT INTO `hobby_member` (`member_id`,`hobby_id`,`state`,`privilege`,`reg_dt`,`chg_dt`,`resd_dt`) VALUES (15,10,'ACTIVE','GENERAL',now(), now(),NULL);
INSERT INTO `hobby_member` (`member_id`,`hobby_id`,`state`,`privilege`,`reg_dt`,`chg_dt`,`resd_dt`) VALUES (16,10,'ACTIVE','GENERAL',now(), now(),NULL);
INSERT INTO `hobby_member` (`member_id`,`hobby_id`,`state`,`privilege`,`reg_dt`,`chg_dt`,`resd_dt`) VALUES (17,10,'ACTIVE','GENERAL',now(), now(),NULL);
INSERT INTO `hobby_member` (`member_id`,`hobby_id`,`state`,`privilege`,`reg_dt`,`chg_dt`,`resd_dt`) VALUES (18,10,'ACTIVE','GENERAL',now(), now(),NULL);
INSERT INTO `hobby_member` (`member_id`,`hobby_id`,`state`,`privilege`,`reg_dt`,`chg_dt`,`resd_dt`) VALUES (19,10,'ACTIVE','GENERAL',now(), now(),NULL);
INSERT INTO `hobby_member` (`member_id`,`hobby_id`,`state`,`privilege`,`reg_dt`,`chg_dt`,`resd_dt`) VALUES (20,10,'ACTIVE','GENERAL',now(), now(),NULL);
-- INSERT INTO `hobby_member` (`member_id`,`hobby_id`,`state`,`privilege`,`reg_dt`,`chg_dt`,`resd_dt`) VALUES (21,10,'ACTIVE','GENERAL',now(), now(),NULL);

-- 11번 회원
-- 관리자 회원
INSERT INTO `hobby_member` (`member_id`,`hobby_id`,`state`,`privilege`,`reg_dt`,`chg_dt`,`resd_dt`) VALUES (12, 11,'ACTIVE','MANAGER',now(), now(),NULL);
-- 일반 회원
INSERT INTO `hobby_member` (`member_id`,`hobby_id`,`state`,`privilege`,`reg_dt`,`chg_dt`,`resd_dt`) VALUES (13, 11,'ACTIVE','GENERAL',now(), now(),NULL);
INSERT INTO `hobby_member` (`member_id`,`hobby_id`,`state`,`privilege`,`reg_dt`,`chg_dt`,`resd_dt`) VALUES (14,11,'ACTIVE','GENERAL',now(), now(),NULL);
INSERT INTO `hobby_member` (`member_id`,`hobby_id`,`state`,`privilege`,`reg_dt`,`chg_dt`,`resd_dt`) VALUES (15,11,'ACTIVE','GENERAL',now(), now(),NULL);
INSERT INTO `hobby_member` (`member_id`,`hobby_id`,`state`,`privilege`,`reg_dt`,`chg_dt`,`resd_dt`) VALUES (16,11,'ACTIVE','GENERAL',now(), now(),NULL);
INSERT INTO `hobby_member` (`member_id`,`hobby_id`,`state`,`privilege`,`reg_dt`,`chg_dt`,`resd_dt`) VALUES (17,11,'ACTIVE','GENERAL',now(), now(),NULL);
INSERT INTO `hobby_member` (`member_id`,`hobby_id`,`state`,`privilege`,`reg_dt`,`chg_dt`,`resd_dt`) VALUES (18,11,'ACTIVE','GENERAL',now(), now(),NULL);
INSERT INTO `hobby_member` (`member_id`,`hobby_id`,`state`,`privilege`,`reg_dt`,`chg_dt`,`resd_dt`) VALUES (19,11,'ACTIVE','GENERAL',now(), now(),NULL);


-- 12번 회원
-- 관리자 회원
INSERT INTO `hobby_member` (`member_id`,`hobby_id`,`state`,`privilege`,`reg_dt`,`chg_dt`,`resd_dt`) VALUES (13, 12,'ACTIVE','MANAGER',now(), now(),NULL);
INSERT INTO `hobby_member` (`member_id`,`hobby_id`,`state`,`privilege`,`reg_dt`,`chg_dt`,`resd_dt`) VALUES (14, 12,'ACTIVE','MANAGER',now(), now(),NULL);
INSERT INTO `hobby_member` (`member_id`,`hobby_id`,`state`,`privilege`,`reg_dt`,`chg_dt`,`resd_dt`) VALUES (15, 12,'ACTIVE','MANAGER',now(), now(),NULL);
-- 일반 회원
INSERT INTO `hobby_member` (`member_id`,`hobby_id`,`state`,`privilege`,`reg_dt`,`chg_dt`,`resd_dt`) VALUES (16, 12,'ACTIVE','GENERAL',now(), now(),NULL);
INSERT INTO `hobby_member` (`member_id`,`hobby_id`,`state`,`privilege`,`reg_dt`,`chg_dt`,`resd_dt`) VALUES (17, 12,'ACTIVE','GENERAL',now(), now(),NULL);
INSERT INTO `hobby_member` (`member_id`,`hobby_id`,`state`,`privilege`,`reg_dt`,`chg_dt`,`resd_dt`) VALUES (18, 12,'ACTIVE','GENERAL',now(), now(),NULL);
INSERT INTO `hobby_member` (`member_id`,`hobby_id`,`state`,`privilege`,`reg_dt`,`chg_dt`,`resd_dt`) VALUES (19, 12,'ACTIVE','GENERAL',now(), now(),NULL);
INSERT INTO `hobby_member` (`member_id`,`hobby_id`,`state`,`privilege`,`reg_dt`,`chg_dt`,`resd_dt`) VALUES (20, 12,'ACTIVE','GENERAL',now(), now(),NULL);

-- 13번 회원
-- 관리자 회원
INSERT INTO `hobby_member` (`member_id`,`hobby_id`,`state`,`privilege`,`reg_dt`,`chg_dt`,`resd_dt`) VALUES (14, 13,'ACTIVE','MANAGER',now(), now(),NULL);
INSERT INTO `hobby_member` (`member_id`,`hobby_id`,`state`,`privilege`,`reg_dt`,`chg_dt`,`resd_dt`) VALUES (15, 13,'ACTIVE','MANAGER',now(), now(),NULL);
-- 일반 회원
INSERT INTO `hobby_member` (`member_id`,`hobby_id`,`state`,`privilege`,`reg_dt`,`chg_dt`,`resd_dt`) VALUES (16, 13,'ACTIVE','GENERAL',now(), now(),NULL);
INSERT INTO `hobby_member` (`member_id`,`hobby_id`,`state`,`privilege`,`reg_dt`,`chg_dt`,`resd_dt`) VALUES (17, 13,'ACTIVE','GENERAL',now(), now(),NULL);
INSERT INTO `hobby_member` (`member_id`,`hobby_id`,`state`,`privilege`,`reg_dt`,`chg_dt`,`resd_dt`) VALUES (18, 13,'ACTIVE','GENERAL',now(), now(),NULL);
INSERT INTO `hobby_member` (`member_id`,`hobby_id`,`state`,`privilege`,`reg_dt`,`chg_dt`,`resd_dt`) VALUES (19, 13,'ACTIVE','GENERAL',now(), now(),NULL);
INSERT INTO `hobby_member` (`member_id`,`hobby_id`,`state`,`privilege`,`reg_dt`,`chg_dt`,`resd_dt`) VALUES (20, 13,'ACTIVE','GENERAL',now(), now(),NULL);

-- 14번 회원
-- 관리자 회원
INSERT INTO `hobby_member` (`member_id`,`hobby_id`,`state`,`privilege`,`reg_dt`,`chg_dt`,`resd_dt`) VALUES (15, 14,'ACTIVE','MANAGER',now(), now(),NULL);
INSERT INTO `hobby_member` (`member_id`,`hobby_id`,`state`,`privilege`,`reg_dt`,`chg_dt`,`resd_dt`) VALUES (16, 14,'ACTIVE','MANAGER',now(), now(),NULL);
INSERT INTO `hobby_member` (`member_id`,`hobby_id`,`state`,`privilege`,`reg_dt`,`chg_dt`,`resd_dt`) VALUES (17, 14,'ACTIVE','MANAGER',now(), now(),NULL);

-- 일반 회원
INSERT INTO `hobby_member` (`member_id`,`hobby_id`,`state`,`privilege`,`reg_dt`,`chg_dt`,`resd_dt`) VALUES (1, 14,'ACTIVE','GENERAL',now(), now(),NULL);
INSERT INTO `hobby_member` (`member_id`,`hobby_id`,`state`,`privilege`,`reg_dt`,`chg_dt`,`resd_dt`) VALUES (2, 14,'ACTIVE','GENERAL',now(), now(),NULL);
INSERT INTO `hobby_member` (`member_id`,`hobby_id`,`state`,`privilege`,`reg_dt`,`chg_dt`,`resd_dt`) VALUES (18, 14,'ACTIVE','GENERAL',now(), now(),NULL);
INSERT INTO `hobby_member` (`member_id`,`hobby_id`,`state`,`privilege`,`reg_dt`,`chg_dt`,`resd_dt`) VALUES (19, 14,'ACTIVE','GENERAL',now(), now(),NULL);
INSERT INTO `hobby_member` (`member_id`,`hobby_id`,`state`,`privilege`,`reg_dt`,`chg_dt`,`resd_dt`) VALUES (20, 14,'ACTIVE','GENERAL',now(), now(),NULL);

-- 15번 회원
-- 관리자 회원
INSERT INTO `hobby_member` (`member_id`,`hobby_id`,`state`,`privilege`,`reg_dt`,`chg_dt`,`resd_dt`) VALUES (16, 15,'ACTIVE','MANAGER',now(), now(),NULL);
INSERT INTO `hobby_member` (`member_id`,`hobby_id`,`state`,`privilege`,`reg_dt`,`chg_dt`,`resd_dt`) VALUES (17, 15,'ACTIVE','MANAGER',now(), now(),NULL);
-- 일반 회원
INSERT INTO `hobby_member` (`member_id`,`hobby_id`,`state`,`privilege`,`reg_dt`,`chg_dt`,`resd_dt`) VALUES (18, 15,'ACTIVE','GENERAL',now(), now(),NULL);
INSERT INTO `hobby_member` (`member_id`,`hobby_id`,`state`,`privilege`,`reg_dt`,`chg_dt`,`resd_dt`) VALUES (19, 15,'ACTIVE','GENERAL',now(), now(),NULL);
INSERT INTO `hobby_member` (`member_id`,`hobby_id`,`state`,`privilege`,`reg_dt`,`chg_dt`,`resd_dt`) VALUES (20, 15,'ACTIVE','GENERAL',now(), now(),NULL);

-- 16번 회원
-- 관리자 회원
INSERT INTO `hobby_member` (`member_id`,`hobby_id`,`state`,`privilege`,`reg_dt`,`chg_dt`,`resd_dt`) VALUES (17, 16,'ACTIVE','MANAGER',now(), now(),NULL);
-- 일반 회원
INSERT INTO `hobby_member` (`member_id`,`hobby_id`,`state`,`privilege`,`reg_dt`,`chg_dt`,`resd_dt`) VALUES (18, 16,'ACTIVE','GENERAL',now(), now(),NULL);
INSERT INTO `hobby_member` (`member_id`,`hobby_id`,`state`,`privilege`,`reg_dt`,`chg_dt`,`resd_dt`) VALUES (19, 16,'ACTIVE','GENERAL',now(), now(),NULL);

-- 17번 회원
-- 관리자 회원
INSERT INTO `hobby_member` (`member_id`,`hobby_id`,`state`,`privilege`,`reg_dt`,`chg_dt`,`resd_dt`) VALUES (1, 17,'ACTIVE','MANAGER',now(), now(),NULL);
INSERT INTO `hobby_member` (`member_id`,`hobby_id`,`state`,`privilege`,`reg_dt`,`chg_dt`,`resd_dt`) VALUES (4, 17,'ACTIVE','MANAGER',now(), now(),NULL);
INSERT INTO `hobby_member` (`member_id`,`hobby_id`,`state`,`privilege`,`reg_dt`,`chg_dt`,`resd_dt`) VALUES (5, 17,'ACTIVE','MANAGER',now(), now(),NULL);
-- 일반 회원
INSERT INTO `hobby_member` (`member_id`,`hobby_id`,`state`,`privilege`,`reg_dt`,`chg_dt`,`resd_dt`) VALUES (8, 17,'ACTIVE','GENERAL',now(), now(),NULL);
INSERT INTO `hobby_member` (`member_id`,`hobby_id`,`state`,`privilege`,`reg_dt`,`chg_dt`,`resd_dt`) VALUES (11, 17,'ACTIVE','GENERAL',now(), now(),NULL);
INSERT INTO `hobby_member` (`member_id`,`hobby_id`,`state`,`privilege`,`reg_dt`,`chg_dt`,`resd_dt`) VALUES (12, 17,'ACTIVE','GENERAL',now(), now(),NULL);
INSERT INTO `hobby_member` (`member_id`,`hobby_id`,`state`,`privilege`,`reg_dt`,`chg_dt`,`resd_dt`) VALUES (13, 17,'ACTIVE','GENERAL',now(), now(),NULL);
INSERT INTO `hobby_member` (`member_id`,`hobby_id`,`state`,`privilege`,`reg_dt`,`chg_dt`,`resd_dt`) VALUES (14, 17,'ACTIVE','GENERAL',now(), now(),NULL);
INSERT INTO `hobby_member` (`member_id`,`hobby_id`,`state`,`privilege`,`reg_dt`,`chg_dt`,`resd_dt`) VALUES (15, 17,'ACTIVE','GENERAL',now(), now(),NULL);
INSERT INTO `hobby_member` (`member_id`,`hobby_id`,`state`,`privilege`,`reg_dt`,`chg_dt`,`resd_dt`) VALUES (16, 17,'ACTIVE','GENERAL',now(), now(),NULL);
INSERT INTO `hobby_member` (`member_id`,`hobby_id`,`state`,`privilege`,`reg_dt`,`chg_dt`,`resd_dt`) VALUES (17, 17,'ACTIVE','GENERAL',now(), now(),NULL);
INSERT INTO `hobby_member` (`member_id`,`hobby_id`,`state`,`privilege`,`reg_dt`,`chg_dt`,`resd_dt`) VALUES (19, 17,'ACTIVE','GENERAL',now(), now(),NULL);

-- 18번 회원
-- 관리자 회원
INSERT INTO `hobby_member` (`member_id`,`hobby_id`,`state`,`privilege`,`reg_dt`,`chg_dt`,`resd_dt`) VALUES (2, 18,'ACTIVE','MANAGER',now(), now(),NULL);
INSERT INTO `hobby_member` (`member_id`,`hobby_id`,`state`,`privilege`,`reg_dt`,`chg_dt`,`resd_dt`) VALUES (5, 18,'ACTIVE','MANAGER',now(), now(),NULL);
-- 일반 회원
INSERT INTO `hobby_member` (`member_id`,`hobby_id`,`state`,`privilege`,`reg_dt`,`chg_dt`,`resd_dt`) VALUES (9, 18,'ACTIVE','GENERAL',now(), now(),NULL);
INSERT INTO `hobby_member` (`member_id`,`hobby_id`,`state`,`privilege`,`reg_dt`,`chg_dt`,`resd_dt`) VALUES (10, 18,'ACTIVE','GENERAL',now(), now(),NULL);
INSERT INTO `hobby_member` (`member_id`,`hobby_id`,`state`,`privilege`,`reg_dt`,`chg_dt`,`resd_dt`) VALUES (11, 18,'ACTIVE','GENERAL',now(), now(),NULL);
INSERT INTO `hobby_member` (`member_id`,`hobby_id`,`state`,`privilege`,`reg_dt`,`chg_dt`,`resd_dt`) VALUES (12, 18,'ACTIVE','GENERAL',now(), now(),NULL);
INSERT INTO `hobby_member` (`member_id`,`hobby_id`,`state`,`privilege`,`reg_dt`,`chg_dt`,`resd_dt`) VALUES (14, 18,'ACTIVE','GENERAL',now(), now(),NULL);
INSERT INTO `hobby_member` (`member_id`,`hobby_id`,`state`,`privilege`,`reg_dt`,`chg_dt`,`resd_dt`) VALUES (16, 18,'ACTIVE','GENERAL',now(), now(),NULL);
INSERT INTO `hobby_member` (`member_id`,`hobby_id`,`state`,`privilege`,`reg_dt`,`chg_dt`,`resd_dt`) VALUES (18, 18,'ACTIVE','GENERAL',now(), now(),NULL);

-- 19번 회원
-- 관리자 회원
INSERT INTO `hobby_member` (`member_id`,`hobby_id`,`state`,`privilege`,`reg_dt`,`chg_dt`,`resd_dt`) VALUES (3, 19,'ACTIVE','MANAGER',now(), now(),NULL);
INSERT INTO `hobby_member` (`member_id`,`hobby_id`,`state`,`privilege`,`reg_dt`,`chg_dt`,`resd_dt`) VALUES (6, 19,'ACTIVE','MANAGER',now(), now(),NULL);
INSERT INTO `hobby_member` (`member_id`,`hobby_id`,`state`,`privilege`,`reg_dt`,`chg_dt`,`resd_dt`) VALUES (7, 19,'ACTIVE','MANAGER',now(), now(),NULL);
-- 일반 회원
INSERT INTO `hobby_member` (`member_id`,`hobby_id`,`state`,`privilege`,`reg_dt`,`chg_dt`,`resd_dt`) VALUES (10, 19,'ACTIVE','GENERAL',now(), now(),NULL);
INSERT INTO `hobby_member` (`member_id`,`hobby_id`,`state`,`privilege`,`reg_dt`,`chg_dt`,`resd_dt`) VALUES (11, 19,'ACTIVE','GENERAL',now(), now(),NULL);
INSERT INTO `hobby_member` (`member_id`,`hobby_id`,`state`,`privilege`,`reg_dt`,`chg_dt`,`resd_dt`) VALUES (13, 19,'ACTIVE','GENERAL',now(), now(),NULL);
INSERT INTO `hobby_member` (`member_id`,`hobby_id`,`state`,`privilege`,`reg_dt`,`chg_dt`,`resd_dt`) VALUES (16, 19,'ACTIVE','GENERAL',now(), now(),NULL);
INSERT INTO `hobby_member` (`member_id`,`hobby_id`,`state`,`privilege`,`reg_dt`,`chg_dt`,`resd_dt`) VALUES (18, 19,'ACTIVE','GENERAL',now(), now(),NULL);
INSERT INTO `hobby_member` (`member_id`,`hobby_id`,`state`,`privilege`,`reg_dt`,`chg_dt`,`resd_dt`) VALUES (20, 19,'ACTIVE','GENERAL',now(), now(),NULL);

-- 20번 회원
-- 관리자 회원
INSERT INTO `hobby_member` (`member_id`,`hobby_id`,`state`,`privilege`,`reg_dt`,`chg_dt`,`resd_dt`) VALUES (4, 20,'ACTIVE','MANAGER',now(), now(),NULL);
INSERT INTO `hobby_member` (`member_id`,`hobby_id`,`state`,`privilege`,`reg_dt`,`chg_dt`,`resd_dt`) VALUES (7, 20,'ACTIVE','MANAGER',now(), now(),NULL);
INSERT INTO `hobby_member` (`member_id`,`hobby_id`,`state`,`privilege`,`reg_dt`,`chg_dt`,`resd_dt`) VALUES (9, 20,'ACTIVE','MANAGER',now(), now(),NULL);
-- 일반 회원
INSERT INTO `hobby_member` (`member_id`,`hobby_id`,`state`,`privilege`,`reg_dt`,`chg_dt`,`resd_dt`) VALUES (11, 20,'ACTIVE','GENERAL',now(), now(),NULL);
INSERT INTO `hobby_member` (`member_id`,`hobby_id`,`state`,`privilege`,`reg_dt`,`chg_dt`,`resd_dt`) VALUES (12, 20,'ACTIVE','GENERAL',now(), now(),NULL);
INSERT INTO `hobby_member` (`member_id`,`hobby_id`,`state`,`privilege`,`reg_dt`,`chg_dt`,`resd_dt`) VALUES (13, 20,'ACTIVE','GENERAL',now(), now(),NULL);
INSERT INTO `hobby_member` (`member_id`,`hobby_id`,`state`,`privilege`,`reg_dt`,`chg_dt`,`resd_dt`) VALUES (14, 20,'ACTIVE','GENERAL',now(), now(),NULL);
INSERT INTO `hobby_member` (`member_id`,`hobby_id`,`state`,`privilege`,`reg_dt`,`chg_dt`,`resd_dt`) VALUES (15, 20,'ACTIVE','GENERAL',now(), now(),NULL);


-- 21번 회원
-- 관리자 회원
INSERT INTO `hobby_member` (`member_id`,`hobby_id`,`state`,`privilege`,`reg_dt`,`chg_dt`,`resd_dt`) VALUES (5, 21,'ACTIVE','MANAGER',now(), now(),NULL);
INSERT INTO `hobby_member` (`member_id`,`hobby_id`,`state`,`privilege`,`reg_dt`,`chg_dt`,`resd_dt`) VALUES (6, 21,'ACTIVE','MANAGER',now(), now(),NULL);
INSERT INTO `hobby_member` (`member_id`,`hobby_id`,`state`,`privilege`,`reg_dt`,`chg_dt`,`resd_dt`) VALUES (7, 21,'ACTIVE','MANAGER',now(), now(),NULL);
-- 일반 회원
INSERT INTO `hobby_member` (`member_id`,`hobby_id`,`state`,`privilege`,`reg_dt`,`chg_dt`,`resd_dt`) VALUES (12, 21,'ACTIVE','GENERAL',now(), now(),NULL);
INSERT INTO `hobby_member` (`member_id`,`hobby_id`,`state`,`privilege`,`reg_dt`,`chg_dt`,`resd_dt`) VALUES (14, 21,'ACTIVE','GENERAL',now(), now(),NULL);
INSERT INTO `hobby_member` (`member_id`,`hobby_id`,`state`,`privilege`,`reg_dt`,`chg_dt`,`resd_dt`) VALUES (15, 21,'ACTIVE','GENERAL',now(), now(),NULL);
INSERT INTO `hobby_member` (`member_id`,`hobby_id`,`state`,`privilege`,`reg_dt`,`chg_dt`,`resd_dt`) VALUES (17, 21,'ACTIVE','GENERAL',now(), now(),NULL);
INSERT INTO `hobby_member` (`member_id`,`hobby_id`,`state`,`privilege`,`reg_dt`,`chg_dt`,`resd_dt`) VALUES (18, 21,'ACTIVE','GENERAL',now(), now(),NULL);
INSERT INTO `hobby_member` (`member_id`,`hobby_id`,`state`,`privilege`,`reg_dt`,`chg_dt`,`resd_dt`) VALUES (19, 21,'ACTIVE','GENERAL',now(), now(),NULL);
INSERT INTO `hobby_member` (`member_id`,`hobby_id`,`state`,`privilege`,`reg_dt`,`chg_dt`,`resd_dt`) VALUES (3, 21,'ACTIVE','GENERAL',now(), now(),NULL);
INSERT INTO `hobby_member` (`member_id`,`hobby_id`,`state`,`privilege`,`reg_dt`,`chg_dt`,`resd_dt`) VALUES (8, 21,'ACTIVE','GENERAL',now(), now(),NULL);
INSERT INTO `hobby_member` (`member_id`,`hobby_id`,`state`,`privilege`,`reg_dt`,`chg_dt`,`resd_dt`) VALUES (10, 21,'ACTIVE','GENERAL',now(), now(),NULL);

-- 22번 회원
-- 관리자 회원
INSERT INTO `hobby_member` (`member_id`,`hobby_id`,`state`,`privilege`,`reg_dt`,`chg_dt`,`resd_dt`) VALUES (6, 22,'ACTIVE','MANAGER',now(), now(),NULL);
-- 일반 회원
INSERT INTO `hobby_member` (`member_id`,`hobby_id`,`state`,`privilege`,`reg_dt`,`chg_dt`,`resd_dt`) VALUES (9, 22,'ACTIVE','GENERAL',now(), now(),NULL);
INSERT INTO `hobby_member` (`member_id`,`hobby_id`,`state`,`privilege`,`reg_dt`,`chg_dt`,`resd_dt`) VALUES (10, 22,'ACTIVE','GENERAL',now(), now(),NULL);
INSERT INTO `hobby_member` (`member_id`,`hobby_id`,`state`,`privilege`,`reg_dt`,`chg_dt`,`resd_dt`) VALUES (11, 22,'ACTIVE','GENERAL',now(), now(),NULL);INSERT INTO `hobby_member` (`member_id`,`hobby_id`,`state`,`privilege`,`reg_dt`,`chg_dt`,`resd_dt`) VALUES (9, 22,'ACTIVE','GENERAL',now(), now(),NULL);
INSERT INTO `hobby_member` (`member_id`,`hobby_id`,`state`,`privilege`,`reg_dt`,`chg_dt`,`resd_dt`) VALUES (13, 22,'ACTIVE','GENERAL',now(), now(),NULL);
INSERT INTO `hobby_member` (`member_id`,`hobby_id`,`state`,`privilege`,`reg_dt`,`chg_dt`,`resd_dt`) VALUES (14, 22,'ACTIVE','GENERAL',now(), now(),NULL);
INSERT INTO `hobby_member` (`member_id`,`hobby_id`,`state`,`privilege`,`reg_dt`,`chg_dt`,`resd_dt`) VALUES (16, 22,'ACTIVE','GENERAL',now(), now(),NULL);
INSERT INTO `hobby_member` (`member_id`,`hobby_id`,`state`,`privilege`,`reg_dt`,`chg_dt`,`resd_dt`) VALUES (18, 22,'ACTIVE','GENERAL',now(), now(),NULL);

-- 23번 회원
-- 관리자 회원
INSERT INTO `hobby_member` (`member_id`,`hobby_id`,`state`,`privilege`,`reg_dt`,`chg_dt`,`resd_dt`) VALUES (7, 23,'ACTIVE','MANAGER',now(), now(),NULL);
INSERT INTO `hobby_member` (`member_id`,`hobby_id`,`state`,`privilege`,`reg_dt`,`chg_dt`,`resd_dt`) VALUES (8, 23,'ACTIVE','MANAGER',now(), now(),NULL);
-- 일반 회원
INSERT INTO `hobby_member` (`member_id`,`hobby_id`,`state`,`privilege`,`reg_dt`,`chg_dt`,`resd_dt`) VALUES (10, 23,'ACTIVE','GENERAL',now(), now(),NULL);
INSERT INTO `hobby_member` (`member_id`,`hobby_id`,`state`,`privilege`,`reg_dt`,`chg_dt`,`resd_dt`) VALUES (11, 23,'ACTIVE','GENERAL',now(), now(),NULL);
INSERT INTO `hobby_member` (`member_id`,`hobby_id`,`state`,`privilege`,`reg_dt`,`chg_dt`,`resd_dt`) VALUES (13, 23,'ACTIVE','GENERAL',now(), now(),NULL);
INSERT INTO `hobby_member` (`member_id`,`hobby_id`,`state`,`privilege`,`reg_dt`,`chg_dt`,`resd_dt`) VALUES (15, 23,'ACTIVE','GENERAL',now(), now(),NULL);
INSERT INTO `hobby_member` (`member_id`,`hobby_id`,`state`,`privilege`,`reg_dt`,`chg_dt`,`resd_dt`) VALUES (17, 23,'ACTIVE','GENERAL',now(), now(),NULL);
INSERT INTO `hobby_member` (`member_id`,`hobby_id`,`state`,`privilege`,`reg_dt`,`chg_dt`,`resd_dt`) VALUES (19, 23,'ACTIVE','GENERAL',now(), now(),NULL);

-- 24번 회원
-- 관리자 회원
INSERT INTO `hobby_member` (`member_id`,`hobby_id`,`state`,`privilege`,`reg_dt`,`chg_dt`,`resd_dt`) VALUES (1, 24,'ACTIVE','MANAGER',now(), now(),NULL);
INSERT INTO `hobby_member` (`member_id`,`hobby_id`,`state`,`privilege`,`reg_dt`,`chg_dt`,`resd_dt`) VALUES (8, 24,'ACTIVE','MANAGER',now(), now(),NULL);
INSERT INTO `hobby_member` (`member_id`,`hobby_id`,`state`,`privilege`,`reg_dt`,`chg_dt`,`resd_dt`) VALUES (9, 24,'ACTIVE','MANAGER',now(), now(),NULL);
-- 일반 회원
INSERT INTO `hobby_member` (`member_id`,`hobby_id`,`state`,`privilege`,`reg_dt`,`chg_dt`,`resd_dt`) VALUES (11, 24,'ACTIVE','GENERAL',now(), now(),NULL);
INSERT INTO `hobby_member` (`member_id`,`hobby_id`,`state`,`privilege`,`reg_dt`,`chg_dt`,`resd_dt`) VALUES (12, 24,'ACTIVE','GENERAL',now(), now(),NULL);
INSERT INTO `hobby_member` (`member_id`,`hobby_id`,`state`,`privilege`,`reg_dt`,`chg_dt`,`resd_dt`) VALUES (13, 24,'ACTIVE','GENERAL',now(), now(),NULL);
INSERT INTO `hobby_member` (`member_id`,`hobby_id`,`state`,`privilege`,`reg_dt`,`chg_dt`,`resd_dt`) VALUES (14, 24,'ACTIVE','GENERAL',now(), now(),NULL);
INSERT INTO `hobby_member` (`member_id`,`hobby_id`,`state`,`privilege`,`reg_dt`,`chg_dt`,`resd_dt`) VALUES (15, 24,'ACTIVE','GENERAL',now(), now(),NULL);
INSERT INTO `hobby_member` (`member_id`,`hobby_id`,`state`,`privilege`,`reg_dt`,`chg_dt`,`resd_dt`) VALUES (17, 24,'ACTIVE','GENERAL',now(), now(),NULL);
INSERT INTO `hobby_member` (`member_id`,`hobby_id`,`state`,`privilege`,`reg_dt`,`chg_dt`,`resd_dt`) VALUES (19, 24,'ACTIVE','GENERAL',now(), now(),NULL);

-- 25번 회원
-- 관리자 회원
INSERT INTO `hobby_member` (`member_id`,`hobby_id`,`state`,`privilege`,`reg_dt`,`chg_dt`,`resd_dt`) VALUES (1, 25,'ACTIVE','MANAGER',now(), now(),NULL);
INSERT INTO `hobby_member` (`member_id`,`hobby_id`,`state`,`privilege`,`reg_dt`,`chg_dt`,`resd_dt`) VALUES (3, 25,'ACTIVE','MANAGER',now(), now(),NULL);
-- 일반 회원
INSERT INTO `hobby_member` (`member_id`,`hobby_id`,`state`,`privilege`,`reg_dt`,`chg_dt`,`resd_dt`) VALUES (6, 25,'ACTIVE','GENERAL',now(), now(),NULL);
INSERT INTO `hobby_member` (`member_id`,`hobby_id`,`state`,`privilege`,`reg_dt`,`chg_dt`,`resd_dt`) VALUES (7, 25,'ACTIVE','GENERAL',now(), now(),NULL);
INSERT INTO `hobby_member` (`member_id`,`hobby_id`,`state`,`privilege`,`reg_dt`,`chg_dt`,`resd_dt`) VALUES (8, 25,'ACTIVE','GENERAL',now(), now(),NULL);
INSERT INTO `hobby_member` (`member_id`,`hobby_id`,`state`,`privilege`,`reg_dt`,`chg_dt`,`resd_dt`) VALUES (9, 25,'ACTIVE','GENERAL',now(), now(),NULL);
INSERT INTO `hobby_member` (`member_id`,`hobby_id`,`state`,`privilege`,`reg_dt`,`chg_dt`,`resd_dt`) VALUES (10, 25,'ACTIVE','GENERAL',now(), now(),NULL);
INSERT INTO `hobby_member` (`member_id`,`hobby_id`,`state`,`privilege`,`reg_dt`,`chg_dt`,`resd_dt`) VALUES (13, 25,'ACTIVE','GENERAL',now(), now(),NULL);
INSERT INTO `hobby_member` (`member_id`,`hobby_id`,`state`,`privilege`,`reg_dt`,`chg_dt`,`resd_dt`) VALUES (15, 25,'ACTIVE','GENERAL',now(), now(),NULL);
INSERT INTO `hobby_member` (`member_id`,`hobby_id`,`state`,`privilege`,`reg_dt`,`chg_dt`,`resd_dt`) VALUES (18, 25,'ACTIVE','GENERAL',now(), now(),NULL);

-- 26번 회원
-- 관리자 회원
INSERT INTO `hobby_member` (`member_id`,`hobby_id`,`state`,`privilege`,`reg_dt`,`chg_dt`,`resd_dt`) VALUES (3, 26,'ACTIVE','MANAGER',now(), now(),NULL);
INSERT INTO `hobby_member` (`member_id`,`hobby_id`,`state`,`privilege`,`reg_dt`,`chg_dt`,`resd_dt`) VALUES (5, 26,'ACTIVE','MANAGER',now(), now(),NULL);
INSERT INTO `hobby_member` (`member_id`,`hobby_id`,`state`,`privilege`,`reg_dt`,`chg_dt`,`resd_dt`) VALUES (7, 26,'ACTIVE','MANAGER',now(), now(),NULL);
-- 일반 회원
INSERT INTO `hobby_member` (`member_id`,`hobby_id`,`state`,`privilege`,`reg_dt`,`chg_dt`,`resd_dt`) VALUES (7, 26,'ACTIVE','GENERAL',now(), now(),NULL);
INSERT INTO `hobby_member` (`member_id`,`hobby_id`,`state`,`privilege`,`reg_dt`,`chg_dt`,`resd_dt`) VALUES (8, 26,'ACTIVE','GENERAL',now(), now(),NULL);
INSERT INTO `hobby_member` (`member_id`,`hobby_id`,`state`,`privilege`,`reg_dt`,`chg_dt`,`resd_dt`) VALUES (11, 26,'ACTIVE','GENERAL',now(), now(),NULL);
INSERT INTO `hobby_member` (`member_id`,`hobby_id`,`state`,`privilege`,`reg_dt`,`chg_dt`,`resd_dt`) VALUES (13, 26,'ACTIVE','GENERAL',now(), now(),NULL);
INSERT INTO `hobby_member` (`member_id`,`hobby_id`,`state`,`privilege`,`reg_dt`,`chg_dt`,`resd_dt`) VALUES (15, 26,'ACTIVE','GENERAL',now(), now(),NULL);

-- 27번 회원
-- 관리자 회원
INSERT INTO `hobby_member` (`member_id`,`hobby_id`,`state`,`privilege`,`reg_dt`,`chg_dt`,`resd_dt`) VALUES (6, 27,'ACTIVE','MANAGER',now(), now(),NULL);
INSERT INTO `hobby_member` (`member_id`,`hobby_id`,`state`,`privilege`,`reg_dt`,`chg_dt`,`resd_dt`) VALUES (8, 27,'ACTIVE','MANAGER',now(), now(),NULL);
-- 일반 회원
INSERT INTO `hobby_member` (`member_id`,`hobby_id`,`state`,`privilege`,`reg_dt`,`chg_dt`,`resd_dt`) VALUES (7, 26,'ACTIVE','GENERAL',now(), now(),NULL);
INSERT INTO `hobby_member` (`member_id`,`hobby_id`,`state`,`privilege`,`reg_dt`,`chg_dt`,`resd_dt`) VALUES (9, 26,'ACTIVE','GENERAL',now(), now(),NULL);
INSERT INTO `hobby_member` (`member_id`,`hobby_id`,`state`,`privilege`,`reg_dt`,`chg_dt`,`resd_dt`) VALUES (10, 26,'ACTIVE','GENERAL',now(), now(),NULL);
INSERT INTO `hobby_member` (`member_id`,`hobby_id`,`state`,`privilege`,`reg_dt`,`chg_dt`,`resd_dt`) VALUES (12, 26,'ACTIVE','GENERAL',now(), now(),NULL);
INSERT INTO `hobby_member` (`member_id`,`hobby_id`,`state`,`privilege`,`reg_dt`,`chg_dt`,`resd_dt`) VALUES (13, 26,'ACTIVE','GENERAL',now(), now(),NULL);
INSERT INTO `hobby_member` (`member_id`,`hobby_id`,`state`,`privilege`,`reg_dt`,`chg_dt`,`resd_dt`) VALUES (14, 26,'ACTIVE','GENERAL',now(), now(),NULL);
INSERT INTO `hobby_member` (`member_id`,`hobby_id`,`state`,`privilege`,`reg_dt`,`chg_dt`,`resd_dt`) VALUES (17, 26,'ACTIVE','GENERAL',now(), now(),NULL);

-- 28번 회원
-- 관리자 회원
INSERT INTO `hobby_member` (`member_id`,`hobby_id`,`state`,`privilege`,`reg_dt`,`chg_dt`,`resd_dt`) VALUES (9, 28,'ACTIVE','MANAGER',now(), now(),NULL);
-- 일반 회원
INSERT INTO `hobby_member` (`member_id`,`hobby_id`,`state`,`privilege`,`reg_dt`,`chg_dt`,`resd_dt`) VALUES (1, 28,'ACTIVE','GENERAL',now(), now(),NULL);
INSERT INTO `hobby_member` (`member_id`,`hobby_id`,`state`,`privilege`,`reg_dt`,`chg_dt`,`resd_dt`) VALUES (2, 28,'ACTIVE','GENERAL',now(), now(),NULL);
INSERT INTO `hobby_member` (`member_id`,`hobby_id`,`state`,`privilege`,`reg_dt`,`chg_dt`,`resd_dt`) VALUES (4, 28,'ACTIVE','GENERAL',now(), now(),NULL);
INSERT INTO `hobby_member` (`member_id`,`hobby_id`,`state`,`privilege`,`reg_dt`,`chg_dt`,`resd_dt`) VALUES (6, 28,'ACTIVE','GENERAL',now(), now(),NULL);
INSERT INTO `hobby_member` (`member_id`,`hobby_id`,`state`,`privilege`,`reg_dt`,`chg_dt`,`resd_dt`) VALUES (10, 28,'ACTIVE','GENERAL',now(), now(),NULL);
INSERT INTO `hobby_member` (`member_id`,`hobby_id`,`state`,`privilege`,`reg_dt`,`chg_dt`,`resd_dt`) VALUES (12, 28,'ACTIVE','GENERAL',now(), now(),NULL);
INSERT INTO `hobby_member` (`member_id`,`hobby_id`,`state`,`privilege`,`reg_dt`,`chg_dt`,`resd_dt`) VALUES (13, 28,'ACTIVE','GENERAL',now(), now(),NULL);
INSERT INTO `hobby_member` (`member_id`,`hobby_id`,`state`,`privilege`,`reg_dt`,`chg_dt`,`resd_dt`) VALUES (17, 28,'ACTIVE','GENERAL',now(), now(),NULL);

-- 29번 회원
-- 관리자 회원
INSERT INTO `hobby_member` (`member_id`,`hobby_id`,`state`,`privilege`,`reg_dt`,`chg_dt`,`resd_dt`) VALUES (10, 29,'ACTIVE','MANAGER',now(), now(),NULL);
-- 일반 회원
INSERT INTO `hobby_member` (`member_id`,`hobby_id`,`state`,`privilege`,`reg_dt`,`chg_dt`,`resd_dt`) VALUES (13, 29,'ACTIVE','GENERAL',now(), now(),NULL);
INSERT INTO `hobby_member` (`member_id`,`hobby_id`,`state`,`privilege`,`reg_dt`,`chg_dt`,`resd_dt`) VALUES (14, 29,'ACTIVE','GENERAL',now(), now(),NULL);
INSERT INTO `hobby_member` (`member_id`,`hobby_id`,`state`,`privilege`,`reg_dt`,`chg_dt`,`resd_dt`) VALUES (16, 29,'ACTIVE','GENERAL',now(), now(),NULL);
INSERT INTO `hobby_member` (`member_id`,`hobby_id`,`state`,`privilege`,`reg_dt`,`chg_dt`,`resd_dt`) VALUES (17, 29,'ACTIVE','GENERAL',now(), now(),NULL);
INSERT INTO `hobby_member` (`member_id`,`hobby_id`,`state`,`privilege`,`reg_dt`,`chg_dt`,`resd_dt`) VALUES (5, 29,'ACTIVE','GENERAL',now(), now(),NULL);
INSERT INTO `hobby_member` (`member_id`,`hobby_id`,`state`,`privilege`,`reg_dt`,`chg_dt`,`resd_dt`) VALUES (3, 29,'ACTIVE','GENERAL',now(), now(),NULL);


-- -----------------------------------------------------
-- insertHobbyMemberArticle
-- -----------------------------------------------------
/*
-- Query: select * from hobby_article
LIMIT 0, 200

-- Date: 2023-02-10 17:07
*/
INSERT INTO `hobby_article` (`hobby_id`,`member_id`,`category`,`title`,`content`,`hit`,`like`,`reg_dt`,`chg_dt`) VALUES (1,2,'GENERAL','석촌 호수','석촌호수에 도착했다. 커플들이 많이 보인다. 파인애플이 듬뿍 올라간피자가 먹고싶습니다.',0,0,now(),now());
INSERT INTO `hobby_article` (`hobby_id`,`member_id`,`category`,`title`,`content`,`hit`,`like`,`reg_dt`,`chg_dt`) VALUES (1,3,'GENERAL','배낭여행 20일차','힘들다, 집가고 싶다, 배고파',0,0,now(),now());
INSERT INTO `hobby_article` (`hobby_id`,`member_id`,`category`,`title`,`content`,`hit`,`like`,`reg_dt`,`chg_dt`) VALUES (1,2,'GENERAL','미국 여행 1일차','디스 이즈 어메리카',0,0,now(),now());
INSERT INTO `hobby_article` (`hobby_id`,`member_id`,`category`,`title`,`content`,`hit`,`like`,`reg_dt`,`chg_dt`) VALUES (1,4,'GENERAL','떠납니다','자아를 찾아 떠납니다.',0,0,now(),now());
INSERT INTO `hobby_article` (`hobby_id`,`member_id`,`category`,`title`,`content`,`hit`,`like`,`reg_dt`,`chg_dt`) VALUES (1,3,'GENERAL','현직 우주 여행자입니다','우주 저 너머로! 사이버펑크 꼭 보세요 두번보세요.',0,0,now(),now());
INSERT INTO `hobby_article` (`hobby_id`,`member_id`,`category`,`title`,`content`,`hit`,`like`,`reg_dt`,`chg_dt`) VALUES (1,4,'GENERAL','한옥마을 왔습니다.','한복입은 모습 보니까 진짜 다들 너무 예쁘더라고요',0,0,now(),now());
INSERT INTO `hobby_article` (`hobby_id`,`member_id`,`category`,`title`,`content`,`hit`,`like`,`reg_dt`,`chg_dt`) VALUES (1,6,'GENERAL','여기는 코스타리카','그래서 여기가 어디죠?',0,0,now(),now());
INSERT INTO `hobby_article` (`hobby_id`,`member_id`,`category`,`title`,`content`,`hit`,`like`,`reg_dt`,`chg_dt`) VALUES (1,7,'GENERAL','성지 순례 왔습니다','다들 평화로운 하루 되시길 바랍니다.',0,0,now(),now());
INSERT INTO `hobby_article` (`hobby_id`,`member_id`,`category`,`title`,`content`,`hit`,`like`,`reg_dt`,`chg_dt`) VALUES (1,4,'GENERAL','마음이 한결 놓이네요','답답한 마음이었는데 나오니까 훨씬 좋네요',0,0,now(),now());
INSERT INTO `hobby_article` (`hobby_id`,`member_id`,`category`,`title`,`content`,`hit`,`like`,`reg_dt`,`chg_dt`) VALUES (1,1,'GENERAL','안녕하세요 방장입니다.','다들 적극적인 활동해주셔서 너무 감사합니다.',0,0,now(),now());
INSERT INTO `hobby_article` (`hobby_id`,`member_id`,`category`,`title`,`content`,`hit`,`like`,`reg_dt`,`chg_dt`) VALUES (1,1,'GENERAL','방장의 여행 추천','저는 오늘 제주도왔습니다. 동백꽃이 너무 이쁘네요! 다들 지금 오셔야할듯~',0,0,now(),now());
INSERT INTO `hobby_article` (`hobby_id`,`member_id`,`category`,`title`,`content`,`hit`,`like`,`reg_dt`,`chg_dt`) VALUES (1,5,'GENERAL','나는 오늘 드라이브나왔습니다','날이 조금 흐리긴 한데 막상 나오니까 너무 좋네요',0,0,now(),now());
INSERT INTO `hobby_article` (`hobby_id`,`member_id`,`category`,`title`,`content`,`hit`,`like`,`reg_dt`,`chg_dt`) VALUES (1,13,'GENERAL','Beautiful','날 하나는 기가막히네요 있다가 화상채팅 들어갈게요',0,0,now(),now());
INSERT INTO `hobby_article` (`hobby_id`,`member_id`,`category`,`title`,`content`,`hit`,`like`,`reg_dt`,`chg_dt`) VALUES (1,12,'GENERAL','베네치아 다들 가보셨나요?','이번에 가려는데 꿀팁좀 주고 가셔요~',0,0,now(),now());
INSERT INTO `hobby_article` (`hobby_id`,`member_id`,`category`,`title`,`content`,`hit`,`like`,`reg_dt`,`chg_dt`) VALUES (1,9,'GENERAL','런던은 항상 날이 흐리네요','사진을 찍어도 이쁘게 나오기가 힘드네요ㅠㅠ',0,0,now(),now());
INSERT INTO `hobby_article` (`hobby_id`,`member_id`,`category`,`title`,`content`,`hit`,`like`,`reg_dt`,`chg_dt`) VALUES (1,10,'GENERAL','나는 언제나 이날만을 기다렸어요','ㅈㄱㄴ',0,0,now(),now());
INSERT INTO `hobby_article` (`hobby_id`,`member_id`,`category`,`title`,`content`,`hit`,`like`,`reg_dt`,`chg_dt`) VALUES (1,11,'GENERAL','돌아가고싶어','오오...집으로 돌아가고 싶어...',0,0,now(),now());
INSERT INTO `hobby_article` (`hobby_id`,`member_id`,`category`,`title`,`content`,`hit`,`like`,`reg_dt`,`chg_dt`) VALUES (1,10,'GENERAL','이제 막 출국합니다!','첫 여행이라 그런지 엄청 떨려요~~~~ 다들 즐거운 여행 보내셔요',0,0,now(),now());
INSERT INTO `hobby_article` (`hobby_id`,`member_id`,`category`,`title`,`content`,`hit`,`like`,`reg_dt`,`chg_dt`) VALUES (1,10,'GENERAL','마지막 날이네요','한국 돌아오면 같이 미팅하면서 썰풀 사람들 찾아요.',0,0,now(),now());
INSERT INTO `hobby_article` (`hobby_id`,`member_id`,`category`,`title`,`content`,`hit`,`like`,`reg_dt`,`chg_dt`) VALUES (1,3,'GENERAL','Hobbyit','숙소 도착했어요~ 미팅 들어오실 분!!!!!',0,0,now(),now());

INSERT INTO `hobby_article` (`hobby_id`,`member_id`,`category`,`title`,`content`,`hit`,`like`,`reg_dt`,`chg_dt`) VALUES (1,2,'GENERAL','석촌 호수','석촌호수에 도착했다. 커플들이 많이 보인다. 파인애플이 듬뿍 올라간피자가 먹고싶습니다.',0,0,now(),now());
INSERT INTO `hobby_article` (`hobby_id`,`member_id`,`category`,`title`,`content`,`hit`,`like`,`reg_dt`,`chg_dt`) VALUES (1,3,'GENERAL','배낭여행 20일차','힘들다, 집가고 싶다, 배고파',0,0,now(),now());
INSERT INTO `hobby_article` (`hobby_id`,`member_id`,`category`,`title`,`content`,`hit`,`like`,`reg_dt`,`chg_dt`) VALUES (1,2,'GENERAL','미국 여행 1일차','디스 이즈 어메리카',0,0,now(),now());
INSERT INTO `hobby_article` (`hobby_id`,`member_id`,`category`,`title`,`content`,`hit`,`like`,`reg_dt`,`chg_dt`) VALUES (1,4,'GENERAL','떠납니다','자아를 찾아 떠납니다.',0,0,now(),now());
INSERT INTO `hobby_article` (`hobby_id`,`member_id`,`category`,`title`,`content`,`hit`,`like`,`reg_dt`,`chg_dt`) VALUES (1,3,'GENERAL','현직 우주 여행자입니다','우주 저 너머로! 사이버펑크 꼭 보세요 두번보세요.',0,0,now(),now());
INSERT INTO `hobby_article` (`hobby_id`,`member_id`,`category`,`title`,`content`,`hit`,`like`,`reg_dt`,`chg_dt`) VALUES (1,4,'GENERAL','한옥마을 왔습니다.','한복입은 모습 보니까 진짜 다들 너무 예쁘더라고요',0,0,now(),now());
INSERT INTO `hobby_article` (`hobby_id`,`member_id`,`category`,`title`,`content`,`hit`,`like`,`reg_dt`,`chg_dt`) VALUES (1,6,'GENERAL','여기는 코스타리카','그래서 여기가 어디죠?',0,0,now(),now());
INSERT INTO `hobby_article` (`hobby_id`,`member_id`,`category`,`title`,`content`,`hit`,`like`,`reg_dt`,`chg_dt`) VALUES (1,7,'GENERAL','성지 순례 왔습니다','다들 평화로운 하루 되시길 바랍니다.',0,0,now(),now());
INSERT INTO `hobby_article` (`hobby_id`,`member_id`,`category`,`title`,`content`,`hit`,`like`,`reg_dt`,`chg_dt`) VALUES (1,4,'GENERAL','마음이 한결 놓이네요','답답한 마음이었는데 나오니까 훨씬 좋네요',0,0,now(),now());
INSERT INTO `hobby_article` (`hobby_id`,`member_id`,`category`,`title`,`content`,`hit`,`like`,`reg_dt`,`chg_dt`) VALUES (1,1,'GENERAL','안녕하세요 방장입니다.','다들 적극적인 활동해주셔서 너무 감사합니다.',0,0,now(),now());
INSERT INTO `hobby_article` (`hobby_id`,`member_id`,`category`,`title`,`content`,`hit`,`like`,`reg_dt`,`chg_dt`) VALUES (1,1,'GENERAL','방장의 여행 추천','저는 오늘 제주도왔습니다. 동백꽃이 너무 이쁘네요! 다들 지금 오셔야할듯~',0,0,now(),now());
INSERT INTO `hobby_article` (`hobby_id`,`member_id`,`category`,`title`,`content`,`hit`,`like`,`reg_dt`,`chg_dt`) VALUES (1,5,'GENERAL','나는 오늘 드라이브나왔습니다','날이 조금 흐리긴 한데 막상 나오니까 너무 좋네요',0,0,now(),now());
INSERT INTO `hobby_article` (`hobby_id`,`member_id`,`category`,`title`,`content`,`hit`,`like`,`reg_dt`,`chg_dt`) VALUES (1,13,'GENERAL','Beautiful','날 하나는 기가막히네요 있다가 화상채팅 들어갈게요',0,0,now(),now());
INSERT INTO `hobby_article` (`hobby_id`,`member_id`,`category`,`title`,`content`,`hit`,`like`,`reg_dt`,`chg_dt`) VALUES (1,12,'GENERAL','베네치아 다들 가보셨나요?','이번에 가려는데 꿀팁좀 주고 가셔요~',0,0,now(),now());
INSERT INTO `hobby_article` (`hobby_id`,`member_id`,`category`,`title`,`content`,`hit`,`like`,`reg_dt`,`chg_dt`) VALUES (1,9,'GENERAL','런던은 항상 날이 흐리네요','사진을 찍어도 이쁘게 나오기가 힘드네요ㅠㅠ',0,0,now(),now());
INSERT INTO `hobby_article` (`hobby_id`,`member_id`,`category`,`title`,`content`,`hit`,`like`,`reg_dt`,`chg_dt`) VALUES (1,10,'GENERAL','나는 언제나 이날만을 기다렸어요','ㅈㄱㄴ',0,0,now(),now());
INSERT INTO `hobby_article` (`hobby_id`,`member_id`,`category`,`title`,`content`,`hit`,`like`,`reg_dt`,`chg_dt`) VALUES (1,11,'GENERAL','돌아가고싶어','오오...집으로 돌아가고 싶어...',0,0,now(),now());
INSERT INTO `hobby_article` (`hobby_id`,`member_id`,`category`,`title`,`content`,`hit`,`like`,`reg_dt`,`chg_dt`) VALUES (1,10,'GENERAL','이제 막 출국합니다!','첫 여행이라 그런지 엄청 떨려요~~~~ 다들 즐거운 여행 보내셔요',0,0,now(),now());
INSERT INTO `hobby_article` (`hobby_id`,`member_id`,`category`,`title`,`content`,`hit`,`like`,`reg_dt`,`chg_dt`) VALUES (1,10,'GENERAL','마지막 날이네요','한국 돌아오면 같이 미팅하면서 썰풀 사람들 찾아요.',0,0,now(),now());
INSERT INTO `hobby_article` (`hobby_id`,`member_id`,`category`,`title`,`content`,`hit`,`like`,`reg_dt`,`chg_dt`) VALUES (1,3,'GENERAL','Hobbyit','숙소 도착했어요~ 미팅 들어오실 분!!!!!',0,0,now(),now());

INSERT INTO `hobby_article` (`hobby_id`,`member_id`,`category`,`title`,`content`,`hit`,`like`,`reg_dt`,`chg_dt`) VALUES (1,2,'GENERAL','석촌 호수','석촌호수에 도착했다. 커플들이 많이 보인다. 파인애플이 듬뿍 올라간피자가 먹고싶습니다.',0,0,now(),now());
INSERT INTO `hobby_article` (`hobby_id`,`member_id`,`category`,`title`,`content`,`hit`,`like`,`reg_dt`,`chg_dt`) VALUES (1,3,'GENERAL','배낭여행 20일차','힘들다, 집가고 싶다, 배고파',0,0,now(),now());
INSERT INTO `hobby_article` (`hobby_id`,`member_id`,`category`,`title`,`content`,`hit`,`like`,`reg_dt`,`chg_dt`) VALUES (1,2,'GENERAL','미국 여행 1일차','디스 이즈 어메리카',0,0,now(),now());
INSERT INTO `hobby_article` (`hobby_id`,`member_id`,`category`,`title`,`content`,`hit`,`like`,`reg_dt`,`chg_dt`) VALUES (1,4,'GENERAL','떠납니다','자아를 찾아 떠납니다.',0,0,now(),now());
INSERT INTO `hobby_article` (`hobby_id`,`member_id`,`category`,`title`,`content`,`hit`,`like`,`reg_dt`,`chg_dt`) VALUES (1,3,'GENERAL','현직 우주 여행자입니다','우주 저 너머로! 사이버펑크 꼭 보세요 두번보세요.',0,0,now(),now());
INSERT INTO `hobby_article` (`hobby_id`,`member_id`,`category`,`title`,`content`,`hit`,`like`,`reg_dt`,`chg_dt`) VALUES (1,4,'GENERAL','한옥마을 왔습니다.','한복입은 모습 보니까 진짜 다들 너무 예쁘더라고요',0,0,now(),now());
INSERT INTO `hobby_article` (`hobby_id`,`member_id`,`category`,`title`,`content`,`hit`,`like`,`reg_dt`,`chg_dt`) VALUES (1,6,'GENERAL','여기는 코스타리카','그래서 여기가 어디죠?',0,0,now(),now());
INSERT INTO `hobby_article` (`hobby_id`,`member_id`,`category`,`title`,`content`,`hit`,`like`,`reg_dt`,`chg_dt`) VALUES (1,7,'GENERAL','성지 순례 왔습니다','다들 평화로운 하루 되시길 바랍니다.',0,0,now(),now());
INSERT INTO `hobby_article` (`hobby_id`,`member_id`,`category`,`title`,`content`,`hit`,`like`,`reg_dt`,`chg_dt`) VALUES (1,4,'GENERAL','마음이 한결 놓이네요','답답한 마음이었는데 나오니까 훨씬 좋네요',0,0,now(),now());
INSERT INTO `hobby_article` (`hobby_id`,`member_id`,`category`,`title`,`content`,`hit`,`like`,`reg_dt`,`chg_dt`) VALUES (1,1,'GENERAL','안녕하세요 방장입니다.','다들 적극적인 활동해주셔서 너무 감사합니다.',0,0,now(),now());
INSERT INTO `hobby_article` (`hobby_id`,`member_id`,`category`,`title`,`content`,`hit`,`like`,`reg_dt`,`chg_dt`) VALUES (1,1,'GENERAL','방장의 여행 추천','저는 오늘 제주도왔습니다. 동백꽃이 너무 이쁘네요! 다들 지금 오셔야할듯~',0,0,now(),now());
INSERT INTO `hobby_article` (`hobby_id`,`member_id`,`category`,`title`,`content`,`hit`,`like`,`reg_dt`,`chg_dt`) VALUES (1,5,'GENERAL','나는 오늘 드라이브나왔습니다','날이 조금 흐리긴 한데 막상 나오니까 너무 좋네요',0,0,now(),now());
INSERT INTO `hobby_article` (`hobby_id`,`member_id`,`category`,`title`,`content`,`hit`,`like`,`reg_dt`,`chg_dt`) VALUES (1,13,'GENERAL','Beautiful','날 하나는 기가막히네요 있다가 화상채팅 들어갈게요',0,0,now(),now());
INSERT INTO `hobby_article` (`hobby_id`,`member_id`,`category`,`title`,`content`,`hit`,`like`,`reg_dt`,`chg_dt`) VALUES (1,12,'GENERAL','베네치아 다들 가보셨나요?','이번에 가려는데 꿀팁좀 주고 가셔요~',0,0,now(),now());
INSERT INTO `hobby_article` (`hobby_id`,`member_id`,`category`,`title`,`content`,`hit`,`like`,`reg_dt`,`chg_dt`) VALUES (1,9,'GENERAL','런던은 항상 날이 흐리네요','사진을 찍어도 이쁘게 나오기가 힘드네요ㅠㅠ',0,0,now(),now());
INSERT INTO `hobby_article` (`hobby_id`,`member_id`,`category`,`title`,`content`,`hit`,`like`,`reg_dt`,`chg_dt`) VALUES (1,10,'GENERAL','나는 언제나 이날만을 기다렸어요','ㅈㄱㄴ',0,0,now(),now());
INSERT INTO `hobby_article` (`hobby_id`,`member_id`,`category`,`title`,`content`,`hit`,`like`,`reg_dt`,`chg_dt`) VALUES (1,11,'GENERAL','돌아가고싶어','오오...집으로 돌아가고 싶어...',0,0,now(),now());
INSERT INTO `hobby_article` (`hobby_id`,`member_id`,`category`,`title`,`content`,`hit`,`like`,`reg_dt`,`chg_dt`) VALUES (1,10,'GENERAL','이제 막 출국합니다!','첫 여행이라 그런지 엄청 떨려요~~~~ 다들 즐거운 여행 보내셔요',0,0,now(),now());
INSERT INTO `hobby_article` (`hobby_id`,`member_id`,`category`,`title`,`content`,`hit`,`like`,`reg_dt`,`chg_dt`) VALUES (1,10,'GENERAL','마지막 날이네요','한국 돌아오면 같이 미팅하면서 썰풀 사람들 찾아요.',0,0,now(),now());
INSERT INTO `hobby_article` (`hobby_id`,`member_id`,`category`,`title`,`content`,`hit`,`like`,`reg_dt`,`chg_dt`) VALUES (1,3,'GENERAL','Hobbyit','숙소 도착했어요~ 미팅 들어오실 분!!!!!',0,0,now(),now());

INSERT INTO `hobby_article` (`hobby_id`,`member_id`,`category`,`title`,`content`,`hit`,`like`,`reg_dt`,`chg_dt`) VALUES (1,2,'GENERAL','석촌 호수','석촌호수에 도착했다. 커플들이 많이 보인다. 파인애플이 듬뿍 올라간피자가 먹고싶습니다.',0,0,now(),now());
INSERT INTO `hobby_article` (`hobby_id`,`member_id`,`category`,`title`,`content`,`hit`,`like`,`reg_dt`,`chg_dt`) VALUES (1,3,'GENERAL','배낭여행 20일차','힘들다, 집가고 싶다, 배고파',0,0,now(),now());
INSERT INTO `hobby_article` (`hobby_id`,`member_id`,`category`,`title`,`content`,`hit`,`like`,`reg_dt`,`chg_dt`) VALUES (1,2,'GENERAL','미국 여행 1일차','디스 이즈 어메리카',0,0,now(),now());
INSERT INTO `hobby_article` (`hobby_id`,`member_id`,`category`,`title`,`content`,`hit`,`like`,`reg_dt`,`chg_dt`) VALUES (1,4,'GENERAL','떠납니다','자아를 찾아 떠납니다.',0,0,now(),now());
INSERT INTO `hobby_article` (`hobby_id`,`member_id`,`category`,`title`,`content`,`hit`,`like`,`reg_dt`,`chg_dt`) VALUES (1,3,'GENERAL','현직 우주 여행자입니다','우주 저 너머로! 사이버펑크 꼭 보세요 두번보세요.',0,0,now(),now());
INSERT INTO `hobby_article` (`hobby_id`,`member_id`,`category`,`title`,`content`,`hit`,`like`,`reg_dt`,`chg_dt`) VALUES (1,4,'GENERAL','한옥마을 왔습니다.','한복입은 모습 보니까 진짜 다들 너무 예쁘더라고요',0,0,now(),now());
INSERT INTO `hobby_article` (`hobby_id`,`member_id`,`category`,`title`,`content`,`hit`,`like`,`reg_dt`,`chg_dt`) VALUES (1,6,'GENERAL','여기는 코스타리카','그래서 여기가 어디죠?',0,0,now(),now());
INSERT INTO `hobby_article` (`hobby_id`,`member_id`,`category`,`title`,`content`,`hit`,`like`,`reg_dt`,`chg_dt`) VALUES (1,7,'GENERAL','성지 순례 왔습니다','다들 평화로운 하루 되시길 바랍니다.',0,0,now(),now());
INSERT INTO `hobby_article` (`hobby_id`,`member_id`,`category`,`title`,`content`,`hit`,`like`,`reg_dt`,`chg_dt`) VALUES (1,4,'GENERAL','마음이 한결 놓이네요','답답한 마음이었는데 나오니까 훨씬 좋네요',0,0,now(),now());
INSERT INTO `hobby_article` (`hobby_id`,`member_id`,`category`,`title`,`content`,`hit`,`like`,`reg_dt`,`chg_dt`) VALUES (1,1,'GENERAL','안녕하세요 방장입니다.','다들 적극적인 활동해주셔서 너무 감사합니다.',0,0,now(),now());
INSERT INTO `hobby_article` (`hobby_id`,`member_id`,`category`,`title`,`content`,`hit`,`like`,`reg_dt`,`chg_dt`) VALUES (1,1,'GENERAL','방장의 여행 추천','저는 오늘 제주도왔습니다. 동백꽃이 너무 이쁘네요! 다들 지금 오셔야할듯~',0,0,now(),now());
INSERT INTO `hobby_article` (`hobby_id`,`member_id`,`category`,`title`,`content`,`hit`,`like`,`reg_dt`,`chg_dt`) VALUES (1,5,'GENERAL','나는 오늘 드라이브나왔습니다','날이 조금 흐리긴 한데 막상 나오니까 너무 좋네요',0,0,now(),now());
INSERT INTO `hobby_article` (`hobby_id`,`member_id`,`category`,`title`,`content`,`hit`,`like`,`reg_dt`,`chg_dt`) VALUES (1,13,'GENERAL','Beautiful','날 하나는 기가막히네요 있다가 화상채팅 들어갈게요',0,0,now(),now());
INSERT INTO `hobby_article` (`hobby_id`,`member_id`,`category`,`title`,`content`,`hit`,`like`,`reg_dt`,`chg_dt`) VALUES (1,12,'GENERAL','베네치아 다들 가보셨나요?','이번에 가려는데 꿀팁좀 주고 가셔요~',0,0,now(),now());
INSERT INTO `hobby_article` (`hobby_id`,`member_id`,`category`,`title`,`content`,`hit`,`like`,`reg_dt`,`chg_dt`) VALUES (1,9,'GENERAL','런던은 항상 날이 흐리네요','사진을 찍어도 이쁘게 나오기가 힘드네요ㅠㅠ',0,0,now(),now());
INSERT INTO `hobby_article` (`hobby_id`,`member_id`,`category`,`title`,`content`,`hit`,`like`,`reg_dt`,`chg_dt`) VALUES (1,10,'GENERAL','나는 언제나 이날만을 기다렸어요','ㅈㄱㄴ',0,0,now(),now());
INSERT INTO `hobby_article` (`hobby_id`,`member_id`,`category`,`title`,`content`,`hit`,`like`,`reg_dt`,`chg_dt`) VALUES (1,11,'GENERAL','돌아가고싶어','오오...집으로 돌아가고 싶어...',0,0,now(),now());
INSERT INTO `hobby_article` (`hobby_id`,`member_id`,`category`,`title`,`content`,`hit`,`like`,`reg_dt`,`chg_dt`) VALUES (1,10,'GENERAL','이제 막 출국합니다!','첫 여행이라 그런지 엄청 떨려요~~~~ 다들 즐거운 여행 보내셔요',0,0,now(),now());
INSERT INTO `hobby_article` (`hobby_id`,`member_id`,`category`,`title`,`content`,`hit`,`like`,`reg_dt`,`chg_dt`) VALUES (1,10,'GENERAL','마지막 날이네요','한국 돌아오면 같이 미팅하면서 썰풀 사람들 찾아요.',0,0,now(),now());
INSERT INTO `hobby_article` (`hobby_id`,`member_id`,`category`,`title`,`content`,`hit`,`like`,`reg_dt`,`chg_dt`) VALUES (1,3,'GENERAL','Hobbyit','숙소 도착했어요~ 미팅 들어오실 분!!!!!',0,0,now(),now());


-- -----------------------------------------------------
-- inserthobbyarticleimg PROCEDURE
-- -----------------------------------------------------
DROP PROCEDURE IF EXISTS `IMG_PROC`;
DELIMITER $$
CREATE PROCEDURE `IMG_PROC` (
)
BEGIN
    -- 변수 선언
    DECLARE IDNUM INTEGER DEFAULT 1;
     WHILE IDNUM <= 80 DO           -- NUM1은 0~9까지 10번반복
		INSERT INTO `hobby_article_img` (`hobby_art_id`, `img_url`) VALUES (IDNUM, '/static/images/defaulthobbyimg.png');
        SET IDNUM = IDNUM + 1;
    END WHILE;

END $$
DELIMITER ;

CALL IMG_PROC();


-- -----------------------------------------------------
--  delete_member_after_7_days EVENT
-- -----------------------------------------------------
DROP EVENT if exists delete_member_after_7_days;
CREATE EVENT delete_member_after_7_days
ON SCHEDULE EVERY 1 DAY
COMMENT '탈퇴 요청일 7일 후 member 테이블의 state 속성값을 WAITING(탈퇴 대기중)에서 RESIGNED(탈퇴)로 변경하는 이벤트를 매일 수행한다.'
DO
UPDATE member SET state = 'RESIGNED' WHERE state = 'WAITING' AND DATEDIFF(NOW(), resd_req_dt) >= 7;



