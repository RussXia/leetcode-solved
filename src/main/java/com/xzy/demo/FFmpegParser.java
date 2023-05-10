package com.xzy.demo;

import org.apache.commons.exec.ExecuteWatchdog;
import org.apache.commons.io.IOUtils;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.StringJoiner;
import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * <a href="https://mvnrepository.com/artifact/org.apache.commons/commons-exec">commons-exec</a>
 * <p>
 * <a href="https://mvnrepository.com/artifact/commons-io/commons-io">commons-io</a>
 * <p>
 * User: RuzzZZ
 * Date: 2023/5/4
 * Time: 15:19
 */
public class FFmpegParser {

    public static void main(String[] args) throws IOException, InterruptedException {
        String input_file = "/Users/xmly/Downloads/251948/251948-orig-61.flv";
        String output = executeFFmpegCommand("ffmpeg -i " + input_file, 100);
        System.out.println("output:" + output);
        String duration = extractValueFromRegexPattern(output, "Duration: (\\d\\d):(\\d\\d):(\\d\\d\\.\\d\\d),");
        String bit_rate = extractValueFromRegexPattern(output, "bitrate: (\\d+) kb/s");
        String file_format = extractValueFromRegexPattern(output, "Input #0, (.*),");
        System.out.println("Duration: " + duration);
        System.out.println("Bit rate: " + bit_rate);
        System.out.println("File format: " + file_format);
    }

    private static String executeFFmpegCommand(String command, int timeoutInSeconds) throws IOException, InterruptedException {
        ProcessBuilder processBuilder = new ProcessBuilder(command.split(" "));
        processBuilder.redirectErrorStream(true);
        Process process = processBuilder.start();
        ExecuteWatchdog watchdog = new ExecuteWatchdog(TimeUnit.SECONDS.toMillis(timeoutInSeconds));
        watchdog.start(process);
        String output = IOUtils.toString(process.getInputStream(), StandardCharsets.UTF_8);
        process.waitFor();
        return output;
    }

    private static String extractValueFromRegexPattern(String text, String regex) {
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(text);
        while (matcher.find()) {
            int matchCount = matcher.groupCount();
            String[] matches = new String[matchCount];
            for (int i = 1; i <= matchCount; i++) {
                matches[i - 1] = matcher.group(i).trim();
            }
            StringJoiner stringJoiner = new StringJoiner("-");
            return String.join("-", matches);
        }
        return "";
    }
}
