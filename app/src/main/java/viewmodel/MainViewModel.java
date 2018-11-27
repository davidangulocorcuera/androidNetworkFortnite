package viewmodel;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.MutableLiveData;
import android.support.annotation.NonNull;
import android.util.Log;

import io.reactivex.schedulers.Schedulers;
import model.Player;
import request.Repository;

public class MainViewModel extends AndroidViewModel {


    static final String BASE_URL = "https://git.eclipse.org/r/";
    private MutableLiveData <Player> serviceDataMutableLiveData = new MutableLiveData<>();
    private Repository repository = Repository.getInstance();



    public MainViewModel(@NonNull Application application) {
        super(application);
    }


    public MutableLiveData<Player> getServiceDataMutableLiveData() {
        return serviceDataMutableLiveData;
    }

    public void getData(String platform,String user) {
        repository.getPlayerData(platform,user)
                .subscribeOn(Schedulers.io())
                .subscribe(response -> serviceDataMutableLiveData.postValue(response),
                           error -> Log.d("SERVICE RESPONSE", error.getLocalizedMessage()));
    }

}
