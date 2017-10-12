CREATE DATABASE `imagement` /*!40100 DEFAULT CHARACTER SET latin1 */;

USE `imagement`;

CREATE TABLE `users` (
  `id` int(3) NOT NULL AUTO_INCREMENT,
  `username` varchar(64) NOT NULL,
  `email` varchar(64) NOT NULL,
  `password` varchar(64) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8;

CREATE TABLE `images` (
  `id` int(3) NOT NULL AUTO_INCREMENT,
  `title` varchar(64) NOT NULL,
  `description` varchar(64) NOT NULL,
  `user_id` int(10) DEFAULT NULL,
  `file` blob,
  PRIMARY KEY (`id`),
  KEY `user_id` (`user_id`),
  CONSTRAINT `images_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`) ON DELETE SET NULL
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

CREATE TABLE `taggers` (
  `id` int(11) NOT NULL,
  `image_id` int(11) NOT NULL,
  `tag_id` int(3) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_taggers_2_idx` (`tag_id`),
  KEY `fk_taggers_1_idx` (`image_id`),
  CONSTRAINT `fk_taggers_1` FOREIGN KEY (`image_id`) REFERENCES `images` (`id`) ON DELETE NO ACTION,
  CONSTRAINT `fk_taggers_2` FOREIGN KEY (`tag_id`) REFERENCES `tags` (`id`) ON DELETE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

CREATE TABLE `tags` (
  `id` int(3) NOT NULL AUTO_INCREMENT,
  `tagword` varchar(64) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

INSERT INTO `imagement`.`users` (`id`, `username`, `email`, `password`) VALUES ('1', 'yauhenav', 'yauhenav@testmail.com', 'Mypassword1');
INSERT INTO `imagement`.`users` (`id`, `username`, `email`, `password`) VALUES ('2', 'monalina', 'monalina@testmail.com', 'Mypassword2');
INSERT INTO `imagement`.`users` (`id`, `username`, `email`, `password`) VALUES ('11', 'lilula', 'lilula@testmail.com', 'Mypassword3');

INSERT INTO `imagement`.`images` (`id`, `title`, `description`, `user_id`) VALUES ('1', 'my_portrait', 'Me looking over horizons', '1');
INSERT INTO `imagement`.`images` (`id`, `title`, `description`, `user_id`) VALUES ('2', 'africa_animal', 'Elephant walking around the road in Africa', '1');
INSERT INTO `imagement`.`images` (`id`, `title`, `description`, `user_id`) VALUES ('3', 'animal_four', 'Another animal in Africa', '1');

INSERT INTO `imagement`.`tags` (`id`, `tagword`) VALUES ('1', 'human');
INSERT INTO `imagement`.`tags` (`id`, `tagword`) VALUES ('2', 'tree');
INSERT INTO `imagement`.`tags` (`id`, `tagword`) VALUES ('3', 'house');
INSERT INTO `imagement`.`tags` (`id`, `tagword`) VALUES ('4', 'elephant');
INSERT INTO `imagement`.`tags` (`id`, `tagword`) VALUES ('5', 'dog');

INSERT INTO `imagement`.`taggers` (`id`, `image_id`, `tag_id`) VALUES ('1', '1', '1');
INSERT INTO `imagement`.`taggers` (`id`, `image_id`, `tag_id`) VALUES ('2', '1', '2');
INSERT INTO `imagement`.`taggers` (`id`, `image_id`, `tag_id`) VALUES ('3', '1', '3');
INSERT INTO `imagement`.`taggers` (`id`, `image_id`, `tag_id`) VALUES ('4', '1', '4');
INSERT INTO `imagement`.`taggers` (`id`, `image_id`, `tag_id`) VALUES ('5', '1', '5');
INSERT INTO `imagement`.`taggers` (`id`, `image_id`, `tag_id`) VALUES ('6', '2', '4');
INSERT INTO `imagement`.`taggers` (`id`, `image_id`, `tag_id`) VALUES ('7', '2', '3');
