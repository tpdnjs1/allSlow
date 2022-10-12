package com.exam.allslow;

public class NullMain {

    public static void main(String[] arg) {
        Runnable r = new Runnable() {
            private int a = 10;

            @Override
            public void run() {
                System.out.println("익명클래스입니다. " + a);
            }
        };

        r.run();

    }


}
