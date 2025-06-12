package ch27collection.section8deque.example.ex1;

import java.util.ArrayDeque;

public class BrowserHistoryMain {

    public static void main(String[] args) {
        BrowserHistory_MySolution browser = new BrowserHistory_MySolution(new ArrayDeque<>());
        
        // 방문한 웹페이지
        browser.visitPage("youtube.com");
        browser.visitPage("google.com");
        browser.visitPage("naver.com");
        browser.visitPage("github.com");

        // 뒤로 가기
        String currentPage1 = browser.goBack();
        System.out.println("currentPage1 = " + currentPage1);

        String currentPage2 = browser.goBack();
        System.out.println("currentPage2 = " + currentPage2);
    }
}