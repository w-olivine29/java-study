package mission.week3.optionaltask.task1lotto;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.UUID;


// 41기 유도경
public class LottoUser {

    private String userID;
    private List<Lotto> lottos;

    public LottoUser() {
        this.userID = generateUserID();
    }

    public String getUserID() {
        return userID;
    }
    
    public List<Lotto> getLottos() {
        return new ArrayList<>(lottos); // 변경을 막기위해 데이터를 복사한 새 리스트로 반환
    }

    public void setLottos(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    private String generateUserID() {
        return "USER-" + UUID.randomUUID();
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        LottoUser lottoUser = (LottoUser) o;
        return Objects.equals(userID, lottoUser.userID);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(userID);
    }
}
