package request;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.List;

import io.reactivex.Flowable;
import model.Player;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface TrnService {

    // GET https://api.fortnitetracker.com/v1/profile/{platform}/{epic-nickname}

    @Headers({"TRN-Api-Key: 66199ccc-8746-4ccb-a3db-15946456a33b"})
    @GET("profile/{platform}/{epic-nickname}")
    Flowable<Player> loadPlayer(@Path("platform") String platform,@Path("epic-nickname") String nickname);

    static TrnService create() {



        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://api.fortnitetracker.com/v1/")
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        return retrofit.create(TrnService.class);
    }

}
