package gss.guru.loginnormal.model.repository.network.client;

import io.reactivex.Single;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface ApiService {

    @GET("auth-token")
    Single<String> auth(
            @Header("MOBILE-EMAIL") String email,
            @Header("MOBILE-PASSWORD") String passwd);

    @GET("shopstatus/{objId}")
    Single<String> getShopStatus(
            @Path(value = "objId") Integer objId);

    @GET("shopcheckconnection/{objId}/{maxInterval}")
    Single<Boolean> getShopConnection(
            @Path(value = "objId") Integer objId,
            @Path(value = "maxInterval") Integer maxInterval);

    @POST("/LITEBOX/API/shop-info")
    Single<String> setShopInfo(
            @Query("equipmentHash") String equipmentHash,
            @Query("deviceId") String deviceId,
            @Body String request);
}
