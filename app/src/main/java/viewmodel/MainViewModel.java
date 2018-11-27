package viewmodel;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.MutableLiveData;
import android.support.annotation.NonNull;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.schedulers.Schedulers;
import model.Parameters;
import model.Player;
import request.Repository;

public class MainViewModel extends AndroidViewModel {


    static final String BASE_URL = "https://git.eclipse.org/r/";
    private MutableLiveData<Player> playerDataMutableLiveData = new MutableLiveData<>();
    private MutableLiveData<ArrayList<Parameters>> parametersDataMutableLiveData = new MutableLiveData<>();
    private Repository repository = Repository.getInstance();
    private ArrayList<Parameters> arr_parameters = new ArrayList<>();


    public MainViewModel(@NonNull Application application) {
        super(application);
    }


    public MutableLiveData<ArrayList<Parameters>> getParametersDataMutableLiveData() {
        return parametersDataMutableLiveData;
    }


    public MutableLiveData<Player> getServiceDataMutableLiveData() {
        return playerDataMutableLiveData;
    }


    public void getData(String platform, String user) {
        repository.getPlayerData(platform, user)
                .subscribeOn(Schedulers.io())
                .subscribe(response -> {
                            arr_parameters.add(response.getStats().getP2().getWinRatio());
                            arr_parameters.add(response.getStats().getP2().getScore());
                            arr_parameters.add(response.getStats().getP2().getKpg());
                            arr_parameters.add(response.getStats().getP2().getKills());
                            parametersDataMutableLiveData.postValue(arr_parameters);
                        },
                        error -> Log.d("SERVICE RESPONSE", error.getLocalizedMessage()));


    }
}


