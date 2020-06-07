

INSERT INTO IotBayAdmin.AccessLogs (visitid,userid,loginTime) VALUES (1,6,'hello');

/*UPDATE IotBayAdmin.AccessLogs SET LOGOUTTIME = ' hello there ', VISITID = 1 WHERE VISITID = (SELECT MAX(VISITID) FROM IOTBAYADMIN.ACCESSLOGS);