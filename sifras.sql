-- phpMyAdmin SQL Dump
-- version 4.6.5.2
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: 04-Out-2017 às 15:03
-- Versão do servidor: 5.7.18
-- PHP Version: 5.6.30

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `sifras`
--

-- --------------------------------------------------------

--
-- Estrutura da tabela `clients`
--

CREATE TABLE `clients` (
  `id` varchar(50) NOT NULL,
  `name` varchar(500) NOT NULL,
  `phone` varchar(300) NOT NULL,
  `email` varchar(350) NOT NULL,
  `obs` tinytext NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Extraindo dados da tabela `clients`
--

INSERT INTO `clients` (`id`, `name`, `phone`, `email`, `obs`) VALUES
('201609070945439997', 'Customer Number One', '55 9999-9999', 'customer@fakeemail.com', '');

-- --------------------------------------------------------

--
-- Estrutura da tabela `posts`
--

CREATE TABLE `posts` (
  `id` varchar(50) NOT NULL,
  `titulo` varchar(500) NOT NULL,
  `conteudo` text NOT NULL,
  `users_id` varchar(50) NOT NULL,
  `datacad` datetime NOT NULL,
  `permitecomentario` tinyint(1) NOT NULL DEFAULT '1'
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Extraindo dados da tabela `posts`
--

INSERT INTO `posts` (`id`, `titulo`, `conteudo`, `users_id`, `datacad`, `permitecomentario`) VALUES
('767567567', 'Um post Qualquer', 'Um conteudo muito  legal aqui...! \r\n\r\nha =]', '', '2017-09-27 00:00:00', 1),
('201710040937557072', 'uiyui', '		\r\n	yui	', '1', '2017-10-04 09:55:37', 1),
('201710040957576519', 'Com coment', 'oi		\r\n		', '1', '2017-10-04 09:57:57', 1);

-- --------------------------------------------------------

--
-- Estrutura da tabela `profiles`
--

CREATE TABLE `profiles` (
  `id` varchar(50) NOT NULL,
  `name` varchar(50) NOT NULL,
  `permissions` varchar(500) NOT NULL,
  `obs` tinytext NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Extraindo dados da tabela `profiles`
--

INSERT INTO `profiles` (`id`, `name`, `permissions`, `obs`) VALUES
('2', 'admin', '*', ''),
('3', 'manager', '', ''),
('4', 'user', '', ''),
('5', 'guest', 'index.*', '');

-- --------------------------------------------------------

--
-- Estrutura da tabela `users`
--

CREATE TABLE `users` (
  `id` varchar(50) NOT NULL,
  `email` varchar(350) NOT NULL,
  `username` varchar(100) NOT NULL,
  `password` varchar(50) NOT NULL,
  `profile_id` int(11) NOT NULL,
  `name` varchar(400) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Extraindo dados da tabela `users`
--

INSERT INTO `users` (`id`, `email`, `username`, `password`, `profile_id`, `name`) VALUES
('1', 'u@umail.com', 'admin', 'admin', 2, 'Administrator'),
('2', 'u@u.com', 'user', 'user', 4, 'User');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `profiles`
--
ALTER TABLE `profiles`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `users`
--
ALTER TABLE `users`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `email` (`email`,`username`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
