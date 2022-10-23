-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- 생성 시간: 22-10-24 00:13
-- 서버 버전: 10.4.25-MariaDB
-- PHP 버전: 8.1.10

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- 데이터베이스: `allslow`
--

-- --------------------------------------------------------

--
-- 테이블 구조 `exercise_calorie`
--

CREATE TABLE `exercise_calorie` (
  `type` char(15) NOT NULL,
  `calorie` float NOT NULL COMMENT '1분 기준 kcal'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- 테이블의 덤프 데이터 `exercise_calorie`
--

INSERT INTO `exercise_calorie` (`type`, `calorie`) VALUES
('가볍게 걷기', 3),
('빠르게 걷기', 5),
('요가', 2.5),
('볼링', 3.3),
('스트레칭 체조', 2.9),
('자전거타기', 4.4),
('등산', 5),
('춤추기', 4.8),
('승마', 5.76),
('탁구', 6),
('테니스', 7.2),
('배드민턴', 5.76),
('배구', 7),
('축구', 9),
('농구', 9.3),
('스키', 8.2),
('에어로빅', 5.9),
('팔굽혀펴기', 4.2),
('계단 오르내리기', 5.8),
('윗몸 일으키기', 10.1),
('핸드볼', 10),
('줄넘기', 10.4),
('격렬한 달리기', 10.5),
('수영', 12);

-- --------------------------------------------------------

--
-- 테이블 구조 `user`
--

CREATE TABLE `user` (
  `uid` int(11) NOT NULL,
  `id` varchar(20) NOT NULL,
  `pw` varchar(20) NOT NULL,
  `name` char(8) NOT NULL,
  `sex` char(2) NOT NULL,
  `age` int(11) NOT NULL,
  `tall` int(11) NOT NULL,
  `weight` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- 테이블의 덤프 데이터 `user`
--

INSERT INTO `user` (`uid`, `id`, `pw`, `name`, `sex`, `age`, `tall`, `weight`) VALUES
(1, 'testid', 'testpw', 'test', '남성', 30, 170, 65),
(2, 'id', 'pw', 'name', '여성', 17, 140, 40),
(3, '1234', '12345', '1234', '여성', 123, 1234, 134);

--
-- 덤프된 테이블의 인덱스
--

--
-- 테이블의 인덱스 `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`uid`),
  ADD UNIQUE KEY `id` (`id`);

--
-- 덤프된 테이블의 AUTO_INCREMENT
--

--
-- 테이블의 AUTO_INCREMENT `user`
--
ALTER TABLE `user`
  MODIFY `uid` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
