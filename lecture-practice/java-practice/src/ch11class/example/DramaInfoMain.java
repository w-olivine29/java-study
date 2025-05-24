package ch11class.example;

/* 드라마 정보 관리
 * DramaInfo 클래스 만들기
 * 배열에 관리하여
 * 출력
 * */
public class DramaInfoMain {

    public static void main(String[] args) {

        DramaInfo sixDragonsFly = new DramaInfo();
        sixDragonsFly.title = "육룡이 나르샤";
        sixDragonsFly.episodesNum = 50;
        sixDragonsFly.isEnd = true;

        DramaInfo kingTaejongLeeBangWon = new DramaInfo();
        kingTaejongLeeBangWon.title = "태종 이방원";
        kingTaejongLeeBangWon.episodesNum = 32;
        kingTaejongLeeBangWon.isEnd = true;

        DramaInfo[] dramaInfos = {sixDragonsFly, kingTaejongLeeBangWon};

        for (DramaInfo drama : dramaInfos) {
            System.out.printf("제목: %s, 회차: %d, 완결여부: %b \n",
                    drama.title, drama.episodesNum, drama.isEnd);
        }
    }

}
