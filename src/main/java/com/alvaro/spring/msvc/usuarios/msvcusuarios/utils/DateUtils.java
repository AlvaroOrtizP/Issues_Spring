package com.alvaro.spring.msvc.usuarios.msvcusuarios.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

public class DateUtils {
    final static ZoneId ZONEID = ZoneId.of("Europe/Madrid");
    private static final Logger logger = LoggerFactory.getLogger(DateUtils.class);

    public static Date convertDateTimeDbToDomain(BigDecimal date) {
        if (date == null) return null;
        return convertDateTimeDbToDomain(date.intValue(), 0, false);
    }

    public static Date convertDateTimeDbToDomain(BigDecimal date, BigDecimal time, boolean endZero) {
        if (date == null) return null;
        if (time == null) return convertDateTimeDbToDomain(date.intValue(), 0, endZero);
        else return convertDateTimeDbToDomain(date.intValue(), time.intValue(), endZero);
    }

    public static Date convertDateTimeDbToDomain(int date, int time, boolean endZero) {
        if (date == 0) return null;
        if (endZero) {
            time = time / 10;
        }
        String fecha = String.format("%07d%06d", date, time);
        SimpleDateFormat formatter = new SimpleDateFormat("yyyyDDDHHmmss");
        try {
            return formatter.parse(fecha);
        } catch (
                ParseException e) { // Traza de error
            logger.error("EXC. en convertDateTimeDbToDomain(" + fecha + ")", e);
            return null;
        }
    }

    /**
     * Obtiene la fecha de un date * * @param date obtenida * @return obtiene unicamente la fecha del date
     */

    public static BigDecimal convertDomainDateToDB(Date date) {
        if (date == null) {
            return BigDecimal.ZERO;
        }
        SimpleDateFormat formatter = new SimpleDateFormat("yyyyDDD");
        return new BigDecimal(Integer.parseInt(formatter.format(date)));
    }

    /**
     * Obtiene el time de un date * * @param date obtenido * @param endZero se añade un 0 en caso de ser true * @return solo el time de la fecha /
     *
     * @param date
     * @param endZero
     * @return
     */
    public static BigDecimal convertDomainTimeToDB(Date date, boolean endZero) {
        if (date == null) {
            return BigDecimal.ZERO;
        }
        SimpleDateFormat formatter = new SimpleDateFormat("HHmmss");
        return new BigDecimal(Integer.parseInt(formatter.format(date) + (endZero ? "0" : "")));
    }

    public static Date now() {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMddHHmmss");
        Date date = null;
        try {
            date = formatter.parse(formatter.format(nowWithMiliseconds()));
        } catch (
                Exception e) { // No puede pasar nunca
        }
        return date;
    }

    /**
     * @return la fecha de hoy sin milisegundos
     */

    public static Date nowWithMiliseconds() {
        LocalDateTime now = LocalDateTime.now(ZONEID);
        return java.sql.Timestamp.valueOf(now);
    } // Devuelve expireDateDB11 si esta no es una fecha vencida (según now), en caso contrario devuelve requestDate.

    public static Date getRequestDate(BigDecimal expireDateDB, Date requestDate, Date now) {
        logger.debug("getRequestDate(" + expireDateDB + ", " + requestDate + ", " + now + ") ...");
        // Puede venir de BD a 0
        if (expireDateDB == null || expireDateDB.compareTo(BigDecimal.ZERO) == 0) {
            return requestDate;
        } else {
            try {
                Date expireDate = convertDateTimeDbToDomain(expireDateDB);
                Date expireDateTime = convertDateTimeDbToDomain(expireDateDB, new BigDecimal(100000), false);
                Date nowOnlyDate = null;
                SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMdd");
                nowOnlyDate = formatter.parse(formatter.format(now));
                if (expireDate != null && expireDate.compareTo(nowOnlyDate) >= 0) {
                    logger.debug("... DateUtils.getRequestDate() --> ".concat(expireDate.toString()));
                    return expireDateTime;
                } else {
                    logger.debug("... DateUtils.getRequestDate() --> ".concat(requestDate.toString()));
                    return requestDate;
                }
            } catch (Exception e) {
                logger.error(e.getMessage());
                return null;
            }
        }
    }

    static public int onlyDateCompare(Date date1, Date date2) {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMdd");
        logger.debug("onlyDateCompare(" + date1 + ", " + date2 + ") ...");
        if (date1 == null) {
            return -1;
        }
        if (date2 == null) {
            return 1;
        }
        int res = 0;
        Date onlyDate1 = date1;
        try {
            onlyDate1 = formatter.parse(formatter.format(date1));
        } catch (
                ParseException e) { // No puede pasar
        }
        Date onlyDate2 = date2;
        try {
            onlyDate2 = formatter.parse(formatter.format(date2));
        } catch (
                ParseException e) { // No puede pasar
        }
        res = onlyDate1.compareTo(onlyDate2);
        logger.debug("... DateUtils.onlyDateCompare() --> " + res);
        return res;
    }
}

