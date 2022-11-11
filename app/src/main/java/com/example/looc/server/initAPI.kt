import com.example.looc.data.*
import retrofit2.Call
import retrofit2.http.*

interface  RetrofitInterface {

    @POST("sign-up")
    fun register(@Body registerDetail : RegisterDetails): Call<RegisterResult>

    @POST("sign-in")
    fun login(@Body loginData: LoginData):Call<LoginResult>

    @GET("lectures")
    fun getLectures(): Call<ArrayList<LectureDetailItem>>







}