package com.example.utils;

import com.example.config.generator.Command;
import com.example.config.generator.Connector;
import com.example.entity.wifi.Ssid;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 *
 */
public class WifiUtil {

    /**
     * 执行器
     *
     * @param cmd      CMD命令
     * @param filePath 需要在哪个目录下执行
     */
    private static List<String> execute(String cmd, String filePath) {
        Process process = null;
        List<String> result = new ArrayList<String>();
        try {
            if (filePath != null) {
                process = Runtime.getRuntime().exec(cmd, null, new File(filePath));
            } else {
                process = Runtime.getRuntime().exec(cmd);
            }
            BufferedReader bReader = new BufferedReader(new InputStreamReader(process.getInputStream(), "gbk"));
            String line = null;
            while ((line = bReader.readLine()) != null) {
                result.add(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }

    /**
     * 列出所有信号较好的ssid
     *
     * @return 所有ssid
     */
    public static List<Ssid> listSsid() {
        List<Ssid> ssidList = new ArrayList<Ssid>();
        String cmd = Command.SHOW_NETWORKS;
        List<String> result = execute(cmd, null);
        System.out.println("原文:"+result);
        if (result != null && result.size() > 0) {

            for (String s : result) {
                Ssid ssid = new Ssid();
                if(s.startsWith("SSID")){
                    String[] split = s.split(" : ");
                    checkSize1(split,ssid);
                }else if(s.contains("加密")){
                    String[] split = s.split(" : ");
                    checkSize2(split,ssid);
                }else if(s.contains("信号")){
                    String[] split = s.split(" : ");
                    checkSize3(split,ssid);
                }
                ssidList.add(ssid);
            }
            //List<String> ssid = result.stream().filter(x -> x.startsWith("SSID")).collect(Collectors.toList());
            //System.out.println("过滤:"+ssid);

        }
        System.out.println("收集的wifi:"+ssidList);
        return ssidList;
    }

    private static void checkSize1(String[] split,Ssid ssid){
        if(split.length==2){
            System.out.println(split[1]);
            ssid.setName(split[1]);
        }
    }

    private static void checkSize2(String[] split,Ssid ssid){
        if(split.length==2){
            System.out.println(split[1]);
            //ssid.setAuth(split[1]);
        }
    }

    private static void checkSize3(String[] split,Ssid ssid){
        if(split.length==2){
            System.out.println(split[1]);
            //ssid.setdB(split[1]);
        }
    }

    /**
     * 校验WLAN配置文件是否正确
     * <p>
     * 校验步骤为：
     * ---step1 添加配置文件
     * ---step3 连接wifi
     * ---step3 ping校验
     */
    public synchronized boolean check(String ssid, String password) {
        System.out.println("check : " + password);
        try {
            String profileName = password + ".xml";
            if (addProfile(profileName)) {
                if (connect(ssid)) {
                    Thread.sleep(50);
                    if (ping()) {
                        return true;
                    }
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return false;
    }

    /**
     * 添加配置文件
     *
     * @param profileName 添加配置文件
     */
    private static boolean addProfile(String profileName) {
        String cmd = Command.ADD_PROFILE.replace("FILE_NAME", profileName);
        List<String> result = execute(cmd, Connector.PROFILE_TEMP_PATH);
        if (result != null && result.size() > 0) {
            if (result.get(0).contains("添加到接口")) {
                return true;
            }
        }
        return false;
    }

    /**
     * 连接wifi
     *
     * @param ssid 添加配置文件
     */
    private static boolean connect(String ssid) {
        boolean connected = false;
        String cmd = Command.CONNECT.replace("SSID_NAME", ssid);
        List<String> result = execute(cmd, null);
        if (result != null && result.size() > 0) {
            if (result.get(0).contains("已成功完成")) {
                connected = true;
            }
        }
        return connected;
    }

    /**
     * ping 校验
     */
    private static boolean ping() {
        boolean pinged = false;
        String cmd = "ping " + Connector.PING_DOMAIN;
        List<String> result = execute(cmd, null);
        if (result != null && result.size() > 0) {
            for (String item : result) {
                if (item.contains("来自")) {
                    pinged = true;
                    break;
                }
            }
        }
        return pinged;
    }

    public static void main(String[] args) {
        System.out.println(listSsid());
    }
}
