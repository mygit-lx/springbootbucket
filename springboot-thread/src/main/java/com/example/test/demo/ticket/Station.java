package com.example.test.demo.ticket;

/**
 *
 */
public class Station extends Thread{

    public Station(String name){
        super(name);
    }

    public static int ticketNum = 20;//总票数

    public static Object ob = "aa";//静态的钥匙

    @Override
    public void run() {
        while (ticketNum>0 || ticketNum ==0){
            synchronized (ob){
                if(ticketNum>0){
                    System.out.println(getName()+"卖了第"+ticketNum+"张票");
                    ticketNum--;
                }else{
                    System.out.println("票卖完了");
                    ticketNum--;
                }
            }
            try {
                sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }


}
