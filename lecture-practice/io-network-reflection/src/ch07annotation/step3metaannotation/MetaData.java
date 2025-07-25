package ch07annotation.step3metaannotation;

import ch07annotation.step2definition.AnnoElement;

@AnnoMeta // 타입적용
public class MetaData {

    // 컴파일 시점에 @Target 매타 애노테이션을 읽어서 지정한 위치가 맞는지 체크
    
    //@AnnoMeta //'@AnnoMeta' not applicable to field
    private int num;

    @AnnoMeta //메서드 적용
    void call() {
    }

    public static void main(String[] args) throws NoSuchMethodException {
        AnnoMeta typeAnno = MetaData.class.getAnnotation(AnnoMeta.class);
        System.out.println("typeAnno = " + typeAnno);

        AnnoMeta methodAnno = MetaData.class.getDeclaredMethod("call").getAnnotation(AnnoMeta.class);
        System.out.println("methodAnno = " + methodAnno);
    }
}
