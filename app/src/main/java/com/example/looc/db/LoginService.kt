import com.example.looc.db.DataModal
import com.example.looc.db.Login
import retrofit2.Call
import retrofit2.http.*

interface  LoginService {

    @POST("/looC/sign-up/")
    fun requestLogin(@Body dataModal : DataModal?): Call<Login>
}