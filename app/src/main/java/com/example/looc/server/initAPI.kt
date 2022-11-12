import com.example.looc.data.*
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.*

interface  RetrofitInterface {

    @POST("sign-up")
    fun register(@Body registerDetail : RegisterDetails): Call<RegisterResult>

    @POST("sign-in")
    fun login(@Body loginData: LoginData):Call<LoginResult>

    @GET("lectures3")
    suspend fun getLoocLectures(): Response<List<LectureDetailItem>>

    @GET("lectures")
    suspend fun getSportLectures(): Response<List<LectureDetailItem>>

    @GET("lectures1")
    suspend fun getDepartmentLectures(): Response<List<LectureDetailItem>>

    @GET("lectures2")
    suspend fun getOfflineLectures(): Response<List<LectureDetailItem>>







}