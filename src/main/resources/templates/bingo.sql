-- phpMyAdmin SQL Dump
-- version 4.9.0.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Czas generowania: 17 Lut 2020, 15:25
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

--
-- Zrzut danych tabeli `player`
--

INSERT INTO `player` (`id_player`, `name`, `room_id`, `is_owner`) VALUES
(1, 'name=Fifi', 3, 1),
(2, 'name=Fifi', 4, 1),
(3, 'name=Fifi', 5, 1),
(4, 'name=Fifi', 6, 1),
(5, 'name=Fifi', 7, 1);

-- --------------------------------------------------------

--
-- Struktura tabeli dla tabeli `room`
--

CREATE TABLE `room` (
  `id_room` int(11) NOT NULL,
  `code` varchar(5) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Zrzut danych tabeli `room`
--

INSERT INTO `room` (`id_room`, `code`) VALUES
(3, '3E456'),
(4, '40W65'),
(5, 'C7D7E'),
(6, '25E6Y'),
(7, '5433B');

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
  ADD PRIMARY KEY (`id_room`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT dla tabeli `board`
--
ALTER TABLE `board`
  MODIFY `id_board` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT dla tabeli `message`
--
ALTER TABLE `message`
  MODIFY `id_message` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT dla tabeli `number`
--
ALTER TABLE `number`
  MODIFY `id_number` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT dla tabeli `player`
--
ALTER TABLE `player`
  MODIFY `id_player` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT dla tabeli `room`
--
ALTER TABLE `room`
  MODIFY `id_room` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

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
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
