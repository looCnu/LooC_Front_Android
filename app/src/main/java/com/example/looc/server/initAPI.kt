import com.example.looc.data.LecturePoster
import com.example.looc.data.LoginData
import com.example.looc.data.RegisterDetails
import retrofit2.Call
import retrofit2.http.*

interface  RetrofitInterface {

    @POST("sign-up")
    fun register(@Body registerDetail : RegisterDetails): Call<RegisterDetails>

    @POST("/sign-in/looC")
    fun login(@Body loginData: LoginData):Call<LoginData>

    @GET("/looC/lecture")
    fun attachPoster(): Call<ArrayList<LecturePoster>>







}