/*
SQLyog Ultimate v11.11 (64 bit)
MySQL - 5.7.13 : Database - demo1
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`demo1` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `demo1`;

/*Table structure for table `authorities` */

DROP TABLE IF EXISTS `authorities`;

CREATE TABLE `authorities` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `uid` int(11) NOT NULL,
  `authority` varchar(200) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `uid` (`uid`),
  CONSTRAINT `authorities_ibfk_1` FOREIGN KEY (`uid`) REFERENCES `users` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=100000031 DEFAULT CHARSET=latin1;

/*Data for the table `authorities` */

insert  into `authorities`(`id`,`uid`,`authority`) values (100000000,100000010,'ROLE_USER'),(100000001,100000011,'ROLE_USER'),(100000002,100000012,'ROLE_USER'),(100000003,100000013,'ROLE_USER'),(100000004,100000014,'ROLE_ADMIN'),(100000005,100000010,'ROLE_ADMIN'),(100000006,100000010,'ROLE_USER'),(100000007,100000011,'ROLE_USER'),(100000008,100000012,'ROLE_USER'),(100000009,100000013,'ROLE_USER'),(100000010,100000014,'ROLE_USER'),(100000011,100000035,'ROLE_USER'),(100000012,100000036,'ROLE_USER'),(100000013,100000037,'ROLE_USER'),(100000014,100000038,'ROLE_USER'),(100000015,100000039,'ROLE_OAUTH'),(100000016,100000040,'ROLE_USER'),(100000017,100000041,'ROLE_USER'),(100000018,100000042,'ROLE_USER'),(100000019,100000043,'ROLE_USER'),(100000020,100000044,'ROLE_USER'),(100000021,100000045,'ROLE_USER'),(100000022,100000046,'ROLE_USER'),(100000023,100000047,'ROLE_USER'),(100000024,100000048,'ROLE_USER'),(100000025,100000049,'ROLE_USER'),(100000026,100000050,'ROLE_USER'),(100000027,100000051,'ROLE_USER'),(100000028,100000052,'ROLE_USER'),(100000029,100000053,'ROLE_USER'),(100000030,100000054,'ROLE_USER');

/*Table structure for table `hibernate_sequence` */

DROP TABLE IF EXISTS `hibernate_sequence`;

CREATE TABLE `hibernate_sequence` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `hibernate_sequence` */

insert  into `hibernate_sequence`(`next_val`) values (1017),(1017),(1017);

/*Table structure for table `oauth_access_token` */

DROP TABLE IF EXISTS `oauth_access_token`;

CREATE TABLE `oauth_access_token` (
  `token_id` varchar(200) NOT NULL,
  `token` blob,
  `authentication_id` varchar(200) DEFAULT NULL,
  `user_name` varchar(100) DEFAULT NULL,
  `client_id` varchar(100) DEFAULT NULL,
  `authentication` blob,
  `refresh_token` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`token_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `oauth_access_token` */

insert  into `oauth_access_token`(`token_id`,`token`,`authentication_id`,`user_name`,`client_id`,`authentication`,`refresh_token`) values ('ce3bf15cd1c7abd834b8f36a168022b2','¨Ì\0sr\0Corg.springframework.security.oauth2.common.DefaultOAuth2AccessToken≤û6$˙Œ\0L\0additionalInformationt\0Ljava/util/Map;L\0\nexpirationt\0Ljava/util/Date;L\0refreshTokent\0?Lorg/springframework/security/oauth2/common/OAuth2RefreshToken;L\0scopet\0Ljava/util/Set;L\0	tokenTypet\0Ljava/lang/String;L\0valueq\0~\0xpsr\0java.util.Collections$EmptyMapY6ÖZ‹Á–\0\0xpsr\0java.util.DatehjÅKYt\0\0xpw\0\0`ÔúaΩxsr\0Lorg.springframework.security.oauth2.common.DefaultExpiringOAuth2RefreshToken/ﬂGcù–…∑\0L\0\nexpirationq\0~\0xr\0Dorg.springframework.security.oauth2.common.DefaultOAuth2RefreshTokens·\ncT‘^\0L\0valueq\0~\0xpt\0$f8a2ce4a-2c0e-4ea4-b3a4-9b0aff252ea2sq\0~\0	w\0\0aâ‰;:xsr\0%java.util.Collections$UnmodifiableSetÄí—èõÄU\0\0xr\0,java.util.Collections$UnmodifiableCollectionB\0ÄÀ^˜\0L\0ct\0Ljava/util/Collection;xpsr\0java.util.LinkedHashSetÿl◊Zï›*\0\0xr\0java.util.HashSet∫DÖïñ∏∑4\0\0xpw\0\0\0?@\0\0\0\0\0t\0readt\0writet\0trustxt\0bearert\0$627daa04-e968-4464-9252-76c59e5cb5c6','af6bdc5339550d9234a5b122e7c53d7e','tim-4','client_1','¨Ì\0sr\0Aorg.springframework.security.oauth2.provider.OAuth2AuthenticationΩ@bR\0L\0\rstoredRequestt\0<Lorg/springframework/security/oauth2/provider/OAuth2Request;L\0userAuthenticationt\02Lorg/springframework/security/core/Authentication;xr\0Gorg.springframework.security.authentication.AbstractAuthenticationToken”™(~nGd\0Z\0\rauthenticatedL\0authoritiest\0Ljava/util/Collection;L\0detailst\0Ljava/lang/Object;xp\0sr\0&java.util.Collections$UnmodifiableList¸%1µÏé\0L\0listt\0Ljava/util/List;xr\0,java.util.Collections$UnmodifiableCollectionB\0ÄÀ^˜\0L\0cq\0~\0xpsr\0java.util.ArrayListxÅ“ô«aù\0I\0sizexp\0\0\0w\0\0\0sr\0Borg.springframework.security.core.authority.SimpleGrantedAuthority\0\0\0\0\0\0ö\0L\0rolet\0Ljava/lang/String;xpt\0\nROLE_OAUTHxq\0~\0psr\0:org.springframework.security.oauth2.provider.OAuth2Request\0\0\0\0\0\0\0\0Z\0approvedL\0authoritiesq\0~\0L\0\nextensionst\0Ljava/util/Map;L\0redirectUriq\0~\0L\0refresht\0;Lorg/springframework/security/oauth2/provider/TokenRequest;L\0resourceIdst\0Ljava/util/Set;L\0\rresponseTypesq\0~\0xr\08org.springframework.security.oauth2.provider.BaseRequest6(z>£qiΩ\0L\0clientIdq\0~\0L\0requestParametersq\0~\0L\0scopeq\0~\0xpt\0client_1sr\0%java.util.Collections$UnmodifiableMapÒ•®˛tıB\0L\0mq\0~\0xpsr\0java.util.HashMap⁄¡√`—\0F\0\nloadFactorI\0	thresholdxp?@\0\0\0\0\0w\0\0\0\0\0\0t\0codet\0Y15IGJt\0\ngrant_typet\0authorization_codet\0\rresponse_typet\0codet\0statet\0tianweit\0redirect_urit\03http://localhost:8082/test0200/oauthCallbackServlett\0\rclient_secrett\0$d3a70507-859f-46dc-92ce-40ecb20f43e8t\0	client_idt\0client_1xsr\0%java.util.Collections$UnmodifiableSetÄí—èõÄU\0\0xq\0~\0	sr\0java.util.LinkedHashSetÿl◊Zï›*\0\0xr\0java.util.HashSet∫DÖïñ∏∑4\0\0xpw\0\0\0?@\0\0\0\0\0t\0readt\0writet\0trustxsq\0~\0-w\0\0\0?@\0\0\0\0\0sq\0~\0\rt\0\nROLE_OAUTHxsq\0~\0\Z?@\0\0\0\0\0\0w\0\0\0\0\0\0\0xt\03http://localhost:8082/test0200/oauthCallbackServletpsq\0~\0-w\0\0\0?@\0\0\0\0\0t\0mobile-resourcet\0client-resourcexsq\0~\0-w\0\0\0?@\0\0\0\0\0q\0~\0!xsr\0Oorg.springframework.security.authentication.UsernamePasswordAuthenticationToken\0\0\0\0\0\0ö\0L\0credentialsq\0~\0L\0	principalq\0~\0xq\0~\0sq\0~\0sq\0~\0\0\0\0w\0\0\0q\0~\0xq\0~\0>sr\0Horg.springframework.security.web.authentication.WebAuthenticationDetails\0\0\0\0\0\0ö\0L\0\rremoteAddressq\0~\0L\0	sessionIdq\0~\0xpt\00:0:0:0:0:0:0:1t\0 D594B8A2530C6A6B5AC6074F32534221psr\0com.tim.spring.model.MyUseré∏UHŸã\0L\0	saltValueq\0~\0xr\02org.springframework.security.core.userdetails.User\0\0\0\0\0\0ö\0Z\0accountNonExpiredZ\0accountNonLockedZ\0credentialsNonExpiredZ\0enabledL\0authoritiesq\0~\0L\0passwordq\0~\0L\0usernameq\0~\0xpsq\0~\0*sr\0java.util.TreeSet›òPìïÌá[\0\0xpsr\0Forg.springframework.security.core.userdetails.User$AuthorityComparator\0\0\0\0\0\0ö\0\0xpw\0\0\0q\0~\0xpt\0tim-4t\0 bc97c873187f8bc08786d6c897d4005c','55d2aa7943d203368a0179e4e07fd261');

/*Table structure for table `oauth_client_details` */

DROP TABLE IF EXISTS `oauth_client_details`;

CREATE TABLE `oauth_client_details` (
  `client_id` varchar(200) NOT NULL COMMENT 'ÂÆ¢Êà∑ID',
  `client_secret` varchar(200) NOT NULL COMMENT 'ÂÆ¢Êà∑ÂØÜÁ†Å',
  `scope` varchar(200) NOT NULL DEFAULT 'read,write,trust' COMMENT 'ÊùÉÈôêËåÉÂõ¥ÔºåÂèØ‰ª•Ëá™ÂÆö‰πâ„ÄÇÂ§ö‰∏™ËåÉÂõ¥Áî®ÈÄóÂè∑„ÄÇ  ‰∏ÄËà¨Êúâ  write,read,trust',
  `authorized_grant_types` varchar(200) NOT NULL DEFAULT 'password,authorization_code,client_credentials,refresh_token,implicit' COMMENT 'ËÆ§ËØÅÊ®°ÂºèÔºåÂèñÂÄºËåÉÂõ¥ÔºåËøôÈáåÁöÑ‰∏ÄÁßçÊàñËÄÖÂ§öÁßçÔºåÁî®ÈÄóÂè∑ÂàÜÈöîÔºö   password,authorization_code,client_credentials,refresh_token,implicit',
  `authorities` varchar(200) NOT NULL DEFAULT 'ROLE_OAUTH' COMMENT 'ÂΩìÂâçËøô‰∏™clientÁöÑÊùÉÈôê',
  `access_token_validity` int(11) NOT NULL DEFAULT '3600' COMMENT 'tokenÊúâÊïàÊúü ÈªòËÆ§3600Áßí',
  `refresh_token_validity` int(11) NOT NULL DEFAULT '3600' COMMENT 'Âà∑Êñ∞tokenÊúâÊïàÊúü',
  `resource_ids` varchar(500) NOT NULL COMMENT 'ÂΩìÂâçclientÊúâÂì™‰∫õËµÑÊ∫ê„ÄÇÂ§ö‰∏™ËµÑÊ∫êÁî®ÈÄóÂè∑ÈöîÂºÄ',
  `autoapprove` varchar(200) DEFAULT NULL COMMENT 'ÈªòËÆ§ÊúâÂì™‰∫õscope Áî®ÈÄóÂè∑ÂàÜÈöîÔºåÂ¶ÇÊûúÊúâÊâÄÊúâscope Áî® true Ë°®Á§∫',
  `web_server_redirect_uri` varchar(500) DEFAULT NULL,
  `additional_information` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`client_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `oauth_client_details` */

insert  into `oauth_client_details`(`client_id`,`client_secret`,`scope`,`authorized_grant_types`,`authorities`,`access_token_validity`,`refresh_token_validity`,`resource_ids`,`autoapprove`,`web_server_redirect_uri`,`additional_information`) values ('client_1','d3a70507-859f-46dc-92ce-40ecb20f43e8','read,write,trust','password,authorization_code,client_credentials,refresh_token,implicit','ROLE_OAUTH',3600,3600,'mobile-resource,client-resource',NULL,NULL,NULL),('client_2','2eb8b32c-7a39-4155-bdd0-df978aeae550','read,write,trust','password,authorization_code,client_credentials,refresh_token,implicit','ROLE_OAUTH',3600,3600,'mobile-resource,client-resource',NULL,NULL,NULL),('client_3','200d398c-1854-40ab-8242-f557a8a7c586','read,write,trust','password,authorization_code,client_credentials,refresh_token,implicit','ROLE_OAUTH',3600,3600,'mobile-resource,client-resource',NULL,NULL,NULL);

/*Table structure for table `oauth_refresh_token` */

DROP TABLE IF EXISTS `oauth_refresh_token`;

CREATE TABLE `oauth_refresh_token` (
  `token_id` varchar(200) NOT NULL,
  `token` blob,
  `authentication` blob,
  PRIMARY KEY (`token_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `oauth_refresh_token` */

insert  into `oauth_refresh_token`(`token_id`,`token`,`authentication`) values ('55d2aa7943d203368a0179e4e07fd261','¨Ì\0sr\0Lorg.springframework.security.oauth2.common.DefaultExpiringOAuth2RefreshToken/ﬂGcù–…∑\0L\0\nexpirationt\0Ljava/util/Date;xr\0Dorg.springframework.security.oauth2.common.DefaultOAuth2RefreshTokens·\ncT‘^\0L\0valuet\0Ljava/lang/String;xpt\0$f8a2ce4a-2c0e-4ea4-b3a4-9b0aff252ea2sr\0java.util.DatehjÅKYt\0\0xpw\0\0aâ‰;:x','¨Ì\0sr\0Aorg.springframework.security.oauth2.provider.OAuth2AuthenticationΩ@bR\0L\0\rstoredRequestt\0<Lorg/springframework/security/oauth2/provider/OAuth2Request;L\0userAuthenticationt\02Lorg/springframework/security/core/Authentication;xr\0Gorg.springframework.security.authentication.AbstractAuthenticationToken”™(~nGd\0Z\0\rauthenticatedL\0authoritiest\0Ljava/util/Collection;L\0detailst\0Ljava/lang/Object;xp\0sr\0&java.util.Collections$UnmodifiableList¸%1µÏé\0L\0listt\0Ljava/util/List;xr\0,java.util.Collections$UnmodifiableCollectionB\0ÄÀ^˜\0L\0cq\0~\0xpsr\0java.util.ArrayListxÅ“ô«aù\0I\0sizexp\0\0\0w\0\0\0sr\0Borg.springframework.security.core.authority.SimpleGrantedAuthority\0\0\0\0\0\0ö\0L\0rolet\0Ljava/lang/String;xpt\0\nROLE_OAUTHxq\0~\0psr\0:org.springframework.security.oauth2.provider.OAuth2Request\0\0\0\0\0\0\0\0Z\0approvedL\0authoritiesq\0~\0L\0\nextensionst\0Ljava/util/Map;L\0redirectUriq\0~\0L\0refresht\0;Lorg/springframework/security/oauth2/provider/TokenRequest;L\0resourceIdst\0Ljava/util/Set;L\0\rresponseTypesq\0~\0xr\08org.springframework.security.oauth2.provider.BaseRequest6(z>£qiΩ\0L\0clientIdq\0~\0L\0requestParametersq\0~\0L\0scopeq\0~\0xpt\0client_1sr\0%java.util.Collections$UnmodifiableMapÒ•®˛tıB\0L\0mq\0~\0xpsr\0java.util.HashMap⁄¡√`—\0F\0\nloadFactorI\0	thresholdxp?@\0\0\0\0\0w\0\0\0\0\0\0t\0codet\0AtbCvTt\0\ngrant_typet\0authorization_codet\0\rresponse_typet\0codet\0statet\0tianweit\0redirect_urit\03http://localhost:8082/test0200/oauthCallbackServlett\0\rclient_secrett\0$d3a70507-859f-46dc-92ce-40ecb20f43e8t\0	client_idt\0client_1xsr\0%java.util.Collections$UnmodifiableSetÄí—èõÄU\0\0xq\0~\0	sr\0java.util.LinkedHashSetÿl◊Zï›*\0\0xr\0java.util.HashSet∫DÖïñ∏∑4\0\0xpw\0\0\0?@\0\0\0\0\0t\0readt\0writet\0trustxsq\0~\0-w\0\0\0?@\0\0\0\0\0sq\0~\0\rt\0\nROLE_OAUTHxsq\0~\0\Z?@\0\0\0\0\0\0w\0\0\0\0\0\0\0xt\03http://localhost:8082/test0200/oauthCallbackServletpsq\0~\0-w\0\0\0?@\0\0\0\0\0t\0mobile-resourcet\0client-resourcexsq\0~\0-w\0\0\0?@\0\0\0\0\0q\0~\0!xsr\0Oorg.springframework.security.authentication.UsernamePasswordAuthenticationToken\0\0\0\0\0\0ö\0L\0credentialsq\0~\0L\0	principalq\0~\0xq\0~\0sq\0~\0sq\0~\0\0\0\0w\0\0\0q\0~\0xq\0~\0>sr\0Horg.springframework.security.web.authentication.WebAuthenticationDetails\0\0\0\0\0\0ö\0L\0\rremoteAddressq\0~\0L\0	sessionIdq\0~\0xpt\00:0:0:0:0:0:0:1t\0 4FD6A3E705332E2EB7AC1C5CBC1B5EC3psr\0com.tim.spring.model.MyUseré∏UHŸã\0L\0	saltValueq\0~\0xr\02org.springframework.security.core.userdetails.User\0\0\0\0\0\0ö\0Z\0accountNonExpiredZ\0accountNonLockedZ\0credentialsNonExpiredZ\0enabledL\0authoritiesq\0~\0L\0passwordq\0~\0L\0usernameq\0~\0xpsq\0~\0*sr\0java.util.TreeSet›òPìïÌá[\0\0xpsr\0Forg.springframework.security.core.userdetails.User$AuthorityComparator\0\0\0\0\0\0ö\0\0xpw\0\0\0q\0~\0xpt\0tim-4t\0 bc97c873187f8bc08786d6c897d4005c');

/*Table structure for table `users` */

DROP TABLE IF EXISTS `users`;

CREATE TABLE `users` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(200) NOT NULL,
  `password` varchar(200) NOT NULL,
  `enabled` tinyint(1) DEFAULT '1',
  `saltValue` varchar(50) DEFAULT NULL,
  `age` int(3) DEFAULT NULL,
  `mobile` varchar(50) DEFAULT NULL,
  `birthday` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=100000055 DEFAULT CHARSET=latin1;

/*Data for the table `users` */

insert  into `users`(`id`,`username`,`password`,`enabled`,`saltValue`,`age`,`mobile`,`birthday`) values (100000010,'u1','acb13da452561dc9d9c70e66b0bd5773',1,'E4774CDDA0793F86414E8B9140BB6DB4',12,'18201997620','2017-07-05 00:00:00'),(100000011,'u2','1',1,'salt1',23,'123123123','2017-07-26 00:00:00'),(100000012,'u3','1',1,'salt11111',32,'222222222','2016-12-29 00:00:00'),(100000013,'u4','1',1,'salt2',1,'333333','2017-08-19 00:00:00'),(100000014,'u5','1',1,'salt3',32,'4444445','2017-02-01 00:00:00'),(100000035,'tim-0','87143951e49773805b4734ccec2d29ea',1,'9be2743106ccab22d3f93b5bb86f1a8b',30,'111111111111','2017-07-20 16:57:18'),(100000036,'tim-1','504cffb16a461e02562a533b9f1d117b',1,'3659424f81aef7138b1bf05a4f185571',24,'111111111111','2017-07-20 16:57:20'),(100000037,'tim-2','67738a7f2eb04661827a8949b9fc1d1c',1,'1d98f523af4579a506910d6afeb2d5b9',24,'111111111111','2017-07-20 16:57:22'),(100000038,'tim-3','40be8841bf72c4ccebc282f25d5e17d0',1,'9f62a9885c15556359b80fac81e5cf67',27,'111111111111','2017-07-20 16:57:24'),(100000039,'tim-4','e2039808f0b9e85ee996b79405d5867b',1,'bc97c873187f8bc08786d6c897d4005c',21,'111111111111','2017-07-20 16:57:26'),(100000040,'tim-5','0662363038b3860df768b0e6180e8e1d',1,'2331383abb302b884ede941a54ec40a9',21,'111111111111','2017-07-20 16:57:28'),(100000041,'tim-6','2b3abd28564ede98127afe30668ccb20',1,'feb947cf2e4e90b40e136cecca522f91',22,'111111111111','2017-07-20 16:57:30'),(100000042,'tim-7','1f9dac52032ba8df88efb1b33be73c66',1,'e2d96cfa93576926d17f99d07cdea0c4',23,'111111111111','2017-07-20 16:57:32'),(100000043,'tim-8','ab928bde727a7deec756c1b18c23dad7',1,'2163c2307a4b2f4557ba4aa95b7cfbda',25,'111111111111','2017-07-20 16:57:34'),(100000044,'tim-9','b43e70c48182f6bc46ccf515b2f9fa04',1,'98a056061d1575a29e7ef86a9180aedb',30,'111111111111','2017-07-20 16:57:36'),(100000045,'tim-10','ce847d512a099514c277ff5725228305',1,'96ff8a254659c4a640e354de6a47384b',25,'111111111111','2017-07-20 16:57:38'),(100000046,'tim-11','99ba9d95954ce1050be3e24c1e42390b',1,'25708d026b1e62e1f66d61e042ffeb51',29,'111111111111','2017-07-20 16:57:40'),(100000047,'tim-12','34776723fbbbaf4f615bf0bcb94cc7ea',1,'83675e6833d5546dd75963288989ca05',20,'111111111111','2017-07-20 16:57:42'),(100000048,'tim-13','c2d5d22aafadf568ad5fb409e8e82f9b',1,'54ef11c63b155633f097da5ff76a00df',23,'111111111111','2017-07-20 16:57:44'),(100000049,'tim-14','c6efb310f292b3e36819bf71652b8d09',1,'eae72ac0641d15fb1b1bacc6e915aa32',22,'111111111111','2017-07-20 16:57:46'),(100000050,'tim-15','aba54d374abf309fd5aa03be78aabbc1',1,'d94cf3e3c9a11522757aa6ff4b912216',30,'111111111111','2017-07-20 16:57:48'),(100000051,'tim-16','90eda26c29f932e88668ae4ab465a37e',1,'7ced11b3b42fdeef3a171f05f1d56f4b',21,'111111111111','2017-07-20 16:57:50'),(100000052,'tim-17','ae3acb20956b0befd3507b467c13dfd7',1,'ed902c748360ff392af7a6826a5dc0f8',20,'111111111111','2017-07-20 16:57:52'),(100000053,'tim-18','fec9df06208ab0564cd171fd7fdd71b7',1,'1ec133f1a11ba633275e5709d1b276f6',25,'111111111111','2017-07-20 16:57:54'),(100000054,'tim-19','7fd54413f77f81ad99656bb8d34a1bcf',1,'b6d15276eb6a0d76f06abc8870db4142',25,'111111111111','2017-07-20 16:57:56');

/*Table structure for table `weather` */

DROP TABLE IF EXISTS `weather`;

CREATE TABLE `weather` (
  `id` bigint(20) NOT NULL,
  `city` varchar(50) DEFAULT NULL,
  `cityCode` varchar(50) DEFAULT NULL,
  `createDateTime` datetime DEFAULT NULL,
  `date` varchar(20) DEFAULT NULL,
  `dayStatus` varchar(50) DEFAULT NULL,
  `maxTemperature` varchar(10) DEFAULT NULL,
  `minTemperature` varchar(10) DEFAULT NULL,
  `nightStatus` varchar(50) DEFAULT NULL,
  `pm25` varchar(10) DEFAULT NULL,
  `qualityStatus` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `weather` */

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
