package com.example.looc.viewmodel

import RetrofitInterface
import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.looc.data.LectureDetailItem
import com.example.looc.server.RetrofitClient
import io.reactivex.plugins.RxJavaPlugins
import kotlinx.coroutines.*
import retrofit2.HttpException

class ListViewModel: ViewModel() {


    val lecturesLoadError = MutableLiveData<String?>()
    val loading = MutableLiveData<Boolean>()



    val retrofit = RetrofitClient.retrofit
    var job1: Job? = null
    var job2: Job? = null
    var job3: Job? = null
    var job4: Job? = null

    val exceptionHandler = CoroutineExceptionHandler { coroutineContext, throwable ->
        RxJavaPlugins.onError(throwable)
    }

    val looCLectures = MutableLiveData<List<LectureDetailItem>>()
    val departmentLectures = MutableLiveData<List<LectureDetailItem>>()
    val sportLectures = MutableLiveData<List<LectureDetailItem>>()
    val offlineLectures = MutableLiveData<List<LectureDetailItem>>()



    fun refresh() {
        fetchLectures()
    }


    private fun fetchLectures() {
        val retrofitInit = retrofit.create(RetrofitInterface::class.java)

        job1 = CoroutineScope(Dispatchers.IO + exceptionHandler).launch {
            val response1 = retrofitInit.getLoocLectures()
            withContext(Dispatchers.Main){
                if (response1.isSuccessful){
                    looCLectures.value = response1.body()
                }
            }


            val response2 = retrofitInit.getDepartmentLectures()
            withContext(Dispatchers.Main){
                if (response2.isSuccessful){
                    departmentLectures.value = response2.body()
                }
            }

            val response3 = retrofitInit.getSportLectures()
            withContext(Dispatchers.Main){
                if (response3.isSuccessful){
                    sportLectures.value = response3.body()
                }
            }

            val response4 = retrofitInit.getOfflineLectures()
            withContext(Dispatchers.Main){
                if (response4.isSuccessful){
                    offlineLectures.value = response4.body()
                }
            }

        }

       /* job2 = CoroutineScope(Dispatchers.IO + exceptionHandler).launch {
            val response2 = retrofit.create(RetrofitInterface::class.java).getDepartmentLectures()
            withContext(Dispatchers.Main){
                if (response2.isSuccessful){
                    departmentLectures.value = response2.body()
                }
            }

        }
        job3 = CoroutineScope(Dispatchers.IO + exceptionHandler).launch {
            val response3 = retrofit.create(RetrofitInterface::class.java).getSportLectures()
            withContext(Dispatchers.Main){
                if (response3.isSuccessful){
                    sportLectures.value = response3.body()
                }
            }
        }

        job4 = CoroutineScope(Dispatchers.IO + exceptionHandler).launch {

            val response4 = retrofit.create(RetrofitInterface::class.java).getOfflineLectures()
            withContext(Dispatchers.Main){
                if (response4.isSuccessful){
                    offlineLectures.value = response4.body()
                }
            }

        }*/



    }



}
