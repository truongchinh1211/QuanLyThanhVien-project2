/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utils;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 *
 * @author Son
 */
public class DateTimeUtils {
    // Định dạng mặc định cho LocalDateTime
    private static final DateTimeFormatter DEFAULT_FORMATTER = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");

    // Chuyển đổi LocalDateTime thành chuỗi với định dạng mặc định
    public static String format(LocalDateTime dateTime) {
        if(dateTime == null)
            return null;
        return format(dateTime, DEFAULT_FORMATTER);
    }

    // Chuyển đổi LocalDateTime thành chuỗi với định dạng được chỉ định
    public static String format(LocalDateTime dateTime, DateTimeFormatter formatter) {
        if(dateTime == null)
            return null;
        return dateTime.format(formatter);
    }

    // Chuyển đổi chuỗi thành LocalDateTime với định dạng mặc định
    public static LocalDateTime parse(String str) {
        return parse(str, DEFAULT_FORMATTER);
    }

    // Chuyển đổi chuỗi thành LocalDateTime với định dạng được chỉ định
    public static LocalDateTime parse(String str, DateTimeFormatter formatter) {
        return LocalDateTime.parse(str, formatter);
    }
}