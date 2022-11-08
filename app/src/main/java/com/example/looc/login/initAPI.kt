import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.POST

interface  RetrofitInterface {

    @FormUrlEncoded
    @POST("/looC/sign-up")
    fun requestLogin(
        @Field("student_id") studentId:String,
        @Field("password") password: String
    )
}