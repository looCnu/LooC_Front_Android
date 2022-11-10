import com.example.looc.data.LecturePoster
import com.example.looc.data.RegisterDetails
import retrofit2.Call
import retrofit2.http.*

interface  RetrofitInterface {

    @POST("/looC/sign-up")
    fun register(@Body registerDetail : RegisterDetails): Call<RegisterDetails>

    @GET("/looC/lecture")
    fun attachPoster(): Call<ArrayList<LecturePoster>>







}