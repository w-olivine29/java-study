package ch27collection.section8deque.example.ex1;

import java.util.Deque;

//[()<-()<-()<-()<-(current)]
public class BrowserHistory_MySolution {

    private Deque<String> history;
    private String currentPage = null;

    public BrowserHistory_MySolution(Deque<String> history) {
        this.history = history;
    }

    public void visitPage(String url) {
        if (currentPage != null) {
            history.push(currentPage);
        }
        currentPage = url;
        System.out.println("방문: " + url);
    }
    
    public String goBack() {
        if (!history.isEmpty()) {
            currentPage = history.pop();
            System.out.println("뒤로 가기: " + currentPage);
            return currentPage;
        }
        return null;
    }

}