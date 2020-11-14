/*회원 테이블과 권한 테이블*/
CREATE TABLE member (
	user_id VARCHAR(50) NOT NULL, /*아이디*/
	user_pw VARCHAR(100) NOT NULL, /*비밀번호*/
	user_name VARCHAR(10) NOT NULL DEFAULT '00', /*닉네임*/
	point INT(10) DEFAULT 0, /*예약 페이지 화폐*/
    email VARCHAR(50) NOT NULL, /*이메일 주소*/
	phone VARCHAR(50) NOT NULL, /*휴대폰 번호*/
	reg_Date TIMESTAMP DEFAULT now(), /*등록 일자*/
	upd_date TIMESTAMP DEFAULT now(), /*수정 일자*/
	enabled CHAR(1) DEFAULT '1', /*enabled : 계정의 활성화, 비활성화의 여부를 알려준다. */
	PRIMARY KEY (user_id)
);

CREATE TABLE member_auth (
	user_id VARCHAR(50) NOT NULL, /*아이디*/
	auth VARCHAR(50) NOT NULL /*권한*/
);

ALTER TABLE member_auth ADD CONSTRAINT fk_member_auth_user_id FOREIGN KEY (user_id) REFERENCES member(user_id) ON DELETE CASCADE;

/*로그인 상태 유지 테이블*/
CREATE TABLE persistent_logins (
	username VARCHAR(64) NOT NULL, /*아이디*/
    series VARCHAR(64) NOT NULL, /*시리즈*/
    token VARCHAR(64) NOT NULL, /*토큰*/
    last_used TIMESTAMP NOT NULL, /*마지막 사용*/
    PRIMARY KEY (series)
);

/*회원 게시판 테이블*/
CREATE TABLE board (
	board_no INT NOT NULL AUTO_INCREMENT, /*게시판 번호*/
	title VARCHAR(200) NOT NULL, /*게시판 제목*/
	content TEXT, /*게시판 내용*/
	writer VARCHAR(50) NOT NULL, /*게시판 작성자*/
	reg_date TIMESTAMP NOT NULL DEFAULT now(), /*등록일자*/
	PRIMARY KEY (board_no)
);

/*댓글 테이블*/
CREATE TABLE reply (
	reply_no INT(5) NOT NULL AUTO_INCREMENT, /*댓글 번호*/
    board_no INT NOT NULL, /*게시판 번호*/
	reply_content VARCHAR(150) NOT NULL, /*댓글 내용*/
	reply_writer VARCHAR(50) NOT NULL, /*댓글 작성자*/
	reg_date TIMESTAMP DEFAULT now(), /*등록일자*/
	PRIMARY KEY (reply_no, board_no)
);

ALTER TABLE reply ADD CONSTRAINT fk_reply_board_no FOREIGN KEY (board_no) REFERENCES board(board_no) ON DELETE CASCADE;

/*공지사항 테이블*/
CREATE TABLE notice (
	notice_no INT NOT NULL AUTO_INCREMENT, /*공지사항 번호*/
	title VARCHAR(200) NOT NULL, /*공지사항 제목*/
	content TEXT, /*공지사항 내용*/
	reg_date TIMESTAMP NOT NULL DEFAULT now(), /*등록 일자*/
	PRIMARY KEY (notice_no)
);

/*1:1문의 테이블*/
CREATE TABLE inquiry (
	inquiry_no INT NOT NULL AUTO_INCREMENT, /*1:1문의 번호*/
	origin_no INT(10), /*문의하는 번호*/
	group_ord INT(10) DEFAULT 0, /*순서 번호*/
	group_layer INT(10) DEFAULT 0, /*깊이*/
	title VARCHAR(200) NOT NULL, /*문의 제목*/
	content TEXT, /*문의 내용*/
	writer VARCHAR(50) NOT NULL, /*문의 작성자*/
	reg_date TIMESTAMP NOT NULL DEFAULT now(), /*문의 등록일자*/
	PRIMARY KEY (inquiry_no)
);

/*충전 내역 테이블*/
CREATE TABLE charge_point_history (
	history_no INT AUTO_INCREMENT, /*충전 내역 번호*/
    user_id VARCHAR(50) NOT NULL, /*아이디*/
    amount INT(5) NOT NULL, /*금액*/
    reg_date TIMESTAMP DEFAULT now(), /*충전 일자*/
    PRIMARY KEY (history_no)
);

/*홍보 배너 테이블*/
CREATE TABLE banner (
	banner_no INT(5) AUTO_INCREMENT, /*배너 번호*/
    movie_no INT(5) NOT NULL, /*영화 번호*/
    banner_name VARCHAR(30) NOT NULL, /*배너 이름*/
    banner_picture_url varchar(200), /*배너 사진*/
	PRIMARY KEY (banner_no)
);

ALTER TABLE banner ADD CONSTRAINT fk_banner_movie_no FOREIGN KEY (movie_no) REFERENCES movie(movie_no) ON DELETE CASCADE;

/*영화 테이블*/
CREATE TABLE movie (
	movie_no INT NOT NULL AUTO_INCREMENT, /*영화 번호*/
    title VARCHAR(100) NOT NULL, /*영화 제목*/
    genre VARCHAR(50) NOT NULL, /*영화 장르*/
    nation VARCHAR(50) NOT NULL, /*영화 국가*/
    running_time INT(5) NOT NULL, /*영화 상영 시간*/
    openning_days DATE, /*영화 개봉일*/
    director VARCHAR(50) NOT NULL, /*영화 감독*/
    actors VARCHAR(200) NOT NULL, /*영화 출연 배우*/
    ratings VARCHAR(5), /*영화 심의 등급*/
    scores FLOAT, /*영화 평점*/
    summary TEXT, /*영화 소개*/
    poster_url VARCHAR(200), /*영화 포스터*/
    still1_url VARCHAR(200), /*영화 스틸컷1*/
    still2_url VARCHAR(200), /*영화 스틸컷2*/
    still3_url VARCHAR(200), /*영화 스틸컷3*/
    still4_url VARCHAR(200), /*영화 스틸컷4*/
	reg_date TIMESTAMP DEFAULT now(), /*등록 일자*/
	enabled CHAR(1) DEFAULT '1', /*영화 상영 상태*/
    PRIMARY KEY (movie_no)
);

/*영화 후기 테이블*/
CREATE TABLE review (
	review_no INT(5) NOT NULL AUTO_INCREMENT, /*후기 번호*/
    movie_no INT(5) NOT NULL, /*영화 번호*/
    scores FLOAT, /*후기 점수*/
    review_content VARCHAR(150) NOT NULL, /*후기 내용*/
    review_writer VARCHAR(50) NOT NULL, /*후기 작성자*/
    reg_date TIMESTAMP DEFAULT now(), /*등록 일자*/
    PRIMARY KEY (review_no, movie_no)
);

ALTER TABLE review ADD CONSTRAINT fk_review_movie_no FOREIGN KEY (movie_no) REFERENCES movie(movie_no) ON DELETE CASCADE;

/*도시 그룹 테이블*/
CREATE TABLE province_class (
	province_no INT NOT NULL AUTO_INCREMENT, /*도시 번호*/
    province_name VARCHAR(20) NOT NULL, /*도시 이름*/
    PRIMARY KEY (province_no)
);

/*도시 상세 테이블*/
CREATE TABLE province_detail (
    province_name VARCHAR(20) NOT NULL, /*도시 이름*/
    city_no INT NOT NULL AUTO_INCREMENT, /*영화관 번호*/
    city VARCHAR(20) NOT NULL, /*영화관*/
    PRIMARY KEY (city_no)
);

/*영화 상영관 테이블*/
CREATE TABLE movie_screen (
	province_name VARCHAR(20) NOT NULL, /*도시 이름*/
    city VARCHAR(20) NOT NULL, /*영화관*/
	screen_name VARCHAR(5) NOT NULL, /*영화 상영관 이름*/
	screen_col INT(3) NOT NULL, /*영화 상영관 행*/
    screen_row INT(3) NOT NULL, /*영화 상영관 열*/
	PRIMARY KEY (city, screen_name)  
);

/*영화 좌석 테이블*/
CREATE TABLE movie_seat (
	city VARCHAR(20) NOT NULL, /*영화관*/
	screen_name VARCHAR(5) NOT NULL, /*영화 상영관 이름*/
	seat_no INT NOT NULL AUTO_INCREMENT, /*좌석 번호*/
	seat_id VARCHAR(10), /*영화 좌석 이름*/
    price INT(6) DEFAULT 10000, /*영화 가격*/
    PRIMARY KEY (seat_no)
);

CREATE TABLE movie_time (
	time_no INT NOT NULL AUTO_INCREMENT,
	province_name VARCHAR(20) NOT NULL, /*도시 이름*/
    city VARCHAR(20) NOT NULL, /*영화관*/
	screen_name VARCHAR(5) NOT NULL, /*영화 상영관 이름*/
	title VARCHAR(100) NOT NULL, /*영화 제목*/
    show_date DATE NOT NULL, /*상영일*/
    show_time TIME NOT NULL, /*상영 시간*/
    PRIMARY KEY (time_no, city, screen_name, show_date, show_time)
);

/*영화 예약 테이블*/
CREATE TABLE movie_reservation (
	movie_reserve_no INT NOT NULL AUTO_INCREMENT, /*예약 번호*/
	user_id VARCHAR(50) NOT NULL, /*회원 아이디*/
	title VARCHAR(100) NOT NULL, /*영화 제목*/
    province_name VARCHAR(20) NOT NULL, /*도시 이름*/
    city VARCHAR(20) NOT NULL, /*영화관*/
	show_date DATE NOT NULL, /*상영일*/
    show_time TIME NOT NULL, /*상영 시간*/
    screen_name VARCHAR(5) NOT NULL, /*영화 상영관 이름*/
	seat_no INT(6), /*좌석 번호*/
	seat_id VARCHAR(10), /*좌석 번호*/
	price INT(6), /*가격*/
    enable CHAR(1) DEFAULT '0', /*좌석 활성화*/
    PRIMARY KEY (movie_reserve_no)
);

/*구매 내역 테이블*/
CREATE TABLE pay_point_history (
	history_no INT AUTO_INCREMENT, /*구매 번호*/
    user_id VARCHAR(50) NOT NULL, /*아이디*/
    amount INT(5) NOT NULL, /*금액*/
    reg_date TIMESTAMP DEFAULT now(), /*구매 일자*/
    PRIMARY KEY (history_no)
);

