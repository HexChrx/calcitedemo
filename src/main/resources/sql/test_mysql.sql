
--
-- Database: `test_mysql`
--

-- --------------------------------------------------------

--
-- Table structure for table `depts`
--

CREATE TABLE `depts` (
                         `id` bigint(20) NOT NULL,
                         `USER_ID` int(11) DEFAULT '0',
                         `NAME` varchar(15) NOT NULL DEFAULT ''
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
--
-- Dumping data for table `depts`
--

INSERT INTO `depts` (`id`, `USER_ID`, `NAME`) VALUES
(1, 0, 'dep1'),
(2, 1, 'dep1'),
(3, 2, 'dep2'),
(4, 3, 'dep2');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `depts`
--
ALTER TABLE `depts`
    ADD PRIMARY KEY (`id`),
  ADD KEY `user_id` (`USER_ID`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `depts`
--
ALTER TABLE `depts`
    MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;
COMMIT;

