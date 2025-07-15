package ch02io.sub1basic.section2fileio.step2optimization;

public class BufferedConst {

    public static final String FILE_NAME = "io-network-reflection/temp/buffered.dat";
    public static final int FILE_SIZE = 10 * 1024 * 1024; // 10MB  (1024 바이트 * 1024 = 메가바이트)

    // 버퍼 사이즈에 따른 쓰기 성능 비교
    public static final int BUFFER_SIZE = 8192;



    private BufferedConst() {
    }
}
