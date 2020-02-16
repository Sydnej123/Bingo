-- phpMyAdmin SQL Dump
-- version 4.9.0.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Czas generowania: 16 Lut 2020, 21:51
-- Wersja serwera: 10.4.6-MariaDB
-- Wersja PHP: 7.3.8

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Baza danych: `bingo`
--

-- --------------------------------------------------------

--
-- Struktura tabeli dla tabeli `board`
--

CREATE TABLE `board` (
  `id_board` int(11) NOT NULL,
  `player_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Struktura tabeli dla tabeli `message`
--

CREATE TABLE `message` (
  `id_message` int(11) NOT NULL,
  `content` text DEFAULT NULL,
  `date` date NOT NULL DEFAULT current_timestamp(),
  `room_id` int(11) NOT NULL,
  `player_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Struktura tabeli dla tabeli `number`
--

CREATE TABLE `number` (
  `id_number` int(11) NOT NULL,
  `number` int(11) NOT NULL,
  `board_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Struktura tabeli dla tabeli `player`
--

CREATE TABLE `player` (
  `id_player` int(11) NOT NULL,
  `name` varchar(20) NOT NULL,
  `room_id` int(11) NOT NULL,
  `is_owner` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Struktura tabeli dla tabeli `room`
--

CREATE TABLE `room` (
  `id_room` int(11) NOT NULL,
  `code` varchar(5) NOT NULL,
  `owner_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Indeksy dla zrzutów tabel
--

--
-- Indeksy dla tabeli `board`
--
ALTER TABLE `board`
  ADD PRIMARY KEY (`id_board`),
  ADD KEY `FK_BOARD_PLAYER` (`player_id`);

--
-- Indeksy dla tabeli `message`
--
ALTER TABLE `message`
  ADD PRIMARY KEY (`id_message`),
  ADD KEY `FK_MESSAGE_PLAYER` (`player_id`),
  ADD KEY `FK_MESSAGE_ROOM` (`room_id`);

--
-- Indeksy dla tabeli `number`
--
ALTER TABLE `number`
  ADD PRIMARY KEY (`id_number`),
  ADD KEY `FK_NUMBER_BOARD` (`board_id`);

--
-- Indeksy dla tabeli `player`
--
ALTER TABLE `player`
  ADD PRIMARY KEY (`id_player`),
  ADD KEY `FK_ROOM_PLAYER` (`room_id`);

--
-- Indeksy dla tabeli `room`
--
ALTER TABLE `room`
  ADD PRIMARY KEY (`id_room`),
  ADD KEY `FK_ROOM_OWNER` (`owner_id`);

--
-- Ograniczenia dla zrzutów tabel
--

--
-- Ograniczenia dla tabeli `board`
--
ALTER TABLE `board`
  ADD CONSTRAINT `FK_BOARD_PLAYER` FOREIGN KEY (`player_id`) REFERENCES `player` (`id_player`);

--
-- Ograniczenia dla tabeli `message`
--
ALTER TABLE `message`
  ADD CONSTRAINT `FK_MESSAGE_PLAYER` FOREIGN KEY (`player_id`) REFERENCES `player` (`id_player`),
  ADD CONSTRAINT `FK_MESSAGE_ROOM` FOREIGN KEY (`room_id`) REFERENCES `room` (`id_room`);

--
-- Ograniczenia dla tabeli `number`
--
ALTER TABLE `number`
  ADD CONSTRAINT `FK_NUMBER_BOARD` FOREIGN KEY (`board_id`) REFERENCES `board` (`id_board`);

--
-- Ograniczenia dla tabeli `player`
--
ALTER TABLE `player`
  ADD CONSTRAINT `FK_ROOM_PLAYER` FOREIGN KEY (`room_id`) REFERENCES `room` (`id_room`);

--
-- Ograniczenia dla tabeli `room`
--
ALTER TABLE `room`
  ADD CONSTRAINT `FK_ROOM_OWNER` FOREIGN KEY (`owner_id`) REFERENCES `player` (`id_player`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
