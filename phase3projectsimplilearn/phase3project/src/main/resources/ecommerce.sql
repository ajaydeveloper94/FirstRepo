-- phpMyAdmin SQL Dump
-- version 5.0.2
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Dec 27, 2020 at 04:36 PM
-- Server version: 10.4.11-MariaDB
-- PHP Version: 7.2.30

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `ecommerce`
--

-- --------------------------------------------------------

--
-- Table structure for table `cart`
--

CREATE TABLE `cart` (
  `cart_id` int(11) NOT NULL,
  `user_id` int(11) NOT NULL,
  `product_id` int(11) NOT NULL,
  `qty` int(11) NOT NULL,
  `product_size` varchar(1000) NOT NULL,
  `product_color` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `cart`
--

INSERT INTO `cart` (`cart_id`, `user_id`, `product_id`, `qty`, `product_size`, `product_color`) VALUES
(9, 38, 1, 10, '9', 'Navy Blue');

-- --------------------------------------------------------

--
-- Table structure for table `child_category`
--

CREATE TABLE `child_category` (
  `child_cat_id` int(11) NOT NULL,
  `child_cat_name` varchar(100) NOT NULL,
  `parent_cat_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `child_category`
--

INSERT INTO `child_category` (`child_cat_id`, `child_cat_name`, `parent_cat_id`) VALUES
(1, 'Sport Shoes', 1),
(2, 'Casual Shoes', 1);

-- --------------------------------------------------------

--
-- Table structure for table `main_parent_category`
--

CREATE TABLE `main_parent_category` (
  `main_parent_cat_id` int(11) NOT NULL,
  `main_parent_cat_name` varchar(200) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `main_parent_category`
--

INSERT INTO `main_parent_category` (`main_parent_cat_id`, `main_parent_cat_name`) VALUES
(1, 'Footwear');

-- --------------------------------------------------------

--
-- Table structure for table `parent_category`
--

CREATE TABLE `parent_category` (
  `parent_cat_id` int(11) NOT NULL,
  `parent_cat_name` varchar(100) NOT NULL,
  `main_parent_cat_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `parent_category`
--

INSERT INTO `parent_category` (`parent_cat_id`, `parent_cat_name`, `main_parent_cat_id`) VALUES
(1, 'Mens Footwear', 1),
(2, 'Womens Footwear', 1);

-- --------------------------------------------------------

--
-- Table structure for table `products`
--

CREATE TABLE `products` (
  `product_id` int(11) NOT NULL,
  `product_code` varchar(20) NOT NULL,
  `product_name` varchar(100) NOT NULL,
  `product_price` int(11) DEFAULT NULL,
  `selling_price` int(11) NOT NULL,
  `product_quantity` int(11) NOT NULL,
  `product_size` varchar(1000) NOT NULL,
  `product_color_name` varchar(100) NOT NULL,
  `product_description` text NOT NULL,
  `main_parent_cat_id` int(11) NOT NULL,
  `parent_cat_id` int(11) NOT NULL,
  `child_cat_id` int(11) NOT NULL,
  `product_images` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `products`
--

INSERT INTO `products` (`product_id`, `product_code`, `product_name`, `product_price`, `selling_price`, `product_quantity`, `product_size`, `product_color_name`, `product_description`, `main_parent_cat_id`, `parent_cat_id`, `child_cat_id`, `product_images`) VALUES
(1, 'PRD1', 'Puma Men Navy Blue Mesh Running Shoes', 4000, 2000, 10, '9', 'Navy Blue', 'A pair of navy blue & orange running sports shoes, has regular styling, lace-up detail\r\nMesh upper\r\nCushioned footbed\r\nTextured and patterned outsole\r\nWarranty: 3 months\r\nWarranty provided by brand/manufacturer', 1, 1, 1, 'puma-sports-prd1-1.webp,puma-sports-prd1-2.webp,'),
(2, 'PRD2', 'HRX by Hrithik Roshan\r\nWomen Pink Woven Design Metalite Running Shoes', 5000, 2999, 1000, '7', 'pink', 'The HRX Performance Running Shoes from the Metalite Collection don\'t just hold your feet snugly as you run; they provide lateral support and stability too. These ultra lightweight shoes are just what you need to break your records.', 1, 2, 1, 'hrx-sports-prd2-1.jpg,hrx-sports-prd2-2.webp,'),
(3, 'PRD3', 'Nike\r\nWomen Black CITY TRAINER Training Shoes', 4995, 3999, 100, '8', 'black', 'A pair of black training sports shoes, has lace-up detail\r\nTextile and mesh upper\r\nNike Comfort footbed\r\nTextured and patterned outsole\r\nWarranty: 6 months\r\nWarranty provided by Brand Owner / Manufacturer\r\n(warranty not valid on products with more than 20% discount)', 1, 2, 1, 'nike-sports-prd3-1.webp,nike-sports-prd3-2.webp,'),
(4, 'PRD4', 'U.S. Polo Assn Men Navy Blue Slip-On Sneakers', 2999, 1999, 100, '8', 'blue', 'A pair of round-toe navy blue slip-on sneakers, has regular styling, slip-on detail\r\nTextile upper\r\nCushioned footbed\r\nTextured and patterned outsole\r\nWarranty: 3 months\r\nWarranty provided by brand/manufacturer', 1, 1, 2, 'uspolo-casual-prd4-1.webp,uspolo-casual-prd4-2.webp,'),
(5, 'PRD5', 'DressBerry Women Lavender Slip-On Sneakers', 1899, 1225, 100, '7', 'lavender', 'A pair of round-toe lavender slip-on sneakers with applique detail, has regular styling, slip-on detail\r\nSynthetic upper\r\nCushioned footbed\r\nTextured and patterned outsole\r\nWarranty: 1 month\r\nWarranty provided by brand/manufacturer', 1, 2, 2, 'dressberry-casual-prd5-1.webp,dressberry-casual-prd5-2.webp,');

-- --------------------------------------------------------

--
-- Table structure for table `users`
--

CREATE TABLE `users` (
  `usersId` int(11) NOT NULL,
  `firstName` varchar(200) NOT NULL,
  `lastName` varchar(100) NOT NULL,
  `email` varchar(200) NOT NULL,
  `phone` varchar(13) NOT NULL,
  `gender` varchar(10) NOT NULL,
  `password` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `users`
--

INSERT INTO `users` (`usersId`, `firstName`, `lastName`, `email`, `phone`, `gender`, `password`) VALUES
(38, 'Dharanidharan', 'P', 'dd141096@gmail.com', '9092900277', 'male', '123456'),
(39, 'Admin', 'boy', 'admin@sportyshoes.com', '9876543210', 'others', '12345');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `cart`
--
ALTER TABLE `cart`
  ADD PRIMARY KEY (`cart_id`),
  ADD UNIQUE KEY `user_id` (`user_id`,`product_id`);

--
-- Indexes for table `child_category`
--
ALTER TABLE `child_category`
  ADD PRIMARY KEY (`child_cat_id`);

--
-- Indexes for table `main_parent_category`
--
ALTER TABLE `main_parent_category`
  ADD PRIMARY KEY (`main_parent_cat_id`);

--
-- Indexes for table `parent_category`
--
ALTER TABLE `parent_category`
  ADD PRIMARY KEY (`parent_cat_id`);

--
-- Indexes for table `products`
--
ALTER TABLE `products`
  ADD PRIMARY KEY (`product_id`);

--
-- Indexes for table `users`
--
ALTER TABLE `users`
  ADD PRIMARY KEY (`usersId`),
  ADD UNIQUE KEY `email` (`email`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `cart`
--
ALTER TABLE `cart`
  MODIFY `cart_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=28;

--
-- AUTO_INCREMENT for table `child_category`
--
ALTER TABLE `child_category`
  MODIFY `child_cat_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `main_parent_category`
--
ALTER TABLE `main_parent_category`
  MODIFY `main_parent_cat_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT for table `parent_category`
--
ALTER TABLE `parent_category`
  MODIFY `parent_cat_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `products`
--
ALTER TABLE `products`
  MODIFY `product_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT for table `users`
--
ALTER TABLE `users`
  MODIFY `usersId` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=40;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
