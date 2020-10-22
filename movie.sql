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
	username VARCHAR(64) NOT NULL,
    series VARCHAR(64) NOT NULL,
    token VARCHAR(64) NOT NULL,
    last_used TIMESTAMP NOT NULL,
    PRIMARY KEY (series)
);

/*영화 테이블*/
CREATE TABLE movie (
	movie_no INT NOT NULL AUTO_INCREMENT, /*영화 번호*/
    title VARCHAR(100) NOT NULL, /*영화 제목*/
    genre VARCHAR(50) NOT NULL, /*영화 장르*/
    nation VARCHAR(50) NOT NULL, /*영화 국가*/
    runnung_time INT(5) NOT NULL, /*영화 상영 시간*/
    opennig_days VARCHAR(50) NOT NULL, /*영화 개봉일*/
    director VARCHAR(50) NOT NULL, /*영화 감독*/
    actors VARCHAR(200) NOT NULL, /*영화 출연 배우*/
    ratings VARCHAR(5), /*영화 심의 등급*/
    summary TEXT, /*영화 소개*/
    poster_url VARCHAR(200), /*영화 포스터*/
    still1_url VARCHAR(200), /*영화 스틸컷1*/
    still2_url VARCHAR(200), /*영화 스틸컷2*/
    still3_url VARCHAR(200), /*영화 스틸컷3*/
    still4_url VARCHAR(200), /*영화 스틸컷4*/
    enabled CHAR(1) DEFAULT '1', /*영화 상영 상태*/
    PRIMARY KEY (movie_no)
);

/*영화 후기 테이블*/
CREATE TABLE review (
	review_no INT(5) NOT NULL AUTO_INCREMENT,
    movie_no INT(5) NOT NULL,
    review_content VARCHAR(150) NOT NULL,
    review_writer VARCHAR(50) NOT NULL,
    reg_date TIMESTAMP DEFAULT now(),
    PRIMARY KEY (review_no, movie_no)
);

ALTER TABLE review ADD CONSTRAINT fk_review_movie_no FOREIGN KEY (movie_no) REFERENCES movie(movie_no) ON DELETE CASCADE;

/*영화 상영관 테이블*/
CREATE TABLE movie_screen (
	screen_no INT NOT NULL, /*영화 상영관 번호*/
    screen_name VARCHAR(5) NOT NULL, /*영화 상영관 이름*/
    screen_column INT(3) NOT NULL, /*영화 상영관 이름*/
    screen_row INT(3) NOT NULL, /*영화 상영관 이름*/
    seat_class VARCHAR(5) NOT NULL, /*좌석 등급*/
    price INT(6), /*가격*/
    PRIMARY KEY (screen_no)
);


/*영화 예약 정보 테이블*/
CREATE TABLE movie_booking_info (
	movie_no INT NOT NULL, /*영화 번호*/
    screen_no INT(5) NOT NULL, /*영화 상영관*/
    seat_class VARCHAR(5) NOT NULL, /*좌석 등급*/
    price INT(6), /*가격*/
    PRIMARY KEY (movie_no)
);

ALTER TABLE movie_booking_info ADD CONSTRAINT fk_movie_booking_info_movie_no FOREIGN KEY (movie_no) REFERENCES movie(movie_no) ON DELETE CASCADE;
ALTER TABLE movie_booking_info ADD CONSTRAINT fk_movie_booking_info_screen_no FOREIGN KEY (screen_no) REFERENCES movie_screen(screen_no) ON DELETE CASCADE;

/*나의 예약 정보 테이블*/
CREATE TABLE book (
	book_no INT AUTO_INCREMENT,
	user_no INT(5) NOT NULL,
	movie_no INT(5) NOT NULL,
	reg_date TIMESTAMP DEFAULT now(),
	PRIMARY KEY (book_no)
);

ALTER TABLE book ADD CONSTRAINT fk_book_movie_no FOREIGN KEY (movie_no) REFERENCES movie(movie_no) ON DELETE CASCADE;
ALTER TABLE book ADD CONSTRAINT fk_book_user_no FOREIGN KEY (user_no) REFERENCES member(user_no) ON DELETE CASCADE;

/*회원 게시판 테이블*/
CREATE TABLE board (
	board_no INT NOT NULL AUTO_INCREMENT,
	title VARCHAR(200) NOT NULL,
	content TEXT,
	writer VARCHAR(50) NOT NULL,
	reg_date TIMESTAMP NOT NULL DEFAULT now(),
	PRIMARY KEY (board_no)
);

/*댓글 테이블*/
CREATE TABLE reply (
	reply_no INT(5) NOT NULL AUTO_INCREMENT,
    board_no INT NOT NULL,
	reply_content VARCHAR(150) NOT NULL,
	reply_writer VARCHAR(50) NOT NULL,
	reg_date TIMESTAMP DEFAULT now(),
	PRIMARY KEY (reply_no, board_no)
);

ALTER TABLE reply ADD CONSTRAINT fk_reply_board_no FOREIGN KEY (board_no) REFERENCES board(board_no) ON DELETE CASCADE;

/*공지사항 테이블*/
CREATE TABLE notice (
	notice_no INT NOT NULL AUTO_INCREMENT,
	title VARCHAR(200) NOT NULL,
	content TEXT,
	reg_date TIMESTAMP NOT NULL DEFAULT now(),
	PRIMARY KEY (notice_no)
);

/*1:1문의 테이블*/
CREATE TABLE inquiry (
	inquiry_no INT NOT NULL AUTO_INCREMENT,
	origin_no INT(10),
	group_ord INT(10) DEFAULT 0,
	group_layer INT(10) DEFAULT 0,
	title VARCHAR(200) NOT NULL,
	content TEXT,
	writer VARCHAR(50) NOT NULL,
	reg_date TIMESTAMP NOT NULL DEFAULT now(),
	PRIMARY KEY (inquiry_no)
);

/*충전 내역 테이블*/
CREATE TABLE change_point_history (
	history_no INT AUTO_INCREMENT,
    user_no INT(5) NOT NULL,
    amount INT(5) NOT NULL,
    reg_date TIMESTAMP DEFAULT now(),
    PRIMARY KEY (history_no)
);

/*지급 내역 테이블*/
CREATE TABLE pay_point_history (
	history_no INT AUTO_INCREMENT,
    user_no INT(5) NOT NULL,
    item_id INT(5) NOT NULL,
    amount INT(5) NOT NULL,
    reg_date TIMESTAMP DEFAULT now(),
    PRIMARY KEY (history_no)
);

/*홍보 배너 테이블*/
CREATE TABLE banner (
	banner_no INT(5) AUTO_INCREMENT,
    movie_no INT(5) NOT NULL,
    banner_name VARCHAR(30) NOT NULL,
    banner_picture_url varchar(200),
	PRIMARY KEY (banner_no)
);

ALTER TABLE banner ADD CONSTRAINT fk_banner_movie_no FOREIGN KEY (movie_no) REFERENCES movie(movie_no) ON DELETE CASCADE;
