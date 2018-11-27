package request;


import java.util.List;

import io.reactivex.Flowable;
import model.Player;

public class Repository {
    private static Repository instance;
    private Repository() {
    }

    public static Repository getInstance() {
        if (instance == null){
            synchronized (Repository.class){
                if (instance == null){
                    instance = new Repository();
                }
            }
        }

        return instance;
    }


    private TrnService apiService = TrnService.create();


    public Flowable<Player> getPlayerData(String platform,String nickname) {
        return apiService.loadPlayer(platform,nickname);
    }


}

